package com.govauction.controller;

import com.govauction.dao.LotDAO;
import com.govauction.dao.LotOrderDAO;
import com.govauction.dao.impl.AbstractDaoImpl;
import com.govauction.entity.Lot;
import com.govauction.entity.LotOrder;
import com.govauction.entity.LotOwner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: akuzin
 * Date: 30.10.13
 * To change this template use File | Settings | File Templates.
 */

public class AuctionServlet extends HttpServlet {

    AbstractDaoImpl<Lot> lotDAO = new LotDAO();
    AbstractDaoImpl<LotOrder> orderDAO = new LotOrderDAO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lotId = request.getParameter("lot");

        String url = request.getRequestURL().toString();

        if (url.contains("newlot")){
            List<Lot> lots = lotDAO.getAll();
            request.setAttribute("lots", lots);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/newLot.jsp");
            rd.forward(request, response);
            return;
        }

        if (lotId != null) {

            Lot lot = lotDAO.getById(Long.parseLong(lotId));
            request.setAttribute("lot", lot);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/lot.jsp");
            rd.forward(request, response);

        } else {

            List<Lot> lots = lotDAO.getAll();
            System.out.println("List of lots: "+lots);
            request.setAttribute("lots", lots);
            List<LotOrder> lotOrders = orderDAO.getAll();
            request.setAttribute("lotorders", lotOrders);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Lot lo;

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String summary = request.getParameter("summary");
        String body = request.getParameter("body");
        String category = request.getParameter("category");
        // Create new lot
        if (title != null && summary != null && body != null && category != null ){

            lo = lotDAO.getById(Long.parseLong(id));

            Lot lot = new Lot();
            if (lo != null) {
                lot.setLotId(Long.parseLong(id));
                lot.setDescription(summary);
                lot.setLotDate(new Date());

                LotOwner lotOwner = new LotOwner();
                lotOwner.setLotOwnerName(lotOwner.getLotOwnerName());
                lotOwner.setLotOwnerId(13L);
                lot.setLotOnwer(new LotOwner());
                lotDAO.edit(lot);
            }else{
                lotDAO.create(lot);
            }
        }
         response.sendRedirect("/lot");
    }
}
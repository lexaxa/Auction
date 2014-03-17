package com.govauction.dao;

import com.govauction.dao.impl.AbstractDaoImpl;
import com.govauction.entity.Lot;
import com.govauction.entity.LotOrder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: akuzin
 * Date: 28.06.13
 * Time: 11:47
 * To change this template use File | Settings | File Templates.
 */
public class LotOrderDAO extends AbstractDaoImpl<LotOrder> {

    @Override
    public void fillCreateStatement(PreparedStatement pstmt, LotOrder entity) {
        try {
            pstmt.setLong(1, entity.getLotOrderId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fillEditStatement(PreparedStatement pstmt, LotOrder entity) {
        try {
            pstmt.setLong(1, entity.getLotOrderId());
            pstmt.setInt(2, entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LotOrder getEntity(ResultSet resultSet) {
        try {
            LotOrder lotOrder = new LotOrder();
            lotOrder.setLotOrderId(resultSet.getLong("lotOrderId"));
            return lotOrder;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getCreateQuery() {
        return dbUtil.getQuery("create.lotorder");
    }

    @Override
    public String getDeleteQuery() {
        return dbUtil.getQuery("delete.lotorder");
    }

    @Override
    public String getEditQuery() {
        return dbUtil.getQuery("update.lotorder");
    }

    @Override
    public String getGetByIdQuery() {
        return dbUtil.getQuery("get.lotorder.by.id");
    }

    @Override
    public String getGetAllQuery() {
        return dbUtil.getQuery("get.all.lotorders");
    }
}

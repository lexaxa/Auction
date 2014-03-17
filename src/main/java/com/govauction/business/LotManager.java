package com.govauction.business;

import com.govauction.dao.LotDAO;
import com.govauction.entity.Lot;
import com.govauction.view.LotView;

public class LotManager {
    private LotDAO dao;
    
    public void addLot(LotView lv) {
        Lot l = createLotFromView(lv);
        dao.create(l);
    }
    
    private Lot createLotFromView(LotView lv) {
        Lot lot = null;
        if(lv.getLotId() !=null) {
            lot = dao.getById(lv.getLotId());
        } else {
            lot = new Lot();
        }
        lot.setDescription(lv.getDescription());
        lot.setLotDate(lv.getLotDate());
        
        return lot;
    }
}

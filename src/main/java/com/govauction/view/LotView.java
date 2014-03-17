package com.govauction.view;

import com.govauction.entity.Lot;

import java.util.Date;

public class LotView {

    private Long lotId;
    private String description;
    private LotOwnerView lotOnwer;
    private Date lotDate;
    //private List<LotOrder> lotOrders;

    public LotView() {
    }

    public LotView(Lot lot) {
        this.lotId = lot.getLotId();
        this.lotOnwer = new LotOwnerView(lot.getLotOnwer());
        this.description = lot.getDescription();
        this.lotDate = lot.getLotDate();
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LotOwnerView getLotOnwer() {
        return lotOnwer;
    }

    public void setLotOnwer(LotOwnerView lotOnwer) {
        this.lotOnwer = lotOnwer;
    }

    public Date getLotDate() {
        return lotDate;
    }

    public void setLotDate(Date lotDate) {
        this.lotDate = lotDate;
    }
}

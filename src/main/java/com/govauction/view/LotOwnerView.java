package com.govauction.view;

import com.govauction.entity.LotOwner;

public class LotOwnerView {

    private Long lotOwnerId;
    private String lotOwnerName;

    public LotOwnerView() {
    }

    public LotOwnerView(LotOwner lotOwner) {
        this.lotOwnerId = lotOwner.getLotOwnerId();
        this.lotOwnerName = lotOwner.getLotOwnerName();
    }

    public Long getLotOwnerId() {
        return lotOwnerId;
    }

    public void setLotOwnerId(Long lotOwnerId) {
        this.lotOwnerId = lotOwnerId;
    }

    public String getLotOwnerName() {
        return lotOwnerName;
    }

    public void setLotOwnerName(String lotOwnerName) {
        this.lotOwnerName = lotOwnerName;
    }
}

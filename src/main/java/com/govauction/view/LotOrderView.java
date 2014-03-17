package com.govauction.view;

import com.govauction.entity.LotOrder;
import com.govauction.entity.Participant;

public class LotOrderView {
    
    private Long lotOrderId;
    private Participant participant;
    
    public LotOrderView(){
        
    }
    
    public LotOrderView(LotOrder lotOrder){
        this.lotOrderId = lotOrder.getLotOrderId();
        this.participant = lotOrder.getParticipant();
    }

    public Long getLotOrderId() {
        return lotOrderId;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setLotOrderId(Long lotOrderId) {
        this.lotOrderId = lotOrderId;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}
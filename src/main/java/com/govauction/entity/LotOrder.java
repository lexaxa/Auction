package com.govauction.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="lot_orders")
public class LotOrder extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "order_id")
    private Long lotOrderId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_id")
    private Lot lot;

    public Long getLotOrderId() {
        return lotOrderId;
    }

    public void setLotOrderId(Long lotOrderId) {
        this.lotOrderId = lotOrderId;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
}

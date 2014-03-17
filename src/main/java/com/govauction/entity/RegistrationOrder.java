package com.govauction.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "registrations")
public class RegistrationOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long registrationOrderId;

    @Column(name = "name")
    private String name;

    public Long getRegistrationOrderId() {
        return registrationOrderId;
    }

    public void setRegistrationOrderId(Long registrationOrderId) {
        this.registrationOrderId = registrationOrderId;
    }
}

package com.retail.proj.flashsale.model;

import javax.persistence.*;

import com.retail.proj.flashsale.pojo.RegistrationStatus;

@Entity
@Table(name = "registrations")

public class FlashSaleRegistration {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flashsale_id",referencedColumnName = "id")
    private FlashSale flashSale;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer Customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_status")
    private RegistrationStatus registrationStatus;
}
package com.retail.proj.flashsale.model;


import javax.persistence.*;

@Entity
@Table(name = "flashsales")

public class FlashSale {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "pid", referencedColumnName = "id")
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;
   @Column(name ="unitsAvailable")
    private Integer unitsAvailable;
    
    @Column(name = "status")
    private Boolean status;

    @Column(name = "registration_open")
    private Boolean registrationOpen;
}
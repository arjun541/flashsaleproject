package com.retail.proj.flashsale.model;

import javax.persistence.Entity;

import com.retail.proj.flashsale.pojo.PurchaseOrderStatus;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "purchaseorders")

public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private Customer customer;

    @Column(name = "created_at", columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private PurchaseOrderStatus orderStatus;
}

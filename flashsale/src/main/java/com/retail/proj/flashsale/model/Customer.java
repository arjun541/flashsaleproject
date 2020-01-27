package com.retail.proj.flashsale.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")

public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @Column(name = "name")
    private String name;
}
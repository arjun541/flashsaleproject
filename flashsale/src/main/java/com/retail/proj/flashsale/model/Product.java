package com.retail.proj.flashsale.model;
import javax.persistence.*;

@Entity
@Table(name = "products")

public class Product {

    @Id

    
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "specialprice")
    private Integer specialPrice;
}
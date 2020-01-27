package com.retail.proj.flashsale.model;
import javax.persistence.*;

@Entity
@Table(name = "products")

public class Product {

    @Id

    
    @Column(name = "id")
    private Integer id;


	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getSpecialPrice() {
		return specialPrice;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setSpecialPrice(Integer specialPrice) {
		this.specialPrice = specialPrice;
	}

	@Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "specialprice")
    private Integer specialPrice;
}
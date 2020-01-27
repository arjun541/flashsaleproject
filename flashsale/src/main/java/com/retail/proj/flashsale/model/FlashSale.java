package com.retail.proj.flashsale.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flashsales")

public class FlashSale {

    @Id
   
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "pid", referencedColumnName = "id")
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    @JsonIgnore
    private Product product;
   public Integer getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public Integer getUnitsAvailable() {
		return unitsAvailable;
	}

	@Override
	public String toString() {
		return "FlashSale [id=" + id +",productName="+product.getName()+ ", unitsAvailable=" + unitsAvailable + ", status="
				+ status + ", registrationOpen=" + registrationOpen + "]";
	}

	public Boolean getStatus() {
		return status;
	}

	public Boolean getRegistrationOpen() {
		return registrationOpen;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setUnitsAvailable(Integer unitsAvailable) {
		this.unitsAvailable = unitsAvailable;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setRegistrationOpen(Boolean registrationOpen) {
		this.registrationOpen = registrationOpen;
	}

@Column(name ="unitsAvailable")
    private Integer unitsAvailable;
    
    @Column(name = "status")
    private Boolean status;

    @Column(name = "registration_open")
    private Boolean registrationOpen;
}
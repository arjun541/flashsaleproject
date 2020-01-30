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
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "flashsale_id")
    private FlashSale flashSale;

    @Column(name = "created_at", columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private PurchaseOrderStatus orderStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public PurchaseOrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(PurchaseOrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public FlashSale getFlashSale() {
		return flashSale;
	}

	public void setFlashSale(FlashSale flashSale) {
		this.flashSale = flashSale;
	}
    
}

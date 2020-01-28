package com.retail.proj.flashsale.model;

import javax.persistence.*;

import org.springframework.http.converter.json.GsonBuilderUtils;

import com.retail.proj.flashsale.pojo.RegistrationStatus;

@Entity
@Table(name = "registrations")

public class FlashSaleRegistration {

    @Id
    
   

    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flashsale_id",referencedColumnName = "id")
    private FlashSale flashSale;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer Customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_status")
    private RegistrationStatus registrationStatus;

	public String getId() {
		return id;
	}

	public FlashSale getFlashSale() {
		return flashSale;
	}

	public Customer getCustomer() {
		return Customer;
	}

	public RegistrationStatus getRegistrationStatus() {
		return registrationStatus;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFlashSale(FlashSale flashSale) {
		this.flashSale = flashSale;
	}

	public void setCustomer(Customer customer) {
		Customer = customer;
	}

	public void setRegistrationStatus(RegistrationStatus registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

	public void setRegistrationStatus(
			com.zaxxer.hikari.metrics.prometheus.PrometheusMetricsTrackerFactory.RegistrationStatus registered) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "FlashSaleRegistration [id=" + id + ", flashSale=" + flashSale + ", Customer=" + Customer
				+ ", registrationStatus=" + registrationStatus + "]";
		
	
	}
    
}
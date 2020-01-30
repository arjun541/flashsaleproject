package com.retail.proj.flashsale.pojo;

import javax.validation.constraints.NotNull;



public class RegistrationRequest {
	@NotNull(message = "Customer Id  has to be present")
	private Integer customerId;
    @NotNull (message = "flash sale Id  has to be present")
	private Integer flashSaleId;
	
	public RegistrationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistrationRequest(Integer customerId, Integer flashSaleId) {
		super();
		this.customerId = customerId;
		this.flashSaleId = flashSaleId;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getFlashSaleId() {
		return flashSaleId;
	}
	public void setFlashSaleId(Integer flashSaleId) {
		this.flashSaleId = flashSaleId;
	}


}

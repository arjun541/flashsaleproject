package com.retail.proj.flashsale.service;

import java.util.List;

import com.retail.proj.flashsale.model.Customer;
import com.retail.proj.flashsale.model.FlashSale;
import com.retail.proj.flashsale.model.FlashSaleRegistration;
import com.retail.proj.flashsale.model.PurchaseOrder;
import com.retail.proj.flashsale.pojo.FlashSaleRegistrationResult;

public interface FlashSaleSerice {
	
	public String serviceMethod();

	List<FlashSale> getFlashSales();



	//FlashSaleRegistration registerForSale(Integer integer, FlashSale f);

	FlashSaleRegistrationResult registerForSale(Integer c, Integer f);

	public PurchaseOrder purchaseFromSale(Integer customerId, Integer flashSaleId);

}

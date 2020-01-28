package com.retail.proj.flashsale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.retail.proj.flashsale.model.FlashSale;
import com.retail.proj.flashsale.model.FlashSaleRegistration;
import com.retail.proj.flashsale.pojo.FlashSaleRegistrationResult;
import com.retail.proj.flashsale.pojo.RegistrationRequest;
import com.retail.proj.flashsale.service.FlashSaleSerice;

@RestController
public class FlashSaleController {

	@Autowired
	FlashSaleSerice flashsaleserviceimpl;
	
	
	

	@GetMapping(path="/flashsales")
	public List<FlashSale> getFlashSaleDetails()
	{
		return flashsaleserviceimpl.getFlashSales();
	}
	
	@PostMapping(path="/register")
	
	public FlashSaleRegistrationResult registerForSale(@RequestBody RegistrationRequest fr)
	{
	
		FlashSaleRegistrationResult fg1=flashsaleserviceimpl.registerForSale(fr.getCustomerId(),fr.getFlashSaleId());
		
		
		return fg1;
		
	}
}

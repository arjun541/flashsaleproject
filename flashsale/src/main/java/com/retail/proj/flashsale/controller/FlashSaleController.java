

package com.retail.proj.flashsale.controller;
/*
 * 
 * 
 * @Author- Mallikarjuna Reddy Bachu
 * 
 * purpose- FlashSaleController is the controller for handling the sale Registration and sale purchase services
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.retail.proj.flashsale.exceptionhandlers.InvalidRequestException;
import com.retail.proj.flashsale.model.FlashSale;
import com.retail.proj.flashsale.model.FlashSaleRegistration;
import com.retail.proj.flashsale.model.PurchaseOrder;
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
	
	public ResponseEntity<Object> registerForSale(@RequestBody RegistrationRequest fr)
	{
	
		FlashSaleRegistrationResult fg1=flashsaleserviceimpl.registerForSale(fr.getCustomerId(),fr.getFlashSaleId());
		if(fg1.getMessage().equalsIgnoreCase("Successfully registered"))
			return ResponseEntity.accepted().body(fg1);
		else if(fg1.getMessage().equalsIgnoreCase("Already Registered!!"))
			return ResponseEntity.status(HttpStatus.CONFLICT).body(fg1);
					
		return ResponseEntity.badRequest().body(fg1);
		
	}
	
@PostMapping(path="/purchase")
	
	public ResponseEntity<Object> purchase(@Validated @RequestBody RegistrationRequest fr)
	{
	
		PurchaseOrder fg1=flashsaleserviceimpl.purchaseFromSale(fr.getCustomerId(),fr.getFlashSaleId());
		
		
		return ResponseEntity.accepted().body(fg1);
		
	}
}

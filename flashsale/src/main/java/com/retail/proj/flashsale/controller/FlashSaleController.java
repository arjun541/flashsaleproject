package com.retail.proj.flashsale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.proj.flashsale.model.FlashSale;
import com.retail.proj.flashsale.service.FlashSaleSerice;

@RestController
public class FlashSaleController {

	@Autowired
	FlashSaleSerice flashsaleserviceimpl;
	
	@GetMapping(path="/test")
	
	public String test() {
		return flashsaleserviceimpl.serviceMethod();
	}
	

	@GetMapping(path="/flashsales")
	public List<FlashSale> getFlashSaleDetails()
	{
		return flashsaleserviceimpl.getFlashSales();
	}
}

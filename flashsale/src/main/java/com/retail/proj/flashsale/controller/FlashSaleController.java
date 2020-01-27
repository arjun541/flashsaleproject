package com.retail.proj.flashsale.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlashSaleController {

	
	@GetMapping(path="/test")
	
	public String test() {
		return "hello world";
	}
}

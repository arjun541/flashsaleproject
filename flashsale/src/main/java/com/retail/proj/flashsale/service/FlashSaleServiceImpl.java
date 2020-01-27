package com.retail.proj.flashsale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.retail.proj.flashsale.model.FlashSale;
import com.retail.proj.flashsale.repository.FlashSaleRepository;

@Component
public class FlashSaleServiceImpl  implements FlashSaleSerice{

	@Autowired
	FlashSaleRepository flashSalerepo;
	@Override
	public String serviceMethod() {
		// TODO Auto-generated method stub
		return "hello";
	}
	@Override
	public List<FlashSale> getFlashSales()
	{
	
		return  flashSalerepo.findAll();
	}

}

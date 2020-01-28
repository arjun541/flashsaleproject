package com.retail.proj.flashsale.repository;


import java.util.List;

import org.hibernate.annotations.OptimisticLock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.retail.proj.flashsale.model.FlashSale;
public interface FlashSaleRepository  extends JpaRepository<FlashSale, Integer>{


	
	 
}

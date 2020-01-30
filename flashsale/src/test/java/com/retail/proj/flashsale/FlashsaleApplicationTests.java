package com.retail.proj.flashsale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.retail.proj.flashsale.model.PurchaseOrder;
import com.retail.proj.flashsale.pojo.FlashSaleRegistrationResult;
import com.retail.proj.flashsale.pojo.PurchaseResult;
import com.retail.proj.flashsale.repository.FlashSaleRepository;
import com.retail.proj.flashsale.repository.OrderRepository;
import com.retail.proj.flashsale.repository.RegistrationRepository;
import com.retail.proj.flashsale.service.FlashSaleSerice;

@SpringBootTest
@Transactional
class FlashsaleApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	FlashSaleSerice fs;
	@Autowired
	RegistrationRepository reg;
	@Autowired 
	FlashSaleRepository fr;
	@Autowired
	OrderRepository or;
	
	  @Test
	    public void registerFlashSale_whenSave_thenGetOk() {
	   
		  
		  fs.registerForSale(1, 1);
		   assertTrue(reg.getOne("1-1").getFlashSale().getId()==1);
	         
	        
	    }
	  @Test
	    public void purchaseproduct_whenRegistered_thenGetOk() {
	   
		  fs.registerForSale(1, 3);
		 PurchaseResult po= fs.purchaseFromSale(1, 3);
		 assertTrue(po.getStatus());
		  
	         
	        
	    }
	  @Test
	    public void purchaseproduct_whenNotRegistered_thenGetNotOk() {
	   
		  
		  PurchaseResult po= fs.purchaseFromSale(4, 3);
		 assertFalse(po.getStatus());
	         
	        
	    }

	  @Test
	    public void register_whenSaleIsRegNotOpen_thenGetNotOk() {
	   
		  
		 FlashSaleRegistrationResult fr=fs.registerForSale(4, 2);
		 assertFalse(fr.getStatus());
	         
	        
	    }

}

package com.retail.proj.flashsale.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retail.proj.flashsale.model.PurchaseOrder;

public interface OrderRepository extends JpaRepository<PurchaseOrder,String>{

	

	 @Query(value = "select * from purchaseorders where customer_id=?1 and product_id=?2 and flashsale_id=?3", nativeQuery = true)
	 ArrayList<PurchaseOrder> findPurchaseOrderExists(int customerId,int productId, Integer integer);
	
}

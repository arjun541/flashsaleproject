package com.retail.proj.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.proj.flashsale.model.PurchaseOrder;

public interface OrderRepository extends JpaRepository<PurchaseOrder,String>{

}

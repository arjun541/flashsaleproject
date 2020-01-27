package com.retail.proj.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.proj.flashsale.model.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{

}

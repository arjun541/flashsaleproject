package com.retail.proj.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.retail.proj.flashsale.model.FlashSaleRegistration;

public interface RegistrationRepository extends JpaRepository<FlashSaleRegistration, String> , JpaSpecificationExecutor<FlashSaleRegistration>{

}

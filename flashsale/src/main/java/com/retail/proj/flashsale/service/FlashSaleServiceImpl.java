package com.retail.proj.flashsale.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.retail.proj.flashsale.model.Customer;
import com.retail.proj.flashsale.model.FlashSale;
import com.retail.proj.flashsale.model.FlashSaleRegistration;
import com.retail.proj.flashsale.model.PurchaseOrder;
import com.retail.proj.flashsale.pojo.FlashSaleRegistrationResult;
import com.retail.proj.flashsale.repository.CustomerRepository;
import com.retail.proj.flashsale.repository.FlashSaleRepository;
import com.retail.proj.flashsale.repository.RegistrationRepository;
import com.zaxxer.hikari.metrics.prometheus.PrometheusMetricsTrackerFactory.RegistrationStatus;

@Component
public class FlashSaleServiceImpl  implements FlashSaleSerice{

	@Autowired
	FlashSaleRepository flashSalerepo;
	@Autowired
	CustomerRepository customerrepo;
	@Autowired
	RegistrationRepository registrationrepo;


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
	@Override

	public FlashSaleRegistrationResult registerForSale(Integer c,Integer f) {
		// TODO Auto-generated method stub

		FlashSaleRegistrationResult regresult=new FlashSaleRegistrationResult();
		FlashSaleRegistration fr=new FlashSaleRegistration();
		regresult.setStatus(false);
		Optional<Customer> oc=customerrepo.findById(c);

		Optional<FlashSale> of=flashSalerepo.findById(f);
		if(!oc.isPresent())
		{

			regresult.setMessage(" Invalid customer");
		}


		else if(!of.isPresent())
		{
			regresult.setMessage("Invalid Sale");

		}

		else if(!of.get().getRegistrationOpen())
		{
			regresult.setMessage("Registartion Closed for Sale");
		}
		else
		{
			fr.setCustomer(oc.get());
			fr.setFlashSale(of.get());
			fr.setId(oc.get().getId()+"-"+of.get().getId());
			Optional<FlashSaleRegistration> fg=registrationrepo.findById(oc.get().getId()+"-"+of.get().getId());

			regresult.setRegistrationId(oc.get().getId()+"-"+of.get().getId());
			if(fg.isPresent())
			{
				regresult.setStatus(true);
				regresult.setMessage("ALready Registered!!");

			}
			else
			{
				fr.setRegistrationStatus(com.retail.proj.flashsale.pojo.RegistrationStatus.REGISTERED);
				fr=registrationrepo.saveAndFlush(fr);
				regresult.setStatus(true);
				regresult.setMessage("Successfully registered");

			}

		}


		return regresult;
	}
	@Override
	@Transactional
	public PurchaseOrder purchaseFromSale(Integer customerId, Integer flashSaleId) {
		// TODO Auto-generated method stub
		Optional<FlashSaleRegistration> osr=registrationrepo.findById(customerId+"-"+flashSaleId);
		FlashSale fs=null;
		int itemsAvailable;
		if(osr.isPresent())
		{
			if(osr.get().getRegistrationStatus().equals(com.retail.proj.flashsale.pojo.RegistrationStatus.REGISTERED))
			{

				fs=osr.get().getFlashSale();
				if(fs.getStatus())
				{
				itemsAvailable=fs.getUnitsAvailable()-1;
				System.out.println("items available----------"+itemsAvailable);

				if(itemsAvailable>=0)
				fs.setUnitsAvailable(itemsAvailable);
				else
					fs.setStatus(false);
				
				flashSalerepo.saveAndFlush(fs);
				}

			}


		}
		return null;

	}
}
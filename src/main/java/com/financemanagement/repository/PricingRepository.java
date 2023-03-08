package com.financemanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.financemanagement.model.Pricing;

public interface PricingRepository extends CrudRepository<Pricing,Long>{
	Iterable<Pricing> findByDescription(String description);
}

package com.financemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financemanagement.model.Pricing;
import com.financemanagement.repository.PricingRepository;

@Service
public class PricingService {

	@Autowired
	PricingRepository pricingRepository;

	public boolean createPricing(Pricing pricing) {

		if (pricing != null) {
			pricingRepository.save(pricing);
			return true;
		}
		return false;
	}

	public void deletePricing(Long id) throws Exception {
		Pricing deletePricing = pricingRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find an Pricing with this ID: " + id));
		pricingRepository.delete(deletePricing);
	}

	public Pricing updatePricing(Long id, Pricing pricing) throws Exception {
		Pricing updatedPricing = pricingRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Pricing with this ID: " + id));
		updatedPricing.setDescription(pricing.getDescription());
		updatedPricing.setPrice(pricing.getPrice());
		pricingRepository.save(updatedPricing);
		return updatedPricing;

	}

	public Iterable<Pricing> listPricings() {
		Iterable<Pricing> listPricings = pricingRepository.findAll();
		return listPricings;
	}

	public Iterable<Pricing> findByName(String description) {
		Iterable<Pricing> pricings = pricingRepository.findByDescription(description);
		return pricings;
	}

	public Pricing findById(Long id) throws Exception {
		Pricing pricing = pricingRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find an Pricing with this ID: " + id));
		return pricing;
	}

}
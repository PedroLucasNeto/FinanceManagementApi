package com.financemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financemanagement.model.Pricing;
import com.financemanagement.service.PricingService;

@RestController
@RequestMapping("/pricing")
public class PricingController {

	@Autowired
	PricingService pricingService;

	@PostMapping
	ResponseEntity<Pricing> createPricing(@RequestBody Pricing pricing) {
		boolean success = pricingService.createPricing(pricing);
		if (success) {
			return new ResponseEntity<Pricing>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Pricing>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping 
	ResponseEntity<Pricing> deletePricing(@PathVariable Long id) throws Exception {
		pricingService.deletePricing(id);
			return new ResponseEntity<Pricing>(HttpStatus.OK);
	}

	@PutMapping("/{id}") 
	ResponseEntity<Pricing> updatePricing(@PathVariable Long id, @RequestBody Pricing pricing) throws Exception {
		pricingService.updatePricing(id, pricing);
		return new ResponseEntity<Pricing>(HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity <Iterable<Pricing>> listPricings(){
		Iterable<Pricing> listPricings = pricingService.listPricings();
		return new ResponseEntity<Iterable<Pricing>>(listPricings, HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	ResponseEntity<Iterable<Pricing>> getPricingByName(@PathVariable String name){
		List<Pricing> pricings = (List<Pricing>) pricingService.findByName(name);
		if (pricings.isEmpty()) {
			return new ResponseEntity<Iterable<Pricing>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Pricing>>(pricings, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	ResponseEntity<Pricing> getPricingById(@PathVariable Long id) throws Exception{
		Pricing pricing = pricingService.findById(id);
		if (pricing.equals(null)) {
			return new ResponseEntity<Pricing>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pricing>(pricing, HttpStatus.OK);
	}
}
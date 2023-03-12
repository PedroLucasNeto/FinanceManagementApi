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

import com.financemanagement.model.Budget;
import com.financemanagement.service.BudgetService;

@RestController
@RequestMapping("/budget")
public class BudgetController {

	@Autowired
	BudgetService budgetService;

	@PostMapping
	ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
		boolean success = budgetService.createBudget(budget);
		if (success) {
			return new ResponseEntity<Budget>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Budget>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping 
	ResponseEntity<Budget> deleteBudget(@PathVariable Long id) throws Exception {
		budgetService.deleteBudget(id);
			return new ResponseEntity<Budget>(HttpStatus.OK);
	}

	@PutMapping("/{id}") 
	ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget budget) throws Exception {
		budgetService.updateBudget(id, budget);
		return new ResponseEntity<Budget>(HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity <Iterable<Budget>> listBudgets(){
		Iterable<Budget> listBudgets = budgetService.listBudgets();
		return new ResponseEntity<Iterable<Budget>>(listBudgets, HttpStatus.OK);
	}
	
	@GetMapping("/{clientName}")
	ResponseEntity<Iterable<Budget>> getBudgetByClientName(@PathVariable String clientName){
		List<Budget> budgets = (List<Budget>) budgetService.findByClientName(clientName);
		if (budgets.isEmpty()) {
			return new ResponseEntity<Iterable<Budget>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Budget>>(budgets, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	ResponseEntity<Budget> getBudgetById(@PathVariable Long id) throws Exception{
		Budget budget = budgetService.findById(id);
		if (budget.equals(null)) {
			return new ResponseEntity<Budget>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Budget>(budget, HttpStatus.OK);
	}
}

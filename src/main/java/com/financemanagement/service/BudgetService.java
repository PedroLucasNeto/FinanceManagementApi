package com.financemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financemanagement.model.Budget;
import com.financemanagement.repository.BudgetRepository;

@Service
public class BudgetService {
	
	@Autowired
	BudgetRepository budgetRepository;

	public boolean createBudget(Budget budget) {

		if (budget != null) {
			budgetRepository.save(budget);
			return true;
		}
		return false;
	}

	public void deleteBudget(Long id) throws Exception {
		Budget deleteBudget = budgetRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Budget with this ID: " + id));
		budgetRepository.delete(deleteBudget);
	}

	public Budget updateBudget(Long id, Budget budget) throws Exception {
		Budget updatedBudget = budgetRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Budget with this ID: " + id));
		updatedBudget.setClientName(budget.getClientName());
		updatedBudget.setClientPhone(budget.getClientPhone());
		updatedBudget.setBudgetDate(budget.getBudgetDate());
		updatedBudget.setContactDate(budget.getContactDate());
		updatedBudget.setPhotoShootPlan(budget.getPhotoShootPlan());
		updatedBudget.setPhotoShootType(budget.getPhotoShootType());

		budgetRepository.save(updatedBudget);
		return updatedBudget;
	}

	public Iterable<Budget> listBudgets() {
		Iterable<Budget> listBudgets = budgetRepository.findAll();
		return listBudgets;
	}

	public Iterable<Budget> findByClientName(String clientName) {
		Iterable<Budget> budgets = budgetRepository.findByClientName();
		return budgets;
	}

	public Budget findById(Long id) throws Exception {
		Budget budget = budgetRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Budget with this ID: " + id));
		return budget;
	}
	

}

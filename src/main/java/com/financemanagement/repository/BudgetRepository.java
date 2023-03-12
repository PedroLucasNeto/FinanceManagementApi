package com.financemanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.financemanagement.model.Budget;

public interface BudgetRepository extends CrudRepository<Budget, Long>{

	Iterable<Budget> findByClientName();

}

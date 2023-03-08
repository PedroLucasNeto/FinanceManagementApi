package com.financemanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.financemanagement.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	Iterable<Product> findByDescription(String description);

}

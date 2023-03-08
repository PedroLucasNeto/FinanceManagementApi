package com.financemanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.financemanagement.model.User;


public interface UserRepository extends CrudRepository<User, Long>{
	
	Iterable<User> findByName(String name);

	User findByEmail(String email);

}

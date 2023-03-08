package com.financemanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.financemanagement.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	Iterable<Client> findByFullname(String fullname);
}

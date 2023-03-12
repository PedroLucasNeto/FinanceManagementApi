package com.financemanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.financemanagement.model.Entry;

public interface EntryRepository extends CrudRepository<Entry, Long> {
	
	Iterable<Entry> findByClientName();

}

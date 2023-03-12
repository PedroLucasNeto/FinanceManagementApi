package com.financemanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.financemanagement.model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long>  {

	Iterable<Appointment> findByClientName();

}

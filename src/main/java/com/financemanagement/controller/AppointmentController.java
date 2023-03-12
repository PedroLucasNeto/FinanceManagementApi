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

import com.financemanagement.model.Appointment;
import com.financemanagement.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@PostMapping
	ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
		boolean success = appointmentService.createAppointment(appointment);
		if (success) {
			return new ResponseEntity<Appointment>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Appointment>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping 
	ResponseEntity<Appointment> deleteAppointment(@PathVariable Long id) throws Exception {
		appointmentService.deleteAppointment(id);
			return new ResponseEntity<Appointment>(HttpStatus.OK);
	}

	@PutMapping("/{id}") 
	ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) throws Exception {
		appointmentService.updateAppointment(id, appointment);
		return new ResponseEntity<Appointment>(HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity <Iterable<Appointment>> listAppointments(){
		Iterable<Appointment> listAppointments = appointmentService.listAppointments();
		return new ResponseEntity<Iterable<Appointment>>(listAppointments, HttpStatus.OK);
	}
	
	@GetMapping("/{clientName}")
	ResponseEntity<Iterable<Appointment>> getAppointmentByClientName(@PathVariable String clientName){
		List<Appointment> appointments = (List<Appointment>) appointmentService.findByClientName(clientName);
		if (appointments.isEmpty()) {
			return new ResponseEntity<Iterable<Appointment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Appointment>>(appointments, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) throws Exception{
		Appointment appointment = appointmentService.findById(id);
		if (appointment.equals(null)) {
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}
}
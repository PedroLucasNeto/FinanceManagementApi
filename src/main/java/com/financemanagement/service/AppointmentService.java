package com.financemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financemanagement.model.Appointment;
import com.financemanagement.repository.AppointmentRepository;

@Service
public class AppointmentService {


	@Autowired
	AppointmentRepository appointmentRepository;

	public boolean createAppointment(Appointment appointment) {

		if (appointment != null) {
			appointmentRepository.save(appointment);
			return true;
		}
		return false;
	}

	public void deleteAppointment(Long id) throws Exception {
		Appointment deleteAppointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Appointment with this ID: " + id));
		appointmentRepository.delete(deleteAppointment);
	}

	public Appointment updateAppointment(Long id, Appointment appointment) throws Exception {
		Appointment updatedAppointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Appointment with this ID: " + id));
		updatedAppointment.setClient(appointment.getClient());
		updatedAppointment.setDeliveryDate(appointment.getDeliveryDate());
		updatedAppointment.setExtraPhoto(appointment.getExtraPhoto());
		updatedAppointment.setPaidAppointment(appointment.isPaidAppointment());
		updatedAppointment.setPaidExtra(appointment.isPaidExtra());
		updatedAppointment.setPaidProduct(appointment.isPaidProduct());
		updatedAppointment.setPaidRemainder(appointment.isPaidRemainder());
		updatedAppointment.setAppointmentDate(appointment.getAppointmentDate());
		updatedAppointment.setContactDate(appointment.getContactDate());
		updatedAppointment.setPhotoShootPlan(appointment.getPhotoShootPlan());
		updatedAppointment.setPhotoShootType(appointment.getPhotoShootType());
		appointmentRepository.save(updatedAppointment);
		return updatedAppointment;
	}

	public Iterable<Appointment> listAppointments() {
		Iterable<Appointment> listAppointments = appointmentRepository.findAll();
		return listAppointments;
	}

	public Iterable<Appointment> findByClientName(String clientName) {
		Iterable<Appointment> appointments = appointmentRepository.findByClientName();
		return appointments;
	}

	public Appointment findById(Long id) throws Exception {
		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Appointment with this ID: " + id));
		return appointment;
	}
	
}

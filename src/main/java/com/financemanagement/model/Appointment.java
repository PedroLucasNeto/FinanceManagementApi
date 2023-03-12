package com.financemanagement.model;

import java.util.Date;

import com.financemanagement.enums.PhotoShootPlan;
import com.financemanagement.enums.PhotoShootType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_appointment")
public class Appointment {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Client client;
	
	@Column
	private PhotoShootPlan photoShootPlan;

	@Column
	private PhotoShootType photoShootType;
	
	@Column
	private int extraPhoto;
	
	@Column
	private Product product;
	
	@Column
	private String deliveryDate;

	@Column
	private Date contactDate;
	
	@Column
	private Date appointmentDate;

	@Column
	private Date photoShootDate;
	
	@Column
	private boolean paidAppointment;
	
	@Column
	private boolean paidRemainder;
	
	@Column
	private boolean paidExtra;
	
	@Column
	private boolean paidProduct;

}

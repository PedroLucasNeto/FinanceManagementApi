package com.financemanagement.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_client")
public class Client {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String fullname;
	
	@Column
	private Date dateOfBirth;
	
	@Column
	private String phone;
	
	@Column
	private String instagram;
	
	@Column
	private String email;
	
	@Column
	private String profession;
	
	@Column
	private String observation;
	
}

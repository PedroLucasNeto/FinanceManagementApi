package com.financemanagement.model;

import java.util.Date;

import com.financemanagement.enums.EntryType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_entry")
public class Entry {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Date entryDate;
	
	@Column
	private Date paymentDate;
	
	@Column
	private String description;
	
	@Column
	private EntryType entryType;
	
	@Column
	private double price;
	
	@Column
	private Client client;
}

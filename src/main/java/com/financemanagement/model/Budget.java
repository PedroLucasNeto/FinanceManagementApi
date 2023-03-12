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
@Table(name = "tb_budget")
public class Budget {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String clientName;
	
	@Column
	private String clientPhone;
	
	@Column
	private Date budgetDate;
	
	@Column(nullable = false)
	private Date contactDate;
	
	@Column
	private PhotoShootType photoShootType;
	
	@Column
	private PhotoShootPlan photoShootPlan;

	@Column
	private Product product;
}

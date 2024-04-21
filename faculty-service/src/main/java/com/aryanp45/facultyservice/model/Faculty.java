package com.aryanp45.facultyservice.model;

import java.math.BigDecimal;

import com.aryanp45.facultyservice.enums.Department;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long facultyId;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private BigDecimal salary;
	private Department departmentName;
}

package com.aryanp45.facultyservice.dto;

import java.math.BigDecimal;

import com.aryanp45.facultyservice.enums.Department;

import lombok.Data;

@Data
public class FacultyDto {
	private Long facultyId;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private BigDecimal salary;
	private Department departmentName;
}

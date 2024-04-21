package com.aryanp45.studentservice.dto;

import com.aryanp45.studentservice.enums.Department;
import com.aryanp45.studentservice.enums.EnrollmentStatus;

import lombok.Data;

@Data
public class StudentDto {
	private Long prn;
	private String name;
	private String email;
	private String address;
	private String phoneNumber;
	private EnrollmentStatus enrollmentStatus;
	private Department departmentName;
}

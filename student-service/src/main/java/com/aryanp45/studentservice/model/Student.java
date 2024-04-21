package com.aryanp45.studentservice.model;

import com.aryanp45.studentservice.enums.Department;
import com.aryanp45.studentservice.enums.EnrollmentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long prn;
	private String name;
	private String email;
	private String address;
	private String phoneNumber;
	private EnrollmentStatus enrollmentStatus;
	private Department departmentName;
}

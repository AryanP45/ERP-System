package com.aryanp45.courseservice.model;

import java.math.BigDecimal;

import com.aryanp45.courseservice.enums.Department;
import com.aryanp45.courseservice.enums.Semester;

import jakarta.persistence.Column;
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
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Department department;
	
	private Long intake;
	
	private Long marks;
	
	private  Semester semester;
	
	@Column(unique=true)
	private String courseCode;
}

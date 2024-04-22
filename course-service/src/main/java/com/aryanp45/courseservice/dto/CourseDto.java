package com.aryanp45.courseservice.dto;

import com.aryanp45.courseservice.enums.Department;
import com.aryanp45.courseservice.enums.Semester;

import lombok.Data;

@Data
public class CourseDto {
	
	private String name;

	private Department department;
	
	private Long intake;
	
	private Long marks;
	
	private  Semester semester;
	
	private String courseCode;
	
}

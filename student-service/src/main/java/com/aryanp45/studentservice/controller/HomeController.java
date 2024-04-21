package com.aryanp45.studentservice.controller;

import org.springframework.core.style.StylerUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryanp45.studentservice.dto.StudentDto;
import com.aryanp45.studentservice.enums.Department;
import com.aryanp45.studentservice.service.StudentService;
import com.aryanp45.studentservice.service.StudentServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class HomeController {
	
	private final StudentServiceImpl studentService;
	/*
	### Student Service
		1. **View Profile**
		    - `GET /api/students/me`
		2. **View Study Material**
		    - `GET /api/students/study-materials`
		    - `GET /api/students/study-materials/{materialId}`
		3. **View Staff**
		    - `GET /api/students/staff`
	*/
	
	// ID means PRN number in student
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentInfoFromId(@PathVariable Long id){
		return ResponseEntity.ok(studentService.getStudentInfoFromId(id));
	}
	
	
}

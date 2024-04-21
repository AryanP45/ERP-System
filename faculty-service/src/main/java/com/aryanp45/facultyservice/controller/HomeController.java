package com.aryanp45.facultyservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryanp45.facultyservice.dto.FacultyDto;
import com.aryanp45.facultyservice.service.FacultyService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/faculty")
@RequiredArgsConstructor
public class HomeController {
	private final FacultyService facultyService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFacultyById(@PathVariable Long id){
		return ResponseEntity.ok(facultyService.getFacultyById(id));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addFaculty(@RequestBody FacultyDto facultyDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.addFaculty(facultyDto));
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllFaculty(){
		return ResponseEntity.ok(facultyService.getAllFaculty());
	}
}

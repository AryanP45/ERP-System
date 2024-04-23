package com.aryanp45.facultyservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class FacultyController {
	private final FacultyService facultyService;

	@GetMapping("/{facultyId}")
	public ResponseEntity<?> getFacultyByFacultyId(@PathVariable Long facultyId) {
		return ResponseEntity.ok(facultyService.getFacultyByFacultyId(facultyId));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllFaculty() {
		return ResponseEntity.ok(facultyService.getAllFaculty());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addFaculty(@RequestBody FacultyDto facultyDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.addFaculty(facultyDto));
	}

	@DeleteMapping("/delete/{facultyId}")
	public ResponseEntity<?> deleteByFacultyId(@PathVariable Long facultyId) {
		return ResponseEntity.ok(facultyService.deleteByFacultyId(facultyId));
	}
	
	// update faculty details
}

package com.aryanp45.courseservice.controller;

import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryanp45.courseservice.dto.CourseDto;
import com.aryanp45.courseservice.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {
	private final CourseService courseService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllCourses(){
		return ResponseEntity.ok(courseService.getAllCourses());
	}
	
}

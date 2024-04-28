package com.aryanp45.courseservice.controller;

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
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable Long id){
		return ResponseEntity.ok(courseService.getCourseById(id));
	}
	
	@GetMapping("/code/{courseCode}")
	public ResponseEntity<?> getCourseByCourseCode(@PathVariable String courseCode){
		return ResponseEntity.ok(courseService.getCourseByCourseCode(courseCode));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(courseDto));
	}
	
	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<?> deleteCourseById(@PathVariable Long id){
		return ResponseEntity.ok(courseService.deleteCourseById(id));
	}
	
	@DeleteMapping("/delete/code/{courseCode}")
	public ResponseEntity<?> deleteByCourseCode(@PathVariable String courseCode){
		return ResponseEntity.ok(courseService.deleteByCourseCode(courseCode));
	}
}

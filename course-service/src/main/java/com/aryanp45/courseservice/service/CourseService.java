package com.aryanp45.courseservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aryanp45.courseservice.dto.CourseDto;
import com.aryanp45.courseservice.model.Course;
import com.aryanp45.courseservice.repository.CourseRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CourseService {
	private final CourseRepository courseRepository;
	
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	public Course getCourseById(Long id) {
		Optional<Course> course = courseRepository.findById(id);
		if(course.isPresent()) return course.get();
		else return new Course();
	}
	
	public Course getCourseByCourseCode(String courseCode) {
		Optional<Course> course = courseRepository.findByCourseCode(courseCode);
		if(course.isPresent()) return course.get();
		else {
			log.info("course is not present. ( incorrect proper courseCode ) ");			
			return new Course();
		}
	}
	
}

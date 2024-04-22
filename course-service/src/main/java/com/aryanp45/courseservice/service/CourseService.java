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
	
	public Course addCourse(CourseDto courseDto) {
		
		Optional<Course> courseOptional = courseRepository.findByCourseCode(courseDto.getCourseCode());	// courseCode is unique
		log.info("Course already present (cannot add course with same code)");
		if(courseOptional.isPresent()) return new Course();
		
		Course course= Course.builder()
				.name(courseDto.getName())
				.department(courseDto.getDepartment())
				.intake(courseDto.getIntake())
				.marks(courseDto.getMarks())
				.semester(courseDto.getSemester())
				.courseCode(courseDto.getCourseCode())
				.build();
		return courseRepository.save(course);
	}
	
	public Course deleteCourseById(Long id) {
		Optional<Course> course = courseRepository.findById(id);
		if(course.isPresent()) {
			courseRepository.deleteById(id);
			return course.get();
		}else {
			log.info("course not found to delete");
			return null;
		}
	}
	
}

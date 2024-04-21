package com.aryanp45.studentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aryanp45.studentservice.dto.StudentDto;
import com.aryanp45.studentservice.model.Student;
import com.aryanp45.studentservice.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl{
	private final StudentRepository studentRepository;
	
	 public Student getStudentInfoFromId(Long id) {
		Optional<Student> student= studentRepository.findByPrn(id);
		if(student.isPresent()) return student.get();
		else return new Student();
	}
	
}
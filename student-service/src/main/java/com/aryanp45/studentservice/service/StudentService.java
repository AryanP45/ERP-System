package com.aryanp45.studentservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aryanp45.studentservice.model.Student;

@Service
public interface StudentService {
	Optional<Student> getStudentInfoFromId(Long id);
}

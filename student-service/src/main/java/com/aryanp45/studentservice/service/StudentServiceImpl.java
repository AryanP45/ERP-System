package com.aryanp45.studentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aryanp45.studentservice.dto.StudentDto;
import com.aryanp45.studentservice.model.Student;
import com.aryanp45.studentservice.repository.StudentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class StudentServiceImpl{
	private final StudentRepository studentRepository;
	
	 public Student getStudentInfoFromPrn(Long prn) {
		Optional<Student> student= studentRepository.findByPrn(prn);
		if(student.isPresent()) return student.get();
		else return new Student();
	}
	
	 public Student addStudent(StudentDto studentDto) {
		 Optional<Student> studentOptional = studentRepository.findByPrn(studentDto.getPrn());
		 if(studentOptional.isPresent()) {
			 log.info("Duplicate Prn number (already registered prn) ");
			 return new Student();
		 }
		 Student student = Student.builder()
				 		.prn(studentDto.getPrn())
				 		.name(studentDto.getName())
				 		.email(studentDto.getEmail())
				 		.address(studentDto.getAddress())
				 		.phoneNumber(studentDto.getPhoneNumber())
				 		.enrollmentStatus(studentDto.getEnrollmentStatus())
				 		.departmentName(studentDto.getDepartmentName())
				 		.build();
		return studentRepository.save(student);
	 }
	
	 public List<Student> getAllStudents(){
		 return studentRepository.findAll();
	 }
	 
	 public Student deleteStudentByPrn(Long prn) {
		 Optional<Student> studentOptional = studentRepository.findByPrn(prn);
		 if(studentOptional.isPresent()) {
			 studentRepository.deleteByPrn(prn);
			 log.info("student deleted!!");
			 return studentOptional.get();
		 }else {
			 log.info("student with specified prn not found !!! ( check prn ) ");
			 return new Student();
		 }
	 }
}

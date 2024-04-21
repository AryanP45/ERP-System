package com.aryanp45.facultyservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aryanp45.facultyservice.dto.FacultyDto;
import com.aryanp45.facultyservice.model.Faculty;
import com.aryanp45.facultyservice.repository.FacultyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacultyService {
	private final FacultyRepository facultyRepository;
	
	public Faculty getFacultyById(Long id) {
		Optional<Faculty> faculty = facultyRepository.findByFacultyId(id);
		if(faculty.isPresent()) return faculty.get();
		else return new Faculty();
	}
	
	public Faculty addFaculty(FacultyDto facultyDto) {
		Faculty faculty = Faculty.builder()
							.facultyId(facultyDto.getFacultyId())
							.name(facultyDto.getName())
							.email(facultyDto.getEmail())
							.phoneNumber(facultyDto.getPhoneNumber())
							.address(facultyDto.getAddress())
							.salary(facultyDto.getSalary())
							.departmentName(facultyDto.getDepartmentName())
							.build();
		return facultyRepository.save(faculty);
		
	}
	
	public List<Faculty> getAllFaculty(){
		return facultyRepository.findAll();
	}
}

package com.aryanp45.facultyservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aryanp45.facultyservice.dto.FacultyDto;
import com.aryanp45.facultyservice.model.Faculty;
import com.aryanp45.facultyservice.repository.FacultyRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class FacultyService {
	private final FacultyRepository facultyRepository;
	
	public Faculty getFacultyByFacultyId(Long facultyId) {
		Optional<Faculty> faculty = facultyRepository.findByFacultyId(facultyId);
		if(faculty.isPresent()) return faculty.get();
		else {
			log.info("No faculty found with specified id");
			return new Faculty();
		}
	}
	
	public Faculty addFaculty(FacultyDto facultyDto) {
		Optional<Faculty> facultyOptional = facultyRepository.findByFacultyId(facultyDto.getFacultyId());
		if(facultyOptional.isPresent()) {
			log.info("Faculty already exists ( duplicate facultyId ) ");
			return new Faculty();
		}
		
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
	
	public Faculty deleteByFacultyId(Long facultyId) {
		Optional<Faculty> faculty = facultyRepository.findByFacultyId(facultyId);
		if(faculty.isPresent()) {
			facultyRepository.deleteByFacultyId(facultyId);
			log.info("faculty deleted : "+faculty.get().getFacultyId());
			return faculty.get();
		}else {
			log.info("Faculty cannot be deleted ( incorrect facultyId) ");
			return new Faculty();
		}
	}
}

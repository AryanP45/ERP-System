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
	
}

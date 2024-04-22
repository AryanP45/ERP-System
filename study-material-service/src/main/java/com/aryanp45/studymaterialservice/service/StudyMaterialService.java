package com.aryanp45.studymaterialservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aryanp45.studymaterialservice.dto.StudyMaterialDto;
import com.aryanp45.studymaterialservice.model.StudyMaterial;
import com.aryanp45.studymaterialservice.repository.StudyMaterialRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudyMaterialService {
	private final StudyMaterialRepository studyMaterialRepository;
	
	public List<StudyMaterial> getAllMaterials(){
		return studyMaterialRepository.findAll();
	}
	
	
}

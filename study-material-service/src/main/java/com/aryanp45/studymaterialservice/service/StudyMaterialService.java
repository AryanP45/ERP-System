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
	
	public StudyMaterial getMaterialById(Long id) {
		Optional<StudyMaterial> studyMaterial =  studyMaterialRepository.findById(id);
		if(studyMaterial.isEmpty()) return new StudyMaterial();
		else return studyMaterial.get();
	}
	
	public StudyMaterial addMaterial(StudyMaterialDto studyMaterialDto) {
		StudyMaterial studyMaterial = StudyMaterial.builder()
													.title(studyMaterialDto.getTitle())
													.files(studyMaterialDto.getFiles())
													.timestamp(studyMaterialDto.getTimestamp())
													.build();
		return studyMaterialRepository.save(studyMaterial);
	}
	
}

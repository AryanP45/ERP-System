package com.aryanp45.studymaterialservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aryanp45.studymaterialservice.dto.StudyMaterialDto;
import com.aryanp45.studymaterialservice.model.StudyMaterial;
import com.aryanp45.studymaterialservice.repository.StudyMaterialRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudyMaterialService {
	private final StudyMaterialRepository studyMaterialRepository;
	
	public List<StudyMaterial> getAllMaterials(){
		return studyMaterialRepository.findAll();
	}
	
	public StudyMaterial getMaterialById(Long id) {
		Optional<StudyMaterial> studyMaterial =  studyMaterialRepository.findById(id);
		if(studyMaterial.isEmpty()) return new StudyMaterial();
		else {
			log.info("material with specifiedd ID not found");
			return studyMaterial.get();
		
		}
	}
	
	public StudyMaterial addMaterial(StudyMaterialDto studyMaterialDto) {
		// id cannot be same,  not present in DTO
		
		StudyMaterial studyMaterial = StudyMaterial.builder()
													.title(studyMaterialDto.getTitle())
													.files(studyMaterialDto.getFiles())
													.timestamp(studyMaterialDto.getTimestamp())
													.createdBy(studyMaterialDto.getCreatedBy())
													.build();
		return studyMaterialRepository.save(studyMaterial);
	}
	
	public StudyMaterial deleteMaterial(Long id) {
		Optional<StudyMaterial> studyMaterial= studyMaterialRepository.findById(id);
		if(studyMaterial.isPresent()) {
			studyMaterialRepository.deleteById(id);
			log.info("StudyMaterial is deleted !!");
			return studyMaterial.get();
		}else {
			log.info("StudyMaterial with specified Id does not exists");
			return new StudyMaterial();
		}
	}
	
	public StudyMaterial updateMaterial(StudyMaterial studyMaterial) {
		Optional<StudyMaterial> studyMaterialopOptional = studyMaterialRepository.findById(studyMaterial.getId());
		if(studyMaterialopOptional.isPresent()) {
			log.info("updated material data !!!");
			return studyMaterialRepository.save(studyMaterial);
			
		}else {
			log.info("material with specified id is not present ( enter valid id )");
			return new StudyMaterial();
		}
	}
	
}

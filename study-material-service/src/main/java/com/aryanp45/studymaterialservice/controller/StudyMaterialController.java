package com.aryanp45.studymaterialservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryanp45.studymaterialservice.dto.StudyMaterialDto;
import com.aryanp45.studymaterialservice.model.StudyMaterial;
import com.aryanp45.studymaterialservice.service.StudyMaterialService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/material")
@RequiredArgsConstructor
public class StudyMaterialController {
	private final StudyMaterialService studyMaterialService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllMaterials(){
		return ResponseEntity.ok(studyMaterialService.getAllMaterials());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMaterialById(@PathVariable Long id){
		System.out.println(id);
		return ResponseEntity.ok(studyMaterialService.getMaterialById(id));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addMaterial(@RequestBody StudyMaterialDto studyMaterialDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(studyMaterialService.addMaterial(studyMaterialDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMaterial(@PathVariable Long id){
		return ResponseEntity.ok(studyMaterialService.deleteMaterial(id));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?>updateMaterial(@RequestBody StudyMaterial studyMaterial){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(studyMaterialService.updateMaterial(studyMaterial));
	}
	
}

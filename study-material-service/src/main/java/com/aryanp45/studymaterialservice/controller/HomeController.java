package com.aryanp45.studymaterialservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aryanp45.studymaterialservice.dto.StudyMaterialDto;
import com.aryanp45.studymaterialservice.service.StudyMaterialService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/material")
@RequiredArgsConstructor
public class HomeController {
	private final StudyMaterialService studyMaterialService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllMaterials(){
		return ResponseEntity.ok(studyMaterialService.getAllMaterials());
	}
	
}

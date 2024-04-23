package com.aryanp45.studymaterialservice.dto;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class StudyMaterialDto {
	private String title;

	private List<String> files;

	private Date timestamp;
	
	private String createdBy;
}

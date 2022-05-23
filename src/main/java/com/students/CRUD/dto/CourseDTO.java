package com.students.CRUD.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {

	private int iD;
	private String name;
	private String decription;
	private List<StudentDTO> likes;
}

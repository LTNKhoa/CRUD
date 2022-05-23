package com.students.CRUD.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.students.CRUD.entities.CourseEntity;
import com.students.CRUD.entities.StudentEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class StudentDTO {
	private int id;
	private String name;
	private int age;
	private Date dateOfBirth;
	private int phone;
	private String email;

}

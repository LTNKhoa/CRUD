package com.students.CRUD.services.impl;

import com.students.CRUD.entities.CourseEntity;
import com.students.CRUD.repository.CourseRepo;
import com.students.CRUD.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseImpl implements CourseService {

	@Autowired
	private CourseRepo courseRepo;

	@Override
	public CourseEntity findById(int id) {
		return courseRepo.findById(id).orElse(null);
	}

}

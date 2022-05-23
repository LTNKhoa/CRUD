package com.students.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.CRUD.entities.CourseEntity;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {
	
}

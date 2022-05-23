package com.students.CRUD.services;

import java.util.List;

import com.students.CRUD.dto.StudentDTO;
import com.students.CRUD.entities.StudentEntity;

public interface StudentService {

	StudentDTO save(StudentDTO StudentDTO);

	StudentDTO update(StudentDTO StudentDTO, int ID);

	void del(int[] ids);

	List<StudentDTO> findAllStudent();

	List<StudentEntity> getAll(String field, int page, int size); // paging

	StudentEntity findById(int id);

}

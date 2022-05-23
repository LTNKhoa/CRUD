package com.students.CRUD.repository;

import com.students.CRUD.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer>, JpaSpecificationExecutor<StudentEntity> {

}

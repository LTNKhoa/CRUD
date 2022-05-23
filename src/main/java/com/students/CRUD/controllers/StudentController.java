package com.students.CRUD.controllers;

import com.sipios.springsearch.anotation.SearchSpec;
import com.students.CRUD.dto.StudentDTO;
import com.students.CRUD.entities.StudentEntity;
import com.students.CRUD.repository.StudentRepo;
import com.students.CRUD.services.StudentService;
import com.students.CRUD.services.impl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentImpl studentimpl;

    @GetMapping(value = "/showStudents")
    public List<StudentDTO> showStudents() {
        return studentService.findAllStudent();
    }

    @PostMapping(value = "/student")
    public StudentDTO addStudent(@RequestBody StudentDTO StudentDTO) {
        StudentDTO result = studentService.save(StudentDTO);
        return result;
    }

    @PutMapping(value = "/student/{id}")
    public StudentDTO updateStudent(@RequestBody StudentDTO StudentDTO, @RequestParam(name = "ID") int ID) {
        StudentDTO result = studentService.update(StudentDTO, ID);
        return result;
    }

    @DeleteMapping(value = "/student")
    public void delStudents(@RequestBody int ids[]) {
        studentService.del(ids);
    }

    @GetMapping("/searchStudent")
    public ResponseEntity<List<StudentEntity>> searchForStudent(@SearchSpec Specification<StudentEntity> specs) {
        return new ResponseEntity<>(studentRepo.findAll(Specification.where(specs)), HttpStatus.OK);
    }
    // seard này dùng spring-search dependency hỗ trợ, không cần viết query

    @GetMapping("/studentspaging")
    public List<StudentEntity> getAll(@RequestParam String field, @RequestParam int page, @RequestParam int size) {
        return studentService.getAll(field, page, size);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<StudentEntity> getStudent(@PathVariable(name = "id") int id) {
        return new ResponseEntity<StudentEntity>(studentService.findById(id), HttpStatus.OK);
    }
}

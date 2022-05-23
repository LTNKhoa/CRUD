package com.students.CRUD.controllers;

import com.students.CRUD.dto.CourseDTO;
import com.students.CRUD.dto.StudentDTO;
import com.students.CRUD.entities.CourseEntity;
import com.students.CRUD.entities.StudentEntity;
import com.students.CRUD.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController(value = "course")
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/getCourse/{id}")
    public ResponseEntity<Object> getCourse(@PathVariable(name = "id") int id) {
        CourseEntity courseEntity = courseService.findById(id);

        CourseDTO courseDTO = modelMapper.map(courseEntity, CourseDTO.class);
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (StudentEntity studentEntity : courseEntity.getStudents()) {
            studentDTOList.add(modelMapper.map(studentEntity, StudentDTO.class));
        }
        courseDTO.setLikes(studentDTOList);

        return new ResponseEntity<Object>(courseDTO, HttpStatus.OK);
    }
}

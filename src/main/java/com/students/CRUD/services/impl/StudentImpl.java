package com.students.CRUD.services.impl;

import com.students.CRUD.dto.StudentDTO;
import com.students.CRUD.entities.StudentEntity;
import com.students.CRUD.repository.StudentRepo;
import com.students.CRUD.services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDTO save(StudentDTO StudentDTO) {
        StudentEntity StudentEntity = modelMapper.map(StudentDTO, StudentEntity.class);
        StudentEntity model = studentRepo.save(StudentEntity);
        return modelMapper.map(model, StudentDTO.class);
    }

    @Override
    public StudentDTO update(StudentDTO StudentDTO, int ID) {
        Optional<StudentEntity> optional = studentRepo.findById(ID);
        if (optional.isPresent()) {
            StudentEntity StudentEntity = modelMapper.map(StudentDTO, StudentEntity.class);
            StudentEntity model = studentRepo.save(StudentEntity);
            return modelMapper.map(model, StudentDTO.class);
        }
        return null;
    }

    @Override
    public void del(int[] ids) {
        for (int item : ids) {
            studentRepo.deleteById(item);
        }
    }

    @Override
    public List<StudentDTO> findAllStudent() {
        List<StudentEntity> student = studentRepo.findAll();
        List<StudentDTO> studentlist = student.stream().map(students -> modelMapper.map(students, StudentDTO.class))
                .collect(Collectors.toList());
        return studentlist;
    }

    // search
    @Override
    public List<StudentEntity> getAll(String field, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Direction.ASC, field);
        return studentRepo.findAll(pageable).toList();
    }

    @Override
    public StudentEntity findById(int id) {
        return studentRepo.findById(id).orElse(null);
    }


}

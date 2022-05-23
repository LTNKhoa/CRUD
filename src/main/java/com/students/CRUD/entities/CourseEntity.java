package com.students.CRUD.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "course")
public class CourseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String decription;

    @ManyToMany(mappedBy = "likedCourses")
    @JsonBackReference
    private List<StudentEntity> students = new ArrayList<>();

//	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
//	Set<CourseEntity> course = new HashSet<>();
}

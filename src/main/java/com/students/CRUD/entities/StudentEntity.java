package com.students.CRUD.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@Table(name = "student")
public class StudentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private Date dateOfBirth;

    @Column
    private int phone;

    @Column
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
//    @JsonSerialize(using = CustomListSerializer.class)
    @JsonManagedReference
    private List<CourseEntity> likedCourses = new ArrayList<>();

//	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
//	Set<StudentEntity> students = new HashSet<>();
}

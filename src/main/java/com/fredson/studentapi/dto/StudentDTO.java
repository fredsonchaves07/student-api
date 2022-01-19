package com.fredson.studentapi.dto;

import com.fredson.studentapi.entities.Student;

import java.io.Serializable;

public class StudentDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long codStudent;
    private String name;
    private String course;

    public StudentDTO(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public StudentDTO(Student student) {
        this.codStudent = student.getCodStudent();
        this.name = student.getName();
        this.course = student.getCourse();
    }

    public Long getCodStudent() {
        return codStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}

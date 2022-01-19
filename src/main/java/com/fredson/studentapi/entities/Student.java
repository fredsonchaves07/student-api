package com.fredson.studentapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codStudent;

    private String name;

    private String course;

    public Student() {}

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getCodStudent(), student.getCodStudent()) && Objects.equals(getName(), student.getName()) && Objects.equals(getCourse(), student.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodStudent(), getName(), getCourse());
    }
}

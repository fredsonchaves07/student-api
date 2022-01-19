package com.fredson.studentapi.repositories;

import com.fredson.studentapi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

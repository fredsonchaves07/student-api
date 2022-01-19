package com.fredson.studentapi.services;

import com.fredson.studentapi.dto.StudentDTO;
import com.fredson.studentapi.entities.Student;
import com.fredson.studentapi.repositories.StudentRepository;
import com.fredson.studentapi.services.excpetions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Transactional(readOnly = true)
    public List<StudentDTO> findAll() {
        List<Student> students = repository.findAll();
        return students.stream().map(StudentDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public StudentDTO findById(Long id) {
        Optional<Student> student = repository.findById(id);
        return new StudentDTO(student.orElseThrow(() -> new ResourceNotFoundException("Student not found")));
    }

    @Transactional
    public StudentDTO insert(StudentDTO student) {
        return new StudentDTO(repository.save(new Student(student.getName(), student.getCourse())));
    }

    @Transactional
    public StudentDTO update(Long id, StudentDTO student) {
        try {
            repository.getById(id).setName(student.getName());
            repository.getById(id).setCourse(student.getCourse());
            return new StudentDTO(repository.save(repository.getById(id)));
        } catch (EntityNotFoundException exception) {
            throw new ResourceNotFoundException("Student not found");
        }
    }
}

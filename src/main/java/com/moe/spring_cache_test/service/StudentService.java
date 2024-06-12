package com.moe.spring_cache_test.service;

import com.moe.spring_cache_test.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();

    Student getById(Long id);

    Student store(Student student);

    Student update(Student student, Long id);

    void delete(Long id);
}

package com.moe.spring_cache_test.service.impl;

import com.moe.spring_cache_test.model.Student;
import com.moe.spring_cache_test.repository.StudentRepository;
import com.moe.spring_cache_test.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Cacheable(value = "student")
    @Override
    public List<Student> getAll() {
        logger.info("...Entering getAll() method!");
        return studentRepository.findAll();
    }

    @Cacheable(value = "student", key = "#id")
    @Override
    public Student getById(Long id) {
        logger.info("...Entering getById() method!");
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not found with :" + id));
    }

    @CacheEvict(value = "student", allEntries = true)
    @Override
    public Student store(Student student) {
        logger.info("...Entering store() method!");
        return studentRepository.save(student);
    }

    @CachePut(value = "student", key = "#id")
    @Override
    public Student update(Student student, Long id) {
        logger.info("...Entering update() method!");
        Student dbStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not found with :" + id));
        dbStudent.setName(student.getName());
        dbStudent.setEmail(student.getEmail());
        dbStudent.setCourse(student.getCourse());
        studentRepository.save(dbStudent);
        return dbStudent;
    }

    @CacheEvict(value = "student", allEntries = true)
    @Override
    public void delete(Long id) {
        logger.info("...Entering delete() method!");
        studentRepository.deleteById(id);
    }
}

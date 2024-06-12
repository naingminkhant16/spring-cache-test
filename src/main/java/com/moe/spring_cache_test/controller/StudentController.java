package com.moe.spring_cache_test.controller;

import com.moe.spring_cache_test.model.Student;
import com.moe.spring_cache_test.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Student student = studentService.getById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("")
    public ResponseEntity<?> store(@RequestBody Student student) {
        Student savedStudent = studentService.store(student);
        return ResponseEntity.ok(savedStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Long id) {
        Student student1 = studentService.update(student, id);
        return ResponseEntity.ok(student1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

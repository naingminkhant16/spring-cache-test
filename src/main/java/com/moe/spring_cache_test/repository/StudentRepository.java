package com.moe.spring_cache_test.repository;

import com.moe.spring_cache_test.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

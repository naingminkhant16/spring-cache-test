package com.moe.spring_cache_test.model;

import com.moe.spring_cache_test.utils.Course;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "course")
    private Course course;

    public Student(String name, String email, Course course) {
        this.name = name;
        this.email = email;
        this.course = course;
    }
}

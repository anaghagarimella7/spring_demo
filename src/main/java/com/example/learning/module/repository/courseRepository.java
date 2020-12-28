package com.example.learning.module.repository;

import com.example.learning.module.entity.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepository extends JpaRepository<course,Integer> {
    
}

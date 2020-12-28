package com.example.learning.module.repository;

import com.example.learning.module.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user,Integer>{
    
}

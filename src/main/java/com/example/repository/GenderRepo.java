package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Gender;

public interface GenderRepo extends JpaRepository<Gender, Long> {

}

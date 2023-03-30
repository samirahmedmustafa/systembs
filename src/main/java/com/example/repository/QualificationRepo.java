package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Qualification;

public interface QualificationRepo extends JpaRepository<Qualification, Long> {

}

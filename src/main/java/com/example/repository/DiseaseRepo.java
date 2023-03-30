package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Disease;

public interface DiseaseRepo extends JpaRepository<Disease, Long>{

}

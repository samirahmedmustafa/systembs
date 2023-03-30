package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.BuildingType;

public interface BuildingTypeRepo extends JpaRepository<BuildingType, Long>{

}

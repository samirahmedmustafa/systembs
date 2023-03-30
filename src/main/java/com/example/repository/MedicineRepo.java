package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine, Long> {

}

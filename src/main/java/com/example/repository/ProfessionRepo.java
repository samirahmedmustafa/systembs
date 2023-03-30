package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Profession;

public interface ProfessionRepo extends JpaRepository<Profession, Long> {

}

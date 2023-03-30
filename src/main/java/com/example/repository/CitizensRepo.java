package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Citizens;

public interface CitizensRepo extends JpaRepository<Citizens, Long>{

}

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Locality;

public interface LocalityRepo extends JpaRepository<Locality, Long>{

}

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Gas;

public interface GasRepo extends JpaRepository<Gas, Long>{

}

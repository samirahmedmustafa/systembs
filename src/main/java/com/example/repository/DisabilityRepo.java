package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Disability;

public interface DisabilityRepo extends JpaRepository<Disability, Long> {

}

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Nationality;

public interface NationalityRepo extends JpaRepository<Nationality, Long> {

}

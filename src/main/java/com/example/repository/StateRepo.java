package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.State;

public interface StateRepo extends JpaRepository<State, Long> {

	State findByName(String name);
}

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Condition;

public interface ConditionRepo extends JpaRepository<Condition, Long>{

}

package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Disease;
import com.example.entity.School;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.DiseaseRepo;
import com.example.repository.SchoolRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {
	
	private final SchoolRepo schoolRepo;
	
	public List<School> getAll() {
		return schoolRepo.findAll();
	}
	
	public School save(School item) {
		return schoolRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		schoolRepo.deleteById(id);
	}
	
	public School update(Long id, School item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		School old = schoolRepo.findById(item.getId()).orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return old;
	}
	
	public School getById(Long id) {
		return schoolRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

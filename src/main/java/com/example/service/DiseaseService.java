package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Disease;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.DiseaseRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiseaseService {
	
	private final DiseaseRepo diseaseRepo;
	
	public List<Disease> getAll() {
		return diseaseRepo.findAll();
	}
	
	public Disease save(Disease item) {
		return diseaseRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		diseaseRepo.deleteById(id);
	}
	
	public Disease update(Disease item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Disease old = diseaseRepo.findById(item.getId()).orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return old;
	}
	
	public Disease getById(Long id) {
		return diseaseRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

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
	
	private final DiseaseRepo itemRepo;
	
	public List<Disease> getAll() {
		return itemRepo.findAll();
	}
	
	public Disease save(Disease item) {
		return itemRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public Disease update(Long id, Disease item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Disease old = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		mapper.map(item, old);
		return itemRepo.save(old);
	}
	
	public Disease getById(Long id) {
		return itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

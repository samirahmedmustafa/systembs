package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CitizensService {
	
	private static final Logger logger = LoggerFactory.getLogger(CitizensService.class);
	private final CitizensRepo itemRepo;
	
	public List<Citizens> getAll() {
		return itemRepo.findAll();
	}
	
	public List<Object[]> getAllCustom() {
		return itemRepo.findCustomCitizens();
	}
	
	public List<Citizens> findByFemale() {
		return itemRepo.findByFemale();
	}
	
	public List<Citizens> findByGender(String gender) {
		return itemRepo.findByGender(gender);
	}
	
	public Citizens save(Citizens item) {
		return itemRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public Citizens update(Long id, Citizens item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Citizens old = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		mapper.map(item, old);
		return itemRepo.save(old);
	}
	
	public Citizens getById(Long id) {
		Citizens citizen = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		logger.warn("citizen: {}", citizen.getWives());
		return citizen;
	}

	
}

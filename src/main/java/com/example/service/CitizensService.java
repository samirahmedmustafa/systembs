package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CitizensService {
	
	private final CitizensRepo citizensRepo;
	
	public List<Citizens> getAll() {
		return citizensRepo.findAll();
	}
	
	public Citizens save(Citizens item) {
		return citizensRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		citizensRepo.deleteById(id);
	}
	
	public Citizens update(Citizens item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Citizens old = citizensRepo.findById(item.getId()).orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return old;
	}
	
	public Citizens getById(Long id) {
		return citizensRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Locality;
import com.example.entity.Neighbourhood;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.LocalityRepo;
import com.example.repository.NeighbourhoodRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocalityService {
	
	private final LocalityRepo itemRepo;
	
	public List<Locality> getAll() {
		return itemRepo.findAll();
	}
	
	public Locality save(Locality item) {
		return itemRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public Locality update(Long id, Locality item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Locality old = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		mapper.map(item, old);
		return itemRepo.save(old);
	}
	
	public Locality getById(Long id) {
		return itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

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
	
	private final LocalityRepo localityRepo;
	
	public List<Locality> getAll() {
		return localityRepo.findAll();
	}
	
	public Locality save(Locality item) {
		return localityRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		localityRepo.deleteById(id);
	}
	
	public Locality update(Locality item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Locality old = localityRepo.findById(item.getId()).orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return old;
	}
	
	public Locality getById(Long id) {
		return localityRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

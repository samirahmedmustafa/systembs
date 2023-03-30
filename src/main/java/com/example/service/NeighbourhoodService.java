package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Neighbourhood;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.NeighbourhoodRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NeighbourhoodService {
	
	private final NeighbourhoodRepo neighbourhoodRepo;
	
	public List<Neighbourhood> getAll() {
		return neighbourhoodRepo.findAll();
	}
	
	public Neighbourhood save(Neighbourhood item) {
		return neighbourhoodRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		neighbourhoodRepo.deleteById(id);
	}
	
	public Neighbourhood update(Neighbourhood item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Neighbourhood old = neighbourhoodRepo.findById(item.getId()).orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return old;
	}
	
	public Neighbourhood getById(Long id) {
		return neighbourhoodRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

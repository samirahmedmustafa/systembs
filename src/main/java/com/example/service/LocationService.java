package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Location;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.LocationRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationService {
	
	private final LocationRepo itemRepo;
	
	public List<Location> getAll() {
		return itemRepo.findAll();
	}
	
	public Location save(Location location) {
		return itemRepo.save(location);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public Location update(Long id, Location location) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Location old = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		mapper.map(location, old);
		return itemRepo.save(old);
	}
	
	public Location getById(Long id) {
		return itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

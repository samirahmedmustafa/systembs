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
	
	private final LocationRepo locationRepo;
	
	public List<Location> getAll() {
		return locationRepo.findAll();
	}
	
	public Location save(Location location) {
		return locationRepo.save(location);
	}
	
	public void deleteItemById(Long id) {
		locationRepo.deleteById(id);
	}
	
	public Location update(Location location) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Location old = locationRepo.findById(location.getId()).orElseThrow(() -> new NotFoundException(location.getId() + " not found"));
		mapper.map(location, old);
		return old;
	}
	
	public Location getById(Long id) {
		return locationRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

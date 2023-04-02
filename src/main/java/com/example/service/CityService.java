package com.example.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.example.entity.Citizens;
import com.example.entity.City;
import com.example.entity.Locality;
import com.example.entity.Neighbourhood;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.CityRepo;
import com.example.repository.LocalityRepo;
import com.example.repository.NeighbourhoodRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityService {
	
	private static final Logger logger = LoggerFactory.getLogger(CityService.class);

	private final CityRepo itemRepo;
	
	public List<City> getAll() {
		return itemRepo.findAll();
	}
	
	public City save(City item) {
		return itemRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public City update(Long id, City item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		City old = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		mapper.map(item, old);
		
		return itemRepo.save(old);
	}
	
	public City getById(Long id) throws Exception {
	
		logger.error("id is: {}", id);
		
		City item;
		
		try {
			item = itemRepo.findById(id).get(); //.orElseThrow(() -> new NoSuchElementException(String.format("item %s not found at all", id)));
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(String.format("Item # %d not found", id));
		} catch (Exception e) {
			throw new Exception(String.format("Unknow error"));
		}
		return item;
	}

	
}

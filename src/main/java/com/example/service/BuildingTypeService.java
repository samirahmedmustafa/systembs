package com.example.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.BuildingType;
import com.example.entity.Citizens;
import com.example.entity.Disease;
import com.example.entity.School;
import com.example.entity.State;
import com.example.exception.NotFoundException;
import com.example.repository.BuildingTypeRepo;
import com.example.repository.CitizensRepo;
import com.example.repository.DiseaseRepo;
import com.example.repository.SchoolRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuildingTypeService {
	
	private final BuildingTypeRepo itemRepo;
	
	public List<BuildingType> getAll() {
		return itemRepo.findAll();
	}
	
	public BuildingType save(BuildingType item) {
		return itemRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public BuildingType update(Long id, BuildingType item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		BuildingType old = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		mapper.map(item, old);
		return itemRepo.save(old);
	}
	
	public BuildingType getById(Long id) {
		return itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

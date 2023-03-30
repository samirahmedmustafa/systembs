package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.BuildingType;
import com.example.entity.Citizens;
import com.example.entity.Disease;
import com.example.entity.School;
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
	
	private final BuildingTypeRepo buildingTypeRepo;
	
	public List<BuildingType> getAll() {
		return buildingTypeRepo.findAll();
	}
	
	public BuildingType save(BuildingType item) {
		return buildingTypeRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		buildingTypeRepo.deleteById(id);
	}
	
	public BuildingType update(BuildingType item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		BuildingType old = buildingTypeRepo.findById(item.getId()).orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return old;
	}
	
	public BuildingType getById(Long id) {
		return buildingTypeRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

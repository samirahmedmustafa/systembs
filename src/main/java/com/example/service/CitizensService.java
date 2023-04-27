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
		logger.warn("citizen: {}", item);
		Citizens old = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		old = updateCitizen(old, item);
//		logger.warn("citizen: {}", item);
//		ModelMapper mapper = new ModelMapper();
//		mapper.getConfiguration().setSkipNullEnabled(true);
//		mapper.map(item, old);
//		return itemRepo.save(old);
		return itemRepo.save(old);
	}
	
	private Citizens updateCitizen(Citizens old, Citizens item) {

		old.setBuildAddressDetails(item.getBuildAddressDetails());
		old.setDateOfBirth(item.getDateOfBirth());
		old.setName(item.getName());
		old.setPhoneNo(item.getPhoneNo());
		old.setDisabilities(item.getDisabilities());
		old.setMedicines(item.getMedicines());
		old.setStatus(item.getStatus());
		old.setQualification(item.getQualification());
		old.setProfessions(item.getProfessions());
		old.setSupports(item.getSupports());
		old.setGases(item.getGases());
		old.setWives(item.getWives());
		old.setNationality(item.getNationality());
		old.setNationalNo(item.getNationalNo());
		old.setDiseases(item.getDiseases());
		old.setSkills(item.getSkills());
		old.setGender(item.getGender());
		old.setIsDeceased(item.getIsDeceased());
		old.setIsGainingSupport(item.getIsGainingSupport());
		old.setLocation(item.getLocation());
		old.setIsSupportEligible(item.getIsSupportEligible());
		
		return old;
	}

	public Citizens getById(Long id) {
		Citizens citizen = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		return citizen;
	}

	
}

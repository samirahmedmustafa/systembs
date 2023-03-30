package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Gender;
import com.example.entity.Qualification;
import com.example.entity.Support;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.GenderRepo;
import com.example.repository.QualificationRepo;
import com.example.repository.SupportRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenderService {
	
	private final GenderRepo genderRepo;
	
	public List<Gender> getAll() {
		return genderRepo.findAll();
	}
	
	public Gender save(Gender qualification) {
		return genderRepo.save(qualification);
	}
	
	public void deleteItemById(Long id) {
		genderRepo.deleteById(id);
	}
	
	public Gender update(Gender gender) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Gender old = genderRepo.findById(gender.getId()).orElseThrow(() -> new NotFoundException(gender.getId() + " not found"));
		mapper.map(gender, old);
		return old;
	}
	
	public Gender getById(Long id) {
		return genderRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

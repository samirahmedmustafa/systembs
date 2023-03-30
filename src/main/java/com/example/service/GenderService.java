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
	
	private final GenderRepo itemRepo;
	
	public List<Gender> getAll() {
		return itemRepo.findAll();
	}
	
	public Gender save(Gender qualification) {
		return itemRepo.save(qualification);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public Gender update(Long id, Gender gender) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Gender old = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		mapper.map(gender, old);
		return itemRepo.save(old);
	}
	
	public Gender getById(Long id) {
		return itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

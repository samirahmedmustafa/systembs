package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Gender;
import com.example.entity.Nationality;
import com.example.entity.Qualification;
import com.example.entity.Support;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.GenderRepo;
import com.example.repository.NationalityRepo;
import com.example.repository.QualificationRepo;
import com.example.repository.SupportRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NationalityService {
	
	private final NationalityRepo nationalityRepo;
	
	public List<Nationality> getAll() {
		return nationalityRepo.findAll();
	}
	
	public Nationality save(Nationality item) {
		return nationalityRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		nationalityRepo.deleteById(id);
	}
	
	public Nationality update(Nationality item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Nationality old = nationalityRepo.findById(item.getId()).orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return old;
	}
	
	public Nationality getById(Long id) {
		return nationalityRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

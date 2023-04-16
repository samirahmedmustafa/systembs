package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Qualification;
import com.example.entity.Support;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.QualificationRepo;
import com.example.repository.SupportRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class QualificationService {
	
	private final QualificationRepo qualificationRepo;
	
	public List<Qualification> getAll() {
		return qualificationRepo.findAll();
	}
	
	public Qualification save(Qualification qualification) {
		return qualificationRepo.save(qualification);
	}
	
	public void deleteItemById(Long id) {
		qualificationRepo.deleteById(id);
	}
	
	public Qualification update(Long id, Qualification qualification) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Qualification old = qualificationRepo.findById(qualification.getId()).orElseThrow(() -> new NotFoundException(qualification.getId() + " not found"));
		mapper.map(qualification, old);
		return old;
	}
	
	public Qualification getById(Long id) {
		return qualificationRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

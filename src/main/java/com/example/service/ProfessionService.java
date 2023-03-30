package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.entity.Condition;
import com.example.entity.Profession;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.ConditionRepo;
import com.example.repository.ProfessionRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfessionService {
	
	private final ProfessionRepo professionRepo;
	
	public List<Profession> getAll() {
		return professionRepo.findAll();
	}
	
	public Profession save(Profession item) {
		return professionRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		professionRepo.deleteById(id);
	}
	
	public Profession update(Profession item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Profession old = professionRepo.findById(item.getId()).orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return old;
	}
	
	public Profession getById(Long id) {
		return professionRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

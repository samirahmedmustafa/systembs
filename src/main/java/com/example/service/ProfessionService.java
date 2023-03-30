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
	
	private final ProfessionRepo itemRepo;
	
	public List<Profession> getAll() {
		return itemRepo.findAll();
	}
	
	public Profession save(Profession item) {
		return itemRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public Profession update(Long id, Profession item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Profession old = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		mapper.map(item, old);
		return itemRepo.save(old);
	}
	
	public Profession getById(Long id) {
		return itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

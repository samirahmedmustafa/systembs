package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.entity.Condition;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.ConditionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConditionService {
	
	private final ConditionRepo itemRepo;
	
	public List<Condition> getAll() {
		return itemRepo.findAll();
	}
	
	public Condition save(Condition item) {
		return itemRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public Condition update(Long id, Condition item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Condition old = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		mapper.map(item, old);
		return itemRepo.save(old);
	}
	
	public Condition getById(Long id) {
		return itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

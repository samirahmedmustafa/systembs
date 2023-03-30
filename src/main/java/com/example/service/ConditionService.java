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
	
	private final ConditionRepo conditionRepo;
	
	public List<Condition> getAll() {
		return conditionRepo.findAll();
	}
	
	public Condition save(Condition item) {
		return conditionRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		conditionRepo.deleteById(id);
	}
	
	public Condition update(Condition item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Condition old = conditionRepo.findById(item.getId()).orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return old;
	}
	
	public Condition getById(Long id) {
		return conditionRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

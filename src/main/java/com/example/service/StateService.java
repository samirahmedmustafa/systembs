package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Disease;
import com.example.entity.School;
import com.example.entity.State;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.DiseaseRepo;
import com.example.repository.SchoolRepo;
import com.example.repository.StateRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StateService {
	
	private final StateRepo stateRepo;
	
	public List<State> getAll() {
		return stateRepo.findAll();
	}
	
	public State save(State item) {
		return stateRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		stateRepo.deleteById(id);
	}
	
	public State update(State item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		State old = stateRepo.findById(item.getId()).orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return old;
	}
	
	public State getById(Long id) {
		return stateRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

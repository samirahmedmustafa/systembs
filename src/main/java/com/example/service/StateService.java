package com.example.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Disease;
import com.example.entity.School;
import com.example.entity.State;
import com.example.exception.AlreadyExistingException;
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
	
	private static final Logger logger = LoggerFactory.getLogger(State.class);


	private final StateRepo itemRepo;
	
	public List<State> getAll() {
		return itemRepo.findAll();
	}
	
	public State save(State item) throws Exception {
		
		if(item.getName() == null || item.getName().equals("")) { throw new IllegalArgumentException(String.format("Enter a valid name", null)); }
		
		if(validateNameExists(item.getName()))
			throw new IllegalArgumentException(String.format("Name %s already exists", item.getName()));
		
		return itemRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public State update(Long id, State item) throws Exception {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		State old = itemRepo.findById(id).orElseThrow(() -> new NoSuchElementException(id + " not found"));
		mapper.map(item, old);
		return itemRepo.save(old);
	}
	
	public State getById(Long id) throws Exception {
		return itemRepo.findById(id).orElseThrow(() -> new NoSuchElementException(id + " not found"));
	}
	
	public State getByName(String name) throws Exception {
		
		State state = itemRepo.findByName(name);
		
		if(state == null) {
			throw new NoSuchElementException(String.format("Name %s not found", name)); 
		}
			
		return state;
	}
	
	public Boolean validateNameExists(String name) {
		
		State state = itemRepo.findByName(name);
		
		System.out.println("name " + state + " exists");
		
		logger.error("name %s exists", state);
		
		if(state == null) 
			return false;

		return true;
	}
	
	public Boolean validateNameNotExists(String name) {
		
		State state = itemRepo.findByName(name);
		
		System.out.println("name " + state + " not exists");
		
		logger.error("name not %s exists", state);
		
		if(state == null) 
			return true;

		return false;
	}

	
}

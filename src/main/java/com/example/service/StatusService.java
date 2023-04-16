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
import com.example.entity.Status;
import com.example.exception.AlreadyExistingException;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.DiseaseRepo;
import com.example.repository.SchoolRepo;
import com.example.repository.StateRepo;
import com.example.repository.StatusRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatusService {
	
	private static final Logger logger = LoggerFactory.getLogger(Status.class);

	private final StatusRepo itemRepo;
	
	public List<Status> getAll() {
		return itemRepo.findAll();
	}
	
	public Status save(Status item) throws Exception {
		
		if(item.getName() == null || item.getName().equals("")) { throw new IllegalArgumentException(String.format("Enter a valid name", null)); }
		
		if(validateNameExists(item.getName()))
			throw new IllegalArgumentException(String.format("Name %s already exists", item.getName()));
		
		return itemRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public Status update(Long id, Status item) throws Exception {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Status old = itemRepo.findById(id).orElseThrow(() -> new NoSuchElementException(id + " not found"));
		mapper.map(item, old);
		return itemRepo.save(old);
	}
	
	public Status getById(Long id) throws Exception {
		return itemRepo.findById(id).orElseThrow(() -> new NoSuchElementException(id + " not found"));
	}
	
	public Status getByName(String name) throws Exception {
		
		Status item = itemRepo.findByName(name);
		
		if(item == null) {
			throw new NoSuchElementException(String.format("Name %s not found", name)); 
		}
			
		return item;
	}
	
	public Boolean validateNameExists(String name) {
		
		Status status = itemRepo.findByName(name);
		
		System.out.println("name " + status + " exists");
		
		logger.error("name %s exists", status);
		
		if(status == null) 
			return false;

		return true;
	}
	
	public Boolean validateNameNotExists(String name) {
		
		Status item = itemRepo.findByName(name);
		
		System.out.println("name " + item + " not exists");
		
		logger.error("name not %s exists", item);
		
		if(item == null) 
			return true;

		return false;
	}

	
}

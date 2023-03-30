package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Support;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.SupportRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupportService {
	
	private final SupportRepo supportRepo;
	
	public List<Support> getAll() {
		return supportRepo.findAll();
	}
	
	public Support save(Support support) {
		return supportRepo.save(support);
	}
	
	public void deleteItemById(Long id) {
		supportRepo.deleteById(id);
	}
	
	public Support update(Support support) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Support old = supportRepo.findById(support.getId()).orElseThrow(() -> new NotFoundException(support.getId() + " not found"));
		mapper.map(support, old);
		return old;
	}
	
	public Support getById(Long id) {
		return supportRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

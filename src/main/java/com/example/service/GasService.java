package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Gas;
import com.example.entity.Gender;
import com.example.entity.Nationality;
import com.example.entity.Qualification;
import com.example.entity.Support;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.GasRepo;
import com.example.repository.GenderRepo;
import com.example.repository.NationalityRepo;
import com.example.repository.QualificationRepo;
import com.example.repository.SupportRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class GasService {
	
	private final GasRepo gasRepo;
	
	public List<Gas> getAll() {
		return gasRepo.findAll();
	}
	
	public Gas save(Gas item) {
		return gasRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		gasRepo.deleteById(id);
	}
	
	public Gas update(Gas item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Gas old = gasRepo.findById(item.getId()).orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return old;
	}
	
	public Gas getById(Long id) {
		return gasRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Gas;
import com.example.entity.Gender;
import com.example.entity.Medicine;
import com.example.entity.Nationality;
import com.example.entity.Qualification;
import com.example.entity.Support;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.GasRepo;
import com.example.repository.GenderRepo;
import com.example.repository.MedicineRepo;
import com.example.repository.NationalityRepo;
import com.example.repository.QualificationRepo;
import com.example.repository.SupportRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MedicineService {
	
	private final MedicineRepo itemRepo;
	
	public List<Medicine> getAll() {
		return itemRepo.findAll();
	}
	
	public Medicine save(Medicine item) {
		return itemRepo.save(item);
	}
	
	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}
	
	public Medicine update(Long id, Medicine item) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Medicine old = itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
		mapper.map(item, old);
		return itemRepo.save(old);
	}
	
	public Medicine getById(Long id) {
		return itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

	
}

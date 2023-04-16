package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.entity.Citizens;
import com.example.entity.Profession;
import com.example.entity.Qualification;
import com.example.entity.Support;
import com.example.exception.NotFoundException;
import com.example.repository.CitizensRepo;
import com.example.repository.QualificationRepo;
import com.example.repository.SupportRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class QualificationService {

	private final QualificationRepo itemRepo;

	public List<Qualification> getAll() {
		return itemRepo.findAll();
	}

	public Qualification save(Qualification qualification) {
		return itemRepo.save(qualification);
	}

	public void deleteItemById(Long id) {
		itemRepo.deleteById(id);
	}

	public Qualification update(Long id, Qualification item) {

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		Qualification old = itemRepo.findById(item.getId())
				.orElseThrow(() -> new NotFoundException(item.getId() + " not found"));
		mapper.map(item, old);
		return itemRepo.save(old);
	}

	public Qualification getById(Long id) {
		return itemRepo.findById(id).orElseThrow(() -> new NotFoundException(id + " not found"));
	}

}

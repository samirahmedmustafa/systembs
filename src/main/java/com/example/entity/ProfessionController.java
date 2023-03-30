package com.example.entity;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CitizensService;
import com.example.service.DiseaseService;
import com.example.service.GenderService;
import com.example.service.LocationService;
import com.example.service.NationalityService;
import com.example.service.ProfessionService;
import com.example.service.SupportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ProfessionController {
	
	private final  ProfessionService itemService;
	
	@GetMapping("professions/{id}")
	public ResponseEntity<Profession> getById(@PathVariable Long id) {
		return new ResponseEntity<Profession>(itemService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("professions")
	public ResponseEntity<List<Profession>> getAll() {
		return new ResponseEntity<List<Profession>>(itemService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("professions/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("professions/{id}")
	public ResponseEntity<Profession> updateById(@RequestBody Profession item) {
		return new ResponseEntity<Profession>(itemService.update(item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("professions")
	public ResponseEntity<Profession> save(@RequestBody Profession item) {
		return new ResponseEntity<Profession>(itemService.save(item), HttpStatusCode.valueOf(201));
	}

}

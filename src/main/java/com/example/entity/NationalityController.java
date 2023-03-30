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
import com.example.service.SupportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class NationalityController {
	
	private final  NationalityService itemService;
	
	@GetMapping("nationalities/{id}")
	public ResponseEntity<Nationality> getById(@PathVariable Long id) {
		return new ResponseEntity<Nationality>(itemService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("nationalities")
	public ResponseEntity<List<Nationality>> getAll() {
		return new ResponseEntity<List<Nationality>>(itemService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("nationalities/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("nationalities/{id}")
	public ResponseEntity<Nationality> updateById(@RequestBody Nationality item) {
		return new ResponseEntity<Nationality>(itemService.update(item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("nationalities")
	public ResponseEntity<Nationality> save(@RequestBody Nationality item) {
		return new ResponseEntity<Nationality>(itemService.save(item), HttpStatusCode.valueOf(201));
	}

}

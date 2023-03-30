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
import com.example.service.SupportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class GenderController {
	
	private final  GenderService genderService;
	
	@GetMapping("genders/{id}")
	public ResponseEntity<Gender> getById(@PathVariable Long id) {
		return new ResponseEntity<Gender>(genderService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("genders")
	public ResponseEntity<List<Gender>> getAll() {
		return new ResponseEntity<List<Gender>>(genderService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("genders/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		genderService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("genders/{id}")
	public ResponseEntity<Gender> updateById(@PathVariable Long id, @RequestBody Gender item) {
		return new ResponseEntity<Gender>(genderService.update(id, item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("genders")
	public ResponseEntity<Gender> save(@RequestBody Gender item) {
		return new ResponseEntity<Gender>(genderService.save(item), HttpStatusCode.valueOf(201));
	}

}

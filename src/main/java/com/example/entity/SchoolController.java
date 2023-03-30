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
import com.example.service.SchoolService;
import com.example.service.SupportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class SchoolController {
	
	private final  SchoolService itemService;
	
	@GetMapping("schools/{id}")
	public ResponseEntity<School> getById(@PathVariable Long id) {
		return new ResponseEntity<School>(itemService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("schools")
	public ResponseEntity<List<School>> getAll() {
		return new ResponseEntity<List<School>>(itemService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("schools/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("schools/{id}")
	public ResponseEntity<School> updateById(@PathVariable Long id, @RequestBody School item) {
		return new ResponseEntity<School>(itemService.update(id, item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("schools")
	public ResponseEntity<School> save(@RequestBody School item) {
		return new ResponseEntity<School>(itemService.save(item), HttpStatusCode.valueOf(201));
	}

}

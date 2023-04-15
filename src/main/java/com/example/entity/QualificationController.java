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
import com.example.service.QualificationService;
import com.example.service.SupportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class QualificationController {
	
	private final  QualificationService itemService;
	
	@GetMapping("qualifications/{id}")
	public ResponseEntity<Qualification> getById(@PathVariable Long id) {
		return new ResponseEntity<Qualification>(itemService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("qualifications")
	public ResponseEntity<List<Qualification>> getAll() {
		return new ResponseEntity<List<Qualification>>(itemService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("qualifications/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("qualifications/{id}")
	public ResponseEntity<Qualification> updateById(@PathVariable Long id, @RequestBody Qualification item) {
		return new ResponseEntity<Qualification>(itemService.update(id, item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("qualifications")
	public ResponseEntity<Qualification> save(@RequestBody Qualification item) {
		return new ResponseEntity<Qualification>(itemService.save(item), HttpStatusCode.valueOf(201));
	}

}

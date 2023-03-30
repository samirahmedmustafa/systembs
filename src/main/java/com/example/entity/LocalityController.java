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
import com.example.service.ConditionService;
import com.example.service.DiseaseService;
import com.example.service.GasService;
import com.example.service.GenderService;
import com.example.service.LocalityService;
import com.example.service.LocationService;
import com.example.service.NationalityService;
import com.example.service.NeighbourhoodService;
import com.example.service.ProfessionService;
import com.example.service.SupportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class LocalityController {
	
	private final LocalityService itemService;
	
	@GetMapping("localities/{id}")
	public ResponseEntity<Locality> getById(@PathVariable Long id) {
		return new ResponseEntity<Locality>(itemService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("localities")
	public ResponseEntity<List<Locality>> getAll() {
		return new ResponseEntity<List<Locality>>(itemService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("localities/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("localities/{id}")
	public ResponseEntity<Locality> updateById(@RequestBody Locality item) {
		return new ResponseEntity<Locality>(itemService.update(item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("localities")
	public ResponseEntity<Locality> save(@RequestBody Locality item) {
		return new ResponseEntity<Locality>(itemService.save(item), HttpStatusCode.valueOf(201));
	}

}

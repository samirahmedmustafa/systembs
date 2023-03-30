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
import com.example.service.LocationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class DiseaseController {
	
	private final DiseaseService diseaseService;
	
	@GetMapping("diseases/{id}")
	public ResponseEntity<Disease> getById(@PathVariable Long id) {
		return new ResponseEntity<Disease>(diseaseService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("diseases")
	public ResponseEntity<List<Disease>> getAll() {
		return new ResponseEntity<List<Disease>>(diseaseService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("diseases/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		diseaseService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("diseases/{id}")
	public ResponseEntity<Disease> updateById(@PathVariable Long id, @RequestBody Disease item) {
		return new ResponseEntity<Disease>(diseaseService.update(id, item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("diseases")
	public ResponseEntity<Disease> save(@RequestBody Disease item) {
		return new ResponseEntity<Disease>(diseaseService.save(item), HttpStatusCode.valueOf(201));
	}

}

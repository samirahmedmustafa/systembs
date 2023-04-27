package com.example.entity;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CitizensService;
import com.example.service.LocationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class CitizensController {
	
	private static final Logger logger = LoggerFactory.getLogger(CitizensController.class);
	private final CitizensService citizensService;
	
	@GetMapping("citizens/{id}")
	public ResponseEntity<Citizens> getById(@PathVariable Long id) {
		
		Citizens citizen = citizensService.getById(id);
//		citizen.getWives().forEach((data) -> System.out.println("getWives: " + data));
//		logger.warn("citizen.getName():{}", citizen.getName());
//		logger.warn("citizen.getMedicines():{}", citizen.getMedicines());
//		logger.warn("citizen.getSupports():{}", citizen.getSupports());
		return new ResponseEntity<Citizens>(citizen, HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("citizens/custom")
	public ResponseEntity<List<Object[]>> getAllCustom() {
		return new ResponseEntity<List<Object[]>>(citizensService.getAllCustom(), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("citizens")
	public ResponseEntity<List<Citizens>> getAll() {
		return new ResponseEntity<List<Citizens>>(citizensService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("citizens/byGender")
	public ResponseEntity<List<Citizens>> findByGender(@RequestParam String gender) {
		return new ResponseEntity<List<Citizens>>(citizensService.findByGender(gender), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("citizens/byFemale")
	public ResponseEntity<List<Citizens>> findByFemale() {
		return new ResponseEntity<List<Citizens>>(citizensService.findByFemale(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("citizens/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		citizensService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("citizens/{id}")
	public ResponseEntity<Citizens> updateById(@PathVariable Long id, @RequestBody Citizens item) {
		return new ResponseEntity<Citizens>(citizensService.update(id, item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("citizens")
	public ResponseEntity<Citizens> save(@RequestBody Citizens item) {
		return new ResponseEntity<Citizens>(citizensService.save(item), HttpStatusCode.valueOf(201));
	}

}

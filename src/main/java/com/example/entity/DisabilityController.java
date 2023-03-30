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

import com.example.service.BuildingTypeService;
import com.example.service.CitizensService;
import com.example.service.DisabilityService;
import com.example.service.DiseaseService;
import com.example.service.GenderService;
import com.example.service.LocationService;
import com.example.service.MedicineService;
import com.example.service.SupportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class DisabilityController {
	
	private final DisabilityService disabilityService;
	
	@GetMapping("disabilities/{id}")
	public ResponseEntity<Disability> getById(@PathVariable Long id) {
		return new ResponseEntity<Disability>(disabilityService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("disabilities")
	public ResponseEntity<List<Disability>> getAll() {
		return new ResponseEntity<List<Disability>>(disabilityService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("disabilities/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		disabilityService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("disabilities/{id}")
	public ResponseEntity<Disability> updateById(@PathVariable Long id, @RequestBody Disability item) {
		return new ResponseEntity<Disability>(disabilityService.update(id, item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("disabilities")
	public ResponseEntity<Disability> save(@RequestBody Disability item) {
		return new ResponseEntity<Disability>(disabilityService.save(item), HttpStatusCode.valueOf(201));
	}

}
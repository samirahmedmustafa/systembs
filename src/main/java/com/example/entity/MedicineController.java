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
import com.example.service.MedicineService;
import com.example.service.SupportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MedicineController {
	
	private final MedicineService medicineService;
	
	@GetMapping("medicines/{id}")
	public ResponseEntity<Medicine> getById(@PathVariable Long id) {
		return new ResponseEntity<Medicine>(medicineService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("medicines")
	public ResponseEntity<List<Medicine>> getAll() {
		return new ResponseEntity<List<Medicine>>(medicineService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("medicines/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		medicineService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("medicines/{id}")
	public ResponseEntity<Medicine> updateById(@RequestBody Medicine item) {
		return new ResponseEntity<Medicine>(medicineService.update(item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("medicines")
	public ResponseEntity<Medicine> save(@RequestBody Medicine item) {
		return new ResponseEntity<Medicine>(medicineService.save(item), HttpStatusCode.valueOf(201));
	}

}

package com.example.entity;

import java.util.List;
import java.util.NoSuchElementException;

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
import com.example.service.CityService;
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
public class CityController {
	
	private final CityService itemService;
	
	@GetMapping("cities/{id}")
	public ResponseEntity<City> getById(@PathVariable Long id) throws Exception {
		return new ResponseEntity<City>(itemService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("cities")
	public ResponseEntity<List<City>> getAll() {
		return new ResponseEntity<List<City>>(itemService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("cities/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("cities/{id}")
	public ResponseEntity<City> updateById(@PathVariable Long id, @RequestBody City item) {
		return new ResponseEntity<City>(itemService.update(id, item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("cities")
	public ResponseEntity<City> save(@RequestBody City item) {
		return new ResponseEntity<City>(itemService.save(item), HttpStatusCode.valueOf(201));
	}

}

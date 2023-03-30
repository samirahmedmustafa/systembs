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

import com.example.service.LocationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class LocationController {
	
	private final LocationService locationService;
	
	@GetMapping("locations/{id}")
	public ResponseEntity<Location> getById(@PathVariable Long id) {
		return new ResponseEntity<Location>(locationService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("locations")
	public ResponseEntity<List<Location>> getAll() {
		return new ResponseEntity<List<Location>>(locationService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("locations/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		locationService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("locations/{id}")
	public ResponseEntity<Location> updateById(@PathVariable Long id, @RequestBody Location location) {
		return new ResponseEntity<Location>(locationService.update(id, location), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("locations")
	public ResponseEntity<Location> save(@RequestBody Location location) {
		return new ResponseEntity<Location>(locationService.save(location), HttpStatusCode.valueOf(201));
	}

}

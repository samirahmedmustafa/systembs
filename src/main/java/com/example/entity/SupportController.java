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
import com.example.service.SupportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class SupportController {
	
	private final SupportService supportService;
	
	@GetMapping("supports/{id}")
	public ResponseEntity<Support> getById(@PathVariable Long id) {
		return new ResponseEntity<Support>(supportService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("supports")
	public ResponseEntity<List<Support>> getAll() {
		return new ResponseEntity<List<Support>>(supportService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("supports/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		supportService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("supports/{id}")
	public ResponseEntity<Support> updateById(@PathVariable Long id, @RequestBody Support item) {
		return new ResponseEntity<Support>(supportService.update(id, item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("supports")
	public ResponseEntity<Support> save(@RequestBody Support item) {
		return new ResponseEntity<Support>(supportService.save(item), HttpStatusCode.valueOf(201));
	}

}

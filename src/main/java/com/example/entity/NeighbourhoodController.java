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
public class NeighbourhoodController {
	
	private final NeighbourhoodService itemService;
	
	@GetMapping("neighbourhoods/{id}")
	public ResponseEntity<Neighbourhood> getById(@PathVariable Long id) {
		return new ResponseEntity<Neighbourhood>(itemService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("neighbourhoods")
	public ResponseEntity<List<Neighbourhood>> getAll() {
		return new ResponseEntity<List<Neighbourhood>>(itemService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("neighbourhoods/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("neighbourhoods/{id}")
	public ResponseEntity<Neighbourhood> updateById(@RequestBody Neighbourhood item) {
		return new ResponseEntity<Neighbourhood>(itemService.update(item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("neighbourhoods")
	public ResponseEntity<Neighbourhood> save(@RequestBody Neighbourhood item) {
		return new ResponseEntity<Neighbourhood>(itemService.save(item), HttpStatusCode.valueOf(201));
	}

}

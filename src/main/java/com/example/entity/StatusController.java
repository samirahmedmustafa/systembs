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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.NotFoundException;
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
import com.example.service.StateService;
import com.example.service.StatusService;
import com.example.service.SupportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class StatusController {
	
	private final StatusService itemService;
	
	@GetMapping("statuses/{id}")
	public ResponseEntity<Status> getById(@PathVariable Long id) throws Exception {
		return new ResponseEntity<Status>(itemService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("statuses/byName")
	public ResponseEntity<Status> getByName(@RequestParam String name) throws Exception {
		return new ResponseEntity<Status>(itemService.getByName(name), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("statuses")
	public ResponseEntity<List<Status>> getAll() {
		return new ResponseEntity<List<Status>>(itemService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("statuses/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("statuses/{id}")
	public ResponseEntity<Status> updateById(@PathVariable Long id, @RequestBody Status item) throws Exception {
		return new ResponseEntity<Status>(itemService.update(id, item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("statuses")
	public ResponseEntity<Status> save(@RequestBody Status item) throws Exception {
		return new ResponseEntity<Status>(itemService.save(item), HttpStatusCode.valueOf(201));
	}

}

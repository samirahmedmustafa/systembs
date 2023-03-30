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
import com.example.service.ProfessionService;
import com.example.service.SupportService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ConditionController {
	
	private final ConditionService itemService;
	
	@GetMapping("conditions/{id}")
	public ResponseEntity<Condition> getById(@PathVariable Long id) {
		return new ResponseEntity<Condition>(itemService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("conditions")
	public ResponseEntity<List<Condition>> getAll() {
		return new ResponseEntity<List<Condition>>(itemService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("conditions/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("conditions/{id}")
	public ResponseEntity<Condition> updateById(@PathVariable Long id, @RequestBody Condition item) {
		return new ResponseEntity<Condition>(itemService.update(id, item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("conditions")
	public ResponseEntity<Condition> save(@RequestBody Condition item) {
		return new ResponseEntity<Condition>(itemService.save(item), HttpStatusCode.valueOf(201));
	}

}

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
public class GasController {
	
	private final GasService itemService;
	
	@GetMapping("gases/{id}")
	public ResponseEntity<Gas> getById(@PathVariable Long id) {
		return new ResponseEntity<Gas>(itemService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("gases")
	public ResponseEntity<List<Gas>> getAll() {
		return new ResponseEntity<List<Gas>>(itemService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("gases/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		itemService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("gases/{id}")
	public ResponseEntity<Gas> updateById(@PathVariable Long id, @RequestBody Gas item) {
		return new ResponseEntity<Gas>(itemService.update(id, item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("gases")
	public ResponseEntity<Gas> save(@RequestBody Gas item) {
		return new ResponseEntity<Gas>(itemService.save(item), HttpStatusCode.valueOf(201));
	}

}

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
public class BuildingTypeController {
	
	private final BuildingTypeService buildingTypeService;
	
	@GetMapping("buildingTypes/{id}")
	public ResponseEntity<BuildingType> getById(@PathVariable Long id) {
		return new ResponseEntity<BuildingType>(buildingTypeService.getById(id), HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("buildingTypes")
	public ResponseEntity<List<BuildingType>> getAll() {
		return new ResponseEntity<List<BuildingType>>(buildingTypeService.getAll(), HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("buildingTypes/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		buildingTypeService.deleteItemById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("buildingTypes/{id}")
	public ResponseEntity<BuildingType> updateById(@RequestBody BuildingType item) {
		return new ResponseEntity<BuildingType>(buildingTypeService.update(item), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("buildingTypes")
	public ResponseEntity<BuildingType> save(@RequestBody BuildingType item) {
		return new ResponseEntity<BuildingType>(buildingTypeService.save(item), HttpStatusCode.valueOf(201));
	}

}

package dev.perso.mealmanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.perso.mealmanager.entities.Aliment;
import dev.perso.mealmanager.entities.Meal;
import dev.perso.mealmanager.repository.AlimentRepository;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class AlimentController {

	private Logger logger = LoggerFactory.getLogger(MealController.class);
	
	@Autowired
	private AlimentRepository alimentRepository;
	
	@GetMapping("/aliments")
	public ResponseEntity<Object> getAllAliments(){
		try {
			Iterable<Aliment> aliments = alimentRepository.findAll();
			
			return new ResponseEntity<Object>(aliments, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}

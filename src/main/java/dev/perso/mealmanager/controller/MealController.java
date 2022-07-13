package dev.perso.mealmanager.controller;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.perso.mealmanager.entities.Aliment;
import dev.perso.mealmanager.entities.Meal;
import dev.perso.mealmanager.repository.AlimentRepository;
import dev.perso.mealmanager.repository.MealRepository;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class MealController {

	private Logger logger = LoggerFactory.getLogger(MealController.class);
	
	@Autowired
	private MealRepository mealRepository;
	
	@Autowired
	private AlimentRepository alimentRepository;
	
	@GetMapping("/meals")
	public ResponseEntity<Object> getAllMeals(){
		try {
			Iterable<Meal> meals = mealRepository.findAll();
//			for(Meal meal : meals) {
//				List<Aliment> alimentsList = alimentRepository.getAlimentByMealId(meal.getId());
//				meal.setAlimentsList(alimentsList);
//			}
//			System.out.println(meals);
			
			return new ResponseEntity<Object>(meals, HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/meals/{id}")
	public ResponseEntity<Object> getMealById(@PathVariable("id") Long id){
		try {
			Meal meal = mealRepository.findById(id).get();
			if (meal != null) {
				return new ResponseEntity<Object>(meal, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}

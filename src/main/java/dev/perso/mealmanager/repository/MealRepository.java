package dev.perso.mealmanager.repository;

import org.springframework.data.repository.CrudRepository;

import dev.perso.mealmanager.entities.Meal;

public interface MealRepository extends CrudRepository<Meal, Long>{

}

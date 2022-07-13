package dev.perso.mealmanager.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.perso.mealmanager.entities.Aliment;

public interface AlimentRepository extends CrudRepository<Aliment, Long> {
//	public List<Aliment> getAlimentByMealId(Long mealId);
}

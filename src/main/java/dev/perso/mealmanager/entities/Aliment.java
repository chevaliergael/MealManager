package dev.perso.mealmanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aliments")
public class Aliment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	
//	@ManyToOne(optional = false)
//	@JoinColumn(name = "meal_id", nullable = false, referencedColumnName = "id")
//	private Meal meal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//
//	public Meal getMeal() {
//		return meal;
//	}
//
//	public void setMeal(Meal meal) {
//		this.meal = meal;
//	}
//	
}

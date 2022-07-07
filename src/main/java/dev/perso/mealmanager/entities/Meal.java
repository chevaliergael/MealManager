package dev.perso.mealmanager.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meals")
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "meal_date")
	private LocalDate mealDate;
	
	@Column(name = "meal_time")
	private LocalTime mealTime;

	@OneToMany(mappedBy = "meals", cascade = CascadeType.ALL)
	private List<Aliment> alimentsList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getMealDate() {
		return mealDate;
	}

	public void setMealDate(LocalDate mealDate) {
		this.mealDate = mealDate;
	}

	public LocalTime getMealTime() {
		return mealTime;
	}

	public void setMealTime(LocalTime mealTime) {
		this.mealTime = mealTime;
	}

	public List<Aliment> getAlimentsList() {
		return alimentsList;
	}

	public void setAlimentsList(List<Aliment> alimentsList) {
		this.alimentsList = alimentsList;
	}
	
	
}

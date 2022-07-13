package dev.perso.mealmanager.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meals")
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "meal_date")
	private LocalDate mealDate;
	
	@Column(name = "meal_time")
	private LocalTime mealTime;

//	@OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
//	private List<Aliment> alimentsList = new ArrayList<Aliment>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="meal_id")
	private List<Aliment> alimentsList = new ArrayList<Aliment>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

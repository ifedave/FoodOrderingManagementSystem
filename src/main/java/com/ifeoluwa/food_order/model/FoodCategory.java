package com.ifeoluwa.food_order.model;

import javax.persistence.*;

@Entity
@Table(name = "food_categories")
public class FoodCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String category_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return category_name;
	}

	public void setCategoryName(String category_name) {
		this.category_name = category_name;
	}
}
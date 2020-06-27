package com.ifeoluwa.food_order.repository;

import com.ifeoluwa.food_order.model.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Integer> {
}

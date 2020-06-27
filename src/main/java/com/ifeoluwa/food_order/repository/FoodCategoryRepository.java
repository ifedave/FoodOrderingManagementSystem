package com.ifeoluwa.food_order.repository;

import com.ifeoluwa.food_order.model.Authorities;
import com.ifeoluwa.food_order.model.FoodCategory;
import org.springframework.data.repository.CrudRepository;

public interface FoodCategoryRepository extends CrudRepository<FoodCategory, Integer> {
}

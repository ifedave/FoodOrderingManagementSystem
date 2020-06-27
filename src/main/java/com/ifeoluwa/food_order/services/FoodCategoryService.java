package com.ifeoluwa.food_order.services;

import com.ifeoluwa.food_order.model.Authorities;
import com.ifeoluwa.food_order.model.FoodCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodCategoryService {
    List<FoodCategory> getAllCategories();
}

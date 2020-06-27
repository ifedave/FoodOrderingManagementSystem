package com.ifeoluwa.food_order.services;

import com.ifeoluwa.food_order.model.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {

    Food addFood(Food food);
    Food updateFood(Food food);
    List<Food> getAllFoods();
    List<Food> getAllFoodsByCategory(String category);
    void deleteFood(int id);
    Food getFoodById(int id);
}

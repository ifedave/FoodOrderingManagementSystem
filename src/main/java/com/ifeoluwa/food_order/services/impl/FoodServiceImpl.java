package com.ifeoluwa.food_order.services.impl;

import com.ifeoluwa.food_order.model.Food;
import com.ifeoluwa.food_order.model.Image;
import com.ifeoluwa.food_order.repository.FoodRepository;
import com.ifeoluwa.food_order.repository.ImageRepository;
import com.ifeoluwa.food_order.services.FoodService;
import com.ifeoluwa.food_order.services.FoodService;
import com.ifeoluwa.food_order.utils.PasswordEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Food addFood(Food food) {
        if(food.getFoodImages()!=null && food.getFoodImages().size()>0) {
            List<Image> savedImages = new ArrayList<>();
            imageRepository.saveAll(food.getFoodImages()).forEach(savedImages::add);
            food.setFoodImages(savedImages);
        }
        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(Food food) {
        if(food.getFoodImages()!=null && food.getFoodImages().size()>0) {
            List<Image> savedImages = new ArrayList<>();
            imageRepository.saveAll(food.getFoodImages()).forEach(savedImages::add);
            food.setFoodImages(savedImages);
        }
        return foodRepository.save(food);
    }


    @Override
    public List<Food> getAllFoods() {
        List<Food> foods= new ArrayList<>();
        foodRepository.findAll().forEach(foods::add);
        return  foods;
    }

    @Override
    public List<Food> getAllFoodsByCategory(String category) {
        List<Food> foods= new ArrayList<>();
        foodRepository.findAll().forEach(foods::add);
        List<Food> filtered_foods=foods
                .stream()
                .filter(food -> food.getCategory().getCategoryName().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        return  filtered_foods;
    }

    @Override
    public void deleteFood(int id) {
        foodRepository.deleteById(id);
    }

    @Override
    public Food getFoodById(int id) {
        return foodRepository.findById(id).orElse(null);
    }

}

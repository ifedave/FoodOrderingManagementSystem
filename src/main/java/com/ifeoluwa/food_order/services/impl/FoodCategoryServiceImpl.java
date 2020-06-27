package com.ifeoluwa.food_order.services.impl;

import com.ifeoluwa.food_order.model.Authorities;
import com.ifeoluwa.food_order.model.FoodCategory;
import com.ifeoluwa.food_order.repository.AuthorityRepository;
import com.ifeoluwa.food_order.repository.FoodCategoryRepository;
import com.ifeoluwa.food_order.services.AuthorityService;
import com.ifeoluwa.food_order.services.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Override
    public List<FoodCategory> getAllCategories() {
        List<FoodCategory> categories= new ArrayList<>();
        foodCategoryRepository.findAll().forEach(categories::add);
        return categories;
    }
}

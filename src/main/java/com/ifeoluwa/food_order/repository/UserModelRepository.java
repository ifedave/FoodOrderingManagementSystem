package com.ifeoluwa.food_order.repository;

import com.ifeoluwa.food_order.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserModelRepository extends CrudRepository<UserModel, Integer> {

    UserModel findByEmail(String email);
}

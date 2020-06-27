package com.ifeoluwa.food_order.services;

import com.ifeoluwa.food_order.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserModelService {

    UserModel addUser(UserModel userModel);
    UserModel updateUser(UserModel userModel);
    UserModel getUserByEmail(String email);
    List<UserModel> getAllUsers();
    List<UserModel> getAllUsersByRole(String role);
    void deleteUser(int id);
    boolean changePassword(String newPassword, UserModel user);

}

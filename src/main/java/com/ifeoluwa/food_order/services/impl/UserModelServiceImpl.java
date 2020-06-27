package com.ifeoluwa.food_order.services.impl;

import com.ifeoluwa.food_order.model.UserModel;
import com.ifeoluwa.food_order.repository.UserModelRepository;
import com.ifeoluwa.food_order.services.UserModelService;
import com.ifeoluwa.food_order.utils.PasswordEncode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserModelServiceImpl implements UserModelService {

    BCryptPasswordEncoder bCryptPasswordEncoder = PasswordEncode.encode();

    @Autowired
    private UserModelRepository userModelRepository;

    @Override
    public UserModel addUser(UserModel userModel) {
        String encoded=new BCryptPasswordEncoder().encode(userModel.getPassword());
        userModel.setPassword(encoded);
        return userModelRepository.save(userModel);
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        return userModelRepository.save(userModel);
    }

    @Override
    public UserModel getUserByEmail(String email) {
        return userModelRepository.findByEmail(email);
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> users= new ArrayList<>();
        userModelRepository.findAll().forEach(users::add);
        return  users;
    }

    @Override
    public List<UserModel> getAllUsersByRole(String role) {
        List<UserModel> users= new ArrayList<>();
        userModelRepository.findAll().forEach(users::add);
        List<UserModel> filtered_users=users
                .stream()
                .filter(user -> user.getAuthority().getAuthorityName().equalsIgnoreCase(role))
                .collect(Collectors.toList());
        return  filtered_users;
    }

    @Override
    public void deleteUser(int id) {
        userModelRepository.deleteById(id);
    }

    @Override
    public boolean changePassword(String newPassword, UserModel user) {
        return false;
    }
}

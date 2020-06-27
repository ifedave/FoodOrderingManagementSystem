package com.ifeoluwa.food_order.services.impl;

import com.ifeoluwa.food_order.model.Authorities;
import com.ifeoluwa.food_order.repository.AuthorityRepository;
import com.ifeoluwa.food_order.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<Authorities> getAllAuthorties() {
        List<Authorities> authorities= new ArrayList<>();
        authorityRepository.findAll().forEach(authorities::add);
        return authorities;
    }
}

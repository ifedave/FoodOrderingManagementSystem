package com.ifeoluwa.food_order.services;

import com.ifeoluwa.food_order.model.Authorities;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorityService {
    List<Authorities> getAllAuthorties();
}

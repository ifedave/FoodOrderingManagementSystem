package com.ifeoluwa.food_order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    @GetMapping(path = "")
    public String index(){
        return "customer/index";
    }

}

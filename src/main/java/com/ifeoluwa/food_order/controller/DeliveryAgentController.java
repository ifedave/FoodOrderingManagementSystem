package com.ifeoluwa.food_order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/delivery_agent")
public class DeliveryAgentController {

    @GetMapping(path = "")
    public String index(){
        return "delivery_agent/index";
    }

}

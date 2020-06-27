package com.ifeoluwa.food_order.controller;

import com.ifeoluwa.food_order.model.Authorities;
import com.ifeoluwa.food_order.model.Food;
import com.ifeoluwa.food_order.model.UserModel;
import com.ifeoluwa.food_order.services.AuthorityService;
import com.ifeoluwa.food_order.services.FoodService;
import com.ifeoluwa.food_order.services.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private UserModelService userModelService;

    @Autowired
    private FoodService foodService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping(path = "/")
    public String index(){
        return "index";
    }

    @GetMapping(path = "/about")
    public String about(){
        return "about";
    }

    @GetMapping(path = "/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping(path = "/services")
    public String services(){
        return "services";
    }

    @GetMapping(path = "/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping(path = "/register")
    public String registerPage(Model model){

        model.addAttribute("user", new UserModel());
        return "register";
    }

    @PostMapping(path = "/register")
    public String registerUser(@ModelAttribute @Valid UserModel user, BindingResult result){

        if (result.hasErrors()) {
            return "register";
        }
        //check if user is trying to register as admin, if yes
        if(user.getAuthority().getId()==1){
            user.setAuthority(authorityService.getAllAuthorties().get(1));
        }

        user=userModelService.addUser(user);
        return "login";
    }

//    @PostMapping(path = "/register")
//    public String registerUser(@ModelAttribute UserModel user){
//
////        Authorities authorities=authorityService.getAllAuthorties().get(1);
////        user.setAuthority(authorities);
//        user=userModelService.addUser(user);
//        return "login";
//    }

    /**
     * It will execute for all the request mappings
     * @return Authority list
     * */
    @ModelAttribute("role")
    public List<Authorities> list(){
        List<Authorities> authorities=authorityService.getAllAuthorties();
        return authorities.subList(1, authorities.size());

    }

    /**
     * It will execute for all the request mappings
     * @return Authority list
     * */
    @ModelAttribute("all_roles")
    public List<Authorities> listAllRoles(){
        return authorityService.getAllAuthorties();
    }

    /**
     * It will execute for all the request mappings
     * @return Authority list
     * */
    @ModelAttribute("all_foods")
    public List<Food> listAllFoods(){
        return foodService.getAllFoods();
    }
}

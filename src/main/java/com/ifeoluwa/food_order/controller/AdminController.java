package com.ifeoluwa.food_order.controller;

import com.ifeoluwa.food_order.model.Authorities;
import com.ifeoluwa.food_order.model.Food;
import com.ifeoluwa.food_order.model.FoodCategory;
import com.ifeoluwa.food_order.model.Image;
import com.ifeoluwa.food_order.services.FoodCategoryService;
import com.ifeoluwa.food_order.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    @Value("${files_uploading_directory}")
    public String uploadingDir ;


    @Autowired
    private FoodCategoryService foodCategoryService;
    @Autowired
    private FoodService foodService;
    @GetMapping(path = "")
    public String index(){
    return "admin/index";
    }

    @GetMapping(path = "/add_food")
    public String addFood(Model model)
    {
        model.addAttribute("food", new Food());
        model.addAttribute("isNewFood",true);
        model.addAttribute("btn_text","Add Food");

        return "admin/add_food";
    }

    @GetMapping(path = "/edit")
    public String updateFood(@RequestParam int id, Model model)
    {
        Food food=foodService.getFoodById(id);
        if(food==null) return "redirect:/";

        model.addAttribute("food", food);
        model.addAttribute("isNewFood",false);
        model.addAttribute("btn_text","Update Food");

        return "admin/add_food";
    }

    @GetMapping(path = "/view")
    public String viewFood(@RequestParam int id, Model model)
    {
        Food food=foodService.getFoodById(id);
        if(food==null) return "redirect:/";

        model.addAttribute("food", food);
        return "admin/view_food";
    }

//    @PostMapping(path = "/add_food")
//    public String saveFood(@ModelAttribute @Valid Food food,  Model model, @RequestParam("Food_Images") MultipartFile[] FoodImages) throws IOException {
//        List<Image> images= new ArrayList<>();
//        for(MultipartFile uploadedFile : FoodImages) {
//            if(uploadedFile.getOriginalFilename().isEmpty()){
//                continue;
//            }
//            String fileName = StringUtils.cleanPath(uploadedFile.getOriginalFilename());
//            Path path = Paths.get(uploadingDir + fileName);
//            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                    .path("/files/download/")
//                    .path(fileName)
//                    .toUriString();
//
//            File file = new File(uploadingDir + uploadedFile.getOriginalFilename());
//            Image image= new Image(food.getFood_name(), food.getDescription(), fileDownloadUri);
//            images.add(image);
//            try {
//                uploadedFile.transferTo(file);
//            }catch (Exception e){}
//        }
//
//
//        food.setFoodImages(images);
//        foodService.addFood(food);
//        model.addAttribute("food", new Food());
//        return "redirect:/admin";
//    }

    @PostMapping(path = "/add_food")
    public String saveFood(@ModelAttribute @Valid Food food,  Model model, @RequestParam("Food_Images") MultipartFile[] FoodImages) throws IOException {
        List<Image> images= new ArrayList<>();
        for(MultipartFile uploadedFile : FoodImages) {
            if(uploadedFile.getOriginalFilename().isEmpty()){
                continue;
            }
            String fileName =  System.currentTimeMillis()+"_"+StringUtils.cleanPath(uploadedFile.getOriginalFilename());
            Path path = Paths.get(uploadingDir + fileName);
            try {
                Files.copy(uploadedFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/files/download/")
                    .path(fileName)
                    .toUriString();

            Image image= new Image(food.getFood_name(), food.getDescription(), fileDownloadUri);
            images.add(image);

        }


        food.setFoodImages(images);
        foodService.addFood(food);
        model.addAttribute("food", new Food());
        return "redirect:/admin";
    }


    @PostMapping(path = "/update_food")
    public String updateFood(@ModelAttribute @Valid Food food,  Model model, @RequestParam("Food_Images") MultipartFile[] FoodImages) throws IOException {
        List<Image> images= new ArrayList<>();
        for(MultipartFile uploadedFile : FoodImages) {
            if(uploadedFile.getOriginalFilename().isEmpty()){
                continue;
            }
            String fileName =  System.currentTimeMillis()+"_"+StringUtils.cleanPath(uploadedFile.getOriginalFilename());
            Path path = Paths.get(uploadingDir +fileName);
            try {
                Files.copy(uploadedFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/files/download/")
                    .path(fileName)
                    .toUriString();

            Image image= new Image(food.getFood_name(), food.getDescription(), fileDownloadUri);
            images.add(image);

        }

        food.setFoodImages(images);
        foodService.updateFood(food);
        //model.addAttribute("food", new Food());
        return "redirect:/admin/foods/";
    }

    @GetMapping(path = "/foods")
    public String foodList(Model model)
    {
        model.addAttribute("fooditem", foodService.getAllFoods());
        return "admin/foods";
    }

    /**
     * It will execute for all the request mappings
     * @return FoodCategory list
     * */
    @ModelAttribute("food_categories")
    public List<FoodCategory> listAllRoles(){
        return foodCategoryService.getAllCategories();
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

package com.ifeoluwa.food_order.services.impl;

import com.ifeoluwa.food_order.model.Image;
import com.ifeoluwa.food_order.repository.ImageRepository;
import com.ifeoluwa.food_order.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image updateImage(Image image) {
        return imageRepository.save(image);
    }


    @Override
    public List<Image> getAllImages() {
        List<Image> images= new ArrayList<>();
        imageRepository.findAll().forEach(images::add);
        return  images;
    }


    @Override
    public void deleteImage(int id) {
        imageRepository.deleteById(id);
    }

}

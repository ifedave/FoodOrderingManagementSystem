package com.ifeoluwa.food_order.services;

import com.ifeoluwa.food_order.model.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {

    Image addImage(Image image);
    Image updateImage(Image image);
    List<Image> getAllImages();
    void deleteImage(int id);

}

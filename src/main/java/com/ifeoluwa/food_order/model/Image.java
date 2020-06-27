package com.ifeoluwa.food_order.model;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String image_location;

    public Image() {
    }

    public Image(String title, String description, String image_location) {
        this.title = title;
        this.description = description;
        this.image_location = image_location;
    }
    public Image(Integer id, String title, String description, String image_location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image_location = image_location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_location() {
        return image_location;
    }

    public void setImage_location(String image_location) {
        this.image_location = image_location;
    }
}

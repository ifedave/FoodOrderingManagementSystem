
package com.ifeoluwa.food_order.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer food_id;
    @Column
    private String food_name;
    @Column
    private String description;
    @Column
    private double price;
    @Column
    private double discounted_price;
    @Column
    private boolean discount;
    @OneToOne
    private FoodCategory category;
    @OneToMany
    private List<Image> foodImages;
    @Column
    private double rating;

    public Food() {
    }

    public Food(Integer food_id, String food_name, String description, double price, double discounted_price, boolean discount, List<Image> foodImages, double rating) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.description = description;
        this.price = price;
        this.discounted_price = discounted_price;
        this.discount = discount;
        this.foodImages = foodImages;
        this.rating = rating;
    }

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(double discounted_price) {
        this.discounted_price = discounted_price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public List<Image> getFoodImages() {
        return foodImages;
    }

    public void setFoodImages(List<Image> foodImages) {
        this.foodImages = foodImages;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }
}

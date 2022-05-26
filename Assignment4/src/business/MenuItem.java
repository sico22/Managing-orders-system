package business;

import java.io.Serializable;

/**
 * This class implements serializable and is a superclass of both base product and composite product
 */
public abstract class MenuItem implements Serializable {
    protected int id;
    protected String title;
    protected double rating;
    protected double calories;
    protected double protein;
    protected double fat;
    protected double sodium;
    protected double price;
    protected int noOrders = 0;

    public int getNoOrders() {
        return noOrders;
    }

    public void setNoOrders(int noOrders) {
        this.noOrders = noOrders;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getSodium() {
        return sodium;
    }

    public double getPrice() {
        return price;
    }

    public abstract void computeAttributes();
}

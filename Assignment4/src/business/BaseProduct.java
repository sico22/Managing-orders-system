package business;

/**
 * @author Alexandra Maria Sicobean
 *
 * This class is used to represent base products. These products are simple items from the menu that will we further used to obtain composed products.
 */

public class BaseProduct extends MenuItem{

    public BaseProduct() {

    }

    public BaseProduct(int id, String title, double rating, double calories, double protein, double fat, double sodium, double price) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }


    @Override
    public void computeAttributes() {

    }
}

package business;

import java.util.ArrayList;

/**
 * @author Alexandra Maria Sicobean
 *
 * This class is used to represent products composed using base products. It is a subclass of the superclass MenuItem who also has as subclass class BaseProduct.
 *
 */

public class CompositeProduct extends MenuItem{
    private ArrayList<MenuItem> baseProductsList;

    public CompositeProduct(String title){
        this.calories = 0;
        this.fat = 0;
        this.price = 0;
        this.protein = 0;
        this.rating = 0;
        this.sodium = 0;
        this.title = title;

        this.baseProductsList = new ArrayList<>();
    }

    public void addToBaseProductList(MenuItem baseProduct){
        this.baseProductsList.add(baseProduct);
    }

    /**
     * This method is used to compute the main attributes od the composed product. It calculates the average rating, as well as the total price, calories, fat, sodium, protein and  of the newly created product.
     */
    @Override
    public void computeAttributes() {
        for(MenuItem p : baseProductsList){
            this.calories += p.calories;
            this.fat += p.fat;
            this.sodium += p.sodium;
            this.protein += p.protein;
            this.rating += p.rating;
            this.price += p.price;
        }

        this.rating = this.rating / baseProductsList.size();
    }
}

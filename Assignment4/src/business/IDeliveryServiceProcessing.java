package business;

import javax.swing.table.DefaultTableModel;
import java.util.HashMap;

public interface IDeliveryServiceProcessing {

    /**
     * This method imports all items from the menu stored in the "products.csv" file
     * @return model for the updated table
     */
    public DefaultTableModel importProducts();

    /**
     * This method allows an Admin to add a new base product to the list of products
     *<pre>
     *"The precondition verifies that the base product has been provided"
     *<b>Precondition:</b> "base product is not null exists"
     *</pre>
     * @param baseProduct
     * @return model for the updated table
     */
    public DefaultTableModel addBaseProduct(BaseProduct baseProduct);

    /**
     * This method allows an Admin to delete a new base product from the list of products
     *<pre>
     *"The precondition verifies that the base product has been provided"
     *<b>Precondition:</b> "base product is not null exists"
     *</pre>
     * @param title
     * @return model for the updated table
     */
    public DefaultTableModel deleteProduct(String title);


    /**
     * This method allows an Admin to modify a new base product from the list of products
     *<pre>
     *"The precondition verifies that the base product has been provided"
     *<b>Precondition:</b> "base product is not null exists"
     *</pre>
     * @param baseProduct
     * @return model for the updated table
     */
    public DefaultTableModel modifyProduct(BaseProduct baseProduct);

    /**
     * This method allows an Admin to add a base product to a composite product
     * @param baseProductTitle
     */
    public void addToCompositeArrayList(String baseProductTitle);

    /**
     * This method allows an Admin to add a composite product to the list of products
     * @param title
     */
    public void addCompositeProduct(String title);

        /**
         * This method allows a Client to search a new base product in the list of products
         *<pre>
         *"The precondition verifies that the title for the product has been provided"
         *<b>Precondition:</b> "base product is not null exists"
         *</pre>
         * @param title title of a menu item
         * @param rating rating of a menu item
         * @param calories calories of a menu item
         * @param protein protein of a menu item
         * @param fat fat of a menu item
         * @param sodium sodium of a menu item
         * @param price price of a menu item
         * @return model for the updated table
         */
    public DefaultTableModel searchProduct(String title, double rating, double calories, double protein, double fat, double sodium, double price);

    /**
     * This method allows the Client to prepare a new order
     *<pre>
     *"The precondition verifies that the base product has been provided"
     *<b>Precondition:</b> "base product is not null exists"
     *</pre>
     * @param clientId client id of a new order
     * @param day day for the order
     * @param month month for the order
     * @param hour hour for the order
     * @return a newly created order
     */
    public Order createNewOrder(int clientId, int day, int month, int hour);

    /**
     * This method generates the reports for the admin based on the preiously placed orders
     * @param startHour the starting hour used to find the orders placed in a certain interval
     * @param endHour the ending hour used to find the orders placed in a certain interval
     * @param minNoOrderedProducts  the minimum number of orders for a certain product
     * @param minNoOrdersFromAClient the minimum number of orders from a certain client
     * @param minPricePerOrder the minimum price for orders
     * @param dayOfOrder the day for which the reports will be computed
     */
    public void generateReports(int startHour, int endHour, int minNoOrderedProducts, int minNoOrdersFromAClient, int minPricePerOrder, int dayOfOrder);

        public void generateBill(HashMap<String, MenuItem> ordersList, Integer clientId);

    }

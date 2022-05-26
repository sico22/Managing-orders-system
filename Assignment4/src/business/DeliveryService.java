package business;

import business.users.Client;
import data.Serializator;

import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

/**
 * @author Alexandra Maria Sicobean
 *
 * This class is responsible for most of the operations that go behind the main two users: Admin and Client
 */

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {
    HashMap <String, MenuItem> menuItems;
    HashMap <String, MenuItem> searchedItems;
    HashMap <Order, HashMap<String, MenuItem>> orders;
    HashMap <String, Client> clients;
    ArrayList <MenuItem> compositeList;
    Writer writerReports;

    /**
     * This method is used for the invariant assertions. It checks the size of the menu as to never reach a negative state
     * @return returns true if the number of items in the menu is greater than 0 and false otherwise
     */
    public boolean menuStillAvailable(){
        return menuItems.size() >= 0;
    }

    public DeliveryService(HashMap <String, Client> clients) {
        this.menuItems = new HashMap<>();
        this.clients = clients;
        this.orders = new HashMap<>();
        this.compositeList = new ArrayList<>();

        try{
            this.writerReports = new FileWriter("reports.txt");
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public HashMap<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    public HashMap<String, Client> getClients() {
        return clients;
    }

    @Override
    public DefaultTableModel importProducts() {
        this.menuItems = Serializator.deserializeMenu();
        this.searchedItems = new HashMap<>();

        Object[][] data = new Object[menuItems.size()][8];
        int row = 0;
        for(String s : menuItems.keySet()){
            data[row][0] = menuItems.get(s).getId();
            data[row][1] = s;
            data[row][2] = menuItems.get(s).getRating();
            data[row][3] = menuItems.get(s).getCalories();
            data[row][4] = menuItems.get(s).getProtein();
            data[row][5] = menuItems.get(s).getFat();
            data[row][6] = menuItems.get(s).getSodium();
            data[row][7] = menuItems.get(s).getPrice();
            row++;
        }

        String[] headers = {"Id", "Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, headers);
        return defaultTableModel;
    }

    /**
     * This method displays the elements from the imported information
     * @param menuItems the collection that stores all menu items
     * @return model for the updated table
     */
    public DefaultTableModel displayProducts(HashMap <String, MenuItem> menuItems) {
        Object[][] data = new Object[menuItems.size()][8];
        int row = 0;
        for(String s : menuItems.keySet()){
            data[row][0] = menuItems.get(s).getId();
            data[row][1] = s;
            data[row][2] = menuItems.get(s).getRating();
            data[row][3] = menuItems.get(s).getCalories();
            data[row][4] = menuItems.get(s).getProtein();
            data[row][5] = menuItems.get(s).getFat();
            data[row][6] = menuItems.get(s).getSodium();
            data[row][7] = menuItems.get(s).getPrice();
            row++;
        }

        String[] headers = {"Id", "Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, headers);
        return defaultTableModel;
    }


    @Override
    public DefaultTableModel addBaseProduct(BaseProduct baseProduct) {
        assert baseProduct != null;
        this.menuItems.put(baseProduct.getTitle(), baseProduct);

        Object[][] data = new Object[menuItems.size()][8];
        int row = 0;
        for(String s : menuItems.keySet()){
            data[row][0] = menuItems.get(s).getId();
            data[row][1] = s;
            data[row][2] = menuItems.get(s).getRating();
            data[row][3] = menuItems.get(s).getCalories();
            data[row][4] = menuItems.get(s).getProtein();
            data[row][5] = menuItems.get(s).getFat();
            data[row][6] = menuItems.get(s).getSodium();
            data[row][7] = menuItems.get(s).getPrice();
            row++;
        }
        String[] headers = {"Id", "Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, headers);
        assert defaultTableModel != null;
        return defaultTableModel;
    }

    @Override
    public DefaultTableModel deleteProduct(String title) {
        assert title != null;
        this.menuItems.remove(title);

        Object[][] data = new Object[menuItems.size()][8];
        int row = 0;
        for(String s : menuItems.keySet()){
            data[row][0] = menuItems.get(s).getId();
            data[row][1] = s;
            data[row][2] = menuItems.get(s).getRating();
            data[row][3] = menuItems.get(s).getCalories();
            data[row][4] = menuItems.get(s).getProtein();
            data[row][5] = menuItems.get(s).getFat();
            data[row][6] = menuItems.get(s).getSodium();
            data[row][7] = menuItems.get(s).getPrice();
            row++;
        }
        String[] headers = {"Id", "Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, headers);
        assert defaultTableModel != null;
        return defaultTableModel;
    }

    @Override
    public DefaultTableModel modifyProduct(BaseProduct baseProduct) {
        assert baseProduct != null;
        return addBaseProduct(baseProduct);
    }


    @Override
    public DefaultTableModel searchProduct(String title, double rating, double calories, double protein, double fat, double sodium, double price) {
        assert title != null;
        ArrayList<String> searchedTitles = new ArrayList<>();

        menuItems.keySet().stream()
                .filter(p -> menuItems.get(p).getTitle().contains(title) &&
                        (menuItems.get(p).getRating() == rating || rating == -1) &&
                        (menuItems.get(p).getCalories() == calories || calories == -1) &&
                        (menuItems.get(p).getProtein() == protein || protein == -1) &&
                        (menuItems.get(p).getFat() == fat || fat == -1) &&
                        (menuItems.get(p).getSodium() == sodium || sodium == -1) &&
                        (menuItems.get(p).getPrice() == price || price == -1))
                .forEach(searchedTitles :: add);

        for(String s : searchedTitles) {
            searchedItems.put(s, menuItems.get(s));
        }

        return displayProducts(searchedItems);
    }

    @Override
    public Order createNewOrder(int clientId, int day, int month, int hour){
        int orderId = orders.size();
        Order order = new Order(orderId, clientId, day, month, hour);
        for(Client c : clients.values()){
            if(c.getId() == clientId){
                c.setNoOrders(c.getNoOrders() + 1);
            }
        }
        assert order != null;
        return order;
    }

    @Override
    public void addToCompositeArrayList(String baseProductTitle){
        this.compositeList.add(menuItems.get(baseProductTitle));
        System.out.println(baseProductTitle + " was added to the new composite product");
    }

    @Override
    public void addCompositeProduct(String title){
        CompositeProduct compositeProduct = new CompositeProduct(title);

        for(MenuItem m : compositeList){
            compositeProduct.addToBaseProductList(m);
        }

        compositeProduct.computeAttributes();
        menuItems.put(title, compositeProduct);
        System.out.println(title + " was successfully added to the menu");
    }

    public void addNewProduct(HashMap<String, MenuItem> ordersList, MenuItem newItem){
        ordersList.put(newItem.getTitle(), newItem);
        newItem.setNoOrders(newItem.getNoOrders() + 1);
        newItem.setNoOrders(newItem.getNoOrders() + 1);
    }

    public void placeOrder(Order order, HashMap<String, MenuItem> ordersList){
        orders.put(order, ordersList);
        this.setChanged();
        this.notifyObservers(order.getOrderId());
    }


    @Override
    public void generateBill(HashMap<String, MenuItem> ordersList, Integer clientId){
        assert ordersList != null;
        String endl = System.getProperty("line.separator");
        double price = 0;

        try{
            Writer writer = new FileWriter("bill.txt");
            for(MenuItem m : ordersList.values()){
                writer.append(ordersList.get(m.getTitle()).getTitle());
                writer.append(endl);
                price += m.getPrice();
            }
            writer.append(String.valueOf(price));
            for(Client c : clients.values()){
                if(c.getId() == clientId && price > c.getMaxSum()){
                    c.setMaxSum(price);
                }
            }
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void generateTimeIntervalOfTheOrders(int startHour, int endHour){
        ArrayList<Order> ordersList = new ArrayList<>();
        String endl = System.getProperty("line.separator");

        orders.keySet().stream()
                .filter(p -> p.getHour() >= startHour && p.getHour() <= endHour)
                .forEach(ordersList :: add);

        try{
            writerReports.append("Orders between ").append(String.valueOf(startHour)).append(" and ").append(String.valueOf(endHour));
            writerReports.append(endl);
            for(Order o : ordersList){
                    writerReports.append("Client id: " + o.getClientId());
                    writerReports.append(',');
                    writerReports.append("Order id: " + o.getOrderId());
                    writerReports.append(',');
                    writerReports.append("Day: " + o.getDay());
                    writerReports.append(',');
                    writerReports.append("Month: " + o.getMonth());
                    writerReports.append(',');
                    writerReports.append("Hour: " + o.getHour());
                    writerReports.append(endl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void generateProductsOrderedMoreThanNTimes(int minNoOrderedProducts){
        ArrayList<MenuItem> products = new ArrayList<>();
        String endl = System.getProperty("line.separator");

        menuItems.values().stream()
                .filter(p -> p.getNoOrders() >= minNoOrderedProducts)
                .forEach(products :: add);

        try{
            writerReports.append(endl);
            writerReports.append("Products ordered more than " + minNoOrderedProducts + " times:");
            writerReports.append(endl);
            for(MenuItem m : products){
                writerReports.append("Title: " + m.getTitle());
                writerReports.append(endl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void generateRegularClients(int minNoOrdersFromAClient, int minPricePerOrder){
        ArrayList<Client> clientsList = new ArrayList<>();
        String endl = System.getProperty("line.separator");

        clients.values().stream()
                .filter(c -> c.getNoOrders() >= minNoOrdersFromAClient && c.getMaxSum() >= minPricePerOrder)
                .forEach(clientsList :: add);

        try{
            writerReports.append(endl);
            writerReports.append("Clients ordered more than " + minNoOrdersFromAClient + " times and paid at least " + minPricePerOrder + ":");
            writerReports.append(endl);
            for(Client c : clientsList){
                writerReports.append("Name: " + c.getName() + ", Address: " + c.getAddress());
                writerReports.append(endl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void generateReports(int startHour, int endHour, int minNoOrderedProducts, int minNoOrdersFromAClient, int minPricePerOrder, int dayOfOrder){
        generateTimeIntervalOfTheOrders(startHour, endHour);
        generateProductsOrderedMoreThanNTimes(minNoOrdersFromAClient);
        generateRegularClients(minNoOrdersFromAClient, minPricePerOrder);
    }

}

package data;

import business.BaseProduct;
import business.MenuItem;
import business.users.Client;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is used to serialize and deserialize data regarding menu items and clients
 */

public class Serializator{

    /**
     * This method uses streams to extract data from a .csv file and create new instances of menu items
     * @return a hashmap containing the name of the product and the menu item. Thus, we won't repeat any elements from the .csv file
     */
    public static HashMap<String, MenuItem> deserializeMenu(){
        HashMap<String, MenuItem> menuItemHashMap = new HashMap<>();
        List<BaseProduct> menuList;
        Path path = Path.of("products.csv");

        try {
            menuList = Files.lines(path)
                    .skip(1)
                    .map(line -> {return getProduct(line);})
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int i = 1;
        for(BaseProduct p : menuList){
            p.setId(i);
            i++;
            menuItemHashMap.put(p.getTitle(), p);
        }

        return menuItemHashMap;

    }


    /**
     * This method computes a line from the stream and returns a base product to be put in the final products list
     * @param line a line from the .csv file
     * @return a new base product
     */
    public static BaseProduct getProduct(String line) {
        BaseProduct baseProduct = new BaseProduct();
        String[] row = line.split(",");
        int i = 1;
        for (String index : row) {
            if (i == 1) {
                baseProduct.setTitle(index);
            }

            if (i == 2) {
                baseProduct.setRating(Double.parseDouble(index));
            }
            if (i == 3)
                baseProduct.setCalories(Double.parseDouble(index));
            if (i == 4)
                baseProduct.setProtein(Double.parseDouble(index));
            if (i == 5)
                baseProduct.setFat(Double.parseDouble(index));
            if (i == 6)
                baseProduct.setSodium(Double.parseDouble(index));
            if (i == 7)
                baseProduct.setPrice(Double.parseDouble(index));
            i++;
        }
        return baseProduct;
    }

    /**
     * This method iterates through the menu items hash map and writes them in the .csv file
     * @param menuItemHashMap
     */
    public static void serializeMenu(HashMap<String, MenuItem> menuItemHashMap){
        String endl = System.getProperty("line.separator");

        try {
            Writer writer = new FileWriter("products.csv");
            writer.flush();
            writer.append("Title,Rating,Calories,Protein,Fat,Sodium,Price");
            writer.append(endl);
            for(String m : menuItemHashMap.keySet()){
                writer.append(menuItemHashMap.get(m).getTitle())
                        .append(',')
                        .append(String.valueOf(menuItemHashMap.get(m).getRating()))
                        .append(',')
                        .append(String.valueOf(menuItemHashMap.get(m).getCalories()))
                        .append(',')
                        .append(String.valueOf(menuItemHashMap.get(m).getProtein()))
                        .append(',')
                        .append(String.valueOf(menuItemHashMap.get(m).getFat()))
                        .append(',')
                        .append(String.valueOf(menuItemHashMap.get(m).getSodium()))
                        .append(',')
                        .append(String.valueOf(menuItemHashMap.get(m).getPrice()))
                        .append(',')
                        .append(endl);

            }
            writer.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method uses streams to extract data from a .csv file and create new instances of clients
     * @return a hashmap containing the username of the client and the client object. Thus, we won't repeat any elements from the .csv file
     */
    public static HashMap<String, Client> deserializeClient(){
        HashMap<String, Client> clientHashMap = new HashMap<>();
        List<Client> clientsList;
        Path path = Path.of("clients.csv");

        try {
            clientsList = Files.lines(path)
                    .skip(1)
                    .map(Serializator::getClient)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int i = 1;
        for(Client c : clientsList){
            c.setId(i);
            i++;
            clientHashMap.put(c.getUsername(), c);
        }
        return clientHashMap;
    }


    /**
     * This method computes a line from the stream and returns a client to be put in the final clients list
     * @param line a line from the .csv file
     * @return a new base product
     */
    public static Client getClient(String line) {
        Client client = new Client();
        String[] row = line.split(",");
        int i = 1;
        for (String index : row) {
            if (i == 1)
                client.setName(index);
            if (i == 2)
                client.setAddress(index);
            if (i == 3)
                client.setUsername(index);
            if (i == 4)
                client.setPassword(index);
            i++;
        }
        return client;
    }

    /**
     * This method iterates through the menu clients hash map and writes them in the .csv file
     * @param clientHashMap
     */
    public static void serializeClient(HashMap<String, Client> clientHashMap) {
        String endl = System.getProperty("line.separator");
        System.out.println(clientHashMap.size());
        try {
            Writer writer = new FileWriter("clients.csv");
            writer.flush();
            writer.append("Name,Address,Username,Password");
            writer.append(endl);
            for (String m : clientHashMap.keySet()) {
                writer.append(String.valueOf(clientHashMap.get(m).getName()))
                        .append(',')
                        .append(String.valueOf(clientHashMap.get(m).getAddress()))
                        .append(',')
                        .append(String.valueOf(clientHashMap.get(m).getUsername()))
                        .append(',')
                        .append(String.valueOf(clientHashMap.get(m).getPassword()))
                        .append(endl);
            }
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

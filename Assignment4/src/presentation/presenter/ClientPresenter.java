package presentation.presenter;

import business.DeliveryService;
import business.MenuItem;
import business.Order;
import business.users.Client;
import presentation.view.AdminView;
import presentation.view.ClientView;
import presentation.view.EmployeeView;
import presentation.view.LogInView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * This method makes the connection between the client view and the delivery service
 */

public class ClientPresenter{

    private final ClientView clientView;
    private final DeliveryService deliveryService;
    private Order newOrder;
    private HashMap<String, MenuItem> ordersList;
    private Client client;

    public ClientPresenter(ClientView clientView, DeliveryService deliveryService, Client client, EmployeeView employeeView){
        this.clientView = clientView;
        this.deliveryService = deliveryService;
        this.client = client;
        this.newOrder = new Order();
        this.ordersList = new HashMap<>();
        assert deliveryService.menuStillAvailable();
        deliveryService.addObserver(employeeView);

        this.clientView.backListener(new BackListener());
        this.clientView.displayMenuListener(new DisplayMenuListener());
        this.clientView.searchListener(new SearchListener());
        this.clientView.newOrderListener(new newOrderListener());
        this.clientView.addProductListener(new AddProductListener());
        this.clientView.placeOrderListener(new PlaceOrderListener());
    }

    public class newOrderListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            newOrder = deliveryService.createNewOrder(client.getId(), clientView.getDateTextField(), clientView.getMonthTextField(), clientView.getHourTextField());
            System.out.println("A new order has been created");
        }
    }

    public class AddProductListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.addNewProduct(ordersList, deliveryService.getMenuItems().get(clientView.getProductTextField()));
            System.out.println(ordersList.get(clientView.getProductTextField()).getTitle() + "successfully added to the cart");
        }
    }

    public class PlaceOrderListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.placeOrder(newOrder, ordersList);
            deliveryService.generateBill(ordersList, newOrder.getClientId());
            System.out.println("Order successfully placed");
        }
    }

    public class SearchListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String title = clientView.getTitleTextField();
            Double rating = clientView.getRatingTextField();
            Double calories = clientView.getCaloriesTextField();
            Double protein = clientView.getProteinTextField();
            Double fat = clientView.getFatTextField();
            Double sodium = clientView.getSodiumTextField();
            Double price = clientView.getPriceTextField();
            clientView.setNewTableModel(deliveryService.searchProduct(title, rating, calories, protein, fat, sodium, price));
        }
    }

    public class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            LogInView logInView = new LogInView("Log in");
            clientView.dispose();
            logInView.setVisible(true);
            LogInPresenter logInPresenter = new LogInPresenter(logInView, deliveryService);
        }
    }

    public class DisplayMenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.setNewTableModel(deliveryService.displayProducts(deliveryService.getMenuItems()));
        }
    }
}

package presentation.presenter;

import business.DeliveryService;
import data.Serializator;
import presentation.view.LogInView;

/**
 * This class is the starting point of the application. Here we deserialize clients so we can use the clients list in the sign up presenter
 */
public class Start {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService(Serializator.deserializeClient());
        assert deliveryService.menuStillAvailable();
        LogInView logInView = new LogInView("Log in");
        logInView.setVisible(true);
        LogInPresenter logInPresenter = new LogInPresenter(logInView, deliveryService);
    }
}
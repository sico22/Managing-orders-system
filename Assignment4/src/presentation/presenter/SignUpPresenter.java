package presentation.presenter;

import business.DeliveryService;
import business.users.Client;
import data.Serializator;
import presentation.view.ClientView;
import presentation.view.SignUpView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This method makes the connection between the sign up view and the delivery service
 */

public class SignUpPresenter {

    private final SignUpView signUpView;
    private DeliveryService deliveryService;


    public SignUpPresenter(SignUpView signUpView, DeliveryService deliveryService){
        this.signUpView = signUpView;
        this.deliveryService = deliveryService;
        assert deliveryService.menuStillAvailable();

        this.signUpView.addClientLlistener(new ClientButtonListener());


    }

    private class ClientButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = deliveryService.getClients().size() + 1;
            String name = signUpView.getNameTextField();
            String address = signUpView.getAddressTextField();
            String username = signUpView.getUsernameTextField();
            String password = signUpView.getPasswordTextField();

            Client newClient = new Client(username, password, name, address, id);
            deliveryService.getClients().put(newClient.getUsername(), newClient);
            Serializator.serializeClient(deliveryService.getClients());

            ClientView clientView = new ClientView("Client");
            signUpView.dispose();
            clientView.setVisible(true);
            ClientPresenter clientPresenter = new ClientPresenter(clientView, deliveryService, newClient, null);
        }
    }

}

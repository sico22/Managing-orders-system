package presentation.presenter;

import business.DeliveryService;
import business.users.Client;
import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * This method makes the connection between the log in view and the delivery service
 */

public class LogInPresenter {
    private final LogInView logInView;
    private DeliveryService deliveryService;
    private EmployeeView employeeView = new EmployeeView("Employee view");

    public LogInPresenter(LogInView logInView, DeliveryService deliveryService){
        this.logInView = logInView;
        this.deliveryService = deliveryService;
        assert deliveryService.menuStillAvailable();

        logInView.addClientLlistener(new ClientButtonListener());
        logInView.addAdminListener(new AdminButtonListener());
        logInView.addEmployeeListener(new EmployeeButtonListener());
        logInView.addSignUpListener(new SignUpButtonListener());

    }

    private class ClientButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Client client = null;
            for(Client c : deliveryService.getClients().values()){
                if(Objects.equals(c.getUsername(), logInView.getUserNameTextField())) {
                     client = c;
                }
            }

            if(client != null){
                ClientView clientView = new ClientView("Client");
                logInView.dispose();
                clientView.setVisible(true);
                ClientPresenter clientPresenter = new ClientPresenter(clientView, deliveryService, client, employeeView);
            }

        }
    }

    private class AdminButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AdminView adminView = new AdminView("Admin");
            logInView.dispose();
            adminView.setVisible(true);
            AdminPresenter adminPresenter = new AdminPresenter(adminView, deliveryService);
        }
    }

    private class EmployeeButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            employeeView.setVisible(true);
        }
    }

    private class SignUpButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SignUpView signUpView = new SignUpView("Sign up");
            logInView.dispose();
            signUpView.setVisible(true);
            SignUpPresenter signUpPresenter = new SignUpPresenter(signUpView, deliveryService);


        }
    }
}

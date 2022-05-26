package presentation.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * This class represents the front page of the application. Here the user can either log into the application or sign up as a client
 */

public class LogInView extends JFrame{
    private JPanel logInPanel;
    private JTextField userNameTextField;
    private JTextField passwordTextField;
    private JButton clientButton;
    private JButton adminButton;
    private JButton employeeButton;
    private JButton signUpButton;

    public LogInView(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(logInPanel);
        this.pack();
    }

    public String getUserNameTextField() {
        return userNameTextField.getText();
    }

    public String getPasswordTextField() {
        return passwordTextField.getText();
    }

    public void addClientLlistener(ActionListener listener){
        clientButton.addActionListener(listener);
    }

    public void addAdminListener(ActionListener listener){
        adminButton.addActionListener(listener);
    }

    public void addEmployeeListener(ActionListener listener){
        employeeButton.addActionListener(listener);
    }

    public void addSignUpListener(ActionListener listener){
        signUpButton.addActionListener(listener);
    }

}

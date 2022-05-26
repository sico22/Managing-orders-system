package presentation.view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * This class enables the client to sign up by introducting his/her data
 */

public class SignUpView extends JFrame{
    private JPanel signUpPanel;
    private JTextField nameTextField;
    private JTextField addressTextField;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton clientButton;

    public SignUpView(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(signUpPanel);
        this.pack();
    }

    public void addClientLlistener(ActionListener listener){
        clientButton.addActionListener(listener);
    }


    public String getNameTextField() {
        return nameTextField.getText();
    }

    public String getAddressTextField() {
        return addressTextField.getText();
    }

    public String getUsernameTextField() {
        return usernameTextField.getText();
    }

    public String getPasswordTextField() {
        return passwordTextField.getText();
    }
}

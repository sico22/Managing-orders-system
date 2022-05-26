package presentation.view;


import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * This employee represents what the admin sees when he logs into the application.
 */

public class EmployeeView extends JFrame implements Observer {
    private JPanel employeePanel;
    private JLabel notificationLabel;

    public EmployeeView(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(employeePanel);
        this.pack();
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Preparing order " + (Integer)arg);
        this.notificationLabel.setText("Preparing order " + (Integer)arg);
    }
}

package presentation.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

/**
 * This client represents what the admin sees when he logs into the application.
 */

public class ClientView extends JFrame{
    private JPanel clientPanel;
    private JTable menuTable;
    private JScrollPane menuScrollPane;
    private JTextField dayTextField;
    private JTextField hourTextField;
    private JTextField productTextField;
    private JButton addProductButton;
    private JButton placeOrderButton;
    private JTextField titleTextField;
    private JTextField ratingTextField;
    private JTextField caloriesTextField;
    private JTextField proteinTextField;
    private JTextField fatTextField;
    private JTextField sodiumTextField;
    private JTextField priceTextField;
    private JButton searchButton;
    private JTextField monthTextField;
    private JButton backButton;
    private JButton displayMenuButton;
    private JButton newOrderButton;

    public ClientView(String title){
        super(title);

        String col[] = {"Id", "Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        menuTable.setModel(tableModel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(clientPanel);
        this.pack();
    }

    public Integer getDateTextField() {
        return Integer.parseInt(dayTextField.getText());
    }

    public Integer getHourTextField() {
        return Integer.parseInt(hourTextField.getText());
    }

    public Integer getMonthTextField() {
        return Integer.parseInt(monthTextField.getText());
    }

    public String getProductTextField() {
        return productTextField.getText();
    }

    public String getTitleTextField() {
        return titleTextField.getText();
    }

    public Double getRatingTextField() {
        try {
            return Double.parseDouble(ratingTextField.getText());
        }catch(Exception e) {
            return -1.0;
        }
    }

    public  Double getCaloriesTextField() {
        try {
            return Double.parseDouble(caloriesTextField.getText());
        }catch(Exception e) {
            return -1.0;
        }
    }

    public  Double getProteinTextField() {
        try {
            return Double.parseDouble(proteinTextField.getText());
        }catch(Exception e) {
            return -1.0;
        }
    }

    public Double getFatTextField() {
        try {
            return Double.parseDouble(fatTextField.getText());
        }catch(Exception e) {
            return -1.0;
        }
    }

    public Double getSodiumTextField() {
        try {
            return Double.parseDouble(sodiumTextField.getText());
        }catch(Exception e) {
            return -1.0;
        }
    }

    public Double getPriceTextField() {
        try {
            return Double.parseDouble(priceTextField.getText());
        }catch(Exception e) {
            return -1.0;
        }
    }

    public void setNewTableModel(DefaultTableModel defaultTableModel){
        menuTable.setModel(defaultTableModel);
    }

    public void addProductListener(ActionListener listener){
        addProductButton.addActionListener(listener);
    }

    public void placeOrderListener(ActionListener listener){
        placeOrderButton.addActionListener(listener);
    }

    public void searchListener(ActionListener listener){
        searchButton.addActionListener(listener);
    }

    public void backListener(ActionListener listener){
        backButton.addActionListener(listener);
    }

    public void displayMenuListener(ActionListener listener){
        displayMenuButton.addActionListener(listener);
    }

    public void newOrderListener(ActionListener listener){
        newOrderButton.addActionListener(listener);
    }

}

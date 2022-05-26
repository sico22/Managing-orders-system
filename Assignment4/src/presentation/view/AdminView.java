package presentation.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

/**
 * This class represents what the admin sees when he logs into the application.
 */

public class AdminView extends JFrame{
    private JPanel adminPanel;
    private JButton importProductsButton;
    private JTable productsTable;
    private JTextField titleTextField;
    private JTextField ratingTextField;
    private JTextField caloriesTextField;
    private JTextField proteinTextField;
    private JTextField fatTextField;
    private JTextField sodiumTextField;
    private JTextField priceTextField;
    private JButton addBaseProductButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private JButton addToComposedProductButton;
    private JButton newComposedProductButton;
    private JButton finishComposedProductButton;
    private JButton generateReportsButton;
    private JScrollPane productsScrollPane;
    private JButton backButton;
    private JTextField startHourTextField;
    private JTextField endHourTextField;
    private JTextField noOrderedProducts;
    private JTextField noOrdersFromAClientTextField;
    private JTextField minimumPriceTextField;
    private JTextField dayOfOrderTextField;
    private JTextField addToComposedProductTextField;

    public AdminView(String title){
        super(title);

        String col[] = {"Id", "Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        productsTable.setModel(tableModel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(adminPanel);
        this.pack();
    }

    public String getAddToComposedProductTextField() {
        return addToComposedProductTextField.getText();
    }

    public Integer getStartHourTextField() {
        return Integer.parseInt(startHourTextField.getText());
    }

    public Integer getEndHourTextField() {
        return Integer.parseInt(endHourTextField.getText());
    }

    public Integer getNoOrderedProducts() {
        return Integer.parseInt(noOrderedProducts.getText());
    }

    public Integer getNoOrdersFromAClientTextField() {
        return Integer.parseInt(noOrdersFromAClientTextField.getText());
    }

    public Integer getMinimumPriceTextField() {
        return Integer.parseInt(minimumPriceTextField.getText());
    }

    public Integer getDayOfOrderTextField() {
        return Integer.parseInt(dayOfOrderTextField.getText());
    }

    public String getTitleTextField() {
        return titleTextField.getText();
    }

    public Double getRatingTextField() {
        return Double.parseDouble(ratingTextField.getText());
    }

    public Double getCaloriesTextField() {
        return Double.parseDouble(caloriesTextField.getText());
    }

    public Double getProteinTextField() {
        return Double.parseDouble(proteinTextField.getText());
    }

    public Double getFatTextField() {
        return Double.parseDouble(fatTextField.getText());
    }

    public Double getSodiumTextField() {
        return Double.parseDouble(sodiumTextField.getText());
    }

    public Double getPriceTextField() {
        return Double.parseDouble(priceTextField.getText());
    }


    public void setNewTableModel(DefaultTableModel defaultTableModel){
        productsTable.setModel(defaultTableModel);
    }

    public void addImportProductsListener(ActionListener listener){
        importProductsButton.addActionListener(listener);
    }

    public void addBaseProductListener(ActionListener listener){
        addBaseProductButton.addActionListener(listener);
    }

    public void deleteProductListener(ActionListener listener){
        deleteButton.addActionListener(listener);
    }

    public void modifyProductListener(ActionListener listener){
        modifyButton.addActionListener(listener);
    }

    public void backListener(ActionListener listener){
        backButton.addActionListener(listener);
    }

    public void generateReportsButton(ActionListener listener){
        generateReportsButton.addActionListener(listener);
    }

    public void addToComposedProductListener(ActionListener listener){
        addToComposedProductButton.addActionListener(listener);
    }

    public void addComposedProductListener(ActionListener listener){
        finishComposedProductButton.addActionListener(listener);
    }
}

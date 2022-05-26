package presentation.presenter;

import business.BaseProduct;
import business.DeliveryService;
import data.Serializator;
import presentation.view.AdminView;
import presentation.view.LogInView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This method makes the connection between the admin view and the delivery service
 */

public class AdminPresenter {
    private final AdminView adminView;
    private DeliveryService deliveryService;

    public AdminPresenter(AdminView adminView, DeliveryService deliveryService){
        this.adminView = adminView;
        this.deliveryService = deliveryService;
        assert deliveryService.menuStillAvailable();

        adminView.addImportProductsListener(new ImportProductsButtonListener());
        adminView.addBaseProductListener(new AddBaseProductsButtonListener());
        adminView.deleteProductListener(new DeleteProductsButtonListener());
        adminView.modifyProductListener(new ModifyProductsButtonListener());
        adminView.backListener(new BackButtonListener());
        adminView.generateReportsButton(new GenerateReportsButtonListener());
        adminView.addToComposedProductListener(new AddToCompositeListListener());
        adminView.addComposedProductListener(new AddCompositeProductListener());

    }

    private class ImportProductsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Products imported");
            adminView.setNewTableModel(deliveryService.importProducts());
        }
    }

    private class AddBaseProductsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = deliveryService.getMenuItems().size() + 1;
            String title = adminView.getTitleTextField();
            Double rating = adminView.getRatingTextField();
            Double calories = adminView.getCaloriesTextField();
            Double protein = adminView.getProteinTextField();
            Double fat = adminView.getFatTextField();
            Double sodium = adminView.getSodiumTextField();
            Double price = adminView.getPriceTextField();
            BaseProduct baseProduct = new BaseProduct(id, title, rating, calories, protein, fat, sodium, price);
            adminView.setNewTableModel(deliveryService.addBaseProduct(baseProduct));
            System.out.println("Product " + baseProduct.getTitle() + " successfully added. New size: " + deliveryService.getMenuItems().size());
        }
    }

    private class DeleteProductsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            adminView.setNewTableModel(deliveryService.deleteProduct(adminView.getTitleTextField()));
            System.out.println("Product " + adminView.getTitleTextField() + " successfully removed. New size: " + deliveryService.getMenuItems().size());

        }
    }

    private class ModifyProductsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String title = adminView.getTitleTextField();
            int id = deliveryService.getMenuItems().get(title).getId();
            Double rating = adminView.getRatingTextField();
            Double calories = adminView.getCaloriesTextField();
            Double protein = adminView.getProteinTextField();
            Double fat = adminView.getFatTextField();
            Double sodium = adminView.getSodiumTextField();
            Double price = adminView.getPriceTextField();
            BaseProduct baseProduct = new BaseProduct(id, title, rating, calories, protein, fat, sodium, price);
            adminView.setNewTableModel(deliveryService.modifyProduct(baseProduct));
            System.out.println("Product " + baseProduct.getTitle() + " successfully modified. New size: " + deliveryService.getMenuItems().size());
        }
    }

    private class BackButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            LogInView logInView = new LogInView("Log in");
            adminView.dispose();
            logInView.setVisible(true);
            LogInPresenter logInPresenter = new LogInPresenter(logInView, deliveryService);
            Serializator.serializeMenu(deliveryService.getMenuItems());
        }
    }

    private class GenerateReportsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int startHour = adminView.getStartHourTextField();
            int endHour = adminView.getEndHourTextField();
            int minNoOrderedProducts = adminView.getNoOrderedProducts();
            int minNoOrdersFromAClient = adminView.getNoOrdersFromAClientTextField();
            int minPricePerOrder = adminView.getMinimumPriceTextField();
            int dayOfOrder = adminView.getDayOfOrderTextField();

           deliveryService.generateReports(startHour, endHour, minNoOrderedProducts, minNoOrdersFromAClient, minPricePerOrder, dayOfOrder);
        }
    }

    private class AddToCompositeListListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.addToCompositeArrayList(adminView.getAddToComposedProductTextField());
        }
    }

    private class AddCompositeProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.addCompositeProduct(adminView.getTitleTextField());
        }
    }
}

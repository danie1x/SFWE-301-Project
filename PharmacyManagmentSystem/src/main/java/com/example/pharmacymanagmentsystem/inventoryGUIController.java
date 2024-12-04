package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class inventoryGUIController {

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<?> inventoryTable;

    @FXML
    private TableColumn<?, ?> itemIdColumn;

    @FXML
    private TableColumn<?, ?> itemNameColumn;

    @FXML
    private TableColumn<?, ?> quantityColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private TableColumn<?, ?> expiryColumn;

    @FXML
    private Button updateInventoryButton;

    @FXML
    private Button lowStockButton;

    @FXML
    private Button orderNewMedButton;

    @FXML
    private Button removeInventoryButton;

    @FXML
    private Button expiredNotificationButton;

    @FXML
    private Button goBackButton;

    @FXML
    protected void onSearchClick() {
        // Handle search button click
        String searchQuery = searchField.getText();
        // Implement search logic here
        System.out.println("Searching for: " + searchQuery);
    }

    @FXML
    protected void onUpdateInventoryClick() {
        // Handle update inventory button click
        // Implement update inventory logic here
        System.out.println("Updating inventory.");
    }

    @FXML
    protected void onLowStockClick() {
        // Handle low stock notification button click
        // Implement low stock notification logic here
        System.out.println("Low stock notification.");
    }

    @FXML
    protected void onOrderNewMedsClick() {
        // Handle order new medicines button click
        // Implement order new medicines logic here
        System.out.println("Ordering new medicines.");
    }

    @FXML
    protected void onRemoveExpiredClick() {
        // Handle remove expired button click
        // Implement remove expired items logic here
        System.out.println("Removing expired items.");
    }

    @FXML
    protected void onExpiredNotificationClick() {
        // Handle expired notification button click
        // Implement expired notification logic here
        System.out.println("Expired notification.");
    }

    @FXML
    private void onGoBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("dashboardGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 778, 487);

        // Get the current stage and set the new scene
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.show();
    }
}
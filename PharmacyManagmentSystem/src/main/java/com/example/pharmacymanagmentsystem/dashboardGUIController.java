package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboardGUIController {

    @FXML
    private Button editProfileButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button prescriptionsButton;

    @FXML
    private Button checkoutButton;

    @FXML
    private Button inventoryButton;

    @FXML
    private Button staffAccountButton;

    @FXML
    private Button patientAccountButton;

    @FXML
    private Button updateAccountButton;

    @FXML
    private Button notificationsButton;

    @FXML
    private Button reportsButton;

    @FXML
    private Button suppliesButton;

    @FXML
    private Label informationLabel;

    @FXML
    private Label dashboardLabel;

    @FXML
    private Label systemLabel;

    @FXML
    protected void onEditProfileButtonClick() {
        // Handle edit profile button click
    }

    @FXML
    protected void onLogOutButtonClick() throws IOException {
        // Handle log out button click
        // Load the LogInPage.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LogInPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Get the current stage and set the new scene
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Log In!");
        stage.show();
    }

    @FXML
    protected void onPrescriptionsButtonClick() {
        // Handle prescriptions button click
    }

    @FXML
    protected void onCheckoutButtonClick() {
        // Handle checkout button click
    }

    @FXML
    protected void onInventoryButtonClick() {
        // Handle inventory button click
    }

    @FXML
    protected void onStaffAccountButtonClick() {
        // Handle staff account button click
    }

    @FXML
    protected void onPatientAccountButtonClick() {
        // Handle patient account button click
    }

    @FXML
    protected void onUpdateAccountButtonClick() {
        // Handle update account button click
    }

    @FXML
    protected void onNotificationsButtonClick() {
        // Handle notifications button click
    }

    @FXML
    protected void onReportsButtonClick() {
        // Handle reports button click
    }

    @FXML
    protected void onSuppliesButtonClick() {
        // Handle supplies button click
    }
}
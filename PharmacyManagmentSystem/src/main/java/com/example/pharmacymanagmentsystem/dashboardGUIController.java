package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboardGUIController {

    @FXML
    private Button customizeDashboardButton;

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
    private Button updatePasswordButton;

    @FXML
    private Button notificationsButton;

    @FXML
    private Button reportsButton;

    @FXML
    private Button accountRecoveryButton;

    private DashboardModel model;

    public void setModel(DashboardModel model) {
        this.model = model;
        bindButtonVisibility();
    }

    private void bindButtonVisibility() {
        prescriptionsButton.visibleProperty().bind(model.showPrescriptionsProperty());
        checkoutButton.visibleProperty().bind(model.showCheckoutProperty());
        inventoryButton.visibleProperty().bind(model.showInventoryProperty());
        staffAccountButton.visibleProperty().bind(model.showStaffAccountProperty());
        patientAccountButton.visibleProperty().bind(model.showPatientAccountProperty());
        updatePasswordButton.visibleProperty().bind(model.showUpdatePasswordProperty());
        notificationsButton.visibleProperty().bind(model.showNotificationsProperty());
        reportsButton.visibleProperty().bind(model.showReportsProperty());
        accountRecoveryButton.visibleProperty().bind(model.showAccountRecoveryProperty());
    }

    @FXML
    private Label informationLabel;

    @FXML
    private Label dashboardLabel;

    @FXML
    private Label systemLabel;

    @FXML
    protected void onCustomizeDashboardButtonClick() throws IOException {
        // Handle edit profile button click
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("customizeDashboard.fxml"));
        Parent customizeRoot = fxmlLoader.load();
        customizeDashboardController customizeController = fxmlLoader.getController();
        customizeController.setModel(model);

        Scene scene = new Scene(customizeRoot, 469, 400);

        // Get the current stage and set the new scene
        Stage stage = (Stage) customizeDashboardButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Customize Dashboard");
        stage.show();
    }

    @FXML
    protected void onLogOutButtonClick() throws IOException {
        // Handle log out button click
        // Load the LogInPage.fxml
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LogInPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        // Get the current stage and set the new scene
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Log In");
        stage.show();
    }

    @FXML
    protected void onPrescriptionsButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("prescriptionGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);

        // Get the current stage and set the new scene
        Stage stage = (Stage) prescriptionsButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Prescriptions");
        stage.show();
    }

    @FXML
    protected void onCheckoutButtonClick() throws IOException {
        // Handle checkout button click
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("checkoutGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 778, 487);

        // Get the current stage and set the new scene
        Stage stage = (Stage) checkoutButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Checkout");
        stage.show();
    }

    @FXML
    protected void onInventoryButtonClick() throws IOException {
        // Handle inventory button click
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("inventoryGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 778, 487);

        // Get the current stage and set the new scene
        Stage stage = (Stage) inventoryButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Inventory");
        stage.show();
    }

    @FXML
    protected void onStaffAccountButtonClick() throws IOException {
        // Handle staff account button click
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("createStaffAccountGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 778, 487);

        // Get the current stage and set the new scene
        Stage stage = (Stage) staffAccountButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Staff Account");
        stage.show();
    }

    @FXML
    protected void onPatientAccountButtonClick() throws IOException {
        // Handle patient account button click
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("createPatientAccountGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 778, 487);

        // Get the current stage and set the new scene
        Stage stage = (Stage) patientAccountButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Patient Account");
        stage.show();
    }

    @FXML
    protected void onUpdatePasswordButtonClick() throws IOException {
        // Handle update password button click
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("updatePasswordGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 778, 487);

        // Get the current stage and set the new scene
        Stage stage = (Stage) updatePasswordButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Update Password");
        stage.show();
    }

    @FXML
    protected void onNotificationsButtonClick() {
        // Handle notifications button click
    }

    @FXML
    protected void onReportsButtonClick() throws IOException {
        // Handle reports button click
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("reportsGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 778, 487);

        // Get the current stage and set the new scene
        Stage stage = (Stage) reportsButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Reports");
        stage.show();
    }

    @FXML
    protected void onAccountRecoveryButtonClick() throws IOException {
        // Handle account recovery button click
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("accountRecoveryGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 778, 487);

        // Get the current stage and set the new scene
        Stage stage = (Stage) accountRecoveryButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Account Recovery");
        stage.show();
    }
}
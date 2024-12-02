package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class LogInController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    public void onLoginButtonClick() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("showPrescriptions", "true");
        properties.setProperty("showCheckout", "true");
        properties.setProperty("showInventory", "true");
        properties.setProperty("showStaffAccount", "true");
        properties.setProperty("showPatientAccount", "true");
        properties.setProperty("showUpdateAccount", "true");
        properties.setProperty("showNotifications", "true");
        properties.setProperty("showReports", "true");
        properties.setProperty("showSupplies", "true");
        try (FileWriter writer = new FileWriter("checkboxes.properties")) {
            properties.store(writer, "Checkbox States");
        }

        FXMLLoader dashboardLoader = new FXMLLoader(Main.class.getResource("dashboardGUI.fxml"));
        Parent dashboardRoot = dashboardLoader.load();
        dashboardGUIController dashboardController = dashboardLoader.getController();

        FXMLLoader customizeLoader = new FXMLLoader(Main.class.getResource("customizeDashboard.fxml"));
        Parent customizeRoot = customizeLoader.load();
        customizeDashboardController customizeController = customizeLoader.getController();

        DashboardModel model = new DashboardModel();
        dashboardController.setModel(model);
        customizeController.setModel(model);

        Scene scene = new Scene(dashboardRoot, 778, 487);


        // Get the current stage and set the new scene
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.show();
    }
}
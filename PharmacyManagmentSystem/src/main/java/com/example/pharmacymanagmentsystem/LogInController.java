package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    private int failedAttempts = 0;
    private static final int MAX_FAILED_ATTEMPTS = 5;

    private static final String MANAGER_USERNAME = "manager";
    private static final String MANAGER_PASSWORD = "manager123";

    @FXML
    public void onLoginButtonClick() throws IOException {
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();
        String correctPassword = "yourCorrectPassword"; // Replace with your actual password checking logic

        if (enteredUsername.equals(MANAGER_USERNAME) && enteredPassword.equals(MANAGER_PASSWORD)) {
            // Automatic login for pharmacy manager
            failedAttempts = 0;
            loadDashboard();
            return;
        }

        if (!enteredPassword.equals(correctPassword)) {
            failedAttempts++;
            if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Account Locked");
                alert.setHeaderText(null);
                alert.setContentText("This account has been locked due to failed sign in attempts. Please request the pharmacy manager to unlock this account to continue.");
                alert.showAndWait();
                return;
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Login Error");
                alert.setHeaderText(null);
                alert.setContentText("Incorrect password. Please try again.");
                alert.showAndWait();
                return;
            }
        }

        if ((failedAttempts >= MAX_FAILED_ATTEMPTS) && (enteredPassword.equals(correctPassword))) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Account Locked");
            alert.setHeaderText(null);
            alert.setContentText("This account has been locked due to failed sign in attempts. Please request the pharmacy manager to unlock this account to continue.");
            alert.showAndWait();
            return;
        }



        // Reset failed attempts on successful login
        failedAttempts = 0;

        Properties properties = new Properties();
        properties.setProperty("showPrescriptions", "true");
        properties.setProperty("showCheckout", "true");
        properties.setProperty("showInventory", "true");
        properties.setProperty("showStaffAccount", "true");
        properties.setProperty("showPatientAccount", "true");
        properties.setProperty("showUpdatePassword", "true");
        properties.setProperty("showNotifications", "true");
        properties.setProperty("showReports", "true");
        properties.setProperty("showAccountRecovery", "true");
        try (FileWriter writer = new FileWriter("checkboxes.properties")) {
            properties.store(writer, "Checkbox States");
        }

        loadDashboard();
    }

    private void loadDashboard() throws IOException {
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
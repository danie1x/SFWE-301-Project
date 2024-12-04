package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class accountRecoveryGUIController {

    @FXML
    private TextField recoveryEmailField;

    @FXML
    private TextField recoveryUsernameField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button recoverAccountButton;

    @FXML
    private Button changePasswordButton;

    @FXML
    private Button goBackButton;

    @FXML
    protected void onRecoverAccountClick() {
        // Handle recover account button click
        String email = recoveryEmailField.getText();
        String username = recoveryUsernameField.getText();

        // Implement account recovery logic here
        System.out.println("Account recovery initiated for: " + email + ", " + username);
    }

    @FXML
    protected void onChangePasswordClick() {
        // Handle change password button click
        String newPassword = newPasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // Implement password change logic here
        if (newPassword.equals(confirmPassword)) {
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Passwords do not match.");
        }
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
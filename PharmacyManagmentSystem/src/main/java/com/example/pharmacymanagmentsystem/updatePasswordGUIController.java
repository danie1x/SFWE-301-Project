package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class updatePasswordGUIController {

    @FXML
    private PasswordField currentPasswordField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button changePasswordButton;

    @FXML
    private Button goBackButton;

    @FXML
    protected void onChangePasswordClick() {
        // Handle change password button click
        String currentPassword = currentPasswordField.getText();
        String newPassword = newPasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (newPassword.equals(confirmPassword)) {
            // Implement password change logic here
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("New passwords do not match.");
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
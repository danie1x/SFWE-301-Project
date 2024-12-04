package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class createStaffAccountGUIController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button createAccountButton;

    @FXML
    private TableView<?> staffTable;

    @FXML
    private TableColumn<?, ?> staffUsernameColumn;

    @FXML
    private TableColumn<?, ?> staffNameColumn;

    @FXML
    private TableColumn<?, ?> staffRoleColumn;

    @FXML
    private Button deactivateAccountButton;

    @FXML
    private Button goBackButton;

    @FXML
    protected void onCreateAccountClick() {
        // Handle create account button click
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Implement account creation logic here
        System.out.println("Staff account created: " + firstName + " " + lastName + ", " + email + ", " + username);
    }

    @FXML
    protected void onDeactivateAccountClick() {
        // Handle deactivate account button click
        // Implement account deactivation logic here
        System.out.println("Staff account deactivated.");
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
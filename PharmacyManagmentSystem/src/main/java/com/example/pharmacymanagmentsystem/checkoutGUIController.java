package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class checkoutGUIController {

    @FXML
    private TextField cardNumberField;

    @FXML
    private TextField expirationDateField;

    @FXML
    private PasswordField cvvField;

    @FXML
    private Button completeCheckoutButton;

    @FXML
    private Button cancelCheckoutButton;

    @FXML
    private Button goBackButton;

    @FXML
    protected void onCompleteCheckoutClick() {
        // Handle complete checkout button click
        String cardNumber = cardNumberField.getText();
        String expirationDate = expirationDateField.getText();
        String cvv = cvvField.getText();

        // Implement checkout logic here
        System.out.println("Checkout completed with card: " + cardNumber + ", Expiration Date: " + expirationDate + ", CVV: " + cvv);
    }

    @FXML
    protected void onCancelCheckoutClick() {
        // Handle cancel checkout button click
        // Implement cancel logic here
        System.out.println("Checkout cancelled.");
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
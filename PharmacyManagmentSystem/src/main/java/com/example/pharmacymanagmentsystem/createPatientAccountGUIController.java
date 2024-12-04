package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class createPatientAccountGUIController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField insuranceField;

    @FXML
    private Button createPatientButton;

    @FXML
    private Button updatePatientButton;

    @FXML
    private Button removePatientButton;

    @FXML
    private Button goBackButton;

    @FXML
    protected void onCreatePatientClick() {
    }

    @FXML
    protected void onUpdatePatientClick() {
    }

    @FXML
    protected void onRemovePatientClick() {
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
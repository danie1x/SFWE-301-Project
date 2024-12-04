package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class prescriptionGUIController {

    @FXML
    private TextField patientNameField;

    @FXML
    private TextField doctorNameField;

    @FXML
    private TextArea prescriptionDetailsField;

    @FXML
    private Button acceptPrescriptionButton;

    @FXML
    private TextField medicineSearchField;

    @FXML
    private Button checkAvailabilityButton;

    @FXML
    private TableView<?> prescriptionTable;

    @FXML
    private TableColumn<?, ?> medicineNameColumn;

    @FXML
    private TableColumn<?, ?> quantityColumn;

    @FXML
    private TableColumn<?, ?> pharmacistNameColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private Button goBackButton;

    @FXML
    private Button fillPrescriptionButton;

    @FXML
    private Button trackPrescriptionButton;

    @FXML
    private TextArea activityLogField;

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


    @FXML
    protected void onAcceptPrescriptionClick() {
        // Handle accept prescription button click
    }

    @FXML
    protected void onCheckAvailabilityClick() {
        // Handle check availability button click
    }

    @FXML
    protected void onFillPrescriptionClick() {
        // Handle fill prescription button click
    }

    @FXML
    protected void onTrackPrescriptionClick() {
        // Handle track prescription button click
    }
}
package com.example.pharmacymanagmentsystem;

import com.example.pharmacymanagmentsystem.backend.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<Patient> patientTable;

    @FXML
    private TableColumn<Patient, String> patientNameColumn;

    @FXML
    private TableColumn<Patient, String> patientDobColumn;

    @FXML
    private TableColumn<Patient, String> patientEmailColumn;

    @FXML
    private TableColumn<Patient, String> patientPhoneColumn;

    @FXML
    private Button removePatientButton;

    private ObservableList<Patient> patientData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize the columns
        patientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        patientDobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
        patientEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        patientPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        // Load patient data
        loadPatientData();

        // Set the data to the table
        patientTable.setItems(patientData);
    }

    private void loadPatientData() {
        // Add sample data (replace with actual data loading logic)
        patientData.add(new Patient("John Doe", "1990-01-01", "john.doe@example.com", "1234567890"));
        patientData.add(new Patient("Jane Smith", "1985-05-15", "jane.smith@example.com", "0987654321"));
        // Add more patients as needed
    }

    @FXML
    private void onCreatePatientClick() {
        // Create a new patient and add to the table
        Patient newPatient = new Patient(
                nameField.getText(),
                dobField.getText(),
                addressField.getText(),
                phoneField.getText(),
                emailField.getText(),
                insuranceField.getText()
        );
        patientData.add(newPatient);
        clearFields();
    }

    @FXML
    private void onUpdatePatientClick() {
        // Update the selected patient details
        Patient selectedPatient = patientTable.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            selectedPatient.setName(nameField.getText());
            selectedPatient.setDob(dobField.getText());
            selectedPatient.setAddress(addressField.getText());
            selectedPatient.setPhone(phoneField.getText());
            selectedPatient.setEmail(emailField.getText());
            selectedPatient.setInsurance(insuranceField.getText());
            patientTable.refresh();
            clearFields();
        }
    }

    @FXML
    private void onRemovePatientClick() {
        // Remove the selected patient from the table
        Patient selectedPatient = patientTable.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            patientData.remove(selectedPatient);
        }
    }

    private void clearFields() {
        nameField.clear();
        dobField.clear();
        addressField.clear();
        phoneField.clear();
        emailField.clear();
        insuranceField.clear();
    }
}
package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class customizeDashboardController {
    @FXML private CheckBox prescriptionsCheckBox;
    @FXML private CheckBox checkoutCheckBox;
    @FXML private CheckBox inventoryCheckBox;
    @FXML private CheckBox staffAccountCheckBox;
    @FXML private CheckBox patientAccountCheckBox;
    @FXML private CheckBox updateAccountInformationCheckBox;
    @FXML private CheckBox notificationsCheckBox;
    @FXML private CheckBox reportsCheckBox;
    @FXML private CheckBox suppliesCheckBox;
    @FXML private Button saveButton;

    private DashboardModel model;

    public void setModel(DashboardModel model) {
        this.model = model;
        bindCheckBoxActions();
        loadCheckBoxStates();
    }

    private void bindCheckBoxActions() {
        model.showPrescriptionsProperty().bind(prescriptionsCheckBox.selectedProperty());
        model.showCheckoutProperty().bind(checkoutCheckBox.selectedProperty());
        model.showInventoryProperty().bind(inventoryCheckBox.selectedProperty());
        model.showStaffAccountProperty().bind(staffAccountCheckBox.selectedProperty());
        model.showPatientAccountProperty().bind(patientAccountCheckBox.selectedProperty());
        model.showUpdateAccountProperty().bind(updateAccountInformationCheckBox.selectedProperty());
        model.showNotificationsProperty().bind(notificationsCheckBox.selectedProperty());
        model.showReportsProperty().bind(reportsCheckBox.selectedProperty());
        model.showSuppliesProperty().bind(suppliesCheckBox.selectedProperty());
    }

    private void loadCheckBoxStates() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("checkboxes.properties")) {
            properties.load(input);
            prescriptionsCheckBox.setSelected(Boolean.parseBoolean(properties.getProperty("showPrescriptions", "false")));
            checkoutCheckBox.setSelected(Boolean.parseBoolean(properties.getProperty("showCheckout", "false")));
            inventoryCheckBox.setSelected(Boolean.parseBoolean(properties.getProperty("showInventory", "false")));
            staffAccountCheckBox.setSelected(Boolean.parseBoolean(properties.getProperty("showStaffAccount", "false")));
            patientAccountCheckBox.setSelected(Boolean.parseBoolean(properties.getProperty("showPatientAccount", "false")));
            updateAccountInformationCheckBox.setSelected(Boolean.parseBoolean(properties.getProperty("showUpdateAccount", "false")));
            notificationsCheckBox.setSelected(Boolean.parseBoolean(properties.getProperty("showNotifications", "false")));
            reportsCheckBox.setSelected(Boolean.parseBoolean(properties.getProperty("showReports", "false")));
            suppliesCheckBox.setSelected(Boolean.parseBoolean(properties.getProperty("showSupplies", "false")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onSaveButton() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("showPrescriptions", String.valueOf(prescriptionsCheckBox.isSelected()));
        properties.setProperty("showCheckout", String.valueOf(checkoutCheckBox.isSelected()));
        properties.setProperty("showInventory", String.valueOf(inventoryCheckBox.isSelected()));
        properties.setProperty("showStaffAccount", String.valueOf(staffAccountCheckBox.isSelected()));
        properties.setProperty("showPatientAccount", String.valueOf(patientAccountCheckBox.isSelected()));
        properties.setProperty("showUpdateAccount", String.valueOf(updateAccountInformationCheckBox.isSelected()));
        properties.setProperty("showNotifications", String.valueOf(notificationsCheckBox.isSelected()));
        properties.setProperty("showReports", String.valueOf(reportsCheckBox.isSelected()));
        properties.setProperty("showSupplies", String.valueOf(suppliesCheckBox.isSelected()));

        try (FileWriter writer = new FileWriter("checkboxes.properties")) {
            properties.store(writer, "Checkbox States");
        }

        FXMLLoader dashboardLoader = new FXMLLoader(Main.class.getResource("dashboardGUI.fxml"));
        Parent dashboardRoot = dashboardLoader.load();
        dashboardGUIController dashboardController = dashboardLoader.getController();
        dashboardController.setModel(model);

        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.setScene(new Scene(dashboardRoot));
        stage.setTitle("Dashboard");
        stage.show();
    }
}
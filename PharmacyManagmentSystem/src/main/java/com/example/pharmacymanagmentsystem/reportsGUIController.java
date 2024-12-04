package com.example.pharmacymanagmentsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class reportsGUIController {

    @FXML
    private TableView<?> transactionTable;

    @FXML
    private TableColumn<?, ?> transactionIdColumn;

    @FXML
    private TableColumn<?, ?> transactionTypeColumn;

    @FXML
    private TableColumn<?, ?> transactionDateColumn;

    @FXML
    private TableColumn<?, ?> transactionDetailsColumn;

    @FXML
    private TextField financialStartDateField;

    @FXML
    private TextField financialEndDateField;

    @FXML
    private TextField inventoryStartDateField;

    @FXML
    private TextField inventoryEndDateField;

    @FXML
    private Button generateFinancialReportButton;

    @FXML
    private Button generateInventoryReportButton;

    @FXML
    private Button saveReportButton;

    @FXML
    private Button exportReportButton;

    @FXML
    private Button goBackButton;

    @FXML
    protected void onGenerateFinancialReportClick() {
        // Handle generate financial report button click
        String startDate = financialStartDateField.getText();
        String endDate = financialEndDateField.getText();
        // Implement financial report generation logic here
        System.out.println("Generating financial report from " + startDate + " to " + endDate);
    }

    @FXML
    protected void onGenerateInventoryReportClick() {
        // Handle generate inventory report button click
        String startDate = inventoryStartDateField.getText();
        String endDate = inventoryEndDateField.getText();
        // Implement inventory report generation logic here
        System.out.println("Generating inventory report from " + startDate + " to " + endDate);
    }

    @FXML
    protected void onSaveReportClick() {
        // Handle save report button click
        // Implement save report logic here
        System.out.println("Saving report.");
    }

    @FXML
    protected void onExportReportClick() {
        // Handle export report button click
        // Implement export report logic here
        System.out.println("Exporting report.");
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
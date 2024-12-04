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

public class notificationsGUIController {

    @FXML
    private TableView<?> notificationsTable;

    @FXML
    private TableColumn<?, ?> notificationIdColumn;

    @FXML
    private TableColumn<?, ?> notificationTitleColumn;

    @FXML
    private TableColumn<?, ?> notificationDateColumn;

    @FXML
    private TableColumn<?, ?> notificationMessageColumn;

    @FXML
    private TextField notificationTitleField;

    @FXML
    private TextArea notificationMessageField;

    @FXML
    private Button addNotificationButton;

    @FXML
    private Button editNotificationButton;

    @FXML
    private Button deleteNotificationButton;

    @FXML
    private Button goBackButton;

    @FXML
    protected void onAddNotificationClick() {
        // Handle add notification button click
        String title = notificationTitleField.getText();
        String message = notificationMessageField.getText();

        // Implement add notification logic here
        System.out.println("Adding notification: " + title + " - " + message);
    }

    @FXML
    protected void onEditNotificationClick() {
        // Handle edit notification button click
        // Implement edit notification logic here
        System.out.println("Editing selected notification.");
    }

    @FXML
    protected void onDeleteNotificationClick() {
        // Handle delete notification button click
        // Implement delete notification logic here
        System.out.println("Deleting selected notification.");
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
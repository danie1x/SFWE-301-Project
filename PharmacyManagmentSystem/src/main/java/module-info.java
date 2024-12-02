module com.example.pharmacymanagmentsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pharmacymanagmentsystem to javafx.fxml;
    exports com.example.pharmacymanagmentsystem;
}
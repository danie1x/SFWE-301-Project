package com.example.pharmacymanagmentsystem;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class DashboardModel {
    private final BooleanProperty showPrescriptions = new SimpleBooleanProperty(true);
    private final BooleanProperty showCheckout = new SimpleBooleanProperty(true);
    private final BooleanProperty showInventory = new SimpleBooleanProperty(true);
    private final BooleanProperty showStaffAccount = new SimpleBooleanProperty(true);
    private final BooleanProperty showPatientAccount = new SimpleBooleanProperty(true);
    private final BooleanProperty showUpdateAccount = new SimpleBooleanProperty(true);
    private final BooleanProperty showNotifications = new SimpleBooleanProperty(true);
    private final BooleanProperty showReports = new SimpleBooleanProperty(true);
    private final BooleanProperty showSupplies = new SimpleBooleanProperty(true);

    // Getters and setters for each property
    public BooleanProperty showPrescriptionsProperty() { return showPrescriptions; }
    public BooleanProperty showCheckoutProperty() { return showCheckout; }
    public BooleanProperty showInventoryProperty() { return showInventory; }
    public BooleanProperty showStaffAccountProperty() { return showStaffAccount; }
    public BooleanProperty showPatientAccountProperty() { return showPatientAccount; }
    public BooleanProperty showUpdateAccountProperty() { return showUpdateAccount; }
    public BooleanProperty showNotificationsProperty() { return showNotifications; }
    public BooleanProperty showReportsProperty() { return showReports; }
    public BooleanProperty showSuppliesProperty() { return showSupplies; }
}

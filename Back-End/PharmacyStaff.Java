package Back-End;

import java.util.Date;


public class PharmacyStaff {
    // Attributes for the pharmacy staff member
    private int employeeId;
    private String name;
    private String workEmail;
    private String licenseNumber;
    private Date licenseExpirationDate;
    private String role; // ex pharmacist, pharmacy manager, etc.

//Anything else to add??

    // Constructor
    public PharmacyStaff(int employeeId, String name, String workEmail, String licenseNumber, Date licenseExpirationDate, 
    String role) {
        this.employeeId = employeeId;
        this.name = name;
        this.workEmail = workEmail;
        this.licenseNumber = licenseNumber;
        this.licenseExpirationDate = licenseExpirationDate;
        this.role = role;
    }

    // Default constructor
    public PharmacyStaff() {}

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    public void setLicenseExpirationDate(Date licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
    
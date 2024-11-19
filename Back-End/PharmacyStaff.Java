package Back-End;

import java.util.Date;


public class PharmacyStaff {
    // Attributes for the pharmacy staff member
    private int employeeId;
    private String name;
    private String workEmail;
    private String licenseNumber;
    private Date licenseExpirationDate;
    private String role; // ex. "pharmacist", "pharmacy manager", etc.

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



}
    
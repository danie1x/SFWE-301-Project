package Back-End;

import java.util.Date;


public class PharmacyStaff {
    // Attributes for the pharmacy staff member
    private int employeeUsername;
    private int employeePassword;
    private String firstName;
    private String lastName;
    private String workEmail;
    private String role; // ex pharmacist, pharmacy manager, etc.

//Anything else to add??

    // Constructor
    public PharmacyStaff(String employeeUsername, String employeePassword, String firstName, String lastName, String workEmail, String role) {
        this.employeeUsername = employeeUsername;
        this.employeePassword = employeePassword;
        this.name = firstName;
        this.name = lastName;
        this.workEmail = workEmail;
        this.role = role;
    }

    // Default constructor
    public PharmacyStaff() {}

    // Getters and Setters

}
    

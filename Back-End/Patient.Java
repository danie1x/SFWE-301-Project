package Back-End;
import java.util.List;


public class Patient {
    // Attributes for the patient
    private String name;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private String insuranceId;

    // Constructor
    public Patient( String name, 
                    String dateOfBirth, 
                    String address, 
                    String phoneNumber, 
                    String email, 
                    String insuranceId) {

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.insuranceId = insuranceId;
    }

    // Default constructor
    public Patient() {
        this.name = "";
        this.dateOfBirth = "";
        this.address = "";
        this.phoneNumber = "";
        this.email = "";
        this.insuranceId = "";
    }

    // Getters for each attribute
    public String getName() { return name; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getInsuranceId() { return insuranceId; }

    // Setters for each attribute
    public void setName(String name) { this.name = name;}
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth;}
    public void setAddress(String address) { this.address = address;}
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber;}
    public void setEmail(String email) { this.email = email;}
    public void setInsuranceId(String insuranceId) { this.insuranceId = insuranceId;}
}
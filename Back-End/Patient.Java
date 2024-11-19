package Back-End;
import java.util.Date;
import java.util.List;


public class Patient {
    // Attributes for the patient
    private int patientId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private String homeAddress;
    private List<String> knownAllergies;
    private String primaryCarePhysician;
    private String specialMedicalConcerns;


    // Constructor
    public Patient(int patientId, String firstName, String lastName, Date dateOfBirth, String phoneNumber, String email, 
                   String homeAddress, List<String> knownAllergies, String primaryCarePhysician, String specialMedicalConcerns) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.homeAddress = homeAddress;
        this.knownAllergies = knownAllergies;
        this.primaryCarePhysician = primaryCarePhysician;
        this.specialMedicalConcerns = specialMedicalConcerns;
   
    }

    // Default constructor
    public Patient() {}

    // Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public List<String> getKnownAllergies() {
        return knownAllergies;
    }

    public void setKnownAllergies(List<String> knownAllergies) {
        this.knownAllergies = knownAllergies;
    }

    public String getPrimaryCarePhysician() {
        return primaryCarePhysician;
    }

    public void setPrimaryCarePhysician(String primaryCarePhysician) {
        this.primaryCarePhysician = primaryCarePhysician;
    }

    public String getSpecialMedicalConcerns() {
        return specialMedicalConcerns;
    }

    public void setSpecialMedicalConcerns(String specialMedicalConcerns) {
        this.specialMedicalConcerns = specialMedicalConcerns;
    }
    
}
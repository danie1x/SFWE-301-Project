package Back-End;
import java.util.Date;
import java.util.List;


public class Patient {
    // Attributes for the patient
    private int patientId;
    private String lastName;
    private String firstName;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private String homeAddress;
    private List<String> knownAllergies;
    private String primaryCarePhysician;
    private int insuranceId;
    private String specialMedicalConcerns;


    // Constructor
    public Patient(int patientId, 
                   String lastName, 
                   String firstName, 
                   Date dateOfBirth, 
                   String phoneNumber, 
                   String email, 
                   String homeAddress, 
                   List<String> knownAllergies, 
                   String primaryCarePhysician, 
                   int insuranceId,
                   String specialMedicalConcerns) {

        this.patientId = patientId;        
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.homeAddress = homeAddress;
        this.knownAllergies = knownAllergies;
        this.primaryCarePhysician = primaryCarePhysician;
        this.insuranceId = insuranceId;
        this.specialMedicalConcerns = specialMedicalConcerns;
   
    }

    // Default constructor
    public Patient() {}

    // Getters and Setters
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getHomeAddress() { return homeAddress; }
    public void setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; }

    public List<String> getKnownAllergies() { return knownAllergies; }
    public void setKnownAllergies(List<String> knownAllergies) { this.knownAllergies = knownAllergies; }

    public String getPrimaryCarePhysician() { return primaryCarePhysician; }
    public void setPrimaryCarePhysician(String primaryCarePhysician) { this.primaryCarePhysician = primaryCarePhysician; }

    public int getInsuranceId() { return insuranceId; }
    public void setInsuranceId(int insuranceId) { this.insuranceId = insuranceId; }    
    
    public String getSpecialMedicalConcerns() { return specialMedicalConcerns; }
    public void setSpecialMedicalConcerns(String specialMedicalConcerns) { this.specialMedicalConcerns = specialMedicalConcerns; }
    
}
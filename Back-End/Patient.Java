package Back-End;

import java.util.Date;
import java.util.List;

public class Patient {
    // Attributes for the patient
    private int patientId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String contactPhone;
    private String contactEmail;
    private String homeAddress;
    private List<String> allergies; //allergies?
    private String primaryCarePhysician;
    private String specialMedicalConcerns;


    // Constructor
    public Patient(int patientId, String firstName, String lastName, Date dateOfBirth, String contactPhone,
    String contactEmail, String homeAddress, List<String> allergies, String primaryCarePhysician,
    String specialMedicalConcerns) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.homeAddress = homeAddress;
        this.allergies = allergies;
        this.primaryCarePhysician = primaryCarePhysician;
        this.specialMedicalConcerns = specialMedicalConcerns;
    }
}
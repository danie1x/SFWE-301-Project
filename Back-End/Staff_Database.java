import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class Staff_Database {
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
/// 
/// Methods
/// 
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    // Method for adding a Patient
    public static void addPatient(Patient patient) {
        String filePath = "patient_database.csv";
        File file = new File(filePath);

        // Check if the patient already exists
        if (isPatientExists(patient.getName(), filePath)) {
            System.out.println("Patient already exists: " + patient.getName());
            return;
        }
    
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.append(patient.getName());
            writer.append(",");
            writer.append(patient.getDateOfBirth());
            writer.append(",");
            writer.append(patient.getAddress());
            writer.append(",");
            writer.append(patient.getPhoneNumber());
            writer.append(",");
            writer.append(patient.getEmail());
            writer.append(",");
            writer.append(patient.getInsuranceId());
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to check if a patient exists
    private static boolean isPatientExists(String name, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0 && fields[0].equals(name)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    // Method for finding a Patient by name
    public static String[] findPatientByName(String name) {
        String filePath = "patient_database.csv";
        String[] result = null;

        // Iterate through the file to find the Patient
        try {

            // Read the file into memory
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    // Check if this is the Patient to return
                    if (values[0].equals(name)) {
                        result = values;
                        break; // Exit the loop once the Patient is found
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
    }

    return result;
}

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    // Method for testing a dummy Patient
    public static void testAddPatient() {
        Patient dummyPatient = new Patient( "Jane", 
                                            "01/01/2000",
                                            "123 Arizona Ave.", 
                                            "555-555-5555", 
                                            "jDoe@catmail.com",
                                            "00001");

        addPatient(dummyPatient);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    // Method for setting up the csv file
    public static void setupFile() {
        String filePath = "patient_database.csv";
        String[] headers = { "name", 
                             "dateOfBirth",
                             "address", 
                             "phoneNumber", 
                             "email", 
                             "insuranceId" };
        File file = new File(filePath);

        try {
            boolean fileExists = file.exists();

            // If the file does not exist, write headers -- Open FileWriter in append mode
            try (FileWriter writer = new FileWriter(filePath, true)) {
                // If the file does not exist, write headers
                if (!fileExists) {
                    writer.write(String.join(",", headers) + "\n");
                    System.out.println("File created successfully.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
/// 
/// MAIN
/// 
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        // Setup the file
        setupFile();

        // Add a Patient
        testAddPatient();

        // Try printing the Patient with name "Jane"
        String[] Patient = findPatientByName("Jane");
        System.out.println(Patient[0]);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
/// 
/// Including this here because I can't figure out how to import it
/// 
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    public static class Patient {
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
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class Patient_Database {
    private static final String FILE_PATH = "Back-End/patient_database.csv";
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
/// 
/// Methods
/// 
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    // Method for adding a Patient
    public static void addPatient(Patient patient) {
        String filePath = FILE_PATH;
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
            writer.append(",");
            writer.append(patient.getIsActive().toString());
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

    // Method for modifying a Patient
    public static void modifyPatient(String name, Patient newPatient) {
        String filePath = FILE_PATH;
        String tempFilePath = "temp_patient_database.csv";
        File file = new File(filePath);
        File tempFile = new File(tempFilePath);

        // Check if the patient exists
        if (!isPatientExists(name, filePath)) {
            System.out.println("Patient does not exist: " + name);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             FileWriter writer = new FileWriter(tempFilePath, true)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0 && fields[0].equals(name)) {
                    writer.append(newPatient.getName());
                    writer.append(",");
                    writer.append(newPatient.getDateOfBirth());
                    writer.append(",");
                    writer.append(newPatient.getAddress());
                    writer.append(",");
                    writer.append(newPatient.getPhoneNumber());
                    writer.append(",");
                    writer.append(newPatient.getEmail());
                    writer.append(",");
                    writer.append(newPatient.getInsuranceId());
                    writer.append(",");
                    writer.append(newPatient.getIsActive().toString());
                    writer.append("\n");
                } else {
                    writer.append(line);
                    writer.append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete the original file
        file.delete();

        // Rename the temp file to the original file
        tempFile.renameTo(file);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    // Method for deleting a Patient
    public static void deletePatient(String name) {
        String filePath = FILE_PATH;
        String tempFilePath = "temp_patient_database.csv";
        File file = new File(filePath);
        File tempFile = new File(tempFilePath);

        // Check if the patient exists
        if (!isPatientExists(name, filePath)) {
            System.out.println("Patient does not exist: " + name);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             FileWriter writer = new FileWriter(tempFilePath, true)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0 && fields[0].equals(name)) {
                    continue;
                }
                writer.append(line);
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
    
    // Method for finding a Patient by name
    public static Patient findPatientByName(String name) {
        String filePath = FILE_PATH;
        Patient result = null;

        // Iterate through the file to find the Patient
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                // Check if this is the Patient to return
                if (values[0].equals(name)) {
                    result = new Patient(values[0], values[1], values[2], values[3], values[4], values[5], Boolean.parseBoolean(values[6]));
                    break; // Exit the loop once the Patient is found
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
        Patient planeJane = new Patient( "Jane", 
                                            "01/01/2000",
                                            "123 Arizona Ave.", 
                                            "555-555-5555", 
                                            "jDoe@catmail.com",
                                            "00001",
                                            true);

        addPatient(planeJane);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    // Method for setting up the csv file
    public static void setupFile() {
        String filePath = FILE_PATH;
        String[] headers = { "name", 
                             "dateOfBirth",
                             "address", 
                             "phoneNumber", 
                             "email", 
                             "insuranceId",
                             "isActive?"};
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

        // BACK-END TEST 1
        /*
        // Add a Patient
        String testName = "Jane";

        // Check if the patient is in the database
        Patient foundPatient = findPatientByName(testName);
        if (foundPatient != null) {
            System.out.println("Database contains " + testName + " record. Status: " + (foundPatient.getIsActive() ? "Active" : "Inactive"));
        } else {
            System.out.println("Database does not contain " + testName + " record");
        }
                
        Patient plainJane = new Patient("Jane", 
                                         "01/01/1980",
                                         "123 Main St.", 
                                         "555-555-1234", 
                                         "jDoe@catmail.com",
                                         "12345",
                                         true);
        addPatient(plainJane);

        // Update the foundPatient variable after adding the patient
        foundPatient = findPatientByName(testName);
        if (foundPatient != null) {
            System.out.println("Database contains " + testName + " record. Status: " + (foundPatient.getIsActive() ? "Active" : "Inactive"));
        } else {
            System.out.println("Database does not contain " + testName + " record");
        }

        // Set the Patient as inactive
        plainJane.setIsActive(false, true);
        modifyPatient(testName, plainJane);

        // Verify the Patient is set as inactive
        foundPatient = findPatientByName(testName);
        if (foundPatient != null) {
            System.out.println("Database contains " + testName + " record. Status: " + (foundPatient.getIsActive() ? "Active" : "Inactive"));
        } else {
            System.out.println("Database does not contain " + testName + " record");
        }
        // END BACK-END TEST 1
        */
        
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
        private Boolean isActive;
    
        // Constructor
        public Patient( String name, 
                        String dateOfBirth, 
                        String address, 
                        String phoneNumber, 
                        String email, 
                        String insuranceId,
                        Boolean isActive) {
    
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.insuranceId = insuranceId;
            this.isActive = isActive;
        }
    
        // Default constructor
        public Patient() {
            this.name = "";
            this.dateOfBirth = "";
            this.address = "";
            this.phoneNumber = "";
            this.email = "";
            this.insuranceId = "";
            this.isActive = true;
        }
    
        // Getters for each attribute
        public String getName() { return name; }
        public String getDateOfBirth() { return dateOfBirth; }
        public String getAddress() { return address; }
        public String getPhoneNumber() { return phoneNumber; }
        public String getEmail() { return email; }
        public String getInsuranceId() { return insuranceId; }
        public Boolean getIsActive() { return isActive; }
    
        // Setters for each attribute
        public void setName(String name, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.name = name;
        }
        public void setDateOfBirth(String dateOfBirth, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.dateOfBirth = dateOfBirth;
        }
        public void setAddress(String address, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.address = address;
        }
        public void setPhoneNumber(String phoneNumber, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.phoneNumber = phoneNumber;
        }
        public void setEmail(String email, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.email = email;
        }
        public void setInsuranceId(String insuranceId, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.insuranceId = insuranceId;
        }
        public void setIsActive(Boolean isActive, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.isActive = isActive;
        }
    }
}

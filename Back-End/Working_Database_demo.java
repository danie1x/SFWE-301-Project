import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class Working_Database_demo {
    public static void main(String[] args) throws IOException {

    String filePath = "working_database.csv";
    String[] headers = {  "username", 
                          "lastName", 
                          "firstName", 
                          "dateOfBirth", 
                          "phoneNumber", 
                          "email", 
                          "homeAddress", 
                          "knownAllergies", 
                          "primaryCarePhysician", 
                          "insuranceId", 
                          "specialMedicalConcerns"};

    File file = new File(filePath);

    try {        
        boolean fileExists = file.exists();

    // If the file does not exist, write headers -- Open FileWriter in append mode
    try (FileWriter writer = new FileWriter(filePath, true)) {
        // If the file does not exist, write headers
        if (!fileExists) {
            writer.write(String.join(",", headers) + "\n");
        }

    }
        System.out.println("File created succesfully.");

    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }

    // Update a record
    List<String> lines = new ArrayList<>();
    boolean record_updated = false;

    // Read the file into memory, modifying the target row
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            // Check if this is the row to update
            if (values[0].equals(targetID)) {
                values[4] = newExpiry;
                record_updated = true;
                System.out.println("Updated ID " + targetID + " with new expiry: " + newExpiry);
            }
            lines.add(String.join(",", values));
        }
        reader.close();
    } catch (IOException e) {
        System.out.println("Error reading file for update: " + e.getMessage());
    }










    // Read the file
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            System.out.println("ID: " + values[0] + ", Name: " + values[1] + ", Email: " + values [2] + ", License: " + values[3] + ", License expiry: " + values[4]);
        }

        reader.close();
    } catch (IOException e) {
        System.out.println( "Error reading file: " + e.getMessage());
    }

    

    // Rewrite the file with the updated content
    try (FileWriter writer = new FileWriter(filePath)) {
        for (String line : lines) {
            writer.write(line + "\n");
        }
        if (!record_updated) {
            System.out.println("ID " + targetID + " not found. No updates made.");
        }
        writer.close();
    } catch (IOException e) {
        System.out.println("Error writing updated file: " + e.getMessage());
    }
    }

    // Method to create a new patient record
    public static void createPatient(int patientId, 
                                     String lastName, 
                                     String firstName, 
                                     String dateOfBirth,
                                     String phoneNumber, 
                                     String email, 
                                     String homeAddress, 
                                     List<String> knownAllergies,
                                     String primaryCarePhysician, 
                                     int insuranceId, 
                                     String specialMedicalConcerns) {

        try (FileWriter writer = new FileWriter(filePath, true)) {
            String record = String.join(",", patientId, firstName, lastName, dateOfBirth, phoneNumber, email,
                    homeAddress, knownAllergies, primaryCarePhysician, insuranceId, specialMedicalConcerns);
            writer.write(record + "\n");
            System.out.println("Patient record created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating patient record: " + e.getMessage());
        }
    }
}

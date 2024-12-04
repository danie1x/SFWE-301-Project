package BackEnd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class Patient_Database {

    // Method for adding a Patient
    public static void addPatient(String[] Patient) {
        String filePath = "patient_database.csv";
        File file = new File(filePath);

        try (FileWriter writer = new FileWriter(file, true)) {
            for (int i = 0; i < Patient.length; i++) {
                writer.append(Patient[i]);
                if (i < Patient.length - 1) {
                    writer.append(",");
                }
            }
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method for finding a Patient by name
    public static String[] findPatientByName(String name) {
        String filePath = "patient_database.csv";
        File file = new File(filePath);
        String[] result = null;

        // Iterate through the file to find the Patient
        try {
            List<String> lines = new ArrayList<>();
            boolean Patient_found = false;

            // Read the file into memory
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    // Check if this is the Patient to return
                    if (values[0].equals(name)) {
                        Patient_found = true;
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

    // Method for testing a dummy Patient
    public static int testAddPatient() {
        String[] dummyPatient = { 
                            "Jane", 
                            "01/01/2000",
                            "123 Arizona Ave.", 
                            "555-555-5555", 
                            "jDoe@catmail.com",
                            "00001"};
        addPatient(dummyPatient);
        String[] testPatient = findPatientByName(dummyPatient[0]);
        System.out.println(testPatient[0] + "test successful.");
        return 1;
    }

    // Method for setting up the csv file
    public static void setupFile() {
        String filePath = "patient_database.csv";
        String[] headers = {  "name", 
                                "dateOfBirth",
                                "address", 
                                "phoneNumber", 
                                "email", 
                                "insuranceId"};
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
    }
    
    public static void main(String[] args) {
        // Setup the file
        setupFile();

        // Add a Patient
        //testAddPatient();

        // Try printing the Patient with name "Jane"
        String[] Patient = findPatientByName("Jane");
        System.out.println(Patient[1]);
    }
}

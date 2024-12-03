import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class Working_Database {

    // Method for adding a record
    public static void addRecord(String[] record) {
        String filePath = "working_database.csv";
        File file = new File(filePath);

        try (FileWriter writer = new FileWriter(file, true)) {
            for (int i = 0; i < record.length; i++) {
                writer.append(record[i]);
                if (i < record.length - 1) {
                    writer.append(",");
                }
            }
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method for finding a record by username
public static String[] findRecordByName(String name) {
    String filePath = "working_database.csv";
    File file = new File(filePath);
    String[] result = null;

    // Iterate through the file to find the record
    try {
        List<String> lines = new ArrayList<>();
        boolean record_found = false;

        // Read the file into memory
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                // Check if this is the record to return
                if (values[0].equals(name)) {
                    record_found = true;
                    result = values;
                    break; // Exit the loop once the record is found
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return result;
}

    // Method for testing a dummy record
    public static void testAddRecord() {
        String[] record = { 
                            "Jane", 
                            "01/01/2000",
                            "123 Arizona Ave.", 
                            "555-555-5555", 
                            "jDoe@catmail.com",
                            "00001"};
        addRecord(record);
    }

    // Method for testing the return of the record "jDoe"
    
    public static void main(String[] args) {
        // Setting up the csv file
        String filePath = "working_database.csv";
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

        // Add a record
        testAddRecord();

        // Try printing the record with name "Jane"
        String[] record = findRecordByName("Jane");
        System.out.println(record[0]);





    }
}

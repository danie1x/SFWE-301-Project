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

    // Method for adding a Staff Member
    public static void addStaff(Staff staff) {
        String filePath = "staff_database.csv";
        File file = new File(filePath);

        // Check if the patient already exists
        if (isStaffExists(staff.getName(), filePath)) {
            System.out.println("Staff member already exists: " + staff.getName());
            return;
        }
    
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.append(staff.getName());
            writer.append(",");
          
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to check if a staff member exists
    private static boolean isStaffExists(String name, String filePath) {
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
    public static String[] findStaffByName(String name) {
        String filePath = "staff_database.csv";
        String[] result = null;

        // Iterate through the file to find the Staff Member
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

    // Method for testing a dummy Staff Member
    public static void testAddStaff() {
        Staff dummyStaff = new Staff( "Joe");

        addStaff(dummyStaff);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    // Method for setting up the csv file
    public static void setupFile() {
        String filePath = "staff_database.csv";
        String[] headers = { "name"
    };
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

        // Add a Staff Member
        testAddStaff();

        // Try printing the Staff Member with name "Joe"
        String[] Staff = findStaffByName("Joe");
        System.out.println(Staff[0]);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
/// 
/// Including this here because I can't figure out how to import it
/// 
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    public static class Staff {
        // Attributes for the staff member
        private String name;
    
        // Constructor
        public Staff( String name) {
    
            this.name = name;
        }
    
        // Default constructor
        public Staff() {
            this.name = "";
        }
    
        // Getters for each attribute
        public String getName() { return name; }
    
        // Setters for each attribute
        public void setName(String name) { this.name = name;}
}
}
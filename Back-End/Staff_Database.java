import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class Staff_Database {
    private static final String FILE_PATH = "Back-End/staff_database.csv";
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
/// 
/// Methods
/// 
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    // Method for adding a Staff Member
    public static void addStaff(Staff staff) {
        String filePath = FILE_PATH;
        File file = new File(filePath);

        // Check if the staff member already exists
        if (isStaffExists(staff.getFirstName(), filePath)) {
            System.out.println("Staff member already exists: " + staff.getFirstName());
            return;
        }
    
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.append(staff.getFirstName());
            writer.append(",");
            writer.append(staff.getLastName());
            writer.append(",");
            writer.append(staff.getEmail());
            writer.append(",");
            writer.append(staff.getUsername());
            writer.append(",");
            writer.append(staff.getPassword());
            writer.append(",");
            writer.append(staff.getIsActive().toString());
            writer.append(",");
            writer.append(staff.getIsAdmin().toString());
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

    // Method for modifying a Staff Member
    public static void modifyStaff(String name, Staff staff) {
        String filePath = FILE_PATH;
        String tempFilePath = "Back-End/temp_staff_database.csv";
        File file = new File(filePath);
        File tempFile = new File(tempFilePath);

        // Check if the staff member exists
        if (!isStaffExists(name, filePath)) {
            System.out.println("Staff member does not exist: " + name);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             FileWriter writer = new FileWriter(tempFilePath, true)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0 && fields[0].equals(name)) {
                    writer.append(staff.getFirstName());
                    writer.append(",");
                    writer.append(staff.getLastName());
                    writer.append(",");
                    writer.append(staff.getEmail());
                    writer.append(",");
                    writer.append(staff.getUsername());
                    writer.append(",");
                    writer.append(staff.getPassword());
                    writer.append(",");
                    writer.append(staff.getIsActive().toString());
                    writer.append(",");
                    writer.append(staff.getIsAdmin().toString());
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

    // Method for deleting a staff member
    public static void deleteStaff(String name) {
        String filePath = FILE_PATH;
        String tempFilePath = "Back-End/temp_staff_database.csv";
        File file = new File(filePath);
        File tempFile = new File(tempFilePath);

        // Check if the staff member exists
        if (!isStaffExists(name, filePath)) {
            System.out.println("Staff member does not exist: " + name);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             FileWriter writer = new FileWriter(tempFilePath, true)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0 && fields[0].equals(name)) {
                    continue;
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

    // Method for finding a staff member by name
    public static Staff findStaffByName(String name) {
        String filePath = FILE_PATH;
        Staff result = null;

        // Iterate through the file to find the Staff Member
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                // Check if this is the staff member to return
                if (values[0].equals(name)) {
                    result = new Staff(values[0], values[1], values[2], values[3], values[4], Boolean.parseBoolean(values[5]), Boolean.parseBoolean(values[6]));
                    break; // Exit the loop once the staff member is found
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
        Staff plainJane = new Staff("Jane", 
                                     "Doe", 
                                     "jDoe@catmail.com", 
                                     "jDoe", 
                                     "password123",
                                     true,
                                     false);

        addStaff(plainJane);
    }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////

    // Method for setting up the csv file
    public static void setupFile() {
        String filePath = FILE_PATH;
        String[] headers = { "firstName",
                             "lastName",
                             "email",
                             "username",
                             "password",
                             "isActive",
                             "isAdmin" };
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

        // BACK-END TEST 2
        /*
        // Add a Staff Member
        String testName = "Jane";

        // Check if the staff member is in the database
        Staff foundStaff = findStaffByName(testName);
        if (foundStaff != null) {
            System.out.println("Database contains " + testName + " record. Status: " + (foundStaff.getIsActive() ? "Active" : "Inactive"));
        } else {
            System.out.println("Database does not contain " + testName + " record");
        }
                
        Staff plainJane = new Staff("Jane", 
                                    "Doe",
                                    "jDoe@catmail.com",
                                    "jane_doe",
                                    "password123",
                                    true,
                                    false);
        addStaff(plainJane);

        // Update the foundStaff variable after adding the staff member
        foundStaff = findStaffByName(testName);
        if (foundStaff != null) {
            System.out.println("Database contains " + testName + " record. Status: " + (foundStaff.getIsActive() ? "Active" : "Inactive"));
        } else {
            System.out.println("Database does not contain " + testName + " record");
        }

        // Set the Staff Member as inactive
        plainJane.setIsActive(false, true);
        modifyStaff(testName, plainJane);

        // Verify the Staff Member is set as inactive
        foundStaff = findStaffByName(testName);
        if (foundStaff != null) {
            System.out.println("Database contains " + testName + " record. Status: " + (foundStaff.getIsActive() ? "Active" : "Inactive"));
        } else {
            System.out.println("Database does not contain " + testName + " record");
        }
        // END BACK-END TEST 2
        */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        // BACK-END TEST 4
        /*
        // Add a Patient
        String testName = "Jane";
        Staff plainJane = new Staff("Jane", 
                                     "Doe", 
                                     "jDoe@catmail.com", 
                                     "jDoe", 
                                     "password123",
                                     true,
                                     false);
        addStaff(plainJane);

        // Check if the patient is in the database
        Staff foundStaff = findStaffByName(testName);
        if (foundStaff != null) {
            System.out.println("Database contains " + testName + " record. Last name: " + (foundStaff.getLastName()));
        } else {
            System.out.println("Database does not contain " + testName + " record");
        }

        // Attempt to change the last name
        plainJane.setLastName("Fonda", false);
        modifyStaff(testName, plainJane);
        foundStaff = findStaffByName(testName);

        // Reattempt to change the last name
        plainJane.setLastName("Fonda", true);
        modifyStaff(testName, plainJane);
        foundStaff = findStaffByName(testName);
        if (foundStaff != null) {
            System.out.println("Database contains " + testName + " record. Last Name: " + (foundStaff.getLastName()));
        } else {
            System.out.println("Database does not contain " + testName + " record");
        }
        // END BACK-END TEST 4
        */
        

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
        private String firstName;
        private String lastName;
        private String email;
        private String username;
        private String password; // TO DO: Hash this
        private Boolean isActive;
        private Boolean isAdmin = false;
    
        // Constructor
        public Staff( String firstName,
                      String lastName,
                      String email,
                      String username,
                      String password,
                      Boolean isActive,
                      Boolean isAdmin) {
    
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.username = username;
            this.password = password;
            this.isActive = isActive;
            this.isAdmin = isAdmin;
        }
    
        // Default constructor
        public Staff() {
            this.firstName = "";
            this.lastName = "";
            this.email = "";
            this.username = "";
            this.password = "";
            this.isActive = true;
            this.isAdmin = false;
        }
    
        // Getters for each attribute
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getEmail() { return email; }
        public String getUsername() { return username; }
        public String getPassword() { return password; } // TO DO: ???
        public Boolean getIsActive() { return isActive; }
        public Boolean getIsAdmin() { return isAdmin; }
    
        // Setters for each attribute with permission check
        public void setFirstName(String firstName, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.firstName = firstName;
        }

        public void setLastName(String lastName, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.lastName = lastName;
        }

        public void setEmail(String email, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.email = email;
        }

        public void setUsername(String username, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.username = username;
        }

        public void setPassword(String password, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.password = password;
        }

        public void setIsActive(Boolean isActive, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.isActive = isActive;
        }

        public void setIsAdmin(Boolean isAdmin, Boolean permission) { 
            if (!permission) {
                System.out.println("You do not have permission to change this attribute.");
                return;
            }
            this.isAdmin = isAdmin;
        }
    }
}
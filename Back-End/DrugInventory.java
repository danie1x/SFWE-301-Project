import java.io.*;
import java.util.*;

// Class representing a Drug
class Drug {
    private int id;
    private String name;
    private int quantity;
    private double price;

    // Constructor
    public Drug(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + quantity + "," + price;
    }
}

public class DrugInventory {

    private static final String CSV_FILE = "data/inventory.csv";

    // Method to read inventory from the CSV file
    public static List<Drug> readInventory() {
        List<Drug> drugs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                int quantity = Integer.parseInt(values[2]);
                double price = Double.parseDouble(values[3]);
                drugs.add(new Drug(id, name, quantity, price));
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
        return drugs;
    }

    // Method to write inventory back to the CSV file
    public static void writeInventory(List<Drug> drugs) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE))) {
            bw.write("ID,Name,Quantity,Price\n"); // Header
            for (Drug drug : drugs) {
                bw.write(drug.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        List<Drug> drugs = readInventory();

        System.out.println("Current Inventory:");
        for (Drug drug : drugs) {
            System.out.println(drug);
        }

        // Example: Adding a new drug to the inventory
        Drug newDrug = new Drug(31, "NewDrug", 50, 9.99);
        drugs.add(newDrug);
        writeInventory(drugs);

        System.out.println("\nUpdated Inventory:");
        drugs = readInventory(); // Reload the updated CSV
        for (Drug drug : drugs) {
            System.out.println(drug);
        }
    }
}
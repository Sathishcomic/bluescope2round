package bluescopeinterview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeProcessor {

    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String uniqueNamesFile = "uniquenames.csv";
        String ageGroupFile = "agegroup20to30.csv";

        try {
            removeDuplicatesAndSaveUniqueNames(inputFile, uniqueNamesFile);
            System.out.println("Unique names saved to " + uniqueNamesFile);

            filterByAgeGroupAndSave(inputFile, ageGroupFile, 20, 30);
            System.out.println("Employees in the age group 20 to 30 saved to " + ageGroupFile);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void removeDuplicatesAndSaveUniqueNames(String inputFile, String outputFile) throws IOException {
        Set<String> uniqueNames = new HashSet<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1) {
                    uniqueNames.add(parts[0].trim());
                }
            }

            for (String name : uniqueNames) {
                writer.println(name);
            }
        }
    }

    public static void filterByAgeGroupAndSave(String inputFile, String outputFile, int minAge, int maxAge) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    int age = Integer.parseInt(parts[1].trim());
                    if (age >= minAge && age <= maxAge) {
                        writer.println(line);
                    }
                }
            }
        }
    }
}

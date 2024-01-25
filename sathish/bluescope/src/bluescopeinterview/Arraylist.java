package bluescopeinterview;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Arraylist{

    public static void main(String[] args) {
        ArrayList<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(" John ",26," HR "));
        employeeList.add(new Employee(" Kumar",32," Systems "));
        employeeList.add(new Employee(" Ram ",31," HR "));
        employeeList.add(new Employee(" Ram " ,36," Systems "));
        employeeList.add(new Employee(" John ",21," Admin "));
      
        removeDuplicate(employeeList);
        customSortByName(employeeList);

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        String outputFile = "output.txt";
        saveArrayListToFile(employeeList, outputFile);
        System.out.println("ArrayList saved to " + outputFile);
    }

    public  static class Employee {
        private String name;
        private int age;
        private String department;

        public Employee(String name, int age, String department) {
            this.name = name;
            this.age = age;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return name + ", " + age + ", " + department;
        }
    }

    public static void customSortByName(ArrayList<Employee> employees) {
        employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
    }

    public static void removeDuplicate(ArrayList<Employee> employees) {
        Set<String> namesSet = new HashSet<>();
        ArrayList<Employee> uniqueEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            if (namesSet.add(employee.getName().trim().toLowerCase())) {
                uniqueEmployees.add(employee);
            }
        }

        employees.clear();
        employees.addAll(uniqueEmployees);
    }

    public static void saveArrayListToFile(ArrayList<Employee> employees, String outputFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            for (Employee employee : employees) {
                writer.println(employee);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

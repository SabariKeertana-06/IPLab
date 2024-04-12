package pack1;

import java.util.Date;

public class Employee {
    private String name;
    private String department;
    private double salary;
    private Date hireDate;

    // Constructor
    public Employee(String name, String department, double salary, String hireDate) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.hireDate = convertToDate(hireDate); // Convert hireDate string to Date object
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    // Helper method to convert string date to Date object
    private Date convertToDate(String dateStr) {
        try {
            // Assuming dateStr is in "MM-dd-yyyy" format
            return new Date(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

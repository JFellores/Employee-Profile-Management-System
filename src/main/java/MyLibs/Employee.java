/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Jomar Fellores
 */
public class Employee {
     private String employeeID;
     private String firstName;
     private String lastName;
     private double baseSalary;
     private int hoursWorked;
     private String position;
     private double performanceRating;
     private String department;
     private EmployeeDetails details;
     private SalaryStrategy salaryStrategy;
     private PerformanceStrategy performanceStrategy;

     public Employee(String employeeID, String firstName, String lastName, double baseSalary, int hoursWorked, double performanceRating, String department,
                     SalaryStrategy salaryStrategy, PerformanceStrategy performanceStrategy, String position, EmployeeDetails details) {
         this.employeeID = employeeID;
         this.firstName = firstName;
         this.lastName = lastName;
         this.baseSalary = baseSalary;
         this.hoursWorked = hoursWorked;
         this.performanceRating = performanceRating;
         this.department = department;
         this.salaryStrategy = salaryStrategy;
         this.performanceStrategy = performanceStrategy;
         this.position = position;
         this.details = details;
     }
     
     public String getEmployeeID() {
         return employeeID;
     }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(double performanceRating) {
        this.performanceRating = performanceRating;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public EmployeeDetails getDetails() {
        return details;
    }

    public void setDetails(EmployeeDetails details) {
        this.details = details;
    }

    public SalaryStrategy getSalaryStrategy() {
        return salaryStrategy;
    }

    public void setSalaryStrategy(SalaryStrategy salaryStrategy) {
        this.salaryStrategy = salaryStrategy;
    }

    public PerformanceStrategy getPerformanceStrategy() {
        return performanceStrategy;
    }

    // Getters and Setters
    public void setPerformanceStrategy(PerformanceStrategy performanceStrategy) {
        this.performanceStrategy = performanceStrategy;
    }

    public double calculateSalary() {
        return salaryStrategy.calculateSalary(baseSalary, hoursWorked);
    }

     public String classifyPerformance() {
         return performanceStrategy.classifyPerformance(performanceRating);
     }

     
}

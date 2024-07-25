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
    private SalaryStrategy salaryStrategy;
    private PerformanceStrategy performanceStrategy;
    

    public Employee(String employeeID, String firstName, String lastName, double baseSalary, int hoursWorked, double performanceRating, String department, SalaryStrategy salaryStrategy, PerformanceStrategy performanceStrategy, String position) {
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
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getPerformanceRating() {
        return performanceRating;
    }

    public String getDepartment() {
        return department;
    }

    public SalaryStrategy getSalaryStrategy() {
        return salaryStrategy;
    }

    public PerformanceStrategy getPerformanceStrategy() {
        return performanceStrategy;
    }

    public String getPosition() {
        return position;
    }

    public double calculateSalary() {
        return salaryStrategy.calculateSalary(baseSalary, hoursWorked);
    }

    public String classifyPerformance() {
        return performanceStrategy.classifyPerformance(performanceRating);
    }
     public void detailsAboutMe() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Position: " + position);
        System.out.println("Department: " + department);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Performance Rating: " + performanceRating);
        System.out.println("Calculated Salary: " + calculateSalary());
        System.out.println("Performance Status: " + classifyPerformance());
    }
     
     public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;   
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setPerformanceRating(double performanceRating) {
        this.performanceRating = performanceRating;
    }
}

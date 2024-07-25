/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Jomar Fellores
 */
public class EmployeeManagementFacade {
    private ArrayList<Employee> employees = new ArrayList<>();
    
    public EmployeeManagementFacade() {
    }

    

    public Employee createEmployee(String employeeID, String firstName, String lastName, double baseSalary, int hoursWorked, double performanceRating, String department, String position) {
        EmployeeFactory factory;

        switch (position) {
            case "Manager":
                factory = new Manager();
                break;
            case "Sales Associate":
                factory = new SalesAssociate();
                break;
            case "Cashier":
                factory = new Cashier();
                break;
            case "Customer Service":
                factory = new CustomerService();
                break;
            case "Merchandiser":
                factory = new Merchandiser();
                break;
            default:
                throw new IllegalArgumentException("Unknown position: " + position);
        }

        Employee employee = factory.createEmployee(employeeID, firstName, lastName, baseSalary, hoursWorked, performanceRating, department);
        employees.add(employee);
        return employee;
    }

    public ArrayList<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public Employee getEmployeeById(String employeeID) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID().equals(employeeID)) {
                return employee;
            }
        }
        return null;
    }

    public void removeEmployee(String employeeID) {
        employees.removeIf(employee -> employee.getEmployeeID().equals(employeeID));
    }
}

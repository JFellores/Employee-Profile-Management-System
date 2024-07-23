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
        // Initialize if necessary
    }

    public Employee createEmployee(String employeeID, String firstName, String lastName, double baseSalary, int hoursWorked, double performanceRating, String department, String position) {
        EmployeeFactory factory;

        switch (position) {
            case "Manager":
                factory = new ManagerFactory();
                break;
            case "Sales Associate":
                factory = new SalesAssociateFactory();
                break;
            case "Cashier":
                factory = new CashierFactory();
                break;
            case "Janitor":
                factory = new JanitorFactory();
                break;
            case "Merchandiser":
                factory = new MerchandiserFactory();
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

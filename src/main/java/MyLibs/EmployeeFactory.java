/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Jomar Fellores
 */
public interface EmployeeFactory {
    Employee createEmployee(String employeeID, String firstName, String lastName, double baseSalary, int hoursWorked, double performanceRating, String department, int age, int contactNumber, String address, String gender);
}

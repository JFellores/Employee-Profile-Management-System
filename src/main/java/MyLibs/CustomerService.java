/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Jomar Fellores
 */
public class CustomerService implements EmployeeFactory {
    @Override
    public Employee createEmployee(String employeeID, String firstName, String lastName, double baseSalary, int hoursWorked, double performanceRating, String department, EmployeeDetails details) {
        return new Employee(employeeID, firstName, lastName, baseSalary, hoursWorked, performanceRating, department,
                            new PartTimeSalaryStrategy(), new PerformanceClassificationStrategy(), "Customer Service", details);
    }
}

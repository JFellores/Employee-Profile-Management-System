/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Jomar Fellores
 */
public class ContractualSalaryStrategy implements SalaryStrategy{
    private static final int REQUIRED_HOURS = 480;

    @Override
    public double calculateSalary(double baseSalary, int hoursWorked) {
        if (hoursWorked < REQUIRED_HOURS) {
            return baseSalary * (hoursWorked / (double) REQUIRED_HOURS);
        }
        return baseSalary * hoursWorked;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Jomar Fellores
 */
public class PartTimeSalaryStrategy implements SalaryStrategy{
    @Override
    public double calculateSalary(double baseSalary, int hoursWorked) {
        return (baseSalary/3) * hoursWorked; 
    }
}

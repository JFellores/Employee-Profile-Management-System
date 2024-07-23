/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Jomar Fellores
 */
public class PerformanceClassificationStrategy implements PerformanceStrategy{
    @Override
    public String classifyPerformance(double rating) {
        if (rating >= 90) {
            return "EE (Exceeds Expectation)";
        } else if (rating >= 70) {
            return "ME (Meets Expectation)";
        } else {
            return "PIP (Performance Improvement Plan)";
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

/**
 *
 * @author Jomar Fellores
 */
public class EmployeeDetails {
    private int age;
    private int contactNumber;
    private String address;
    private String gender;

    public EmployeeDetails(int age, int contactNumber, String address, String gender) {
        this.age = age;
        this.contactNumber = contactNumber;
        this.address = address;
        this.gender = gender;
    }

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Age: " + age + "\n" +
               "Contact Number: " + contactNumber + "\n" +
               "Address: " + address + "\n" +
               "Gender: " + gender;
    }
}

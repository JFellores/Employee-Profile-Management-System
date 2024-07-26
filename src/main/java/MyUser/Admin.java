/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyUser;

/**
 *
 * @author Jomar Fellores
 */
public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean isValid() {
        // For simplicity, assuming admin credentials are hardcoded.
        String validUsername = "123";
        String validPassword = "123";

        return username.equals(validUsername) && password.equals(validPassword);
    }
}
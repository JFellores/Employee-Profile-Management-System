/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyUser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Jomar Fellores
 */
public class Employee extends User {
    private static final String EXCEL_FILE_PATH = "/Database/TESTING.xlsx"; // Ensure this path is correct

    public Employee(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean isValid() {
            try (InputStream is = getClass().getResourceAsStream(EXCEL_FILE_PATH);
             Workbook workbook = WorkbookFactory.create(is)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

            // Start from row index 1 to skip the header row
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue; // Skip empty rows

                Cell employeeIDCell = row.getCell(0);
                Cell lastNameCell = row.getCell(2);

                if (employeeIDCell == null || lastNameCell == null) {
                    continue; // Skip rows with missing cells
                }

                // Ensure data is treated as String
                String employeeID = employeeIDCell.getStringCellValue().trim();
                String lastName = lastNameCell.getStringCellValue().trim();

                // Debugging: Print the values to verify correctness
                System.out.println("Read Employee ID: " + employeeID);
                System.out.println("Read Last Name: " + lastName);
                System.out.println("Comparing with username: " + username + " and password: " + password);

                // Check if username matches lastName and password matches employeeID
                if (lastName.equals(username) && employeeID.equals(password)) {
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}

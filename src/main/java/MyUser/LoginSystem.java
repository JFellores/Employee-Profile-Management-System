/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyUser;

import static java.awt.PageAttributes.MediaType.C;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Jomar Fellores
 */
public class LoginSystem {
    private Workbook workbook;

    public LoginSystem(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            this.workbook = new XSSFWorkbook(fis);
        }
    }

    public Row authenticate(String employeeID) throws IOException {
        Sheet sheet = workbook.getSheetAt(0); // Assume data is in the first sheet
        for (Row row : sheet) {
            Cell idCell = row.getCell(0); // Assuming Employee ID is in the first column
            if (idCell != null && idCell.getStringCellValue().equals(employeeID)) {
                return row;
            }
        }
        return null; 
    }
}

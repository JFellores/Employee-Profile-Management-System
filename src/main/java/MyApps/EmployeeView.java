/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MyApps;

import MyLogins.AdminLoginForm;
import MyLogins.EmployeeLoginForm;
import MyLibs.*;
import MyUser.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author luisr
 */


public class EmployeeView extends javax.swing.JFrame {
    private boolean dataChanged = false;
    int mousePx;
    int mousePy;
    private static EmployeeManagementFacade facade;
    private static uEmployee employee;
    private static List<Employee> employeeList = new ArrayList<>();
    
    /**
     * Creates new form EmployeeView
     */
    public EmployeeView(EmployeeManagementFacade facade, uEmployee employee) {
        this.facade = facade;
        this.employee = employee;
        initComponents();
        
        //Non - Editable Fields
        TF_fullName.setBackground(new java.awt.Color(0,0,0,1));
        TF_fullName.setFocusable(false);
        TF_empID1.setEditable(false);
        TF_empID2.setEditable(false);
        TF_empID.setEditable(false);
        TF_Sal.setEditable(false);
        TF_HW.setEditable(false);
        TF_Perf.setEditable(false);
        TF_Dep.setEditable(false);
        TF_pos.setEditable(false);
        TF_pos.setEditable(false);
        
        LoadEmployees();
        accessEmployeeData(employee.getEmployeeID());
      
    }
    public void accessEmployeeData(String employeeID) {
        int index = findEmployeeIndex(employeeID);
        if (index != -1) {
            Employee emp = employeeList.get(index);
            // Now you can access the employee's data
            TF_empID1.setText(emp.getEmployeeID());
            TF_empID2.setText(emp.getFirstName());
            TF_empID.setText(emp.getLastName());
            TF_fullName.setText(emp.getLastName() + ", " + emp.getFirstName());
            TF_Sal.setText(Double.toString(emp.getBaseSalary()));
            TF_HW.setText(Integer.toString(emp.getHoursWorked()));
            TF_pos.setText(emp.getPosition());
            TF_Perf.setText(Double.toString(emp.getPerformanceRating()));
            TF_Dep.setText(emp.getDepartment());
            
            // Editable fields
            TF_age.setText(String.valueOf(emp.getDetails().getAge()));
            TF_add.setText(emp.getDetails().getAddress());
            TF_cont.setText(String.valueOf(emp.getDetails().getContactNumber()));
            TF_sex.setText(emp.getDetails().getGender());

        } else {
            // Employee not found
            JOptionPane.showMessageDialog(null, "Employee not found.");
        }
    }
    public int findEmployeeIndex(String employeeID) {
        try {
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getEmployeeID().equals(employeeID)) {
                    return i;
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred while searching for the employee: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while searching for the employee. Please try again.");
        }
        JOptionPane.showMessageDialog(null, "Employee not found.");
        return -1; // Return -1 if the employee is not found
    }
    
    private void LoadEmployees() {                                           
       String userHome = System.getProperty("user.home");
    File documentsFolder = new File(userHome, "Documents");
    File fileToLoad = new File(documentsFolder, "DATABASE.xlsx");
    facade = new EmployeeManagementFacade();

    if (!fileToLoad.exists()) {
        JOptionPane.showMessageDialog(null, "The file DATABASE.xlsx does not exist in the Documents folder.");
        return;
    }

    // Clear the existing list to avoid duplicates
    employeeList.clear();

    try (FileInputStream fileIn = new FileInputStream(fileToLoad); 
         Workbook workbook = new XSSFWorkbook(fileIn)) {
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < rowCount; i++) { // Skip header row (i = 0)
            Row row = sheet.getRow(i);
            if (row == null) continue; // Skip empty rows

            try {
                String employeeID = row.getCell(0).getStringCellValue();
                String firstName = row.getCell(1).getStringCellValue();
                String lastName = row.getCell(2).getStringCellValue();
                double baseSalary = row.getCell(3).getNumericCellValue();
                int hoursWorked = (int) row.getCell(4).getNumericCellValue();
                String position = row.getCell(5).getStringCellValue();
                double performanceRating = row.getCell(6).getNumericCellValue();
                String department = row.getCell(7).getStringCellValue();
                int age = (int) row.getCell(8).getNumericCellValue();
                String contactNumber = row.getCell(9).getStringCellValue();
                String address = row.getCell(10).getStringCellValue();
                String gender = row.getCell(11).getStringCellValue();

                // Create the Employee instance
                Employee emp = facade.createEmployee(employeeID, firstName, lastName, baseSalary, hoursWorked, performanceRating, department, position, age, contactNumber, address, gender);
                
                // Add the Employee to the list
                employeeList.add(emp);
            } catch (Exception e) {
                e.printStackTrace();
                // Log or handle individual row errors
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while loading the Excel file.");
    }
    }                 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CheckIn = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        TF_fullName = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        EditButton = new javax.swing.JButton();
        TF_empID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TF_pos = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TF_Dep = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TF_Perf = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TF_HW = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TF_Sal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TF_add = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TF_cont = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TF_age = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TF_sex = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TF_empID1 = new javax.swing.JTextField();
        TF_empID2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Welcome");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user (2).png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        CheckIn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        CheckIn.setForeground(new java.awt.Color(15, 137, 15));
        CheckIn.setText("CHECK IN");
        CheckIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInActionPerformed(evt);
            }
        });

        LogOut.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        LogOut.setText("LOG OUT");
        LogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        TF_fullName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TF_fullName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TF_fullName.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(CheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(2, 2, 2))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel4)))
                        .addGap(33, 33, 33)))
                .addGap(54, 54, 54))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(TF_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_fullName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE)
                .addComponent(LogOut)
                .addGap(29, 29, 29))
        );

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 102, 51));
        kGradientPanel1.setkStartColor(new java.awt.Color(68, 168, 68));
        kGradientPanel1.setkTransparentControls(false);
        kGradientPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel1MouseDragged(evt);
            }
        });
        kGradientPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel1MousePressed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        EditButton.setText("EDIT PERSONAL INFO");
        EditButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        TF_empID.setBackground(new java.awt.Color(242, 242, 242));
        TF_empID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("EMPLOYEE ID");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("LAST NAME");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FIRST NAME");

        TF_pos.setBackground(new java.awt.Color(242, 242, 242));
        TF_pos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TF_pos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_posActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("POSITION");

        TF_Dep.setBackground(new java.awt.Color(242, 242, 242));
        TF_Dep.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DEPARTMENT");

        TF_Perf.setBackground(new java.awt.Color(242, 242, 242));
        TF_Perf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PERFORMANCE RATING");

        TF_HW.setBackground(new java.awt.Color(242, 242, 242));
        TF_HW.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TF_HW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_HWActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("HOURS WORKED");

        TF_Sal.setBackground(new java.awt.Color(242, 242, 242));
        TF_Sal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SALARY");

        TF_add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        TF_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_addActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ADDRESS");

        TF_cont.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CONTACT NUMBER");

        TF_age.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("AGE");

        TF_sex.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("GENDER");

        TF_empID1.setBackground(new java.awt.Color(242, 242, 242));
        TF_empID1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        TF_empID2.setBackground(new java.awt.Color(242, 242, 242));
        TF_empID2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(TF_Perf, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(TF_age, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(TF_empID1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(TF_pos)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(TF_empID2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TF_Dep, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(35, 35, 35)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel13)
                                    .addComponent(TF_Sal)
                                    .addComponent(TF_HW)
                                    .addComponent(TF_empID, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(TF_add, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17)
                                    .addComponent(TF_cont, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TF_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 59, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EditButton)
                .addGap(201, 201, 201))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_empID1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_pos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_empID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_empID2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_Dep, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_HW, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TF_Perf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TF_Sal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_cont, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_age, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_sex, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged
        int corX = evt.getXOnScreen();
        int corY = evt.getYOnScreen();

        setLocation(corX - mousePx, corY - mousePy);
    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed
        mousePx = evt.getX();
        mousePy = evt.getY();
    }//GEN-LAST:event_kGradientPanel1MousePressed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        // Retrieve the new values from the text fields
        String ageText = TF_age.getText();
        String contactNumberText = TF_cont.getText();
        String address = TF_add.getText();
        String gender = TF_sex.getText();

        // Validate and convert the age
        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid age value. Please enter a valid number.");
            return;
        }

        // Validate contact number
        if (!isValidContactNumber(contactNumberText)) {
            JOptionPane.showMessageDialog(null, "Invalid contact number. It must be exactly 11 digits and start with '09'.");
            return;
        }

        // Retrieve the employee ID from the text field
        String employeeIDToUpdate = TF_empID1.getText(); // Assuming TF_empID1 contains the employee ID

        // Find the index of the employee with the given ID
        int index = findEmployeeIndex(employeeIDToUpdate);

        if (index != -1) {
        // Update the employee at the found index
        Employee emp = employeeList.get(index);

        boolean updated = false;
        if (emp.getDetails().getAge() != age) {
            emp.getDetails().setAge(age);
            updated = true;
        }
        if (!emp.getDetails().getContactNumber().equals(contactNumberText)) {
            emp.getDetails().setContactNumber(contactNumberText); // Store as String
            updated = true;
        }
        if (!emp.getDetails().getAddress().equals(address)) {
            emp.getDetails().setAddress(address);
            updated = true;
        }
        if (!emp.getDetails().getGender().equals(gender)) {
            emp.getDetails().setGender(gender);
            updated = true;
        }

        if (updated) {
            dataChanged = true;
            JOptionPane.showMessageDialog(null, "Employee updated successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "No changes detected.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Employee not found.");
    }
        //            System.out.println(employee.getEmployeeID() + " " + employee.getLastName());
        //                    for (Employee emp : employeeList) {
        //                        System.out.println("Employee ID: " + emp.getEmployeeID());
        //                        System.out.println("First Name: " + emp.getFirstName());
        //                        System.out.println("Last Name: " + emp.getLastName());
        //                        System.out.println("Base Salary: " + emp.getBaseSalary());
        //                        System.out.println("Hours Worked: " + emp.getHoursWorked());
        //                        System.out.println("Position: " + emp.getPosition());
        //                        System.out.println("Performance Rating: " + emp.getPerformanceRating());
        //                        System.out.println("Department: " + emp.getDepartment());
        //                        System.out.println("Age: " + emp.getDetails().getAge());
        //                        System.out.println("Contact Number: " + emp.getDetails().getContactNumber());
        //                        System.out.println("Address: " + emp.getDetails().getAddress());
        //                        System.out.println("Gender: " + emp.getDetails().getGender());
        //                        System.out.println(); // Empty line for better readability
        //                }
        //                    
        //                 System.out.println();
    }//GEN-LAST:event_EditButtonActionPerformed
    private boolean isValidContactNumber(String contactNumber) {
        // Check if contact number is exactly 11 digits and starts with "09"
        return contactNumber.matches("09\\d{9}");
    }
    private void TF_HWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_HWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_HWActionPerformed
    private void showLoginForm() {
        // Show the login form
        EmployeeLoginForm employee = new EmployeeLoginForm(facade);
        employee.setVisible(true);
        employee.setLocationRelativeTo(null);
        // Dispose of the current form
        this.dispose();
    }
    private void TF_posActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_posActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_posActionPerformed

    private void TF_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_addActionPerformed

    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        if (dataChanged) {
        SaveToDatabase();
        }
        showLoginForm();
    }//GEN-LAST:event_LogOutActionPerformed
    
    private void CheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInActionPerformed
         if (CheckIn.getText().equals("CHECK IN")) {
                    CheckIn.setText("CHECK OUT");
                    CheckIn.setForeground(new java.awt.Color(255, 0, 0)); 
                } else {
                    CheckIn.setText("CHECK IN");
                    CheckIn.setForeground(new java.awt.Color(15, 137, 15)); 
                }
    }//GEN-LAST:event_CheckInActionPerformed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel5MousePressed
    private void SaveToDatabase() {                                           
    String userHome = System.getProperty("user.home");
    File documentsFolder = new File(userHome, "Documents");
    File fileToSave = new File(documentsFolder, "DATABASE.xlsx");

    // Ensure the parent directory exists
    if (!documentsFolder.exists() && !documentsFolder.mkdirs()) {
        JOptionPane.showMessageDialog(null, "Failed to create the directory for saving the file.");
        return;
    }

    try (Workbook workbook = new XSSFWorkbook()) {
        Sheet sheet = workbook.createSheet("Employees");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Employee ID");
        headerRow.createCell(1).setCellValue("First Name");
        headerRow.createCell(2).setCellValue("Last Name");
        headerRow.createCell(3).setCellValue("Base Salary");
        headerRow.createCell(4).setCellValue("Hours Worked");
        headerRow.createCell(5).setCellValue("Position");
        headerRow.createCell(6).setCellValue("Performance Rating");
        headerRow.createCell(7).setCellValue("Department");
        headerRow.createCell(8).setCellValue("Age");
        headerRow.createCell(9).setCellValue("Contact Number");
        headerRow.createCell(10).setCellValue("Address");
        headerRow.createCell(11).setCellValue("Gender");

        // Populate the sheet with employee data
        int rowNum = 1;
        for (Employee emp : employeeList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(emp.getEmployeeID());
            row.createCell(1).setCellValue(emp.getFirstName());
            row.createCell(2).setCellValue(emp.getLastName());
            row.createCell(3).setCellValue(emp.getBaseSalary());
            row.createCell(4).setCellValue(emp.getHoursWorked());
            row.createCell(5).setCellValue(emp.getPosition());
            row.createCell(6).setCellValue(emp.getPerformanceRating());
            row.createCell(7).setCellValue(emp.getDepartment());
            row.createCell(8).setCellValue(emp.getDetails().getAge());
            row.createCell(9).setCellValue(emp.getDetails().getContactNumber());
            row.createCell(10).setCellValue(emp.getDetails().getAddress());
            row.createCell(11).setCellValue(emp.getDetails().getGender());
        }

        // Save the workbook to the file
        try (FileOutputStream fileOut = new FileOutputStream(fileToSave)) {
            workbook.write(fileOut);
        }

       

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "An error occurred while saving the Excel file.");
        e.printStackTrace();
    }
    }         
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeView(facade, employee).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckIn;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton LogOut;
    private javax.swing.JTextField TF_Dep;
    private javax.swing.JTextField TF_HW;
    private javax.swing.JTextField TF_Perf;
    private javax.swing.JTextField TF_Sal;
    private javax.swing.JTextField TF_add;
    private javax.swing.JTextField TF_age;
    private javax.swing.JTextField TF_cont;
    private javax.swing.JTextField TF_empID;
    private javax.swing.JTextField TF_empID1;
    private javax.swing.JTextField TF_empID2;
    private javax.swing.JLabel TF_fullName;
    private javax.swing.JTextField TF_pos;
    private javax.swing.JTextField TF_sex;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MyApps;
import MyApps.AdminView;
import MyLibs.*;
import java.awt.Color;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jomar Fellores
 */
public class AddGUI extends javax.swing.JFrame {
   private static JTable EmployeeTable;
   int mousePx;
   int mousePy;
   
    private EmployeeManagementFacade facade;
    
    public AddGUI(EmployeeManagementFacade facade, JTable EmployeeTable) {
        
        initComponents();
        this.facade = facade;
        this.EmployeeTable = EmployeeTable;
    }
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    private boolean isEmployeeIdValid(String empId) {
    // Check if ID is exactly 6 digits long and numeric
    return empId.matches("\\d{6}");
    }

    // Method to check for duplicate employee ID
    private boolean isEmployeeIdDuplicate(String empId) {
        DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();
        for (int row = 0; row < model.getRowCount(); row++) {
            if (empId.equals(model.getValueAt(row, 0))) { // Assumes employee ID is in the first column
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        TF_EmpID = new javax.swing.JTextField();
        TF_FirstName = new javax.swing.JTextField();
        TF_PR = new javax.swing.JTextField();
        javax.swing.JButton BTNAdd = new javax.swing.JButton();
        javax.swing.JButton BTNClear = new javax.swing.JButton();
        TF_LastName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TF_Hours = new javax.swing.JTextField();
        TF_Base = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        GoBack = new javax.swing.JToggleButton();
        CB_Position = new javax.swing.JComboBox<>();
        CB_Dept = new javax.swing.JComboBox<>();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        kGradientPanel2.setBackground(new java.awt.Color(246, 238, 222));
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel9.setText("Add Employee");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-user (3).png"))); // NOI18N
        jLabel11.setText("jLabel11");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel9)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
        );

        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(43, 18, 129));
        kGradientPanel1.setkStartColor(new java.awt.Color(85, 47, 176));
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

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee ID");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Position");

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Performance Rating");

        TF_EmpID.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        TF_EmpID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_EmpIDActionPerformed(evt);
            }
        });

        TF_FirstName.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        TF_FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_FirstNameActionPerformed(evt);
            }
        });

        TF_PR.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        TF_PR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_PRActionPerformed(evt);
            }
        });

        BTNAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        BTNAdd.setText("ADD");
        BTNAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTNAdd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add.png"))); // NOI18N
        BTNAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAddActionPerformed(evt);
            }
        });

        BTNClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clean.png"))); // NOI18N
        BTNClear.setText("CLEAR");
        BTNClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTNClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNClearActionPerformed(evt);
            }
        });

        TF_LastName.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        TF_LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_LastNameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Last Name");

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Department");

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Hours Worked");

        TF_Hours.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N

        TF_Base.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Base Salary");

        GoBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back static.jpg"))); // NOI18N
        GoBack.setBorder(null);
        GoBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GoBack.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back-moving.gif"))); // NOI18N
        GoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackActionPerformed(evt);
            }
        });

        CB_Position.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        CB_Position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Merchandiser", "Sales Associate", "Customer Service", "Cashier" }));

        CB_Dept.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        CB_Dept.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Information Technology", "Human Resources", "Sales & Marketing" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTNAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(GoBack)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TF_FirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TF_Hours, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_EmpID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_Position, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(TF_PR, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(CB_Dept, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TF_Base, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TF_LastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_EmpID, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_PR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_FirstName)
                    .addComponent(TF_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CB_Position, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(CB_Dept))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_Hours, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_Base, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(BTNAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTNClear)
                .addGap(7, 7, 7)
                .addComponent(GoBack)
                .addGap(7, 7, 7))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BTNAdd, BTNClear});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {TF_EmpID, TF_FirstName, TF_PR});

        kGradientPanel3.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkTransparentControls(false);
        kGradientPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel3MouseDragged(evt);
            }
        });
        kGradientPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel3MousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel12.setText("ADD EMPLOYEE");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-user (3).png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed
        mousePx = evt.getX();
        mousePy = evt.getY();
    }//GEN-LAST:event_kGradientPanel1MousePressed

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged
        int corX = evt.getXOnScreen();
        int corY = evt.getYOnScreen();

        setLocation(corX - mousePx, corY - mousePy);
    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void GoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackActionPerformed
        close();
    }//GEN-LAST:event_GoBackActionPerformed

    private void TF_LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_LastNameActionPerformed

    private void BTNClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNClearActionPerformed
        TF_EmpID.setText("");
        TF_FirstName.setText("");
        TF_PR.setText("");
        TF_LastName.setText("");
        TF_Hours.setText("");
        TF_Base.setText("");
    }//GEN-LAST:event_BTNClearActionPerformed

    private void BTNAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAddActionPerformed
        String empId = TF_EmpID.getText();
        String firstName = TF_FirstName.getText();
        String lastName = TF_LastName.getText();
        String position = CB_Position.getSelectedItem().toString();
        String performance = TF_PR.getText();
        String hours = TF_Hours.getText();
        String base = TF_Base.getText();
        String department = CB_Dept.getSelectedItem().toString();
        int age = 0;
        String contactNumber = "";
        String address = "";
        String gender = "";
        
        Set<String> validPositions = new HashSet<>(Arrays.asList("Manager", "Sales Associate", "Cashier", "Customer Service", "Merchandiser"));

        // Validate input fields
        if (firstName.isEmpty() || empId.isEmpty() || performance.isEmpty() || position.isEmpty() || lastName.isEmpty() || hours.isEmpty() || base.isEmpty() || department.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill up all fields", "Try again", JOptionPane.ERROR_MESSAGE);
        } else if (!validPositions.contains(position)) {
            // Validate the position
            JOptionPane.showMessageDialog(this, "Invalid position. Please enter a valid position. \nManager | Sales Associate | Cashier | Customer Service | Merchandiser", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!isEmployeeIdValid(empId)) {
            // Validate the employee ID length and format
            JOptionPane.showMessageDialog(this, "Employee ID must be exactly 6 digits long.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (isEmployeeIdDuplicate(empId)) {
            // Check for duplicate employee ID
            JOptionPane.showMessageDialog(this, "Employee ID must be unique. The provided ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Convert hours and base to their appropriate types
            int hoursWorked;
            double baseSalary, performanceRating;

            try {
                hoursWorked = Integer.parseInt(hours);
                baseSalary = Double.parseDouble(base);
                performanceRating = Double.parseDouble(performance);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create an employee based on the position
            Employee employee = facade.createEmployee(empId, firstName, lastName, baseSalary, hoursWorked, performanceRating, department, position, age, contactNumber, address, gender);

            // Add employee details to JTable
            DecimalFormat df = new DecimalFormat("#.00");
            AdminView.AddRow(new Object[]{
                employee.getEmployeeID(),
                employee.getLastName() + ", " + employee.getFirstName(),
                employee.getDepartment(),
                employee.getPosition(),
                df.format(employee.getSalaryStrategy().calculateSalary(baseSalary, hoursWorked)),
                employee.getPerformanceStrategy().classifyPerformance(employee.getPerformanceRating()),
            });

            // Clear text fields
            TF_EmpID.setText("");
            TF_FirstName.setText("");          
            TF_PR.setText("");
            TF_LastName.setText("");
            TF_Hours.setText("");
            TF_Base.setText("");
        }
    }//GEN-LAST:event_BTNAddActionPerformed

    private void TF_PRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_PRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_PRActionPerformed

    private void TF_FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_FirstNameActionPerformed

    private void TF_EmpIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_EmpIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_EmpIDActionPerformed

    private void kGradientPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel3MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_kGradientPanel3MouseDragged

    private void kGradientPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kGradientPanel3MousePressed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeeManagementFacade facade = null;
                new AddGUI(facade, EmployeeTable).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Dept;
    private javax.swing.JComboBox<String> CB_Position;
    private javax.swing.JToggleButton GoBack;
    private javax.swing.JTextField TF_Base;
    private javax.swing.JTextField TF_EmpID;
    private javax.swing.JTextField TF_FirstName;
    private javax.swing.JTextField TF_Hours;
    private javax.swing.JTextField TF_LastName;
    private javax.swing.JTextField TF_PR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    // End of variables declaration//GEN-END:variables
}

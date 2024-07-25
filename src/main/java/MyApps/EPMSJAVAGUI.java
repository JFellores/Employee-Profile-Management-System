/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MyApps;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import MyLibs.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import static org.apache.commons.math3.fitting.leastsquares.LeastSquaresFactory.model;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Jomar Fellores
 */
public class EPMSJAVAGUI extends javax.swing.JFrame {
   EmployeeManagementFacade facade = new EmployeeManagementFacade(); 
   private boolean isHeaderWritten = false;
   int mousePx;
   int mousePy;
   
    /**
     * Creates new form EPMSJAVAGUI
     */
    public EPMSJAVAGUI() {
        initComponents();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        EmployeeTable.setDefaultEditor(Object.class, null);
        
        EmployeeTable.getTableHeader().setFont(new Font("Arial Narrow",Font.BOLD,12));
        EmployeeTable.getTableHeader().setOpaque(false);
        EmployeeTable.getTableHeader().setDefaultRenderer(new HeaderColor());
        EmployeeTable.getTableHeader().setForeground(new Color(255, 255, 255));
        EmployeeTable.setRowHeight(25);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        changeTable(EmployeeTable, 5);
    }
    
    private void filter(String query) {
        DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        EmployeeTable.setRowSorter(tr);

        if (query != null && !query.equals("None") && !query.trim().isEmpty()) {
            // Apply the filter with the provided query
            tr.setRowFilter(RowFilter.regexFilter(query));
        } else {
            // Reset the filter to show all rows
            tr.setRowFilter(null);
        }
    }
    
    public void changeTable(JTable table, int column_index) {
        table.getColumnModel().getColumn(column_index).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Ensure value is treated as a String
                String performanceRating = table.getValueAt(row, column_index).toString();

                // Set background color based on performance rating
                switch (performanceRating) {
                    case "EE (Exceeds Expectation)" -> c.setBackground(Color.GREEN); // Green for Exceeds Expectation
                    case "ME (Meets Expectation)" -> c.setBackground(Color.YELLOW); // Yellow for Meets Expectation
                    case "PIP (Performance Improvement Plan)" -> c.setBackground(Color.RED);    // Red for Performance Improvement Plan
                    default -> c.setBackground(Color.WHITE);  // Default color for unknown values
                }

                // Ensure the foreground color is set properly to be visible
                if (isSelected) {
                    c.setForeground(Color.WHITE); // Text color for selected cell
                } else {
                    c.setForeground(Color.BLACK); // Default text color
                }

                return c;
            }
        });
    }

    
    public void transferDataToEPMSJAVAGUI(Object[][] data) {
        // Assuming EmployeeTable is already initialized and set up
        DefaultTableModel targetModel = (DefaultTableModel) EmployeeTable.getModel();

        // Clear existing data
        targetModel.setRowCount(0);

        // Add new data
        for (Object[] row : data) {
            targetModel.addRow(row);
        }
    }
    
    
    public static void AddRow(Object[] dataRow) {
        DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();
        model.addRow(dataRow);
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
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        AddButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        UpdateButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        LoadButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LogOutButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        EmployeeTable = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        EmployeeSearch = new javax.swing.JTextField();
        SearchButton = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        SortByComboBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Profile Management System");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(153, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 102, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-user-96.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome");
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 23));

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("admin");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);

        AddButton.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        AddButton.setForeground(new java.awt.Color(255, 255, 255));
        AddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-add-64.png"))); // NOI18N
        AddButton.setText(" Add Employee");
        AddButton.setBorderPainted(false);
        AddButton.setContentAreaFilled(false);
        AddButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AddButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/gifgit-unscreen.gif"))); // NOI18N
        AddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddButtonMouseExited(evt);
            }
        });
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        EditButton.setForeground(new java.awt.Color(255, 255, 255));
        EditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-edit-120.png"))); // NOI18N
        EditButton.setText(" Edit Employee");
        EditButton.setBorderPainted(false);
        EditButton.setContentAreaFilled(false);
        EditButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        EditButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/AnimEd.gif"))); // NOI18N
        EditButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditButtonMouseExited(evt);
            }
        });
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-delete-120.png"))); // NOI18N
        DeleteButton.setText(" Delete Employee");
        DeleteButton.setBorderPainted(false);
        DeleteButton.setContentAreaFilled(false);
        DeleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DeleteButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-delete-unscreen.gif"))); // NOI18N
        DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseExited(evt);
            }
        });
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        UpdateButton.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        UpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        UpdateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-cog-24.png"))); // NOI18N
        UpdateButton.setText("Check Details");
        UpdateButton.setBorderPainted(false);
        UpdateButton.setContentAreaFilled(false);
        UpdateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UpdateButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UpdateButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-cog-unscreen.gif"))); // NOI18N
        UpdateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UpdateButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UpdateButtonMouseExited(evt);
            }
        });
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        SaveButton.setForeground(new java.awt.Color(255, 255, 255));
        SaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-save-23.png"))); // NOI18N
        SaveButton.setText(" Save Data");
        SaveButton.setBorderPainted(false);
        SaveButton.setContentAreaFilled(false);
        SaveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SaveButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-save-unscreen.gif"))); // NOI18N
        SaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SaveButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SaveButtonMouseExited(evt);
            }
        });
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        LoadButton.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        LoadButton.setForeground(new java.awt.Color(255, 255, 255));
        LoadButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-up-23.png"))); // NOI18N
        LoadButton.setText("Load Data");
        LoadButton.setBorderPainted(false);
        LoadButton.setContentAreaFilled(false);
        LoadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoadButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LoadButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-up-unscreen-ezgif.com-resize.gif"))); // NOI18N
        LoadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LoadButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LoadButtonMouseExited(evt);
            }
        });
        LoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(EditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(UpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LoadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Manage Employees");

        LogOutButton.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        LogOutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-logout-21_1.png"))); // NOI18N
        LogOutButton.setText("Log out");
        LogOutButton.setContentAreaFilled(false);
        LogOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogOutButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LogOutButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-logout-unscreen.gif"))); // NOI18N
        LogOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogOutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogOutButtonMouseExited(evt);
            }
        });
        LogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel3))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(LogOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(LogOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        EmployeeTable.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        EmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name ", "Department", "Position", "Salary", "Performance Rating"
            }
        ));
        EmployeeTable.setFocusable(false);
        EmployeeTable.setGridColor(new java.awt.Color(0, 0, 0));
        EmployeeTable.setName(""); // NOI18N
        EmployeeTable.setOpaque(false);
        EmployeeTable.setRowHeight(25);
        EmployeeTable.setSelectionBackground(new java.awt.Color(102, 255, 255));
        EmployeeTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        EmployeeTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        EmployeeTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        EmployeeTable.setShowGrid(false);
        EmployeeTable.setShowHorizontalLines(true);
        EmployeeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(EmployeeTable);

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        EmployeeSearch.setBorder(null);
        EmployeeSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        EmployeeSearch.setOpaque(true);
        EmployeeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeSearchActionPerformed(evt);
            }
        });
        EmployeeSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EmployeeSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmployeeSearchKeyReleased(evt);
            }
        });

        SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-search-20.png"))); // NOI18N
        SearchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SearchButton.setBorderPainted(false);
        SearchButton.setContentAreaFilled(false);
        SearchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchButton.setFocusPainted(false);
        SearchButton.setFocusable(false);
        SearchButton.setRequestFocusEnabled(false);
        SearchButton.setVerifyInputWhenFocusTarget(false);

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-sort-26.png"))); // NOI18N

        SortByComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "EE", "ME", "PIP" }));
        SortByComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SortByComboBoxItemStateChanged(evt);
            }
        });
        SortByComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortByComboBoxActionPerformed(evt);
            }
        });

        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SearchButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EmployeeSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SortByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(SortByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmployeeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
      public class HeaderColor extends DefaultTableCellRenderer {

        public HeaderColor() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
           
           setBackground(new java.awt.Color(95, 125, 255));
//you can change the color that u want 
            return this;
        }

    }
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        
        AddGUI add = new AddGUI(facade);
        add.setVisible(true);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        EditGUI edit = new EditGUI(facade);
        edit.setVisible(true);
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
         int row = EmployeeTable.getSelectedRow();
        
        if (row < 0){
       
        JOptionPane.showMessageDialog(this, "No row is selected", "Select row", JOptionPane.ERROR_MESSAGE);
        
        }else{
            DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();
            model.removeRow(row);
            
            //tableManager.deleteSelectedEmployee(row);
        } 
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AddButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseEntered
        AddButton.setOpaque(true);
        AddButton.setBackground(new Color(0, 200, 255, 100));
    }//GEN-LAST:event_AddButtonMouseEntered

    private void AddButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseExited
        AddButton.setOpaque(false);
        
    }//GEN-LAST:event_AddButtonMouseExited

    private void EditButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButtonMouseEntered
        EditButton.setOpaque(true);
        EditButton.setBackground(new Color(0, 200, 255, 100));
    }//GEN-LAST:event_EditButtonMouseEntered

    private void EditButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButtonMouseExited
        EditButton.setOpaque(false);
    }//GEN-LAST:event_EditButtonMouseExited

    private void DeleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseEntered
        DeleteButton.setOpaque(true);
        DeleteButton.setBackground(new Color(0, 200, 255, 100));
    }//GEN-LAST:event_DeleteButtonMouseEntered

    private void DeleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseExited
        DeleteButton.setOpaque(false);
    }//GEN-LAST:event_DeleteButtonMouseExited

    private void LogOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseExited
        LogOutButton.setOpaque(false);
    }//GEN-LAST:event_LogOutButtonMouseExited

    private void LogOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseEntered
        LogOutButton.setOpaque(true);
        LogOutButton.setBackground(new Color(100, 0, 240, 100));
    }//GEN-LAST:event_LogOutButtonMouseEntered

    private void EmployeeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmployeeSearchActionPerformed

    private void EmployeeSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmployeeSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {}
    }//GEN-LAST:event_EmployeeSearchKeyPressed

    private void LoadButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoadButtonMouseEntered
        LoadButton.setOpaque(true);
        LoadButton.setBackground(new Color(0, 200, 255, 100));
    }//GEN-LAST:event_LoadButtonMouseEntered

    private void LoadButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoadButtonMouseExited
        LoadButton.setOpaque(false);
    }//GEN-LAST:event_LoadButtonMouseExited

    private void LoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open file");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            if (fileToOpen.exists()) {
                if (fileToOpen.getName().endsWith(".xlsx")) {
                    // Load Excel file
                    try (FileInputStream fileIn = new FileInputStream(fileToOpen);
                         Workbook workbook = new XSSFWorkbook(fileIn)) {

                        Sheet sheet = workbook.getSheetAt(0);
                        DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();
                        changeTable(EmployeeTable, 5);
                        model.setRowCount(0); // Clear existing data
                        model.setColumnCount(0); // Clear existing columns

                        // Read header row
                        Row headerRow = sheet.getRow(0);
                        if (headerRow != null) {
                            for (Cell cell : headerRow) {
                                model.addColumn(cell.getStringCellValue());
                            }
                        }

                        // Read data rows starting from row 2 (index 1)
                        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                            Row row = sheet.getRow(rowIndex);
                            if (row != null) {
                                Vector<Object> rowData = new Vector<>();
                                for (Cell cell : row) {
                                    rowData.add(cell.toString());
                                }
                                model.addRow(rowData);
                            }
                        }

                        System.out.println("File loaded from: " + fileToOpen.getAbsolutePath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid file type. Only .xlsx files are supported for loading.");
                }
            } else {
                System.err.println("Error: The file does not exist.");
            }
      }
    }//GEN-LAST:event_LoadButtonActionPerformed

    private void UpdateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButtonMouseEntered
        UpdateButton.setOpaque(true);
        UpdateButton.setBackground(new Color(0, 200, 255, 100));
    }//GEN-LAST:event_UpdateButtonMouseEntered

    private void UpdateButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButtonMouseExited
        UpdateButton.setOpaque(false);
    }//GEN-LAST:event_UpdateButtonMouseExited

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        
        
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void SaveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseEntered
        SaveButton.setOpaque(true);
        SaveButton.setBackground(new Color(0, 200, 255, 100));
    }//GEN-LAST:event_SaveButtonMouseEntered

    private void SaveButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseExited
        SaveButton.setOpaque(false);
    }//GEN-LAST:event_SaveButtonMouseExited

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
                                       
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Specify a file to save");
    int userSelection = fileChooser.showSaveDialog(null);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();

        if (fileToSave.getName().endsWith(".xlsx")) {
            Workbook workbook = null;
            Sheet sheet;

            if (fileToSave.exists()) {
                // Open existing workbook
                try (FileInputStream fileIn = new FileInputStream(fileToSave)) {
                    workbook = new XSSFWorkbook(fileIn);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            } else {
                // Create a new workbook
                workbook = new XSSFWorkbook();
            }

            // Check if the sheet already exists
            if (workbook.getSheet("Employee Data") != null) {
                sheet = workbook.getSheet("Employee Data");
            } else {
                sheet = workbook.createSheet("Employee Data");
            }

            // Collect existing data from the sheet to avoid duplication
            Set<String> existingData = new HashSet<>();
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    StringBuilder rowData = new StringBuilder();
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        rowData.append(row.getCell(j).toString()).append(";");
                    }
                    existingData.add(rowData.toString());
                }
            }

            // Create header row if the sheet is empty
            if (sheet.getLastRowNum() == 0 && sheet.getRow(0) == null) {
                Row headerRow = sheet.createRow(0);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Cell cell = headerRow.createCell(col);
                    cell.setCellValue(model.getColumnName(col));
                }
            }

            // Append data rows without duplication
            int lastRowNum = sheet.getLastRowNum() + 1; // Move to the next row for data
            for (int row = 0; row < model.getRowCount(); row++) {
                StringBuilder rowData = new StringBuilder();
                for (int col = 0; col < model.getColumnCount(); col++) {
                    rowData.append(model.getValueAt(row, col).toString()).append(";");
                }

                if (!existingData.contains(rowData.toString())) {
                    Row dataRow = sheet.createRow(lastRowNum++);
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Cell cell = dataRow.createCell(col);
                        Object value = model.getValueAt(row, col);
                        if (value != null) {
                            cell.setCellValue(value.toString());
                        } else {
                            cell.setCellValue("");
                        }
                    }
                }
            }

            // Resize columns to fit the content
            for (int col = 0; col < model.getColumnCount(); col++) {
                sheet.autoSizeColumn(col);
            }

            // Write the updated workbook to the file
            try (FileOutputStream fileOut = new FileOutputStream(fileToSave)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(null, "Data appended to Excel file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please specify a valid file extension (.xlsx)");
        }
    }

    }//GEN-LAST:event_SaveButtonActionPerformed

    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButtonActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Specify a file to save");
    int userSelection = fileChooser.showSaveDialog(null);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();

        if (fileToSave.getName().endsWith(".xlsx")) {
            Workbook workbook = null;
            Sheet sheet;

            if (fileToSave.exists()) {
                // Open existing workbook
                try (FileInputStream fileIn = new FileInputStream(fileToSave)) {
                    workbook = new XSSFWorkbook(fileIn);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            } else {
                // Create a new workbook
                workbook = new XSSFWorkbook();
            }

            // Check if the sheet already exists
            if (workbook.getSheet("Employee Data") != null) {
                sheet = workbook.getSheet("Employee Data");
            } else {
                sheet = workbook.createSheet("Employee Data");
            }

            // Collect existing data from the sheet to avoid duplication
            Set<String> existingData = new HashSet<>();
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    StringBuilder rowData = new StringBuilder();
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        rowData.append(row.getCell(j).toString()).append(";");
                    }
                    existingData.add(rowData.toString());
                }
            }

            // Create header row if the sheet is empty
            if (sheet.getLastRowNum() == 0 && sheet.getRow(0) == null) {
                Row headerRow = sheet.createRow(0);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Cell cell = headerRow.createCell(col);
                    cell.setCellValue(model.getColumnName(col));
                }
            }

            // Append data rows without duplication
            int lastRowNum = sheet.getLastRowNum() + 1; // Move to the next row for data
            for (int row = 0; row < model.getRowCount(); row++) {
                StringBuilder rowData = new StringBuilder();
                for (int col = 0; col < model.getColumnCount(); col++) {
                    rowData.append(model.getValueAt(row, col).toString()).append(";");
                }

                if (!existingData.contains(rowData.toString())) {
                    Row dataRow = sheet.createRow(lastRowNum++);
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Cell cell = dataRow.createCell(col);
                        Object value = model.getValueAt(row, col);
                        if (value != null) {
                            cell.setCellValue(value.toString());
                        } else {
                            cell.setCellValue("");
                        }
                    }
                }
            }

            // Resize columns to fit the content
            for (int col = 0; col < model.getColumnCount(); col++) {
                sheet.autoSizeColumn(col);
            }

            // Write the updated workbook to the file
            try (FileOutputStream fileOut = new FileOutputStream(fileToSave)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(null, "Data appended to Excel file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please specify a valid file extension (.xlsx)");
        }
    }
    
    // Exit the application after the whole process
    System.exit(0);
    }//GEN-LAST:event_LogOutButtonActionPerformed

    private void SortByComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortByComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SortByComboBoxActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
   // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
         int corX = evt.getXOnScreen();
         int corY = evt.getYOnScreen();
                
         setLocation(corX - mousePx, corY - mousePy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
       mousePx = evt.getX();
       mousePy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void SortByComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SortByComboBoxItemStateChanged
        String query = SortByComboBox.getSelectedItem().toString();
        filter(query);
    }//GEN-LAST:event_SortByComboBoxItemStateChanged

    private void EmployeeSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmployeeSearchKeyReleased
        DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        EmployeeTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(EmployeeSearch.getText()));
        
    }//GEN-LAST:event_EmployeeSearchKeyReleased

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
            java.util.logging.Logger.getLogger(EPMSJAVAGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EPMSJAVAGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EPMSJAVAGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EPMSJAVAGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new EPMSJAVAGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTextField EmployeeSearch;
    private static javax.swing.JTable EmployeeTable;
    private javax.swing.JButton LoadButton;
    private javax.swing.JButton LogOutButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JToggleButton SearchButton;
    private javax.swing.JComboBox<String> SortByComboBox;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}

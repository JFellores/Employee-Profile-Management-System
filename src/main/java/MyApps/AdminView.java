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
import MyLogins.AdminLoginForm;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
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
public class AdminView extends javax.swing.JFrame {
   EmployeeManagementFacade facade = new EmployeeManagementFacade();
   private TableRowSorter<DefaultTableModel> rowSorter;
   private boolean isHeaderWritten = false;
   private static final String EXCEL_FILE_PATH = "/Database/TESTING.xlsx";
   int mousePx;
   int mousePy;
   
    /**
     * Creates new form EPMSJAVAGUI
     */
    public AdminView() {
        initComponents();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();
        rowSorter = new TableRowSorter<>(model);
        EmployeeTable.setRowSorter(rowSorter);
        
        
        EmployeeTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,17));
        EmployeeTable.getTableHeader().setOpaque(false);
        EmployeeTable.getTableHeader().setBackground(new Color(88,74,169));
        EmployeeTable.getTableHeader().setForeground(new Color(255,255,255));
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
        CheckDetails = new javax.swing.JButton();
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

        kGradientPanel1.setkEndColor(new java.awt.Color(37, 24, 135));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 105, 218));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/admin_icon (2).png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 21)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome");
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 23));

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("admin");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);

        AddButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        AddButton.setForeground(new java.awt.Color(255, 255, 255));
        AddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-add-64.png"))); // NOI18N
        AddButton.setText(" Add Employee");
        AddButton.setBorder(null);
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

        EditButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
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

        DeleteButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
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

        CheckDetails.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        CheckDetails.setForeground(new java.awt.Color(255, 255, 255));
        CheckDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-cog-24.png"))); // NOI18N
        CheckDetails.setText("Check Details");
        CheckDetails.setBorderPainted(false);
        CheckDetails.setContentAreaFilled(false);
        CheckDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CheckDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CheckDetails.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-cog-unscreen.gif"))); // NOI18N
        CheckDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CheckDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CheckDetailsMouseExited(evt);
            }
        });
        CheckDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckDetailsActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
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

        LoadButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
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
            .addComponent(EditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(CheckDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LoadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE EMPLOYEES");

        LogOutButton.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
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
                        .addContainerGap()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(LogOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jLabel3))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel1))))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(LogOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        EmployeeTable.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        EmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "Department", "Position", "Salary", "Performance Rating"
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

        EmployeeSearch.setBackground(new java.awt.Color(127, 100, 217));
        EmployeeSearch.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        EmployeeSearch.setForeground(new java.awt.Color(255, 255, 255));
        EmployeeSearch.setText("Search...");
        EmployeeSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        EmployeeSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        EmployeeSearch.setOpaque(true);
        EmployeeSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmployeeSearchFocusGained(evt);
            }
        });
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

        SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
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

        SortByComboBox.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        SortByComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Employee ID", "Name", "Department", "Position", "Salary", "Performance Rating" }));
        SortByComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                                .addComponent(EmployeeSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EmployeeSearch)
                    .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SortByComboBox))
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
        
        AddGUI add = new AddGUI(facade,EmployeeTable);
        add.setLocationRelativeTo(null);

        add.setVisible(true);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
                
         
    int selectedRow = EmployeeTable.getSelectedRow();
    if (selectedRow != -1) {
        String employeeID = (String) EmployeeTable.getValueAt(selectedRow, 0);
        Employee selectedEmployee = facade.getEmployeeById(employeeID);

        if (selectedEmployee != null) {
            EditGUI edit = new EditGUI(facade, selectedEmployee, this); // Pass 'this' as reference to the main GUI
            edit.setLocationRelativeTo(null);
            edit.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select an employee to edit.", "Error", JOptionPane.WARNING_MESSAGE);
    }

    }//GEN-LAST:event_EditButtonActionPerformed

    public void refreshEmployeeTable() {
      
    DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();
    model.setRowCount(0); // Clear existing rows
    DecimalFormat df = new DecimalFormat("#.00");
    for (Employee employee : facade.getAllEmployees()) {
        model.addRow(new Object[]{
            employee.getEmployeeID(),
            employee.getLastName() + ", " + employee.getFirstName(),
            employee.getDepartment(),
            employee.getPosition(),
            df.format(employee.getSalaryStrategy().calculateSalary(employee.getBaseSalary(), employee.getHoursWorked())),
            employee.getPerformanceStrategy().classifyPerformance(employee.getPerformanceRating())
        });
        }
    }
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
            int row = EmployeeTable.getSelectedRow();

            if (row < 0) {
                JOptionPane.showMessageDialog(this, "No row is selected", "Select row", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Get the filtered row index
            int modelRow = EmployeeTable.convertRowIndexToModel(row);

            // Get the employee ID from the selected row
            DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();
            String employeeID = (String) model.getValueAt(modelRow, 0); // Assuming ID is in the first column

            // Confirm deletion
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this employee?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Remove the employee from the facade
                facade.removeEmployee(employeeID);

                // Remove the row from the table model
                model.removeRow(modelRow);

                // Optional: Show a confirmation message
                JOptionPane.showMessageDialog(this, "Employee removed successfully.");
            }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AddButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseEntered
        AddButton.setOpaque(true);
        AddButton.setBackground(new Color(192, 211, 255, 100));
    }//GEN-LAST:event_AddButtonMouseEntered

    private void AddButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseExited
        AddButton.setOpaque(false);
        
    }//GEN-LAST:event_AddButtonMouseExited

    private void EditButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButtonMouseEntered
        EditButton.setOpaque(true);
        EditButton.setBackground(new Color(192, 211, 255, 100));
    }//GEN-LAST:event_EditButtonMouseEntered

    private void EditButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditButtonMouseExited
        EditButton.setOpaque(false);
    }//GEN-LAST:event_EditButtonMouseExited

    private void DeleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseEntered
        DeleteButton.setOpaque(true);
        DeleteButton.setBackground(new Color(192, 211, 255, 100));
    }//GEN-LAST:event_DeleteButtonMouseEntered

    private void DeleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseExited
        DeleteButton.setOpaque(false);
    }//GEN-LAST:event_DeleteButtonMouseExited

    private void LogOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseExited
        LogOutButton.setOpaque(false);
    }//GEN-LAST:event_LogOutButtonMouseExited

    private void LogOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseEntered
        LogOutButton.setOpaque(true);
        LogOutButton.setBackground(new Color(192, 211, 255, 100));
    }//GEN-LAST:event_LogOutButtonMouseEntered

    private void EmployeeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmployeeSearchActionPerformed

    private void EmployeeSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmployeeSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {}
    }//GEN-LAST:event_EmployeeSearchKeyPressed

    private void LoadButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoadButtonMouseEntered
        LoadButton.setOpaque(true);
        LoadButton.setBackground(new Color(192, 211, 255, 100));
    }//GEN-LAST:event_LoadButtonMouseEntered

    private void LoadButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoadButtonMouseExited
        LoadButton.setOpaque(false);
    }//GEN-LAST:event_LoadButtonMouseExited

    private void LoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadButtonActionPerformed
        String userHome = System.getProperty("user.home");
        File documentsFolder = new File(userHome, "Documents");
        File fileToLoad = new File(documentsFolder, "DATABASE.xlsx");

        if (!fileToLoad.exists()) {
            JOptionPane.showMessageDialog(null, "The file DATABASE.xlsx does not exist in the Documents folder.");
            return;
        }

        try (FileInputStream fileIn = new FileInputStream(fileToLoad); Workbook workbook = new XSSFWorkbook(fileIn)) {
            Sheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();

            DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();
            // Clear existing rows
            model.setRowCount(0);

            for (int i = 1; i < rowCount; i++) { // Skip header row (i = 0)
                Row row = sheet.getRow(i);
                if (row == null) continue; // Skip empty rows

                String employeeID = row.getCell(0).getStringCellValue();
                String firstName = row.getCell(1).getStringCellValue();
                String lastName = row.getCell(2).getStringCellValue();
                double baseSalary = row.getCell(3).getNumericCellValue();
                int hoursWorked = (int) row.getCell(4).getNumericCellValue();
                String position = row.getCell(5).getStringCellValue();
                double performanceRating = row.getCell(6).getNumericCellValue();
                String department = row.getCell(7).getStringCellValue();
                int age = (int) row.getCell(8).getNumericCellValue();
                int contactNumber = (int) row.getCell(9).getNumericCellValue();
                String address = row.getCell(10).getStringCellValue();
                String gender = row.getCell(11).getStringCellValue();

                // Create the Employee instance
                Employee employee = facade.createEmployee(employeeID, firstName, lastName, baseSalary, hoursWorked, performanceRating, department, position, age, contactNumber, address, gender);

                // Add row to JTable
                DecimalFormat df = new DecimalFormat("#.00");
                model.addRow(new Object[]{
                    employee.getEmployeeID(),
                    employee.getLastName() + ", " + employee.getFirstName(),
                    employee.getDepartment(),
                    employee.getPosition(),
                    df.format(employee.calculateSalary()),
                    employee.classifyPerformance(),
                });
            }

            JOptionPane.showMessageDialog(null, "Data loaded from Excel file successfully.");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while loading the Excel file.");
        }
    }//GEN-LAST:event_LoadButtonActionPerformed

    private void CheckDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckDetailsMouseEntered
        CheckDetails.setOpaque(true);
        CheckDetails.setBackground(new Color(192, 211, 255, 100));
    }//GEN-LAST:event_CheckDetailsMouseEntered

    private void CheckDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckDetailsMouseExited
        CheckDetails.setOpaque(false);
    }//GEN-LAST:event_CheckDetailsMouseExited

    private void CheckDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckDetailsActionPerformed
    int selectedRow = EmployeeTable.getSelectedRow();
        if (selectedRow != -1) {
            String employeeID = (String) EmployeeTable.getValueAt(selectedRow, 0);
            Employee selectedEmployee = facade.getEmployeeById(employeeID);

            if (selectedEmployee != null) {
                // Create a message with employee details
                String employeeDetails = "Employee ID: " + selectedEmployee.getEmployeeID() + "\n" +
                                         "Name: " + selectedEmployee.getFirstName() + " " + selectedEmployee.getLastName() + "\n" +
                                         "Department: " + selectedEmployee.getDepartment() + "\n" +
                                         "Position: " + selectedEmployee.getPosition() + "\n" +
                                         "Base Salary: " + selectedEmployee.getBaseSalary() + "\n" +
                                         "Hours Worked: " + selectedEmployee.getHoursWorked() + "\n" +
                                         "Performance Rating: " + selectedEmployee.getPerformanceRating();
                // Show the message in a JOptionPane
                JOptionPane.showMessageDialog(this, employeeDetails, "Employee Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an employee to view details.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_CheckDetailsActionPerformed

    private void SaveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseEntered
        SaveButton.setOpaque(true);
        SaveButton.setBackground(new Color(192, 211, 255, 100));
    }//GEN-LAST:event_SaveButtonMouseEntered

    private void SaveButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveButtonMouseExited
        SaveButton.setOpaque(false);
    }//GEN-LAST:event_SaveButtonMouseExited

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        String userHome = System.getProperty("user.home");
        File documentsFolder = new File(userHome, "Documents");
        File fileToSave = new File(documentsFolder, "DATABASE.xlsx");

        // Ensure the parent directory exists
        if (!documentsFolder.exists() && !documentsFolder.mkdirs()) {
            JOptionPane.showMessageDialog(null, "Failed to create directory: " + documentsFolder.getAbsolutePath());
            return;
        }

        try (Workbook workbook = new XSSFWorkbook()) { // Create a new workbook
            Sheet sheet = workbook.createSheet("Employee Data");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Employee ID", "First Name", "Last Name", "Base Salary", "Hours Worked", "Position", "Performance Rating", "Department", "Age", "Contact Number", "Address", "Gender"};
            for (int col = 0; col < headers.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(headers[col]);
            }

            // Add data rows
            ArrayList<Employee> employees = facade.getAllEmployees(); // Fetch employees from the facade
            int rowIndex = 1; // Start from row 1 (row 0 is for headers)

            for (Employee employee : employees) {
                Row dataRow = sheet.createRow(rowIndex++);
                dataRow.createCell(0).setCellValue(employee.getEmployeeID());
                dataRow.createCell(1).setCellValue(employee.getFirstName());
                dataRow.createCell(2).setCellValue(employee.getLastName());
                dataRow.createCell(3).setCellValue(employee.getBaseSalary());
                dataRow.createCell(4).setCellValue(employee.getHoursWorked());
                dataRow.createCell(5).setCellValue(employee.getPosition());
                dataRow.createCell(6).setCellValue(employee.getPerformanceRating());
                dataRow.createCell(7).setCellValue(employee.getDepartment());

                // Access EmployeeDetails
                EmployeeDetails details = employee.getDetails();
                if (details != null) {
                    dataRow.createCell(8).setCellValue(details.getAge());
                    dataRow.createCell(9).setCellValue(details.getContactNumber());
                    dataRow.createCell(10).setCellValue(details.getAddress());
                    dataRow.createCell(11).setCellValue(details.getGender());
                } else {
                    // Handle case where EmployeeDetails might be null
                    dataRow.createCell(8).setCellValue("N/A");
                    dataRow.createCell(9).setCellValue("N/A");
                    dataRow.createCell(10).setCellValue("N/A");
                    dataRow.createCell(11).setCellValue("N/A");
                }
            }

            // Resize columns to fit the content
            for (int col = 0; col < headers.length; col++) {
                sheet.autoSizeColumn(col);
            }

            // Write the new workbook to the file
            try (FileOutputStream fileOut = new FileOutputStream(fileToSave)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(null, "Data saved to Excel file successfully.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while saving the Excel file.");
        }

    }//GEN-LAST:event_SaveButtonActionPerformed

    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButtonActionPerformed
        // Confirm if the user wants to save data before logging out
        int userResponse = JOptionPane.showConfirmDialog(
            null, 
            "Do you want to save your data before logging out?", 
            "Confirm Logout", 
            JOptionPane.YES_NO_OPTION
        );

        if (userResponse == JOptionPane.YES_OPTION) {
            // Save the data
            SaveButtonActionPerformed(evt);
            // Proceed with logout
            showLoginForm();
        } else if (userResponse == JOptionPane.NO_OPTION) {
            // Proceed with logout without saving
            showLoginForm();
        }
    }//GEN-LAST:event_LogOutButtonActionPerformed
    private void showLoginForm() {
        // Show the login form
        AdminLoginForm admin = new AdminLoginForm();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);
        // Dispose of the current form
        this.dispose();
    }
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

    private void EmployeeSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmployeeSearchKeyReleased
        rowSorter.setRowFilter(RowFilter.regexFilter(EmployeeSearch.getText()));
    }//GEN-LAST:event_EmployeeSearchKeyReleased

    private void EmployeeSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmployeeSearchFocusGained
        // TODO add your handling code here:
        EmployeeSearch.setText("");
    }//GEN-LAST:event_EmployeeSearchFocusGained

    private void SortByComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortByComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SortByComboBoxActionPerformed

    private void SortByComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SortByComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String columnName = SortByComboBox.getSelectedItem().toString();
            sort(columnName);
        }
    }//GEN-LAST:event_SortByComboBoxItemStateChanged
    private void sort(String columnName) {
        DefaultTableModel model = (DefaultTableModel) EmployeeTable.getModel();
    
    if ("None".equalsIgnoreCase(columnName)) {
        // Revert to default sorting or no sorting
        rowSorter.setSortKeys(null);
        return;
    }

    // Find the column index based on the column name
    int columnIndex = -1;
    for (int i = 0; i < model.getColumnCount(); i++) {
        if (model.getColumnName(i).equalsIgnoreCase(columnName)) {
            columnIndex = i;
            break;
        }
    }
    
    if (columnIndex != -1) {
        // Determine if the column is numeric or alphabetical
        boolean isNumeric = true;
        for (int row = 0; row < model.getRowCount(); row++) {
            try {
                Double.parseDouble(model.getValueAt(row, columnIndex).toString());
            } catch (NumberFormatException e) {
                isNumeric = false;
                break;
            }
        }

        // Apply sorting
        if (isNumeric) {
            rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(columnIndex, SortOrder.ASCENDING)));
        } else {
            rowSorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(columnIndex, SortOrder.ASCENDING)));
        }
    } else {
        System.out.println("Column not found: " + columnName);
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
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new AdminView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton CheckDetails;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTextField EmployeeSearch;
    private static javax.swing.JTable EmployeeTable;
    private javax.swing.JButton LoadButton;
    private javax.swing.JButton LogOutButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JToggleButton SearchButton;
    private javax.swing.JComboBox<String> SortByComboBox;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyLibs;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jomar Fellores
 */
public class SharedTableModel extends DefaultTableModel{
    public SharedTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }
}

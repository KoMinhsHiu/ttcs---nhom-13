/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author sidac
 */
public class EnchanceTable extends javax.swing.JTable{
    private int flagIndex = -1;
    
    //Default value
    private boolean defaultValueSortableAttr = false;
    private boolean defaultValueEditableAttr = false; 
    private String defaultTheme = "light";
    private int defaultFontSize = 12;
//    private Font defaultFont = new Font("Time New Roman",Font.TRUETYPE_FONT ,this.defaultFontSize); 
    private boolean defaultCanSelectAll = false;
    
    public EnchanceTable() {
        
    }
    public EnchanceTable(boolean sortableAttr, boolean editableAttr, boolean canSelectAll, int fontSize) {
        this.defaultValueSortableAttr = sortableAttr;
        this.defaultValueEditableAttr = editableAttr;
        this.defaultCanSelectAll = canSelectAll;
        this.defaultFontSize = fontSize;
    }
    public JTable enchanedTable(Object[][] data, String[] header, boolean[] editableColumns, boolean[] sortableColumns, boolean isCanSelectAll, int fontSize){
        JTable table = new JTable();
        if (isCanSelectAll){
            header = new String[header.length];
            header[header.length - 1] = "Chọn";
        }
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            header
        ) {
            boolean[] canEdit = editableColumns;
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == data.length+1 ? Boolean.class : super.getColumnClass(columnIndex);
            }
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        if (isCanSelectAll){
            JTableHeader tableHeader = table.getTableHeader();
            tableHeader.addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int col = tableHeader.columnAtPoint(evt.getPoint());
                    TableColumnModel columnModel = table.getColumnModel();
                    String name = columnModel.getColumn(col).getHeaderValue().toString();
                    if (name == "Chọn"){
                        for (int i = 0; i < table.getRowCount(); i++) {
                            table.setValueAt(true, i, col);
                        }
                    }
                }
            });
        }

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                tableMouseClicked(evt);
            }
        });
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Object[] item : data) {
            model.addRow(item);
        }
        
//        setFontForHeaderTable(table, fontSize);
        return table;
    }

    public JTable enchanedTable(Object[][] data){
        int n = data.length;
        String[] header = new String[n];
        boolean[] sortableColumns = new boolean[n];
        boolean[] editableColumns = new boolean[n];
        boolean isCanSelectAll = defaultCanSelectAll;
        for (int i = 0; i< data.length; i++){
            header[i] = "Column " + i;
            sortableColumns[i] = defaultValueSortableAttr;
            editableColumns[i] = defaultValueEditableAttr;
        }
        return enchanedTable(data, header, sortableColumns, editableColumns, isCanSelectAll, defaultFontSize);
    }
    private class CustomHeaderRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component headerComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            headerComponent.setBackground(Color.YELLOW);
            return headerComponent;
        }
    }
    
    private class CustomHeaderRendererBack extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component headerComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            headerComponent.setBackground(Color.LIGHT_GRAY);
            return headerComponent;
        }
    }
    private void setFontForHeaderTable(JTable table, Font font, int fontSize) {
        table.setFont(new Font(font.getName(), font.getStyle(), fontSize));

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font(font.getName(), Font.BOLD, fontSize));
    }
    
}

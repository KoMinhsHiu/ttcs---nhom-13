/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
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
public class enhanceTable {
    private int flagIndex = -1;
    private boolean defaultValueSortableAttr = false;
    private boolean defaultValueEditableAttr = false; 
    private String defaultTheme = "light";
    private int defaultFontSize = 12;
//    private Font defaultFont = new Font("Time New Roman",Font.TRUETYPE_FONT ,this.defaultFontSize); 
    private boolean defaultCanSelectAll = false;
    public JTable renderTransactionTableWithFrame1(Object[][] data){
        JTable table = new JTable();
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Mã", "A","B", "Thời gian", "Chọn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true
            };
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Ä�áº·t kiá»ƒu dá»¯ liá»‡u cá»§a cá»™t kiá»ƒu boolean lÃ  Boolean
                return columnIndex == 5 ? Boolean.class : super.getColumnClass(columnIndex);
            }
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
//        JTableHeader transactionHeader = table.getTableHeader();
//        transactionHeader.addMouseListener(new MouseInputAdapter() {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                int col = transactionHeader.columnAtPoint(evt.getPoint());
//                TableColumnModel columnModel = table.getColumnModel();
//                String name = columnModel.getColumn(col).getHeaderValue().toString();
//                if (name == "Chọn"){
//                    for (int i = 0; i < table.getRowCount(); i++) {
//                        table.setValueAt(true, i, col);
//                    }
//                }
//            }
//        });
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
        return table;
    }
//    public static JTable renderTable(Object[][] data){
//        DefaultTableModel model = new DefaultTableModel(data);
//        JTable table = new JTable(model);
//
//        // Loại bỏ border bên trong
//        table.setShowGrid(false);
//        table.setIntercellSpacing(new Dimension(0, 0));
//
//        // Thiết lập hiệu ứng đổi màu khi di chuột qua
//        table.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                table.clearSelection();
//            }
//        });
//    }
    public JTable renderTransactionTableWithFrame(Object[][] data){
        Vector<Vector<Object>> formattedData = new Vector<Vector<Object>>();
        for (int i = 0; i< data.length; i++){
            Vector<Object> da = new Vector<Object>();
            for (int j = 0; j < data[i].length; j++){
                da.add(data[i][j]);
            }
            formattedData.add(da);
        }
        return renderTransactionTableWithFrame(formattedData);
    }
        
    public JTable renderTransactionTableWithFrame(Vector<String> headerName, Object[][] data){
        Vector<Vector<Object>> formattedData = new Vector<Vector<Object>>();
        for (int i = 0; i< data.length; i++){
            Vector<Object> da = new Vector<Object>();
            for (int j = 0; j < data[i].length; j++){
                da.add(data[i][j]);
            }
            formattedData.add(da);
        }
        return renderTransactionTableWithFrame(headerName, formattedData);
    }
    
    public JTable renderTransactionTableWithFrame(Vector<Vector<Object>> data, String[] header, boolean[] editableColumns, boolean[] sortableColumns, boolean isCanSelectAll, int fontSize){
        // Dữ liệu mẫu
//        Vector<Object> vector1 = new Vector<>(Arrays.asList(1, 2, "A"));
//        Vector<Object> vector2 = new Vector<>(Arrays.asList(3, 4, "B"));
//        Vector<Object> vector3 = new Vector<>(Arrays.asList(5, 6, "C"));
//        data.add(vector1);
//        data.add(vector2);
//        data.add(vector3);

        // Tạo bảng và mô hình
        Vector<String> headerVector = new Vector<String>();
        if (isCanSelectAll){
            header = new String[header.length];
            header[header.length - 1] = "Chọn";
        }
        for (String s : header){
            headerVector.add(s);
        }
        DefaultTableModel model = new DefaultTableModel(data, headerVector) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Chỉnh sửa tính chất có thể chỉnh sửa của các cột
                return editableColumns[column];
            }
        };
        JTable table = new JTable(model);

        // Loại bỏ border bên trong
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));

        // Thiết lập hiệu ứng đổi màu khi di chuột qua
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                table.clearSelection();
            }
        });

        table.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                table.clearSelection();
                if (row >= 0 && row < table.getRowCount()) {
                    table.addRowSelectionInterval(row, row);
                }
            }
        });

        // Thiết lập màu xen kẽ cho các dòng
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                
                
                if (!isSelected) {
                    // Chọn màu xen kẽ cho các dòng
                    if (row % 2 == 0) {
                        rendererComponent.setBackground(new Color(240, 240, 240));
                    } else {
                        rendererComponent.setBackground(Color.WHITE);
                    }
                }

                return rendererComponent;
            }
        });
        JTableHeader tableHeader = table.getTableHeader();

        // Lấy TableColumnModel từ JTableHeader
        TableColumnModel columnModel = tableHeader.getColumnModel();

        // Lấy số lượng cột
        int columnCount = columnModel.getColumnCount();

        // Lấy từng TableColumn cụ thể
        for (int i = 0; i < columnCount; i++) {
            TableColumn column = columnModel.getColumn(i);
//            tableHeader.getColumnModel().getColumn(i).addMouseListener()

        }
        JTableHeader tableHeader1 = table.getTableHeader();
        tableHeader1.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int column = tableHeader1.columnAtPoint(e.getPoint());
                if (column != -1 && column != flagIndex) {
                    System.out.println(column + " " + flagIndex);
                    tableHeader1.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRenderer());
                    if (flagIndex != -1){
                        tableHeader1.getColumnModel().getColumn(flagIndex).setHeaderRenderer(new CustomHeaderRendererBack());
                    }
                    tableHeader1.repaint();
                    flagIndex = column;

                }
            }
            
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                int column = tableHeader1.columnAtPoint(e.getPoint());
//                if (column != -1) {
//                    String columnName = table.getColumnName(column);
//                    tableHeader.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRenderer());
//                    tableHeader.repaint();
//                }
//            }
//            
            @Override
            public void mouseExited(MouseEvent e) {
                int column = tableHeader1.columnAtPoint(e.getPoint());
//                if (column != -1) {
//                    String columnName = table.getColumnName(column);
//                    tableHeader.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRendererBack());
//                    tableHeader.repaint();
//                }
                System.out.println("a" + column);
                for (int i =0 ; i< columnCount; i++){
                    tableHeader1.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRendererBack());
//                    tableHeader.repaint()
                }
                tableHeader1.repaint();
            }
        });

        // Thêm sự kiện chuột để lấy cell header hiện tại
        tableHeader1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                int column = tableHeader1.columnAtPoint(e.getPoint());
                if (column != -1) {
                    
                    String columnName = table.getColumnName(column);
                    tableHeader.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRenderer());
                    tableHeader.repaint();
                    
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                int column = tableHeader1.columnAtPoint(e.getPoint());
                if (column != -1) {
                    String columnName = table.getColumnName(column);
                    tableHeader.getColumnModel().getColumn(column).setHeaderRenderer(new CustomHeaderRendererBack());
                    tableHeader.repaint();
                }
            }
            
//    @Override
//    public void mouseMoved(MouseEvent e) {
////        int column = tableHeader.columnAtPoint(e.getPoint());
////        if (column != -1) {
//            // Xử lý khi chuột di chuyển trên ô header
//            System.out.println("Mouse moved over header cell: ");
////        }
//    }
        });
//        
        // Đặt ActionListener cho cột khi click vào header
//        table.getTableHeader().addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                table.getTableHeader().setBackground(Color.YELLOW);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                table.getTableHeader().setBackground(UIManager.getColor("TableHeader.background"));
//            }
//        });

        // Tạo cửa sổ và thêm bảng vào đó
        table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return table;
    }
    
    public JTable renderTransactionTableWithFrame(Vector<Vector<Object>> data){
        int n = data.size();
       String[] header = new String[n];
        boolean[] sortableColumns = new boolean[n];
        boolean[] editableColumns = new boolean[n];
        boolean isCanSelectAll = defaultCanSelectAll;
        for (int i = 0; i< n; i++){
            header[i] = "Column " + i;
            sortableColumns[i] = defaultValueSortableAttr;
            editableColumns[i] = defaultValueEditableAttr;
        }
        return renderTransactionTableWithFrame(data, header, sortableColumns, editableColumns, isCanSelectAll, defaultFontSize);
    }
    
    /**
     * Hàm tạo table có header name
     * @param headerName
     * @param data
     * @return Jtable
     */
    public JTable renderTransactionTableWithFrame(Vector<String> headerName, Vector<Vector<Object>> data){
        int n = data.size();
        String[] header = new String[n];
        boolean[] sortableColumns = new boolean[n];
        boolean[] editableColumns = new boolean[n];
        boolean isCanSelectAll = defaultCanSelectAll;
        for (int i = 0; i< n; i++){
            header[i] = headerName.get(i);
            sortableColumns[i] = defaultValueSortableAttr;
            editableColumns[i] = defaultValueEditableAttr;
        }
        return renderTransactionTableWithFrame(data, header, sortableColumns, editableColumns, isCanSelectAll, defaultFontSize);
    }
        
    private class CustomHeaderRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component headerComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            headerComponent.setBackground(Color.YELLOW);
            return headerComponent;
        }
    }
    
    private static class CustomHeaderRendererBack extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component headerComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            headerComponent.setBackground(Color.LIGHT_GRAY);
            return headerComponent;
        }
    }
}

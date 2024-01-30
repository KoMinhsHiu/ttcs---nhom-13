package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import model.connection.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import model.objects.TypeO;


public class DanhMucThu {
     // lấy danh mục trong cơ sở dữ liệu để đưa ra jcombobox
    public static void populateDanhmucComboBox(JComboBox<String> Danhmuc) {
        String sql = "SELECT Name_Type FROM Type WHERE Receipts_Or_expenses = 0";
        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Danhmuc.removeAllItems();
            while (resultSet.next()) {
                String danhMuc = resultSet.getString("Name_Type");
                Danhmuc.addItem(danhMuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
     //Thêm mục 
    public static void themMucActionPerformed(JComboBox<String> Danhmuc) {
        String newCategory = JOptionPane.showInputDialog(Danhmuc, "Thêm danh mục mới:");
        if (newCategory != null && !newCategory.trim().isEmpty()) {
                Danhmuc.addItem(newCategory);
                Danhmuc.setSelectedItem(newCategory);
                saveCategoryToDatabase(newCategory,Danhmuc);
        } else {
            Danhmuc.setSelectedItem(" ");
        }
    }
    
    // lưu danh mục khi thêm vào cơ sở dữ liệu
    private static void saveCategoryToDatabase(String newCategory, JComboBox<String> Danhmuc) {
        String sql = "INSERT INTO Type (Name_Type,Receipts_Or_expenses) VALUES (?, 0)";
        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newCategory);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(Danhmuc, "Danh mục đã được thêm", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(Danhmuc, "Lỗi khi thêm danh mục", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {      
            e.printStackTrace();
        } 
    }

}

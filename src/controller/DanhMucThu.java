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
            if (!isCategoryAlreadyExists(newCategory, Danhmuc)) {
                Danhmuc.addItem(newCategory);
                Danhmuc.setSelectedItem(newCategory);
                saveCategoryToDatabase(newCategory,Danhmuc);
               
                
            } else {
                JOptionPane.showMessageDialog(Danhmuc, "Danh mục đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
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

     // Ràng buộc kiểm tra khi thêm và sửa danh mục có trùng trong cơ sở dữ liêu hay không
    private static boolean isCategoryAlreadyExists(String newCategory, JComboBox<String> Danhmuc) {
        String[] categories = getCategories(Danhmuc);
        for (String category : categories) {
            if (category.equalsIgnoreCase(newCategory.trim())) {
                return true; 
            }
        }
        //Receipts_Or_expenses = 1 Tương ứng với danh mục thu, ID_User = -1 để lấy danh mục thu có sẵn lưu trong db
        String sql = "SELECT COUNT(*) FROM Type WHERE UPPER(Name_Type) = UPPER(?) and (Receipts_Or_expenses = 0)"; 
        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newCategory.trim());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() && resultSet.getInt(1) > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return false;
    }
    
    // Phương thức để lấy danh sách các danh mục từ JComboBox
    private static String[] getCategories(JComboBox<String> Danhmuc) {
        int itemCount = Danhmuc.getItemCount();
        String[] categories = new String[itemCount];
        for (int i = 0; i < itemCount; i++) {
            categories[i] = (String) Danhmuc.getItemAt(i);
        }
        return categories;
    }

   
    
    
     // Xóa mục
    public static void xoaMucActionPerformed(JComboBox<String> Danhmuc) {                                       
            
        String[] categories = getCategories(Danhmuc);
        String selectedCategory = (String) JOptionPane.showInputDialog(
                Danhmuc,
                "Chọn danh mục để xóa:",
                "Xóa mục",
                JOptionPane.QUESTION_MESSAGE,
                null,
                categories,
                categories.length > 0 ? categories[0] : null
        );
        if (selectedCategory != null) {
            Danhmuc.removeItem(selectedCategory);
            deleteCategoryFromDatabase(selectedCategory,Danhmuc );
        }
    }                                      

                                
    // hàm để xóa danh mục khỏi cơ sở dữ liệu
    private static void deleteCategoryFromDatabase(String selectedCategory,JComboBox<String> Danhmuc) {
        String sql = "DELETE FROM Type WHERE Name_Type=?";
        try {
            Connection connection = JDBCConnection.getJDBCConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, selectedCategory);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(Danhmuc, "Danh mục đã được xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(Danhmuc, "Lỗi khi xóa danh mục", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    //Sửa mục
    public static void suaMucActionPerformed(JComboBox<String> Danhmuc) {                                       

        String selectedCategory = (String) Danhmuc.getSelectedItem();
        if (selectedCategory == null || selectedCategory.trim().isEmpty()) {
            JOptionPane.showMessageDialog(Danhmuc, "Vui lòng chọn một danh mục để sửa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String newCategory = JOptionPane.showInputDialog(Danhmuc, "Nhập tên danh mục mới:", selectedCategory);
        if (newCategory != null && !newCategory.trim().isEmpty()) {
            if (!isCategoryAlreadyExists(newCategory,Danhmuc)) {
                Danhmuc.removeItem(selectedCategory);
                Danhmuc.addItem(newCategory);
                Danhmuc.setSelectedItem(newCategory);
                updateCategoryInDatabase(selectedCategory, newCategory,Danhmuc);
            } 
            else{
                JOptionPane.showMessageDialog(Danhmuc, "Danh mục đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } 
        else {
            Danhmuc.setSelectedItem(" "); 
        }
    }                                      
    
    // Cập nhật lại cơ sở dữ liệu khi sửa mục
    private static void updateCategoryInDatabase(String oldCategory, String newCategory,JComboBox<String> Danhmuc) {
        String sql = "UPDATE Type SET Name_Type=? WHERE Name_Type=?";
        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newCategory);
            preparedStatement.setString(2, oldCategory);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(Danhmuc, "Danh mục đã được cập nhật", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(Danhmuc, "Lỗi khi cập nhật danh mục", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }  
}

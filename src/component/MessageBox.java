/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.awt.Component;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author sidac
 */
public class MessageBox {
    private static String notNumberErrMessage = "Số nhập vào không hợp lệ";
    private static String wrongDateStringMessage = "Ngày không hợp lệ";
    
    public static void showError(Component parentComponent, String message) {
        JOptionPane.showMessageDialog(parentComponent, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showNotNumErr(Component parentComponent){
        showError(parentComponent, notNumberErrMessage);
    }
    
    public static void showWrongDateFormat(Component parentComponent){
        showError(parentComponent, wrongDateStringMessage);
    }
}

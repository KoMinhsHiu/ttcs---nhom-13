/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sidac
 */
public class JDBCConnection {
    public static Connection getJDBCConnection(){
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=QLTC;encrypt = true;trustServerCertificate=true";
        String username = "qltc";
        String password = "2612";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connect thành công");
            return connection;
        } catch (SQLException e) {
            System.out.println("Có lỗi!");
            e.printStackTrace();
        }
        
        return null;
    }
}


package model.connection;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnection {
    public static Connection getJDBCConnection(){
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLTC;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "sa";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successfull !");
            return connection;
        }catch(SQLException e){
            System.out.println("Connection Fail !");
            e.printStackTrace();
        }
        return null;
    }
}

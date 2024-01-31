/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.objects;

import java.sql.ResultSet;


import java.math.BigDecimal;
import model.connection.JDBCConnection;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import Utils.DateHelpder;
import java.sql.Types;
import java.util.Vector;


/**
 *
 * @author sidac
 */
public class LogsDB {
    public Connection getConnection(){
        JDBCConnection myJDBCFuncLib = new JDBCConnection();
        return myJDBCFuncLib.getJDBCConnection();
    }
    
    public int insertLog(int ID_Type, BigDecimal Price, String Note,String DateString, int ID_User){
        int idAdded = -1;
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.InsertLog(?, ?, ?, ?, ?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setInt(1, ID_Type);
                callableStatement.setObject(2, Price); 
                callableStatement.setString(3, Note); 
                callableStatement.setString(4, DateHelpder.convertStringToSQLDate(DateString)); 
                callableStatement.setInt(5,ID_User);
                
                // Đặt loại dữ liệu và đăng ký OUTPUT parameter
                callableStatement.registerOutParameter(6, Types.INTEGER);
                

                // Thực thi stored procedure
                callableStatement.executeUpdate();
                
                idAdded = callableStatement.getInt(6);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idAdded;
    }
    
    public void deleteLogWithID(int ID_Log){
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.DeleteLogByID(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setInt(1, ID_Log);
                // Thực thi stored procedure
                callableStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void findLogWithID(int ID_Log){
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.getLogByID(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setInt(1,ID_Log);
                // Thực thi stored procedure
                callableStatement.executeUpdate();
                
                ResultSet rs = callableStatement.getResultSet();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void findLogWithIDs(String ID_Logs){
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.getLogByID(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setString(1,ID_Logs);
                // Thực thi stored procedure
                callableStatement.executeUpdate();
                
                ResultSet rs = callableStatement.getResultSet();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * @param ID_Log
     * @param data [ID_Log, ID_Type, Price, Note]
     */
    public void updateLog(Object[] data){
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.UpdateLog(?,?,?,?,?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setObject(1,data[0]); //Id_Log
                callableStatement.setObject(2,data[1]); //ID_Type
                callableStatement.setObject(3,data[2]); //Price
                callableStatement.setObject(4,data[3]); //Note
                callableStatement.setObject(5,data[4]); //DateString

                // Thực thi stored procedure
                callableStatement.executeUpdate();
                
                ResultSet rs = callableStatement.getResultSet();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateData(Object[][] data){
        Vector<Object[]> datas = new Vector<Object[]>();
        for (Object[] item : data) {
            updateLog(item);
            datas.add(item);
        }
    }
    
    public void updateLog(Vector<Object[]> data){
        
    }
    
    public Vector<Object[]> getDataWithCondition(Vector<String> conditions, Vector<String> orders){
        Vector<Object[]> ans = null;
        String whereString  = "";
        String orderString = "";
        if (conditions.size() > 0){
            whereString = "WHERE ";
            for (int i = 0; i < conditions.size(); i++) {
                whereString += conditions.get(i);
                if (i != conditions.size() - 1){
                    whereString += " AND ";
                }
            }
        }
        if (orders.size() > 0){
            orderString = "ORDER BY ";
            for (int i = 0; i < orders.size(); i++) {
                orderString += orders.get(i);
                if (i != orders.size() - 1){
                    orderString += ", ";
                }
            }
        }
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.GetLogsByCondition(?,?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setObject(1, whereString); 
                callableStatement.setObject(2, orderString); 
                // Thực thi stored procedure
                callableStatement.executeQuery();
                
                ResultSet rs = callableStatement.getResultSet();
                
                ans = new Vector<Object[]>();
                while (rs.next()){
                    Object[] item = new Object[6];
                    item[0] = rs.getInt("ID_Log");
                    item[1] = rs.getInt("ID_User");
                    item[2] = rs.getInt("ID_Type");
                    item[3] = rs.getObject("Price");
                    item[4] = rs.getString("Note");
                    item[5] = rs.getString("Date");
                    ans.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ans;
    }
    
    public void deleteLogs(Vector<Integer> vec){
        String idString = Utils.Utils.vectorIntToString(vec);
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.DeleteLogsByIds(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setString(1,Utils.Utils.vectorIntToString(vec));
                // Thực thi stored procedure
                callableStatement.executeUpdate();
                
                ResultSet rs = callableStatement.getResultSet();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

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
import Utils.DateHelper;
import Utils.Utils;
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
                callableStatement.setString(4, DateHelper.convertStringToSQLDate(DateString)); 
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
            String storedProcedureCall = "{call dbo.DeleteLogsByIDs(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setString(1, Integer.toString(ID_Log));
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
    
    public void restoreLogWithID(int ID_Log){
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.restoreLogs(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setString(1, Integer.toString(ID_Log));
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
                System.out.println("Id: " + data[0] + " note: "+ data[3]);
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
            whereString = "WHERE Log.IsDeleted = 0 AND ";
            for (int i = 0; i < conditions.size(); i++) {
                whereString += conditions.get(i);
                if (i != conditions.size() - 1){
                    whereString += " AND ";
                }
            }
            if (conditions.size() == 0){
                whereString = "WHERE Log.IsDeleted = 0 ";
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
                    item[2] = rs.getString("Name_Type");
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
        String idString = Utils.vectorIntToString(vec);
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.DeleteLogsByIds(?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setString(1,Utils.vectorIntToString(vec));
                // Thực thi stored procedure
                callableStatement.executeUpdate();
                
                ResultSet rs = callableStatement.getResultSet();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        String dateStart = "2024-02-01";
        String dateEnd = "2024-03-31";
        Vector<Object[]> ans = new Vector<>();
        int dateCount = 5;
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.GetProportionOfItemInTypes(?,?,?,?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setInt(1, 0);
                callableStatement.setString(2, dateStart);
                callableStatement.setString(3, dateEnd);
                callableStatement.setInt(4, dateCount);

                // Thực thi stored procedure
                boolean hasResults = callableStatement.execute();

                // Kiểm tra xem có result set trả về hay không
                if (hasResults) {
                    ResultSet rs = callableStatement.getResultSet();
                    ans = new Vector<>();
                    while (rs.next()) {
                        Object[] item = new Object[3];
                        item[0] = rs.getString("GroupStartDate");
                        item[1] = rs.getDouble("TotalPrice");
                        item[2] = rs.getInt("T");
                        ans.add(item);
                    }
                    
//                     Xử lý dữ liệu tại đây (ví dụ: in ra các giá trị)
                    for (Object[] item : ans) {
                        String groupStartDate = (item[0] != null) ? item[0].toString() : "N/A";
                        double totalPrice = (item[1] != null) ? (double) item[1] : 0.0;
                        int tValue = (item[2] != null) ? (int) item[2] : 0;

//                        System.out.println("GroupStartDate: " + groupStartDate + ", TotalPrice: " + totalPrice + ", T: " + tValue);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        String dateStartFormatted = DateHelper.convertStringDateFormat(dateStart, "yyyy-MM-dd", "dd/MM/yyyy");
        String dateEndFormatted = DateHelper.convertStringDateFormat(dateEnd, "yyyy-MM-dd", "dd/MM/yyyy");
        String curStartDate = dateStartFormatted;
        int n = (int) Math.round(DateHelper.calDateDiffBetweenToDate(dateStartFormatted, dateEndFormatted, "dd/MM/yyyy") / dateCount);
        Object[][] f_ans = new Object[n][3];
        Object[][] tieu_ans = new Object[n][3];
        for (int i = 0 ; i < n; i++){
            f_ans[i][0] = curStartDate;
            f_ans[i][1] = 0;
            curStartDate = DateHelper.getDateFormattedWithOffset(dateStartFormatted, "d", (i+1)*dateCount);
        }
        int j =0;
        for (int i = 0 ;i < ans.size(); i++){
            if ((int)ans.get(i)[2] == 0){
                System.out.println(j);
                f_ans[j][1] = ans.get(i)[1];
                j++;
            }
        }
        
        for (int i = 0 ;i < f_ans.length; i++){
            System.out.println("Date: " + f_ans[i][0] + " price: "+ f_ans[i][1]);
        }
        
    }
    
    public Object[][] getDataDays(String dateStart, String dateEnd, int groupSize) {
        int dateCount = groupSize;
        Vector<Object[]> ans = new Vector<>();
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.GetProportionOfItemInTypes(?,?,?,?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setInt(1, 0);
                callableStatement.setString(2, dateStart);
                callableStatement.setString(3, dateEnd);
                callableStatement.setInt(4, dateCount);

                // Thực thi stored procedure
                boolean hasResults = callableStatement.execute();

                // Kiểm tra xem có result set trả về hay không
                if (hasResults) {
                    ResultSet rs = callableStatement.getResultSet();
                    ans = new Vector<>();
                    while (rs.next()) {
                        Object[] item = new Object[3];
                        item[0] = rs.getString("GroupStartDate");
                        item[1] = rs.getDouble("TotalPrice");
                        item[2] = rs.getInt("T");
                        ans.add(item);
                    }
                    
//                     Xử lý dữ liệu tại đây (ví dụ: in ra các giá trị)
                    for (Object[] item : ans) {
                        String groupStartDate = (item[0] != null) ? item[0].toString() : "N/A";
                        double totalPrice = (item[1] != null) ? (double) item[1] : 0.0;
                        int tValue = (item[2] != null) ? (int) item[2] : 0;

                        System.out.println("GroupStartDate: " + groupStartDate + ", TotalPrice: " + totalPrice + ", T: " + tValue);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        String dateStartFormatted = DateHelper.convertStringDateFormat(dateStart, "yyyy-MM-dd", "dd/MM/yyyy");
        String dateEndFormatted = DateHelper.convertStringDateFormat(dateEnd, "yyyy-MM-dd", "dd/MM/yyyy");
        String curStartDate = dateStartFormatted;
        int n = 1 + (int) Math.round( (double)DateHelper.calDateDiffBetweenToDate(dateStartFormatted, dateEndFormatted, "dd/MM/yyyy") / dateCount);

        Object[][] f_ans = new Object[n][3];
        Object[][] tieu_ans = new Object[n][3];
        for (int i = 0 ; i < n; i++){
            f_ans[i][0] = curStartDate;
            int index = (int) Math.ceil(DateHelper.calDateDiffBetweenToDate(dateStartFormatted, curStartDate, "dd/MM/yyyy") / dateCount);
            System.out.println("index: " + index + " " +ans.get(i)[1]);
            int index_to_put = 0;
            if ((int)ans.get(i)[2] == 0){
                index_to_put = 0;
            }
            else if ((int)ans.get(i)[2] == 1){
                index_to_put = 1;
            }
            f_ans[index][index_to_put+1] =  ans.get(i)[1];
//            f_ans[i][1] = 0;
//            f_ans[i][2] = 0;
            curStartDate = DateHelper.getDateFormattedWithOffset(dateStartFormatted, "d", (i+1)*(dateCount));
        }
        for (int i = 0; i< f_ans.length; i++){
            for (int j = 1; j <f_ans[i].length; j++){
                if (f_ans[i][j] == null){
                    f_ans[i][j] = 0.0;
                }
            }
        }
        return f_ans;
    }
    public void test1(){
        System.out.println("test1");
        String dateStart = "2024-02-01";
        String dateEnd = "2024-03-31";
        int type = 0;
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.SP_GetTotalOfItem(?,?,?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setInt(1, type);
                callableStatement.setString(2, dateStart);
                callableStatement.setString(3, dateEnd);

                // Thực thi stored procedure
                boolean hasResults = callableStatement.execute();

                // Kiểm tra xem có result set trả về hay không
                if (hasResults) {
                    ResultSet rs = callableStatement.getResultSet();
                    Vector<Object[]> ans = new Vector<>();
                    while (rs.next()) {
                        Object[] item = new Object[3];
                        item[0] = rs.getString("TypeName");
                        item[1] = rs.getDouble("TotalPrice");
                        ans.add(item);
                        System.out.println(dateStart + " - " + dateEnd);
                        System.out.println("TypeName: " + item[0] + " TotalPrice: " + item[1]);

                    }
                    // Xử lý dữ liệu tại đây (ví dụ: in ra các giá trị)
//                    for (Object[] item : ans) {
//                        String groupStartDate = (item[0] != null) ? item[0].toString() : "N/A";
//                        double totalPrice = (item[1] != null) ? (double) item[1] : 0.0;
//                        int tValue = (item[2] != null) ? (int) item[2] : 0;
//
//                        System.out.println("GroupStartDate: " + groupStartDate + ", TotalPrice: " + totalPrice + ", T: " + tValue);
//                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void test2(){
        String dateStart = "2024-02-01";
        String dateEnd = "2024-03-31";
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.SP_GetTotalOfType(?,?)}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                callableStatement.setString(1, dateStart);
                callableStatement.setString(2, dateEnd);

                // Thực thi stored procedure
                boolean hasResults = callableStatement.execute();

                // Kiểm tra xem có result set trả về hay không
                if (hasResults) {
                    ResultSet rs = callableStatement.getResultSet();
                    Vector<Object[]> ans = new Vector<>();
                    while (rs.next()) {
                        Object[] item = new Object[3];
                        item[0] = rs.getString("TypeName");
                        item[1] = rs.getDouble("TotalPrice");
                        ans.add(item);
                        System.out.println(dateStart + " - " + dateEnd);
                        System.out.println("TypeName: " + item[0] + " TotalPrice: " + item[1]);

                    }
                    // Xử lý dữ liệu tại đây (ví dụ: in ra các giá trị)
//                    for (Object[] item : ans) {
//                        String groupStartDate = (item[0] != null) ? item[0].toString() : "N/A";
//                        double totalPrice = (item[1] != null) ? (double) item[1] : 0.0;
//                        int tValue = (item[2] != null) ? (int) item[2] : 0;
//
//                        System.out.println("GroupStartDate: " + groupStartDate + ", TotalPrice: " + totalPrice + ", T: " + tValue);
//                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

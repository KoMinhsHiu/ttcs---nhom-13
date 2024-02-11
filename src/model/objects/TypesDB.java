/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.objects;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.connection.JDBCConnection;

/**
 *
 * @author sidac
 */
public class TypesDB {
    private Vector<Vector<Object>> types = new Vector<>();
    private int indexId = 0;
    private int indexName = 1;
    
   
    public Connection getConnection(){
        JDBCConnection myJDBCFuncLib = new JDBCConnection();
        return myJDBCFuncLib.getJDBCConnection();
    }
    
    public TypesDB(){
        
    }
    
    public void setTypes(){
        this.types = getTypesV();
    }
    
    public void setTypes(Vector<Vector<Object>> types){
        this.types = types;
    }
    
    public Vector<Vector<Object>> getTypesV(){
        Vector<Vector<Object>> ans = new Vector<>();
        try (Connection connection = getConnection()) {
            // Gọi stored procedure với tham số
            String storedProcedureCall = "{call dbo.sp_GetTypeList()}";
            try (CallableStatement callableStatement = connection.prepareCall(storedProcedureCall)) {
                // Thiết lập giá trị tham số
                // Thực thi stored procedure
                callableStatement.executeQuery();
                
                ResultSet rs = callableStatement.getResultSet();
                
                while (rs.next()){
                    Vector<Object> temp = new Vector<>();
                    temp.add(rs.getInt("ID_Type"));
                    temp.add(rs.getString("Name_Type"));
                    ans.add(temp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }
    
    public String[] getTypeNames(){
        Vector<String> ans = new Vector<>();
        for (int i = 0; i< types.size(); i++){
            ans.add(types.get(i).get(indexName).toString());
        }
        return ans.toArray(new String[0]);
    }
    
    public String[] getTypeNames(String s){
        Vector<String> ans = new Vector<>();
        ans.add(s);
        for (int i = 0; i< types.size(); i++){
            ans.add(types.get(i).get(indexName).toString());
        }
        return ans.toArray(new String[0]);
    }
    public int[] getTypeIDs() {
        int[] ans = new int[types.size()];
        for (int i = 0; i < types.size(); i++) {
            ans[i] = (Integer) types.get(i).get(indexId);
        }
        return ans;
    }
    
    public String findName(int id){
        for (int i = 0; i< types.size(); i++){
            if ((Integer) types.get(i).get(indexId) == id){
                return types.get(i).get(indexName).toString();
            }
        }
        return "";
    }
    
    public int findId(String name){
        for (int i = 0; i< types.size(); i++){
            if (types.get(i).get(indexName).toString().equals(name)){
                return (Integer) types.get(i).get(indexId);
            }
        }
        return -1;
    }
}

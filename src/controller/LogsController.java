package controller;

import java.util.Vector;
import model.objects.LogO;
import model.objects.LogsDB;
import Utils.DateHelper;
import java.math.BigDecimal;

public class LogsController {
    private Vector<LogO> logs;
    
    public LogsController(){
        this.logs = new Vector<LogO>();
    }

    public LogsController(Vector<LogO> logs){
        this.logs = logs;
    }
    
    public Vector<LogO> getLogs() {
        return logs;
    }
    
    public LogO getLogAt(int index){
        return this.logs.get(index);
    }
    
    public LogO getLogByID(int id){
        for(int i = 0; i < this.logs.size(); i++){
            if (this.getLogAt(i).getID() == id){
                return this.logs.get(i);
            }
        }
        return null;
    }
    
    /**
     * thêm log và logscontroller
     * @param log 
     */
    public void addLog(LogO log){
        this.logs.add(log);
    }
    
    /**
     * Thêm log vào DB và logs
     * @param log
     * @param mode 1 để thêm vào DB
     */
    public void addLog(LogO log, int mode){
        if (mode == 1){
            LogsDB logsDB = new LogsDB();
            int a = logsDB.insertLog(log.getID_Type(), log.getPrice(), log.getNote(), log.getDateString(), 0);
            log.setID_Log(a);
        }
        else{
            this.logs.add(log);
        }
    }
    
    /**
     * Thêm log vào DB
     * @param log 
     */
    public void addLogDB(LogO log){
        LogsDB logsDB = new LogsDB();
        int a = logsDB.insertLog(log.getID_Type(), log.getPrice(), log.getNote(), log.getDateString(), 0);
        log.setID_Log(a);
    }
    
    
    public void addLogAt(LogO log, int index){
        this.logs.add(index, log);
    }
    
    public void removeLogAt(int index){
        this.logs.remove(index);
    }
    /**
     * Xóa nhiều phần tử sau index
     * @param index
     * @param mode 0 nếu muốn xóa luôn tại index, 1 nếu chỉ muốn xóa từ sau index
     */
    public void removeLogAfter(int index, int mode){
        if (index >= this.logs.size()){
            return;
        }
        if (mode == 1){
            index = index + 1;
        }
        
        for (int i = index; i< this.logs.size(); i++){
            this.logs.remove(index);
        }
    }
    
    public void removeLogByID(int id){
        for (int i = 0 ; i < this.logs.size(); i++){
            //Nếu id của logs thứ i trùng thì xóa
            if (this.logs.get(i).getID() == id){
                this.logs.remove(i);
            }
        }
    }
    
    public int getIndexInLogs(int id){
        for (int i=0 ;i < logs.size(); i++){
            if (logs.get(i).getID() == id){
                return i;
            }
        }
        return -1;
    }
    
    public int getIndexInLogs(LogO log){
        return getIndexInLogs(log.getID());
    }
    
    public void setLogs(Vector<LogO> logs){
        this.logs = logs;
    }
    
    public void printLogs(){
        System.out.println(this.logs.size());
        for (int i = 0 ;i < this.logs.size(); i++){
            System.out.println(this.logs.get(i).getNote());
        }
    }
    
    public int getSize(){
        return this.logs.size();
    }
    
    public Object[][] logDataToTable(String[] structure){
        Object[][] data = new Object[this.getSize()][structure.length];
        for(int i = 0; i < this.getSize(); i++){
            for (int j = 0; j < structure.length; j++) {
                switch (structure[j]) {
                    case "id":
                        data[i][j] = this.getLogAt(i).getID();
                        break;
                    // case "action":
                    //     data[i][j] = this.logs.getLogAt(i).getAction();
                    //     break;
                    case "date":
                        data[i][j] = this.getLogAt(i).getDateString();
                        break;
                    case "user":
                        data[i][j] = this.getLogAt(i).getID_User();
                        break;
                    case "price":
                        data[i][j] = this.getLogAt(i).getPrice();
                        break;
                    case "note":
                        data[i][j] = this.getLogAt(i).getNote();
                        break;
                    case "idOfItemInCategory":
                        data[i][j] = this.getLogAt(i).getName_Type();
                        break;
                    default:
                        break;
                }
            }
        }
        return data;
    }
    public void filter(Vector<Object[]> conditionsForFilter, Vector<Object[]> conditionsForSort){
        this.logs = new Vector<>();
        for (Object[] item : conditionsForFilter){
            if (item[0] == "date"){
                item[1] = (String)DateHelper.convertStringToSQLDate((String)item[1]);
            }
        }
        Vector<String> conditionForFilter = new Vector<String>();
        for (Object[] item : conditionsForFilter){
            if (item[0] == "date"){
                if (item[2] == "from"){
                    conditionForFilter.add("date >= " + "'" + item[1] + "'");
                }
                else if (item[2] == "to"){
                    conditionForFilter.add("date <= " + "'" + item[1] + "'");
                }
            }
            else if (item[0] == "price"){
                if (item[2] == "from"){
                    conditionForFilter.add("price >= " + "" + item[1] + "");
                }
                else if (item[2] == "to"){
                    conditionForFilter.add("price <= " + "" + item[1] + "");
                }
            }
            
            else if (item[0] == "type"){
                conditionForFilter.add("dbo.LOG.ID_Type = " + item[1]);
            }
        }
        Vector<String> conditionForSort = new Vector<String>();
        for (Object[] item : conditionsForSort){
            if (item[0] == "date"){
                if (item[1] == "ASC"){
                    conditionForSort.add("date ASC");
                }
                else if (item[1] == "DESC"){
                    conditionForSort.add("date DESC");
                }
            }
            else if (item[0] == "price"){
                if (item[1] == "ASC"){
                    conditionForSort.add("price ASC");
                }
                else if (item[1] == "DESC"){
                    conditionForSort.add("price DESC");
                }
            }
        }
        Vector<Object[]> data = new Vector<Object[]>();
        data = new LogsDB().getDataWithCondition(conditionForFilter, conditionForSort);
        for (Object[] item : data){
            this.addLog(new LogO((int)item[0], (String)item[2], (int)item[1], (BigDecimal)item[3], (String)item[4], (String)item[5]));
        }
        // Transactions transactions = new Transactions();
        // transactions.vectorToTransactions(data);
        // return transactions;

//        this.logs = logs;
    }
    
    public void updateDataRow(int id, String note, BigDecimal amount){
        for (int i = 0; i < this.getSize(); i++) {
            if(this.getLogAt(i).getID() == id){
                this.getLogAt(i).setNote(note);
                this.getLogAt(i).setPrice(amount);
                break;
            }
            
        }
    }
    
    public void updateLogWitdID(int id){
        LogsDB logsDB = new LogsDB();
//        LogO log = new LogO(this.getLogByID(id).toObject());
        logsDB.updateLog(this.getLogByID(id).toObject());

    }
    
    public void updateLog(){
        LogsDB logsDB = new LogsDB();
        logsDB.updateData(logDataToTable(new String[]{"id", "idOfItemInCategory", "price", "note"}));
    }
    
    public void setAttrAllLog(String name, Object value){
//        if (name == "isDelete"){
//            for (int i =0; i< this.getSize(); i++){
//                this.getLogAt(i).
//                
//            }
//        }
    }
    
    public BigDecimal getTotalAmountInDay(){
        BigDecimal total = new BigDecimal("0");
        for (int i = 0; i < this.getSize(); i++){
            total = total.add(this.getLogAt(i).getPrice());
        }
        return total;
    }
}



package controller;

import java.util.Vector;
import model.objects.LogO;

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
    
    public void addLog(LogO log){
        this.logs.add(log);
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
    
    public void setLogs(Vector<LogO> logs){
        this.logs = logs;
    }
}

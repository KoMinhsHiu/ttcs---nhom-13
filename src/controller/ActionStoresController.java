/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Utils.constants;
import java.util.Vector;
import model.objects.ActionStore;
import model.objects.LogO;
import model.objects.LogsDB;

/**
 *
 * @author sidac
 */
public class ActionStoresController {
    private Vector<Vector<ActionStore>> actionStore;
    private int indexOfActionStore = -1;
    
    public ActionStoresController(){
        actionStore = new Vector<>();
        
    }
    
    public ActionStoresController(Vector<Vector<ActionStore>> actionStore) {
        this.actionStore = actionStore;
    }
    
    public Vector<Vector<ActionStore>> getActionStore() {
        return actionStore;
    }
    
    public Vector<ActionStore> getCurAction(){
        return this.actionStore.get(indexOfActionStore);
    }
    
    public void setActionStore(Vector<Vector<ActionStore>> actionStore){
        this.actionStore = actionStore;
    }
    
    /**
     * Thêm actionItem vào actionStore
     * @param log
     * @param typeAction
     */
    public void addActionStore(LogO log, String typeAction, int index){
        ActionStore action = new ActionStore(log, typeAction, index);
        this.addActionStore(action);
    }

    /**
     * Thêm actionItem vào actionStore
     * @param log
     * @param typeAction
     * @param index
     */
    public void addActionStoreAt(LogO log, String typeAction, int index, int indexToAdd){
        ActionStore action = new ActionStore(log, typeAction, index);
        this.addActionStore(action);
    }
    
    public void addActionStoreAt(Vector<ActionStore> actions, int index){
        this.actionStore.add(index, actions);
    }
    
    public void addActionStoreAt(ActionStore action, int index){
        Vector<ActionStore> v = new Vector<>();
        v.add(action);
        this.addActionStoreAt(v, index);
        if (index < this.indexOfActionStore){
            this.indexOfActionStore += 1;
        }
    }
    
    public void removeActionStoreAt(int index){
        if (index >= 0 && index <= this.actionStore.size() - 1){
            this.actionStore.remove(index);
            
            if (index < this.indexOfActionStore){
                this.indexOfActionStore -= 1;
            }
        }
    }
    
    public void removeActionStoreAfterIndex(int index){
        if (index >= 0 && index <= this.actionStore.size() - 1){
            for (int i = this.actionStore.size() - 1;i > index; i--){
                this.actionStore.remove(i);
            }
            
            //Cập nhật lại index
            this.indexOfActionStore = index;
        }
        

    }
    
    public void removeActionStoreFromIndex(int index){
        if (index >= 0 && index <= this.actionStore.size() - 1){
            for (int i = this.actionStore.size() - 1;i >= index; i--){
                this.actionStore.remove(i);
            }
            
            //Cập nhật index
            this.indexOfActionStore = index - 1;
        }

    }
    /**
     * Thêm actionItem vào actionStore
     * @param actionStoreItem
     */
    public void addActionStore(ActionStore actionStoreItem){
        //Format lại input đưa qua hàm add chính
        Vector<ActionStore> data = new Vector<>();
        data.add(actionStoreItem);
        
        this.addActionStore(data);
    }
    
    public void addActionStore(Vector<ActionStore> data){
        //Nếu index lớn hơn size thì set lại về size - 1
//        if (this.indexOfActionStore > this.actionStore.size()){
//            this.indexOfActionStore = this.actionStore.size() - 1;
//        }
//        
//        //Thêm vào vị trí sau index hiện tại
//        this.indexOfActionStore += 1;
//        this.actionStore.add(indexOfActionStore, data);
        if (this.indexOfActionStore == this.actionStore.size()-1){
            this.indexOfActionStore += 1;
        }
        
        this.actionStore.add(data);
          
    }
    
    public boolean isIndexValidForTakeAction(){
        if (this.indexOfActionStore < 0 || this.indexOfActionStore > this.actionStore.size() - 1){
            return false;
        }
        return true;
    }
    
    
    public Vector<LogO> moveBack(Vector<LogO> logs){
        if (this.indexOfActionStore >= 0){
            Vector<ActionStore> action = this.getCurAction();
            this.indexOfActionStore -= 1;
            return this.deexeAction(logs, action);
        }
        return logs;
    }
    
    public Vector<LogO> moveNext(Vector<LogO> logs){
        if ((this.indexOfActionStore == -1 || this.indexOfActionStore < this.actionStore.size()-1) && this.actionStore.size() != 0){
            this.indexOfActionStore += 1;
            Vector<ActionStore> action = this.getCurAction();
            return this.executeAction(logs, action);
        }
        return logs;
    }
    
//    public Vector<LogO> tackAction(Vector<LogO> logs, Vector<ActionStore> actions, String typeOfAction){
//        if (t)
//    }
    
    public Vector<LogO> deexeAction(Vector<LogO> nLogs, Vector<ActionStore> actions){
        System.out.println("index: " + (this.indexOfActionStore + 1) + " action size: " + actions.size());
        Vector<LogO> logs = nLogs;
        LogsDB logsDB = new LogsDB();
        for (int i = 0 ;i < actions.size(); i++){
            String typeAction = actions.get(i).getTypeAction();
            if (typeAction.equals(constants.addCode)){
                logs.remove(actions.get(i));
                
                logsDB.deleteLogWithID(actions.get(i).getData().getID());
                
            }
            else if (typeAction == constants.deleteCode){
                logs.add(actions.get(i).getIndex(), actions.get(i).getData());
                logsDB.restoreLogWithID(actions.get(i).getData().getID());
                
            }
            else if (typeAction == constants.updateCode){
                for (int it = 0; it< logs.size(); it++){
                    if (logs.get(it).getID() == actions.get(0).getData().getID()){
                        System.out.println("L1: " + logs.get(i).getNote());
                        logs.set(it, actions.get(0).getData());
                        System.out.println("L2: " + logs.get(i).getNote());

                    }
                }
                
                System.out.println("Note " + actions.get(0).getData().getNote());

                logsDB.updateLog(actions.get(0).getData().toObject());
                
                
            }
        }
        return logs;
    }
    
    public Vector<LogO> executeAction(Vector<LogO> nLogs, Vector<ActionStore> actions){
        Vector<LogO> logs = nLogs;
        LogsDB logsDB = new LogsDB();
        for (int i = 0 ;i < actions.size(); i++){
            String typeAction = actions.get(i).getTypeAction();
            if (typeAction.equals(constants.addCode)){
                logs.add(actions.get(i).getIndex(), actions.get(i).getData());
                
                logsDB.restoreLogWithID(actions.get(i).getData().getID());
            }
            else if (typeAction.equals(constants.deleteCode)){
                logs.remove(actions.get(i).getData());
                
                logsDB.deleteLogWithID(actions.get(i).getData().getID());
                
            }
            else if (typeAction.equals(constants.updateCode)){
                logs.set(actions.get(1).getIndex(), actions.get(1).getData());
                
                logsDB.updateLog(actions.get(1).getData().toObject());
            }
        }
        return logs;
    }

}
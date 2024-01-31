package model.objects;

import java.math.BigDecimal;


public class LogO {
    private int ID_Log;
    private int ID_Type;
    private int ID_User;
    private BigDecimal Price;
    private String Note;
    private String DateString;

    public int getID() {
        return ID_Log;
    }
    public LogO() {
        this.ID_Log = -1;
    }
    public LogO(int ID_Type, int ID_User, BigDecimal Price, String Note, String DateString) {
        this.ID_Log = ID_Log;
        this.ID_Type = ID_Type;
        this.ID_User = ID_User;
        this.Price = Price;
        this.Note = Note;
        this.DateString = DateString;
        // this.User_ID = User_ID;
    }
    /**
     * 
     * @param ID_Log
     * @param ID_Type
     * @param ID_User
     * @param Price
     * @param Note
     * @param DateString 
     */
    public LogO(int ID_Log, int ID_Type, int ID_User, BigDecimal Price, String Note, String DateString) {
        this.ID_Log = ID_Log;
        this.ID_Type = ID_Type;
        this.ID_User = ID_User;
        this.Price = Price;
        this.Note = Note;
        this.DateString = DateString;
        // this.User_ID = User_ID;
    }
    
    public LogO(Object[] data){
        this.ID_Log = (int) data[0];
        this.ID_Type = (int) data[1];
        this.ID_User = (int) data[2];
        this.Price = (BigDecimal) data[3];
        this.Note = (String) data[4];
        this.DateString = (String) data[5];
    }
    public void setID_Log(int ID_Log) {
        this.ID_Log = ID_Log;
    }

    public int getID_Type() {
        return ID_Type;
    }


    public void setID_Type(int ID_Type) {
        this.ID_Type = ID_Type;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getDateString() {
        return DateString;
    }

    public void setDateString(String DateString) {
        this.DateString = DateString;
    }
    
    public int getID_User(){
        return this.ID_User;
    }
    
    public void setID_User(int id){
        this.ID_User = id;
    }
    
    public Object[] toObject(){
        return new Object[]{this.ID_Log, this.ID_Type, this.Price, this.Note, this.getDateString()};
    }
    public Object[] toObjectI(){
        return new Object[]{this.ID_Log, this.ID_User, this.ID_Type, this.Note, this.Price, this.getDateString()};
    }
}

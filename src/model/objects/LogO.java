package model.objects;



public class LogO {
    private int ID_Log;
    private int ID_Type;
    private double Price;
    private String Note;
    private String DateString;

    public int getID() {
        return ID_Log;
    }
    public LogO() {
        this.ID_Log = -1;
    }

    public LogO(int ID_Log, int ID_Type, double Price, String Note, String DateString) {
        this.ID_Log = ID_Log;
        this.ID_Type = ID_Type;
        this.Price = Price;
        this.Note = Note;
        this.DateString = DateString;
        // this.User_ID = User_ID;
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

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
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

}

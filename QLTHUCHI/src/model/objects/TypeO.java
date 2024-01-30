
package model.objects;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class TypeO {
    private int ID_Type;
    private int ID_User;
    private int Receipts_Or_Expenses;
    private String Name_Type;
    private String Icon_Path;
    private String Color;
    private int ID_Budget;

    public TypeO() {
        this.ID_Type = -1;
    }

    public TypeO(int ID_Type, int Receipts_Or_Expenses, String Name_Type, String Icon_Path, String Color) {
        this.ID_Type = ID_Type;
        // this.ID_User = ID_User;
        this.Receipts_Or_Expenses = Receipts_Or_Expenses;
        this.Name_Type = Name_Type;
        this.Icon_Path = Icon_Path;
        this.Color = Color;
        // this.ID_Budget = ID_Budget;
    }
    public int getID_Type() {
        return ID_Type;
    }

    public void setID_Type(int ID_Type) {
        this.ID_Type = ID_Type;
    }

    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int ID_Log) {
        this.ID_User = ID_Log;
    }

    public int isReceipts_Or_Expenses() {
        return Receipts_Or_Expenses;
    }

    public void setReceipts_Or_Expenses(int Receipts_Or_Expenses) {
        this.Receipts_Or_Expenses = Receipts_Or_Expenses;
    }

    public String getName_Type() {
        return Name_Type;
    }

    public void setName_Type(String Name_Type) {
        this.Name_Type = Name_Type;
    }

    public String getIcon_Path() {
        return Icon_Path;
    }

    public void setIcon_Path(String Icon_Path) {
        this.Icon_Path = Icon_Path;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public int getID_Budget() {
        return ID_Budget;
    }

    public void setID_Budget(int ID_Budget) {
        this.ID_Budget = ID_Budget;
    }

}

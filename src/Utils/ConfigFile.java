package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigFile {

    public static String getDB(){
        String dbName = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sidac\\OneDrive\\Documents\\NetBeansProjects\\QLTC\\src\\Utils\\config.txt"))) {
            // Đọc giá trị hằng số từ file
            String line = reader.readLine();
            while (line != null) {
                if (line.startsWith("DB=")) {
                    dbName = line.substring("DB=".length());
                    break; // DB chỉ nên xuất hiện 1 lần duy nhất
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            
            
            e.printStackTrace();
        }
        return dbName;
    }

    public static String getColName(){
        return "id,";
    }
}

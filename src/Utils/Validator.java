package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sidac
 */
public class Validator {
    public static boolean isNumeric(String str) {
        return Pattern.matches("-?\\d+(\\.\\d+)?", str);
    }
    
    
    public static boolean isDateString(String dateString) {
        System.out.println(dateString);
        boolean check = false;
        String[] formats = {"dd/MM/yyyy", "MM-dd-yyyy", "dd-MM-yyyy"}; // Các định dạng ngày có thể
        for (String format : formats) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false); // Tắt tính linh hoạt
            try {
                sdf.parse(dateString);
                check = true;
                return true; // Nếu parse thành công, ngày hợp lệ
            } catch (ParseException e) {
                // Nếu có lỗi ParseException, tiếp tục vòng lặp để kiểm tra với định dạng tiếp theo
            }
        }
        return check; // Nếu không có định dạng nào phù hợp
    }
}

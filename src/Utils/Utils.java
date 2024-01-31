/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Vector;

/**
 *
 * @author sidac
 */
public class Utils {
    public static String vectorIntToString(Vector<Integer> vec) {
        if (vec == null || vec.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (Integer value : vec) {
            result.append(value).append(",");
        }

        // Loại bỏ dấu phẩy cuối cùng nếu có
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}

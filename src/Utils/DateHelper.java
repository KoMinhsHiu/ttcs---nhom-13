package Utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateHelper {

    /**
     * Lấy ngày hiện tại và định dạng theo "dd/MM/yyyy"
     * @return String "dd/MM/yyyy"
     */
    public static String getCurrentDateFormatted() {
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();

        // Định dạng ngày theo "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter);
    }

    /**
     * Lấy ngày hiện tại và định dạng đầu ra
     * @param outputFormatString Định dạng đầu ra
     * @return String outputFormatString
     */
    public static String converDateToString(Date inputDate, String outputFormatString) {
        try {
            // Định dạng đầu ra
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputFormatString);
            return outputFormat.format(inputDate);
        } catch (Exception e) {
            // Xử lý nếu có lỗi xảy ra khi chuyển đổi
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Format lại String theo định dạng "dd/MM/yyyy", dịch chuyển theo offset và trả về 1 String
     * @param date String "dd/MM/yyyy"
     * @param type d: day, m: month, y: year
     * @param offset int
     * @return String "dd/MM/yyyy"
     */
    public static String getDateFormattedWithOffset(String date, String type, int offset){
        // Date dateF = convertStringToDate(date, "dd/MM/yyyy");
        // String currentDate = converDateToString(dateF, "dd/MM/yyyy");
        String[] test = date.split("/");
        if (test.length != 3){
            return "";
        }
        if (test[0].length() != 2){
            test[0] = "0" + test[0];
        }
        if (test[1].length() != 2){
            test[1] = "0" + test[1];
        }
        date = test[0] + "/" + test[1] + "/" + test[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate currentDate = LocalDate.parse(date, formatter);
        if (type == "d"){
            return currentDate.plusDays(offset).format(formatter);
        }
        else if (type == "m"){
            return currentDate.plusMonths(offset).format(formatter);
        }
        else if (type == "y"){
            return currentDate.plusYears(offset).format(formatter);
        }
        else{
            return "";
        }
    }

    /**
     * Chuyển string dd/MM/yyyy sang sqlDate yyyy-MM-dd
     * @param inputDate
     * @return
     */
    public static String convertToSqlDate(String inputDate) {
        try {
            // Định dạng đầu vào
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(inputDate);

            // Định dạng đầu ra
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            return outputFormat.format(date);
        } catch (ParseException e) {
            // Xử lý nếu có lỗi xảy ra khi chuyển đổi
            e.printStackTrace();
            return null;
        }
    }
    //convert ngược lại từ sqlDate sang string
    public static String convertSqlDateToString(String inputDate) {
        try {
            // Định dạng đầu vào
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(inputDate);

            // Định dạng đầu ra
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            return outputFormat.format(date);
        } catch (ParseException e) {
            // Xử lý nếu có lỗi xảy ra khi chuyển đổi
            e.printStackTrace();
            return null;
        }
    }
    // public static String convertStringToSQLDate(String input){
    //     String[] r = input.split("/");
    //     return r[2] + "-" + r[1] + "-" + r[0];
    // }
    public static String convertStringToSQLDate(String input){
        // Mảng các định dạng ngày tháng có thể xuất hiện trong chuỗi đầu vào
        String[] possibleDateFormats = {
            "yyyy-MM-dd",
            "dd-MM-yyyy",
            "dd/MM/yyyy",
            // Thêm các định dạng khác nếu cần
        };
        for (String dateFormat : possibleDateFormats) {
            String ans = "";
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            try {
                // Cố gắng phân tích (parse) chuỗi đầu vào
                Date date = sdf.parse(input);
                ans = new SimpleDateFormat("yyyy-MM-dd").format(date);
                return ans;
                // Nếu phân tích thành công, chuyển đổi về định dạng "yyyy-MM-dd"
            } catch (ParseException e) {
                // Nếu có lỗi, tiếp tục với định dạng tiếp theo
            }

        }
        System.err.println("Không thể phân tích chuỗi đầu vào thành ngày tháng.");
        return null;
    }

    //Calculate date diff between 2 dates with custom format
    public static int calDateDiffBetweenToDate(String dateStartInput, String dateEndInput, String inputFormatString){
        Date dateStart = convertStringToDate(dateStartInput, inputFormatString);
        Date dateEnd = convertStringToDate(dateEndInput, inputFormatString);
        long diff = dateEnd.getTime() - dateStart.getTime();
        return (int) (diff / (24 * 60 * 60 * 1000));
    }
    //string to date with custom format
    public static Date convertStringToDate(String inputDate, String inputFormatString) {
        try {
            // Định dạng đầu vào
            SimpleDateFormat inputFormat = new SimpleDateFormat(inputFormatString);
            Date date = inputFormat.parse(inputDate);

            // Định dạng đầu ra
            return date;
        } catch (ParseException e) {
            // Xử lý nếu có lỗi xảy ra khi chuyển đổi
            e.printStackTrace();
            return null;
        }
    }

    public static String getLastDateOfMonth(int month, int year) {
        // Chuyển đổi chuỗi tháng và năm thành số nguyên

        // Tạo một đối tượng LocalDate với ngày đầu tiên của tháng tiếp theo
        if (month == 12){
            year += 1;
            month = 1;
        }
        else{
            month += 1;
        }
        LocalDate firstDayOfNextMonth = LocalDate.of(year, month, 1);

        // Trừ một ngày để lấy ngày cuối cùng của tháng hiện tại
        LocalDate lastDayOfMonth = firstDayOfNextMonth.minusDays(1);

        // Định dạng ngày cuối cùng thành chuỗi "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = lastDayOfMonth.format(formatter);

        return formattedDate;
    }

    /**
     * Chia time range thành các khoảng
     * @param timeStart dd/mm/yyyy
     * @param timeEnd dd/mm/yyyy
     * @param interval int - số lượng range
     * @return String[][] - mảng 2 chiều chứa các khoảng thời gian
     */
    public static String[][] allocateTimeIntervals(String timeStart, String timeEnd, int interval){
        String[][] result = new String[interval][2];
        int diff = calDateDiffBetweenToDate(timeStart, timeEnd, "dd/MM/yyyy");
        if (diff - interval < 0){
            timeStart = getDateFormattedWithOffset(timeEnd, "d", diff - interval);
            diff = calDateDiffBetweenToDate(timeStart, timeEnd, "dd/MM/yyyy");
        }

        int intervalLength = diff / interval;

        for (int i = 0; i < interval; i++){
            result[i][0] = convertToSqlDate(getDateFormattedWithOffset(timeStart, "d", i * intervalLength));
            if (calDateDiffBetweenToDate(getDateFormattedWithOffset(timeStart, "d", (i + 1) * intervalLength), timeEnd, "dd/MM/yyyy") >= 0){
                result[i][1] = convertToSqlDate(getDateFormattedWithOffset(timeStart, "d", (i + 1) * intervalLength));
            }
            else{
                result[i][1] = convertToSqlDate(timeEnd);
                break;
            }
            // result[i][1] = getDateFormattedWithOffset(timeStart, "d", (i + 1) * intervalLength);
        }

        return result;
    }

    public static boolean isDateStringAvailable(String dateToCheck, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);

        try {
            sdf.parse(dateToCheck);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    public static boolean isDateStringAvailable(String dateToCheck){
        return isDateStringAvailable(dateToCheck, "dd/mm/yyyy");
    }
}

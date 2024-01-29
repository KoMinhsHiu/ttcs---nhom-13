package Utils;
import java.text.DecimalFormat;
public class MoneyChanger {
    public static String formatMoney(int amount){
        DecimalFormat decimalFormat = new DecimalFormat("#,### đ");
        return decimalFormat.format(amount);
    }
    public static int reverseFormatMoney(String formattedAmount) {
        // Loại bỏ dấu cách và 'đ' từ chuỗi định dạng
        String cleanAmount = formattedAmount.replaceAll("[^0-9]", "");

        try {
            // Chuyển chuỗi thành số nguyên
            return Integer.parseInt(cleanAmount);
        } catch (NumberFormatException e) {
            // Xử lý ngoại lệ nếu chuỗi không thể chuyển đổi thành số
            System.err.println("Không thể chuyển đổi chuỗi thành số nguyên.");
            return 0; // Hoặc giá trị mặc định khác tùy thuộc vào yêu cầu của bạn
        }
    }
    public static void main(String[] args) {
        System.out.println(reverseFormatMoney(formatMoney(1000000)));
    }
}

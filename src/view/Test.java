package view;

import Utils.EnchanceTable;
//import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import view.CalendarT;
import model.objects.LogsDB;
public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calendar Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogsDB logs = new LogsDB();

        JPanel calendar = new JPanel();

        calendar.setBackground(new java.awt.Color(51, 255, 51));
        calendar.setLayout(new java.awt.GridLayout(5, 7));

        EnchanceTable a = new EnchanceTable();
        // Tạo một JPanel để chứa JCalendar
        JPanel panel = new JPanel(new BorderLayout());
        
        // Tạo một JCalendar và thêm nó vào JPanel
        CalendarT calendars = new view.CalendarT(1);
        panel.add(calendars, BorderLayout.CENTER);
        KeyStroke ctrlXKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);// Đặt JFrame vào giữa màn hình
        panel.getInputMap().put(ctrlXKeyStroke, "ctrlX");
        panel.getActionMap().put("ctrlX", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                    // Gọi hàm tương ứng với Ctrl + N ở đây
            }
        });
        // Thêm JPanel vào JFrame
        frame.getContentPane().add(panel);

        // Cấu hình JFrame
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        System.out.println("S");

        Point p = frame.getLocation();
//        logs.test1();
//        logs.test2();
        JPanel newFrame = new JPanel();
        // JFrame newFrame = new JFrame("New Frame");
        // newFrame.setType(JFrame.Type.UTILITY);
        // newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // newFrame.setLocationRelativeTo(null);
        // newFrame.setVisible(true);
    }
}

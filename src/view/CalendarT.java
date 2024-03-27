
package view;

import Utils.DateHelper;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import model.objects.LogsDB;
import view.PanelBorder;

public class CalendarT extends javax.swing.JPanel {
    private int id_user;
    private int rowNum = 5;
    private int colNum = 7;
    public CalendarT(int id_user) {
        this.id_user = id_user;
        initComponents();
        setDefault();
    }

    private void setDefault(){
        button_next.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-next-50.png"));
        button_pre.setIcon(new ImageIcon("src\\source\\img\\Calendar\\icons8-previous-50.png"));
        Calendar c = Calendar.getInstance();
        setTextLabelDate(c);
        label_date.setHorizontalAlignment(JLabel.CENTER);

    }
    private void setTextLabelDate(Calendar c){
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int end_month = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        String date = String.valueOf(month) + "/" + String.valueOf(year) +" "
                + "(01/" + String.valueOf(month) + " - "
                +  String.valueOf(end_month) + "/" + String.valueOf(month)
                + ")";
        label_date.setText(date);
    }
    
    private Calendar getMonthYear(){
        String[] date = (String.valueOf(label_date.getText()).split(" "))[0].split("/");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, Integer.parseInt(date[0])-1);
        c.set(Calendar.YEAR, Integer.parseInt(date[1]));    
        return c;
    }
    
    private Calendar getPreviousMonth() {
        
        if (calendar.get(Calendar.MONTH) == Calendar.JANUARY) {
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
        } else {
            calendar.roll(Calendar.MONTH, false);
        }

        return calendar;
    }
    private Calendar getNextMonth() {

        if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER) {
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
        } else {
            calendar.roll(Calendar.MONTH, true);
        }

        return calendar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        button_pre = new javax.swing.JButton();
        button_next = new javax.swing.JButton();
        dateChooseBtn = new javax.swing.JButton();
        label_date = new javax.swing.JTextField();
        calendarWrapper = new view.PanelBorder();
        calendarShowPanel = new javax.swing.JPanel();
        calendarItem = new javax.swing.JPanel();
        dateItemLabel = new javax.swing.JLabel();
        incomeValueLabel = new javax.swing.JLabel();
        spentValueLabel = new javax.swing.JLabel();
        totalValueLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        calendar = Calendar.getInstance();
        startDate = new javax.swing.JTextField();
        endDate = new javax.swing.JTextField();
        setPreferredSize(new java.awt.Dimension(637, 604));
        setLayout(null);
        PanelBorder dateWrapper = new PanelBorder();
        button_pre.setBackground(new java.awt.Color(153, 153, 153));
        button_pre.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
//        button_pre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/img/Calendar/icons8-previous-50.png"))); // NOI18N
        button_pre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button_pre.setBorder(null);
        button_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_preActionPerformed(evt);
            }
        });
        add(button_pre);
        button_pre.setBounds(140, 10, 20, 20);

        button_next.setBackground(new java.awt.Color(153, 153, 153));
        button_next.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
//        button_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/img/Calendar/icons8-next-50.png"))); // NOI18N
        button_next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        button_next.setBorder(null);
        button_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_nextActionPerformed(evt);
            }
        });
        add(button_next);
        button_next.setBounds(410, 10, 20, 20);

        dateChooseBtn.setBackground(new java.awt.Color(153, 153, 153));
        dateChooseBtn.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
//        dateChooseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/img/Calendar/icons8-next-50.png"))); // NOI18N
        dateChooseBtn.setBorder(null);
        dateChooseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChooseBtnActionPerformed(evt);
            }
        });
        add(dateChooseBtn);
        dateChooseBtn.setBounds(380, 10, 20, 20);

        label_date.setText("jTextField1");
        label_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                label_dateActionPerformed(evt);
            }
        });
        add(label_date);
        label_date.setBounds(210, 10, 150, 30);

        calendarWrapper.setBackground(new java.awt.Color(153, 153, 255));
        calendarWrapper.setLayout(null);

        calendarShowPanel.setBackground(new java.awt.Color(255, 255, 255));
        calendarShowPanel.setLayout(new java.awt.GridLayout(rowNum, colNum));

        calendarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calendarItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calendarItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calendarItemMouseExited(evt);
            }
        });
        //set giá trị hiển thị cho ngày bắt đầu và kết thúc
        this.startDate.setText(this.getStartDate());
        this.endDate.setText(this.getEndDate());
        
        //Số ngày giữa start-end
        int dateDiff = DateHelper.calDateDiffBetweenToDate(this.getStartDate(), this.getEndDate(), "yyyy-mm-dd") + 1;
        data = logs.getDataDays(this.startDate.getText(), this.endDate.getText(),1);
        
        totalValueLabel.setBounds(30, 60, 34, 14);
        
        this.fitCol();

        for (int i = 0; i< dateDiff; i++){
            JPanel calendarItem1 = new JPanel();
            calendarItem1.setLayout(null);

            //Set value cho ngày của 1 item
            JLabel dateItemLabel = new JLabel(((String)data[i][indexDate]));
            dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
            calendarItem1.add(dateItemLabel);
            dateItemLabel.setBounds(0, 0, 60, 20);
            //Gán màu
            if ((double)data[i][indexIncome] - (double)data[i][indexSpent] < 0.0){
                dateItemLabel.setForeground(Color.RED);
            }
            else if ((double)data[i][indexIncome] - (double)data[i][indexSpent] > 0.0){
                dateItemLabel.setForeground(Color.GREEN);
            }
    //
            JLabel incomeValueLabel = new JLabel(data[i][1].toString());
            incomeValueLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
            calendarItem1.add(incomeValueLabel);
            incomeValueLabel.setBounds(30, 20, 34, 14);

            JLabel spentValueLabel = new JLabel(data[i][1].toString());
            spentValueLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
            calendarItem1.add(spentValueLabel);
            spentValueLabel.setBounds(30, 40, 34, 14);
            calendarItem1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    createFrame(evt.getX(), evt.getY());
                }
    //            @Override
    //            public void mouseClicked(MouseEvent e) {
    //                createFrame(e.getX(), e.getY());
    //            }
    //        });
    //            }
    //        }
            public void mouseEntered(java.awt.event.MouseEvent e) {
                calendarItem1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 15));
    //            calendarItem1.setBackground(Color.LIGHT_GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                calendarItem1.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
            }
            });
        
            calendarShowPanel.add(calendarItem1);
        }
        
        calendarWrapper.add(calendarShowPanel);
        calendarShowPanel.setBounds(10, 10, 560, 270);

        add(calendarWrapper);
        calendarWrapper.setBounds(10, 60, 580, 290);
    }// </editor-fold>                        
    
    private JPanel drawTable(Object[][] data){
        this.fitCol();
        
        for (int i = 0; i <= DateHelper.calDateDiffBetweenToDate(this.startDate.getText(), this.endDate.getText(), "yyyy-mm-dd"); i++){
            JPanel calendarItem1 = new JPanel();
            calendarItem1.setLayout(null);
            JLabel dateItemLabel = new JLabel(((String)data[i][indexDate]));
            dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
            calendarItem1.add(dateItemLabel);
            dateItemLabel.setBounds(0, 0, 60, 20);
            if ((double)data[i][indexIncome] - (double)data[i][indexSpent] < 0.0){
                dateItemLabel.setForeground(Color.RED);
            }
            else if ((double)data[i][indexIncome] - (double)data[i][indexSpent] > 0.0){
                dateItemLabel.setForeground(Color.GREEN);
            }
    //
            JLabel incomeValueLabel = new JLabel(data[i][1].toString());
            incomeValueLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
            calendarItem1.add(incomeValueLabel);
            incomeValueLabel.setBounds(30, 20, 34, 14);
            
            JLabel spentValueLabel = new JLabel(data[i][2].toString());
            spentValueLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
            calendarItem1.add(spentValueLabel);
            spentValueLabel.setBounds(30, 40, 34, 14);
            int borderWidth = 1;
            calendarItem1.setBackground(UIManager.getColor("Panel.background"));
            Point frameLocation = calendarShowPanel.getLocation();
            
            
            int startX = (int) frameLocation.getX();
            int startY = (int) frameLocation.getY();
            calendarItem1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (testFrame != null){
                        testFrame.dispose();
                    }
                    createFrame(evt.getX() + startX, evt.getY()+ startY);
//                    view.render.renders render = new view.render.renders();
//                    render.renderTransactionTableWithFrame(data);
                }
    //            @Override
    //            public void mouseClicked(MouseEvent e) {
    //                createFrame(e.getX(), e.getY());
    //            }
    //        });
    //            }
    //        }
            public void mouseEntered(java.awt.event.MouseEvent e) {
                calendarItem1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 15));
    //            calendarItem1.setBackground(Color.LIGHT_GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                calendarItem1.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                dateItemLabel.setFont(new java.awt.Font("Times New Roman", 0, 12));
            }
            });
            calendarItem1.setBackground(new java.awt.Color(255,255,255));

            calendarShowPanel.add(calendarItem1);
        }
        
        return calendarShowPanel;
    }
    private void button_preActionPerformed(java.awt.event.ActionEvent evt) {                                           
        setTextLabelDate(getPreviousMonth());
        
        updateDates();
        
        repaintCalendar();
    }                                          

    private void button_nextActionPerformed(java.awt.event.ActionEvent evt) {                                            
        setTextLabelDate(getNextMonth());

        updateDates();
        
        repaintCalendar();
    }                                           

    private void dateChooseBtnActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void label_dateActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void calendarItemMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
        

    }                                         
    private static void createFrame(int mouseX,int mouseY) {
        
        if (testFrame != null){
            testFrame.dispose();

        }
        testFrame = new JFrame("Mouse Clicked Frame");
        testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        testFrame.setUndecorated(true);
        System.out.println(mouseX);
        int frameWidth = 200;
        int frameHeight = 150;
        Vector<String> headerName = new Vector<>();
        headerName.add("Thu");
        headerName.add("Chi");
        headerName.add("Tổng");
        Object[][] datas = new Object[][]{
            {1, 3, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        component.enhanceTable render = new component.enhanceTable();
        JTable eTable = render.renderTransactionTableWithFrame(headerName, datas);
        testFrame.add(new JScrollPane(eTable));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        int mouseX1 = (int) mouseLocation.getX();
        int mouseY1 = (int) mouseLocation.getY();
        int frameX = mouseX1;
        int frameY = mouseY1;
        if (frameX + frameWidth > screenSize.width) {
            frameX = screenSize.width - frameWidth;
        }

        if (frameY + frameHeight > screenSize.height) {
            frameY = screenSize.height - frameHeight;
        }

        testFrame.setBounds(frameX, frameY, frameWidth, frameHeight);
        testFrame.setVisible(true);
    }

    private void calendarItemMouseEntered(java.awt.event.MouseEvent evt) {                                          
        java.awt.Color borderColor = java.awt.Color.RED;
        int borderWidth = 2;
        this.setBorder(new javax.swing.border.LineBorder(borderColor, borderWidth));
    }                                         

    private void calendarItemMouseExited(java.awt.event.MouseEvent evt) {                                         
        this.setBorder(null);
    }             
    
    private String getStartDate(){
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int end_month = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String startdate = String.valueOf(year) + "-"+String.valueOf(month) + "-01";        
        return startdate;
    }

    private String getEndDate(){
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int end_month = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String endDate = String.valueOf(year) + "-"+String.valueOf(month) + "-" +String.valueOf(end_month);    
        return endDate;
    }
    
    private void updateDates(){
        String startdate = this.getStartDate();
        String enddate = this.getEndDate();
        
        this.fitCol();

        this.startDate.setText(startdate);
        this.endDate.setText(enddate);
    }
    
    private void repaintCalendar(){
        this.data = logs.getDataDays(startDate.getText(), endDate.getText(), 1);
        calendarWrapper.removeAll();
        calendarShowPanel.removeAll();
        calendarWrapper.add(drawTable(data));
        calendarWrapper.validate(); //Cần dòng này để repaint hoạt động ngay
        calendarWrapper.repaint();
    }
    
    //Thay đổi giá trị colNum để vừa
    private void fitCol(){
        String startdate = this.getStartDate();
        String enddate = this.getEndDate();
        if (DateHelper.calDateDiffBetweenToDate(startdate, enddate, "yyyy-MM-dd") > rowNum*colNum){
            colNum += 1;
        }
        else if (DateHelper.calDateDiffBetweenToDate(startdate, enddate, "yyyy-MM-dd") <= rowNum*(colNum-1)){
            colNum -= 1;
        }
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton button_next;
    private javax.swing.JButton button_pre;
    private javax.swing.JPanel calendarItem;
    private javax.swing.JPanel calendarShowPanel;
    private view.PanelBorder calendarWrapper;
    private javax.swing.JButton dateChooseBtn;
    private javax.swing.JLabel dateItemLabel;
    private javax.swing.JLabel incomeValueLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField label_date;
    private javax.swing.JTextField startDate;
    private javax.swing.JTextField endDate;
    private javax.swing.JLabel spentValueLabel;
    private javax.swing.JLabel totalValueLabel;
    LogsDB logs = new LogsDB();
    private Object[][] data;
    private int indexDate = 0;
    private int indexIncome = 1;
    private int indexSpent = 2;
    private static JFrame testFrame;
    private Calendar calendar;
    // End of variables declaration                   


}

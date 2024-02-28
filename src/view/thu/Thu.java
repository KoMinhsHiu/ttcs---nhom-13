package view.thu;



import controller.DanhMucThu;

import controller.TypeController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import model.objects.TypeO;

import view.danhmuc.ThuJPanel;

/**
 *
 * @author LENOVO
 */
public class Thu extends javax.swing.JFrame {

    TypeController typeController;
    
    public Thu() {
        initComponents();
        
        
        setPanelDanhMuc();
        
    }
    
    
  
    
    
    private void setPanelDanhMuc(){
        
        JButton buttonChinhsua1 = button_chinhsua1;
        
        typeController = new TypeController();
        List<TypeO> types = typeController.getAllTypeExpenses();
        int length = types.size();
        int rows = (int)length/3 + 1;
        panel_danhmuc.setLayout(new GridLayout(rows,3));
        
        for(TypeO type:types){
            ImageIcon icon;
            JToggleButton toggleButton;
            if(!(type.getIcon_Path() == null)){
                icon = new ImageIcon(type.getIcon_Path());
                toggleButton = new JToggleButton(type.getName_Type(), icon);
            }
            else{
                toggleButton = new JToggleButton(type.getName_Type());
            }
            
            toggleButton.setFont(new Font("Times New Roman",Font.PLAIN, 16));
            toggleButton.setActionCommand(String.valueOf(type.getID_Type()));
            toggleButton.setForeground(new Color(333333));
            
            toggleButton.setBackground(new Color(255, 230, 230));
            toggleButton.setMaximumSize(new java.awt.Dimension(50, 50));
            toggleButton.setMinimumSize(new java.awt.Dimension(10, 10));
            toggleButton.setPreferredSize(new Dimension(50,50));
            panel_danhmuc.add(toggleButton);
            buttonGroup1.add(toggleButton);
            
        }
        panel_danhmuc.add(buttonChinhsua1);
        buttonGroup1.add(buttonChinhsua1);
    }
    
    

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dialog_dsThu = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        detailsLogFrame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        timeType = new javax.swing.JComboBox<>();
        transactionScrollPane = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        totalOfTypeInDay = new javax.swing.JLabel();
        totalInDayValue = new javax.swing.JLabel();
        deleteAllBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        curDate = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        panel_title = new javax.swing.JPanel();
        nextActionBtn = new javax.swing.JButton();
        backActionBtn = new javax.swing.JButton();
        beforeDateBtn = new javax.swing.JButton();
        nextDateBtn = new javax.swing.JButton();
        label_title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        text_ghichu = new javax.swing.JTextField();
        text_tienthu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        button_save = new javax.swing.JButton();
        button_calculator = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_danhmuc = new javax.swing.JPanel();
        button_chinhsua1 = new javax.swing.JButton();
        button_danh_sach_thu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        dialog_dsThu.setModal(true);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Xóa");

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Tất cả");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(jButton2))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout dialog_dsThuLayout = new javax.swing.GroupLayout(dialog_dsThu.getContentPane());
        dialog_dsThu.getContentPane().setLayout(dialog_dsThuLayout);
        dialog_dsThuLayout.setHorizontalGroup(
            dialog_dsThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        dialog_dsThuLayout.setVerticalGroup(
            dialog_dsThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialog_dsThuLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(745, 400));

        timeType.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        timeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng" }));
        timeType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeTypeActionPerformed(evt);
            }
        });

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mục", "Số tiền", "Ghi chú", "Thời gian", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transactionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionTableMouseClicked(evt);
            }
        });
        transactionScrollPane.setViewportView(transactionTable);

        totalOfTypeInDay.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totalOfTypeInDay.setText("Tổng:");

        totalInDayValue.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        totalInDayValue.setText("0");

        deleteAllBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deleteAllBtn.setText("Xóa");
        deleteAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Lọc theo:");

        jPanel4.setBackground(new java.awt.Color(0, 255, 204));

        curDate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        curDate.setText("Date");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(curDate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(curDate))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        panel_title.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_titleLayout = new javax.swing.GroupLayout(panel_title);
        panel_title.setLayout(panel_titleLayout);
        panel_titleLayout.setHorizontalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        panel_titleLayout.setVerticalGroup(
            panel_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        nextActionBtn.setBorder(null);
        nextActionBtn.setMaximumSize(new java.awt.Dimension(24, 24));
        nextActionBtn.setMinimumSize(new java.awt.Dimension(24, 24));
        nextActionBtn.setPreferredSize(new java.awt.Dimension(24, 24));
        nextActionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionBtnActionPerformed(evt);
            }
        });

        backActionBtn.setBorder(null);
        backActionBtn.setMaximumSize(new java.awt.Dimension(24, 24));
        backActionBtn.setMinimumSize(new java.awt.Dimension(24, 24));
        backActionBtn.setPreferredSize(new java.awt.Dimension(24, 24));
        backActionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionBtnActionPerformed(evt);
            }
        });

        beforeDateBtn.setBorder(null);
        beforeDateBtn.setPreferredSize(new java.awt.Dimension(24, 24));
        beforeDateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beforeDateBtnActionPerformed(evt);
            }
        });

        nextDateBtn.setBorder(null);
        nextDateBtn.setMinimumSize(new java.awt.Dimension(24, 24));
        nextDateBtn.setPreferredSize(new java.awt.Dimension(24, 24));
        nextDateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextDateBtnActionPerformed(evt);
            }
        });

        label_title.setBackground(new java.awt.Color(255, 255, 255));
        label_title.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        label_title.setForeground(new java.awt.Color(0, 255, 255));
        label_title.setText("Danh Sách Thu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 807, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(backActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nextActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(759, 759, 759)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(335, 335, 335)
                                        .addComponent(beforeDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(timeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nextDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(totalOfTypeInDay)
                                .addGap(47, 47, 47)
                                .addComponent(totalInDayValue))
                            .addComponent(deleteAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transactionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteAllBtn)
                            .addComponent(beforeDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextDateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(timeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nextActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backActionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transactionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalInDayValue)
                    .addComponent(totalOfTypeInDay))
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout detailsLogFrameLayout = new javax.swing.GroupLayout(detailsLogFrame.getContentPane());
        detailsLogFrame.getContentPane().setLayout(detailsLogFrameLayout);
        detailsLogFrameLayout.setHorizontalGroup(
            detailsLogFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsLogFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1461, Short.MAX_VALUE))
        );
        detailsLogFrameLayout.setVerticalGroup(
            detailsLogFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsLogFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Ngày");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Ghi chú");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Tiền thu");

        jDateChooser1.setBackground(new java.awt.Color(245, 177, 109));
        jDateChooser1.setForeground(new java.awt.Color(255, 0, 0));
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Danh mục");

        text_ghichu.setBackground(new java.awt.Color(245, 177, 109));
        text_ghichu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        text_ghichu.setForeground(new java.awt.Color(102, 102, 102));
        text_ghichu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_ghichuActionPerformed(evt);
            }
        });

        text_tienthu.setBackground(new java.awt.Color(245, 177, 109));
        text_tienthu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        text_tienthu.setForeground(new java.awt.Color(51, 51, 51));
        text_tienthu.setText("0");
        text_tienthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_tienthuActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("đ");

        button_save.setBackground(new java.awt.Color(242, 242, 242));
        button_save.setForeground(new java.awt.Color(255, 102, 0));
        button_save.setBorder(null);
        button_save.setPreferredSize(new java.awt.Dimension(64, 64));
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        button_calculator.setBackground(new java.awt.Color(242, 242, 242));
        button_calculator.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        button_calculator.setBorder(null);
        button_calculator.setMaximumSize(new java.awt.Dimension(64, 64));
        button_calculator.setMinimumSize(new java.awt.Dimension(64, 64));
        button_calculator.setPreferredSize(new java.awt.Dimension(64, 64));
        button_calculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_calculatorActionPerformed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(625, 111));

        button_chinhsua1.setBackground(new java.awt.Color(242, 86, 29));
        button_chinhsua1.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        button_chinhsua1.setForeground(new java.awt.Color(255, 255, 255));
        button_chinhsua1.setText("Chỉnh sửa danh mục");
        button_chinhsua1.setBorder(null);
        button_chinhsua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_chinhsua1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_danhmucLayout = new javax.swing.GroupLayout(panel_danhmuc);
        panel_danhmuc.setLayout(panel_danhmucLayout);
        panel_danhmucLayout.setHorizontalGroup(
            panel_danhmucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button_chinhsua1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panel_danhmucLayout.setVerticalGroup(
            panel_danhmucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_danhmucLayout.createSequentialGroup()
                .addComponent(button_chinhsua1)
                .addGap(0, 232, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(panel_danhmuc);

        button_danh_sach_thu.setBackground(new java.awt.Color(51, 255, 255));
        button_danh_sach_thu.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        button_danh_sach_thu.setForeground(new java.awt.Color(255, 255, 255));
        button_danh_sach_thu.setText("Danh sách thu");
        button_danh_sach_thu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_danh_sach_thuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Script", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Thu");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(text_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button_danh_sach_thu)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(text_tienthu, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(button_calculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(1, 1, 1))
                            .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(text_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(text_tienthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(button_calculator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(button_danh_sach_thu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_chinhsua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_chinhsua1ActionPerformed

        ThuJPanel thuJPanel = new ThuJPanel();
        JFrame newFrame = new JFrame("Chỉnh sửa");
        newFrame.getContentPane().add(thuJPanel);
        newFrame.setSize(330, 150);
        newFrame.setLocationRelativeTo(null);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Gọi phương thức để xử lý lại request hoặc làm mới trang
                DanhMucThu.updateDanhMucThuPanel(panel_danhmuc, buttonGroup1, button_chinhsua1);
            }
        });
        newFrame.setVisible(true);
    }//GEN-LAST:event_button_chinhsua1ActionPerformed

    private void text_ghichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_ghichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_ghichuActionPerformed

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
     
    }//GEN-LAST:event_button_saveActionPerformed

    private void button_calculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_calculatorActionPerformed
    
    }//GEN-LAST:event_button_calculatorActionPerformed

    private void button_danh_sach_thuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_danh_sach_thuActionPerformed

    }//GEN-LAST:event_button_danh_sach_thuActionPerformed

    private void timeTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeTypeActionPerformed
       
    }//GEN-LAST:event_timeTypeActionPerformed

    private void nextDateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextDateBtnActionPerformed
       
    }//GEN-LAST:event_nextDateBtnActionPerformed

    private void beforeDateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beforeDateBtnActionPerformed
      
    }//GEN-LAST:event_beforeDateBtnActionPerformed

    private void backActionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionBtnActionPerformed
        
     
        
    }//GEN-LAST:event_backActionBtnActionPerformed

    private void nextActionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionBtnActionPerformed

      
        
    }//GEN-LAST:event_nextActionBtnActionPerformed

    private void transactionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionTableMouseClicked
      
    }//GEN-LAST:event_transactionTableMouseClicked

    private void deleteAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllBtnActionPerformed
                //lap hang
     
    
        
    }//GEN-LAST:event_deleteAllBtnActionPerformed

    private void text_tienthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_tienthuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_tienthuActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Thu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backActionBtn;
    private javax.swing.JButton beforeDateBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton button_calculator;
    private javax.swing.JButton button_chinhsua1;
    private javax.swing.JButton button_danh_sach_thu;
    private javax.swing.JButton button_save;
    private javax.swing.JLabel curDate;
    private javax.swing.JButton deleteAllBtn;
    private javax.swing.JFrame detailsLogFrame;
    private javax.swing.JDialog dialog_dsThu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_title;
    private javax.swing.JButton nextActionBtn;
    private javax.swing.JButton nextDateBtn;
    private javax.swing.JPanel panel_danhmuc;
    private javax.swing.JPanel panel_title;
    private javax.swing.JTextField text_ghichu;
    private javax.swing.JTextField text_tienthu;
    private javax.swing.JComboBox<String> timeType;
    private javax.swing.JLabel totalInDayValue;
    private javax.swing.JLabel totalOfTypeInDay;
    private javax.swing.JScrollPane transactionScrollPane;
    private javax.swing.JTable transactionTable;
    // End of variables declaration//GEN-END:variables
   


}

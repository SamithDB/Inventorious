package interfaces;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashith
 */
public class allAttendance extends javax.swing.JFrame {

    Vector<String> v = new Stack<String>();
    JTextField tx;
    private boolean hide_flag = false;
    String keyword;

    public allAttendance() {
        initComponents();
//        new pay_loan().setToCombo(cmb_empid, "SELECT empid FROM rate");
        autoSuggest();
    }

    public void autoSuggest() {
        try {
            Class.forName("com.mysql.jdbc.Connection");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/build_final", "root", "1234");
            ResultSet r = con.createStatement().executeQuery("SELECT DISTINCt empid FROM attendance");

            cmb_empid.removeAllItems();
            r.first();
            if (cmb_empid.getItemCount() == 0) {
                do {
                    cmb_empid.addItem(r.getString("empid"));
                    v.addElement(r.getString("empid"));
                    cmb_empid.addItemListener(new ItemListener() {

                        @Override
                        public void itemStateChanged(ItemEvent ie) {
                            if (ie.getStateChange() == ItemEvent.SELECTED) {
                                cmb_empid.getSelectedIndex();
                            }
                        }
                    });

                } while (r.next());
            } else {
                cmb_empid.addItem("No Match Found");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        cmb_empid.setEditable(true);
        tx = (JTextField) cmb_empid.getEditor().getEditorComponent();
        tx.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String text = tx.getText().toUpperCase();
                        if (text.length() == 0) {
                            cmb_empid.hidePopup();
                            setModel(new DefaultComboBoxModel(v), "");
                        } else {
                            DefaultComboBoxModel m = getSuggest(v, text);
                            if (m.getSize() == 0) {
                                cmb_empid.hidePopup();
                            } else {
                                setModel(m, text);
                                cmb_empid.showPopup();
                            }
                        }
                    }
                });

            }

            @Override
            public void keyPressed(KeyEvent e) {
                String text = tx.getText();
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_ENTER) {
                    if (v.contains(text)) {
                        // v.addElement(text);
                        cmb_empid.setSelectedItem(text);
                        cmb_empid.hidePopup();
                    }
                    hide_flag = true;
                } else if (code == KeyEvent.VK_ESCAPE) {
                    hide_flag = true;
                } else if (code == KeyEvent.VK_RIGHT) {
                    for (int i = 0; i < v.size(); i++) {
                        String str = (String) v.elementAt(i);
                        if (str.startsWith(text)) {
                            tx.setText(str);
                        }
                    }
                }
            }
        });
    }

    private void setModel(DefaultComboBoxModel mdl, String str) {
        cmb_empid.setModel(mdl);
        tx.setText(str);
    }

    private DefaultComboBoxModel getSuggest(List<String> list, String text) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for (String s : list) {
            if (s.startsWith(text)) {
                m.addElement(s);
            }
        }
        return m;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmb_empid = new javax.swing.JComboBox();
        mnc_month = new com.toedter.calendar.JMonthChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pay = new javax.swing.JTable();
        ych_year = new com.toedter.calendar.JYearChooser();
        lbl_close = new javax.swing.JLabel();
        chk_year = new javax.swing.JCheckBox();
        chk_month = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        btn_half = new javax.swing.JButton();
        btn_ot = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1311, 690));

        cmb_empid.setEditable(true);
        cmb_empid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_empid.setOpaque(false);
        cmb_empid.setPreferredSize(new java.awt.Dimension(32, 28));
        cmb_empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_empidActionPerformed(evt);
            }
        });

        mnc_month.setEnabled(false);
        mnc_month.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnc_month.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnc_monthMouseClicked(evt);
            }
        });
        mnc_month.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                mnc_monthAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Emp ID");
        jLabel1.setPreferredSize(new java.awt.Dimension(54, 28));

        tbl_pay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_pay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp ID", "Name", "Attendance", "Short Leaves", "Over Time", "Month", "Year"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_pay.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tbl_pay.getTableHeader().setResizingAllowed(false);
        tbl_pay.getTableHeader().setReorderingAllowed(false);
        tbl_pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_payMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_pay);
        if (tbl_pay.getColumnModel().getColumnCount() > 0) {
            tbl_pay.getColumnModel().getColumn(0).setResizable(false);
            tbl_pay.getColumnModel().getColumn(1).setResizable(false);
            tbl_pay.getColumnModel().getColumn(2).setResizable(false);
            tbl_pay.getColumnModel().getColumn(3).setResizable(false);
            tbl_pay.getColumnModel().getColumn(4).setResizable(false);
            tbl_pay.getColumnModel().getColumn(5).setResizable(false);
            tbl_pay.getColumnModel().getColumn(6).setResizable(false);
        }

        ych_year.setEnabled(false);
        ych_year.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ych_yearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ych_yearMouseEntered(evt);
            }
        });

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/close_window-26.png"))); // NOI18N
        lbl_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_closeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_closeMouseReleased(evt);
            }
        });

        chk_year.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chk_year.setText("Year");
        chk_year.setPreferredSize(new java.awt.Dimension(57, 28));
        chk_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_yearActionPerformed(evt);
            }
        });

        chk_month.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chk_month.setText("Month");
        chk_month.setPreferredSize(new java.awt.Dimension(69, 28));
        chk_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_monthActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        jLabel2.setText("View Attendance");

        btn_half.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_half.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/calendar-32.png"))); // NOI18N
        btn_half.setText("View Hafl Day");
        btn_half.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_halfActionPerformed(evt);
            }
        });

        btn_ot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_ot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/alarm_clock-32.png"))); // NOI18N
        btn_ot.setText("View Over Time");
        btn_ot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_otActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(chk_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(ych_year, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(chk_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(mnc_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmb_empid, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(lbl_close)
                        .addGap(10, 10, 10))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(btn_half)
                .addGap(27, 27, 27)
                .addComponent(btn_ot)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_close)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mnc_month, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_month, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ych_year, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ot, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_half, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 874, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked

        dispose();
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void lbl_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseEntered

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/close_window-32.png")));
    }//GEN-LAST:event_lbl_closeMouseEntered

    private void lbl_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseExited

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/close_window-26.png")));
    }//GEN-LAST:event_lbl_closeMouseExited

    private void mnc_monthAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_mnc_monthAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_mnc_monthAncestorAdded

    private void cmb_empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_empidActionPerformed

        if (!cmb_empid.getSelectedItem().equals("Select")) {
            if (chk_year.isSelected()) {
                keyword = "AND year='" + ych_year.getYear() + "'";
                if (chk_month.isSelected()) {
                    keyword = "AND year='" + ych_year.getYear() + "' AND month='" + new pay_pay().mchMonth(mnc_month) + "' ";
                }
            } else {
                keyword = "";
            }

            searchRecordAll(keyword);
        }
    }//GEN-LAST:event_cmb_empidActionPerformed

    private void chk_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_yearActionPerformed

        cmb_empid.setSelectedItem("Select");
        if (chk_year.isSelected()) {
            if (!chk_month.isSelected()) {
                
            }
            ych_year.setEnabled(true);
        } else {
            if (!chk_month.isSelected()) {
                
            }
            ych_year.setEnabled(false);
        }
    }//GEN-LAST:event_chk_yearActionPerformed

    private void chk_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_monthActionPerformed

        cmb_empid.setSelectedItem("Select");
        if (chk_month.isSelected()) {
            if (!chk_year.isSelected()) {
                
            }
            mnc_month.setEnabled(true);
        } else {
            if (!chk_year.isSelected()) {
               
            }
            mnc_month.setEnabled(false);
        }
    }//GEN-LAST:event_chk_monthActionPerformed

    private void ych_yearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ych_yearMouseClicked

        cmb_empid.setSelectedItem("Select");
    }//GEN-LAST:event_ych_yearMouseClicked

    private void mnc_monthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnc_monthMouseClicked

        cmb_empid.setSelectedItem("Select");
    }//GEN-LAST:event_mnc_monthMouseClicked

    private void ych_yearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ych_yearMouseEntered

    }//GEN-LAST:event_ych_yearMouseEntered

    private void lbl_closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseReleased


    }//GEN-LAST:event_lbl_closeMouseReleased

    private void tbl_payMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_payMouseReleased

    }//GEN-LAST:event_tbl_payMouseReleased

    private void btn_halfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_halfActionPerformed

        if (!cmb_empid.getSelectedItem().equals("Select")) {
            new viewTable("half", (String) cmb_empid.getSelectedItem()).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Please Select An EMP ID", "Attendance", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_halfActionPerformed

    private void btn_otActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_otActionPerformed

        if (!cmb_empid.getSelectedItem().equals("Select")) {
            new viewTable("ot", (String) cmb_empid.getSelectedItem()).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Please Select An EMP ID", "Attendance", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_otActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(allAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(allAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(allAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(allAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new allAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_half;
    private javax.swing.JButton btn_ot;
    private javax.swing.JCheckBox chk_month;
    private javax.swing.JCheckBox chk_year;
    private javax.swing.JComboBox cmb_empid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_close;
    private com.toedter.calendar.JMonthChooser mnc_month;
    private javax.swing.JTable tbl_pay;
    private com.toedter.calendar.JYearChooser ych_year;
    // End of variables declaration//GEN-END:variables

    void searchResult() {
        if (tbl_pay.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No Record Found");
            cmb_empid.setSelectedItem("Select");
        }
    }

    private void searchRecordAll(String Search) {
        DefaultTableModel model = (DefaultTableModel) tbl_pay.getModel();
        try {
            ResultSet r = new JDBC().getData("SELECT month,year,empid,COUNT(date) AS att,(SELECT insname FROM employee WHERE empid='" + cmb_empid.getSelectedItem() + "') AS name,"
                    + "(SELECT COUNT(date) FROM half WHERE empid='" + cmb_empid.getSelectedItem() + "'" + Search + ") AS short,"
                    + "(SELECT SUM(hour) FROM ot WHERE empid='" + cmb_empid.getSelectedItem() + "'" + Search + ") AS over FROM attendance WHERE empid='" + cmb_empid.getSelectedItem() + "' ");
            new Add_customer().removeAllRow(tbl_pay);

            while (r.next()) {
                Vector v = new Vector();
                v.add(r.getString("empid"));
                v.add(r.getString("name"));
                v.add(r.getString("att"));
                v.add(r.getString("short"));
                v.add(hour(r.getInt("over")));
                v.add(r.getString("month"));
                v.add(r.getString("year"));

                model.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String hour(int i) {
        int a = i / 60;
        int b = i % 60;
        String s = String.valueOf(a) + "." + String.valueOf(b);
        return s;

    }
    

}

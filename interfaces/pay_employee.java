package interfaces;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashith
 */
public class pay_employee extends javax.swing.JInternalFrame {

    public pay_employee() {
        super("Employee Pay", true, true, true, true);
        initComponents();
    }
    Calendar cal = Calendar.getInstance();
    int month = cal.get(Calendar.MONTH);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_payemp = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_payemp_empid = new javax.swing.JTextField();
        txt_payemp_fname = new javax.swing.JTextField();
        txt_payemp_lname = new javax.swing.JTextField();
        txt_payemp_desgnation = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_payemp_amount = new javax.swing.JTextField();
        txt_payemp_pdate = new javax.swing.JTextField();
        btn_payemp_loan = new javax.swing.JButton();
        txt_payemp_search = new javax.swing.JTextField();
        btn_payemp_search = new javax.swing.JButton();
        btn_payemp_refresh = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(null);
        setMaximumSize(new java.awt.Dimension(1366, 730));
        setPreferredSize(new java.awt.Dimension(1366, 730));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 40)); // NOI18N
        jLabel1.setText("Employee Payment Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/user_folder-64.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setOpaque(false);

        tbl_payemp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp ID", "Last Name", "Lst.Pay Amount", "Lst. Pay Date & Month"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_payemp.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tbl_payemp.getTableHeader().setResizingAllowed(false);
        tbl_payemp.getTableHeader().setReorderingAllowed(false);
        tbl_payemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_payempMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_payempMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_payemp);
        if (tbl_payemp.getColumnModel().getColumnCount() > 0) {
            tbl_payemp.getColumnModel().getColumn(0).setResizable(false);
            tbl_payemp.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_payemp.getColumnModel().getColumn(1).setResizable(false);
            tbl_payemp.getColumnModel().getColumn(2).setResizable(false);
            tbl_payemp.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 610, 440));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setOpaque(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Detatils", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 1, 20))); // NOI18N
        jPanel4.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Emp ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("First Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Last Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Designation");

        txt_payemp_empid.setEditable(false);
        txt_payemp_empid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_payemp_fname.setEditable(false);
        txt_payemp_fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_payemp_lname.setEditable(false);
        txt_payemp_lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_payemp_desgnation.setEditable(false);
        txt_payemp_desgnation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_payemp_lname, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(txt_payemp_fname, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_payemp_empid, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_payemp_desgnation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_payemp_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_payemp_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_payemp_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_payemp_desgnation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pay Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 1, 20))); // NOI18N
        jPanel5.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Last Pay Amount");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Last Pay Date");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Loans");

        txt_payemp_amount.setEditable(false);
        txt_payemp_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_payemp_pdate.setEditable(false);
        txt_payemp_pdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_payemp_loan.setText("___");
        btn_payemp_loan.setEnabled(false);
        btn_payemp_loan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_payemp_loanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_payemp_pdate, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                        .addComponent(txt_payemp_amount))
                    .addComponent(btn_payemp_loan))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_payemp_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_payemp_pdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(btn_payemp_loan))
                .addGap(0, 68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 640, 440));

        txt_payemp_search.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        txt_payemp_search.setForeground(new java.awt.Color(153, 153, 153));
        txt_payemp_search.setText("Enter Name or Emp ID");
        txt_payemp_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_payemp_searchMouseClicked(evt);
            }
        });
        txt_payemp_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_payemp_searchActionPerformed(evt);
            }
        });
        txt_payemp_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_payemp_searchKeyPressed(evt);
            }
        });
        getContentPane().add(txt_payemp_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 240, -1));

        btn_payemp_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/search-32.png"))); // NOI18N
        btn_payemp_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_payemp_searchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_payemp_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        btn_payemp_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/View_Details-26.png"))); // NOI18N
        btn_payemp_refresh.setText("<html>View All<br>Last Month</html>");
        btn_payemp_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_payemp_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_payemp_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 600, 120, -1));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/background.png"))); // NOI18N
        lbl_background.setMaximumSize(new java.awt.Dimension(1366, 730));
        lbl_background.setMinimumSize(new java.awt.Dimension(1366, 730));
        lbl_background.setPreferredSize(new java.awt.Dimension(1366, 730));
        getContentPane().add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 1350, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void btn_payemp_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_payemp_searchActionPerformed

        if (txt_payemp_search.getText().isEmpty() || txt_payemp_search.getText().equals("Enter Last Name or Emp ID")) {
            JOptionPane.showMessageDialog(this, "PLEASE Enter Emp Name Or ID");
            new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Last Name or Emp ID", txt_payemp_search);
        } else {
            empDetatils();
        }

    }//GEN-LAST:event_btn_payemp_searchActionPerformed

    private void txt_payemp_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_payemp_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_payemp_searchActionPerformed

    private void txt_payemp_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_payemp_searchMouseClicked

        new pay_loan().searchText("Tahoma", 0, 0, null, txt_payemp_search);
    }//GEN-LAST:event_txt_payemp_searchMouseClicked

    private void txt_payemp_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_payemp_searchKeyPressed

        if (evt.getKeyCode() == 10) {
            if (txt_payemp_search.getText().isEmpty() || txt_payemp_search.getText().equals("Enter Name or Emp ID")) {
                JOptionPane.showMessageDialog(this, "PLEASE Enter Name or Emp ID");
                new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Last Name or ID", txt_payemp_search);
            } else {
                empDetatils();
                if (tbl_payemp.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "No Record Found");
                    new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Last Name or Emp ID", txt_payemp_search);
                }
            }
        }
        if (evt.getKeyCode() == 8) {
            new pay_loan().searchText("Tahoma", 0, 0, null, txt_payemp_search);
        }

    }//GEN-LAST:event_txt_payemp_searchKeyPressed

    private void tbl_payempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_payempMouseClicked


    }//GEN-LAST:event_tbl_payempMouseClicked

    private void btn_payemp_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_payemp_refreshActionPerformed

        cls();
        DefaultTableModel dtm = (DefaultTableModel) tbl_payemp.getModel();
        new Add_customer().removeAllRow(tbl_payemp);
        try {
            ResultSet r = new JDBC().getData("SELECT empid,name,date,month,tot,year FROM pay WHERE month='" + month + "' ");
            while (r.next()) {
                Vector v = new Vector();
                v.add(r.getString("empid"));
                v.add(r.getString("name"));
                v.add("Rs:" + r.getString("tot"));
                v.add(r.getString("date") + "-" + monthName(r.getInt("month")));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btn_payemp_refreshActionPerformed

    private void tbl_payempMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_payempMouseReleased

        cls();
        DefaultTableModel dtm = (DefaultTableModel) tbl_payemp.getModel();
        int selectedRow = tbl_payemp.getSelectedRow();
        try {
            ResultSet r = new JDBC().getData("SELECT empid,name,designation FROM employee WHERE empid='" + dtm.getValueAt(selectedRow, 0) + "' ");
            ResultSet pay = new JDBC().getData("SELECT * FROM pay WHERE empid='" + dtm.getValueAt(selectedRow, 0) + "' AND year=(SELECT MAX(year) FROM pay) AND month=(SELECT MAX(month) FROM pay) ");
            if (r.next()) {
                txt_payemp_empid.setText(r.getString("empid"));
                txt_payemp_desgnation.setText(r.getString("designation"));
                String ar[] = r.getString("name").split(",");
                if (ar.length == 3) {
                    txt_payemp_fname.setText(ar[0]);
                    txt_payemp_lname.setText(ar[2]);
                } else if (ar.length == 2) {
                    txt_payemp_fname.setText(ar[0]);
                    txt_payemp_lname.setText(null);
                } else if (ar.length == 0) {
                    txt_payemp_fname.setText(null);
                    txt_payemp_lname.setText(null);
                }
            }
            if (pay.next()) {
                txt_payemp_amount.setText("Rs:" + String.valueOf(pay.getDouble("tot")));
                txt_payemp_pdate.setText(String.valueOf(pay.getInt("date")) + "-" + monthName(pay.getInt("month")));
                if (pay.getInt("loan") == 0) {
                    btn_payemp_loan.setText("NO");
                    btn_payemp_loan.setEnabled(false);
                } else {
                    btn_payemp_loan.setText("YES");
                    btn_payemp_loan.setEnabled(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbl_payempMouseReleased

    private void btn_payemp_loanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_payemp_loanActionPerformed

        if (btn_payemp_loan.getText().equals("YES")) {
            Home.jDesktopPane2.add(new pay_loan()).setVisible(true);
        }
    }//GEN-LAST:event_btn_payemp_loanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_payemp_loan;
    private javax.swing.JButton btn_payemp_refresh;
    private javax.swing.JButton btn_payemp_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JTable tbl_payemp;
    private javax.swing.JTextField txt_payemp_amount;
    private javax.swing.JTextField txt_payemp_desgnation;
    private javax.swing.JTextField txt_payemp_empid;
    private javax.swing.JTextField txt_payemp_fname;
    private javax.swing.JTextField txt_payemp_lname;
    private javax.swing.JTextField txt_payemp_pdate;
    private javax.swing.JTextField txt_payemp_search;
    // End of variables declaration//GEN-END:variables
void empDetatils() {
        try {
            ResultSet r = new JDBC().getData("SELECT empid,name,date,month,tot FROM pay WHERE empid='" + txt_payemp_search.getText() + "' OR name LIKE '%" + txt_payemp_search.getText() + "%' AND year=(SELECT MAX(year) FROM pay) AND month=(SELECT MAX(month) FROM pay) ");
            while (r.next()) {
                new Add_customer().removeAllRow(tbl_payemp);
                DefaultTableModel dtm = (DefaultTableModel) tbl_payemp.getModel();
                Vector v = new Vector();
                v.add(r.getString("empid"));
                v.add(r.getString("name"));
                v.add("Rs:" + r.getString("tot"));
                v.add(r.getString("date") + "-" + monthName(r.getInt("month")));
                dtm.addRow(v);
            }
            if (tbl_payemp.getRowCount()==0) {
                JOptionPane.showMessageDialog(this, "No Record Founded", "Search", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Last Name or Emp ID", txt_payemp_search);
    }

    String monthName(int m) {
        String s = "";
        if (m == 1) {
            s = "January";
        } else if (m == 2) {
            s = "February";
        } else if (m == 3) {
            s = "March";
        } else if (m == 4) {
            s = "April";
        } else if (m == 5) {
            s = "May";
        } else if (m == 6) {
            s = "June";
        } else if (m == 7) {
            s = "July";
        } else if (m == 8) {
            s = "August";
        } else if (m == 9) {
            s = "September";
        } else if (m == 10) {
            s = "Octomber";
        } else if (m == 11) {
            s = "Npvember";
        } else {
            s = "December";
        }
        return s;
    }

    void cls() {
        txt_payemp_amount.setText(null);
        txt_payemp_desgnation.setText(null);
        txt_payemp_empid.setText(null);
        txt_payemp_fname.setText(null);
        txt_payemp_lname.setText(null);
        txt_payemp_pdate.setText(null);
        btn_payemp_loan.setText("__");
        btn_payemp_loan.setEnabled(false);
    }

}

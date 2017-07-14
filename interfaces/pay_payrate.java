package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashith
 */
public class pay_payrate extends javax.swing.JInternalFrame {

    public pay_payrate() {
        super("Pay Rate", true, true, true, true);
        initComponents();
        new pay_loan().setToCombo(cmb_rate_empid, "SELECT empid FROM employee where status='Activate'");
        dch_rate_pdate.setDay(new pay_pay().date());

    }
    boolean editMode = true;
    String id = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_rate_empid = new javax.swing.JComboBox();
        txt_rate_lname = new javax.swing.JTextField();
        txt_rate_degna = new javax.swing.JTextField();
        txt_rate_normal = new javax.swing.JTextField();
        txt_rate_ot = new javax.swing.JTextField();
        txt_rate_halfd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_rate_save = new javax.swing.JButton();
        btn_rate_cancel = new javax.swing.JButton();
        dch_rate_pdate = new com.toedter.calendar.JDayChooser();
        btn_rate_edit = new javax.swing.JButton();
        btn_rate_delete = new javax.swing.JButton();
        btn_rate_refresh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_rate_vw = new javax.swing.JTable();
        lbl_background = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/coins-26.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1366, 734));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 40)); // NOI18N
        jLabel1.setText("Edit Pay Rate");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/coins-64.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Emp ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Designation");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Normal Day");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("O/T Hour");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Half Day");

        cmb_rate_empid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_rate_empid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        cmb_rate_empid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmb_rate_empidMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmb_rate_empidMouseExited(evt);
            }
        });
        cmb_rate_empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_rate_empidActionPerformed(evt);
            }
        });

        txt_rate_lname.setEditable(false);
        txt_rate_lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_rate_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rate_lnameActionPerformed(evt);
            }
        });

        txt_rate_degna.setEditable(false);
        txt_rate_degna.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_rate_normal.setEditable(false);
        txt_rate_normal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_rate_normal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_rate_normalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rate_normalKeyTyped(evt);
            }
        });

        txt_rate_ot.setEditable(false);
        txt_rate_ot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_rate_ot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_rate_otKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rate_otKeyTyped(evt);
            }
        });

        txt_rate_halfd.setEditable(false);
        txt_rate_halfd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_rate_halfd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_rate_halfdKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rate_halfdKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Pay Date");

        btn_rate_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/save-26.png"))); // NOI18N
        btn_rate_save.setText("Save");
        btn_rate_save.setToolTipText("");
        btn_rate_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rate_saveActionPerformed(evt);
            }
        });

        btn_rate_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/cancel-26.png"))); // NOI18N
        btn_rate_cancel.setText("Cancel");
        btn_rate_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rate_cancelActionPerformed(evt);
            }
        });

        dch_rate_pdate.setBackground(new java.awt.Color(153, 153, 255));
        dch_rate_pdate.setDecorationBackgroundColor(new java.awt.Color(255, 255, 255));
        dch_rate_pdate.setEnabled(false);
        dch_rate_pdate.setOpaque(false);
        dch_rate_pdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dch_rate_pdateKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_rate_empid, 0, 218, Short.MAX_VALUE)
                            .addComponent(txt_rate_lname)
                            .addComponent(txt_rate_degna))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_rate_normal, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(txt_rate_ot)
                                    .addComponent(txt_rate_halfd))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(dch_rate_pdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                                .addComponent(btn_rate_save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_rate_cancel)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmb_rate_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_rate_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_rate_degna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_rate_normal)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_rate_ot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txt_rate_halfd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(dch_rate_pdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(127, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_rate_save)
                            .addComponent(btn_rate_cancel))
                        .addGap(47, 47, 47))))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 620, 560));

        btn_rate_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/edit-26.png"))); // NOI18N
        btn_rate_edit.setText("Edit");
        btn_rate_edit.setEnabled(false);
        btn_rate_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rate_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_rate_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 590, 90, -1));

        btn_rate_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/delete_database-26.png"))); // NOI18N
        btn_rate_delete.setText("Delete");
        btn_rate_delete.setEnabled(false);
        btn_rate_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rate_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_rate_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 590, 110, -1));

        btn_rate_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/refresh-26.png"))); // NOI18N
        btn_rate_refresh.setText("View All");
        btn_rate_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rate_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_rate_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 590, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setOpaque(false);

        tbl_rate_vw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp ID", " LastName", "Normal Day", "O/T Hour", "Half Day", "Pay Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_rate_vw.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tbl_rate_vw.getTableHeader().setResizingAllowed(false);
        tbl_rate_vw.getTableHeader().setReorderingAllowed(false);
        tbl_rate_vw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_rate_vwMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_rate_vwMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_rate_vw);
        if (tbl_rate_vw.getColumnModel().getColumnCount() > 0) {
            tbl_rate_vw.getColumnModel().getColumn(0).setResizable(false);
            tbl_rate_vw.getColumnModel().getColumn(1).setResizable(false);
            tbl_rate_vw.getColumnModel().getColumn(2).setResizable(false);
            tbl_rate_vw.getColumnModel().getColumn(3).setResizable(false);
            tbl_rate_vw.getColumnModel().getColumn(4).setResizable(false);
            tbl_rate_vw.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 660, 470));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/background.png"))); // NOI18N
        getContentPane().add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_rate_empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_rate_empidActionPerformed

        if (cmb_rate_empid.getSelectedItem().equals("Select")) {
            cls();
            tbl_rate_vw.clearSelection();
            btn_rate_save.setEnabled(true);
            btn_rate_save.setText("Save");
        } else {
            DefaultTableModel dtm = (DefaultTableModel) tbl_rate_vw.getModel();
            try {
                ResultSet r = new JDBC().getData("SELECT * FROM employee WHERE empid='" + cmb_rate_empid.getSelectedItem() + "' ");
                ResultSet toCmb = new JDBC().getData("SELECT * FROM rate WHERE empid='" + cmb_rate_empid.getSelectedItem() + "' ");
                if (r.next()) {
                    if (toCmb.next()) {
                        id = r.getString("empid");
                        if (tbl_rate_vw.getRowCount() == 1 || tbl_rate_vw.getRowCount() == 0) {
                            new Add_customer().removeAllRow(tbl_rate_vw);
                            clickToText(dtm, toCmb);
                        } else {
                            txt_rate_normal.setText("Rs:" + toCmb.getString("normal"));
                            txt_rate_ot.setText("Rs:" + toCmb.getString("ot"));
                            txt_rate_halfd.setText("Rs:" + toCmb.getString("halfd"));
                            selectTable(dtm, id);
                        }
                        btn_rate_save.setEnabled(false);
                    } else {
                        btn_rate_save.setEnabled(true);
                        txt_rate_halfd.setText(null);
                        txt_rate_normal.setText(null);
                        txt_rate_ot.setText(null);
                        int msg = JOptionPane.showConfirmDialog(this, "NEW Employee Please ADD PAY Details", "Message", 0);

                        if (msg == 0) {
                            txt_rate_normal.setEditable(true);
                            txt_rate_normal.setText("Rs:");
                            txt_rate_normal.grabFocus();
                            txt_rate_halfd.setEditable(true);
                            txt_rate_ot.setEditable(true);
                            dch_rate_pdate.setEnabled(true);
                            btn_rate_save.setEnabled(true);
                            btn_rate_edit.setEnabled(false);
                            btn_rate_delete.setEnabled(false);
                        } else {
                            cls();
                            new Add_customer().removeAllRow(tbl_rate_vw);
                            cmb_rate_empid.setSelectedItem("Select");
                        }

                    }

                    if (!cmb_rate_empid.getSelectedItem().equals("Select")) {
                        String ar[] = r.getString("name").split(",");
                        txt_rate_lname.setText(ar[2]);
                        txt_rate_degna.setText(r.getString("designation"));
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_cmb_rate_empidActionPerformed

    private void txt_rate_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rate_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rate_lnameActionPerformed

    private void btn_rate_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rate_saveActionPerformed

        if (!editMode) {
            DefaultTableModel dtm = (DefaultTableModel) tbl_rate_vw.getModel();
            int selectRow = tbl_rate_vw.getSelectedRow();
            try {
                ResultSet r = new JDBC().getData("SELECT normal,ot,halfd,pdate FROM rate WHERE empid='" + cmb_rate_empid.getSelectedItem() + "' ");
                if (r.next()) {
                    System.out.println(equals(r));
                    if (equals(r)) {
                        dtm.setValueAt(txt_rate_normal.getText(), selectRow, 2);
                        dtm.setValueAt(txt_rate_ot.getText(), selectRow, 3);
                        dtm.setValueAt(txt_rate_halfd.getText(), selectRow, 4);
                        dtm.setValueAt(dch_rate_pdate.getDay(), selectRow, 5);
                        upDateDB();
                        btn_rate_edit.setEnabled(false);
                        btn_rate_delete.setEnabled(false);
                        cmb_rate_empid.setSelectedItem("Select");
                        cls();

                    } else {
                        JOptionPane.showMessageDialog(this, "PAY RATE Is ALREADY Added");
                        btn_rate_edit.setEnabled(false);
                        btn_rate_delete.setEnabled(false);
                    }
                    editMode = true;
                    btn_rate_save.setText("Save");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                ResultSet r = new JDBC().getData("SELECT empid FROM rate WHERE empid='" + cmb_rate_empid.getSelectedItem() + "' ");
                if (r.next()) {
                    JOptionPane.showMessageDialog(this, "PAY RATE Is ALREADY Added");
                } else {
                    addToDB();
                    cls();
                    btn_rate_edit.setEnabled(false);
                    btn_rate_delete.setEnabled(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_rate_saveActionPerformed

    private void cmb_rate_empidMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_rate_empidMouseEntered

    }//GEN-LAST:event_cmb_rate_empidMouseEntered

    private void txt_rate_normalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rate_normalKeyPressed

        if (txt_rate_normal.getText().isEmpty() || txt_rate_normal.getText().substring(3).isEmpty()) {
            txt_rate_normal.setText("Rs: ");

        } else {
            if (evt.getKeyCode() == 10 && !txt_rate_normal.getText().equals("Rs: ")) {
                txt_rate_ot.grabFocus();
                txt_rate_ot.setText("Rs: ");
            }
        }
    }//GEN-LAST:event_txt_rate_normalKeyPressed

    private void txt_rate_otKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rate_otKeyPressed

        if (txt_rate_ot.getText().isEmpty() || txt_rate_ot.getText().substring(3).isEmpty()) {
            txt_rate_ot.setText("Rs: ");
        } else {
            if (evt.getKeyCode() == 10 && !txt_rate_ot.getText().equals("Rs: ")) {
                txt_rate_halfd.grabFocus();
                txt_rate_halfd.setText("Rs: ");
            }
        }
    }//GEN-LAST:event_txt_rate_otKeyPressed

    private void cmb_rate_empidMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_rate_empidMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_rate_empidMouseExited

    private void tbl_rate_vwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_rate_vwMouseClicked

    }//GEN-LAST:event_tbl_rate_vwMouseClicked

    private void btn_rate_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rate_cancelActionPerformed

        cmb_rate_empid.getModel().setSelectedItem("Select");
        cls();
        btn_rate_edit.setEnabled(false);
        btn_rate_delete.setEnabled(false);
        btn_rate_save.setEnabled(true);
        editMode = true;
        btn_rate_save.setText("Save");
        txt_rate_halfd.setEditable(false);
        txt_rate_normal.setEditable(false);
        txt_rate_ot.setEditable(false);
    }//GEN-LAST:event_btn_rate_cancelActionPerformed

    private void btn_rate_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rate_editActionPerformed

        txt_rate_normal.setEditable(true);
        txt_rate_halfd.setEditable(true);
        txt_rate_ot.setEditable(true);
        dch_rate_pdate.setEnabled(true);
        btn_rate_save.setEnabled(true);
        txt_rate_normal.grabFocus();
        editMode = false;
        btn_rate_save.setText("Update");
    }//GEN-LAST:event_btn_rate_editActionPerformed

    private void btn_rate_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rate_deleteActionPerformed

        DefaultTableModel dtm = (DefaultTableModel) tbl_rate_vw.getModel();
        if (tbl_rate_vw.getSelectedRowCount() > 1) {
            int msg = JOptionPane.showConfirmDialog(this, "Are You Sure Do You WANT To REMOVE ALL", "Stop", 0, 1, new ImageIcon("/build.image/close_window-26.png"));
            if (msg == 0) {
                try {
                    for (int i = 0; tbl_rate_vw.getSelectedRowCount() < 10; i++) {
                        new JDBC().putData("DELETE FROM rate WHERE empid='" + dtm.getValueAt(i, 0) + "' ");
                    }
                    new Add_customer().removeAllRow(tbl_rate_vw);
                    JOptionPane.showMessageDialog(this, "Records has been REMOVED");
                    btn_rate_edit.setEnabled(false);
                    btn_rate_delete.setEnabled(false);
                    cmb_rate_empid.setSelectedItem("Select");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            int msg = JOptionPane.showConfirmDialog(this, "Are You Sure Do You WANT To REMOVE This", "Stop", 0);
            if (msg == 0) {
                try {
                    new JDBC().putData("DELETE FROM rate WHERE empid='" + dtm.getValueAt(tbl_rate_vw.getSelectedRow(), 0) + "' ");
                    new Add_customer().removeRow(tbl_rate_vw);
                    JOptionPane.showMessageDialog(this, "Record has been REMOVED");
                    cmb_rate_empid.setSelectedItem("Select");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btn_rate_deleteActionPerformed

    private void btn_rate_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rate_refreshActionPerformed

        refresh();
        editMode = false;
    }//GEN-LAST:event_btn_rate_refreshActionPerformed

    private void txt_rate_halfdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rate_halfdKeyPressed

        if (txt_rate_halfd.getText().isEmpty() || txt_rate_halfd.getText().substring(3).isEmpty()) {
            txt_rate_halfd.setText("Rs: ");
        }
        if (evt.getKeyCode() == 10) {
            dch_rate_pdate.grabFocus();
        }
    }//GEN-LAST:event_txt_rate_halfdKeyPressed

    private void txt_rate_normalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rate_normalKeyTyped

        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_rate_normalKeyTyped

    private void txt_rate_otKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rate_otKeyTyped

        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_rate_otKeyTyped

    private void txt_rate_halfdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rate_halfdKeyTyped

        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_rate_halfdKeyTyped

    private void dch_rate_pdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dch_rate_pdateKeyPressed

        if (evt.getKeyCode() == 10) {
            btn_rate_saveActionPerformed(null);
        }
    }//GEN-LAST:event_dch_rate_pdateKeyPressed

    private void tbl_rate_vwMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_rate_vwMouseReleased

        setToText();
        btn_rate_save.setEnabled(false);
    }//GEN-LAST:event_tbl_rate_vwMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_rate_cancel;
    private javax.swing.JButton btn_rate_delete;
    private javax.swing.JButton btn_rate_edit;
    private javax.swing.JButton btn_rate_refresh;
    private javax.swing.JButton btn_rate_save;
    private javax.swing.JComboBox cmb_rate_empid;
    private com.toedter.calendar.JDayChooser dch_rate_pdate;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JTable tbl_rate_vw;
    private javax.swing.JTextField txt_rate_degna;
    private javax.swing.JTextField txt_rate_halfd;
    private javax.swing.JTextField txt_rate_lname;
    private javax.swing.JTextField txt_rate_normal;
    private javax.swing.JTextField txt_rate_ot;
    // End of variables declaration//GEN-END:variables

    void addToDB() {
        if (!cmb_rate_empid.getSelectedItem().equals("Select")) {
            String nrd[] = txt_rate_normal.getText().split(":");
            String ot[] = txt_rate_ot.getText().split(":");
            String hlfd[] = txt_rate_halfd.getText().split(":");
            try {
                new JDBC().putData("INSERT INTO rate VALUES('" + cmb_rate_empid.getSelectedItem() + "','" + nrd[1] + "','" + ot[1] + "','" + hlfd[1] + "','" + dch_rate_pdate.getDay() + "','" + txt_rate_lname.getText() + "')");
                addToTable();
                new JDBC().putData("INSERT INTO epetf (empid) VALUES('" + cmb_rate_empid.getSelectedItem() + "') ");
                JOptionPane.showMessageDialog(this, "PAY Rate Saved");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "PLEASE Select an Emp ID");
        }
    }

    void addToTable() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_rate_vw.getModel();
        Vector v = new Vector();
        v.add(cmb_rate_empid.getSelectedItem());
        v.add(txt_rate_lname.getText());
        v.add(txt_rate_normal.getText());
        v.add(txt_rate_ot.getText());
        v.add(txt_rate_halfd.getText());
        v.add(dch_rate_pdate.getDay());
        dtm.addRow(v);
    }

    void cls() {
        txt_rate_lname.setText(null);
        txt_rate_degna.setText(null);
        txt_rate_normal.setText(null);
        txt_rate_halfd.setText(null);
        txt_rate_ot.setText(null);
    }

    void upDateDB() {
        String nrd[] = txt_rate_normal.getText().split(":");
        String ot[] = txt_rate_ot.getText().split(":");
        String hlfd[] = txt_rate_halfd.getText().split(":");
        try {
            new JDBC().putData("UPDATE rate SET normal='" + nrd[1] + "',ot='" + ot[1] + "',halfd='" + hlfd[1] + "',pdate='" + dch_rate_pdate.getDay() + "' WHERE empid='" + cmb_rate_empid.getSelectedItem() + "' ");
            JOptionPane.showMessageDialog(this, "RECORD has been UPDATED");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setToText() {
        btn_rate_edit.setEnabled(true);
        btn_rate_delete.setEnabled(true);
        DefaultTableModel dtm = (DefaultTableModel) tbl_rate_vw.getModel();
        int selectedRow = tbl_rate_vw.getSelectedRow();
        cmb_rate_empid.getModel().setSelectedItem(dtm.getValueAt(selectedRow, 0));
        try {
            ResultSet r = new JDBC().getData("SELECT designation FROM employee WHERE empid='" + dtm.getValueAt(selectedRow, 0) + "' ");
            if (r.next()) {
                txt_rate_degna.setText(r.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        txt_rate_normal.setText((String) dtm.getValueAt(selectedRow, 2));
        txt_rate_ot.setText((String) dtm.getValueAt(selectedRow, 3));
        txt_rate_halfd.setText((String) dtm.getValueAt(selectedRow, 4));

    }

    void refresh() {
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM rate");
            new Add_customer().removeAllRow(tbl_rate_vw);
            while (r.next()) {
                DefaultTableModel dtm = (DefaultTableModel) tbl_rate_vw.getModel();
                Vector v = new Vector();
                v.add(r.getString("empid"));
                v.add(r.getString("lname"));
                v.add("Rs:" + r.getString("normal"));
                v.add("Rs:" + r.getString("ot"));
                v.add("Rs:" + r.getString("halfd"));
                v.add(r.getString("pdate"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String amount(JTextField tx) {
        String s = "";
        try {
            String ar[] = tx.getText().split(":");
            if (ar.length == 2) {
                s = ar[1];
            }
            s = null;
        } catch (Exception e) {
        }
        return s;
    }

    boolean equals(ResultSet r) {
        boolean b = false;
        try {
            b = (!r.getString("normal").equals(amount(txt_rate_normal)) | !r.getString("ot").equals(amount(txt_rate_ot))
                    | !r.getString("halfd").equals(amount(txt_rate_halfd)) | r.getInt("pdate") != (dch_rate_pdate.getDay()));
        } catch (SQLException ex) {

        }
        return b;
    }

    void editToCmb(String a) {
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM rate WHERE empid='" + a + "' ");
            if (r.next()) {
                new pay_loan().setToCombo(cmb_rate_empid, "SELECT * FROM rate");
                txt_rate_lname.setText(r.getString("lname"));
                txt_rate_halfd.setText("Rs:" + r.getDouble("halfd"));
                txt_rate_normal.setText("Rs:" + r.getString("normal"));
                txt_rate_ot.setText("Rs:" + r.getString("ot"));
            }
        } catch (Exception e) {
        }
    }

    void clickToText(DefaultTableModel dtm, ResultSet toCmb) {
        try {
            id = toCmb.getString("empid");
            Vector v = new Vector();
            v.add(id);
            v.add(toCmb.getString("lname"));
            v.add("Rs:" + toCmb.getString("normal"));
            v.add("Rs:" + toCmb.getString("ot"));
            v.add("Rs:" + toCmb.getString("halfd"));
            v.add(toCmb.getString("pdate"));
            dtm.addRow(v);
            txt_rate_normal.setText("Rs:" + toCmb.getString("normal"));
            txt_rate_ot.setText("Rs:" + toCmb.getString("ot"));
            txt_rate_halfd.setText("Rs:" + toCmb.getString("halfd"));
            selectTable(dtm, id);
        } catch (Exception e) {
        }
    }

    void selectTable(DefaultTableModel dtm, String s) {
        for (int row = 0; row < tbl_rate_vw.getRowCount(); row++) {
            if (s.equals(dtm.getValueAt(row, 0))) {
                tbl_rate_vw.getSelectionModel().setSelectionInterval(row, row);
            }
        }
    }

}

package interfaces;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashith
 */
public class Add_customer extends javax.swing.JInternalFrame {

    public Add_customer() {
        super("Add Customer", true, true, true, true);
        initComponents();
        Id("SELECT COUNT(cusid)+1 AS newid FROM customer", txt_addcust_id, "CUS", "%03d");
        txt_addcust_name.grabFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_addcust_head = new javax.swing.JLabel();
        lbl_addcust_icon = new javax.swing.JLabel();
        pnl_addcust_adddtls = new javax.swing.JPanel();
        lbl_addcust_id = new javax.swing.JLabel();
        lbl_addcust_name = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        chk_addcust_nic = new javax.swing.JCheckBox();
        txt_addcust_name = new javax.swing.JTextField();
        txt_addcust_address1 = new javax.swing.JTextField();
        txt_addcust_address2 = new javax.swing.JTextField();
        txt_addcust_nic = new javax.swing.JTextField();
        txt_addcust_mob = new javax.swing.JTextField();
        cmb_addcust_state = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        btn_addcust_save = new javax.swing.JButton();
        btn_addcust_reset = new javax.swing.JButton();
        txt_addcust_id = new javax.swing.JTextField();
        btn_addcust_refresh = new javax.swing.JButton();
        btn_addcust_delete = new javax.swing.JButton();
        btn_addcust_clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_addcust_vw = new javax.swing.JTable();
        lbl_background = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/add_user-26.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_addcust_head.setFont(new java.awt.Font("Segoe UI Light", 0, 40)); // NOI18N
        lbl_addcust_head.setText("Add Customer");
        getContentPane().add(lbl_addcust_head, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 270, -1));

        lbl_addcust_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/add_user-64.png"))); // NOI18N
        getContentPane().add(lbl_addcust_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        pnl_addcust_adddtls.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 0, 20))); // NOI18N
        pnl_addcust_adddtls.setOpaque(false);

        lbl_addcust_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_addcust_id.setText("Customer ID");

        lbl_addcust_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_addcust_name.setText("Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Address");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mobile");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("State");

        chk_addcust_nic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chk_addcust_nic.setText("NIC");
        chk_addcust_nic.setOpaque(false);
        chk_addcust_nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_addcust_nicActionPerformed(evt);
            }
        });

        txt_addcust_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_addcust_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addcust_nameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_addcust_nameKeyTyped(evt);
            }
        });

        txt_addcust_address1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_addcust_address1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addcust_address1KeyPressed(evt);
            }
        });

        txt_addcust_address2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_addcust_address2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addcust_address2KeyPressed(evt);
            }
        });

        txt_addcust_nic.setEditable(false);
        txt_addcust_nic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_addcust_nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addcust_nicActionPerformed(evt);
            }
        });
        txt_addcust_nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addcust_nicKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_addcust_nicKeyTyped(evt);
            }
        });

        txt_addcust_mob.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_addcust_mob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addcust_mobActionPerformed(evt);
            }
        });
        txt_addcust_mob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addcust_mobKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_addcust_mobKeyTyped(evt);
            }
        });

        cmb_addcust_state.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_addcust_state.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal Cutomer", "Credit Customer" }));
        cmb_addcust_state.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_addcust_stateKeyPressed(evt);
            }
        });

        jPanel3.setOpaque(false);

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/add_user-128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_image, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );

        btn_addcust_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/add_list-26.png"))); // NOI18N
        btn_addcust_save.setText("Save");
        btn_addcust_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcust_saveActionPerformed(evt);
            }
        });

        btn_addcust_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/erase-26.png"))); // NOI18N
        btn_addcust_reset.setText("Reset Feilds");
        btn_addcust_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcust_resetActionPerformed(evt);
            }
        });

        txt_addcust_id.setEditable(false);
        txt_addcust_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_addcust_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addcust_idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_addcust_adddtlsLayout = new javax.swing.GroupLayout(pnl_addcust_adddtls);
        pnl_addcust_adddtls.setLayout(pnl_addcust_adddtlsLayout);
        pnl_addcust_adddtlsLayout.setHorizontalGroup(
            pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addcust_adddtlsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chk_addcust_nic, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_addcust_name, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_addcust_id, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_addcust_adddtlsLayout.createSequentialGroup()
                        .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_addcust_adddtlsLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(btn_addcust_reset))
                            .addComponent(btn_addcust_save))
                        .addGap(14, 14, 14))
                    .addGroup(pnl_addcust_adddtlsLayout.createSequentialGroup()
                        .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_addcust_adddtlsLayout.createSequentialGroup()
                                .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_addcust_name)
                                    .addComponent(txt_addcust_address1)
                                    .addComponent(txt_addcust_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_addcust_id)
                                    .addComponent(txt_addcust_address2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_addcust_mob, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_addcust_state, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        pnl_addcust_adddtlsLayout.setVerticalGroup(
            pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addcust_adddtlsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_addcust_adddtlsLayout.createSequentialGroup()
                        .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_addcust_id)
                            .addComponent(txt_addcust_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_addcust_name)
                            .addComponent(txt_addcust_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_addcust_address1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txt_addcust_address2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_addcust_nic)
                    .addComponent(txt_addcust_nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_addcust_mob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmb_addcust_state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(pnl_addcust_adddtlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addcust_save)
                    .addComponent(btn_addcust_reset))
                .addContainerGap())
        );

        getContentPane().add(pnl_addcust_adddtls, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 590, 410));

        btn_addcust_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/refresh-26.png"))); // NOI18N
        btn_addcust_refresh.setText("View Today");
        btn_addcust_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcust_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addcust_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 570, -1, -1));

        btn_addcust_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/Delete_Row-26.png"))); // NOI18N
        btn_addcust_delete.setText("Delete Row");
        btn_addcust_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcust_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addcust_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 570, -1, -1));

        btn_addcust_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/cancel-26.png"))); // NOI18N
        btn_addcust_clear.setText("Clear All");
        btn_addcust_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcust_clearActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addcust_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 570, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setOpaque(false);

        tbl_addcust_vw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "NIC", "Mobile", "State", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_addcust_vw.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(tbl_addcust_vw);
        if (tbl_addcust_vw.getColumnModel().getColumnCount() > 0) {
            tbl_addcust_vw.getColumnModel().getColumn(0).setResizable(false);
            tbl_addcust_vw.getColumnModel().getColumn(1).setResizable(false);
            tbl_addcust_vw.getColumnModel().getColumn(3).setResizable(false);
            tbl_addcust_vw.getColumnModel().getColumn(4).setResizable(false);
            tbl_addcust_vw.getColumnModel().getColumn(5).setResizable(false);
            tbl_addcust_vw.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 130, 620, 410));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/background.png"))); // NOI18N
        getContentPane().add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chk_addcust_nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_addcust_nicActionPerformed

        if (!txt_addcust_name.getText().isEmpty()) {
            if (chk_addcust_nic.isSelected()) {
                txt_addcust_nic.setEditable(true);
                txt_addcust_nic.grabFocus();
            } else {
                txt_addcust_nic.setEditable(false);
            }
        }
    }//GEN-LAST:event_chk_addcust_nicActionPerformed

    private void txt_addcust_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addcust_nameKeyPressed

        if (evt.getKeyCode() == 10) {
            if (txt_addcust_name.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "NAME can not be EMPTY");
            } else {
                txt_addcust_address1.grabFocus();
            }
        }
    }//GEN-LAST:event_txt_addcust_nameKeyPressed

    private void txt_addcust_address1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addcust_address1KeyPressed

        nextText(evt, txt_addcust_address2);
    }//GEN-LAST:event_txt_addcust_address1KeyPressed

    private void txt_addcust_address2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addcust_address2KeyPressed

        if (evt.getKeyCode() == 10) {
            if (chk_addcust_nic.isSelected()) {
                txt_addcust_nic.grabFocus();
            } else {
                txt_addcust_mob.grabFocus();
            }
        }
    }//GEN-LAST:event_txt_addcust_address2KeyPressed

    private void txt_addcust_nicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addcust_nicKeyPressed

        if (evt.getKeyCode() == 10) {
            if (!txt_addcust_nic.getText().isEmpty() && txt_addcust_nic.getText().length() == 9) {
                txt_addcust_nic.setText(txt_addcust_nic.getText() + "v");
                nextText(evt, txt_addcust_mob);
            }
        }

    }//GEN-LAST:event_txt_addcust_nicKeyPressed

    private void txt_addcust_mobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addcust_mobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addcust_mobActionPerformed

    private void txt_addcust_mobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addcust_mobKeyPressed

        if (!txt_addcust_nic.getText().isEmpty() && !txt_addcust_nic.getText().endsWith("v")) {
            txt_addcust_nic.setText(txt_addcust_nic.getText() + "v");
        }
        if (evt.getKeyCode() == 10) {
            cmb_addcust_state.grabFocus();
        }
    }//GEN-LAST:event_txt_addcust_mobKeyPressed

    private void btn_addcust_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcust_resetActionPerformed

        cls(txt_addcust_name, txt_addcust_address1, txt_addcust_address2, txt_addcust_nic, txt_addcust_nic, txt_addcust_mob, chk_addcust_nic, cmb_addcust_state);
    }//GEN-LAST:event_btn_addcust_resetActionPerformed

    private void btn_addcust_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcust_saveActionPerformed
        if (chk_addcust_nic.isSelected()) {
            if (txt_addcust_nic.getText().endsWith("v")) {
                try {
                    add();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Enter Valid NIC Number", "NIC Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            try {
                add();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
                Id("SELECT COUNT(cusid)+1 AS newid FROM customer", txt_addcust_id, "CUS", "%03d");

    }//GEN-LAST:event_btn_addcust_saveActionPerformed

    private void cmb_addcust_stateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_addcust_stateKeyPressed

        if (evt.getKeyCode() == 10) {
            try {
                add();
                Id("SELECT COUNT(cusid)+1 AS newid FROM customer", txt_addcust_id, "CUS", "%03d");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_cmb_addcust_stateKeyPressed

    private void btn_addcust_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcust_refreshActionPerformed

        if (tbl_addcust_vw.getRowCount() != 0) {
            removeAllRow(tbl_addcust_vw);
            refresh("SELECT * FROM customer WHERE date='" + Today() + "' ", tbl_addcust_vw);
        } else {
            refresh("SELECT * FROM customer WHERE date='" + Today() + "' ", tbl_addcust_vw);
        }
    }//GEN-LAST:event_btn_addcust_refreshActionPerformed

    private void btn_addcust_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcust_deleteActionPerformed

        if (tbl_addcust_vw.getSelectedRowCount() > 1) {
            int msg = JOptionPane.showConfirmDialog(this, "Are You Sure Do You WANT To REMOVE ALL", "Stop", 0, JOptionPane.QUESTION_MESSAGE);
            if (msg == 0) {
                try {
                    DefaultTableModel dtm = (DefaultTableModel) tbl_addcust_vw.getModel();
                    for (int i = 0; i < tbl_addcust_vw.getSelectedRowCount(); i++) {
                        new JDBC().putData("DELETE FROM customer WHERE cusid='" + dtm.getValueAt(i, 0) + "' ");
                    }
                    removeAllRow(tbl_addcust_vw);
                    Id("SELECT COUNT(cusid)+1 AS newid FROM customer", txt_addcust_id, "CUS", "%03d");
                    JOptionPane.showMessageDialog(this, "Records has been REMOVED");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (tbl_addcust_vw.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Nothing to REMOVE", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                DefaultTableModel dtm = (DefaultTableModel) tbl_addcust_vw.getModel();
                int row = tbl_addcust_vw.getSelectedRow();
                new JDBC().putData("DELETE FROM customer WHERE cusid='" + dtm.getValueAt(row, 0) + "' ");
                removeRow(tbl_addcust_vw);
                Id("SELECT COUNT(cusid)+1 AS newid FROM customer", txt_addcust_id, "CUS", "%03d");
                JOptionPane.showMessageDialog(this, "Record has been REMOVED");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btn_addcust_deleteActionPerformed

    private void btn_addcust_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcust_clearActionPerformed

        cls(txt_addcust_name, txt_addcust_address1, txt_addcust_address2, txt_addcust_nic, txt_addcust_nic, txt_addcust_mob, chk_addcust_nic, cmb_addcust_state);
        removeAllRow(tbl_addcust_vw);
        Id("SELECT COUNT(cusid)+1 AS newid FROM customer", txt_addcust_id, "CUS", "%03d");
    }//GEN-LAST:event_btn_addcust_clearActionPerformed

    private void txt_addcust_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addcust_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addcust_idActionPerformed

    private void txt_addcust_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addcust_nameKeyTyped

        lbl_addcust_name.setForeground(Color.black);
        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();

        }
    }//GEN-LAST:event_txt_addcust_nameKeyTyped

    private void txt_addcust_nicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addcust_nicKeyTyped

        char c = evt.getKeyChar();
        if (!(c >= '0' & c <= '9')) {
            evt.consume();
        }
        if (txt_addcust_nic.getText().length() == 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txt_addcust_nicKeyTyped

    private void txt_addcust_mobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addcust_mobKeyTyped

        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
            if (!txt_addcust_mob.getText().startsWith("0")) {
                evt.consume();
                JOptionPane.showMessageDialog(this, ui);
            }
        }
        if (txt_addcust_mob.getText().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_addcust_mobKeyTyped

    private void txt_addcust_nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addcust_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addcust_nicActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addcust_clear;
    private javax.swing.JButton btn_addcust_delete;
    private javax.swing.JButton btn_addcust_refresh;
    private javax.swing.JButton btn_addcust_reset;
    private javax.swing.JButton btn_addcust_save;
    private javax.swing.JCheckBox chk_addcust_nic;
    private javax.swing.JComboBox cmb_addcust_state;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_addcust_head;
    private javax.swing.JLabel lbl_addcust_icon;
    private javax.swing.JLabel lbl_addcust_id;
    private javax.swing.JLabel lbl_addcust_name;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JPanel pnl_addcust_adddtls;
    private javax.swing.JTable tbl_addcust_vw;
    private javax.swing.JTextField txt_addcust_address1;
    private javax.swing.JTextField txt_addcust_address2;
    private javax.swing.JTextField txt_addcust_id;
    private javax.swing.JTextField txt_addcust_mob;
    private javax.swing.JTextField txt_addcust_name;
    private javax.swing.JTextField txt_addcust_nic;
    // End of variables declaration//GEN-END:variables

    public void nextText(KeyEvent evt, JTextField tx) {
        if (evt.getKeyCode() == 10) {
            tx.grabFocus();
        }
    }

    void cls(JTextField tx1, JTextField tx2, JTextField tx3, JTextField tx4, JTextField tx5, JTextField tx6, JCheckBox ch, JComboBox cm) {
        tx1.setText(null);
        tx2.setText(null);
        tx3.setText(null);
        tx4.setText(null);
        tx5.setEditable(false);
        ch.setSelected(false);
        tx6.setText(null);
        cm.setSelectedItem("Normal Customer");
    }

    void add() throws Exception {
        if (!txt_addcust_name.getText().isEmpty()) {
            try {
                new JDBC().putData("INSERT INTO customer VALUES('" + txt_addcust_id.getText() + "','" + txt_addcust_name.getText() + "','" + txt_addcust_address1.getText() + "," + txt_addcust_address2.getText() + "','" + txt_addcust_nic.getText() + "','" + txt_addcust_mob.getText() + "','" + cmb_addcust_state.getSelectedItem() + "','" + Today() + "') ");
                addDatatoTable(txt_addcust_id.getText(), txt_addcust_name.getText(), txt_addcust_address1.getText(), txt_addcust_address2.getText(), txt_addcust_nic.getText(), txt_addcust_mob.getText(), cmb_addcust_state.getSelectedItem(), tbl_addcust_vw);
                cls(txt_addcust_name, txt_addcust_address1, txt_addcust_address2, txt_addcust_nic, txt_addcust_nic, txt_addcust_mob, chk_addcust_nic, cmb_addcust_state);
                int id = Integer.valueOf(txt_addcust_id.getText().substring(3));
                txt_addcust_id.setText("CUS"+String.format("%03d", id));
            } catch (MySQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(this, "Customer ID alredy EXITS", "Warrning", JOptionPane.ERROR_MESSAGE);
                int id = Integer.valueOf(txt_addcust_id.getText().substring(3));
                txt_addcust_id.setText("CUS"+String.format("%03d", id));
            }
        } else {
            lbl_addcust_name.setForeground(Color.red);
            JOptionPane.showMessageDialog(this, "NAME can not be EMPTY", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    String Today() {
        Calendar cal = Calendar.getInstance();
        String dt = String.valueOf(cal.get(Calendar.YEAR)) + "-0" + String.valueOf((cal.get(Calendar.MONTH)) + 1) + "-" + String.valueOf(cal.get(Calendar.DATE));
        return dt;
    }

    void addDatatoTable(Object tx1, Object tx2, Object tx3, Object tx4, Object tx5, Object tx6, Object tx7, JTable tb) {
        DefaultTableModel dtm = (DefaultTableModel) tb.getModel();
        Vector v = new Vector();
        v.add(tx1);
        v.add(tx2);
        v.add(tx3 + "," + tx4);
        v.add(tx5);
        v.add(tx6);
        v.add(tx7);
        v.add(Today());
        dtm.addRow(v);
    }

    void removeRow(JTable tb) {
        DefaultTableModel dtm = (DefaultTableModel) tb.getModel();
        int selectRow = tb.getSelectedRow();
        dtm.removeRow(selectRow);
    }

    void removeAllRow(JTable tb) {
        DefaultTableModel dtm = (DefaultTableModel) tb.getModel();
        int rowCount = tb.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            dtm.removeRow(0);
        }
    }

    void refresh(String sql, JTable tb) {
        try {
            ResultSet r = new JDBC().getData(sql);
            removeAllRow(tbl_addcust_vw);
            DefaultTableModel dtm = (DefaultTableModel) tb.getModel();

            while (r.next()) {
                Vector v = new Vector();
                v.add(r.getString("cusid"));
                v.add(r.getString("name"));
                v.add(r.getString("address"));
                v.add(r.getString("nic"));
                v.add(r.getString("mobile"));
                v.add(r.getString("state"));
                v.add(r.getString("date"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Id(String sql, JTextField tx, String type, String format) {
        try {
            ResultSet r = new JDBC().getData(sql);
            if (r.next()) {
                tx.setText(type + String.format(format, r.getInt("newid")));
            }
        } catch (Exception e) {
        }
    }

}

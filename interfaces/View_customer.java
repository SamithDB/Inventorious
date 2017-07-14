package interfaces;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashith
 */
public class View_customer extends javax.swing.JInternalFrame {

    public View_customer() {
        super("View Customer", true, true, true, true);
        initComponents();
        new Add_customer().refresh("SELECT * FROM customer WHERE date='" + new Add_customer().Today() + "' ", tbl_vwcust);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_vwcust = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chk_vwcust_nic = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_vwcust_id = new javax.swing.JTextField();
        txt_vwcust_name = new javax.swing.JTextField();
        txt_vwcust_address1 = new javax.swing.JTextField();
        txt_vwcust_address2 = new javax.swing.JTextField();
        txt_vwcust_nic = new javax.swing.JTextField();
        txt_vwcust_mobile = new javax.swing.JTextField();
        cmb_vwcust_state = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_vwcust_edit = new javax.swing.JButton();
        btn_vwcust_update = new javax.swing.JButton();
        btn_vwcust_cancel = new javax.swing.JButton();
        txt_vwcust_search = new javax.swing.JTextField();
        btn_vwcust_search = new javax.swing.JButton();
        btn_vwcust_refresh = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/group-26.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1366, 730));
        setPreferredSize(new java.awt.Dimension(1366, 730));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 40)); // NOI18N
        jLabel2.setText("View Customer Detatils");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/group-64.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setOpaque(false);

        tbl_vwcust.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_vwcust.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tbl_vwcust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_vwcustMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_vwcust);
        if (tbl_vwcust.getColumnModel().getColumnCount() > 0) {
            tbl_vwcust.getColumnModel().getColumn(0).setResizable(false);
            tbl_vwcust.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_vwcust.getColumnModel().getColumn(1).setResizable(false);
            tbl_vwcust.getColumnModel().getColumn(2).setResizable(false);
            tbl_vwcust.getColumnModel().getColumn(3).setResizable(false);
            tbl_vwcust.getColumnModel().getColumn(3).setPreferredWidth(55);
            tbl_vwcust.getColumnModel().getColumn(4).setResizable(false);
            tbl_vwcust.getColumnModel().getColumn(4).setPreferredWidth(55);
            tbl_vwcust.getColumnModel().getColumn(5).setResizable(false);
            tbl_vwcust.getColumnModel().getColumn(5).setPreferredWidth(60);
            tbl_vwcust.getColumnModel().getColumn(6).setResizable(false);
            tbl_vwcust.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 610, 380));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 0, 20))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Customer ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Address");

        chk_vwcust_nic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chk_vwcust_nic.setText("NIC");
        chk_vwcust_nic.setOpaque(false);
        chk_vwcust_nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_vwcust_nicActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Mobile");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("State");

        txt_vwcust_id.setEditable(false);
        txt_vwcust_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_vwcust_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vwcust_idActionPerformed(evt);
            }
        });

        txt_vwcust_name.setEditable(false);
        txt_vwcust_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_vwcust_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vwcust_nameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_vwcust_nameKeyTyped(evt);
            }
        });

        txt_vwcust_address1.setEditable(false);
        txt_vwcust_address1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_vwcust_address1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vwcust_address1KeyPressed(evt);
            }
        });

        txt_vwcust_address2.setEditable(false);
        txt_vwcust_address2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_vwcust_address2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vwcust_address2KeyPressed(evt);
            }
        });

        txt_vwcust_nic.setEditable(false);
        txt_vwcust_nic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_vwcust_nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vwcust_nicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_vwcust_nicKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_vwcust_nicKeyTyped(evt);
            }
        });

        txt_vwcust_mobile.setEditable(false);
        txt_vwcust_mobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_vwcust_mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vwcust_mobileKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_vwcust_mobileKeyTyped(evt);
            }
        });

        cmb_vwcust_state.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_vwcust_state.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal Customer", "Credit Customer" }));
        cmb_vwcust_state.setEnabled(false);
        cmb_vwcust_state.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_vwcust_stateKeyPressed(evt);
            }
        });

        jPanel3.setOpaque(false);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/add_user-128.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
        );

        btn_vwcust_edit.setEnabled(false);
        btn_vwcust_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/edit-26.png"))); // NOI18N
        btn_vwcust_edit.setText("Edit");
        btn_vwcust_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vwcust_editActionPerformed(evt);
            }
        });

        btn_vwcust_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/add_database-26.png"))); // NOI18N
        btn_vwcust_update.setText("Update");
        btn_vwcust_update.setEnabled(false);
        btn_vwcust_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vwcust_updateActionPerformed(evt);
            }
        });

        btn_vwcust_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/cancel-26.png"))); // NOI18N
        btn_vwcust_cancel.setText("Cancel All");
        btn_vwcust_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vwcust_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chk_vwcust_nic, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_vwcust_mobile, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_vwcust_nic, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(cmb_vwcust_state, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_vwcust_edit)
                                .addGap(18, 18, 18)
                                .addComponent(btn_vwcust_update)
                                .addGap(18, 18, 18)
                                .addComponent(btn_vwcust_cancel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_vwcust_id)
                                    .addComponent(txt_vwcust_name)
                                    .addComponent(txt_vwcust_address1)
                                    .addComponent(txt_vwcust_address2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_vwcust_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_vwcust_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_vwcust_address1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txt_vwcust_address2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chk_vwcust_nic)
                            .addComponent(txt_vwcust_nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_vwcust_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmb_vwcust_state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_vwcust_edit)
                    .addComponent(btn_vwcust_update)
                    .addComponent(btn_vwcust_cancel))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 620, 430));

        txt_vwcust_search.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        txt_vwcust_search.setForeground(new java.awt.Color(153, 153, 153));
        txt_vwcust_search.setText("Enter Customer ID or Name");
        txt_vwcust_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_vwcust_searchMouseClicked(evt);
            }
        });
        txt_vwcust_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vwcust_searchActionPerformed(evt);
            }
        });
        txt_vwcust_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_vwcust_searchKeyPressed(evt);
            }
        });
        getContentPane().add(txt_vwcust_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 260, -1));

        btn_vwcust_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/search-32.png"))); // NOI18N
        btn_vwcust_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vwcust_searchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_vwcust_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 110, -1));

        btn_vwcust_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/View_Details-26.png"))); // NOI18N
        btn_vwcust_refresh.setText("View All");
        btn_vwcust_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vwcust_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_vwcust_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 580, -1, -1));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/background.png"))); // NOI18N
        getContentPane().add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_vwcust_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vwcust_editActionPerformed

        enabled(txt_vwcust_name, txt_vwcust_address1, txt_vwcust_address2, txt_vwcust_mobile, cmb_vwcust_state, btn_vwcust_update, true);
        txt_vwcust_name.grabFocus();
    }//GEN-LAST:event_btn_vwcust_editActionPerformed

    private void btn_vwcust_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vwcust_cancelActionPerformed

        int ms = JOptionPane.showConfirmDialog(this, "Do You Want to CLEAR ALL", "Are You Sure!", JOptionPane.YES_NO_OPTION);
        if (ms == 0) {
            new Add_customer().removeAllRow(tbl_vwcust);
            chk_vwcust_nic.setSelected(false);
            enabled(txt_vwcust_name, txt_vwcust_address1, txt_vwcust_address2, txt_vwcust_mobile, cmb_vwcust_state, btn_vwcust_update, false);
            txt_vwcust_id.setText(null);
            txt_vwcust_nic.setEditable(false);
            btn_vwcust_edit.setEnabled(false);
            new Add_customer().cls(txt_vwcust_name, txt_vwcust_address1, txt_vwcust_address2, txt_vwcust_nic, txt_vwcust_id, txt_vwcust_mobile, chk_vwcust_nic, cmb_vwcust_state);
            if (tbl_vwcust.getRowCount() != 0) {
                new Add_customer().refresh("SELECT * FROM customer", tbl_vwcust);
            }
        }
    }//GEN-LAST:event_btn_vwcust_cancelActionPerformed

    private void txt_vwcust_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vwcust_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_vwcust_idActionPerformed

    private void btn_vwcust_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vwcust_searchActionPerformed

        if (txt_vwcust_search.getText().isEmpty() || txt_vwcust_search.getText().equals("Enter Customer ID or Name")) {
            JOptionPane.showMessageDialog(this, "PLEASE enter a Customer ID or Name");
            new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Customer ID or Name", txt_vwcust_search);
        } else {
            search();
            if (tbl_vwcust.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No Record Found");
                new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Customer ID or Name", txt_vwcust_search);
            }
        }

    }//GEN-LAST:event_btn_vwcust_searchActionPerformed

    private void tbl_vwcustMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_vwcustMouseClicked

        btn_vwcust_edit.setEnabled(true);
        DefaultTableModel dtm = (DefaultTableModel) tbl_vwcust.getModel();
        int selectRow = tbl_vwcust.getSelectedRow();
        txt_vwcust_id.setText((String) dtm.getValueAt(selectRow, 0));
        txt_vwcust_name.setText((String) dtm.getValueAt(selectRow, 1));
        String add = (String) dtm.getValueAt(selectRow, 2);
        String ar[] = add.split(",");
        if (ar.length == 2) {
            txt_vwcust_address1.setText(ar[0]);
            txt_vwcust_address2.setText(ar[1]);

        } else if (ar.length == 1) {
            txt_vwcust_address1.setText(ar[0]);
            txt_vwcust_address2.setText(null);
        } else if (ar.length == 0) {
            txt_vwcust_address1.setText(null);
            txt_vwcust_address2.setText(null);
        }
        txt_vwcust_nic.setText((String) dtm.getValueAt(selectRow, 3));
        txt_vwcust_mobile.setText((String) dtm.getValueAt(selectRow, 4));
        cmb_vwcust_state.setSelectedItem(dtm.getValueAt(selectRow, 5));


    }//GEN-LAST:event_tbl_vwcustMouseClicked

    private void chk_vwcust_nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_vwcust_nicActionPerformed

        if (txt_vwcust_name.isEditable()) {
            if (chk_vwcust_nic.isSelected()) {
                txt_vwcust_nic.setEditable(true);
                txt_vwcust_nic.grabFocus();
            } else {
                txt_vwcust_nic.setEditable(false);
            }
        }
    }//GEN-LAST:event_chk_vwcust_nicActionPerformed

    private void btn_vwcust_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vwcust_refreshActionPerformed

        new Add_customer().removeAllRow(tbl_vwcust);
        new Add_customer().refresh("SELECT * FROM customer", tbl_vwcust);
    }//GEN-LAST:event_btn_vwcust_refreshActionPerformed

    private void btn_vwcust_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vwcust_updateActionPerformed

        if (txt_vwcust_name.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NAME can not be EMPTY");
        } else {
            DefaultTableModel dtm = (DefaultTableModel) tbl_vwcust.getModel();
            int selectRow = tbl_vwcust.getSelectedRow();
            try {
                ResultSet r = new JDBC().getData("SELECT * FROM customer WHERE cusid='" + dtm.getValueAt(selectRow, 0) + "' ");
                if (r.next()) {
                    if (!r.getString("name").equals(txt_vwcust_name.getText()) || !r.getString("address").equals(txt_vwcust_address1.getText() + "," + txt_vwcust_address2.getText()) || !r.getString("nic").equals(txt_vwcust_nic.getText()) || !r.getString("mobile").equals(txt_vwcust_mobile.getText()) || !r.getString("state").equals(cmb_vwcust_state.getSelectedItem())) {
                        try {
                            new JDBC().putData("UPDATE customer SET name='" + txt_vwcust_name.getText() + "',address='" + txt_vwcust_address1.getText() + "," + txt_vwcust_address2.getText() + "',nic='" + txt_vwcust_nic.getText() + "',mobile='" + txt_vwcust_mobile.getText() + "',state='" + cmb_vwcust_state.getSelectedItem() + "' WHERE cusid='" + txt_vwcust_id.getText() + "' ");
                            JOptionPane.showMessageDialog(this, "Record Has Been UPDATED");
                            dtm.setValueAt(txt_vwcust_name.getText(), selectRow, 1);
                            dtm.setValueAt(txt_vwcust_address1.getText() + "," + txt_vwcust_address2.getText(), selectRow, 2);
                            dtm.setValueAt(txt_vwcust_nic.getText(), selectRow, 3);
                            dtm.setValueAt(txt_vwcust_mobile.getText(), selectRow, 4);
                            dtm.setValueAt(cmb_vwcust_state.getSelectedItem(), selectRow, 5);
                            new Add_customer().cls(txt_vwcust_name, txt_vwcust_address1, txt_vwcust_address2, txt_vwcust_nic, txt_vwcust_nic, txt_vwcust_mobile, chk_vwcust_nic, cmb_vwcust_state);
                            txt_vwcust_id.setText(null);
                            enabled(txt_vwcust_name, txt_vwcust_address1, txt_vwcust_address2, txt_vwcust_mobile, cmb_vwcust_state, btn_vwcust_update, false);
                            btn_vwcust_edit.setEnabled(false);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Customer Detatils ALREDY EXITS");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_vwcust_updateActionPerformed

    private void txt_vwcust_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vwcust_nameKeyPressed

        new Add_customer().nextText(evt, txt_vwcust_address1);
    }//GEN-LAST:event_txt_vwcust_nameKeyPressed

    private void txt_vwcust_address1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vwcust_address1KeyPressed

        new Add_customer().nextText(evt, txt_vwcust_address2);
    }//GEN-LAST:event_txt_vwcust_address1KeyPressed

    private void txt_vwcust_address2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vwcust_address2KeyPressed

        if (txt_vwcust_nic.isEditable()) {
            new Add_customer().nextText(evt, txt_vwcust_nic);
        } else {
            new Add_customer().nextText(evt, txt_vwcust_mobile);
        }
    }//GEN-LAST:event_txt_vwcust_address2KeyPressed

    private void txt_vwcust_nicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vwcust_nicKeyPressed

        new Add_customer().nextText(evt, txt_vwcust_mobile);
    }//GEN-LAST:event_txt_vwcust_nicKeyPressed

    private void txt_vwcust_mobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vwcust_mobileKeyPressed

        if (evt.getKeyCode() == 10) {
            cmb_vwcust_state.grabFocus();
        }
    }//GEN-LAST:event_txt_vwcust_mobileKeyPressed

    private void txt_vwcust_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_vwcust_searchMouseClicked

        searchText();
    }//GEN-LAST:event_txt_vwcust_searchMouseClicked

    private void txt_vwcust_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vwcust_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_vwcust_searchActionPerformed

    private void txt_vwcust_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vwcust_searchKeyPressed

        if (evt.getKeyCode() == 10) {
            if (txt_vwcust_search.getText().isEmpty() || txt_vwcust_search.getText().equals("Enter Customer ID or Name")) {
                JOptionPane.showMessageDialog(this, "PLEASE enter a Customer ID or Name");
                new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Customer ID or Name", txt_vwcust_search);
            } else {
                search();
                if (tbl_vwcust.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "No Record Found");
                }
            }
        }
        if (evt.getKeyCode() == 8) {
            if (txt_vwcust_search.getText().isEmpty() || txt_vwcust_search.getText().equals("Enter Customer ID or Name")) {
                txt_vwcust_search.setText(null);
                txt_vwcust_search.setForeground(Color.BLACK);
                txt_vwcust_search.setFont(new java.awt.Font("Tahoma", 0, 14));
            }

        }
    }//GEN-LAST:event_txt_vwcust_searchKeyPressed

    private void txt_vwcust_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vwcust_nameKeyTyped

        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_vwcust_nameKeyTyped

    private void txt_vwcust_nicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vwcust_nicKeyTyped

        char c = evt.getKeyChar();
        if (!(c >= '0' & c <= '9')) {
            evt.consume();
        }
        if (txt_vwcust_nic.getText().length() > 9) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();

        }
    }//GEN-LAST:event_txt_vwcust_nicKeyTyped

    private void txt_vwcust_mobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vwcust_mobileKeyTyped

        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
            if (!txt_vwcust_mobile.getText().startsWith("0")) {
                evt.consume();
                JOptionPane.showMessageDialog(this, ui);
            }
        }
        if (txt_vwcust_mobile.getText().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_vwcust_mobileKeyTyped

    private void txt_vwcust_nicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vwcust_nicKeyReleased

        if (txt_vwcust_nic.getText().length() == 9) {
            txt_vwcust_nic.setText(txt_vwcust_nic.getText() + "v");
        }
    }//GEN-LAST:event_txt_vwcust_nicKeyReleased

    private void cmb_vwcust_stateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_vwcust_stateKeyPressed

        if (evt.getKeyCode() == 10) {
            if (btn_vwcust_update.isEnabled()) {
                btn_vwcust_updateActionPerformed(null);
                cmb_vwcust_state.hidePopup();
            }
        }
    }//GEN-LAST:event_cmb_vwcust_stateKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_vwcust_cancel;
    private javax.swing.JButton btn_vwcust_edit;
    private javax.swing.JButton btn_vwcust_refresh;
    private javax.swing.JButton btn_vwcust_search;
    private javax.swing.JButton btn_vwcust_update;
    private javax.swing.JCheckBox chk_vwcust_nic;
    private javax.swing.JComboBox cmb_vwcust_state;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JTable tbl_vwcust;
    private javax.swing.JTextField txt_vwcust_address1;
    private javax.swing.JTextField txt_vwcust_address2;
    private javax.swing.JTextField txt_vwcust_id;
    private javax.swing.JTextField txt_vwcust_mobile;
    private javax.swing.JTextField txt_vwcust_name;
    private javax.swing.JTextField txt_vwcust_nic;
    private javax.swing.JTextField txt_vwcust_search;
    // End of variables declaration//GEN-END:variables
void enabled(JTextField tx1, JTextField tx2, JTextField tx3, JTextField tx4, JComboBox cm, JButton bt1, Boolean b) {
        tx1.setEditable(b);
        tx2.setEditable(b);
        tx3.setEditable(b);
        tx4.setEditable(b);
        cm.setEnabled(b);
        bt1.setEnabled(b);

    }

    void searchText() {
        txt_vwcust_search.setFont(new java.awt.Font("Tahoma", 0, 14));
        txt_vwcust_search.setForeground(new java.awt.Color(0, 0, 0));
        txt_vwcust_search.setText(null);
    }

    String searchID() {
        if (txt_vwcust_search.getText().contentEquals("cus")) {
            String sId = txt_vwcust_search.getText();
            return sId;
        } else {
            String sName = txt_vwcust_search.getText();
            return sName;
        }
    }

    void search() {
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM customer WHERE cusid='" + searchID() + "' or name LIKE'%" + searchID() + "%' ");
            DefaultTableModel dtm = (DefaultTableModel) tbl_vwcust.getModel();
            if (!r.wasNull()) {
                new Add_customer().removeAllRow(tbl_vwcust);
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
                new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Customer ID or Name", txt_vwcust_search);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Customer ID or Name", txt_vwcust_search);
    }

}

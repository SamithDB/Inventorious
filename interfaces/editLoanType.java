package interfaces;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashith
 */
public class editLoanType extends javax.swing.JFrame {
    
    public editLoanType() {
        initComponents();
        toCombo(cmb_lntype);
        icon();
    }
    boolean editMode = false;
    boolean previous = false;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_controll = new javax.swing.JPanel();
        btn_cancel = new javax.swing.JButton();
        btn_finish = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        pnl_ = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        lbl_ribbon = new javax.swing.JLabel();
        pnl_wzard = new javax.swing.JPanel();
        lbl_head = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        txt_loan_amount = new javax.swing.JTextField();
        lbl_guid = new javax.swing.JLabel();
        cmb_lntype = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Loan Type");
        setAlwaysOnTop(true);
        setIconImages(null);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_finish.setText("Finish");
        btn_finish.setEnabled(false);
        btn_finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finishActionPerformed(evt);
            }
        });

        btn_next.setText("Edit");
        btn_next.setEnabled(false);
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_delete.setText("Previous");
        btn_delete.setEnabled(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_controllLayout = new javax.swing.GroupLayout(pnl_controll);
        pnl_controll.setLayout(pnl_controllLayout);
        pnl_controllLayout.setHorizontalGroup(
            pnl_controllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_controllLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_finish, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_controllLayout.setVerticalGroup(
            pnl_controllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_controllLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_controllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_finish)
                    .addComponent(btn_next)
                    .addComponent(btn_delete))
                .addContainerGap())
        );

        getContentPane().add(pnl_controll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 341, 500, 50));

        pnl_.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/coin-us-dollar.png"))); // NOI18N
        pnl_.add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        lbl_ribbon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/back.png"))); // NOI18N
        pnl_.add(lbl_ribbon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 350));

        getContentPane().add(pnl_, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnl_wzard.setBackground(new java.awt.Color(255, 255, 255));

        lbl_head.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lbl_head.setText("<html><b>Wizard</b><br>Edit Loan Category</html>");

        lbl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl1.setText("Select Loan Type");

        lbl2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl2.setText("<html>Enter Maximum Amount<b> (Rs:)</b></html>");

        txt_loan_amount.setEditable(false);
        txt_loan_amount.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_loan_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_loan_amountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_loan_amountKeyTyped(evt);
            }
        });

        lbl_guid.setText("To Edit,Select Loan Type");

        cmb_lntype.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_lntype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_lntypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_wzardLayout = new javax.swing.GroupLayout(pnl_wzard);
        pnl_wzard.setLayout(pnl_wzardLayout);
        pnl_wzardLayout.setHorizontalGroup(
            pnl_wzardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_wzardLayout.createSequentialGroup()
                .addGroup(pnl_wzardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmb_lntype, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_wzardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_wzardLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lbl_head, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnl_wzardLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(pnl_wzardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl1)
                                .addComponent(lbl_guid)))
                        .addGroup(pnl_wzardLayout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(txt_loan_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        pnl_wzardLayout.setVerticalGroup(
            pnl_wzardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_wzardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_head, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmb_lntype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_loan_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(lbl_guid)
                .addContainerGap())
        );

        getContentPane().add(pnl_wzard, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 370, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        
        if (!editMode) {
            txt_loan_amount.setEditable(true);
            txt_loan_amount.grabFocus();
            btn_next.setText("Next");
            btn_delete.setEnabled(false);
            lbl_guid.setText("To Countinue,Click Next");
            editMode = true;
            
        } else {
            if (txt_loan_amount.getText().isEmpty()) {
                lbl2.setForeground(Color.red);
            } else {
                cmb_lntype.setEnabled(false);
                txt_loan_amount.setEnabled(false);
                btn_next.setEnabled(false);
                btn_finish.setEnabled(true);
                lbl_guid.setText("To Update,Click Finish");
                btn_delete.setText("Previous");
                btn_delete.setEnabled(true);
                previous = true;
            }
        }
        
    }//GEN-LAST:event_btn_nextActionPerformed

    private void txt_loan_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loan_amountKeyTyped
        
        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_loan_amountKeyTyped

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        
        cmb_lntype.setSelectedItem("Select");
        cmb_lntype.setEnabled(true);
        txt_loan_amount.setEnabled(true);
        editMode = false;
        previous = false;

    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finishActionPerformed
        
        if (equals()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Loan Category Alredy Added", "Loan Type", JOptionPane.WARNING_MESSAGE);
        } else {
            upDateDB();
        }
    }//GEN-LAST:event_btn_finishActionPerformed

    private void cmb_lntypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_lntypeActionPerformed
        
        if (cmb_lntype.getSelectedItem().equals("Select")) {
            txt_loan_amount.setText(null);
            btn_next.setEnabled(false);
            btn_delete.setEnabled(false);
            txt_loan_amount.setEditable(false);
            btn_next.setText("Edit");
            btn_finish.setEnabled(false);
            lbl_guid.setText("To Edit,Select Loan Category");
            btn_delete.setEnabled(false);
        } else {
            try {
                ResultSet r = new JDBC().getData("SELECT amount FROM loantype WHERE type LIKE'" + cmb_lntype.getSelectedItem() + "' ");
                if (r.next()) {
                    txt_loan_amount.setText(String.valueOf(r.getDouble("amount")));
                    btn_next.setEnabled(true);
                    lbl_guid.setText("To Edit,Click Edit");
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_cmb_lntypeActionPerformed

    private void txt_loan_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loan_amountKeyReleased

        lbl2.setForeground(Color.black);
    }//GEN-LAST:event_txt_loan_amountKeyReleased

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed

        if (previous) {
            previous = false;
            btn_delete.setText("Previous");
            cmb_lntype.setEnabled(true);
            txt_loan_amount.setEnabled(true);
            btn_next.setEnabled(true);
            btn_finish.setEnabled(false);
            lbl_guid.setText("To Countinue,Click Next");
           // btn_delete.setEnabled(false);
        } else {
            
        }

    }//GEN-LAST:event_btn_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(editLoanType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editLoanType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editLoanType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editLoanType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editLoanType().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_finish;
    private javax.swing.JButton btn_next;
    private javax.swing.JComboBox cmb_lntype;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl_guid;
    private javax.swing.JLabel lbl_head;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_ribbon;
    private javax.swing.JPanel pnl_;
    private javax.swing.JPanel pnl_controll;
    private javax.swing.JPanel pnl_wzard;
    private javax.swing.JTextField txt_loan_amount;
    // End of variables declaration//GEN-END:variables
void toCombo(JComboBox cm) {
        try {
            ResultSet r = new JDBC().getData("SELECT type FROM loantype");
            Vector v = new Vector();
            //v.add("Select");
            while (r.next()) {                
                v.add(r.getString("type"));
            }
            cm.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean equals() {
        double amount = Double.valueOf(txt_loan_amount.getText());
        boolean value = false;
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM loantype WHERE amount='" + amount + "'  ");
            if (r.next()) {
                value = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }        

    void upDateDB() {
        try {
            new JDBC().putData("UPDATE loantype WHERE type='" + cmb_lntype.getSelectedItem() + "' ");
            JOptionPane.showMessageDialog(this, "Loan Category Has UPDATED", "Loan Type", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void icon(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/buildpc/payimage/tools.png"));
        Image image = icon.getImage();
        setIconImage(image);
    }
    
    
    
    
}

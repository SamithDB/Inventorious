package interfaces;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Hashith
 */
public class maxHalf extends javax.swing.JFrame {

    /**
     * Creates new form maxOT
     */
    public maxHalf() {
        initComponents();
        new pay_loan().setToCombo(cmb_empid, "SELECT empid FROM rate");
    }
    boolean editMode = false;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btn_cancell = new javax.swing.JButton();
        btn_finish = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmb_empid = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        spn_days = new javax.swing.JSpinner();
        lbl0 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_cancell.setText("Cancel");

        btn_finish.setText("Finish");
        btn_finish.setEnabled(false);
        btn_finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finishActionPerformed(evt);
            }
        });

        btn_next.setText("Next");
        btn_next.setEnabled(false);
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_prev.setText("Previous");
        btn_prev.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btn_cancell, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(btn_prev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_finish, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancell)
                    .addComponent(btn_finish)
                    .addComponent(btn_next)
                    .addComponent(btn_prev))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 337, 500, 60));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/back.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/calendar-96.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 390));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setText("<html><b>Wizard</b><br>Set Monthly Short Leaves Count</html>");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Select Employee ID");

        cmb_empid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_empidActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Maximum Days For Month");

        spn_days.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spn_days.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        lbl0.setText("Select an Empid, To Set/Edit OT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmb_empid, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_days, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl0, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmb_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spn_days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(lbl0)
                .addGap(38, 38, 38))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 390, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed

        if (editMode) {
            spn_days.setEnabled(true);
            lbl0.setText("To Save, Click Finish");
            btn_finish.setEnabled(true);
            btn_next.setEnabled(false);
        } else {
            btn_next.setText("Next");
            btn_next.setEnabled(true);
            spn_days.setEnabled(false);
            btn_next.setEnabled(false);
            btn_finish.setEnabled(true);
            lbl0.setText("To Save, Click Finish");
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void cmb_empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_empidActionPerformed

        editMode = false;
        if (cmb_empid.getSelectedItem().equals("Select")) {
            spn_days.setValue(0);
            btn_finish.setEnabled(false);
            btn_next.setEnabled(false);
            btn_prev.setEnabled(false);
            btn_next.setText("Next");
            lbl0.setText("Select an Empid, To Set/Edit OT");
            spn_days.setEnabled(false);
            editMode = false;
        } else {
            try {
                ResultSet r = new JDBC().getData("SELECT max_shrt FROM maxShort WHERE empid='" + cmb_empid.getSelectedItem() + "' ");
                if (r.next()) {
                    lbl0.setText("To Edit, Click Edit");
                    spn_days.setValue(r.getDouble("max_shrt"));
                    spn_days.setEnabled(false);
                    btn_next.setEnabled(true);
                    btn_finish.setEnabled(false);
                    btn_next.setText("Edit");
                    editMode = true;
                } else {
                    int ms = JOptionPane.showConfirmDialog(this, "No Record Available For " + cmb_empid.getSelectedItem() + " Please Add ", "O/T Hour", JOptionPane.YES_NO_OPTION);
                    if (ms == 0) {
                        lbl0.setText("To Countinue, Click Next");
                        spn_days.setValue(0);
                        btn_next.setText("Next");
                        btn_next.setEnabled(true);
                        spn_days.setEnabled(true);
                        btn_finish.setEnabled(false);
                        editMode = false;
                    } else {
                        btn_next.setText("Next");
                        btn_next.setEnabled(false);
                        btn_finish.setEnabled(false);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_cmb_empidActionPerformed

    private void btn_finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finishActionPerformed

        if (editMode) {
            updateLog();
        } else {
            setToLog();
        }
    }//GEN-LAST:event_btn_finishActionPerformed

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
            java.util.logging.Logger.getLogger(maxHalf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(maxHalf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(maxHalf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(maxHalf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new maxHalf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancell;
    private javax.swing.JButton btn_finish;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JComboBox cmb_empid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl0;
    private javax.swing.JSpinner spn_days;
    // End of variables declaration//GEN-END:variables
void updateLog() {
        try {
            new JDBC().putData("UPDATE maxShort SET max_shrt='" + spn_days.getValue() + "' WHERE empid='" + cmb_empid.getSelectedItem() + "' ");
            this.dispose();
        } catch (Exception e) {
        }
    }

    void setToLog() {
        try {
            new JDBC().putData("INSERT INTO maxShort VALUES ('" + cmb_empid.getSelectedItem() + "','" + spn_days.getValue() + "') ");
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

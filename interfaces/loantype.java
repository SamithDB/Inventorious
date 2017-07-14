package interfaces;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.ModernBalloonStyle;

/**
 *
 * @author Hashith
 */
public class loantype extends javax.swing.JFrame {

    public loantype() {
        initComponents();
        nextID();
        icon();

    }

    String type = "";
    double amount = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_controll = new javax.swing.JPanel();
        btn_cancel = new javax.swing.JButton();
        btn_finish = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_previous = new javax.swing.JButton();
        pnl_ = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        lbl_ribbon = new javax.swing.JLabel();
        pnl_wzard = new javax.swing.JPanel();
        lbl_head = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        txt_loanType = new javax.swing.JTextField();
        txt_loan_amount = new javax.swing.JTextField();
        lbl_guid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Loan Type");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
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

        btn_next.setText("Next");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_previous.setText("Previous");
        btn_previous.setEnabled(false);
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
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
                .addComponent(btn_previous, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btn_previous))
                .addContainerGap())
        );

        getContentPane().add(pnl_controll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 338, 500, 50));

        pnl_.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/coin-us-dollar.png"))); // NOI18N
        pnl_.add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        lbl_ribbon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/back.png"))); // NOI18N
        pnl_.add(lbl_ribbon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 340));

        getContentPane().add(pnl_, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnl_wzard.setBackground(new java.awt.Color(255, 255, 255));

        lbl_head.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lbl_head.setText("<html><b>Wizard</b><br>Add New Loan Category</html>");

        lbl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl1.setText("Enter Loan Type");

        lbl2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl2.setText("<html>Enter Maximum Amount<b> (Rs:)</b></html>");

        txt_loanType.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_loanType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_loanTypeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_loanTypeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_loanTypeKeyTyped(evt);
            }
        });

        txt_loan_amount.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_loan_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_loan_amountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_loan_amountKeyTyped(evt);
            }
        });

        lbl_guid.setText("To Continue, Click Next");

        javax.swing.GroupLayout pnl_wzardLayout = new javax.swing.GroupLayout(pnl_wzard);
        pnl_wzard.setLayout(pnl_wzardLayout);
        pnl_wzardLayout.setHorizontalGroup(
            pnl_wzardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_wzardLayout.createSequentialGroup()
                .addGroup(pnl_wzardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_loanType, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_loanType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_loan_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(lbl_guid)
                .addContainerGap())
        );

        getContentPane().add(pnl_wzard, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 370, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed

        if (!txt_loanType.getText().isEmpty()) {
            if (!txt_loan_amount.getText().isEmpty()) {
                type = txt_loanType.getText();
                amount = Double.valueOf(txt_loan_amount.getText());
                btn_next.setEnabled(false);
                btn_previous.setEnabled(true);
                btn_finish.setEnabled(true);
                txt_loan_amount.setEnabled(false);
                txt_loanType.setEnabled(false);
                lbl_guid.setText("To Save New Category, Click Finish");
            }else{
                lbl2.setForeground(Color.red);
            }
        }else{
            lbl1.setForeground(Color.RED);
        }

    }//GEN-LAST:event_btn_nextActionPerformed

    private void txt_loanTypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loanTypeKeyTyped

        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_loanTypeKeyTyped

    private void txt_loan_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loan_amountKeyTyped

        String msg = "<html><b>Please Enter<u>Appropriate Amount</u></b></html>";
        ModernBalloonStyle style = new ModernBalloonStyle(10, 10, new java.awt.Color(125, 125, 125), new java.awt.Color(150, 150, 150), Color.BLUE);
        BalloonTip tip = new BalloonTip(txt_loan_amount, msg, style, false);

        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }

        if (txt_loan_amount.getText().length() >= 5) {
            tip.setVisible(true);
        } else {
            tip.setVisible(false);
        }
    }//GEN-LAST:event_txt_loan_amountKeyTyped

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed

        btn_next.setEnabled(true);
        btn_finish.setEnabled(false);
        btn_previous.setEnabled(false);
        txt_loan_amount.setText(null);
        txt_loanType.setText(null);
        txt_loan_amount.setEnabled(true);
        txt_loanType.setEnabled(true);
        lbl_guid.setText("To Continue, Click Next");
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousActionPerformed

        txt_loan_amount.setEnabled(true);
        txt_loanType.setEnabled(true);
        btn_next.setEnabled(true);
        btn_finish.setEnabled(false);
        btn_previous.setEnabled(false);
        lbl_guid.setText("To Continue, Click Next");
    }//GEN-LAST:event_btn_previousActionPerformed

    private void btn_finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finishActionPerformed

        if (equals()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Loan Category Alredy Added", "Loan Type", JOptionPane.WARNING_MESSAGE);
        } else {
            setToDb();
            JOptionPane.showMessageDialog(this, "New Loan Category Added", "Wizard", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }

    }//GEN-LAST:event_btn_finishActionPerformed

    private void txt_loanTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loanTypeKeyPressed

        if (evt.getKeyCode()==10) {
            txt_loan_amount.grabFocus();
        }
    }//GEN-LAST:event_txt_loanTypeKeyPressed

    private void txt_loanTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loanTypeKeyReleased

        lbl1.setForeground(Color.black);
    }//GEN-LAST:event_txt_loanTypeKeyReleased

    private void txt_loan_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loan_amountKeyReleased

        lbl2.setForeground(Color.black);
    }//GEN-LAST:event_txt_loan_amountKeyReleased

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
            java.util.logging.Logger.getLogger(loantype.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loantype.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loantype.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loantype.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loantype().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_finish;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl_guid;
    private javax.swing.JLabel lbl_head;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_ribbon;
    private javax.swing.JPanel pnl_;
    private javax.swing.JPanel pnl_controll;
    private javax.swing.JPanel pnl_wzard;
    private javax.swing.JTextField txt_loanType;
    private javax.swing.JTextField txt_loan_amount;
    // End of variables declaration//GEN-END:variables
String nextID() {
        String id = "";
        try {
            ResultSet r = new JDBC().getData("SELECT MAX(id)+1 AS newid FROM loantype");
            if (r.next()) {
                id = r.getString("newid");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    void setToDb() {
        try {
            new JDBC().putData("INSERT INTO loantype VALUES('" + nextID() + "','" + type + "','" + amount + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean equals() {
        boolean value = false;
        try {
            ResultSet r = new JDBC().getData("SELECT type from loantype WHERE type LIKE'" + txt_loanType.getText() + "' ");
            if (r.next()) {
                value = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    void icon(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/buildpc/payimage/tools.png"));
        Image image = icon.getImage();
        setIconImage(image);
    }
    
    
    
    
    
    
}

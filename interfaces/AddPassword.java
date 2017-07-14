/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.RoundedBalloonStyle;
import net.java.balloontip.utils.TimingUtils;

/**
 *
 * @author Thusitha
 */
public class AddPassword extends javax.swing.JInternalFrame {

    /**
     * Creates new form addlevel
     */
    public AddPassword() {
        initComponents();
        btnNext.setEnabled(false);
    }
    public AddPassword(String pass,String hint){
        initComponents();
        txtUsername.setText(Home.addUser.get("Username").toString());
        passPassword.setText(pass);
        passConfirm.setText(pass);
        txtHint.setText(hint);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lblChangeImage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passPassword = new javax.swing.JPasswordField();
        passConfirm = new javax.swing.JPasswordField();
        txtHint = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblChangeImage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblChangeImage.setText("Add Username & Password");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Password");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Confirm Password");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Hint");

        passPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passPasswordKeyPressed(evt);
            }
        });

        passConfirm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passConfirm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passConfirmFocusLost(evt);
            }
        });
        passConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passConfirmKeyPressed(evt);
            }
        });

        txtHint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Username");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(txtHint)
                    .addComponent(passConfirm)
                    .addComponent(txtUsername))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(passPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(239, Short.MAX_VALUE))
        );

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblChangeImage)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(14, 14, 14)
                        .addComponent(btnNext)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblChangeImage)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnNext)
                    .addComponent(btnBack))
                .addContainerGap())
        );

        setBounds(379, 0, 608, 554);
    }// </editor-fold>//GEN-END:initComponents

    RoundedBalloonStyle style = new RoundedBalloonStyle(10, 8, Color.yellow, Color.yellow);
    private void passPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passPasswordKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (String.valueOf(passPassword.getPassword()).length()>6) {
                passConfirm.grabFocus();
            }else{
                BalloonTip tip = new BalloonTip(passPassword, "Please enter more than 6 characters", style, false);
                tip.setVisible(true);
                TimingUtils.showTimedBalloon(tip, 3000);
            }
        }
        
    }//GEN-LAST:event_passPasswordKeyPressed

    private void passConfirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passConfirmKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (String.valueOf(passConfirm.getPassword()).equals(String.valueOf(passPassword.getPassword()))) {
                btnNext.setEnabled(true);
                btnNext.grabFocus();
            }else{
                passConfirm.grabFocus();
                BalloonTip tip = new BalloonTip(passConfirm, "Password not mach. Please try again", style, false);
                tip.setVisible(true);
                TimingUtils.showTimedBalloon(tip, 3000);
            }
        }
    }//GEN-LAST:event_passConfirmKeyPressed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        if (String.valueOf(passConfirm.getPassword()).equals(String.valueOf(passPassword.getPassword()))) {
            Home.addUser.put("Username", txtUsername.getText());
            Home.addUser.put("Password", String.valueOf(passConfirm.getPassword()));
            Home.addUser.put("Tip", txtHint.getText());
            this.dispose();
            AddLevel level = new AddLevel();
            Home.jDesktopPane2.add(level);
            level.setVisible(true);
        } else {
            passConfirm.grabFocus();
            BalloonTip tip = new BalloonTip(passConfirm, "Password not mach. Please try again", style, false);
            tip.setVisible(true);
            TimingUtils.showTimedBalloon(tip, 3000);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void passConfirmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passConfirmFocusLost

        if (String.valueOf(passConfirm.getPassword()).equals(String.valueOf(passPassword.getPassword()))) {
            btnNext.setEnabled(true);
            btnNext.grabFocus();
        } else {
            passConfirm.grabFocus();
            BalloonTip tip = new BalloonTip(passConfirm, "Password not mach. Please try again", style, false);
            tip.setVisible(true);
            TimingUtils.showTimedBalloon(tip, 3000);
        }
    }//GEN-LAST:event_passConfirmFocusLost

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        AddUser user = new AddUser(Home.addUser.get("EmpID").toString());
        Home.jDesktopPane2.add(user);
        user.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        int i = JOptionPane.showConfirmDialog(this, "Do you want to cancel?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
        if (i==0) {
            this.dispose();
            Home.addUser.clear();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                ResultSet r = new JDBC().getData("SELECT * FROM user WHERE userName='"+txtUsername.getText()+"'");
                if (r.next()) {
                    BalloonTip tip = new BalloonTip(txtUsername, "Username is already exists. Please choose another one.", style, false);
                    tip.setVisible(true);
                    TimingUtils.showTimedBalloon(tip, 3000);
                    
                }else{
                    passPassword.grabFocus();
                    Home.addUser.put("Username", txtUsername.getText());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txtUsernameKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblChangeImage;
    private javax.swing.JPasswordField passConfirm;
    private javax.swing.JPasswordField passPassword;
    private javax.swing.JTextField txtHint;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
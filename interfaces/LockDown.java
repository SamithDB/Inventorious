/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import com.sun.java.swing.plaf.windows.WindowsPasswordFieldUI;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.RoundedBalloonStyle;
import net.java.balloontip.utils.TimingUtils;

/**
 *
 * @author Thusitha
 */
public class LockDown extends javax.swing.JFrame {

    /**
     * Creates new form LockDown
     */
    public LockDown() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 150));
        this.setSize(1366, 768);
        getAdmin();
        passFieldAdminPass.setVisible(false);
        btnHome.setVisible(false);
        btnUnlock.setVisible(false);
        passFieldAdminPass.setUI(new WindowsPasswordFieldUI());
//        passFieldAdminPass.setBorder(new RoundedCornerBorder());

    }

    RoundedBalloonStyle style = new RoundedBalloonStyle(15, 7, Color.yellow, Color.yellow);

    public void getAdmin() {
        Vector v = new Vector();
        v.add("Select admin user");
        v.add("Olympus");
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM user WHERE level='admin'");
            while (r.next()) {
                v.add(r.getString("userName"));
            }
            cmbboxAdminUser.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbboxAdminUser = new javax.swing.JComboBox();
        passFieldAdminPass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnUnlock = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 10, 200));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login/admin.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 128, 128));

        cmbboxAdminUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbboxAdminUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbboxAdminUserActionPerformed(evt);
            }
        });
        getContentPane().add(cmbboxAdminUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 260, -1));

        passFieldAdminPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(passFieldAdminPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 260, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Administrator Login");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Admin");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, -1, -1));

        btnUnlock.setText("Unlock");
        btnUnlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnlockActionPerformed(evt);
            }
        });
        getContentPane().add(btnUnlock, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, 210, 40));

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login/lockdown.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 225, 592, 285));

        lblMessage.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 255, 255));
        lblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1370, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 592, 293));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbboxAdminUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbboxAdminUserActionPerformed

        if (cmbboxAdminUser.getSelectedIndex() == 0) {
            ImageIcon ii = new ImageIcon(getClass().getResource("/images/login/Admin.png"));
            ii.getImage();
            jLabel3.setIcon(ii);
            passFieldAdminPass.setVisible(false);
            btnHome.setVisible(false);
            btnUnlock.setVisible(false);

        } else {
            setImage();
            passFieldAdminPass.setVisible(true);
            btnHome.setVisible(false);
            btnUnlock.setVisible(true);
        }
    }//GEN-LAST:event_cmbboxAdminUserActionPerformed

    Configs con = new Configs();
    BufferedImage image = null;

    public void setImage() {
        try {
            image = ImageIO.read(new File(con.getProp(cmbboxAdminUser.getSelectedItem().toString())));
            ImageIcon ii = new ImageIcon(ScaledImage(image, jLabel3.getWidth(), jLabel3.getHeight()));
            jLabel3.setIcon(ii);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Image ScaledImage(Image img, int w, int h) {

        BufferedImage resizedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, w, h, null);
        g2.dispose();
        return resizedImage;

    }
    private void btnUnlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnlockActionPerformed

        loginToSystem("Unlock");
        System.out.println("Count of user attempts"+login.count);
        login.count=0;

    }//GEN-LAST:event_btnUnlockActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed

        loginToSystem("Home");
        login.count=0;
    }//GEN-LAST:event_btnHomeActionPerformed

    void loginToSystem(String button) {
        if (passFieldAdminPass.getPassword().equals("")) {
            BalloonTip tip = new BalloonTip(passFieldAdminPass, "Please type the password", style, false);
            tip.setVisible(true);
            TimingUtils.showTimedBalloon(tip, 3000);
        } else if (cmbboxAdminUser.getSelectedItem().equals("Olympus") && String.valueOf(passFieldAdminPass.getPassword()).equals("123")) {

            if (button.equals("Home")) {
                Home.userName = "Olympus";
                Home.level = "admin";
                Home.password = "123";

                Home home = new Home();
                home.setVisible(true);
                BuildPC.log.dispose();
                this.dispose();
            } else {
                this.dispose();
            }
        } else {
            try {
                ResultSet r = new JDBC().getData("SELECT * FROM user WHERE userName='" + cmbboxAdminUser.getSelectedItem() + "'");
                if (r.first()) {
                    String user = r.getString("userName");
                    String pass = r.getString("passWord");
                    if (user.equals(cmbboxAdminUser.getSelectedItem()) && pass.equals(String.valueOf(passFieldAdminPass.getPassword()))) {

                        if (button.equals("Home")) {
                            Home.userName = r.getString("userName");
                            Home.level = r.getString("level");
                            Home.password = String.valueOf(passFieldAdminPass.getPassword());

                            Home home = new Home();
                            home.setVisible(true);
                            BuildPC.log.dispose();
                            this.dispose();

                        } else {
                            this.dispose();
                        }
                    } else {
                        BalloonTip tip = new BalloonTip(passFieldAdminPass, "Password is wrong. Please try again.", style, false);
                        tip.setVisible(true);
                        TimingUtils.showTimedBalloon(tip, 3000);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

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
            java.util.logging.Logger.getLogger(LockDown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LockDown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LockDown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LockDown.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LockDown().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnUnlock;
    private javax.swing.JComboBox cmbboxAdminUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lblMessage;
    private javax.swing.JPasswordField passFieldAdminPass;
    // End of variables declaration//GEN-END:variables
}

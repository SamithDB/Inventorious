/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;

/**
 *
 * @author Thusitha
 */
public class userMenu extends javax.swing.JPanel {

    /**
     * Creates new form userMenu
     */
    public userMenu() {
        initComponents();
        lblUsername.setText(Home.userName);
        lblUserLevel.setText(Home.level);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblUserLevel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblOp1 = new javax.swing.JLabel();
        lblOp2 = new javax.swing.JLabel();
        lblOp3 = new javax.swing.JLabel();
        lblOp4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/desktop/user.png"))); // NOI18N

        lblUsername.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("jLabel2");

        lblUserLevel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblUserLevel.setForeground(new java.awt.Color(255, 255, 255));
        lblUserLevel.setText("jLabel3");

        lblOp1.setBackground(new java.awt.Color(51, 51, 51));
        lblOp1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblOp1.setForeground(new java.awt.Color(255, 255, 255));
        lblOp1.setText("Change Password");
        lblOp1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOp1.setOpaque(true);
        lblOp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOp1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOp1MouseExited(evt);
            }
        });

        lblOp2.setBackground(new java.awt.Color(51, 51, 51));
        lblOp2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblOp2.setForeground(new java.awt.Color(255, 255, 255));
        lblOp2.setText("Switch User");
        lblOp2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOp2.setOpaque(true);
        lblOp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOp2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOp2MouseExited(evt);
            }
        });

        lblOp3.setBackground(new java.awt.Color(51, 51, 51));
        lblOp3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblOp3.setForeground(new java.awt.Color(255, 255, 255));
        lblOp3.setText("Log Off");
        lblOp3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOp3.setOpaque(true);
        lblOp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOp3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOp3MouseExited(evt);
            }
        });

        lblOp4.setBackground(new java.awt.Color(51, 51, 51));
        lblOp4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblOp4.setForeground(new java.awt.Color(255, 255, 255));
        lblOp4.setText("Add new user");
        lblOp4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOp4.setOpaque(true);
        lblOp4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOp4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOp4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOp4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(lblUserLevel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblOp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblOp2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(lblOp3, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(lblOp4, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblUsername)
                        .addGap(18, 18, 18)
                        .addComponent(lblUserLevel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(lblOp4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblOp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp1MouseEntered

        lblOp1.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_lblOp1MouseEntered

    private void lblOp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp1MouseExited

        lblOp1.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblOp1MouseExited

    private void lblOp2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp2MouseEntered
        
        lblOp2.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_lblOp2MouseEntered

    private void lblOp2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp2MouseExited
        
        lblOp2.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblOp2MouseExited

    private void lblOp3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp3MouseEntered
        
        lblOp3.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_lblOp3MouseEntered

    private void lblOp3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp3MouseExited
        
        lblOp3.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblOp3MouseExited

    private void lblOp4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp4MouseEntered
        
        lblOp4.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_lblOp4MouseEntered

    private void lblOp4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp4MouseExited
        
        lblOp4.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblOp4MouseExited

    private void lblOp4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp4MouseClicked

        Home.jDesktopPane2.remove(Home.usermenu);
        Home.jDesktopPane2.repaint();
        
        lblOp4.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblOp4MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblOp1;
    private javax.swing.JLabel lblOp2;
    private javax.swing.JLabel lblOp3;
    private javax.swing.JLabel lblOp4;
    private javax.swing.JLabel lblUserLevel;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}

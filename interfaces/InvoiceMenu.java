/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.awt.Color;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.RoundedBalloonStyle;

/**
 *
 * @author Thusitha
 */
public class InvoiceMenu extends javax.swing.JPanel {

    /**
     * Creates new form InvoiceMenu
     */
    RoundedBalloonStyle style = new RoundedBalloonStyle(10, 7, Color.black, Color.black);
    BalloonTip tip = null;
    public InvoiceMenu() {
        initComponents();
        
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
        lblOp2 = new javax.swing.JLabel();
        lblOp1 = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();

        lblOp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/check_book-64.png"))); // NOI18N
        lblOp2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOp2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOp2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOp2MouseExited(evt);
            }
        });

        lblOp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/invoice-64.png"))); // NOI18N
        lblOp1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOp1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblOp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOp1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOp1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOp1MouseExited(evt);
            }
        });

        lbltitle.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        lbltitle.setText("Invoice");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltitle)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(lblOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitle)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(307, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblOp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp2MouseClicked
        Invoice i=new Invoice();
        Home.jDesktopPane2.add(i);
        i.setVisible(true);
    }//GEN-LAST:event_lblOp2MouseClicked

    private void lblOp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp1MouseClicked

        Invoice_details i=new Invoice_details();
        Home.jDesktopPane2.add(i);
        i.setVisible(true);
    }//GEN-LAST:event_lblOp1MouseClicked

    private void lblOp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp1MouseEntered
        tip = new BalloonTip(lblOp1, "<html><font style='color:white;'>View Invoice</font></html>", style, false);
        tip.setVisible(true);
    }//GEN-LAST:event_lblOp1MouseEntered

    private void lblOp2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp2MouseEntered
        tip = new BalloonTip(lblOp2, "<html><font style='color:white;'>New Invoice</font></html>", style, false);
        tip.setVisible(true); 
    }//GEN-LAST:event_lblOp2MouseEntered

    private void lblOp2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp2MouseExited
         tip.setVisible(false);
    }//GEN-LAST:event_lblOp2MouseExited

    private void lblOp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp1MouseExited
         tip.setVisible(false);
    }//GEN-LAST:event_lblOp1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblOp1;
    private javax.swing.JLabel lblOp2;
    private javax.swing.JLabel lbltitle;
    // End of variables declaration//GEN-END:variables
}
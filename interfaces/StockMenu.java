/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import static com.alee.managers.notification.NotificationIcon.tip;
import java.awt.Color;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.RoundedBalloonStyle;
import net.java.balloontip.utils.TimingUtils;

/**
 *
 * @author Thusitha
 */
public class StockMenu extends javax.swing.JPanel {

    /**
     * Creates new form StockMenu
     */
    public StockMenu() {
        initComponents();
    }
    RoundedBalloonStyle style = new RoundedBalloonStyle(10, 7, Color.black, Color.black);
    BalloonTip tip = null;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOp1 = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        lblOp3 = new javax.swing.JLabel();
        lblOp2 = new javax.swing.JLabel();
        lblOp5 = new javax.swing.JLabel();
        lblOp4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        lblOp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-64.png"))); // NOI18N
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
        lbltitle.setText("Stock");

        lblOp3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document-64.png"))); // NOI18N
        lblOp3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOp3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOp3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOp3MouseExited(evt);
            }
        });

        lblOp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_box-64.png"))); // NOI18N
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

        lblOp5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return-64.png"))); // NOI18N
        lblOp5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOp5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOp5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOp5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOp5MouseExited(evt);
            }
        });

        lblOp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tag-64.png"))); // NOI18N
        lblOp4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                    .addComponent(lbltitle)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addComponent(lblOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(lblOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOp4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addComponent(lblOp5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(lblOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOp4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOp5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblOp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp1MouseClicked

        AddNewStockItems addNew = new AddNewStockItems();
        Home.jDesktopPane2.add(addNew);
        addNew.setVisible(true);
    }//GEN-LAST:event_lblOp1MouseClicked

    private void lblOp3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp3MouseClicked

        ViewGRN addNew = new ViewGRN();
        Home.jDesktopPane2.add(addNew);
        addNew.setVisible(true);
    }//GEN-LAST:event_lblOp3MouseClicked

    private void lblOp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp2MouseClicked

        ViewStock addNew = new ViewStock();
        Home.jDesktopPane2.add(addNew);
        addNew.setVisible(true);
    }//GEN-LAST:event_lblOp2MouseClicked

    private void lblOp5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp5MouseClicked

        ViewReturnedItems addNew = new ViewReturnedItems();
        Home.jDesktopPane2.add(addNew);
        addNew.setVisible(true);
    }//GEN-LAST:event_lblOp5MouseClicked

    private void lblOp4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp4MouseClicked

        ViewItems addNew = new ViewItems();
        Home.jDesktopPane2.add(addNew);
        addNew.setVisible(true);
    }//GEN-LAST:event_lblOp4MouseClicked

    private void lblOp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp1MouseEntered

       tip = new BalloonTip(lblOp1, "<html><font style='color:white;'>Add New Stock Items</font></html>", style, false);
        tip.setVisible(true); 
       
    }//GEN-LAST:event_lblOp1MouseEntered

    private void lblOp2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp2MouseEntered

        tip = new BalloonTip(lblOp2, "<html><font style='color:white;'>View Stock</font></html>", style, false);
        tip.setVisible(true);
    }//GEN-LAST:event_lblOp2MouseEntered

    private void lblOp3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp3MouseEntered
        tip = new BalloonTip(lblOp3, "<html><font style='color:white;'>View Good Received Notes</font></html>", style, false);
        tip.setVisible(true);
    }//GEN-LAST:event_lblOp3MouseEntered

    private void lblOp4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp4MouseEntered

        tip = new BalloonTip(lblOp4, "<html><font style='color:white;'>View Items</font></html>", style, false);
        tip.setVisible(true);
    }//GEN-LAST:event_lblOp4MouseEntered

    private void lblOp5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp5MouseEntered

        tip = new BalloonTip(lblOp5, "<html><font style='color:white;'>View Returned Items</font></html>", style, false);
        tip.setVisible(true);
    }//GEN-LAST:event_lblOp5MouseEntered

    private void lblOp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp1MouseExited

        tip.setVisible(false);
    }//GEN-LAST:event_lblOp1MouseExited

    private void lblOp2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp2MouseExited

        tip.setVisible(false);
    }//GEN-LAST:event_lblOp2MouseExited

    private void lblOp3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp3MouseExited

        tip.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_lblOp3MouseExited

    private void lblOp4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp4MouseExited

        tip.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_lblOp4MouseExited

    private void lblOp5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp5MouseExited

        tip.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_lblOp5MouseExited


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblOp1;
    private javax.swing.JLabel lblOp2;
    private javax.swing.JLabel lblOp3;
    private javax.swing.JLabel lblOp4;
    private javax.swing.JLabel lblOp5;
    private javax.swing.JLabel lbltitle;
    // End of variables declaration//GEN-END:variables
}

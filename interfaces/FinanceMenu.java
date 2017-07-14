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
public class FinanceMenu extends javax.swing.JPanel {

    /**
     * Creates new form FinanceMenu
     */
    public FinanceMenu() {
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

        lbltitle = new javax.swing.JLabel();
        lblOp1 = new javax.swing.JLabel();
        lblOp2 = new javax.swing.JLabel();
        lblOp3 = new javax.swing.JLabel();
        lblOp4 = new javax.swing.JLabel();
        lblOp5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblOp6 = new javax.swing.JLabel();

        lbltitle.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        lbltitle.setText("Finance");

        lblOp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/track-64.png"))); // NOI18N
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

        lblOp3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/handshake-64.png"))); // NOI18N
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

        lblOp4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/money_bag-64.png"))); // NOI18N
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

        lblOp5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/moneybox-64.png"))); // NOI18N
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

        lblOp6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/area_chart-64.png"))); // NOI18N
        lblOp6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOp6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOp6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOp6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOp6MouseExited(evt);
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
                                .addComponent(lblOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOp4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addComponent(lblOp5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOp6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(lblOp5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOp6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    RoundedBalloonStyle style = new RoundedBalloonStyle(10, 7, Color.black, Color.black);
    private void lblOp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp1MouseClicked

        FinanceSupPayment suppay = new FinanceSupPayment();
        Home.jDesktopPane2.add(suppay);
        suppay.setVisible(true);
    }//GEN-LAST:event_lblOp1MouseClicked

    private void lblOp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp2MouseClicked

        chequeBook cheque = new chequeBook();
        Home.jDesktopPane2.add(cheque);
        cheque.setVisible(true);
    }//GEN-LAST:event_lblOp2MouseClicked

    private void lblOp3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp3MouseClicked

        chequeTransaction trans = new chequeTransaction();
        Home.jDesktopPane2.add(trans);
        trans.setVisible(true);
    }//GEN-LAST:event_lblOp3MouseClicked

    private void lblOp4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp4MouseClicked

        CashBook cash = new CashBook();
        Home.jDesktopPane2.add(cash);
        cash.setVisible(true);
    }//GEN-LAST:event_lblOp4MouseClicked

    private void lblOp5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp5MouseClicked

        bankAccounts accounts = new bankAccounts();
        Home.jDesktopPane2.add(accounts);
        accounts.setVisible(true);
    }//GEN-LAST:event_lblOp5MouseClicked

    private void lblOp6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp6MouseClicked

        FinanceReports reports = new FinanceReports();
        Home.jDesktopPane2.add(reports);
        reports.setVisible(true);
    }//GEN-LAST:event_lblOp6MouseClicked
    BalloonTip tip = null;
    private void lblOp6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp6MouseEntered

        tip = new BalloonTip(lblOp6, "<html><font style='color:white;'>Reports</font></html>", style, false);
        tip.setVisible(true);
    }//GEN-LAST:event_lblOp6MouseEntered

    private void lblOp6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp6MouseExited

        tip.setVisible(false);

    }//GEN-LAST:event_lblOp6MouseExited

    private void lblOp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp1MouseEntered

        tip = new BalloonTip(lblOp1, "<html><font style='color:white;'>Supplier Payments</font></html>", style, false);
        tip.setVisible(true);
    }//GEN-LAST:event_lblOp1MouseEntered

    private void lblOp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp1MouseExited

        tip.setVisible(false);
    }//GEN-LAST:event_lblOp1MouseExited

    private void lblOp2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp2MouseEntered

        tip = new BalloonTip(lblOp2, "<html><font style='color:white;'>Cheque Book</font></html>", style, false);
        tip.setVisible(true);
    }//GEN-LAST:event_lblOp2MouseEntered

    private void lblOp2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp2MouseExited

        tip.setVisible(false);
    }//GEN-LAST:event_lblOp2MouseExited

    private void lblOp3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp3MouseEntered

        tip = new BalloonTip(lblOp3, "<html><font style='color:white;'>Cheque Transactions</font></html>", style, false);
        tip.setVisible(true);
    }//GEN-LAST:event_lblOp3MouseEntered

    private void lblOp3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp3MouseExited

        tip.setVisible(false);
    }//GEN-LAST:event_lblOp3MouseExited

    private void lblOp4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp4MouseEntered

        tip = new BalloonTip(lblOp4, "<html><font style='color:white;'>Cash Book</font></html>", style, false);
        tip.setVisible(true);
    }//GEN-LAST:event_lblOp4MouseEntered

    private void lblOp4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp4MouseExited

        tip.setVisible(false);
    }//GEN-LAST:event_lblOp4MouseExited

    private void lblOp5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp5MouseEntered

        tip = new BalloonTip(lblOp5, "<html><font style='color:white;'>Bank Accounts</font></html>", style, false);
        tip.setVisible(true);
    }//GEN-LAST:event_lblOp5MouseEntered

    private void lblOp5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOp5MouseExited

        tip.setVisible(false);
    }//GEN-LAST:event_lblOp5MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblOp1;
    private javax.swing.JLabel lblOp2;
    private javax.swing.JLabel lblOp3;
    private javax.swing.JLabel lblOp4;
    private javax.swing.JLabel lblOp5;
    private javax.swing.JLabel lblOp6;
    private javax.swing.JLabel lbltitle;
    // End of variables declaration//GEN-END:variables
}
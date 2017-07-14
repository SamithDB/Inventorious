/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thusitha
 */
public class cashBookUpdate extends javax.swing.JInternalFrame {

    /**
     * Creates new form cashBookUpdate
     */
    public cashBookUpdate() {
        super("Update Cash balance", false, true, false, true);
        initComponents();
        this.setLocation(350, -370);
        new Thread(new Runnable() {

            @Override
            public void run() {                
                try {
                    for (int i = -365; i < 0; i++) {
                        setLocation(350, i);
                    Thread.sleep(1);
                    }
                    Thread.currentThread().stop();
                } catch (InterruptedException ex) {
                    Logger.getLogger(cashBookUpdate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesciption = new javax.swing.JTextArea();
        txtAmount = new javax.swing.JFormattedTextField();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameDeactivated(evt);
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Update Cash Book");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Transaction Type");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Description");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Amount");

        cmbType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Select Type --", "Re-fund", "Income", "Expenses" }));
        cmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTypeActionPerformed(evt);
            }
        });

        txtDesciption.setColumns(20);
        txtDesciption.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtDesciption.setRows(5);
        txtDesciption.setEnabled(false);
        txtDesciption.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDesciptionKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtDesciption);

        txtAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        txtAmount.setEnabled(false);
        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountKeyPressed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/rename-32.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.setEnabled(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/save-32.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                            .addComponent(txtAmount)
                            .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnClear))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

                clear();
    }//GEN-LAST:event_btnClearActionPerformed

    public void clear(){
        cmbType.setSelectedIndex(0);
        txtDesciption.setText("");
        txtAmount.setText("");
        txtDesciption.setEnabled(false);
        txtAmount.setEnabled(false);
        cmbType.grabFocus();
        btnSave.setEnabled(false);
        btnClear.setEnabled(false);
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String s = sdf.format(d);
        
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM assets WHERE description='cash'");
            if(r.next()){
                double Currentamount = Double.parseDouble(r.getString("amount"));
                double amount = Double.parseDouble(String.valueOf(txtAmount.getValue()));
                if (cmbType.getSelectedIndex() == 3) {
                    if (Currentamount<amount) {
                        JOptionPane.showMessageDialog(this, "Sorry, Cash balance is not enough to pay this amount.");
                        clear();
                    }else{
                        Currentamount -=amount;
                        new JDBC().putData("INSERT INTO cashBook(date,description,type,amount,currentAmount) VALUES('"+s+"','"+txtDesciption.getText()+"','"+cmbType.getSelectedItem()+"','"+txtAmount.getValue()+"','"+Currentamount+"')");
                        new JDBC().putData("UPDATE assets SET amount='"+Currentamount+"' WHERE description='cash'");
                        clear();
                    }
                    
                }else if(cmbType.getSelectedIndex()==1 || cmbType.getSelectedIndex()==2){   
                    Currentamount += amount;
                    new JDBC().putData("INSERT INTO cashBook(date,description,type,amount,currentAmount) VALUES('"+s+"','"+txtDesciption.getText()+"','"+cmbType.getSelectedItem()+"','"+txtAmount.getValue()+"','"+Currentamount+"')");
                    new JDBC().putData("UPDATE assets SET amount='"+Currentamount+"' WHERE description='cash'");
                    clear();
                    
                }
            }else{
                if (cmbType.getSelectedIndex() == 3) {
                    JOptionPane.showMessageDialog(this, "Cash balance is over. Please re-fill the cash balance.");
                    clear();
                }else{
                    new JDBC().putData("INSERT INTO assets VALUES('ASET1','"+s+"','cash','"+txtAmount.getValue()+"')");
                    new JDBC().putData("INSERT INTO cashBook(date,description,type,amount,currentAmount) VALUES('"+s+"','"+txtDesciption.getText()+"','"+cmbType.getSelectedItem()+"','"+txtAmount.getValue()+"','"+txtAmount.getValue()+"')");
                    clear();
                    
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();      
            
        }
        CashBook.setTableData();
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed

        txtDesciption.setEnabled(true);
        txtDesciption.grabFocus();
    }//GEN-LAST:event_cmbTypeActionPerformed

    private void txtDesciptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDesciptionKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtAmount.setEnabled(true);
            txtAmount.grabFocus();
        }
    }//GEN-LAST:event_txtDesciptionKeyPressed

    private void txtAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSave.setEnabled(true);
            btnClear.setEnabled(true);
            btnSave.grabFocus();
        }
    }//GEN-LAST:event_txtAmountKeyPressed

    private void formInternalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeactivated

        closeWindow();
    }//GEN-LAST:event_formInternalFrameDeactivated

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

        closeWindow();
    }//GEN-LAST:event_formInternalFrameClosed

    public void closeWindow(){
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i > -356; i--) {
                        setLocation(350, i);
                        Thread.sleep(1);
                        if (i==-200) {
                            dispose();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Thread.currentThread().stop();
            }
        }).start();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField txtAmount;
    private javax.swing.JTextArea txtDesciption;
    // End of variables declaration//GEN-END:variables
}

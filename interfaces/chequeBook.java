/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Thusitha
 */
public class chequeBook extends javax.swing.JInternalFrame {

    /**
     * Creates new form chequeBook
     */
    public chequeBook() {
        super("Cheque Book", false, true, false, true);
        initComponents();
        bookDetails();
        accNo();
        btnPrint.setVisible(false);
    }
    
    public void clear(){
        txtChequeBookNo.setEnabled(false);
        txtFirstNo.setEnabled(false);
        txtLastNo.setEnabled(false);
        txtdate.setEnabled(false);
        txtLeavesAmount.setEnabled(false);
        btnClear.setEnabled(false);
        btnSave.setEnabled(false);
        btnPrint.setEnabled(false);
        
        txtChequeBookNo.setText("");
        txtFirstNo.setText("");
        txtLastNo.setText("");
        txtLeavesAmount.setText("");
        txtBankBranch.setText("");
        cmbboxAccNo.setSelectedIndex(0);
        txtBankName.setText("");
        txtBankTel.setText("");        
    }
    
    public void accNo(){
        try {
            ResultSet r = new JDBC().getData("SELECT accNo FROM bankAccount WHERE type='"+"Current"+"'");
            Vector v = new Vector();
            v.add("--Select Account Number--");
            while(r.next()){
                v.add(r.getString("accNo"));
            }
            cmbboxAccNo.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void bookDetails(){
        DefaultTableModel dtm = (DefaultTableModel) tblChequeInfo.getModel();
        int count = dtm.getRowCount();
        for (int i = 0; i < count; i++) {
            dtm.removeRow(0);
        }
        try {
            ResultSet r = new JDBC().getData("select CB.bookNo,CB.accNo,CB.date,count(CI.status) as count from chequeinfo CI,chequebook CB where CI.bookNo=CB.bookNo and CI.status='not issued' group by CI.bookNo");
            while(r.next()){
                Vector v = new Vector();
                v.add(r.getString("bookNo"));
                v.add(r.getString("accNo"));
                v.add(r.getString("date"));
                byte b = Byte.parseByte(r.getString("count"));
                if (b>=1) {
                    v.add(r.getString("count"));
                    
                }
                
                dtm.addRow(v);
                
            }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtChequeBookNo = new javax.swing.JTextField();
        txtFirstNo = new javax.swing.JTextField();
        txtLastNo = new javax.swing.JTextField();
        txtLeavesAmount = new javax.swing.JTextField();
        txtBankName = new javax.swing.JTextField();
        txtBankBranch = new javax.swing.JTextField();
        txtBankTel = new javax.swing.JTextField();
        txtdate = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChequeInfo = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer r,int rw,int col){
                Component c = super.prepareRenderer(r, rw, col);
                //        c.setBackground(Color.WHITE);

                if (!isRowSelected(rw)){
                    c.setBackground(getBackground());
                    int modelRow = convertRowIndexToModel(rw);
                    String count = (String)tblChequeInfo.getValueAt(modelRow, 3);
                    int chequeCount = Integer.parseInt(count);
                    if(chequeCount<=7){
                        c.setBackground(Color.red);
                    }
                }
                return c;
            }

        };
        jLabel12 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        cmbboxAccNo = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();

        setTitle("<html>\n\t<font align='center'>Cheque Book</font>\n</html>");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("cheque Book");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Account No");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cheque Book No");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("First No");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Last No");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Issued Date");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cheque leaves Amount");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Bank Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Bank Branch");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Bank Telephone No");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, -1, -1));

        txtChequeBookNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtChequeBookNo.setEnabled(false);
        txtChequeBookNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChequeBookNoKeyPressed(evt);
            }
        });
        jPanel1.add(txtChequeBookNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 237, -1));

        txtFirstNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFirstNo.setEnabled(false);
        txtFirstNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFirstNoKeyPressed(evt);
            }
        });
        jPanel1.add(txtFirstNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 237, -1));

        txtLastNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLastNo.setEnabled(false);
        txtLastNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLastNoKeyPressed(evt);
            }
        });
        jPanel1.add(txtLastNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 237, -1));

        txtLeavesAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLeavesAmount.setEnabled(false);
        jPanel1.add(txtLeavesAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 158, -1));

        txtBankName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBankName.setEnabled(false);
        jPanel1.add(txtBankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 130, 350, -1));

        txtBankBranch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBankBranch.setEnabled(false);
        jPanel1.add(txtBankBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 170, 350, -1));

        txtBankTel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBankTel.setEnabled(false);
        jPanel1.add(txtBankTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 210, 350, -1));

        txtdate.setDateFormatString("yyyy-MM-dd");
        txtdate.setEnabled(false);
        txtdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtdatePropertyChange(evt);
            }
        });
        jPanel1.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 179, -1));

        tblChequeInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cheque Book No", "Account No", "Issued Date", "Cheques remain"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblChequeInfo);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 1330, 300));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/check_book-64.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(795, 30, -1, -1));

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/printer-32.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.setEnabled(false);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 310, 110, -1));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/save-32.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 310, 110, -1));

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finance/rename-32.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.setEnabled(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 310, 100, -1));

        cmbboxAccNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbboxAccNoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbboxAccNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 237, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        jLabel11.setMaximumSize(new java.awt.Dimension(1366, 733));
        jLabel11.setMinimumSize(new java.awt.Dimension(1366, 733));
        jLabel11.setName(""); // NOI18N
        jLabel11.setPreferredSize(new java.awt.Dimension(1366, 733));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        String ss = s.format(txtdate.getDate());
        try {
            new JDBC().putData("INSERT INTO chequebook VALUES('"+txtChequeBookNo.getText()+"','"+cmbboxAccNo.getSelectedItem()+"','"+ss+"')");
            int start = Integer.parseInt(txtFirstNo.getText());
            int last = Integer.parseInt(txtLastNo.getText());
            for (int i = start; i < last; i++) {
                try {
                    new JDBC().putData("INSERT INTO chequeinfo VALUES('"+i+"','"+txtChequeBookNo.getText()+"','"+cmbboxAccNo.getSelectedItem()+"','"+"not issued"+"')");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        bookDetails();
        clear();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

                clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtFirstNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtFirstNo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the first cheque leave number");
                txtFirstNo.grabFocus();
                
            }else{
                txtLastNo.setEnabled(true);
                txtLastNo.grabFocus();
            }
        }
    }//GEN-LAST:event_txtFirstNoKeyPressed

    private void txtLastNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtLastNo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the last cheque leave number");
                txtLastNo.grabFocus();
                
            }else{
                txtFirstNo.getText().trim();
                txtLastNo.getText().trim();
                if (txtFirstNo.getText().length() == txtLastNo.getText().length()) {
                    int  b= (int) (Integer.parseInt(txtLastNo.getText()) - Integer.parseInt(txtFirstNo.getText()));
                    txtLeavesAmount.setText(String.valueOf(b));
                    txtdate.setEnabled(true);
                    txtdate.grabFocus();
                    
                }else{
                    JOptionPane.showMessageDialog(this, "First and last cheque leaves numbers are not match. Please try again.");
                }
            }
        }
    }//GEN-LAST:event_txtLastNoKeyPressed

    private void txtChequeBookNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChequeBookNoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtChequeBookNo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter the cheque book number");
            }else{
                try {
                    ResultSet r = new JDBC().getData("SELECT bookNo FROM chequebook WHERE bookNo='"+txtChequeBookNo.getText()+"'");
                    if (r.next()) {
                        JOptionPane.showMessageDialog(this, "Cheque book number is already exist. Please enter new number.");
                        txtChequeBookNo.setText("");
                        txtChequeBookNo.grabFocus();
                        
                    }else{
                        txtFirstNo.grabFocus();
                        txtFirstNo.setEnabled(true);
                        
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_txtChequeBookNoKeyPressed

    private void txtdatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtdatePropertyChange

        if (txtdate.getCalendarButton().isEnabled()) {
            
                    btnClear.setEnabled(true);
                    btnSave.setEnabled(true);
                    btnPrint.setEnabled(true);
                    btnSave.grabFocus();
        }
    }//GEN-LAST:event_txtdatePropertyChange

    private void cmbboxAccNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbboxAccNoActionPerformed

        if (cmbboxAccNo.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(this, "Please enter a current account Number");
                cmbboxAccNo.grabFocus();
            }else{
                try {
                    ResultSet r = new JDBC().getData("SELECT * FROM bankaccount WHERE accNo='"+cmbboxAccNo.getSelectedItem()+"'");
                    if (r.next()) {
                        if (r.getString("type").equals("Current")) {
                            txtBankName.setText(r.getString("bankName"));
                            txtBankBranch.setText(r.getString("branch"));
                            txtBankTel.setText(r.getString("tel"));
                            txtChequeBookNo.setEnabled(true);
                            txtChequeBookNo.grabFocus();
                        }else{
                            JOptionPane.showMessageDialog(this, "Account number that you entered is not a current account. Please try again.");
                            cmbboxAccNo.grabFocus();
                            
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Cannot find account number. Please try again.");
                        cmbboxAccNo.grabFocus();
                        
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
    }//GEN-LAST:event_cmbboxAccNoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbboxAccNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblChequeInfo;
    private javax.swing.JTextField txtBankBranch;
    private javax.swing.JTextField txtBankName;
    private javax.swing.JTextField txtBankTel;
    private javax.swing.JTextField txtChequeBookNo;
    private javax.swing.JTextField txtFirstNo;
    private javax.swing.JTextField txtLastNo;
    private javax.swing.JTextField txtLeavesAmount;
    private com.toedter.calendar.JDateChooser txtdate;
    // End of variables declaration//GEN-END:variables
}
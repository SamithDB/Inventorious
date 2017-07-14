/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Samith
 */
public class sup_more extends javax.swing.JInternalFrame {

    /**
     * Creates new form sup_more
     */
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;
            
    public sup_more() {
        
        super("More Details" + (++openFrameCount), 
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable

        //...Create the GUI and put it in the window...

        //...Then set the window size or call pack...
        setSize(300,300);

        //Set the window's location.
        setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
        initComponents();
        
        jButton3.setVisible(false);
        
        settext();
        
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_sup_fname = new javax.swing.JTextField();
        txt_sup_lname = new javax.swing.JTextField();
        txt_sup_id = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txt_sup_nic = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txt_sup_company = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_sup_company_address = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txt_sup_company_contactnum1 = new javax.swing.JTextField();
        txt_sup_company_contactnum2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_sup_mobile = new javax.swing.JTextField();
        txt_sup_tel = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_sup_address_no = new javax.swing.JTextField();
        txt_sup_address_street = new javax.swing.JTextField();
        txt_sup_address_city = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_sup_email = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_sup_web = new javax.swing.JTextField();
        txt_sup_fax = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Details"));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setText("Supplier ID");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 30, 123, -1));

        jLabel21.setText(" Name:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 110, -1, -1));

        jLabel22.setText("First Name");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 110, -1, -1));
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 79, 170, -1));

        jLabel25.setText("Last Name");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 110, -1, -1));

        txt_sup_fname.setEditable(false);
        jPanel6.add(txt_sup_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 107, 214, -1));

        txt_sup_lname.setEditable(false);
        jPanel6.add(txt_sup_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 107, 213, -1));

        txt_sup_id.setEditable(false);
        jPanel6.add(txt_sup_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 27, 214, -1));

        jLabel30.setText("Supplier NIC");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 82, -1));

        txt_sup_nic.setEditable(false);
        jPanel6.add(txt_sup_nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 65, 214, -1));

        jLabel31.setText("Gender");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 149, -1, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        jPanel6.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 145, 73, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jPanel6.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 145, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setOpaque(false);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login/admin.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 150, 198));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1038, 236));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Company Details"));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setText("Company");
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 60, -1, -1));

        txt_sup_company.setEditable(false);
        jPanel7.add(txt_sup_company, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 57, 493, -1));

        jLabel33.setText("Address");
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 88, -1, -1));

        txt_sup_company_address.setEditable(false);
        jPanel7.add(txt_sup_company_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 88, 493, -1));

        jLabel34.setText("Contact Num.");
        jPanel7.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 119, -1, -1));

        txt_sup_company_contactnum1.setEditable(false);
        jPanel7.add(txt_sup_company_contactnum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 119, 225, -1));

        txt_sup_company_contactnum2.setEditable(false);
        txt_sup_company_contactnum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sup_company_contactnum2ActionPerformed(evt);
            }
        });
        jPanel7.add(txt_sup_company_contactnum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 119, 225, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/Management-Library-icon.png"))); // NOI18N
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(878, 27, -1, 137));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 253, 1038, 280));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Contact Details"));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("Mobile");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 157, -1, -1));

        jLabel12.setText("Tel.");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 188, -1, -1));

        txt_sup_mobile.setEditable(false);
        txt_sup_mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sup_mobileActionPerformed(evt);
            }
        });
        jPanel8.add(txt_sup_mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 154, 160, -1));

        txt_sup_tel.setEditable(false);
        jPanel8.add(txt_sup_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 185, 160, -1));

        jLabel13.setText("Address");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 219, 51, -1));

        txt_sup_address_no.setEditable(false);
        jPanel8.add(txt_sup_address_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 216, 160, -1));

        txt_sup_address_street.setEditable(false);
        jPanel8.add(txt_sup_address_street, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 247, 160, -1));

        txt_sup_address_city.setEditable(false);
        txt_sup_address_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sup_address_cityActionPerformed(evt);
            }
        });
        jPanel8.add(txt_sup_address_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 278, 160, -1));

        jLabel14.setText("E-Mail");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 319, -1, -1));

        txt_sup_email.setEditable(false);
        jPanel8.add(txt_sup_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 316, 160, -1));

        jLabel15.setText("Web");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 357, -1, -1));

        txt_sup_web.setEditable(false);
        jPanel8.add(txt_sup_web, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 354, 160, -1));

        txt_sup_fax.setEditable(false);
        jPanel8.add(txt_sup_fax, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 392, 160, -1));

        jLabel16.setText("Fax");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 395, 28, -1));

        jLabel17.setText("No");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 219, -1, -1));

        jLabel18.setText("   Street");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 250, 40, -1));

        jLabel19.setText("City");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 281, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/phone-64.png"))); // NOI18N
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, -1, 120));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1054, 11, 290, 520));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/undo-32.png"))); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 560, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/settings-32.png"))); // NOI18N
        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 560, 100, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/settings2-32.png"))); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 560, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/background.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 720));

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

    public void settext(){
        
        try {
            String s=supplier.sid.getText();
            ResultSet r = new JDBC().getData("SELECT * FROM suppliers where sup_id='"+s+"'");
            while(r.next()){
                txt_sup_nic.setText(r.getString("sup_nic"));
                
                String st = r.getString("sup_name");
                String ar[] = st.split("_");
                txt_sup_fname.setText(ar[0]); 
                txt_sup_lname.setText(ar[1]); 
                
                txt_sup_company.setText(r.getString("sup_company"));
                txt_sup_company_address.setText(r.getString("sup_company_address"));
                
                String cn = r.getString("sup_company_contactnum");
                String ar1[] = cn.split("_");
                txt_sup_company_contactnum1.setText(ar1[0]);  
                txt_sup_company_contactnum2.setText(ar1[1]);   
                
                txt_sup_mobile.setText(r.getString("sup_mobile"));
                txt_sup_tel.setText(r.getString("sup_tel"));
                
                String ad = r.getString("sup_address");
                String ar2[] = ad.split("_");
                txt_sup_address_no.setText(ar2[0]);  
                txt_sup_address_street.setText(ar2[1]);   
                txt_sup_address_city.setText(ar2[2]);
                
                txt_sup_email.setText(r.getString("sup_email"));
                txt_sup_web.setText(r.getString("sup_web"));
                txt_sup_fax.setText(r.getString("sup_fax"));
                
                String gen=r.getString("sup_gender");
                if("Male".equals(gen)){jRadioButton1.setSelected(true);}else if("Female".equals(gen)){jRadioButton2.setSelected(true);}
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    private void txt_sup_company_contactnum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sup_company_contactnum2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sup_company_contactnum2ActionPerformed

    private void txt_sup_mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sup_mobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sup_mobileActionPerformed

    private void txt_sup_address_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sup_address_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sup_address_cityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton3.setVisible(true);
        
                txt_sup_nic.setEditable(true);
                txt_sup_fname.setEditable(true);
                txt_sup_lname.setEditable(true);
                
                txt_sup_company.setEditable(true);
                txt_sup_company_address.setEditable(true);
                txt_sup_company_contactnum1.setEditable(true);
                txt_sup_company_contactnum2.setEditable(true);
                
                txt_sup_mobile.setEditable(true);
                txt_sup_tel.setEditable(true);
                txt_sup_address_no.setEditable(true);
                txt_sup_address_street.setEditable(true);
                txt_sup_address_city.setEditable(true);
                txt_sup_email.setEditable(true);
                txt_sup_web.setEditable(true);
                txt_sup_fax.setEditable(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
             String s=supplier.sid.getText();
             String gen="";
            if(jRadioButton1.isSelected()){gen="Male";}else if(jRadioButton2.isSelected()){gen="Female";}
            new JDBC().putData("UPDATE suppliers SET sup_name='"+txt_sup_fname.getText()+"_"+txt_sup_lname.getText()+"',sup_address='"+txt_sup_address_no.getText()+"_"+txt_sup_address_street.getText()+"_"+txt_sup_address_city.getText()+"',sup_mobile='"+txt_sup_mobile.getText()+"',sup_tel='"+txt_sup_tel.getText()+"',sup_email='"+txt_sup_email.getText()+"',sup_web='"+txt_sup_web.getText()+"',sup_fax='"+txt_sup_fax.getText()+"',sup_company='"+txt_sup_company.getText()+"',sup_company_address='"+txt_sup_company_address.getText()+"',sup_company_contactnum='"+txt_sup_company_contactnum1.getText()+"_"+txt_sup_company_contactnum2.getText()+"',sup_nic='"+txt_sup_nic.getText()+"',sup_reg_date='"+"2014-04-23"+"',sup_status='"+"Active"+"',sup_gender='"+gen+"' where sup_id='"+s+"'");
            JOptionPane.showMessageDialog(this,"Supplier Updated.....");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Can't Updated....."
                    + "Check information again.....");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField txt_sup_address_city;
    private javax.swing.JTextField txt_sup_address_no;
    private javax.swing.JTextField txt_sup_address_street;
    private javax.swing.JTextField txt_sup_company;
    private javax.swing.JTextField txt_sup_company_address;
    private javax.swing.JTextField txt_sup_company_contactnum1;
    private javax.swing.JTextField txt_sup_company_contactnum2;
    private javax.swing.JTextField txt_sup_email;
    private javax.swing.JTextField txt_sup_fax;
    private javax.swing.JTextField txt_sup_fname;
    public static javax.swing.JTextField txt_sup_id;
    private javax.swing.JTextField txt_sup_lname;
    private javax.swing.JTextField txt_sup_mobile;
    private javax.swing.JTextField txt_sup_nic;
    private javax.swing.JTextField txt_sup_tel;
    private javax.swing.JTextField txt_sup_web;
    // End of variables declaration//GEN-END:variables
}

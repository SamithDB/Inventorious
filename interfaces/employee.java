package interfaces;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashith
 */
public class employee extends javax.swing.JInternalFrame {

    public employee() {
        super("Employee", true, true, true, true);
        initComponents();
        new Add_customer().Id("SELECT COUNT(empid)+1 AS newid FROM employee", txt_empid, "EMP", "%04d");
        dch_bday.setDate(new Date());
        dch_date.setDate(new Date());
    }
    boolean editMode = false;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        lbl_emp_head = new javax.swing.JLabel();
        ilbl_emp_head_image = new javax.swing.JLabel();
        pnl_personal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_empid = new javax.swing.JTextField();
        txt_fname = new javax.swing.JTextField();
        txt_mname = new javax.swing.JTextField();
        txt_lname = new javax.swing.JTextField();
        txt_ins_name = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        dch_bday = new com.toedter.calendar.JDateChooser();
        txt_emp_nic = new javax.swing.JTextField();
        pnl_contact = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_add1 = new javax.swing.JTextField();
        txt_hnum = new javax.swing.JTextField();
        txt_mnum = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_add2 = new javax.swing.JTextField();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl0 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        pnl_employment = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_desig = new javax.swing.JTextField();
        dch_date = new com.toedter.calendar.JDateChooser();
        lbl13 = new javax.swing.JLabel();
        lbl14 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        pnl_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_details = new javax.swing.JTable();
        btn_edit = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMaximumSize(new java.awt.Dimension(1366, 734));
        setPreferredSize(new java.awt.Dimension(1366, 734));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_main.setOpaque(false);

        lbl_emp_head.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        lbl_emp_head.setText("Add/Edit Employee Details");

        ilbl_emp_head_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/employeeImage/employee-64.png"))); // NOI18N

        pnl_personal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15))); // NOI18N
        pnl_personal.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Employee ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Middle Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Name With Initial");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("NIC");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Birth Day");

        txt_empid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_empid.setEnabled(false);

        txt_fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fnameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_fnameKeyTyped(evt);
            }
        });

        txt_mname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_mname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mnameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mnameKeyTyped(evt);
            }
        });

        txt_lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lnameActionPerformed(evt);
            }
        });
        txt_lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_lnameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_lnameKeyTyped(evt);
            }
        });

        txt_ins_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ins_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ins_nameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ins_nameKeyTyped(evt);
            }
        });

        lbl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl1.setText("*");

        lbl2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl2.setText("*");

        lbl3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl3.setText("*");

        lbl4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl4.setText("*");

        lbl5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl5.setText("*");

        lbl6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl6.setText("*");

        dch_bday.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dch_bdayKeyPressed(evt);
            }
        });

        txt_emp_nic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnl_personalLayout = new javax.swing.GroupLayout(pnl_personal);
        pnl_personal.setLayout(pnl_personalLayout);
        pnl_personalLayout.setHorizontalGroup(
            pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_personalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_personalLayout.createSequentialGroup()
                        .addComponent(txt_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl2))
                    .addGroup(pnl_personalLayout.createSequentialGroup()
                        .addComponent(txt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl3))
                    .addGroup(pnl_personalLayout.createSequentialGroup()
                        .addComponent(txt_ins_name, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl4))
                    .addGroup(pnl_personalLayout.createSequentialGroup()
                        .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_personalLayout.createSequentialGroup()
                                .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dch_bday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_empid, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(txt_emp_nic))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl5)
                                    .addComponent(lbl6)))
                            .addGroup(pnl_personalLayout.createSequentialGroup()
                                .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_personalLayout.setVerticalGroup(
            pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_personalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_mname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_ins_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbl5)
                    .addComponent(txt_emp_nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_personalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(lbl6))
                    .addComponent(dch_bday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnl_contact.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15))); // NOI18N
        pnl_contact.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Address");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Home Number");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Mobile Number");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("E-mail Address");

        txt_add1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_add1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_add1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_add1KeyTyped(evt);
            }
        });

        txt_hnum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_hnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hnumActionPerformed(evt);
            }
        });
        txt_hnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_hnumKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hnumKeyTyped(evt);
            }
        });

        txt_mnum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_mnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mnumKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mnumKeyTyped(evt);
            }
        });

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });

        txt_add2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_add2ActionPerformed(evt);
            }
        });
        txt_add2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_add2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_add2KeyTyped(evt);
            }
        });

        lbl8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl8.setText("*");

        lbl9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl9.setText("*");

        lbl10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl10.setText("*");

        lbl11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl11.setText("*");

        lbl0.setText("* Feild Must Requied");

        lbl12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl12.setText("*");

        javax.swing.GroupLayout pnl_contactLayout = new javax.swing.GroupLayout(pnl_contact);
        pnl_contact.setLayout(pnl_contactLayout);
        pnl_contactLayout.setHorizontalGroup(
            pnl_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_contactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnl_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_add1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(txt_add2)
                    .addComponent(txt_hnum)
                    .addComponent(txt_mnum)
                    .addComponent(txt_email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl8)
                    .addComponent(lbl9)
                    .addComponent(lbl10)
                    .addComponent(lbl11)
                    .addComponent(lbl12))
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_contactLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl0)
                .addContainerGap())
        );
        pnl_contactLayout.setVerticalGroup(
            pnl_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_contactLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(pnl_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_add1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_add2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_hnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_mnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_contactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl0))
        );

        pnl_employment.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employment Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15))); // NOI18N
        pnl_employment.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Designation");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Date");

        txt_desig.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_desig.setToolTipText("");
        txt_desig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_desigKeyPressed(evt);
            }
        });

        dch_date.setOpaque(false);

        lbl13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl13.setText("*");

        lbl14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl14.setText("*");

        javax.swing.GroupLayout pnl_employmentLayout = new javax.swing.GroupLayout(pnl_employment);
        pnl_employment.setLayout(pnl_employmentLayout);
        pnl_employmentLayout.setHorizontalGroup(
            pnl_employmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_employmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_employmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(pnl_employmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_employmentLayout.createSequentialGroup()
                        .addComponent(txt_desig, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl13))
                    .addGroup(pnl_employmentLayout.createSequentialGroup()
                        .addComponent(dch_date, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl14)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnl_employmentLayout.setVerticalGroup(
            pnl_employmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_employmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_employmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_desig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl13))
                .addGap(18, 18, 18)
                .addGroup(pnl_employmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_employmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14)
                        .addComponent(dch_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl14))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btn_add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/employeeImage/add_image-26.png"))); // NOI18N
        btn_add.setText("Add Details");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_reset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/cancel-26.png"))); // NOI18N
        btn_reset.setText("Reset Feilds");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        pnl_table.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl_table.setOpaque(false);

        tbl_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp ID", "Name", "NIC", "Designation", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_details.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tbl_details.getTableHeader().setResizingAllowed(false);
        tbl_details.getTableHeader().setReorderingAllowed(false);
        tbl_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_detailsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_details);
        if (tbl_details.getColumnModel().getColumnCount() > 0) {
            tbl_details.getColumnModel().getColumn(0).setResizable(false);
            tbl_details.getColumnModel().getColumn(1).setResizable(false);
            tbl_details.getColumnModel().getColumn(2).setResizable(false);
            tbl_details.getColumnModel().getColumn(3).setResizable(false);
            tbl_details.getColumnModel().getColumn(4).setResizable(false);
        }

        btn_edit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/edit-26.png"))); // NOI18N
        btn_edit.setText("Edit Details");
        btn_edit.setEnabled(false);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_remove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/employeeImage/remove_user-26.png"))); // NOI18N
        btn_remove.setText("Remove Employee");
        btn_remove.setEnabled(false);
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_tableLayout = new javax.swing.GroupLayout(pnl_table);
        pnl_table.setLayout(pnl_tableLayout);
        pnl_tableLayout.setHorizontalGroup(
            pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_tableLayout.createSequentialGroup()
                        .addComponent(btn_edit)
                        .addGap(18, 18, 18)
                        .addComponent(btn_remove)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_tableLayout.setVerticalGroup(
            pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_edit)
                    .addComponent(btn_remove))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        txt_search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btn_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/search-32.png"))); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_mainLayout = new javax.swing.GroupLayout(pnl_main);
        pnl_main.setLayout(pnl_mainLayout);
        pnl_mainLayout.setHorizontalGroup(
            pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_mainLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_personal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_mainLayout.createSequentialGroup()
                                .addComponent(pnl_employment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnl_mainLayout.createSequentialGroup()
                                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_search)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnl_mainLayout.createSequentialGroup()
                                        .addComponent(btn_add)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_reset)
                                        .addGap(180, 180, 180))))
                            .addComponent(pnl_table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnl_mainLayout.createSequentialGroup()
                        .addComponent(ilbl_emp_head_image)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_emp_head)))
                .addContainerGap())
        );
        pnl_mainLayout.setVerticalGroup(
            pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mainLayout.createSequentialGroup()
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_mainLayout.createSequentialGroup()
                        .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_search)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_mainLayout.createSequentialGroup()
                        .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ilbl_emp_head_image)
                            .addComponent(lbl_emp_head))
                        .addGap(22, 22, 22)
                        .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_employment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_mainLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_add)
                                    .addComponent(btn_reset)))
                            .addComponent(pnl_personal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(pnl_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        getContentPane().add(pnl_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 700));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/background.png"))); // NOI18N
        getContentPane().add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_add2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_add2ActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_hnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hnumActionPerformed

    private void txt_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lnameActionPerformed

    private void txt_fnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fnameKeyTyped

        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_fnameKeyTyped

    private void txt_mnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mnameKeyTyped

        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_mnameKeyTyped

    private void txt_lnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lnameKeyTyped

        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_lnameKeyTyped

    private void txt_ins_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ins_nameKeyTyped

        if (Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_ins_nameKeyTyped

    private void txt_add1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_add1KeyTyped


    }//GEN-LAST:event_txt_add1KeyTyped

    private void txt_add2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_add2KeyTyped


    }//GEN-LAST:event_txt_add2KeyTyped

    private void txt_hnumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hnumKeyTyped

        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_hnumKeyTyped

    private void txt_mnumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mnumKeyTyped

        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_mnumKeyTyped

    private void txt_fnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fnameKeyPressed

        validate(txt_fname, lbl1, lbl0, txt_mname, evt);
    }//GEN-LAST:event_txt_fnameKeyPressed

    private void txt_mnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mnameKeyPressed

        validate(txt_mname, lbl2, lbl0, txt_lname, evt);
    }//GEN-LAST:event_txt_mnameKeyPressed

    private void txt_lnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lnameKeyPressed

        validate(txt_lname, lbl3, lbl0, txt_ins_name, evt);
    }//GEN-LAST:event_txt_lnameKeyPressed

    private void txt_ins_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ins_nameKeyPressed

        validate(txt_ins_name, lbl4, lbl0, txt_emp_nic, evt);
    }//GEN-LAST:event_txt_ins_nameKeyPressed

    private void dch_bdayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dch_bdayKeyPressed


    }//GEN-LAST:event_dch_bdayKeyPressed

    private void txt_add2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_add2KeyPressed

        validate(txt_add2, lbl9, lbl0, txt_hnum, evt);
    }//GEN-LAST:event_txt_add2KeyPressed

    private void txt_add1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_add1KeyPressed

        validate(txt_add1, lbl8, lbl0, txt_add2, evt);
    }//GEN-LAST:event_txt_add1KeyPressed

    private void txt_hnumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hnumKeyPressed

        validate(txt_hnum, lbl10, lbl0, txt_mnum, evt);
    }//GEN-LAST:event_txt_hnumKeyPressed

    private void txt_mnumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mnumKeyPressed

        validate(txt_mnum, lbl11, lbl0, txt_email, evt);
    }//GEN-LAST:event_txt_mnumKeyPressed

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed

        validate(txt_email, lbl12, lbl0, txt_desig, evt);
    }//GEN-LAST:event_txt_emailKeyPressed

    private void txt_desigKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_desigKeyPressed

        validate(txt_desig, lbl13, lbl0, txt_empid, evt);
    }//GEN-LAST:event_txt_desigKeyPressed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        if (editMode) {
            if (updateInfo()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "<html>Employee Details Alredy <b>EXITS</b></html>", title, JOptionPane.WARNING_MESSAGE);
            } else {
                setUpdateToDB();
            }
        } else {
            putDataToDB();
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed

        cls();
        new Add_customer().Id("SELECT COUNT(empid)+1 AS newid FROM employee ", txt_empid, "EMP", "%04d");
        tbl_details.clearSelection();
        editMode = false;
        btn_add.setEnabled(true);
        btn_add.setText("Add Details");
        btn_edit.setEnabled(false);
        btn_remove.setEnabled(false);
        dch_bday.setEnabled(true);
        dch_date.setEnabled(true);
        textEditable(true);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed

        if (txt_search.getText().isEmpty()) {
            searchResult("");
        } else {
            searchResult("WHERE name LIKE'%" + txt_search.getText() + "%' OR empid='" + txt_search.getText() + "'");
        }

    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed

        editMode = true;
        btn_add.setEnabled(true);
        btn_add.setText("Update Details");
        textEditable(true);
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed

        String empid = (String) tbl_details.getValueAt(tbl_details.getSelectedRow(), 0);
        int ms = JOptionPane.showConfirmDialog(this, "Do You Want to REMOVE " + empid + "'s All Records ", title, JOptionPane.YES_NO_OPTION);
        if (ms == 0) {
            deleteFromDB();
        }
    }//GEN-LAST:event_btn_removeActionPerformed

    private void tbl_detailsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_detailsMouseReleased

        tableToText();
        btn_add.setEnabled(false);
       
        textEditable(false);
        lbl0.setForeground(Color.black);
        
        int selectedRow = tbl_details.getSelectedRow();
        if (tbl_details.getValueAt(selectedRow, 4).equals("Deactivate")) {
            btn_remove.setEnabled(false);
            btn_edit.setEnabled(false);
        } else {
            btn_edit.setEnabled(true);
            btn_remove.setEnabled(true);
        }
    }//GEN-LAST:event_tbl_detailsMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_search;
    private com.toedter.calendar.JDateChooser dch_bday;
    private com.toedter.calendar.JDateChooser dch_date;
    private javax.swing.JLabel ilbl_emp_head_image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl0;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl13;
    private javax.swing.JLabel lbl14;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_emp_head;
    private javax.swing.JPanel pnl_contact;
    private javax.swing.JPanel pnl_employment;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_personal;
    private javax.swing.JPanel pnl_table;
    private javax.swing.JTable tbl_details;
    private javax.swing.JTextField txt_add1;
    private javax.swing.JTextField txt_add2;
    private javax.swing.JTextField txt_desig;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_emp_nic;
    private javax.swing.JTextField txt_empid;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_hnum;
    private javax.swing.JTextField txt_ins_name;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JTextField txt_mname;
    private javax.swing.JTextField txt_mnum;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables

    void validate(JTextField tx, JLabel lbl, JLabel lbl0, JTextField tx2, KeyEvent evt) {
        if (tx.getText().isEmpty()) {
            lbl.setForeground(Color.red);
            lbl0.setForeground(Color.red);
            btn_add.setEnabled(false);
        } else {
            lbl.setForeground(Color.black);
            lbl0.setForeground(Color.black);
            btn_add.setEnabled(true);
            if (evt.getKeyCode() == 10) {
                tx2.grabFocus();
            }
        }
    }

    void addToDB() throws Exception {
        try {
            new JDBC().putData("INSERT INTO employee VALUES('" + txt_empid.getText() + "','" + txt_fname.getText() + "," + txt_mname.getText() + "," + txt_lname.getText() + "',"
                    + "'" + txt_ins_name.getText() + "','" + txt_emp_nic.getText() + "',"
                    + "'" + txt_add1.getText() + "," + txt_add2.getText() + "','" + txt_hnum.getText() + "','" + txt_mnum.getText() + "',"
                    + "'" + txt_email.getText() + "','" + txt_desig.getText() + "','" + dateFromChooser(dch_date) + "','" + dateFromChooser(dch_bday) + "',"
                    + "'Activate')");
            addToTable(tbl_details);
            JOptionPane.showMessageDialog(this, "Employee Details Added To System", "Employee", JOptionPane.INFORMATION_MESSAGE);
            cls();
            int id = Integer.valueOf(txt_empid.getText().substring(3)) + 1;
            txt_empid.setText("EMP" + String.format("%04d", id));
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "EMPLOYEE ID Alredy EXITS", "Employee", JOptionPane.WARNING_MESSAGE);
            int id = Integer.valueOf(txt_empid.getText().substring(3)) + 1;
            txt_empid.setText("EMP" + String.format("%04d", id));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    String dateFromChooser(JDateChooser dch) {
        String date = new SimpleDateFormat("dd-MMM-yyyy").format(dch.getDate());
        return date;
    }

    boolean personalInfo() {
        return txt_fname.getText().isEmpty() | txt_mname.getText().isEmpty() | txt_lname.getText().isEmpty()
                | txt_ins_name.getText().isEmpty() | txt_emp_nic.getText().length() > 10;
    }

    boolean contactInfo() {
        return txt_add1.getText().isEmpty() | txt_add2.getText().isEmpty() | txt_hnum.getText().isEmpty()
                | txt_mnum.getText().isEmpty() | txt_email.getText().isEmpty();
    }

    boolean empInfo() {
        return txt_desig.getText().isEmpty();
    }

    void cls() {
        txt_fname.setText(null);
        txt_mname.setText(null);
        txt_lname.setText(null);
        txt_ins_name.setText(null);
        txt_emp_nic.setText(null);
        dch_bday.setDate(new Date());
        txt_add1.setText(null);
        txt_add2.setText(null);
        txt_hnum.setText(null);
        txt_mnum.setText(null);
        txt_email.setText(null);
        txt_desig.setText(null);
        dch_date.setDate(new Date());
        lbl0.setForeground(Color.black);
    }

    void addToTable(JTable tbl) {
        DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
        Vector v = new Vector();
        v.add(txt_empid.getText());
        v.add(txt_ins_name.getText());
        v.add(txt_emp_nic.getText());
        v.add(txt_desig.getText());
        v.add("Activate");
        dtm.addRow(v);
    }

    void searchResult(String keyword) {
        DefaultTableModel dtm = (DefaultTableModel) tbl_details.getModel();
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM employee " + keyword + " ");
            new Add_customer().removeAllRow(tbl_details);
            while (r.next()) {
                Vector v = new Vector();
                v.add(r.getString("empid"));
                v.add(r.getString("insname"));
                v.add(r.getString("nic"));
                v.add(r.getString("designation"));
                v.add(r.getString("status"));
                dtm.addRow(v);
            }
            if (tbl_details.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "<html>NO Result Availble For This Key Word <br>Try With <b>Different <u>KEY WORD</u></b></html>",
                        "Search Result", JOptionPane.INFORMATION_MESSAGE);
            }
            txt_search.setText(null);
        } catch (Exception e) {
        }
    }

    void tableToText() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_details.getModel();
        int selectedRow = tbl_details.getSelectedRow();
        String search = (String) dtm.getValueAt(selectedRow, 0);
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM employee WHERE empid='" + search + "' ");
            while (r.next()) {
                txt_empid.setText(r.getString("empid"));
                String name[] = r.getString("name").split(",");
                txt_fname.setText(name[0]);
                txt_mname.setText(name[1]);
                txt_lname.setText(name[2]);
                txt_ins_name.setText(r.getString("insname"));
                txt_emp_nic.setText(r.getString("nic"));
                dch_bday.setDate(stringToDate(r.getString("bday")));
                String address[] = r.getString("addr").split(",");
                txt_add1.setText(address[0]);
                txt_add2.setText(address[1]);
                txt_hnum.setText(r.getString("hnum"));
                txt_mnum.setText(r.getString("mob"));
                txt_email.setText(r.getString("email"));
                txt_desig.setText(r.getString("designation"));
                dch_date.setDate(stringToDate(r.getString("date")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Date stringToDate(String dt) {
        Date d = null;
        String date = dt;
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            d = format.parse(date);
        } catch (ParseException e) {
        }
        return d;

    }

    void putDataToDB() {
        if (personalInfo() | contactInfo() | empInfo()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "PLEASE Fill The Form Correctly", "Employee", JOptionPane.ERROR_MESSAGE);
            lbl0.setForeground(Color.red);
        } else {
            lbl0.setForeground(Color.black);

            if (lbl0.getForeground().equals(Color.red)) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "PLEASE Fill The Form Correctly", "Employee", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    addToDB();
                } catch (Exception ex) {
                }
            }
        }
    }

    void upDateDB() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_details.getModel();
        int row = tbl_details.getSelectedRow();
        try {
            new JDBC().putData("UPDATE employee SET name='" + txt_fname.getText() + "," + txt_mname.getText() + "," + txt_lname.getText() + "',"
                    + "insname='" + txt_ins_name.getText() + "', nic='" + txt_emp_nic.getText() + "', addr='" + txt_add1.getText() + "," + txt_add2.getText() + "',"
                    + "hnum='" + txt_hnum.getText() + "', mob='" + txt_mnum.getText() + "', email='" + txt_email.getText() + "', date='" + dateFromChooser(dch_date) + "',"
                    + "bday='" + dateFromChooser(dch_bday) + "',designation='" + txt_desig.getText() + "' WHERE empid='" + txt_empid.getText() + "' ");
            JOptionPane.showMessageDialog(this, "EMPLOYEE Details Has Been Updated", "Update", JOptionPane.INFORMATION_MESSAGE);
            dtm.setValueAt(txt_ins_name.getText(), row, 1);
            dtm.setValueAt(txt_emp_nic.getText(), row, 2);
            dtm.setValueAt(txt_desig.getText(), row, 3);
            cls();
            new Add_customer().Id("SELECT COUNT(empid)+1 AS newid FROM employee", txt_empid, "EMP", "%04d");
            tbl_details.clearSelection();
        } catch (Exception e) {
        }
    }

    void setUpdateToDB() {
        if (personalInfo() | contactInfo() | empInfo()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "PLEASE Fill The Form Correctly", "Employee", JOptionPane.ERROR_MESSAGE);
            lbl0.setForeground(Color.red);
        } else {
            lbl0.setForeground(Color.black);

            if (lbl0.getForeground().equals(Color.red)) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "PLEASE Fill The Form Correctly", "Employee", JOptionPane.ERROR_MESSAGE);
            } else {
                upDateDB();
                editMode = false;
                btn_edit.setEnabled(false);
                btn_remove.setEnabled(false);
                btn_add.setText("Add Details");
            }
        }
    }

    void textEditable(boolean b) {
        txt_fname.setEditable(b);
        txt_mname.setEditable(b);
        txt_lname.setEditable(b);
        txt_ins_name.setEditable(b);
        txt_emp_nic.setEditable(b);
        dch_bday.setEnabled(b);
        txt_add1.setEditable(b);
        txt_add2.setEditable(b);
        txt_hnum.setEditable(b);
        txt_mnum.setEditable(b);
        txt_email.setEditable(b);
        txt_desig.setEditable(b);
        dch_date.setEnabled(b);
    }

    boolean updateInfo() {
        boolean compare = false;
        String name[], insname, nic, addr[], hnum, mnum, email, designation, bday, date;
        DefaultTableModel dtm = (DefaultTableModel) tbl_details.getModel();
        int row = tbl_details.getSelectedRow();
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM employee WHERE empid='" + dtm.getValueAt(row, 0) + "'");
            if (r.next()) {
                name = r.getString("name").split(",");
                insname = r.getString("insname");
                nic = r.getString("nic");
                addr = r.getString("addr").split(",");
                hnum = r.getString("hnum");
                mnum = r.getString("mob");
                email = r.getString("email");
                designation = r.getString("designation");
                bday = r.getString("bday");
                date = r.getString("date");

                if (name[0].equals(txt_fname.getText()) & name[1].equals(txt_mname.getText()) & name[2].equals(txt_lname.getText())
                        & insname.equals(txt_ins_name.getText()) & nic.equals(txt_emp_nic.getText()) & addr[0].equals(txt_add1.getText())
                        & addr[1].equals(txt_add2.getText()) & hnum.equals(txt_hnum.getText()) & mnum.equals(txt_mnum.getText())
                        & email.equals(txt_email.getText()) & designation.equals(txt_desig.getText())
                        & bday.equals(dateFromChooser(dch_bday)) & date.equals(dateFromChooser(dch_date))) {
                    compare = true;
                }

            }
        } catch (Exception e) {
        }
        return compare;
    }

    void deleteFromDB() {
        String msg = "<html>Employee Record Was <b>DELETED</b></html>";
        DefaultTableModel dtm = (DefaultTableModel) tbl_details.getModel();
        int row = tbl_details.getSelectedRow();
        
        try {
            new JDBC().putData("UPDATE employee SET status='Deactivate' WHERE empid='" + dtm.getValueAt(row, 0) + "' ");
            JOptionPane.showMessageDialog(this, msg, title, JOptionPane.INFORMATION_MESSAGE);
            dtm.setValueAt("Deactivate", row, 4);
            btn_resetActionPerformed(null);
        } catch (Exception e) {
        }
        
    }
}

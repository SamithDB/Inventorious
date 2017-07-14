package interfaces;

import com.toedter.calendar.JMonthChooser;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Hashith
 */
public class pay_pay extends javax.swing.JInternalFrame {

    JTextField payid = new JTextField();

    public pay_pay() {
        super("Pay", true, true, true, true);
        initComponents();
        new Add_customer().Id("SELECT COUNT(payid)+1 AS newid FROM pay", payid, "PAY00", "%05d");
        searchEnable();
        new pay_loan().setToCombo(cmb_pay_empid, "SELECT empid FROM rate");
    }
    boolean payMonth = true;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pay = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        chk_pay_otherdeduc = new javax.swing.JCheckBox();
        txt_pay_fname = new javax.swing.JTextField();
        txt_pay_lanme = new javax.swing.JTextField();
        txt_pay_designation = new javax.swing.JTextField();
        txt_pay_earning = new javax.swing.JTextField();
        txt_pay_ot = new javax.swing.JTextField();
        txt_pay_hlday = new javax.swing.JTextField();
        txt_pay_laon = new javax.swing.JTextField();
        txt_pay_deduct = new javax.swing.JTextField();
        cmb_pay_empid = new javax.swing.JComboBox();
        btn_pay_pay = new javax.swing.JButton();
        btn_pay_cancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_pay_tot = new javax.swing.JTextField();
        btn_pay_minus = new javax.swing.JButton();
        cmb_pay_search = new javax.swing.JComboBox();
        btn_pay_search = new javax.swing.JButton();
        mch_pay = new com.toedter.calendar.JMonthChooser();
        txt_pay_search = new javax.swing.JTextField();
        pnl_btl = new javax.swing.JPanel();
        btn_pay_refresh = new javax.swing.JButton();
        btn_pay_vwall = new javax.swing.JButton();
        btn_pay_vwpaysht = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/cash_receiving-26.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1366, 730));
        setPreferredSize(new java.awt.Dimension(1366, 730));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 40)); // NOI18N
        jLabel1.setText("Payments ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/cash_receiving-64.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setOpaque(false);

        tbl_pay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pay ID", "Emp ID", "Name", "Earning", "O/T", "Half Day", "Loans", "Other Deduc..", "Total", "Month", "Date", "Year"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_pay.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tbl_pay.getTableHeader().setReorderingAllowed(false);
        tbl_pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_payMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_pay);
        if (tbl_pay.getColumnModel().getColumnCount() > 0) {
            tbl_pay.getColumnModel().getColumn(0).setResizable(false);
            tbl_pay.getColumnModel().getColumn(1).setResizable(false);
            tbl_pay.getColumnModel().getColumn(2).setResizable(false);
            tbl_pay.getColumnModel().getColumn(3).setResizable(false);
            tbl_pay.getColumnModel().getColumn(4).setResizable(false);
            tbl_pay.getColumnModel().getColumn(5).setResizable(false);
            tbl_pay.getColumnModel().getColumn(6).setResizable(false);
            tbl_pay.getColumnModel().getColumn(7).setResizable(false);
            tbl_pay.getColumnModel().getColumn(8).setResizable(false);
            tbl_pay.getColumnModel().getColumn(9).setResizable(false);
            tbl_pay.getColumnModel().getColumn(10).setResizable(false);
            tbl_pay.getColumnModel().getColumn(11).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 1290, 280));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Emp ID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("First Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Last Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Designation");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Earning");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("O/T Hours");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Half Day");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Loans");

        chk_pay_otherdeduc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chk_pay_otherdeduc.setText("Other Deduction");
        chk_pay_otherdeduc.setEnabled(false);
        chk_pay_otherdeduc.setOpaque(false);
        chk_pay_otherdeduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_pay_otherdeducActionPerformed(evt);
            }
        });

        txt_pay_fname.setEditable(false);
        txt_pay_fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_pay_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pay_fnameActionPerformed(evt);
            }
        });

        txt_pay_lanme.setEditable(false);
        txt_pay_lanme.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_pay_lanme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pay_lanmeActionPerformed(evt);
            }
        });

        txt_pay_designation.setEditable(false);
        txt_pay_designation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_pay_earning.setEditable(false);
        txt_pay_earning.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_pay_ot.setEditable(false);
        txt_pay_ot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_pay_hlday.setEditable(false);
        txt_pay_hlday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_pay_laon.setEditable(false);
        txt_pay_laon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_pay_deduct.setEditable(false);
        txt_pay_deduct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_pay_deduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_pay_deductMouseClicked(evt);
            }
        });
        txt_pay_deduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pay_deductActionPerformed(evt);
            }
        });
        txt_pay_deduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pay_deductKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pay_deductKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pay_deductKeyTyped(evt);
            }
        });

        cmb_pay_empid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_pay_empid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        cmb_pay_empid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmb_pay_empidMouseEntered(evt);
            }
        });
        cmb_pay_empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_pay_empidActionPerformed(evt);
            }
        });

        btn_pay_pay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_pay_pay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/bank-26.png"))); // NOI18N
        btn_pay_pay.setText("Pay");
        btn_pay_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pay_payActionPerformed(evt);
            }
        });

        btn_pay_cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_pay_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/cancel-26.png"))); // NOI18N
        btn_pay_cancel.setText("Cancel");
        btn_pay_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pay_cancelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total");

        txt_pay_tot.setEditable(false);
        txt_pay_tot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_pay_minus.setEnabled(false);
        btn_pay_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/minus-26.png"))); // NOI18N
        btn_pay_minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pay_minusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_pay_fname)
                    .addComponent(txt_pay_lanme)
                    .addComponent(cmb_pay_empid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_pay_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(chk_pay_otherdeduc))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_pay_deduct)
                    .addComponent(txt_pay_ot)
                    .addComponent(txt_pay_earning)
                    .addComponent(txt_pay_hlday, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txt_pay_laon, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txt_pay_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btn_pay_minus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_pay_pay)
                        .addGap(18, 18, 18)
                        .addComponent(btn_pay_cancel)))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_pay_minus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(cmb_pay_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(txt_pay_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(txt_pay_lanme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(txt_pay_earning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_pay_hlday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_pay_designation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chk_pay_otherdeduc)
                                    .addComponent(txt_pay_deduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(txt_pay_laon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_pay_ot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_pay_tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_pay_pay)
                            .addComponent(btn_pay_cancel))
                        .addGap(50, 50, 50))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 80, 1280, 200));

        cmb_pay_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_pay_search.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Emp ID", "Month" }));
        cmb_pay_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_pay_searchActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_pay_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 140, -1));

        btn_pay_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/search-32.png"))); // NOI18N
        btn_pay_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pay_searchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pay_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        mch_pay.setVisible(false);
        mch_pay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mch_pay.setMaximumSize(new java.awt.Dimension(111, 23));
        mch_pay.setMinimumSize(new java.awt.Dimension(111, 23));
        mch_pay.setPreferredSize(new java.awt.Dimension(111, 23));
        mch_pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mch_payMouseClicked(evt);
            }
        });
        getContentPane().add(mch_pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 120, 30));

        txt_pay_search.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        txt_pay_search.setForeground(new java.awt.Color(153, 153, 153));
        txt_pay_search.setText("Enter Emp ID Or Name");
        txt_pay_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_pay_searchMouseClicked(evt);
            }
        });
        txt_pay_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pay_searchActionPerformed(evt);
            }
        });
        txt_pay_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pay_searchKeyPressed(evt);
            }
        });
        getContentPane().add(txt_pay_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 250, -1));

        pnl_btl.setOpaque(false);

        btn_pay_refresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_pay_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/View_Details-26.png"))); // NOI18N
        btn_pay_refresh.setText("View This Year");
        btn_pay_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pay_refreshActionPerformed(evt);
            }
        });

        btn_pay_vwall.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_pay_vwall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/day_view-26.png"))); // NOI18N
        btn_pay_vwall.setText("View All");
        btn_pay_vwall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pay_vwallActionPerformed(evt);
            }
        });

        btn_pay_vwpaysht.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_pay_vwpaysht.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/paper-26.png"))); // NOI18N
        btn_pay_vwpaysht.setText("View Pay Sheet");
        btn_pay_vwpaysht.setEnabled(false);
        btn_pay_vwpaysht.setPreferredSize(new java.awt.Dimension(105, 35));
        btn_pay_vwpaysht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pay_vwpayshtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_btlLayout = new javax.swing.GroupLayout(pnl_btl);
        pnl_btl.setLayout(pnl_btlLayout);
        pnl_btlLayout.setHorizontalGroup(
            pnl_btlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_btlLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(btn_pay_vwpaysht, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_pay_vwall)
                .addGap(18, 18, 18)
                .addComponent(btn_pay_refresh)
                .addGap(24, 24, 24))
        );
        pnl_btlLayout.setVerticalGroup(
            pnl_btlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_btlLayout.createSequentialGroup()
                .addGroup(pnl_btlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pay_refresh)
                    .addComponent(btn_pay_vwall)
                    .addComponent(btn_pay_vwpaysht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        getContentPane().add(pnl_btl, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 630, 510, 50));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/background.png"))); // NOI18N
        getContentPane().add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pay_deductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pay_deductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pay_deductActionPerformed

    private void txt_pay_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pay_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pay_fnameActionPerformed

    private void txt_pay_lanmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pay_lanmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pay_lanmeActionPerformed

    private void txt_pay_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pay_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pay_searchActionPerformed

    private void cmb_pay_empidMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_pay_empidMouseEntered

    }//GEN-LAST:event_cmb_pay_empidMouseEntered

    private void cmb_pay_empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_pay_empidActionPerformed

        cmbAction();
    }//GEN-LAST:event_cmb_pay_empidActionPerformed

    private void chk_pay_otherdeducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_pay_otherdeducActionPerformed

        if (chk_pay_otherdeduc.isSelected()) {
            if (!txt_pay_fname.getText().isEmpty()) {
                if (chk_pay_otherdeduc.isSelected()) {
                    txt_pay_deduct.setEditable(true);
                    txt_pay_deduct.setText("Rs:");
                    txt_pay_deduct.grabFocus();
                    btn_pay_minus.setEnabled(true);
                } else {
                    txt_pay_deduct.setEditable(false);
                    btn_pay_minus.setEnabled(false);
                    txt_pay_deduct.setText(null);
                }
            }
            txt_pay_deduct.setText(null);
        } else {
            txt_pay_deduct.setEditable(false);
        }
    }//GEN-LAST:event_chk_pay_otherdeducActionPerformed

    private void btn_pay_payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pay_payActionPerformed

        try {
            ResultSet r = new JDBC().getData("SELECT empid FROM pay WHERE month='" + month() + "' AND year='" + year() + "' AND empid='" + cmb_pay_empid.getSelectedItem() + "' ");
            if (r.next()) {
                JOptionPane.showMessageDialog(this, "ALREADY Payed");
            } else {
                if (cmb_pay_empid.getSelectedItem().equals("Select")) {
                    JOptionPane.showMessageDialog(this, "PLEASE Select an EMP ID");
                } else {
                    setToDB();
                    addToTable();
                    updateDB();
                    cls();
                    new Add_customer().Id("SELECT COUNT(payid)+1 AS newid FROM pay", payid, "PAY00", "%05d");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_pay_payActionPerformed

    private void btn_pay_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pay_searchActionPerformed

        if (cmb_pay_search.getSelectedItem().equals("Emp ID")) {
            searchPay();
        } else if (cmb_pay_search.getSelectedItem().equals("Month")) {
            monthSearch();
            if (tbl_pay.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No Record Found");
            }
        }
    }//GEN-LAST:event_btn_pay_searchActionPerformed

    private void txt_pay_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_pay_searchMouseClicked

        if (txt_pay_search.isEnabled()) {
            new pay_loan().searchText("Tahoma", 0, 0, null, txt_pay_search);
        }
    }//GEN-LAST:event_txt_pay_searchMouseClicked

    private void btn_pay_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pay_refreshActionPerformed

        searchRecord("SELECT * FROM pay WHERE year='" + year() + "' ", tbl_pay);
    }//GEN-LAST:event_btn_pay_refreshActionPerformed

    private void btn_pay_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pay_cancelActionPerformed

        cls();
        tbl_pay.clearSelection();
    }//GEN-LAST:event_btn_pay_cancelActionPerformed

    private void cmb_pay_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_pay_searchActionPerformed

        if (cmb_pay_search.getSelectedItem().equals("Month")) {
            txt_pay_search.setVisible(false);
            txt_pay_search.setEnabled(false);
            mch_pay.setVisible(true);
            btn_pay_search.setLocation(310, 290);
        } else {
            mch_pay.setVisible(false);
            txt_pay_search.setVisible(true);
            txt_pay_search.setEnabled(true);
            btn_pay_search.setLocation(480, 290);
        }
    }//GEN-LAST:event_cmb_pay_searchActionPerformed

    private void btn_pay_minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pay_minusActionPerformed

        if (deduc(true) < deduc(false)) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "SORRY Amount Large To SALARY", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (deduc(true) < deduc(false)) {
            otherDed();
            btn_pay_minus.setEnabled(false);
            chk_pay_otherdeduc.setSelected(false);
        }

    }//GEN-LAST:event_btn_pay_minusActionPerformed

    private void txt_pay_deductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_pay_deductMouseClicked

        if (chk_pay_otherdeduc.isSelected() && txt_pay_deduct.isEditable()) {
            txt_pay_deduct.setText("Rs:");
        }

    }//GEN-LAST:event_txt_pay_deductMouseClicked

    private void txt_pay_deductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pay_deductKeyPressed

        if (txt_pay_deduct.getText().isEmpty() || txt_pay_deduct.getText().substring(3).isEmpty()) {
            txt_pay_deduct.setText("Rs: ");
        }
    }//GEN-LAST:event_txt_pay_deductKeyPressed

    private void txt_pay_deductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pay_deductKeyReleased

        if (evt.getKeyCode() == 10) {
            otherDed();
            chk_pay_otherdeduc.setSelected(false);
        }
        deduc(true);
    }//GEN-LAST:event_txt_pay_deductKeyReleased

    private void mch_payMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mch_payMouseClicked


    }//GEN-LAST:event_mch_payMouseClicked

    private void btn_pay_vwallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pay_vwallActionPerformed

        viewAll();
    }//GEN-LAST:event_btn_pay_vwallActionPerformed

    private void txt_pay_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pay_searchKeyPressed

        if (evt.getKeyCode() == 10) {
            if (cmb_pay_search.getSelectedItem().equals("Emp ID")) {
                searchPay();
            }
        }
    }//GEN-LAST:event_txt_pay_searchKeyPressed

    private void txt_pay_deductKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pay_deductKeyTyped

        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_pay_deductKeyTyped

    private void btn_pay_vwpayshtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pay_vwpayshtActionPerformed

        DefaultTableModel model = (DefaultTableModel) tbl_pay.getModel();
        int selectedRow = tbl_pay.getSelectedRow();

        if (tbl_pay.getSelectedRowCount() == 1) {
            new PaySheet(model.getValueAt(selectedRow, 0), model.getValueAt(selectedRow, 1)).setVisible(true);
        } else if (tbl_pay.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(this, "Please Select One Row For The One Time", "Selection", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please Select A Row", "Selection", JOptionPane.INFORMATION_MESSAGE);
        }
        btn_pay_vwpaysht.setEnabled(false);
    }//GEN-LAST:event_btn_pay_vwpayshtActionPerformed

    private void tbl_payMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_payMouseReleased

        btn_pay_vwpaysht.setEnabled(true);
    }//GEN-LAST:event_tbl_payMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pay_cancel;
    private javax.swing.JButton btn_pay_minus;
    private javax.swing.JButton btn_pay_pay;
    private javax.swing.JButton btn_pay_refresh;
    private javax.swing.JButton btn_pay_search;
    javax.swing.JButton btn_pay_vwall;
    private javax.swing.JButton btn_pay_vwpaysht;
    private javax.swing.JCheckBox chk_pay_otherdeduc;
    private javax.swing.JComboBox cmb_pay_empid;
    private javax.swing.JComboBox cmb_pay_search;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_background;
    private com.toedter.calendar.JMonthChooser mch_pay;
    private javax.swing.JPanel pnl_btl;
    private javax.swing.JTable tbl_pay;
    private javax.swing.JTextField txt_pay_deduct;
    private javax.swing.JTextField txt_pay_designation;
    private javax.swing.JTextField txt_pay_earning;
    private javax.swing.JTextField txt_pay_fname;
    private javax.swing.JTextField txt_pay_hlday;
    private javax.swing.JTextField txt_pay_lanme;
    private javax.swing.JTextField txt_pay_laon;
    private javax.swing.JTextField txt_pay_ot;
    private javax.swing.JTextField txt_pay_search;
    private javax.swing.JTextField txt_pay_tot;
    // End of variables declaration//GEN-END:variables

    double otherD() {
        if (chk_pay_otherdeduc.isSelected() && !txt_pay_deduct.getText().equals("Rs:")) {
            String otded[] = txt_pay_deduct.getText().split(":");
            if (otded.length == 2) {
                double d2 = Double.parseDouble(otded[1]);
                return d2;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    void totalText() {
        try {
            ResultSet lon = new JDBC().getData("SELECT amount/install AS dloan FROM loan WHERE empid='" + cmb_pay_empid.getSelectedItem() + "' ");
            if (!lon.wasNull()) {
                double tot = Amount(txt_pay_earning) + Amount(txt_pay_ot) + Amount(txt_pay_hlday) - Amount(txt_pay_laon) - otherD();
                txt_pay_tot.setText("Rs:" + RoundTo2Decimals(tot));

            } else {
                double tot = Amount(txt_pay_earning) + Amount(txt_pay_ot) + Amount(txt_pay_hlday) - otherD();
                txt_pay_tot.setText("Rs:" + RoundTo2Decimals(tot));
            }
        } catch (Exception er) {
            er.printStackTrace();
        }
    }

    void updateDB() {
        try {
            ResultSet r = new JDBC().getData("SELECT amount FROM loan");
            if (!r.wasNull()) {
                try {
                    new JDBC().putData("UPDATE loan SET amount=amount-(amount/install),install=(install-1) WHERE empid='" + cmb_pay_empid.getSelectedItem() + "' ");
                    deleteLoan();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void deleteLoan() {
        try {
            new JDBC().putData("DELETE FROM loan WHERE amount=0");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void searchPay() {
        if (txt_pay_search.getText().equals("Enter Emp ID Or Name") || !txt_pay_search.getText().isEmpty()) {
            try {
                ResultSet r = new JDBC().getData("SELECT * FROM pay WHERE empid='" + txt_pay_search.getText() + "' OR "
                        + "name LIKE'%" + txt_pay_search.getText() + "%' AND year='" + year() + "' ");
                if (!r.wasNull()) {
                    new Add_customer().removeAllRow(tbl_pay);
                    Vector v = new Vector();
                    while (r.next()) {
                        DefaultTableModel dtm = (DefaultTableModel) tbl_pay.getModel();

                        v.add(r.getString("payid"));
                        v.add(r.getString("empid"));
                        v.add(r.getString("name"));
                        v.add("Rs:" + r.getString("earn"));
                        v.add("Rs:" + r.getString("ot"));
                        v.add("Rs:" + r.getString("halfday"));
                        v.add("Rs:" + r.getString("loan"));
                        v.add("Rs:" + r.getString("other"));
                        v.add("Rs:" + r.getString("tot"));
                        v.add(r.getString("month"));
                        v.add(r.getString("date"));
                        v.add(r.getString("year"));
                        dtm.addRow(v);
                    }
                    new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Emp ID Or Name", txt_pay_search);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (tbl_pay.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No Record Found");
                new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Emp ID Or Name", txt_pay_search);
            }
        } else if (txt_pay_search.getText().equals("Enter Emp ID ") || txt_pay_search.getText().isEmpty()) {
            new pay_loan().searchText("Tempus Sans ITC", 1, 153, "Enter Emp ID Or Name", txt_pay_search);
            JOptionPane.showMessageDialog(this, "PLEASE enter EMPLOYEE ID ");
        }
    }

    double Amount(JTextField tx) {
        if (!tx.getText().isEmpty()) {
            String ln[] = tx.getText().split(":");
            if (ln.length == 2) {
                double d = Double.parseDouble(ln[1]);
                return d;
            } else {
                return 0;
            }
        }
        return 0;
    }

    void addToTable() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_pay.getModel();
        Vector v = new Vector();
        v.add(payid.getText());
        v.add(cmb_pay_empid.getSelectedItem());
        v.add(txt_pay_lanme.getText());
        v.add(txt_pay_earning.getText());
        v.add(txt_pay_ot.getText());
        v.add(txt_pay_hlday.getText());
        v.add(txt_pay_laon.getText());
        v.add(txt_pay_deduct.getText());
        v.add(txt_pay_tot.getText());
        v.add(month());
        v.add(date());
        v.add(year());
        dtm.addRow(v);
    }

    void setToDB() {
        try {
            new JDBC().putData("INSERT INTO pay VALUES('" + payid.getText() + "','" + cmb_pay_empid.getSelectedItem() + "','" + Amount(txt_pay_earning) + "',"
                    + "'" + Amount(txt_pay_ot) + "','" + Amount(txt_pay_hlday) + "','" + Amount(txt_pay_laon) + "','" + Amount(txt_pay_deduct) + "',"
                    + "'" + Amount(txt_pay_tot) + "','" + date() + "','" + month() + "','" + txt_pay_lanme.getText() + "','" + year() + "' ) ");
            printReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void searchEnable() {
        if (cmb_pay_search.getSelectedItem().equals("Emp ID")) {
            txt_pay_search.setEnabled(true);
        } else {
            txt_pay_search.setEnabled(false);
        }
    }

    int month() {
        String ar[] = new Add_customer().Today().split("-");
        int mnth = Integer.parseInt(ar[1]);
        return mnth;

    }

    int date() {
        String dat[] = new Add_customer().Today().split("-");
        int day = Integer.parseInt(dat[2]);
        return day;
    }

    int year() {
        String yer[] = new Add_customer().Today().split("-");
        int year = Integer.parseInt(yer[0]);
        return year;
    }

    void cls() {
        cmb_pay_empid.getModel().setSelectedItem("Select");
        txt_pay_fname.setText(null);
        txt_pay_lanme.setText(null);
        txt_pay_designation.setText(null);
        txt_pay_earning.setText(null);
        txt_pay_ot.setText(null);
        txt_pay_hlday.setText(null);
        txt_pay_deduct.setText(null);
        chk_pay_otherdeduc.setSelected(false);
        txt_pay_laon.setText(null);
        txt_pay_tot.setText(null);
    }

    void otherDed() {
        if (chk_pay_otherdeduc.isSelected()) {
            String ar[] = txt_pay_deduct.getText().split(":");
            if (ar.length >= 2) {
                double b1 = Double.parseDouble(ar[1]);
                String tot[] = txt_pay_tot.getText().split(":");
                double b2 = Double.parseDouble(tot[1]);
                if (tot.length == 2) {
                    double sum = b2 - b1;
                    txt_pay_tot.setText("Rs:" + String.valueOf(sum));
                }
            }
        }
        btn_pay_minus.setEnabled(false);
        btn_pay_pay.grabFocus();
    }

    int mchMonth(JMonthChooser mc) {
        int i = mc.getMonth() + 1;
        return i;

    }

    void monthSearch() {
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM pay WHERE month='" + mchMonth(mch_pay) + "' AND year='" + year() + "' ");
            if (!r.wasNull()) {
                new Add_customer().removeAllRow(tbl_pay);
                while (r.next()) {
                    DefaultTableModel dtm = (DefaultTableModel) tbl_pay.getModel();
                    Vector v = new Vector();
                    v.add(r.getString("payid"));
                    v.add(r.getString("empid"));
                    v.add(r.getString("name"));
                    v.add("Rs:" + r.getString("earn"));
                    v.add("Rs:" + r.getString("ot"));
                    v.add("Rs:" + r.getString("halfday"));
                    v.add("Rs:" + r.getString("loan"));
                    v.add("Rs:" + r.getString("other"));
                    v.add("Rs:" + r.getString("tot"));
                    v.add(r.getString("month"));
                    v.add(r.getString("date"));
                    v.add(r.getString("year"));
                    dtm.addRow(v);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void searchRecord(String sql, JTable tbl) {
        try {
            ResultSet r = new JDBC().getData(sql);
            new Add_customer().removeAllRow(tbl);
            while (r.next()) {
                DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
                Vector v = new Vector();
                v.add(r.getString("payid"));
                v.add(r.getString("empid"));
                v.add(r.getString("name"));
                v.add("Rs:" + r.getString("earn"));
                v.add("Rs:" + r.getString("ot"));
                v.add("Rs:" + r.getString("halfday"));
                v.add("Rs:" + r.getString("loan"));
                v.add("Rs:" + r.getString("other"));
                v.add("Rs:" + r.getString("tot"));
                v.add(new pay_employee().monthName(r.getInt("month")));
                v.add(r.getString("date"));
                v.add(r.getString("year"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void viewAll() {
        final allPayments all = new allPayments();
        all.setOpacity(0.88f);
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    all.setLocation(i, 39);
                    all.setVisible(true);
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Thread.currentThread().stop();
            }
        }).start();
    }

    void cmbAction() {
        if (!cmb_pay_empid.getSelectedItem().equals("Select")) {
            try {
                String id = cmb_pay_empid.getSelectedItem().toString();
                ResultSet r = new JDBC().getData("SELECT * FROM employee WHERE empid='" + id + "' ");
                ResultSet er = new JDBC().getData("SELECT normal*(SELECT COUNT(date) FROM attendance WHERE empid='" + id + "' AND month='" + month() + "' AND year='" + year() + "' ) AS earn,"
                        + " (ot/60)*(SELECT SUM(hour) FROM ot WHERE empid='" + id + "' AND month='" + month() + "' AND year='" + year() + "' )AS oth,"
                        + "halfd*(SELECT COUNT(date) FROM half WHERE empid='" + id + "' AND month='" + month() + "' AND year='" + year() + "' )AS hl"
                        + " FROM rate WHERE empid='" + id + "' ");
                ResultSet ln = new JDBC().getData("SELECT amount/install AS dloan FROM loan WHERE empid='" + id + "' ");
                if (r.next()) {
                    String ar[] = r.getString("name").split(",");
                    txt_pay_fname.setText(ar[0]);
                    txt_pay_lanme.setText(ar[2]);
                    txt_pay_designation.setText(r.getString("designation"));

                    if (er.next()) {
                        amountToText(txt_pay_earning, RoundTo2Decimals(er.getDouble("earn")));
                        txt_pay_hlday.setText("Rs:" + RoundTo2Decimals(er.getDouble("hl")));
                        txt_pay_ot.setText("Rs:" + RoundTo2Decimals(er.getDouble("oth")));
                        if (ln.next()) {
                            txt_pay_laon.setText("Rs:" + RoundTo2Decimals(ln.getDouble("dloan")));
                        } else {
                            txt_pay_laon.setText("Rs:0");
                        }
                        totalText();
                        chk_pay_otherdeduc.setEnabled(true);

                        if (!payMonth) {
                            cls();
                            btn_pay_pay.setEnabled(false);
                        }

                    }

                    ResultSet pay = new JDBC().getData("SELECT pdate FROM rate WHERE empid='" + id + "' ");
                    if (pay.next()) {

                        if (pay.getInt("pdate") == (date())) {
                            btn_pay_pay.setEnabled(true);
                        } else {
                            btn_pay_pay.setEnabled(false);
                        }

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            cls();
            chk_pay_otherdeduc.setEnabled(false);
        }
    }

    double deduc(boolean b) {
        double i = 0;
        double i2 = 0;
        try {
            i = Double.parseDouble(txt_pay_tot.getText().substring(3));
            i2 = Double.parseDouble(txt_pay_deduct.getText().substring(4));
            if (i2 >= i) {
                txt_pay_deduct.setBackground(Color.RED);
                //JOptionPane.showMessageDialog(this, "SORRY Amount Lagre to Salary", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                txt_pay_deduct.setBackground(Color.WHITE);
            }

        } catch (java.lang.NumberFormatException | java.lang.StringIndexOutOfBoundsException e) {
        }
        if (b) {
            return i;
        } else {
            return i2;
        }

    }

    boolean amountToText(JTextField tx1, double d) {
        if (d == 0) {
            JOptionPane.showMessageDialog(this, "Attendance Record NOT AVAILABLE For This Month", title, JOptionPane.WARNING_MESSAGE);
            payMonth = false;
        } else {
            tx1.setText("Rs:" + d);
            payMonth = true;
        }
        return payMonth;
    }

    void printReport() {
        try {
            String reportPath = "src\\reports\\payPrint.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", cmb_pay_empid.getSelectedItem());
            params.put("date", printDate());
            params.put("desig", txt_pay_designation.getText());
            params.put("payid", payid.getText());
            params.put("empid", cmb_pay_empid.getSelectedItem());
            params.put("earn", txt_pay_earning.getText());
            params.put("ot", txt_pay_ot.getText());
            params.put("halfd", txt_pay_hlday.getText());
            params.put("loan", txt_pay_laon.getText());
            params.put("other", txt_pay_deduct.getText());
            params.put("tot", txt_pay_tot.getText());

            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr, params, new JREmptyDataSource());
           JasperPrintManager.printReport(jp, true);
            //JasperViewer.viewReport(jp,true );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String printDate() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

    double RoundTo2Decimals(double val) {
        DecimalFormat df = new DecimalFormat("#####.##");
        return Double.valueOf(df.format(val));
    }

}

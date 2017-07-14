package interfaces;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.ModernBalloonStyle;
import net.java.balloontip.utils.FadingUtils;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Hashith
 */
public class pay_loan extends javax.swing.JInternalFrame {

    public pay_loan() {
        super("Loan", true, true, true, true);
        initComponents();
        new Add_customer().Id("SELECT COUNT(id)+1 AS newid FROM loan", txt_loan_id, "LON", "%05d");
        setToCombo(cmb_loan_empid, "SELECT empid FROM rate");
        dch_loan_date.setDate(new Date());
        new editLoanType().toCombo(cmb_loan_type);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_head = new javax.swing.JLabel();
        lbl_head_icon = new javax.swing.JLabel();
        pnl1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_loan_install = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_loan_id = new javax.swing.JTextField();
        txt_loan_fname = new javax.swing.JTextField();
        txt_loan_lname = new javax.swing.JTextField();
        txt_loan_design = new javax.swing.JTextField();
        txt_loan_bsalary = new javax.swing.JTextField();
        txt_loan_amount = new javax.swing.JTextField();
        txt_loan_install = new javax.swing.JTextField();
        dch_loan_date = new com.toedter.calendar.JDateChooser();
        btn_loan_fomerlon = new javax.swing.JButton();
        btn_loan_pay = new javax.swing.JButton();
        btn_loan_cancel = new javax.swing.JButton();
        cmb_loan_empid = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cmb_loan_type = new javax.swing.JComboBox();
        pnl2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_loan_vwcunt = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer r,int rw,int col){
                Component c = super.prepareRenderer(r, rw, col);
                //        c.setBackground(Color.WHITE);

                if (!isRowSelected(rw)){
                    c.setBackground(getBackground());
                    int modelRow = convertRowIndexToModel(rw);
                    String row = (String)tbl_loan_vwcunt.getValueAt(modelRow, 4);
                    int rows = Integer.parseInt(row);
                    if(rows>0){
                        c.setBackground(Color.red);
                    }
                }
                return c;
            }
        };
        txt_loan_search = new javax.swing.JTextField();
        btn_loan_search = new javax.swing.JButton();
        btn_loan_vwall = new javax.swing.JButton();
        pnl3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_loan_vw = new javax.swing.JTable();
        pnl4 = new javax.swing.JPanel();
        btn_loan_vwsheet = new javax.swing.JButton();
        btn_loan_editlt = new javax.swing.JButton();
        btn_loan_addNew = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/wallet-26.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1366, 730));
        setPreferredSize(new java.awt.Dimension(1366, 730));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_head.setFont(new java.awt.Font("Segoe UI Light", 0, 40)); // NOI18N
        lbl_head.setText("Loans");
        getContentPane().add(lbl_head, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        lbl_head_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/bank_cards-64.png"))); // NOI18N
        getContentPane().add(lbl_head_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        pnl1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Basic Salary");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Emp ID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("First Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Last Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Designation");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Loan Amount");

        lbl_loan_install.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_loan_install.setText("Instalment");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Date");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Loan ID");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Due Loan");

        txt_loan_id.setEditable(false);
        txt_loan_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_loan_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loan_idActionPerformed(evt);
            }
        });

        txt_loan_fname.setEditable(false);
        txt_loan_fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_loan_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loan_fnameActionPerformed(evt);
            }
        });

        txt_loan_lname.setEditable(false);
        txt_loan_lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_loan_design.setEditable(false);
        txt_loan_design.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_loan_bsalary.setEditable(false);
        txt_loan_bsalary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_loan_bsalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loan_bsalaryActionPerformed(evt);
            }
        });
        txt_loan_bsalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_loan_bsalaryKeyPressed(evt);
            }
        });

        txt_loan_amount.setEditable(false);
        txt_loan_amount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_loan_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loan_amountActionPerformed(evt);
            }
        });
        txt_loan_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_loan_amountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_loan_amountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_loan_amountKeyTyped(evt);
            }
        });

        txt_loan_install.setEditable(false);
        txt_loan_install.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_loan_install.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loan_installActionPerformed(evt);
            }
        });
        txt_loan_install.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_loan_installKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_loan_installKeyTyped(evt);
            }
        });

        dch_loan_date.setDateFormatString("yyyy-MM-dd");
        dch_loan_date.setEnabled(false);

        btn_loan_fomerlon.setText("___");
        btn_loan_fomerlon.setEnabled(false);
        btn_loan_fomerlon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loan_fomerlonActionPerformed(evt);
            }
        });

        btn_loan_pay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/bank-26.png"))); // NOI18N
        btn_loan_pay.setText("Pay");
        btn_loan_pay.setEnabled(false);
        btn_loan_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loan_payActionPerformed(evt);
            }
        });

        btn_loan_cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/cancel-26.png"))); // NOI18N
        btn_loan_cancel.setText("Cancel");
        btn_loan_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loan_cancelActionPerformed(evt);
            }
        });

        cmb_loan_empid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_loan_empid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        cmb_loan_empid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb_loan_empidMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmb_loan_empidMouseEntered(evt);
            }
        });
        cmb_loan_empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_loan_empidActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Loan Category");

        cmb_loan_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_loan_type.setMaximumRowCount(100);
        cmb_loan_type.setEnabled(false);
        cmb_loan_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_loan_typeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_loan_pay)
                        .addGap(18, 18, 18)
                        .addComponent(btn_loan_cancel))
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_loan_install, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl1Layout.createSequentialGroup()
                                .addComponent(cmb_loan_empid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(txt_loan_id, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmb_loan_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_loan_fomerlon)
                                .addComponent(txt_loan_lname)
                                .addComponent(txt_loan_design)
                                .addComponent(txt_loan_bsalary)
                                .addComponent(txt_loan_amount)
                                .addComponent(txt_loan_install)
                                .addComponent(dch_loan_date, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                            .addComponent(txt_loan_fname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                        .addGap(191, 191, 191)))
                .addGap(25, 25, 25))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_loan_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 21, Short.MAX_VALUE)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmb_loan_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(19, 19, 19)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmb_loan_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_loan_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_loan_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_loan_design, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_loan_bsalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(btn_loan_fomerlon))
                .addGap(18, 18, 18)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_loan_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_loan_install)
                    .addComponent(txt_loan_install, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(dch_loan_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_loan_pay)
                    .addComponent(btn_loan_cancel))
                .addGap(37, 37, 37))
        );

        getContentPane().add(pnl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 580, 540));

        pnl2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current State", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 0, 18))); // NOI18N
        pnl2.setOpaque(false);

        tbl_loan_vwcunt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loan ID", "Emp ID", "Name", "Loan Amount", "Install..", "Date", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_loan_vwcunt.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tbl_loan_vwcunt.getTableHeader().setResizingAllowed(false);
        tbl_loan_vwcunt.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_loan_vwcunt);
        if (tbl_loan_vwcunt.getColumnModel().getColumnCount() > 0) {
            tbl_loan_vwcunt.getColumnModel().getColumn(0).setResizable(false);
            tbl_loan_vwcunt.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_loan_vwcunt.getColumnModel().getColumn(1).setResizable(false);
            tbl_loan_vwcunt.getColumnModel().getColumn(2).setResizable(false);
            tbl_loan_vwcunt.getColumnModel().getColumn(3).setResizable(false);
            tbl_loan_vwcunt.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbl_loan_vwcunt.getColumnModel().getColumn(4).setResizable(false);
            tbl_loan_vwcunt.getColumnModel().getColumn(4).setPreferredWidth(30);
            tbl_loan_vwcunt.getColumnModel().getColumn(5).setResizable(false);
            tbl_loan_vwcunt.getColumnModel().getColumn(5).setPreferredWidth(60);
            tbl_loan_vwcunt.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );

        getContentPane().add(pnl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 630, 200));

        txt_loan_search.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        txt_loan_search.setForeground(new java.awt.Color(153, 153, 153));
        txt_loan_search.setText("Enter Emp ID or Name");
        txt_loan_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_loan_searchMouseClicked(evt);
            }
        });
        txt_loan_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_loan_searchKeyPressed(evt);
            }
        });
        getContentPane().add(txt_loan_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 250, -1));

        btn_loan_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/search-32.png"))); // NOI18N
        btn_loan_search.setToolTipText("");
        btn_loan_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loan_searchActionPerformed(evt);
            }
        });
        getContentPane().add(btn_loan_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 20, 80, -1));

        btn_loan_vwall.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_loan_vwall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/View_Details-26.png"))); // NOI18N
        btn_loan_vwall.setText("View All");
        btn_loan_vwall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loan_vwallActionPerformed(evt);
            }
        });
        getContentPane().add(btn_loan_vwall, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 360, 120, -1));

        tbl_loan_vw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loan ID", "Emp ID", "Name", "Loan Amount", "Install..", "Date", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_loan_vw.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tbl_loan_vw.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_loan_vw.getTableHeader().setResizingAllowed(false);
        tbl_loan_vw.getTableHeader().setReorderingAllowed(false);
        tbl_loan_vw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_loan_vwMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_loan_vwMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_loan_vw);
        if (tbl_loan_vw.getColumnModel().getColumnCount() > 0) {
            tbl_loan_vw.getColumnModel().getColumn(0).setResizable(false);
            tbl_loan_vw.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_loan_vw.getColumnModel().getColumn(1).setResizable(false);
            tbl_loan_vw.getColumnModel().getColumn(2).setResizable(false);
            tbl_loan_vw.getColumnModel().getColumn(3).setResizable(false);
            tbl_loan_vw.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbl_loan_vw.getColumnModel().getColumn(4).setResizable(false);
            tbl_loan_vw.getColumnModel().getColumn(4).setPreferredWidth(30);
            tbl_loan_vw.getColumnModel().getColumn(5).setResizable(false);
            tbl_loan_vw.getColumnModel().getColumn(5).setPreferredWidth(60);
            tbl_loan_vw.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );

        getContentPane().add(pnl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 610, 270));

        pnl4.setOpaque(false);

        btn_loan_vwsheet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_loan_vwsheet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/paper-26.png"))); // NOI18N
        btn_loan_vwsheet.setText("View Loan Sheet");
        btn_loan_vwsheet.setEnabled(false);
        btn_loan_vwsheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loan_vwsheetActionPerformed(evt);
            }
        });

        btn_loan_editlt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_loan_editlt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/installing_updates-26.png"))); // NOI18N
        btn_loan_editlt.setText("Edit Loan Types Cateogry");
        btn_loan_editlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loan_editltActionPerformed(evt);
            }
        });

        btn_loan_addNew.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_loan_addNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/categorize-26.png"))); // NOI18N
        btn_loan_addNew.setText("Add New Loan Category");
        btn_loan_addNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loan_addNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl4Layout = new javax.swing.GroupLayout(pnl4);
        pnl4.setLayout(pnl4Layout);
        pnl4Layout.setHorizontalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_loan_addNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_loan_editlt, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_loan_vwsheet, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        pnl4Layout.setVerticalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_loan_addNew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_loan_editlt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_loan_vwsheet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(pnl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 600, 680, 100));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/background.png"))); // NOI18N
        lbl_background.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_backgroundKeyPressed(evt);
            }
        });
        getContentPane().add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_loan_installActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loan_installActionPerformed

    }//GEN-LAST:event_txt_loan_installActionPerformed

    private void txt_loan_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loan_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loan_amountActionPerformed

    private void btn_loan_fomerlonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loan_fomerlonActionPerformed

        if (btn_loan_fomerlon.getText().equals("YES")) {
            try {
                ResultSet ln = new JDBC().getData("SELECT * FROM loan WHERE empid='" + cmb_loan_empid.getSelectedItem() + "' ");
                ResultSet lnhst = new JDBC().getData("SELECT * FROM loanhistory WHERE empid='" + cmb_loan_empid.getSelectedItem() + "' ");
                DefaultTableModel dtm = (DefaultTableModel) tbl_loan_vwcunt.getModel();
                DefaultTableModel dtm1 = (DefaultTableModel) tbl_loan_vw.getModel();
                while (ln.next()) {
                    new Add_customer().removeAllRow(tbl_loan_vwcunt);
                    Vector v = new Vector();
                    v.add(ln.getString("id"));
                    v.add(ln.getString("empid"));
                    v.add(ln.getString("name"));
                    v.add("Rs:" + ln.getString("amount"));
                    v.add(ln.getString("install"));
                    v.add(ln.getString("date"));
                    dtm.addRow(v);

                }
                while (lnhst.next()) {
                    new Add_customer().removeAllRow(tbl_loan_vw);
                    Vector v1 = new Vector();
                    v1.add(lnhst.getString("id"));
                    v1.add(lnhst.getString("empid"));
                    v1.add(lnhst.getString("name"));
                    v1.add("Rs:" + lnhst.getString("amount"));
                    v1.add(lnhst.getString("install"));
                    v1.add(lnhst.getString("date"));
                    dtm1.addRow(v1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btn_loan_fomerlonActionPerformed

    private void btn_loan_vwallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loan_vwallActionPerformed

        refresh();
        refreshCurnt();
    }//GEN-LAST:event_btn_loan_vwallActionPerformed

    private void txt_loan_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loan_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loan_idActionPerformed

    private void cmb_loan_empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_loan_empidActionPerformed

        if (cmb_loan_empid.getSelectedItem().equals("Select")) {
            cls();
        } else {
            try {
                ResultSet r = new JDBC().getData("SELECT * FROM employee WHERE empid='" + cmb_loan_empid.getSelectedItem() + "' ");
                ResultSet rsl = new JDBC().getData("SELECT normal*30 AS bsalary FROM rate WHERE empid='" + cmb_loan_empid.getSelectedItem() + "' ");
                ResultSet flon = new JDBC().getData("SELECT empid,type FROM loan WHERE amount>0 AND empid='" + cmb_loan_empid.getSelectedItem() + "' ");
                if (r.next()) {
                    String ar[] = r.getString("name").split(",");
                    txt_loan_fname.setText(ar[0]);
                    txt_loan_lname.setText(ar[2]);
                    txt_loan_design.setText(r.getString("designation"));
                }
                if (rsl.next()) {
                    if (rsl.getString("bsalary").isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Salary Details NOT AVAILABLE", "Pay Rate", JOptionPane.WARNING_MESSAGE);
                    } else {
                        txt_loan_bsalary.setText("Rs:" + rsl.getString("bsalary"));
                    }
                }
                if (flon.next()) {
                    btn_loan_fomerlon.setEnabled(true);
                    btn_loan_fomerlon.setText("YES");
                    btn_loan_pay.setEnabled(false);
                    txt_loan_amount.setEditable(false);
                    txt_loan_amount.setEditable(false);
                    txt_loan_install.setEditable(false);
                    dch_loan_date.setEnabled(false);
                    cmb_loan_type.setEnabled(false);
                    cmb_loan_type.setSelectedItem(flon.getString("type"));
                } else {
                    btn_loan_fomerlon.setEnabled(false);
                    btn_loan_fomerlon.setText("NO");
                    txt_loan_amount.setEditable(true);
                    txt_loan_amount.setText("Rs:");
                    txt_loan_amount.grabFocus();
                    txt_loan_install.setEditable(true);
                    dch_loan_date.setEnabled(true);
                    cmb_loan_type.setEnabled(true);
                    cmb_loan_type.setSelectedItem("Select");
                    new Add_customer().removeAllRow(tbl_loan_vw);
                    new Add_customer().removeAllRow(tbl_loan_vwcunt);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_cmb_loan_empidActionPerformed

    private void cmb_loan_empidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_loan_empidMouseClicked

    }//GEN-LAST:event_cmb_loan_empidMouseClicked

    private void cmb_loan_empidMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_loan_empidMouseEntered

    }//GEN-LAST:event_cmb_loan_empidMouseEntered

    private void txt_loan_bsalaryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loan_bsalaryKeyPressed


    }//GEN-LAST:event_txt_loan_bsalaryKeyPressed

    private void txt_loan_amountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loan_amountKeyPressed

        if (txt_loan_amount.getText().isEmpty() || txt_loan_amount.getText().substring(3).isEmpty()) {
            txt_loan_amount.setText("Rs: ");

        } else {
            if (evt.getKeyCode() == 10 && !txt_loan_amount.getText().equals("Rs: ")) {
                txt_loan_install.grabFocus();
            }
        }
    }//GEN-LAST:event_txt_loan_amountKeyPressed

    private void btn_loan_payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loan_payActionPerformed

        if (cmb_loan_empid.getSelectedItem().equals("Select")) {
            JOptionPane.showMessageDialog(this, "PLEASE Select An Emp ID");
        } else {
            if (btn_loan_fomerlon.getText().equals("YES")) {

            } else {
                if (!txt_loan_amount.getText().equals("Rs:")) {
                    if (txt_loan_install.getText().isEmpty()) {
                        lbl_loan_install.setForeground(Color.red);
                        JOptionPane.showMessageDialog(this, "PLEASE enter Valid VALUE");
                    } else {
                        addToDB();
                        new Add_customer().Id("SELECT COUNT(id)+1 AS newid FROM loan", txt_loan_id, "LON", "%05d");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Fill Information Correctly");
                }
            }
        }
    }//GEN-LAST:event_btn_loan_payActionPerformed

    private void btn_loan_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loan_cancelActionPerformed

        cls();
    }//GEN-LAST:event_btn_loan_cancelActionPerformed

    private void lbl_backgroundKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_backgroundKeyPressed
    }//GEN-LAST:event_lbl_backgroundKeyPressed

    private void txt_loan_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_loan_searchMouseClicked

        searchText("Tahoma", 0, 0, null, txt_loan_search);

    }//GEN-LAST:event_txt_loan_searchMouseClicked

    private void txt_loan_installKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loan_installKeyTyped

        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
        if (txt_loan_install.getText().length() >= 2) {
            String msg = "<html><b>Please Enter<u>Appropriate Value</u></b></html>";
            ModernBalloonStyle style = new ModernBalloonStyle(10, 10, new java.awt.Color(125, 125, 125), new java.awt.Color(150, 150, 150), Color.BLUE);
            BalloonTip tip = new BalloonTip(txt_loan_install, msg, style, false);

            FadingUtils.fadeOutBalloon(tip, getActionForKeyStroke(null), 3000, 5);
            txt_loan_install.setForeground(Color.red);
        }
        if (txt_loan_install.getText().length() <= 2) {
            txt_loan_install.setForeground(Color.black);
            btn_loan_pay.setEnabled(true);
        }

    }//GEN-LAST:event_txt_loan_installKeyTyped

    private void btn_loan_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loan_searchActionPerformed

        if (txt_loan_search.getText().isEmpty() || txt_loan_search.getText().equals("Enter Emp ID or Name")) {
            JOptionPane.showMessageDialog(this, "PLEASE Enter Emp ID or Name");
            searchText("Tempus Sans ITC", 1, 153, "Enter Emp ID or Name", txt_loan_search);
        } else {
            search();
            if (tbl_loan_vw.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No Record Found");
            }
            searchText("Tempus Sans ITC", 1, 153, "Enter Emp ID or Name", txt_loan_search);
        }
    }//GEN-LAST:event_btn_loan_searchActionPerformed

    private void tbl_loan_vwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_loan_vwMouseClicked

        DefaultTableModel dtm = (DefaultTableModel) tbl_loan_vw.getModel();
        int row = tbl_loan_vw.getSelectedRow();
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM loan WHERE empid='" + dtm.getValueAt(row, 1) + "' ");
            if (r.next()) {
                DefaultTableModel dtm1 = (DefaultTableModel) tbl_loan_vwcunt.getModel();
                new Add_customer().removeAllRow(tbl_loan_vwcunt);
                Vector v = new Vector();
                v.add(r.getString("id"));
                v.add(r.getString("empid"));
                v.add(r.getString("name"));
                v.add("Rs:" + r.getString("amount"));
                v.add(r.getString("install"));
                v.add(r.getString("date"));
                v.add(r.getString("type"));
                dtm1.addRow(v);
            } else {
                new Add_customer().removeAllRow(tbl_loan_vwcunt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tbl_loan_vwMouseClicked

    private void txt_loan_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loan_searchKeyPressed

        if (evt.getKeyCode() == 10) {
            if (txt_loan_search.getText().isEmpty() || txt_loan_search.getText().equals("Enter Emp ID or Name")) {
                JOptionPane.showMessageDialog(this, "PLEASE Enter Emp ID or Name");
            } else {
                search();
                if (tbl_loan_vw.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "No Record Found");
                }
                searchText("Tempus Sans ITC", 1, 153, "Enter Emp ID or Name", txt_loan_search);
            }
        }
        if (evt.getKeyCode() == 8) {
            if (txt_loan_search.getText().equals("Enter Emp ID or Name")) {
                searchText("Tahoma", 0, 0, null, txt_loan_search);
            }
        }
    }//GEN-LAST:event_txt_loan_searchKeyPressed

    private void txt_loan_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loan_amountKeyTyped

        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_loan_amountKeyTyped

    private void txt_loan_installKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loan_installKeyReleased

        if (txt_loan_install.getText().length() == 3) {
            txt_loan_install.setForeground(Color.red);
            btn_loan_pay.setEnabled(false);
        }
    }//GEN-LAST:event_txt_loan_installKeyReleased

    private void btn_loan_addNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loan_addNewActionPerformed

        loantype lt = new loantype();
        lt.setVisible(true);

    }//GEN-LAST:event_btn_loan_addNewActionPerformed

    private void btn_loan_editltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loan_editltActionPerformed

        new editLoanType().setVisible(true);
    }//GEN-LAST:event_btn_loan_editltActionPerformed

    private void cmb_loan_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_loan_typeActionPerformed

        if (cmb_loan_type.getSelectedItem().equals("Select")) {
            txt_loan_amount.setEnabled(false);
            txt_loan_install.setEnabled(false);
            btn_loan_pay.setEnabled(false);
        } else {
            if (btn_loan_fomerlon.getText().equals("NO")) {
                btn_loan_pay.setEnabled(true);
                txt_loan_amount.setEnabled(true);
                txt_loan_install.setEnabled(true);
                txt_loan_amount.setText("Rs:");
                txt_loan_amount.grabFocus();
            }
        }
    }//GEN-LAST:event_cmb_loan_typeActionPerformed

    private void txt_loan_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loan_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loan_fnameActionPerformed

    private void txt_loan_bsalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loan_bsalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loan_bsalaryActionPerformed

    private void txt_loan_amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loan_amountKeyReleased

        double textValue = Double.valueOf(txt_loan_amount.getText().substring(4));
        if (textValue > maxAmount()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Value Is Large To Lone Category", "Loan", JOptionPane.WARNING_MESSAGE);
            btn_loan_pay.setEnabled(false);
        } else {
            btn_loan_pay.setEnabled(true);
        }

    }//GEN-LAST:event_txt_loan_amountKeyReleased

    private void btn_loan_vwsheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loan_vwsheetActionPerformed

        DefaultTableModel model = (DefaultTableModel) tbl_loan_vw.getModel();
        int selectedRow = tbl_loan_vw.getSelectedRow();
        
        btn_loan_vwsheet.setEnabled(false);
        new LoanSheet(model.getValueAt(selectedRow, 0), model.getValueAt(selectedRow, 1)).setVisible(true);
    }//GEN-LAST:event_btn_loan_vwsheetActionPerformed

    private void tbl_loan_vwMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_loan_vwMouseReleased

        btn_loan_vwsheet.setEnabled(true);
    }//GEN-LAST:event_tbl_loan_vwMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_loan_addNew;
    private javax.swing.JButton btn_loan_cancel;
    private javax.swing.JButton btn_loan_editlt;
    private javax.swing.JButton btn_loan_fomerlon;
    private javax.swing.JButton btn_loan_pay;
    private javax.swing.JButton btn_loan_search;
    private javax.swing.JButton btn_loan_vwall;
    private javax.swing.JButton btn_loan_vwsheet;
    private javax.swing.JComboBox cmb_loan_empid;
    private javax.swing.JComboBox cmb_loan_type;
    private com.toedter.calendar.JDateChooser dch_loan_date;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_head;
    private javax.swing.JLabel lbl_head_icon;
    private javax.swing.JLabel lbl_loan_install;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl4;
    private javax.swing.JTable tbl_loan_vw;
    private javax.swing.JTable tbl_loan_vwcunt;
    private javax.swing.JTextField txt_loan_amount;
    private javax.swing.JTextField txt_loan_bsalary;
    private javax.swing.JTextField txt_loan_design;
    private javax.swing.JTextField txt_loan_fname;
    private javax.swing.JTextField txt_loan_id;
    private javax.swing.JTextField txt_loan_install;
    private javax.swing.JTextField txt_loan_lname;
    private javax.swing.JTextField txt_loan_search;
    // End of variables declaration//GEN-END:variables

    void setToCombo(JComboBox cm, String sql) {
        try {
            ResultSet r = new JDBC().getData(sql);
            Vector v = new Vector<>();
            v.add("Select");
            while (r.next()) {
                v.add(r.getString("empid"));
            }
            cm.setModel(new DefaultComboBoxModel<>(v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String chooserDate(JDateChooser dch) {
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdt.format(dch.getDate());
        return date;
    }

    void addToDB() {
        if (!cmb_loan_empid.getSelectedItem().equals("Select")) {
            try {
                new JDBC().putData("INSERT INTO loan VALUES('" + txt_loan_id.getText() + "','" + cmb_loan_empid.getSelectedItem() + "','" + loanText() + "','" + txt_loan_install.getText() + "',"
                        + "'" + payDate() + "','" + txt_loan_fname.getText() + "," + txt_loan_lname.getText() + "','" + cmb_loan_type.getSelectedItem() + "')");
                new JDBC().putData("INSERT INTO loanhistory VALUES('" + txt_loan_id.getText() + "','" + cmb_loan_empid.getSelectedItem() + "','" + loanText() + "','" + txt_loan_install.getText() + "',"
                        + "'" + payDate() + "','" + txt_loan_fname.getText() + "," + txt_loan_lname.getText() + "','" + cmb_loan_type.getSelectedItem() + "')");
                addToTable();
                printReport();
                JOptionPane.showMessageDialog(this, "Record has been ADDED");
                cls();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "PLEASE Select an Emp ID");
        }
    }

    void addToTable() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_loan_vw.getModel();
        Vector v = new Vector();
        v.add(txt_loan_id.getText());
        v.add(cmb_loan_empid.getSelectedItem());
        v.add(txt_loan_fname.getText() + "," + txt_loan_lname.getText());
        v.add(txt_loan_amount.getText());
        v.add(txt_loan_install.getText());
        v.add(dch_loan_date.getDate());
        v.add(cmb_loan_type.getSelectedItem());
        dtm.addRow(v);
    }

    void cls() {
        cmb_loan_empid.getModel().setSelectedItem("Select");
        cmb_loan_type.setSelectedItem("Select");
        cmb_loan_type.setEnabled(false);
        txt_loan_fname.setText(null);
        txt_loan_lname.setText(null);
        txt_loan_design.setText(null);
        txt_loan_bsalary.setText(null);
        txt_loan_amount.setText(null);
        txt_loan_install.setText(null);
        btn_loan_fomerlon.setText("___");
        btn_loan_fomerlon.setEnabled(false);
    }

    void refresh() {
        new Add_customer().removeAllRow(tbl_loan_vw);
        try {
            ResultSet ln = new JDBC().getData("SELECT * FROM loanhistory");
            DefaultTableModel dtm = (DefaultTableModel) tbl_loan_vw.getModel();
            while (ln.next()) {
                Vector v = new Vector();
                v.add(ln.getString("id"));
                v.add(ln.getString("empid"));
                v.add(ln.getString("name"));
                v.add("Rs:" + ln.getString("amount"));
                v.add(ln.getString("install"));
                v.add(ln.getString("date"));
                v.add(ln.getString("type"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void searchText(String font, int st, int color, String txt, JTextField txtfl) {
        txtfl.setFont(new java.awt.Font(font, st, 14));
        txtfl.setForeground(new java.awt.Color(color, color, color));
        txtfl.setText(txt);
    }

    double loanText() {
        String amnt[] = txt_loan_amount.getText().split(":");
        if (amnt.length == 2) {
            double d = Double.parseDouble(amnt[1]);
            return d;
        } else {
            return 0;
        }
    }

    String payDate() {
        if (dch_loan_date.isValid()) {
            String date = chooserDate(dch_loan_date);
            return date;
        } else {
            String date = new Add_customer().Today();
            return date;
        }
    }

    void refreshCurnt() {
        new Add_customer().removeAllRow(tbl_loan_vwcunt);
        try {
            ResultSet ln = new JDBC().getData("SELECT * FROM loan");
            DefaultTableModel dtm = (DefaultTableModel) tbl_loan_vwcunt.getModel();
            while (ln.next()) {
                Vector v = new Vector();
                v.add(ln.getString("id"));
                v.add(ln.getString("empid"));
                v.add(ln.getString("name"));
                v.add("Rs:" + ln.getString("amount"));
                v.add(ln.getString("install"));
                v.add(ln.getString("date"));
                v.add(ln.getString("type"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void search() {
        if (!txt_loan_search.getText().equals("Enter Emp ID or Name")) {
            if (txt_loan_search.getText().isEmpty()) {
                searchText("Tempus Sans ITC", 1, 153, "Enter Emp ID or Name", txt_loan_search);
                JOptionPane.showMessageDialog(this, "PLEASE enter EMPLOYEE ID or NAME");
            } else {
                try {
                    ResultSet r1 = new JDBC().getData("SELECT * FROM loan WHERE empid='" + txt_loan_search.getText() + "' OR name LIKE'%" + txt_loan_search.getText() + "%'  ");
                    ResultSet r = new JDBC().getData("SELECT * FROM loanhistory WHERE empid='" + txt_loan_search.getText() + "' OR name LIKE'%" + txt_loan_search.getText() + "%' ");
                    DefaultTableModel dtm = (DefaultTableModel) tbl_loan_vw.getModel();
                    DefaultTableModel dtm1 = (DefaultTableModel) tbl_loan_vwcunt.getModel();
                    if (!r.wasNull()) {
                        new Add_customer().removeAllRow(tbl_loan_vw);
                        while (r.next()) {
                            Vector v = new Vector();
                            v.add(r.getString("id"));
                            v.add(r.getString("empid"));
                            v.add(r.getString("name"));
                            v.add("Rs:"+r.getString("amount"));
                            v.add(r.getString("install"));
                            v.add(r.getString("date"));
                            v.add(r.getString("type"));
                            dtm.addRow(v);
                        }
                    }
                    if (!r1.wasNull()) {
                        new Add_customer().removeAllRow(tbl_loan_vwcunt);
                        while (r1.next()) {
                            Vector v = new Vector();
                            v.add(r1.getString("id"));
                            v.add(r1.getString("empid"));
                            v.add(r1.getString("name"));
                            v.add("Rs:"+r1.getString("amount"));
                            v.add(r1.getString("install"));
                            v.add(r1.getString("date"));
                            v.add(r1.getString("type"));
                            dtm1.addRow(v);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            searchText("Tempus Sans ITC", 1, 153, "Enter Emp ID or Name", txt_loan_search);
            JOptionPane.showMessageDialog(this, "PLEASE enter EMPLOYEE ID or NAME");
        }
    }

    double maxAmount() {
        double amount = 0;
        try {
            ResultSet r = new JDBC().getData("SELECT amount FROM loantype WHERE type='" + cmb_loan_type.getSelectedItem() + "' ");
            if (r.next()) {
                amount = r.getDouble("amount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    void printReport() {
        try {
            String reportPath = "src\\reports\\payLoanPrint.jrxml";
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("desig", txt_loan_design.getText());
            params.put("empid", cmb_loan_empid.getSelectedItem());
            params.put("lid", txt_loan_id.getText());
            params.put("bsalary", txt_loan_bsalary.getText());
            params.put("ltype", cmb_loan_type.getSelectedItem());
            params.put("amount", txt_loan_amount.getText());
            params.put("install", txt_loan_install.getText());
            params.put("date", pay_pay.printDate());

            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr, params, new JREmptyDataSource());
            JasperViewer.viewReport(jp, true);
            JasperPrintManager.printReport(jp, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

}

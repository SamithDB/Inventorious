package interfaces;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hashith
 */
public class attendance extends javax.swing.JInternalFrame {

    public attendance() {
        super("Attendance", true, true, true, true);
        initComponents();
        new pay_loan().setToCombo(cmb_att_empid, "SELECT empid FROM rate");
        otEnabled(false);
        halfEnabled(false);
        tbl_ot.setEnabled(false);

    }
    Calendar cal = Calendar.getInstance();
    int month = cal.get(Calendar.MONTH) + 1;
    int year = cal.get(Calendar.YEAR);
    int date = cal.get(Calendar.DATE);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_background = new javax.swing.JPanel();
        lbl_att_head_image = new javax.swing.JLabel();
        lbl_att_head = new javax.swing.JLabel();
        pnl_att_empInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmb_att_empid = new javax.swing.JComboBox();
        txt_att_name = new javax.swing.JTextField();
        txt_att_designation = new javax.swing.JTextField();
        pnl_att_ot = new javax.swing.JPanel();
        lbl_ot_from = new javax.swing.JLabel();
        lbl_ot_to = new javax.swing.JLabel();
        spn_ot_from = new javax.swing.JSpinner();
        spn_ot_to = new javax.swing.JSpinner();
        btn_ot_calcu = new javax.swing.JButton();
        lbl_ot_count = new javax.swing.JLabel();
        txt_ot_hour = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_ot = new javax.swing.JTable();
        btn_ot_add = new javax.swing.JButton();
        btn_ot_availability = new javax.swing.JButton();
        chk_att_maxOT = new javax.swing.JCheckBox();
        pnl_att_half = new javax.swing.JPanel();
        lbl_half_date = new javax.swing.JLabel();
        lbl_half_reason = new javax.swing.JLabel();
        spn_half_datetime = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        txp_half_reson = new javax.swing.JTextPane();
        btn_half_mark = new javax.swing.JButton();
        btn_half_vw = new javax.swing.JButton();
        btn_half_clesr = new javax.swing.JButton();
        pnl_att = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_att = new javax.swing.JTable();
        btn_att_mark = new javax.swing.JButton();
        btn_att_reset = new javax.swing.JButton();
        btn_att_otEdit = new javax.swing.JButton();
        chk_att_halfDay = new javax.swing.JCheckBox();
        pnl_goto = new javax.swing.JPanel();
        lbl_att_gtpaymnnt = new javax.swing.JLabel();
        lbl_gtpayrate = new javax.swing.JLabel();
        btn_att_shortedit = new javax.swing.JButton();
        btn_att_view = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setMaximumSize(new java.awt.Dimension(1366, 734));
        setPreferredSize(new java.awt.Dimension(1366, 734));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_background.setOpaque(false);

        lbl_att_head_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/tear_of_calendar-64.png"))); // NOI18N

        lbl_att_head.setFont(new java.awt.Font("Segoe UI Light", 0, 40)); // NOI18N
        lbl_att_head.setText("Mark Attendance & OT");

        pnl_att_empInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        pnl_att_empInfo.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Employee ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Designation");

        cmb_att_empid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_att_empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_att_empidActionPerformed(evt);
            }
        });

        txt_att_name.setEditable(false);
        txt_att_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_att_designation.setEditable(false);
        txt_att_designation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnl_att_empInfoLayout = new javax.swing.GroupLayout(pnl_att_empInfo);
        pnl_att_empInfo.setLayout(pnl_att_empInfoLayout);
        pnl_att_empInfoLayout.setHorizontalGroup(
            pnl_att_empInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_att_empInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_att_empInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pnl_att_empInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_att_empInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_att_designation)
                        .addComponent(cmb_att_empid, 0, 148, Short.MAX_VALUE))
                    .addComponent(txt_att_name, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        pnl_att_empInfoLayout.setVerticalGroup(
            pnl_att_empInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_att_empInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_att_empInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_att_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_att_empInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_att_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_att_empInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_att_designation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_att_ot.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Over Time", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        pnl_att_ot.setOpaque(false);

        lbl_ot_from.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_ot_from.setText("From");

        lbl_ot_to.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_ot_to.setText("To");

        spn_ot_from.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spn_ot_from.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));

        spn_ot_to.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spn_ot_to.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));

        btn_ot_calcu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_ot_calcu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/calculator-26.png"))); // NOI18N
        btn_ot_calcu.setText("Calculate Hour Count");
        btn_ot_calcu.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        btn_ot_calcu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ot_calcuActionPerformed(evt);
            }
        });

        lbl_ot_count.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_ot_count.setText("Worked Time (min)");

        txt_ot_hour.setEditable(false);
        txt_ot_hour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tbl_ot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empid", "From", "To", "Hour Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_ot.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tbl_ot.getTableHeader().setResizingAllowed(false);
        tbl_ot.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbl_ot);
        if (tbl_ot.getColumnModel().getColumnCount() > 0) {
            tbl_ot.getColumnModel().getColumn(0).setResizable(false);
            tbl_ot.getColumnModel().getColumn(1).setResizable(false);
            tbl_ot.getColumnModel().getColumn(2).setResizable(false);
            tbl_ot.getColumnModel().getColumn(3).setResizable(false);
        }

        btn_ot_add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_ot_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/alarm_clock-26.png"))); // NOI18N
        btn_ot_add.setText("Add O/T");
        btn_ot_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ot_addActionPerformed(evt);
            }
        });

        btn_ot_availability.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_ot_availability.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/clock-32.png"))); // NOI18N
        btn_ot_availability.setText("<html>Show Available<br><b>OT <u> Hours</u></b></html>");
        btn_ot_availability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ot_availabilityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_att_otLayout = new javax.swing.GroupLayout(pnl_att_ot);
        pnl_att_ot.setLayout(pnl_att_otLayout);
        pnl_att_otLayout.setHorizontalGroup(
            pnl_att_otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_att_otLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_att_otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(pnl_att_otLayout.createSequentialGroup()
                        .addGroup(pnl_att_otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_att_otLayout.createSequentialGroup()
                                .addGroup(pnl_att_otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_ot_count, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_ot_to, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_ot_from, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(pnl_att_otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spn_ot_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_att_otLayout.createSequentialGroup()
                                        .addGroup(pnl_att_otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txt_ot_hour, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spn_ot_to, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(27, 27, 27)
                                        .addGroup(pnl_att_otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_ot_calcu)
                                            .addComponent(btn_ot_add)))))
                            .addComponent(btn_ot_availability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_att_otLayout.setVerticalGroup(
            pnl_att_otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_att_otLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_att_otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ot_from)
                    .addComponent(spn_ot_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_att_otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ot_to)
                    .addComponent(spn_ot_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ot_calcu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_att_otLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ot_count)
                    .addComponent(txt_ot_hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ot_add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ot_availability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        chk_att_maxOT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chk_att_maxOT.setText("Mark Over Time");
        chk_att_maxOT.setEnabled(false);
        chk_att_maxOT.setOpaque(false);
        chk_att_maxOT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_att_maxOTActionPerformed(evt);
            }
        });

        pnl_att_half.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Half Day", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        pnl_att_half.setOpaque(false);

        lbl_half_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_half_date.setText("Date & Time");

        lbl_half_reason.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_half_reason.setText("Reason");

        spn_half_datetime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spn_half_datetime.setModel(new javax.swing.SpinnerDateModel());

        txp_half_reson.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(txp_half_reson);

        btn_half_mark.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_half_mark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/checked_checkbox-26.png"))); // NOI18N
        btn_half_mark.setText("Mark");
        btn_half_mark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_half_markActionPerformed(evt);
            }
        });

        btn_half_vw.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_half_vw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/day_view-26.png"))); // NOI18N
        btn_half_vw.setText("View All Short Leaves");
        btn_half_vw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_half_vwActionPerformed(evt);
            }
        });

        btn_half_clesr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_half_clesr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/eraser-26.png"))); // NOI18N
        btn_half_clesr.setText("Clear Text");
        btn_half_clesr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_half_clesrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_att_halfLayout = new javax.swing.GroupLayout(pnl_att_half);
        pnl_att_half.setLayout(pnl_att_halfLayout);
        pnl_att_halfLayout.setHorizontalGroup(
            pnl_att_halfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_att_halfLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnl_att_halfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_half_reason)
                    .addComponent(lbl_half_date))
                .addGap(18, 18, 18)
                .addGroup(pnl_att_halfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_att_halfLayout.createSequentialGroup()
                        .addComponent(btn_half_mark)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_half_clesr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_half_vw))
                    .addComponent(spn_half_datetime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnl_att_halfLayout.setVerticalGroup(
            pnl_att_halfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_att_halfLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_att_halfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_half_date)
                    .addComponent(spn_half_datetime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_att_halfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_half_reason)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnl_att_halfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_half_mark, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_half_vw, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_half_clesr, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_att.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mark Attendance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        pnl_att.setOpaque(false);

        tbl_att.setBackground(new java.awt.Color(204, 204, 204));
        tbl_att.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Empid", "Attendance", "Half Day", "O/T (Hr)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_att.setOpaque(false);
        tbl_att.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tbl_att.getTableHeader().setResizingAllowed(false);
        tbl_att.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbl_att);
        if (tbl_att.getColumnModel().getColumnCount() > 0) {
            tbl_att.getColumnModel().getColumn(0).setResizable(false);
            tbl_att.getColumnModel().getColumn(1).setResizable(false);
            tbl_att.getColumnModel().getColumn(2).setResizable(false);
            tbl_att.getColumnModel().getColumn(3).setResizable(false);
        }

        btn_att_mark.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_att_mark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/checked_user-26.png"))); // NOI18N
        btn_att_mark.setText("Mark");
        btn_att_mark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_att_markActionPerformed(evt);
            }
        });

        btn_att_reset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_att_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/custimage/cancel-26.png"))); // NOI18N
        btn_att_reset.setText("Reset All");
        btn_att_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_att_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_attLayout = new javax.swing.GroupLayout(pnl_att);
        pnl_att.setLayout(pnl_attLayout);
        pnl_attLayout.setHorizontalGroup(
            pnl_attLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_attLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnl_attLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_att_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_att_mark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        pnl_attLayout.setVerticalGroup(
            pnl_attLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_attLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnl_attLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btn_att_mark)
                .addGap(18, 18, 18)
                .addComponent(btn_att_reset)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        btn_att_otEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_att_otEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/alarm_clock-32.png"))); // NOI18N
        btn_att_otEdit.setText("<html>Add/Edit Monthly<br>OT Hour Count</html>");
        btn_att_otEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_att_otEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_att_otEditActionPerformed(evt);
            }
        });

        chk_att_halfDay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chk_att_halfDay.setText("Mark Half Day");
        chk_att_halfDay.setEnabled(false);
        chk_att_halfDay.setOpaque(false);
        chk_att_halfDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_att_halfDayActionPerformed(evt);
            }
        });

        pnl_goto.setBackground(new java.awt.Color(204, 204, 204));
        pnl_goto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Go To", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        pnl_goto.setOpaque(false);

        lbl_att_gtpaymnnt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_att_gtpaymnnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/cash_receiving-48.png"))); // NOI18N
        lbl_att_gtpaymnnt.setText("Payments");
        lbl_att_gtpaymnnt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_att_gtpaymnnt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_att_gtpaymnntMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_att_gtpaymnntMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_att_gtpaymnntMouseReleased(evt);
            }
        });

        lbl_gtpayrate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_gtpayrate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/coins-48.png"))); // NOI18N
        lbl_gtpayrate.setText("Pay Rate");
        lbl_gtpayrate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_gtpayrate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_gtpayrateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_gtpayrateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_gtpayrateMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_gtpayrateMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pnl_gotoLayout = new javax.swing.GroupLayout(pnl_goto);
        pnl_goto.setLayout(pnl_gotoLayout);
        pnl_gotoLayout.setHorizontalGroup(
            pnl_gotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_gotoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lbl_att_gtpaymnnt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(lbl_gtpayrate, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_gotoLayout.setVerticalGroup(
            pnl_gotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_gotoLayout.createSequentialGroup()
                .addGroup(pnl_gotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_att_gtpaymnnt)
                    .addComponent(lbl_gtpayrate))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btn_att_shortedit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_att_shortedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/calendar-32.png"))); // NOI18N
        btn_att_shortedit.setText("<html>Add/Edit Monthly<br>Half Day Amount\n</html>");
        btn_att_shortedit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_att_shortedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_att_shorteditActionPerformed(evt);
            }
        });

        btn_att_view.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_att_view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/attendanceimage/month_view-32.png"))); // NOI18N
        btn_att_view.setText("<html>All Employee<br>Attendance<html>");
        btn_att_view.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_att_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_att_viewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_backgroundLayout = new javax.swing.GroupLayout(pnl_background);
        pnl_background.setLayout(pnl_backgroundLayout);
        pnl_backgroundLayout.setHorizontalGroup(
            pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnl_att_ot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_att_empInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_backgroundLayout.createSequentialGroup()
                        .addComponent(lbl_att_head_image)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_att_head))
                    .addComponent(chk_att_maxOT))
                .addGap(30, 30, 30)
                .addGroup(pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_att_halfDay)
                    .addGroup(pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_backgroundLayout.createSequentialGroup()
                            .addGroup(pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pnl_goto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnl_att_half, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_att_otEdit)
                                .addComponent(btn_att_shortedit)
                                .addComponent(btn_att_view)))
                        .addComponent(pnl_att, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnl_backgroundLayout.setVerticalGroup(
            pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_backgroundLayout.createSequentialGroup()
                .addGroup(pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_backgroundLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_att_head_image)
                            .addComponent(lbl_att_head))
                        .addGap(18, 18, 18)
                        .addComponent(pnl_att_empInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_backgroundLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_att, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_att_maxOT)
                    .addComponent(chk_att_halfDay))
                .addGap(18, 18, 18)
                .addGroup(pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnl_att_ot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnl_backgroundLayout.createSequentialGroup()
                            .addComponent(pnl_att_half, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pnl_goto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnl_backgroundLayout.createSequentialGroup()
                        .addComponent(btn_att_view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_att_shortedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btn_att_otEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );

        getContentPane().add(pnl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/background.png"))); // NOI18N
        getContentPane().add(lbl_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 704));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_att_empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_att_empidActionPerformed

        comboToText();

    }//GEN-LAST:event_cmb_att_empidActionPerformed

    private void lbl_att_gtpaymnntMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_att_gtpaymnntMouseEntered

        lbl_att_gtpaymnnt.setText("<html><b><u>Payments</u></b></html>");
    }//GEN-LAST:event_lbl_att_gtpaymnntMouseEntered

    private void lbl_att_gtpaymnntMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_att_gtpaymnntMouseExited

        lbl_att_gtpaymnnt.setText("Payments");
    }//GEN-LAST:event_lbl_att_gtpaymnntMouseExited

    private void lbl_gtpayrateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gtpayrateMouseEntered

        lbl_gtpayrate.setText("<html><b><u>Pay Rate</u></b></html>");
    }//GEN-LAST:event_lbl_gtpayrateMouseEntered

    private void lbl_gtpayrateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gtpayrateMouseExited

        lbl_gtpayrate.setText("Pay Rate");
    }//GEN-LAST:event_lbl_gtpayrateMouseExited

    private void btn_ot_availabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ot_availabilityActionPerformed

        JOptionPane.showMessageDialog(this, "" + cmb_att_empid.getSelectedItem() + " Available " + maxOT() + "Hours For This Month", "Availability", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_ot_availabilityActionPerformed

    private void chk_att_maxOTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_att_maxOTActionPerformed

        if (chk_att_maxOT.isSelected()) {
            if (maxOT() <= 0) {
                JOptionPane.showMessageDialog(this, "" + cmb_att_empid.getSelectedItem() + " Has No More O/T for This Month", "Availability", JOptionPane.WARNING_MESSAGE);
                chk_att_maxOT.setSelected(false);
            } else {
                otEnabled(true);
                tbl_ot.setEnabled(true);
                btn_ot_add.setEnabled(false);
            }
        } else {
            otEnabled(false);
            tbl_ot.setEnabled(false);
        }
    }//GEN-LAST:event_chk_att_maxOTActionPerformed

    private void chk_att_halfDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_att_halfDayActionPerformed

        if (chk_att_halfDay.isSelected()) {
            if (maxShort() <= 0) {
                JOptionPane.showMessageDialog(this, "" + cmb_att_empid.getSelectedItem() + " Has No More Short Leaves for This Month", "Availability", JOptionPane.WARNING_MESSAGE);
                chk_att_halfDay.setSelected(false);
            } else {
                halfEnabled(true);
                btn_att_mark.setEnabled(false);
            }
        } else {
            halfEnabled(false);
            btn_att_mark.setEnabled(true);
        }
    }//GEN-LAST:event_chk_att_halfDayActionPerformed

    private void btn_ot_calcuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ot_calcuActionPerformed

        String from = dateFromSpinner(spn_ot_from);
        String to = dateFromSpinner(spn_ot_to);
        txt_ot_hour.setText(String.valueOf(calculateTime(from, to)));
        btn_ot_add.setEnabled(true);
    }//GEN-LAST:event_btn_ot_calcuActionPerformed

    private void btn_ot_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ot_addActionPerformed

        String id = (String) cmb_att_empid.getSelectedItem();
        addOT();
        cmb_att_empid.setSelectedItem(id);
    }//GEN-LAST:event_btn_ot_addActionPerformed

    private void btn_half_clesrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_half_clesrActionPerformed

        txp_half_reson.setText(null);
    }//GEN-LAST:event_btn_half_clesrActionPerformed

    private void btn_att_otEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_att_otEditActionPerformed

        new maxOT().setVisible(true);
    }//GEN-LAST:event_btn_att_otEditActionPerformed

    private void btn_half_markActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_half_markActionPerformed

        addHalf();
    }//GEN-LAST:event_btn_half_markActionPerformed

    private void btn_att_shorteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_att_shorteditActionPerformed

        new maxHalf().setVisible(true);
    }//GEN-LAST:event_btn_att_shorteditActionPerformed

    private void btn_half_vwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_half_vwActionPerformed

        JOptionPane.showMessageDialog(this, ""+cmb_att_empid.getSelectedItem()+" Got "+availableShort()+" Days As Short Leaves", "Short Leaves", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_half_vwActionPerformed

    private void btn_att_markActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_att_markActionPerformed

        if (cmb_att_empid.getSelectedItem().equals("Select")) {
            JOptionPane.showMessageDialog(this, "PLEASE Select AN EmpID", title, JOptionPane.ERROR_MESSAGE);
        } else {
            markAtt();
        }
    }//GEN-LAST:event_btn_att_markActionPerformed

    private void btn_att_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_att_resetActionPerformed

        cmb_att_empid.setSelectedItem("Select");
        chk_att_halfDay.setSelected(false);
        chk_att_maxOT.setSelected(false);
        otEnabled(false);
        halfEnabled(false);
        btn_att_mark.setEnabled(true);
        txt_ot_hour.setText(null);
        txp_half_reson.setText(null);
    }//GEN-LAST:event_btn_att_resetActionPerformed

    private void lbl_att_gtpaymnntMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_att_gtpaymnntMouseReleased

        Home.jDesktopPane2.add(new pay_pay()).setVisible(true);
    }//GEN-LAST:event_lbl_att_gtpaymnntMouseReleased

    private void lbl_gtpayrateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gtpayrateMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_gtpayrateMousePressed

    private void lbl_gtpayrateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_gtpayrateMouseReleased

        Home.jDesktopPane2.add(new pay_payrate()).setVisible(true);
    }//GEN-LAST:event_lbl_gtpayrateMouseReleased

    private void btn_att_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_att_viewActionPerformed

        new allAttendance().setVisible(true);
    }//GEN-LAST:event_btn_att_viewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_att_mark;
    private javax.swing.JButton btn_att_otEdit;
    private javax.swing.JButton btn_att_reset;
    private javax.swing.JButton btn_att_shortedit;
    private javax.swing.JButton btn_att_view;
    private javax.swing.JButton btn_half_clesr;
    private javax.swing.JButton btn_half_mark;
    private javax.swing.JButton btn_half_vw;
    private javax.swing.JButton btn_ot_add;
    private javax.swing.JButton btn_ot_availability;
    private javax.swing.JButton btn_ot_calcu;
    private javax.swing.JCheckBox chk_att_halfDay;
    private javax.swing.JCheckBox chk_att_maxOT;
    private javax.swing.JComboBox cmb_att_empid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_att_gtpaymnnt;
    private javax.swing.JLabel lbl_att_head;
    private javax.swing.JLabel lbl_att_head_image;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JLabel lbl_gtpayrate;
    private javax.swing.JLabel lbl_half_date;
    private javax.swing.JLabel lbl_half_reason;
    private javax.swing.JLabel lbl_ot_count;
    private javax.swing.JLabel lbl_ot_from;
    private javax.swing.JLabel lbl_ot_to;
    private javax.swing.JPanel pnl_att;
    private javax.swing.JPanel pnl_att_empInfo;
    private javax.swing.JPanel pnl_att_half;
    private javax.swing.JPanel pnl_att_ot;
    private javax.swing.JPanel pnl_background;
    private javax.swing.JPanel pnl_goto;
    private javax.swing.JSpinner spn_half_datetime;
    private javax.swing.JSpinner spn_ot_from;
    private javax.swing.JSpinner spn_ot_to;
    private javax.swing.JTable tbl_att;
    private javax.swing.JTable tbl_ot;
    private javax.swing.JTextPane txp_half_reson;
    private javax.swing.JTextField txt_att_designation;
    private javax.swing.JTextField txt_att_name;
    private javax.swing.JTextField txt_ot_hour;
    // End of variables declaration//GEN-END:variables
    void comboToText() {
        chk_att_halfDay.setSelected(false);
        chk_att_maxOT.setSelected(false);
        btn_att_mark.setEnabled(true);
        otEnabled(false);
        halfEnabled(false);
        if (cmb_att_empid.getSelectedItem().equals("Select")) {
            txt_att_name.setText(null);
            txt_att_designation.setText(null);
            chk_att_halfDay.setEnabled(false);
            chk_att_maxOT.setEnabled(false);
            tbl_ot.setEnabled(false);
            chk_att_halfDay.setSelected(false);
            chk_att_maxOT.setSelected(false);
            otEnabled(false);
            halfEnabled(false);
            tbl_ot.setEnabled(false);
            new Add_customer().removeAllRow(tbl_att);
        } else {
            try {
                ResultSet r = new JDBC().getData("SELECT insname,designation FROM employee WHERE empid='" + cmb_att_empid.getSelectedItem() + "'");
                if (r.next()) {
                    txt_att_name.setText(r.getString("insname"));
                    txt_att_designation.setText(r.getString("designation"));
                    chk_att_maxOT.setEnabled(true);
                    chk_att_halfDay.setEnabled(true);
                } else {
                    chk_att_halfDay.setEnabled(false);
                    chk_att_maxOT.setEnabled(false);
                }
                attendanceAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void otEnabled(boolean b) {
        pnl_att_ot.setEnabled(b);
        spn_ot_from.setEnabled(b);
        spn_ot_to.setEnabled(b);
        txt_ot_hour.setEnabled(b);
        btn_ot_calcu.setEnabled(b);
        btn_ot_availability.setEnabled(b);
        btn_ot_add.setEnabled(b);
        lbl_ot_count.setEnabled(b);
        lbl_ot_from.setEnabled(b);
        lbl_ot_to.setEnabled(b);
    }

    void halfEnabled(boolean b) {
        pnl_att_half.setEnabled(b);
        lbl_half_date.setEnabled(b);
        lbl_half_reason.setEnabled(b);
        spn_half_datetime.setEnabled(b);
        txp_half_reson.setEnabled(b);
        btn_half_clesr.setEnabled(b);
        btn_half_mark.setEnabled(b);
        btn_half_vw.setEnabled(b);
    }

    void attendanceAll() {
        String id = (String) cmb_att_empid.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) tbl_att.getModel();
        try {
            ResultSet r = new JDBC().getData("SELECT empid,COUNT(date) AS days,(SELECT COUNT(date) FROM half WHERE empid='" + id + "' AND month='" + month + "' AND year='" + year + "') AS hf,"
                    + "(SELECT SUM(hour) FROM ot WHERE empid='" + id + "' AND month='" + month + "' AND year='" + year + "') AS oth "
                    + "FROM attendance WHERE empid='" + id + "' AND month='" + month + "' AND year='" + year + "' ");

            Vector v = new Vector();
            new Add_customer().removeAllRow(tbl_att);
            while (r.next()) {
                v.add(r.getString("empid"));
                v.add(r.getString("days"));
                v.add(r.getInt("hf"));
                v.add(hour(r.getInt("oth")));
            }
            model.addRow(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String calculateTime(String time1, String time2) {
        String anw = "";
        Date d1 = null;
        Date d2 = null;

        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm");
        try {
            d1 = format.parse(time1);
            d2 = format.parse(time2);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.lang.NumberFormatException ex) {
        }

        long diff = d2.getTime() - d1.getTime();
        long minute = diff / (60 * 1000) % 60;
        long hour = diff / (60 * 60 * 1000);

        anw = String.valueOf((hour * 60) + (minute));

        return anw;
    }

    String dateFromSpinner(JSpinner spn) {
        String date = new SimpleDateFormat("dd/MM/yyyy hh:mm").format(spn.getValue());
        return date;
    }

    String hour(int i) {
        int a = i / 60;
        int b = i % 60;
        String s = String.valueOf(a) + "." + String.valueOf(b);
        return s;

    }

    void addOT() {
        /* table hour count doesn't update */
        DefaultTableModel att = (DefaultTableModel) tbl_att.getModel();
        DefaultTableModel ott = (DefaultTableModel) tbl_ot.getModel();
        try {
            new JDBC().putData("INSERT INTO ot VALUES('" + nextID("SELECT COUNT(id)+1 AS newid FROM ot") + "',"
                    + "'" + cmb_att_empid.getSelectedItem() + "','" + year + "','" + month + "',"
                    + "'" + date + "','" + txt_ot_hour.getText() + "','" + dateFromSpinner(spn_ot_from) + "','" + dateFromSpinner(spn_ot_to) + "')");

            Vector v = new Vector();
            v.add(cmb_att_empid.getSelectedItem());
            v.add(spn_ot_from.getValue());
            v.add(spn_ot_to.getValue());
            v.add(hour(Integer.parseInt(txt_ot_hour.getText())));
            ott.addRow(v);

            String ot = (String) att.getValueAt(0, 3);
//            int hour = Integer.parseInt(ot)+Integer.parseInt(t)

            chk_att_maxOT.setSelected(false);
            otEnabled(false);
            tbl_ot.setEnabled(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String nextID(String sql) {
        String id = " ";
        try {
            ResultSet r = new JDBC().getData(sql);
            if (r.next()) {
                id = r.getString("newid");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    void clsOT() {
        txt_ot_hour.setText(null);
    }

    void addHalf() {
        DefaultTableModel model = (DefaultTableModel) tbl_att.getModel();
        try {
            new JDBC().putData("INSERT INTO half VALUES('" + nextID("SELECT COUNT(id)+1 AS newid FROM half") + "',"
                    + "'" + cmb_att_empid.getSelectedItem() + "','" + year + "','" + month + "','" + date + "',"
                    + "'" + txp_half_reson.getText() + "','" + dateFromSpinner(spn_half_datetime) + "')");

            String s = String.valueOf(tbl_att.getValueAt(0, 2));
            int i = Integer.parseInt(s) + 1;

            model.setValueAt(i, 0, 2);
            clsHalf();
            halfEnabled(false);
            chk_att_halfDay.setSelected(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void clsHalf() {
        txp_half_reson.setText(null);
    }

    int maxOT() {
        int ot = 0;

        try {
            ResultSet r = new JDBC().getData("SELECT max_ot FROM maxot WHERE empid='" + cmb_att_empid.getSelectedItem() + "' ");
            ResultSet r1 = new JDBC().getData("SELECT SUM(hour) AS oth FROM ot WHERE empid='" + cmb_att_empid.getSelectedItem() + "' AND year='" + year + "'"
                    + "AND month='" + month + "' ");
            if (r.next()) {
                if (r1.next()) {
                    ot = (int) (r.getDouble("max_ot") - Double.parseDouble(hour(r1.getInt("oth"))));
                } else {
                    JOptionPane.showMessageDialog(this, "No O/T Available For This Month", "O/T", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Add Monthly O/T Hour Count", "O/T", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ot;
    }

    int maxShort() {
        int days = 0;

        try {
            ResultSet r = new JDBC().getData("SELECT max_shrt FROM maxShort WHERE empid='" + cmb_att_empid.getSelectedItem() + "' ");
            ResultSet r1 = new JDBC().getData("SELECT COUNT(date) AS shrt FROM half WHERE empid='" + cmb_att_empid.getSelectedItem() + "' AND year='" + year + "'"
                    + "AND month='" + month + "' ");
            if (r.next()) {
                if (r1.next()) {
                    days = r.getInt("max_shrt") - r1.getInt("shrt");
                } else {
                    JOptionPane.showMessageDialog(this, "No Short Leaves Available For This Month", "Short Leaves", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Add Monthly Short Leaves Amount", "Short Leaves", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return days;
    }
    int availableShort(){
        int days = 0;
        
        try {
            ResultSet r1 = new JDBC().getData("SELECT COUNT(date) AS shrt FROM half WHERE empid='" + cmb_att_empid.getSelectedItem() + "' AND year='" + year + "'"
                    + "AND month='" + month + "' ");
            if (r1.next()) {
                days = r1.getInt("shrt");
            }
        } catch (Exception e) {
        }
        
        return days;
    }
    void markAtt(){
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM attendance WHERE empid='"+cmb_att_empid.getSelectedItem()+"' AND year='"+year+"' AND "
                    + "month='"+month+"' AND date='"+date+"' ");
            if (r.next()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Attendance Alredy Marked", title, JOptionPane.WARNING_MESSAGE);
            } else {
                new JDBC().putData("INSERT INTO attendance VALUES('"+nextID("SELECT COUNT(id)+1 AS newid FROM attendance")+"',"
                        + "'"+cmb_att_empid.getSelectedItem()+"','"+year+"','"+month+"','"+date+"')");
                JOptionPane.showMessageDialog(this, "Attendance Marked !", title, JOptionPane.INFORMATION_MESSAGE);
                String s = String.valueOf(tbl_att.getValueAt(0, 1));
                int i = Integer.parseInt(s)+1;
                tbl_att.setValueAt(i, 0, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

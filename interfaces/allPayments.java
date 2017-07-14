 package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hashith
 */
public class allPayments extends javax.swing.JFrame {

    Vector<String> v = new Stack<String>();
    JTextField tx;
    private boolean hide_flag = false;

    public allPayments() {
        initComponents();
//        new pay_loan().setToCombo(cmb_empid, "SELECT empid FROM rate");
        monthColor(true, 100);
        autoSuggest();
    }

    public void autoSuggest() {
        try {
            Class.forName("com.mysql.jdbc.Connection");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/build_pc_final", "root", "1234");
            ResultSet r = con.createStatement().executeQuery("SELECT empid FROM rate");

            cmb_empid.removeAllItems();
            r.first();
            if (cmb_empid.getItemCount() == 0) {
                do {
                    cmb_empid.addItem(r.getString("empid"));
                    v.addElement(r.getString("empid"));
                    cmb_empid.addItemListener(new ItemListener() {

                        @Override
                        public void itemStateChanged(ItemEvent ie) {
                            if (ie.getStateChange() == ItemEvent.SELECTED) {
                                cmb_empid.getSelectedIndex();
                            }
                        }
                    });

                } while (r.next());
            } else {
                cmb_empid.addItem("No Match Found");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        cmb_empid.setEditable(true);
        tx = (JTextField) cmb_empid.getEditor().getEditorComponent();
        tx.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String text = tx.getText().toUpperCase();
                        if (text.length() == 0) {
                            cmb_empid.hidePopup();
                            setModel(new DefaultComboBoxModel(v), "");
                        } else {
                            DefaultComboBoxModel m = getSuggest(v, text);
                            if (m.getSize() == 0) {
                                cmb_empid.hidePopup();
                            } else {
                                setModel(m, text);
                                cmb_empid.showPopup();
                            }
                        }
                    }
                });

            }

            @Override
            public void keyPressed(KeyEvent e) {
                String text = tx.getText();
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_ENTER) {
                    if (v.contains(text)) {
                        // v.addElement(text);
                        cmb_empid.setSelectedItem(text);
                        cmb_empid.hidePopup();
                    }
                    hide_flag = true;
                } else if (code == KeyEvent.VK_ESCAPE) {
                    hide_flag = true;
                } else if (code == KeyEvent.VK_RIGHT) {
                    for (int i = 0; i < v.size(); i++) {
                        String str = (String) v.elementAt(i);
                        if (str.startsWith(text)) {
                            tx.setText(str);
                        }
                    }
                }
            }
        });
    }

    private void setModel(DefaultComboBoxModel mdl, String str) {
        cmb_empid.setModel(mdl);
        tx.setText(str);
    }

    private DefaultComboBoxModel getSuggest(List<String> list, String text) {
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        for (String s : list) {
            if (s.startsWith(text)) {
                m.addElement(s);
            }
        }
        return m;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmb_empid = new javax.swing.JComboBox();
        mnc_month = new com.toedter.calendar.JMonthChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pay = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer r,int rw,int col){
                Component c = super.prepareRenderer(r, rw, col);
                //        c.setBackground(Color.WHITE);

                if (!isRowSelected(rw)){
                    c.setBackground(getBackground());
                    int modelRow = convertRowIndexToModel(rw);
                    String row = (String)tbl_pay.getValueAt(modelRow, 9);
                    //int rows = Integer.parseInt(row);
                    if(row.equals("January")){
                        c.setBackground(new java.awt.Color(243, 160, 61));
                    }else if(row.equals("February")){
                        c.setBackground(new java.awt.Color(255, 255, 0));
                    }else if(row.equals("March")){
                        c.setBackground(new java.awt.Color(0, 204, 51));
                    }else if(row.equals("April")){
                        c.setBackground(new java.awt.Color(0, 153, 204));
                    }else if(row.equals("May")){
                        c.setBackground((new java.awt.Color(0, 51, 255)));
                    }else if(row.equals("June")){
                        c.setBackground(new java.awt.Color(204, 0, 204));
                    }else if(row.equals("July")){
                        c.setBackground(new java.awt.Color(204, 204, 204));
                    }else if(row.equals("August")){
                        c.setBackground(new java.awt.Color(199, 155, 101));
                    }else if(row.equals("September")){
                        c.setBackground(new java.awt.Color(255, 153, 204));
                    }else if(row.equals("Octomber")){
                        c.setBackground(new java.awt.Color(187, 255, 84));
                    }else if(row.equals("November")){
                        c.setBackground(new java.awt.Color(231, 33, 132));
                    }else{
                        c.setBackground(Color.WHITE);
                    }
                }
                return c;
            }
        };
        ych_year = new com.toedter.calendar.JYearChooser();
        lbl_close = new javax.swing.JLabel();
        btn_all = new javax.swing.JButton();
        pnl_color = new javax.swing.JPanel();
        lbl_jan = new javax.swing.JLabel();
        lbl_feb = new javax.swing.JLabel();
        lbl_apr = new javax.swing.JLabel();
        lbl_may = new javax.swing.JLabel();
        lbl_jun = new javax.swing.JLabel();
        lbl_jul = new javax.swing.JLabel();
        lbl_aug = new javax.swing.JLabel();
        lbl_sep = new javax.swing.JLabel();
        lbl_oct = new javax.swing.JLabel();
        lbl_nov = new javax.swing.JLabel();
        lbl_dec = new javax.swing.JLabel();
        lbl_may1 = new javax.swing.JLabel();
        chk_year = new javax.swing.JCheckBox();
        chk_month = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        btn_pay_vwpaysht = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1311, 690));

        cmb_empid.setEditable(true);
        cmb_empid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_empid.setOpaque(false);
        cmb_empid.setPreferredSize(new java.awt.Dimension(32, 28));
        cmb_empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_empidActionPerformed(evt);
            }
        });

        mnc_month.setEnabled(false);
        mnc_month.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnc_month.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnc_monthMouseClicked(evt);
            }
        });
        mnc_month.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                mnc_monthAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Emp ID");
        jLabel1.setPreferredSize(new java.awt.Dimension(54, 28));

        tbl_pay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        tbl_pay.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tbl_pay.getTableHeader().setResizingAllowed(false);
        tbl_pay.getTableHeader().setReorderingAllowed(false);
        tbl_pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_payMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_pay);
        if (tbl_pay.getColumnModel().getColumnCount() > 0) {
            tbl_pay.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbl_pay.getColumnModel().getColumn(2).setPreferredWidth(120);
            tbl_pay.getColumnModel().getColumn(10).setPreferredWidth(25);
        }

        ych_year.setEnabled(false);
        ych_year.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ych_yearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ych_yearMouseEntered(evt);
            }
        });

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/close_window-26.png"))); // NOI18N
        lbl_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_closeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_closeMouseReleased(evt);
            }
        });

        btn_all.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btn_all.setText("View All Records");
        btn_all.setPreferredSize(new java.awt.Dimension(137, 28));
        btn_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_allActionPerformed(evt);
            }
        });

        pnl_color.setVisible(false);
        pnl_color.setToolTipText("<html><p><b>Search By</b><br>Color</p></html>");
        pnl_color.setOpaque(false);

        lbl_jan.setVisible(false);
        lbl_jan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/january.png"))); // NOI18N
        lbl_jan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_jan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_janMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_janMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_janMouseExited(evt);
            }
        });

        lbl_feb.setVisible(false);
        lbl_feb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/february.png"))); // NOI18N
        lbl_feb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_feb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_febMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_febMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_febMouseExited(evt);
            }
        });

        lbl_apr.setVisible(false);
        lbl_apr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/april.png"))); // NOI18N
        lbl_apr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_apr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_aprMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_aprMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_aprMouseExited(evt);
            }
        });

        lbl_may.setVisible(false);
        lbl_may.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/may.png"))); // NOI18N
        lbl_may.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_may.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_mayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_mayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_mayMouseExited(evt);
            }
        });

        lbl_jun.setVisible(false);
        lbl_jun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/june.png"))); // NOI18N
        lbl_jun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_jun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_junMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_junMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_junMouseExited(evt);
            }
        });

        lbl_jul.setVisible(false);
        lbl_jul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/july.png"))); // NOI18N
        lbl_jul.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_jul.setOpaque(true);
        lbl_jul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_julMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_julMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_julMouseExited(evt);
            }
        });

        lbl_aug.setVisible(false);
        lbl_aug.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/august.png"))); // NOI18N
        lbl_aug.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_aug.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_augMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_augMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_augMouseExited(evt);
            }
        });

        lbl_sep.setVisible(false);
        lbl_sep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/september.png"))); // NOI18N
        lbl_sep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_sep.setOpaque(true);
        lbl_sep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_sepMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_sepMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_sepMouseExited(evt);
            }
        });

        lbl_oct.setVisible(false);
        lbl_oct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/octomber.png"))); // NOI18N
        lbl_oct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_oct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_octMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_octMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_octMouseExited(evt);
            }
        });

        lbl_nov.setVisible(false);
        lbl_nov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/november.png"))); // NOI18N
        lbl_nov.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_nov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_novMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_novMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_novMouseExited(evt);
            }
        });

        lbl_dec.setVisible(false);
        lbl_dec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/december.png"))); // NOI18N
        lbl_dec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_dec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_decMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_decMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_decMouseExited(evt);
            }
        });

        lbl_may.setVisible(false);
        lbl_may1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/payimage/Month/march.png"))); // NOI18N
        lbl_may1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_may1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_may1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_may1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_may1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_colorLayout = new javax.swing.GroupLayout(pnl_color);
        pnl_color.setLayout(pnl_colorLayout);
        pnl_colorLayout.setHorizontalGroup(
            pnl_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_colorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_jan)
                    .addComponent(lbl_feb))
                .addGap(18, 18, 18)
                .addGroup(pnl_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_apr)
                    .addComponent(lbl_may1))
                .addGap(18, 18, 18)
                .addGroup(pnl_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_may)
                    .addComponent(lbl_jun))
                .addGap(18, 18, 18)
                .addGroup(pnl_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_jul)
                    .addComponent(lbl_aug))
                .addGap(18, 18, 18)
                .addGroup(pnl_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_sep)
                    .addComponent(lbl_oct))
                .addGap(18, 18, 18)
                .addGroup(pnl_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_nov, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_dec, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pnl_colorLayout.setVerticalGroup(
            pnl_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_colorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_jan)
                        .addComponent(lbl_may)
                        .addComponent(lbl_jul)
                        .addComponent(lbl_sep)
                        .addComponent(lbl_nov))
                    .addComponent(lbl_may1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_colorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_feb)
                    .addComponent(lbl_apr)
                    .addComponent(lbl_jun)
                    .addComponent(lbl_aug)
                    .addComponent(lbl_oct)
                    .addComponent(lbl_dec))
                .addContainerGap())
        );

        chk_year.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chk_year.setText("Year");
        chk_year.setPreferredSize(new java.awt.Dimension(57, 28));
        chk_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_yearActionPerformed(evt);
            }
        });

        chk_month.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chk_month.setText("Month");
        chk_month.setPreferredSize(new java.awt.Dimension(69, 28));
        chk_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_monthActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        jLabel2.setText("View Payment Details");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_all, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chk_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(ych_year, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(chk_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mnc_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmb_empid, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(447, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(lbl_close))
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_pay_vwpaysht, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_close)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mnc_month, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_month, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(ych_year, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_all, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btn_pay_vwpaysht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1311, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked

        monthColor(false, 100);
        dispose();
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void lbl_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseEntered

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/close_window-32.png")));
    }//GEN-LAST:event_lbl_closeMouseEntered

    private void lbl_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseExited

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildpc/image/close_window-26.png")));
    }//GEN-LAST:event_lbl_closeMouseExited

    private void mnc_monthAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_mnc_monthAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_mnc_monthAncestorAdded

    private void cmb_empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_empidActionPerformed

        if (!cmb_empid.getSelectedItem().equals("Select")) {
            if (chk_year.isSelected() && chk_month.isSelected()) {
                if (cmb_empid.getSelectedItem().equals("All")) {
                    new pay_pay().searchRecord("SELECT * FROM pay WHERE month='" + new pay_pay().mchMonth(mnc_month) + "' AND year='" + ych_year.getYear() + "' "
                            + " ", tbl_pay);
                    searchResult();
                } else {
                    new pay_pay().searchRecord("SELECT * FROM pay WHERE empid='" + cmb_empid.getSelectedItem() + "' AND month='" + new pay_pay().mchMonth(mnc_month) + "' AND "
                            + "year='" + ych_year.getYear() + "'  ", tbl_pay);
                    searchResult();
                }
            } else if (chk_year.isSelected()) {
                if (cmb_empid.getSelectedItem().equals("All")) {
                    new pay_pay().searchRecord("SELECT * FROM pay WHERE year='" + ych_year.getYear() + "'  ", tbl_pay);
                    searchResult();
                } else {
                    new pay_pay().searchRecord("SELECT * FROM pay WHERE empid='" + cmb_empid.getSelectedItem() + "' AND year='" + ych_year.getYear() + "'  ", tbl_pay);
                    searchResult();
                }
            } else if (chk_month.isSelected()) {
                if (cmb_empid.getSelectedItem().equals("All")) {
                    new pay_pay().searchRecord("SELECT * FROM pay WHERE month='" + new pay_pay().mchMonth(mnc_month) + "'   ", tbl_pay);
                    searchResult();
                } else {
                    new pay_pay().searchRecord("SELECT * FROM pay WHERE empid='" + cmb_empid.getSelectedItem() + "' AND month='" + new pay_pay().mchMonth(mnc_month) + "'   ", tbl_pay);
                    searchResult();
                }
            } else {
                new pay_pay().searchRecord("SELECT * FROM pay WHERE empid='" + cmb_empid.getSelectedItem() + "'   ", tbl_pay);
                searchResult();
            }
        } else {
            new Add_customer().removeAllRow(tbl_pay);
        }

    }//GEN-LAST:event_cmb_empidActionPerformed

    private void btn_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_allActionPerformed

        new pay_pay().searchRecord("SELECT * FROM pay ", tbl_pay);
        chk_month.setSelected(false);
        mnc_month.setEnabled(false);
        chk_year.setSelected(false);
        ych_year.setEnabled(false);
        cmb_empid.removeItem("All");
    }//GEN-LAST:event_btn_allActionPerformed

    private void chk_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_yearActionPerformed

        cmb_empid.setSelectedItem("Select");
        if (chk_year.isSelected()) {
            if (!chk_month.isSelected()) {
                cmb_empid.addItem("All");
            }
            ych_year.setEnabled(true);
        } else {
            if (!chk_month.isSelected()) {
                cmb_empid.removeItem("All");
            }
            ych_year.setEnabled(false);
        }
    }//GEN-LAST:event_chk_yearActionPerformed

    private void chk_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_monthActionPerformed

        cmb_empid.setSelectedItem("Select");
        if (chk_month.isSelected()) {
            if (!chk_year.isSelected()) {
                cmb_empid.addItem("All");
            }
            mnc_month.setEnabled(true);
        } else {
            if (!chk_year.isSelected()) {
                cmb_empid.removeItem("All");
            }
            mnc_month.setEnabled(false);
        }
    }//GEN-LAST:event_chk_monthActionPerformed

    private void ych_yearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ych_yearMouseClicked

        cmb_empid.setSelectedItem("Select");
    }//GEN-LAST:event_ych_yearMouseClicked

    private void mnc_monthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnc_monthMouseClicked

        cmb_empid.setSelectedItem("Select");
    }//GEN-LAST:event_mnc_monthMouseClicked

    private void ych_yearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ych_yearMouseEntered

    }//GEN-LAST:event_ych_yearMouseEntered

    private void lbl_janMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_janMouseClicked

        searchByColor(1);
    }//GEN-LAST:event_lbl_janMouseClicked

    private void lbl_febMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_febMouseClicked

        searchByColor(2);
    }//GEN-LAST:event_lbl_febMouseClicked

    private void lbl_janMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_janMouseEntered

        lbl_jan.setLocation(10, 8);
    }//GEN-LAST:event_lbl_janMouseEntered

    private void lbl_janMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_janMouseExited

        lbl_jan.setLocation(12, 12);
    }//GEN-LAST:event_lbl_janMouseExited

    private void lbl_febMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_febMouseEntered

        lbl_feb.setLocation(10, 46);
    }//GEN-LAST:event_lbl_febMouseEntered

    private void lbl_febMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_febMouseExited

        lbl_feb.setLocation(12, 50);
    }//GEN-LAST:event_lbl_febMouseExited

    private void lbl_julMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_julMouseClicked

        searchByColor(7);
    }//GEN-LAST:event_lbl_julMouseClicked

    private void lbl_aprMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_aprMouseEntered

        lbl_apr.setLocation(128, 46);
    }//GEN-LAST:event_lbl_aprMouseEntered

    private void lbl_aprMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_aprMouseExited

        lbl_apr.setLocation(130, 50);
    }//GEN-LAST:event_lbl_aprMouseExited

    private void lbl_may1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_may1MouseEntered

        lbl_may1.setLocation(128, 8);
    }//GEN-LAST:event_lbl_may1MouseEntered

    private void lbl_may1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_may1MouseExited

        lbl_may1.setLocation(130, 12);
    }//GEN-LAST:event_lbl_may1MouseExited

    private void lbl_mayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mayMouseClicked

        searchByColor(5);
    }//GEN-LAST:event_lbl_mayMouseClicked

    private void lbl_mayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mayMouseEntered

        lbl_may.setLocation(246, 8);
    }//GEN-LAST:event_lbl_mayMouseEntered

    private void lbl_mayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mayMouseExited

        lbl_may.setLocation(248, 12);
    }//GEN-LAST:event_lbl_mayMouseExited

    private void lbl_junMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_junMouseEntered

        lbl_jun.setLocation(246, 46);
    }//GEN-LAST:event_lbl_junMouseEntered

    private void lbl_junMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_junMouseExited

        lbl_jun.setLocation(248, 50);
    }//GEN-LAST:event_lbl_junMouseExited

    private void lbl_julMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_julMouseEntered

        lbl_jul.setLocation(364, 8);
    }//GEN-LAST:event_lbl_julMouseEntered

    private void lbl_julMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_julMouseExited

        lbl_jul.setLocation(366, 12);
    }//GEN-LAST:event_lbl_julMouseExited

    private void lbl_sepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_sepMouseClicked

        searchByColor(10);
    }//GEN-LAST:event_lbl_sepMouseClicked

    private void lbl_augMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_augMouseEntered

        lbl_aug.setLocation(364, 46);
    }//GEN-LAST:event_lbl_augMouseEntered

    private void lbl_augMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_augMouseExited

        lbl_aug.setLocation(366, 50);
    }//GEN-LAST:event_lbl_augMouseExited

    private void lbl_sepMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_sepMouseEntered

        lbl_sep.setLocation(482, 8);
    }//GEN-LAST:event_lbl_sepMouseEntered

    private void lbl_sepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_sepMouseExited

        lbl_sep.setLocation(484, 12);
    }//GEN-LAST:event_lbl_sepMouseExited

    private void lbl_octMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_octMouseEntered

        lbl_oct.setLocation(482, 46);
    }//GEN-LAST:event_lbl_octMouseEntered

    private void lbl_octMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_octMouseExited

        lbl_oct.setLocation(484, 50);
    }//GEN-LAST:event_lbl_octMouseExited

    private void lbl_novMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_novMouseClicked

        searchByColor(11);
    }//GEN-LAST:event_lbl_novMouseClicked

    private void lbl_novMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_novMouseEntered

        lbl_nov.setLocation(600, 8);
    }//GEN-LAST:event_lbl_novMouseEntered

    private void lbl_novMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_novMouseExited

        lbl_nov.setLocation(602, 12);
    }//GEN-LAST:event_lbl_novMouseExited

    private void lbl_decMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_decMouseEntered

        lbl_dec.setLocation(600, 46);
    }//GEN-LAST:event_lbl_decMouseEntered

    private void lbl_decMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_decMouseExited

        lbl_dec.setLocation(602, 50);
    }//GEN-LAST:event_lbl_decMouseExited

    private void lbl_may1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_may1MouseClicked

        searchByColor(3);
    }//GEN-LAST:event_lbl_may1MouseClicked

    private void lbl_aprMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_aprMouseClicked

        searchByColor(4);
    }//GEN-LAST:event_lbl_aprMouseClicked

    private void lbl_junMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_junMouseClicked

        searchByColor(6);
    }//GEN-LAST:event_lbl_junMouseClicked

    private void lbl_augMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_augMouseClicked

        searchByColor(8);
    }//GEN-LAST:event_lbl_augMouseClicked

    private void lbl_octMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_octMouseClicked

        searchByColor(10);
    }//GEN-LAST:event_lbl_octMouseClicked

    private void lbl_decMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_decMouseClicked

        searchByColor(12);
    }//GEN-LAST:event_lbl_decMouseClicked

    private void lbl_closeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseReleased


    }//GEN-LAST:event_lbl_closeMouseReleased

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(allPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(allPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(allPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(allPayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new allPayments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_all;
    private javax.swing.JButton btn_pay_vwpaysht;
    private javax.swing.JCheckBox chk_month;
    private javax.swing.JCheckBox chk_year;
    private javax.swing.JComboBox cmb_empid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_apr;
    private javax.swing.JLabel lbl_aug;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_dec;
    private javax.swing.JLabel lbl_feb;
    private javax.swing.JLabel lbl_jan;
    private javax.swing.JLabel lbl_jul;
    private javax.swing.JLabel lbl_jun;
    private javax.swing.JLabel lbl_may;
    private javax.swing.JLabel lbl_may1;
    private javax.swing.JLabel lbl_nov;
    private javax.swing.JLabel lbl_oct;
    private javax.swing.JLabel lbl_sep;
    private com.toedter.calendar.JMonthChooser mnc_month;
    private javax.swing.JPanel pnl_color;
    private javax.swing.JTable tbl_pay;
    private com.toedter.calendar.JYearChooser ych_year;
    // End of variables declaration//GEN-END:variables
void monthColor(final boolean b, final long l) {
        pnl_color.setVisible(true);
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 12; i++) {
                    if (i == 10) {
                        lbl_jan.setVisible(b);
                    }
                    if (i == 3) {
                        lbl_feb.setVisible(b);
                    }
                    if (i == 5) {
                        lbl_may1.setVisible(b);
                    }
                    if (i == 7) {
                        lbl_apr.setVisible(b);
                    }
                    if (i == 9) {
                        lbl_may.setVisible(b);
                    }
                    if (i == 11) {
                        lbl_jun.setVisible(b);
                    }
                    if (i == 2) {
                        lbl_jul.setVisible(b);
                    }
                    if (i == 4) {
                        lbl_aug.setVisible(b);
                    }
                    if (i == 6) {
                        lbl_sep.setVisible(b);
                    }
                    if (i == 8) {
                        lbl_oct.setVisible(b);
                    }
                    if (i == 0) {
                        lbl_nov.setVisible(b);
                    }
                    if (i == 1) {
                        lbl_dec.setVisible(b);
                    }
                    try {
                        Thread.sleep(l);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Thread.currentThread().stop();
            }
        }).start();
    }

    void searchResult() {
        if (tbl_pay.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No Record Found");
            cmb_empid.setSelectedItem("Select");
        }
    }

    void searchByColor(int month) {
        chk_month.setSelected(false);
        cmb_empid.removeItem("All");
        mnc_month.setEnabled(false);
        if (chk_year.isSelected()) {
            new pay_pay().searchRecord("SELECT * FROM pay WHERE month='" + month + "' AND year='" + ych_year.getYear() + "' ", tbl_pay);
        } else {
            new pay_pay().searchRecord("SELECT * FROM pay WHERE month='" + month + "' ", tbl_pay);
        }
        if (tbl_pay.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No Record Available");
            btn_pay_vwpaysht.setEnabled(false);
        }
    }

}

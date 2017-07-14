/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.utils.TimingUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Deeptha Senanayake
 */
public class ViewGRN extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewGRN
     */
    public ViewGRN() {
        super("View Good Received Notes", true, true, true, true);
        initComponents();
        getGRNReports();
        combo_viewByActionPerformed(null);
        getEvent();
    }
    
    
    public void viewByGRN(String grn_no){
        combo_viewBy.setSelectedIndex(2);
        combo_viewByActionPerformed(null);
        combo_grnNo.setSelectedItem(grn_no);
        combo_grnNoActionPerformed(null);
        try {
            table_grninfo.setRowSelectionInterval(0, 0);
        } catch (Exception e) {}
        table_grninfoMouseReleased(null);
    }
    
    void setGRNView(String id){
        combo_viewBy.setSelectedIndex(3);
        combo_viewByActionPerformed(null);
        combo_supID.setSelectedItem(id);
        combo_supIDActionPerformed(null);
    }

    void getSupIDs() {
        try {
            ResultSet r = new JDBC().getData("SELECT sup_id FROM suppliers");
            Vector v = new Vector();
            while (r.next()) {
                v.add(r.getString("sup_id"));
            }
            combo_supID.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
        }
    }

    void getGRNNos() {
        try {
            ResultSet r = new JDBC().getData("SELECT grn_no FROM grn ");
            Vector v = new Vector();
            while (r.next()) {
                v.add(r.getString("grn_no"));
            }
            combo_grnNo.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
        }
    }

    private void getGRNReports() {
        DefaultTableModel model1 = (DefaultTableModel) table_grninfo.getModel();
        int rowC = table_grninfo.getRowCount();
        int view = combo_viewBy.getSelectedIndex();
        for (int i = 0; i < rowC; i++) {
            model1.removeRow(0);
        }
        String sql = "";
        if (view == 1) {
            String date = new SimpleDateFormat("yyyy-MM-dd").format(date_chooser.getDate());
            sql = " WHERE date='" + date + "' ";
        } else if (view == 2) {
            sql = " WHERE grn_no='" + combo_grnNo.getEditor().getItem() + "'";
        } else if (view == 3) {
            sql = " WHERE sup_id='" + combo_supID.getEditor().getItem() + "'";
        }
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM grn_info " + sql);
            while (r.next()) {
                Vector v = new Vector();
                v.add(r.getDate("date"));
                v.add(r.getString("grn_no"));
                v.add(r.getString("sup_id"));
                v.add(r.getString("employee_id"));

                model1.addRow(v);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error while Loading GRN Reports.", "View GRNs", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    void viewGRN() {

        DefaultTableModel model1 = (DefaultTableModel) table_grnReport.getModel();
        int selRow = table_grninfo.getSelectedRow();
        int rowC = table_grnReport.getRowCount();
        for (int i = 0; i < rowC; i++) {
            model1.removeRow(0);
        }
        try {
            ResultSet r = new JDBC().getData("SELECT *,COUNT(serial) as Total FROM grn WHERE grn_no='" + table_grninfo.getValueAt(selRow, 1) + "' GROUP BY(serial) ");
            int totalItems = 0, totalQty = 0;
            double totalCost = 0;
            while (r.next()) {
                String[] id = r.getString("serial").split("-");
                ResultSet r2 = new JDBC().getData("SELECT item_des FROM items WHERE item_id='" + id[0] + "' ");
                Vector v = new Vector();
                if (r2.next()) {
                    v.add(r2.getString("item_des"));
                } else {
                    v.add("cannot find !");
                }
                v.add(r.getInt("qty"));
                v.add(r.getDouble("cost"));
                v.add(r.getDouble("cost") * r.getInt("qty"));

                model1.addRow(v);
                totalItems++;
                totalQty += r.getInt("qty");
                totalCost += r.getDouble("cost") * r.getInt("qty");

            }
            total_items1.setText(String.valueOf(totalItems));
            total_cost.setText(String.valueOf(totalCost));
            total_qty.setText(String.valueOf(totalQty));
            
            ResultSet sup = new JDBC().getData("SELECT sup_id,sup_company,sup_tel,sup_web from suppliers where sup_id=(select sup_id from grn_info where grn_no='"+table_grninfo.getValueAt(selRow, 1)+"'  )");
            if (sup.next()) {
                sup_id.setText(sup.getString("sup_id"));
                sup_com.setText(sup.getString("sup_company"));
                sup_tel.setText(sup.getString("sup_tel"));
                sup_web.setText(sup.getString("sup_web"));
            }else{
                sup_id.setText("Not Available !");
                sup_com.setText("Not Available !");
                sup_tel.setText("Not Available !");
                sup_web.setText("Not Available !");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error");
        }

    }

    /**
     * This method is called from within the constructor to initialize
 the form. WARNING: Do NOT modify this code. The content of this
 method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_grninfo = new javax.swing.JTable();
        combo_viewBy = new javax.swing.JComboBox();
        btn_refresh_grn = new javax.swing.JButton();
        total_cost4 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        date_chooser = new com.toedter.calendar.JDateChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        loading = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_grnReport = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        total_items = new javax.swing.JLabel();
        total_cost = new javax.swing.JLabel();
        total_cost1 = new javax.swing.JLabel();
        total_items1 = new javax.swing.JLabel();
        total_qtyy = new javax.swing.JLabel();
        total_qty = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        total_items2 = new javax.swing.JLabel();
        sup_id = new javax.swing.JLabel();
        total_cost3 = new javax.swing.JLabel();
        sup_com = new javax.swing.JLabel();
        total_qtyy1 = new javax.swing.JLabel();
        sup_tel = new javax.swing.JLabel();
        total_qtyy2 = new javax.swing.JLabel();
        sup_web = new javax.swing.JLabel();
        lbl_grnNo = new javax.swing.JLabel();
        combo_grnNo = new javax.swing.JComboBox();
        lbl_supID = new javax.swing.JLabel();
        combo_supID = new javax.swing.JComboBox();
        btn_refresh_grn1 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document-32.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1366, 731));
        setMinimumSize(new java.awt.Dimension(1366, 731));
        setPreferredSize(new java.awt.Dimension(1366, 731));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);

        jLabel38.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document-64.png"))); // NOI18N
        jLabel38.setText(" View Good Received Notes");
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });

        table_grninfo.setAutoCreateRowSorter(true);
        table_grninfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "GRN No", "Supplier ID", "Employee ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_grninfo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_grninfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_grninfoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_grninfoMouseReleased(evt);
            }
        });
        table_grninfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_grninfoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table_grninfoKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(table_grninfo);

        combo_viewBy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_viewBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Date", "GRN No", "Supplier ID" }));
        combo_viewBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_viewByActionPerformed(evt);
            }
        });

        btn_refresh_grn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_refresh_grn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sinchronize-32.png"))); // NOI18N
        btn_refresh_grn.setText("Refresh");
        btn_refresh_grn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refresh_grnActionPerformed(evt);
            }
        });

        total_cost4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_cost4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_cost4.setText("View :");

        lbl_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_date.setText("Date :");

        date_chooser.setDateFormatString("yyyy-MM-dd");
        date_chooser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_chooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_chooserPropertyChange(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        loading.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loading.setText("Click On the Report to View");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(loading)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(loading)
                .addGap(240, 240, 240))
        );

        jTabbedPane1.addTab("Report ", jPanel5);

        table_grnReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Description", "Qty", "Cost per Unit", "Total Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(table_grnReport);
        if (table_grnReport.getColumnModel().getColumnCount() > 0) {
            table_grnReport.getColumnModel().getColumn(1).setMinWidth(50);
            table_grnReport.getColumnModel().getColumn(1).setPreferredWidth(50);
            table_grnReport.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "More Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        total_items.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_items.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_items.setText("Total Items :");

        total_cost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_cost.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total_cost.setText("----.--");

        total_cost1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_cost1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_cost1.setText("Total Cost :");

        total_items1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_items1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total_items1.setText("----.--");

        total_qtyy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_qtyy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_qtyy.setText("Total Quantity :");

        total_qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_qty.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total_qty.setText("----.--");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(total_items, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_cost1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_qtyy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(total_items1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_cost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_qty, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_cost1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_items)
                    .addComponent(total_items1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_qtyy)
                    .addComponent(total_qty))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Supplier Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        total_items2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_items2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_items2.setText("Company :");

        sup_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sup_id.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        total_cost3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_cost3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_cost3.setText("Supplier ID :");

        sup_com.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sup_com.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        total_qtyy1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_qtyy1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_qtyy1.setText("Tel :");

        sup_tel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sup_tel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        total_qtyy2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_qtyy2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_qtyy2.setText("Website :");

        sup_web.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sup_web.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(total_qtyy2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_items2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_cost3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_qtyy1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(sup_com, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sup_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sup_tel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sup_web, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sup_id, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_cost3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(total_items2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sup_com, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(total_qtyy1)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(sup_tel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_qtyy2)
                    .addComponent(sup_web, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Additional Information", jPanel1);

        lbl_grnNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_grnNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_grnNo.setText("GRN No :");

        combo_grnNo.setEditable(true);
        combo_grnNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_grnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_grnNoActionPerformed(evt);
            }
        });

        lbl_supID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_supID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_supID.setText("Supplier ID :");

        combo_supID.setEditable(true);
        combo_supID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_supID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_supIDActionPerformed(evt);
            }
        });

        btn_refresh_grn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_refresh_grn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coins-32.png"))); // NOI18N
        btn_refresh_grn1.setText("View Financial Details");
        btn_refresh_grn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refresh_grn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(total_cost4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_viewBy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_date)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_grnNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_grnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_supID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_supID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1)
                        .addGap(43, 43, 43))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel38))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_refresh_grn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refresh_grn1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total_cost4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(date_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(combo_viewBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(combo_grnNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combo_supID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_supID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_grnNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_refresh_grn)
                    .addComponent(btn_refresh_grn1))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 701));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        background.setMaximumSize(new java.awt.Dimension(1366, 731));
        background.setMinimumSize(new java.awt.Dimension(1366, 731));
        background.setPreferredSize(new java.awt.Dimension(1366, 731));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel38MouseClicked

    private void table_grninfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_grninfoMouseClicked


    }//GEN-LAST:event_table_grninfoMouseClicked

    private void table_grninfoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_grninfoKeyPressed


    }//GEN-LAST:event_table_grninfoKeyPressed

    private void btn_refresh_grnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refresh_grnActionPerformed


    }//GEN-LAST:event_btn_refresh_grnActionPerformed

    private void table_grninfoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_grninfoKeyReleased

        viewGRN();
        table_grninfoMouseReleased(null);
    }//GEN-LAST:event_table_grninfoKeyReleased

    private void table_grninfoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_grninfoMouseReleased

        viewGRN();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    loading.setIcon(new ImageIcon(getClass().getResource("/images/ajax-loader (9).gif")));
                    loading.setText("Please wait..");
                    String path = "src/reports/GRN.jrxml";
                    Map<String, Object> param = new HashMap<>();
                    param.put("no", table_grninfo.getValueAt(table_grninfo.getSelectedRow(), 1));
                    JasperReport jasperReport = JasperCompileManager.compileReport(path);
                    loading.setText("Please wait....");
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JDBC().con());
                    loading.setText("Please wait......");
                    JRViewer j = new JRViewer(jasperPrint);
                    jTabbedPane1.setComponentAt(0, j);
                    j.setZoomRatio(0.75f);
                } catch (Exception e) {
                    e.printStackTrace();
                    jTabbedPane1.setComponentAt(0, loading);
                    loading.setText("Error while Loading Report !");
                    loading.setSize(loading.getHeight(), jTabbedPane1.getWidth());
                    loading.setIcon(null);
                    Thread.currentThread().stop();
                }
            }
        }).start();
    }//GEN-LAST:event_table_grninfoMouseReleased

    private void combo_viewByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_viewByActionPerformed

        int sel = combo_viewBy.getSelectedIndex();
        if (sel == 0) {
            lbl_date.setVisible(false);
            date_chooser.setVisible(false);
            lbl_grnNo.setVisible(false);
            combo_grnNo.setVisible(false);
            lbl_supID.setVisible(false);
            combo_supID.setVisible(false);
        } else if (sel == 1) {
            lbl_date.setVisible(true);
            date_chooser.setVisible(true);
            lbl_grnNo.setVisible(false);
            combo_grnNo.setVisible(false);
            lbl_supID.setVisible(false);
            combo_supID.setVisible(false);
            date_chooser.setDate(new Date());
        } else if (sel == 2) {
            lbl_date.setVisible(false);
            date_chooser.setVisible(false);
            lbl_grnNo.setVisible(true);
            combo_grnNo.setVisible(true);
            lbl_supID.setVisible(false);
            combo_supID.setVisible(false);
            getGRNNos();
        } else if (sel == 3) {
            lbl_date.setVisible(false);
            date_chooser.setVisible(false);
            lbl_grnNo.setVisible(false);
            combo_grnNo.setVisible(false);
            lbl_supID.setVisible(true);
            combo_supID.setVisible(true);
            getSupIDs();
        }
        getGRNReports();

    }//GEN-LAST:event_combo_viewByActionPerformed

    private void date_chooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_chooserPropertyChange

        getGRNReports();
    }//GEN-LAST:event_date_chooserPropertyChange

    private void combo_grnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_grnNoActionPerformed

        getGRNReports();

    }//GEN-LAST:event_combo_grnNoActionPerformed

    private void combo_supIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_supIDActionPerformed

        getGRNReports();
    }//GEN-LAST:event_combo_supIDActionPerformed

    private void btn_refresh_grn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refresh_grn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_refresh_grn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_refresh_grn;
    private javax.swing.JButton btn_refresh_grn1;
    public javax.swing.JComboBox combo_grnNo;
    private javax.swing.JComboBox combo_supID;
    private javax.swing.JComboBox combo_viewBy;
    private com.toedter.calendar.JDateChooser date_chooser;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_grnNo;
    private javax.swing.JLabel lbl_supID;
    private javax.swing.JLabel loading;
    private javax.swing.JLabel sup_com;
    private javax.swing.JLabel sup_id;
    private javax.swing.JLabel sup_tel;
    private javax.swing.JLabel sup_web;
    public javax.swing.JTable table_grnReport;
    private javax.swing.JTable table_grninfo;
    private javax.swing.JLabel total_cost;
    private javax.swing.JLabel total_cost1;
    private javax.swing.JLabel total_cost3;
    private javax.swing.JLabel total_cost4;
    private javax.swing.JLabel total_items;
    private javax.swing.JLabel total_items1;
    private javax.swing.JLabel total_items2;
    private javax.swing.JLabel total_qty;
    private javax.swing.JLabel total_qtyy;
    private javax.swing.JLabel total_qtyy1;
    private javax.swing.JLabel total_qtyy2;
    // End of variables declaration//GEN-END:variables

    private void getEvent() {
        combo_grnNo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                getGRNReports();
                if (table_grninfo.getRowCount() <= 0) {
                    BalloonTip tip = WarningBalloons.getTip(combo_grnNo, "No GRN Found !");
                    TimingUtils.showTimedBalloon(tip, 1000);
                }
            }
        });
        combo_supID.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {
                getGRNReports();
                if (table_grninfo.getRowCount() <= 0) {
                    BalloonTip tip = WarningBalloons.getTip(combo_supID, "No Supplier Found !");
                    TimingUtils.showTimedBalloon(tip, 1000);
                }
            }
        });
    }
}

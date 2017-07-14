/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
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
public class ViewReturnedItems extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewReturnedItems
     */
    public ViewReturnedItems() {
        super("View Returned Items", true, true, true, true);
        initComponents();
        getCategories();

        combo_viewByActionPerformed(null);
        setEvents();
    }

    boolean setRed(String serial, int qty) {
        boolean send = false;
        try{
        ResultSet r = new JDBC().getData("select qty from grn where serial ='" + serial + "' ");
        if (r.next()) {
            int all_qty = r.getInt("qty");
            send = (all_qty / 8) <= qty;
        }
        
        }catch(Exception e){
        }
        return send;
    }

    String getDetails() {
        int sel =table_returns.getSelectedRow();
        
        return table_returns.getValueAt(sel,3)+"-"+table_returns.getValueAt(sel, 2);
    }

    void getSupplierIDs() {
        try {
            ResultSet r = new JDBC().getData("SELECT DISTINCT(sup_id) FROM returns");
            Vector v = new Vector();
            v.add("Select");
            while (r.next() && !r.getString("sup_id").equalsIgnoreCase("Cannot find!")) {
                v.add(r.getString("sup_id"));
            }
            setNewComboData(combo_supplier, v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String getDescription(String id) throws Exception {

        ResultSet r2 = new JDBC().getData("SELECT item_des FROM items WHERE item_id='" + id + "' ");
        if (r2.next()) {
            return r2.getString("item_des");
        } else {
            return "Cannot find !";
        }
    }

    public void setNewComboData(JComboBox combo, Vector v) {
        combo.setModel(new DefaultComboBoxModel(v));
    }

    private void getCategories() {
        try {
            ResultSet r = new JDBC().getData("SELECT DISTINCT(item_cate) FROM items WHERE item_id IN(SELECT item_id FROM stock WHERE serial IN(SELECT serial FROM returns)) ");
            Vector v = new Vector();
            v.add("Select");
            while (r.next()) {
                v.add(r.getString("item_cate"));
            }
            setNewComboData(combo_cate, v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    DefaultTableModel getNewModel(JTable table) {
        return (DefaultTableModel) table.getModel();
    }

    void getReturnedItems(String date) {
        clearTable();
        try {
            String sql = "";
            if (date != null) {
                sql = "WHERE date LIKE'" + date + "%' ";
            }
            JDBC Data = new JDBC();
            ResultSet r = Data.getData("SELECT * FROM returns " + sql);
            String[] id;
            while (r.next()) {
                Vector v = new Vector();

                v.add(r.getInt("return_id"));
                v.add(r.getString("serial"));
                v.add(new SimpleDateFormat("yyyy-MM-dd").format(r.getDate("date")));
                id = r.getString("serial").split("-");
                v.add(getDescription(id[0]));
                if (r.getString("invoice_no").equalsIgnoreCase("FROM_STOCK")) {
                    v.add("Not Available !");
                } else {
                    v.add(r.getString("invoice_no"));
                }
                v.add(r.getInt("qty"));
                getNewModel(table_returns).addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.gc();
    }

    void clearTable() {
        int rowc = table_returns.getRowCount();
        for (int i = 0; i < rowc; i++) {
            getNewModel(table_returns).removeRow(0);
        }
        System.gc();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        combo_viewBy = new javax.swing.JComboBox();
        date_chooser = new com.toedter.calendar.JDateChooser();
        lbl_date = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_cate = new javax.swing.JLabel();
        combo_cate = new javax.swing.JComboBox();
        lbl_supp = new javax.swing.JLabel();
        combo_supplier = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_returns = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer r,int rw,int col){
                Component c = super.prepareRenderer(r, rw, col);
                //        c.setBackground(Color.WHITE);

                if (!isRowSelected(rw)){
                    c.setBackground(getBackground());
                    int modelRow = convertRowIndexToModel(rw);
                    int qty = Integer.parseInt(table_returns.getValueAt(modelRow, 5).toString());
                    String serial = table_returns.getValueAt(modelRow,1).toString();
                    if(setRed(serial, qty)){
                        c.setBackground(new Color(255, 51, 51));
                    }
                }
                return c;
            }
        };
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        background = new javax.swing.JLabel();

        setTitle("View Returned List");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return-32.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1366, 731));
        setMinimumSize(new java.awt.Dimension(1366, 731));
        setPreferredSize(new java.awt.Dimension(1366, 731));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setOpaque(false);

        combo_viewBy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_viewBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Date", "Item Category", "Supplier", "All" }));
        combo_viewBy.setSelectedIndex(3);
        combo_viewBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_viewByActionPerformed(evt);
            }
        });

        date_chooser.setToolTipText("Default : Today");
        date_chooser.setDateFormatString("yyyy-MM-dd");
        date_chooser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_chooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_chooserPropertyChange(evt);
            }
        });

        lbl_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_date.setText("Date :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("View By : ");

        lbl_cate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_cate.setText("Category :");

        combo_cate.setEditable(true);
        combo_cate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_cate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        combo_cate.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                combo_catePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        combo_cate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_cateActionPerformed(evt);
            }
        });
        combo_cate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_cateKeyReleased(evt);
            }
        });

        lbl_supp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_supp.setText("Supplier :");

        combo_supplier.setEditable(true);
        combo_supplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_supplier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        combo_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_supplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_viewBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_cate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_supp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(459, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_supp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_cate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(PanelLayout.createSequentialGroup()
                                    .addComponent(lbl_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(3, 3, 3))
                                .addComponent(combo_viewBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(combo_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combo_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1240, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return-64.png"))); // NOI18N
        jLabel16.setText("View Returned Items");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1275, -1));

        table_returns.setAutoCreateRowSorter(true);
        table_returns.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table_returns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Serial", "Date", "Item Description", "Invoice No", "Qty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_returns.setRowHeight(20);
        table_returns.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_returns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_returnsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table_returns);
        if (table_returns.getColumnModel().getColumnCount() > 0) {
            table_returns.getColumnModel().getColumn(0).setMinWidth(50);
            table_returns.getColumnModel().getColumn(0).setPreferredWidth(50);
            table_returns.getColumnModel().getColumn(0).setMaxWidth(70);
            table_returns.getColumnModel().getColumn(1).setMinWidth(40);
            table_returns.getColumnModel().getColumn(1).setPreferredWidth(70);
            table_returns.getColumnModel().getColumn(1).setMaxWidth(80);
            table_returns.getColumnModel().getColumn(2).setMinWidth(100);
            table_returns.getColumnModel().getColumn(2).setPreferredWidth(120);
            table_returns.getColumnModel().getColumn(2).setMaxWidth(130);
            table_returns.getColumnModel().getColumn(4).setMinWidth(100);
            table_returns.getColumnModel().getColumn(4).setPreferredWidth(100);
            table_returns.getColumnModel().getColumn(4).setMaxWidth(120);
            table_returns.getColumnModel().getColumn(5).setMinWidth(50);
            table_returns.getColumnModel().getColumn(5).setPreferredWidth(50);
            table_returns.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, 524, 540));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sinchronize-32.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 80, 51, -1));
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 127, 796, 540));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        getReturnedItems(null);
        combo_viewBy.setSelectedIndex(3);
        combo_viewByActionPerformed(null);
        jTabbedPane1.removeAll();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void date_chooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_chooserPropertyChange

        if (date_chooser.getDate() != null) {
            getReturnedItems(new SimpleDateFormat("yyyy-MM-dd").format(date_chooser.getDate()));
        }

    }//GEN-LAST:event_date_chooserPropertyChange

    private void combo_viewByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_viewByActionPerformed

        if (combo_viewBy.getSelectedIndex() == 0) {
            date_chooser.setDate(new Date());
            lbl_supp.setVisible(false);
            combo_supplier.setVisible(false);
            lbl_cate.setVisible(false);
            combo_cate.setVisible(false);

            date_chooser.setVisible(true);
            lbl_date.setVisible(true);

        } else if (combo_viewBy.getSelectedIndex() == 1) {
            combo_cateActionPerformed(null);
            date_chooser.setVisible(false);
            lbl_supp.setVisible(false);
            combo_supplier.setVisible(false);
            lbl_date.setVisible(false);

            lbl_cate.setVisible(true);
            combo_cate.setVisible(true);
        } else if (combo_viewBy.getSelectedIndex() == 2) {

            lbl_cate.setVisible(false);
            combo_cate.setVisible(false);
            date_chooser.setVisible(false);
            lbl_date.setVisible(false);

            lbl_supp.setVisible(true);
            combo_supplier.setVisible(true);
            getSupplierIDs();
            combo_supplierActionPerformed(null);
        } else {
            lbl_cate.setVisible(false);
            combo_cate.setVisible(false);
            date_chooser.setVisible(false);
            lbl_date.setVisible(false);
            lbl_supp.setVisible(false);
            combo_supplier.setVisible(false);

            getReturnedItems(null);
        }
    }//GEN-LAST:event_combo_viewByActionPerformed

    private void table_returnsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_returnsMouseReleased

        new Thread(new Runnable() {

            @Override
            public void run() {
                jTabbedPane1.add("Please wait..", null);
                try {
                    String path = "src/reports/Return_Statement.jrxml";
                    Map<String, Integer> para = new HashMap<String, Integer>();
                    int id = Integer.parseInt(table_returns.getValueAt(table_returns.getSelectedRow(), 0).toString());
                    para.put("id", id);
                    JasperReport jasperReport = JasperCompileManager.compileReport(path);
                    jTabbedPane1.setTitleAt(jTabbedPane1.getTabCount() - 1, "Please wait...");
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, para, new JDBC().con());
                    jTabbedPane1.setTitleAt(jTabbedPane1.getTabCount() - 1, "Please wait....");
                    JRViewer jView = new JRViewer(jasperPrint);
                    jTabbedPane1.setComponentAt(jTabbedPane1.getTabCount() - 1, jView);
                    jTabbedPane1.setTitleAt(jTabbedPane1.getTabCount() - 1, getDetails());
                    jTabbedPane1.setSelectedIndex(jTabbedPane1.getTabCount() - 1);
                    jView.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error While Loading Report !", "Return Statemet", JOptionPane.WARNING_MESSAGE);
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }//GEN-LAST:event_table_returnsMouseReleased

    private void combo_cateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_cateKeyReleased

    }//GEN-LAST:event_combo_cateKeyReleased

    private void combo_cateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_cateActionPerformed

        clearTable();
        try {
            JDBC Data = new JDBC();
            ResultSet r = Data.getData("SELECT * FROM returns WHERE serial IN(SELECT serial FROM stock WHERE item_id IN(SELECT item_id FROM items WHERE item_cate LIKE '" + combo_cate.getEditor().getItem() + "%'))");

            String[] id;
            while (r.next()) {
                Vector v = new Vector();

                v.add(r.getInt("return_id"));
                v.add(r.getString("serial"));
                v.add(new SimpleDateFormat("yyyy-MM-dd").format(r.getDate("date")));
                id = r.getString("serial").split("-");
                v.add(getDescription(id[0]));
                if (r.getString("invoice_no").equalsIgnoreCase("FROM_STOCK")) {
                    v.add("Not Available !");
                } else {
                    v.add(r.getString("invoice_no"));
                }
                v.add(r.getInt("qty"));
                getNewModel(table_returns).addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_combo_cateActionPerformed

    private void combo_catePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_combo_catePopupMenuWillBecomeInvisible

    }//GEN-LAST:event_combo_catePopupMenuWillBecomeInvisible

    private void combo_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_supplierActionPerformed

        try {
            clearTable();
            ResultSet r = new JDBC().getData("SELECT * FROM returns WHERE sup_id LIKE '" + combo_supplier.getEditor().getItem() + "%' ");
            String[] id;
            while (r.next()) {
                Vector v = new Vector();

                v.add(r.getInt("return_id"));
                v.add(r.getString("serial"));
                v.add(new SimpleDateFormat("yyyy-MM-dd").format(r.getDate("date")));
                id = r.getString("serial").split("-");
                v.add(getDescription(id[0]));
                if (r.getString("invoice_no").equalsIgnoreCase("FROM_STOCK")) {
                    v.add("Not Available !");
                } else {
                    v.add(r.getString("invoice_no"));
                }
                v.add(r.getInt("qty"));
                getNewModel(table_returns).addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_combo_supplierActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel background;
    private javax.swing.JComboBox combo_cate;
    private javax.swing.JComboBox combo_supplier;
    private javax.swing.JComboBox combo_viewBy;
    private com.toedter.calendar.JDateChooser date_chooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_cate;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_supp;
    private javax.swing.JTable table_returns;
    // End of variables declaration//GEN-END:variables

    private void setEvents() {
        combo_cate.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                combo_cateActionPerformed(null);
                if (table_returns.getRowCount() <= 0) {
                    BalloonTip tip = WarningBalloons.getTip(combo_cate, "No Reports Found!");
                    TimingUtils.showTimedBalloon(tip, 1000);

                }
            }
        });

        combo_supplier.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                combo_supplierActionPerformed(null);
                if (table_returns.getRowCount() <= 0) {
                    BalloonTip tip = WarningBalloons.getTip(combo_supplier, "No Reports Found!");
                    TimingUtils.showTimedBalloon(tip, 1000);
                }
            }
        });
    }
}

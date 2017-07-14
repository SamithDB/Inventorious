/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deeptha Senanayake
 */
public class ViewStock extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewStock
     */
    public ViewStock() {
        super("View Stock Items", true, true, true, true);
        initComponents();
        getCategories();
        viewStockItems("All", combo_SelectModel.getSelectedItem().toString());
    }

    public static void setQty(String serial, int qty) {
        int rowc = table_itemDetails.getRowCount();
        for (int i = 0; i < rowc; i++) {
            if (serial.equals(table_itemDetails.getValueAt(i, 0))) {
                if (qty > 0) {
                    table_itemDetails.setValueAt(qty, i, 2);
                } else {
                    table_itemDetails.setValueAt("Not Available !", i, 2);
                }
            }
        }
    }

    private void viewStockItems(String category, String model) {

        DefaultTableModel model1 = (DefaultTableModel) table_itemDetails.getModel();
        int rowC = table_itemDetails.getRowCount();

        for (int i = 0; i < rowC; i++) {
            model1.removeRow(0);
        }

        String sql = "";
        if (category.equalsIgnoreCase("All") && model.equalsIgnoreCase("All")) {
            sql = " WHERE qty>0";
        } else if (category.equals("All")) {
            sql = " WHERE item_id IN(SELECT item_id FROM items WHERE item_model='" + model + "') AND qty > 0";
        } else if (model.equals("All")) {
            sql = " WHERE item_id IN(SELECT item_id FROM items WHERE item_cate='" + category + "' ) AND qty > 0";
        } else {
            sql = " WHERE item_id IN(SELECT item_id FROM items WHERE item_model='" + model + "' AND item_cate='" + category + "' ) AND qty > 0";
        }
        try {
            JDBC DB = new JDBC();
            ResultSet r = DB.getData("SELECT * FROM stock" + sql);

            while (r.next()) {
                ResultSet r2 = DB.getData("SELECT item_des FROM items WHERE item_id='" + r.getString("item_id") + "' ");
                ResultSet r3 = DB.getData("SELECT cost FROM grn WHERE serial='" + r.getString("serial") + "' ");

                Vector v = new Vector();
                v.add(r.getString("serial"));
                if (r2.next()) {
                    v.add(r2.getString("item_des"));
                } else {
                    v.add("Cannot find!");
                }
                if (r.getInt("qty") <= 0) {
                    v.add("Not Available");
                } else if (r.getInt("qty") < 5) {
                    v.add(r.getInt("qty"));
                } else if (r.getInt("qty") < 10) {
                    v.add(r.getInt("qty"));
                } else {
                    v.add(r.getString("qty"));
                }
                v.add(r.getString("warranty"));
                if (r3.next()) {
                    v.add(r3.getDouble("cost"));
                } else {
                    v.add("Cannot find !");
                }
                v.add(r.getDouble("price"));

                model1.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getCategories() {
        try {
            ResultSet r = new JDBC().getData("SELECT DISTINCT(item_cate) FROM items WHERE item_id IN(SELECT item_id FROM stock WHERE qty>0) ");
            Vector v = new Vector();
            v.add("All");
            while (r.next()) {
                v.add(r.getString("item_cate"));
            }
            lst_categories.setListData(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lst_categories.setSelectedIndex(0);
        getModels("All");
    }

    void getModels(String Category) {
        String sql;
        if (Category.equals("All")) {
            sql = "WHERE item_id IN(SELECT item_id FROM stock WHERE qty>0 )";
        } else {
            sql = "WHERE item_cate='" + Category + "' AND item_id IN(SELECT item_id FROM stock WHERE qty>0)";
        }
        try {
            ResultSet r = new JDBC().getData("SELECT DISTINCT(item_model) FROM items " + sql);
            Vector v = new Vector();
            v.add("All");
            while (r.next()) {
                v.add(r.getString("item_model"));
            }
            combo_SelectModel.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search_Item(String keyword) {

        lst_categories.setSelectedIndex(0);
        combo_SelectModel.setSelectedIndex(0);
        int rowCount = table_itemDetails.getRowCount();
        DefaultTableModel model1 = (DefaultTableModel) table_itemDetails.getModel();

        for (int i = 0; i < rowCount; i++) {
            model1.removeRow(0);
        }

        try {
            ResultSet r = new JDBC().getData("SELECT * FROM stock WHERE qty>0 AND (item_id IN(SELECT item_id FROM items WHERE item_des LIKE'%" + keyword + "%') OR serial LIKE'%" + keyword + "%') ");

            while (r.next()) {
                ResultSet r2 = new JDBC().getData("SELECT item_des FROM items WHERE item_id='" + r.getString("item_id") + "' ");
                ResultSet r3 = new JDBC().getData("SELECT cost FROM grn WHERE serial='" + r.getString("serial") + "' ");
                Vector v = new Vector();
                v.add(r.getString("serial"));
                if (r2.next()) {
                    v.add(r2.getString("item_des"));
                } else {
                    v.add("Cannot found !");
                }
                if (r.getInt("Qty") > 0) {
                    v.add(r.getInt("qty"));
                } else {
                    v.add("Not Available");
                }
                v.add(r.getString("warranty"));
                if (r3.next()) {
                    v.add(r3.getString("cost"));
                } else {
                    v.add("cannot found");
                }
                v.add(r.getString("price"));

                model1.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error while searching item !");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        panel_item_info = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_itemDetails = new javax.swing.JTable();
        combo_SelectModel = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        btn_Refresh = new javax.swing.JButton();
        btn_itemReturn = new javax.swing.JButton();
        btn_Edit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_categories = new javax.swing.JList();
        background = new javax.swing.JLabel();

        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_box-32.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1366, 731));
        setMinimumSize(new java.awt.Dimension(1366, 731));
        setPreferredSize(new java.awt.Dimension(1386, 731));

        jPanel1.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_box-64.png"))); // NOI18N
        jLabel20.setText(" View Stock Items");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel20);
        jLabel20.setBounds(10, 11, 353, 64);

        panel_item_info.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Item Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panel_item_info.setMinimumSize(new java.awt.Dimension(451, 201));
        panel_item_info.setOpaque(false);

        table_itemDetails.setAutoCreateRowSorter(true);
        table_itemDetails.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table_itemDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><b>Serial</b></html>", "Description", "Qty", "Warranty Period", "Cost", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_itemDetails.setRowHeight(20);
        table_itemDetails.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_itemDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_itemDetailsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_itemDetails);
        if (table_itemDetails.getColumnModel().getColumnCount() > 0) {
            table_itemDetails.getColumnModel().getColumn(0).setMinWidth(100);
            table_itemDetails.getColumnModel().getColumn(0).setPreferredWidth(100);
            table_itemDetails.getColumnModel().getColumn(0).setMaxWidth(120);
            table_itemDetails.getColumnModel().getColumn(1).setMinWidth(300);
            table_itemDetails.getColumnModel().getColumn(1).setPreferredWidth(300);
            table_itemDetails.getColumnModel().getColumn(1).setMaxWidth(350);
            table_itemDetails.getColumnModel().getColumn(4).setPreferredWidth(120);
            table_itemDetails.getColumnModel().getColumn(4).setMaxWidth(130);
            table_itemDetails.getColumnModel().getColumn(5).setPreferredWidth(120);
            table_itemDetails.getColumnModel().getColumn(5).setMaxWidth(130);
        }

        combo_SelectModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_SelectModel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        combo_SelectModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_SelectModelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Model :");

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txt_search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel_item_infoLayout = new javax.swing.GroupLayout(panel_item_info);
        panel_item_info.setLayout(panel_item_infoLayout);
        panel_item_infoLayout.setHorizontalGroup(
            panel_item_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_item_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_item_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addGroup(panel_item_infoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_SelectModel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        panel_item_infoLayout.setVerticalGroup(
            panel_item_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_item_infoLayout.createSequentialGroup()
                .addGroup(panel_item_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_SelectModel)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_item_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panel_item_info);
        panel_item_info.setBounds(390, 112, 970, 510);

        btn_Refresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sinchronize-32.png"))); // NOI18N
        btn_Refresh.setText("Refresh");
        btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Refresh);
        btn_Refresh.setBounds(185, 632, 115, 41);

        btn_itemReturn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_itemReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return-32 (2).png"))); // NOI18N
        btn_itemReturn.setText("Return Item(s)");
        btn_itemReturn.setToolTipText("Return to Supplier");
        btn_itemReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_itemReturnActionPerformed(evt);
            }
        });
        jPanel1.add(btn_itemReturn);
        btn_itemReturn.setBounds(20, 632, 159, 41);

        btn_Edit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empty_box-32_1.png"))); // NOI18N
        btn_Edit.setText("View");
        btn_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Edit);
        btn_Edit.setBounds(306, 632, 100, 40);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categories", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setOpaque(false);

        lst_categories.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lst_categories.setForeground(new java.awt.Color(0, 153, 153));
        lst_categories.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lst_categories.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lst_categories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lst_categoriesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lst_categories);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 110, 370, 510);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 1380, 700);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed

    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyPressed

        if (evt.getKeyCode() == 10) {
            search_Item(txt_search.getText());
        }

    }//GEN-LAST:event_txt_searchKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        search_Item(txt_search.getText());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked

    }//GEN-LAST:event_jLabel20MouseClicked

    private void table_itemDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_itemDetailsMouseClicked

        if (evt.getClickCount() == 2) {
            btn_EditActionPerformed(null);
        }
    }//GEN-LAST:event_table_itemDetailsMouseClicked

    private void combo_SelectModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_SelectModelActionPerformed

        viewStockItems(lst_categories.getSelectedValue().toString(), combo_SelectModel.getSelectedItem().toString());

    }//GEN-LAST:event_combo_SelectModelActionPerformed

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed

        getCategories();
        viewStockItems("All", "All");
        txt_search.setText(null);
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased

        search_Item(txt_search.getText());
    }//GEN-LAST:event_txt_searchKeyReleased

    private void btn_itemReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_itemReturnActionPerformed

        if (table_itemDetails.getSelectedRowCount() > 0) {
            int sel = table_itemDetails.getSelectedRow();
            ReturnStockItems returnStock = new ReturnStockItems();
            returnStock.description = (String) table_itemDetails.getValueAt(sel, 1);
            returnStock.qty = Integer.parseInt(table_itemDetails.getValueAt(sel, 2).toString());
            returnStock.serial = (String) table_itemDetails.getValueAt(sel, 0);
            returnStock.warranty = table_itemDetails.getValueAt(sel, 3).toString();

            returnStock.setDetails();
            returnStock.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please Select item to Return !");
        }

    }//GEN-LAST:event_btn_itemReturnActionPerformed

    private void btn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditActionPerformed

        int sel = table_itemDetails.getSelectedRow();
        String serial = table_itemDetails.getValueAt(sel, 0).toString();
        String qty = table_itemDetails.getValueAt(sel, 2).toString();
        String cost = table_itemDetails.getValueAt(sel, 4).toString();
        String period = table_itemDetails.getValueAt(sel, 3).toString();
        double price = Double.parseDouble(table_itemDetails.getValueAt(sel, 5).toString());
        String id[] = serial.split("-");
        String description = table_itemDetails.getValueAt(sel, 1).toString();

        new StockEdit(serial, id[0], description, qty, cost, period, price).setVisible(true);
    }//GEN-LAST:event_btn_EditActionPerformed

    private void lst_categoriesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lst_categoriesMouseReleased

        viewStockItems(lst_categories.getSelectedValue().toString(), combo_SelectModel.getSelectedItem().toString());
        getModels(lst_categories.getSelectedValue().toString());
    }//GEN-LAST:event_lst_categoriesMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_Edit;
    private javax.swing.JButton btn_Refresh;
    private javax.swing.JButton btn_itemReturn;
    private javax.swing.JComboBox combo_SelectModel;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList lst_categories;
    private javax.swing.JPanel panel_item_info;
    public static javax.swing.JTable table_itemDetails;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}

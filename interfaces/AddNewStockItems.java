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
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.utils.TimingUtils;

/**
 *
 * @author Deeptha Senanayake
 */
public class AddNewStockItems extends javax.swing.JInternalFrame {

    static String employee_id = "EMP000001";
    Vector<String> itemDetails = new Vector<>();
    String GRN_NO;

    /**
     * Creates new form AddNewItems
     */
    public AddNewStockItems() {
        super("Add New Items", true, true, true, true);
        initComponents();
        SupplierIDs();
        getItemIDs();
        setEvent();
        setUp();
    }

    private void setUp() {
        combo_suppIDActionPerformed(null);
        progress_lable.setVisible(false);
    }

    void removeSelectedItem(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(table.getSelectedRow());
    }

    Vector<String> getItemDetails(String itemId) {
        Vector v = new Vector();
        for (int i = 0; i < itemDetails.size(); i++) {
            String[] id = itemDetails.get(i).split("#");
            if (id[0].equals(itemId)) {
                v.add(id[1]);
                v.add(id[2]);
                v.add(id[3]);
                break;
            }
        }
        return v;
    }

    private void setEvent() {
        combo_discount.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == 10) {
                    txt_itemPrice.grabFocus();
                }
                if (!Character.isDigit(ke.getKeyChar())) {
                    ke.consume();
                    BalloonTip tip = WarningBalloons.getTip(combo_discount, "Only Numbers");
                    tip.setVisible(true);
                    TimingUtils.showTimedBalloon(tip, 2000);
                }
            }
        });
        combo_suppID.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (combo_suppID.getSelectedIndex() != 0) {
                    btn_addItem.grabFocus();
                } else {
                    Check_newSup.grabFocus();
                }
            }
        });
    }

    boolean isExist() {
        int rows = table_newitems.getRowCount();
        boolean yes = false;
        for (int i = 0; i < rows; i++) {
            String[] id = item_ID.getSelectedItem().toString().split(" ");
            if (table_newitems.getValueAt(i, 0).equals(id[0])) {
                yes = true;
                break;
            }
        }
        return yes;

    }

    void resetFields() {
        txt_itemCost.setText(null);
        txt_itemPrice.setText(null);
        spin_qty.setValue(0);
        item_ID.setSelectedIndex(0);
        item_des.setText(null);
        combo_period.setSelectedIndex(0);
        spin_warranty.setValue(0);
        check_discount.setSelected(false);
        check_discountActionPerformed(null);
        discount.setText(null);
        updated_cost.setText(null);
        check_warrantyPeriod.setSelected(false);
        if (table_newitems.getRowCount() == 0) {
            combo_suppID.setSelectedIndex(0);
            combo_suppIDActionPerformed(null);
        }
    }

    boolean isEmptyDiscount() {
        return (check_discount.isSelected() && combo_discount.getSelectedItem().toString().isEmpty()) || (check_discount.isSelected() && combo_discount.getSelectedItem().equals(0));
    }

    boolean isEmptyWarranty() {
        return check_warrantyPeriod.isSelected() && (spin_warranty.getValue().equals(0) || combo_period.getSelectedIndex() == 0);
    }

    boolean isEmptyFields() {
        return item_ID.getSelectedIndex() == 0 || spin_qty.getValue().equals(0) || txt_itemCost.getValue() == null || txt_itemPrice.getValue() == null;
    }

    private void getItemIDs() {
        try {
            ResultSet r = new JDBC().getData("SELECT item_id,item_des FROM items");
            Vector v = new Vector();
            v.add("Select");
            v.add("--Add New Item--");
            while (r.next()) {
                v.add(r.getString("item_id") + " " + r.getString("item_des"));
            }
            item_ID.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
        }
        item_IDActionPerformed(null);
    }

    private void SupplierIDs() {
        try {
            ResultSet r = new JDBC().getData("SELECT * FROM suppliers");
            Vector v = new Vector();
            v.add("Select");
            while (r.next()) {
                v.add(r.getString("sup_id"));
            }
            combo_suppID.setModel(new DefaultComboBoxModel(v));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error while loading supplier IDs");
        }
    }

    String nextGrnId() {
        int nextGrnID = 0;
        try {
            ResultSet r = new JDBC().getData("SELECT COUNT(grn_no) as grn_no FROM grn_info");
            if (r.next()) {
                nextGrnID = r.getInt("grn_no") + 1;
            } else {
                nextGrnID = 1;
            }
        } catch (Exception e) {
        }
        return ("GRN" + String.format("%06d", nextGrnID));

    }

    private void saveGRN() {

        new Thread(new Runnable() {

            @Override
            public void run() {
                GRN_NO = nextGrnId();
                int rowCount = table_newitems.getRowCount();
                btn_saveGRN.setEnabled(false);
                table_newitems.setEnabled(false);
                progress_lable.setVisible(true);
                for (int i = 0; i < rowCount; i++) {
                    progress_lable.setText("Saving Stock items..");

                    String serial, itemID;
                    itemID = table_newitems.getValueAt(i, 0).toString();
                    //get current batch no from item ID
                    int batch_no = getBatchNo(itemID);
                    //generate unique serial number
                    serial = itemID + "-" + batch_no;

                    try {
                        new JDBC().putData("INSERT INTO stock VALUES('" + serial + "','" + itemID + "','" + batch_no + "','" + table_newitems.getValueAt(i, 3) + "','" + table_newitems.getValueAt(i, 4) + "','" + table_newitems.getValueAt(i, 5) + "' )");
                        progress_lable.setText("Updating Current GRN Report..");
                        new JDBC().putData("INSERT INTO grn VALUES('" + GRN_NO + "','" + serial + "','" + itemID + "','" + table_newitems.getValueAt(i, 2) + "','" + table_newitems.getValueAt(i, 5) + "','" + table_newitems.getValueAt(i, 6) + "')");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (i == rowCount - 1) {
                        progress_lable.setText("Saving GRN info..");
                        try {
                            new JDBC().putData("INSERT INTO grn_info VALUES('" + GRN_NO + "','" + combo_suppID.getSelectedItem() + "','" + employee_id + "','" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "','" + subTotal() + "')");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                btn_saveGRN.setEnabled(true);
                table_newitems.setEnabled(true);
                progress_lable.setVisible(false);

                DefaultTableModel d_model = (DefaultTableModel) table_newitems.getModel();
                int rowc = d_model.getRowCount();
                for (int i = 0; i < rowc; i++) {
                    d_model.removeRow(0);
                }
                combo_suppID.setEnabled(true);
                Check_newSup.setEnabled(true);
                total_cost.setText(String.valueOf(subTotal()));
                if (jCheckBox1.isSelected()) {
                    ViewGRN grn = new ViewGRN();
                    Home.jDesktopPane2.add(grn);
                    grn.setVisible(true);
                    grn.viewByGRN(GRN_NO);
                }
                Thread.currentThread().stop();
            }
        }).start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_AddNewItems = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        panel_itemDetails = new javax.swing.JPanel();
        lbl_price = new javax.swing.JLabel();
        lbl_cost = new javax.swing.JLabel();
        lbl_Qty = new javax.swing.JLabel();
        spin_qty = new javax.swing.JSpinner();
        lbl_ItemID = new javax.swing.JLabel();
        item_ID = new javax.swing.JComboBox();
        lbl_Description = new javax.swing.JLabel();
        item_des = new javax.swing.JLabel();
        discount = new javax.swing.JLabel();
        check_discount = new javax.swing.JCheckBox();
        combo_discount = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txt_itemPrice = new javax.swing.JFormattedTextField();
        txt_itemCost = new javax.swing.JFormattedTextField();
        updated_cost = new javax.swing.JLabel();
        lbl_updatedCost = new javax.swing.JLabel();
        combo_period = new javax.swing.JComboBox();
        check_warrantyPeriod = new javax.swing.JCheckBox();
        spin_warranty = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_supName = new javax.swing.JLabel();
        lbl_supWebsite = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Check_newSup = new javax.swing.JCheckBox();
        combo_suppID = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_newitems = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        total_cost = new javax.swing.JLabel();
        progress_lable = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        btn_saveGRN = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_addItem = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-32.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1366, 731));
        setMinimumSize(new java.awt.Dimension(1366, 731));
        setPreferredSize(new java.awt.Dimension(1366, 731));
        getContentPane().setLayout(null);

        Panel_AddNewItems.setMaximumSize(new java.awt.Dimension(1366, 768));
        Panel_AddNewItems.setOpaque(false);
        Panel_AddNewItems.setPreferredSize(new java.awt.Dimension(1366, 768));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/box2-64.png"))); // NOI18N
        jLabel7.setText("Add New Stock Items");

        jPanel6.setDoubleBuffered(false);
        jPanel6.setOpaque(false);

        panel_itemDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Item Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panel_itemDetails.setMaximumSize(new java.awt.Dimension(341, 239));
        panel_itemDetails.setMinimumSize(new java.awt.Dimension(341, 239));
        panel_itemDetails.setOpaque(false);

        lbl_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_price.setText("Selling Price (Rs):");

        lbl_cost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_cost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_cost.setText("Cost per Unit(Rs):");

        lbl_Qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Qty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_Qty.setText("Qty :");

        spin_qty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spin_qty.setName(""); // NOI18N
        spin_qty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                spin_qtyMouseEntered(evt);
            }
        });
        spin_qty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spin_qtyStateChanged(evt);
            }
        });
        spin_qty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spin_qtyFocusLost(evt);
            }
        });
        spin_qty.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                spin_qtyInputMethodTextChanged(evt);
            }
        });
        spin_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spin_qtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spin_qtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spin_qtyKeyTyped(evt);
            }
        });

        lbl_ItemID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_ItemID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_ItemID.setText("Item ID :");

        item_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        item_ID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<< Add New Item >>" }));
        item_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_IDActionPerformed(evt);
            }
        });
        item_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                item_IDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                item_IDKeyReleased(evt);
            }
        });

        lbl_Description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_Description.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_Description.setText("Description :");

        item_des.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        item_des.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        item_des.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        discount.setToolTipText("");
        discount.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        check_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        check_discount.setText("Discount :");
        check_discount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        check_discount.setOpaque(false);
        check_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_discountActionPerformed(evt);
            }
        });
        check_discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                check_discountKeyReleased(evt);
            }
        });

        combo_discount.setEditable(true);
        combo_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_discount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "50", "25", "15", "10", "5", "0" }));
        combo_discount.setSelectedIndex(5);
        combo_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_discountActionPerformed(evt);
            }
        });
        combo_discount.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                combo_discountPropertyChange(evt);
            }
        });
        combo_discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_discountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_discountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                combo_discountKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("%");

        txt_itemPrice.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txt_itemPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_itemPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_itemPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_itemPriceActionPerformed(evt);
            }
        });
        txt_itemPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_itemPriceKeyReleased(evt);
            }
        });

        txt_itemCost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txt_itemCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_itemCost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_itemCost.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_itemCostPropertyChange(evt);
            }
        });
        txt_itemCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_itemCostKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_itemCostKeyTyped(evt);
            }
        });

        updated_cost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updated_cost.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        updated_cost.setToolTipText("");
        updated_cost.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_updatedCost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_updatedCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_updatedCost.setText("Updated Cost(Rs) :");

        combo_period.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_period.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Days", "Months", "Years" }));
        combo_period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_periodActionPerformed(evt);
            }
        });
        combo_period.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_periodKeyReleased(evt);
            }
        });

        check_warrantyPeriod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        check_warrantyPeriod.setText("Warranty :");
        check_warrantyPeriod.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        check_warrantyPeriod.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        check_warrantyPeriod.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        check_warrantyPeriod.setOpaque(false);
        check_warrantyPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_warrantyPeriodActionPerformed(evt);
            }
        });
        check_warrantyPeriod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                check_warrantyPeriodKeyReleased(evt);
            }
        });

        spin_warranty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spin_warranty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spin_warrantyStateChanged(evt);
            }
        });
        spin_warranty.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                spin_warrantyPropertyChange(evt);
            }
        });
        spin_warranty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spin_warrantyKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel_itemDetailsLayout = new javax.swing.GroupLayout(panel_itemDetails);
        panel_itemDetails.setLayout(panel_itemDetailsLayout);
        panel_itemDetailsLayout.setHorizontalGroup(
            panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_itemDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_Description, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Qty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_cost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(check_discount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_updatedCost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(lbl_price, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_ItemID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(check_warrantyPeriod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updated_cost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_itemDetailsLayout.createSequentialGroup()
                        .addComponent(combo_discount, 0, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_itemCost, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spin_qty, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(item_des, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_itemPrice)
                    .addComponent(item_ID, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_itemDetailsLayout.createSequentialGroup()
                        .addComponent(spin_warranty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_period, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel_itemDetailsLayout.setVerticalGroup(
            panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_itemDetailsLayout.createSequentialGroup()
                .addGroup(panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Description)
                    .addComponent(item_des, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Qty)
                    .addComponent(spin_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_itemCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check_discount)
                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo_discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updated_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_updatedCost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_price)
                    .addComponent(txt_itemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_itemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spin_warranty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_warrantyPeriod))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Supplier Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel5.setMaximumSize(new java.awt.Dimension(341, 141));
        jPanel5.setMinimumSize(new java.awt.Dimension(341, 141));
        jPanel5.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Supplier ID :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Company Name :");

        lbl_supName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_supName.setText("ABC Suppliers(pvt) Ltd.");

        lbl_supWebsite.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lbl_supWebsite.setForeground(new java.awt.Color(0, 153, 153));
        lbl_supWebsite.setText("www.abc_suplier.com");
        lbl_supWebsite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Website :");

        Check_newSup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Check_newSup.setText("New Supplier");
        Check_newSup.setOpaque(false);
        Check_newSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_newSupActionPerformed(evt);
            }
        });
        Check_newSup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Check_newSupKeyPressed(evt);
            }
        });

        combo_suppID.setEditable(true);
        combo_suppID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_suppID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_suppIDActionPerformed(evt);
            }
        });
        combo_suppID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_suppIDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(303, 303, 303))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_supName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(combo_suppID, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Check_newSup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbl_supWebsite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Check_newSup, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_suppID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_supName)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbl_supWebsite))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table_newitems.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table_newitems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><b>Item ID</b></html>", "Item Description", "Cost per Unit", "Selling Price", "Warranty Period", "Qty", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_newitems.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table_newitems.setRequestFocusEnabled(false);
        table_newitems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table_newitems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_newitemsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_newitemsMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table_newitems);
        if (table_newitems.getColumnModel().getColumnCount() > 0) {
            table_newitems.getColumnModel().getColumn(0).setPreferredWidth(70);
            table_newitems.getColumnModel().getColumn(0).setMaxWidth(80);
            table_newitems.getColumnModel().getColumn(2).setMinWidth(100);
            table_newitems.getColumnModel().getColumn(2).setPreferredWidth(70);
            table_newitems.getColumnModel().getColumn(2).setMaxWidth(100);
            table_newitems.getColumnModel().getColumn(3).setMinWidth(100);
            table_newitems.getColumnModel().getColumn(3).setPreferredWidth(70);
            table_newitems.getColumnModel().getColumn(3).setMaxWidth(100);
            table_newitems.getColumnModel().getColumn(4).setMinWidth(150);
            table_newitems.getColumnModel().getColumn(4).setMaxWidth(200);
            table_newitems.getColumnModel().getColumn(5).setMinWidth(30);
            table_newitems.getColumnModel().getColumn(5).setPreferredWidth(40);
            table_newitems.getColumnModel().getColumn(5).setMaxWidth(50);
            table_newitems.getColumnModel().getColumn(6).setMinWidth(100);
            table_newitems.getColumnModel().getColumn(6).setPreferredWidth(100);
            table_newitems.getColumnModel().getColumn(6).setMaxWidth(200);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Subtotal :");

        total_cost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        total_cost.setForeground(new java.awt.Color(102, 102, 102));
        total_cost.setText("-----.--");

        progress_lable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        progress_lable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ajax-loader (9).gif"))); // NOI18N
        progress_lable.setText("Saving Stock items");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("View GRN Report After Save");
        jCheckBox1.setOpaque(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_itemDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(progress_lable, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(total_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(panel_itemDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(progress_lable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(total_cost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.setOpaque(false);

        btn_saveGRN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_saveGRN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checkmark-32.png"))); // NOI18N
        btn_saveGRN.setText("Save GRN Report");
        btn_saveGRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveGRNActionPerformed(evt);
            }
        });

        btn_remove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-32.png"))); // NOI18N
        btn_remove.setText("Remove Item(s)");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/file-32.png"))); // NOI18N
        jButton4.setText("New GRN");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_remove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_saveGRN, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(btn_remove)
                    .addComponent(btn_saveGRN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        btn_addItem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_addItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_image-32.png"))); // NOI18N
        btn_addItem.setText("Add item");
        btn_addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addItemActionPerformed(evt);
            }
        });

        btn_reset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/undo-32.png"))); // NOI18N
        btn_reset.setText("Reset Fields");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btn_addItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_reset)
                .addGap(0, 160, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout Panel_AddNewItemsLayout = new javax.swing.GroupLayout(Panel_AddNewItems);
        Panel_AddNewItems.setLayout(Panel_AddNewItemsLayout);
        Panel_AddNewItemsLayout.setHorizontalGroup(
            Panel_AddNewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AddNewItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_AddNewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_AddNewItemsLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(125, 125, 125))
                    .addGroup(Panel_AddNewItemsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        Panel_AddNewItemsLayout.setVerticalGroup(
            Panel_AddNewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AddNewItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_AddNewItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        getContentPane().add(Panel_AddNewItems);
        Panel_AddNewItems.setBounds(0, 2, 1345, 700);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1350, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveGRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveGRNActionPerformed
        if (combo_suppID.getSelectedIndex() != 0 && !Check_newSup.isSelected()) {
            saveGRN();

        } else if (Check_newSup.isSelected()) {
            Add_new sup = new Add_new();

            Home.jDesktopPane2.add(sup);
            sup.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please Select Supplier ID/Add New Supplier to Save GRN report");
        }

    }//GEN-LAST:event_btn_saveGRNActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        int row_count = table_newitems.getSelectedRowCount();
        if (row_count > 0) {
            int conf = JOptionPane.showConfirmDialog(this, "Are uor Sure ?", "Remove Item", 0, JOptionPane.QUESTION_MESSAGE);
            if (conf == 0) {
                int row = table_newitems.getSelectedRow();

                for (int i = 0; i < row_count; i++) {
                    DefaultTableModel model3 = (DefaultTableModel) table_newitems.getModel();
                    model3.removeRow(row);
                }
                if (table_newitems.getRowCount() == 0) {
                    combo_suppID.setEnabled(true);
                    Check_newSup.setEnabled(true);
                } else {
                    combo_suppID.setEnabled(false);
                    Check_newSup.setEnabled(false);
                }
                total_cost.setText(String.valueOf(subTotal()));
            }
        }
    }//GEN-LAST:event_btn_removeActionPerformed

    private void spin_qtyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spin_qtyMouseEntered

    }//GEN-LAST:event_spin_qtyMouseEntered

    private void spin_qtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spin_qtyFocusLost

    }//GEN-LAST:event_spin_qtyFocusLost

    private void spin_qtyInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_spin_qtyInputMethodTextChanged

    }//GEN-LAST:event_spin_qtyInputMethodTextChanged

    private void spin_qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spin_qtyKeyPressed

    }//GEN-LAST:event_spin_qtyKeyPressed

    private void Check_newSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_newSupActionPerformed

        if (Check_newSup.isSelected() == true) {
            combo_suppID.setEnabled(false);
            lbl_supName.setText("Not Available !");
            lbl_supWebsite.setText("Not Available !");
        } else {
            combo_suppID.setEnabled(true);

            lbl_supName.setText("ABC Company ");
            lbl_supWebsite.setText("www.abccompany.com");
        }
    }//GEN-LAST:event_Check_newSupActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        int conf = JOptionPane.showConfirmDialog(this, "Are you really want to Reset ?", "Reset Fields !", JOptionPane.YES_NO_OPTION);
        if (conf == 0) {
            resetFields();
        }
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addItemActionPerformed

        if (!isEmptyFields()) {
            if (!isEmptyDiscount()) {
                if (!isEmptyWarranty()) {
                    if (!isExist()) {
                        DefaultTableModel model2 = (DefaultTableModel) table_newitems.getModel();

                        Vector v = new Vector();
                        double cost;
                        int qty;
                        String id[] = item_ID.getSelectedItem().toString().split(" ");
                        v.add(id[0]);
                        v.add(item_des.getText());
                        if (check_discount.isSelected()) {
                            v.add(updated_cost.getText());
                            cost = Double.parseDouble(updated_cost.getText());
                        } else {
                            v.add(txt_itemCost.getValue());
                            cost = Double.parseDouble(txt_itemCost.getValue().toString());
                        }

                        v.add(txt_itemPrice.getValue());
                        if (!check_warrantyPeriod.isSelected()) {
                            v.add("No Warranty");
                        } else {
                            v.add(spin_warranty.getValue() + "-" + combo_period.getSelectedItem().toString());
                        }
                        itemDetails.add(id[0] + "#" + txt_itemCost.getValue() + "#" + combo_discount.getSelectedItem());
                        qty = Integer.parseInt(spin_qty.getValue().toString());
                        v.add(qty);
                        v.add(cost * qty);
                        model2.addRow(v);
                        resetFields();
                        calDiscount();
                    } else {
                        JOptionPane.showMessageDialog(this, "This item is Already Added to Current GRN.", "Exist", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please Select Warranty Period or \n Uncheck the Warranty.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Enter Discount Amount or \n Uncheck the Discout.", "Discount", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "<html>Fill all Fields !<br> <b> Please Select Item Category !<br>Quentity must be at least 1<br>Please Enter Cost !<br>Please Enter Price !</html>", "Add Stock Item", JOptionPane.WARNING_MESSAGE);
        }
        if (table_newitems.getRowCount() > 0 && combo_suppID.getSelectedIndex() != 0 && !Check_newSup.isSelected()) {
            combo_suppID.setEnabled(false);
            Check_newSup.setEnabled(false);
        }
        total_cost.setText(String.valueOf(subTotal()));
    }//GEN-LAST:event_btn_addItemActionPerformed

    int getBatchNo(String item_ID) {
        int batch_no = 0;
        try {
            ResultSet r = new JDBC().getData("SELECT COUNT(item_id) AS COUNT FROM stock WHERE item_id='" + item_ID + "'");
            if (r.next()) {
                batch_no = r.getInt("COUNT") + 1;
            }
            return batch_no;
        } catch (Exception e) {
            return batch_no;
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        DefaultTableModel model = (DefaultTableModel) table_newitems.getModel();
        int rowc = table_newitems.getRowCount();
        if (rowc == 0) {
            combo_suppID.setEnabled(true);
            Check_newSup.setEnabled(true);
        } else {
            int conf = JOptionPane.showConfirmDialog(this, "Current Data will be Lost !,Continue ?", "New GRN Report", 0);
            if (conf == 0) {
                for (int i = 0; i < rowc; i++) {
                    model.removeRow(0);
                }
                combo_suppID.setEnabled(true);
                Check_newSup.setEnabled(true);
            }
        }
        resetFields();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void item_IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_IDKeyPressed

        try {
            if (item_ID.getSelectedIndex() != 0 && item_ID.getSelectedIndex() != 1 && evt.getKeyCode() == 10) {
                item_IDActionPerformed(null);
                spin_qty.grabFocus();
            } else if (evt.isControlDown() && evt.getKeyCode() == 40) {
                item_ID.setSelectedIndex(item_ID.getSelectedIndex() + 5);
            } else if (evt.isControlDown() && evt.getKeyCode() == 38) {
                item_ID.setSelectedIndex(item_ID.getSelectedIndex() - 5);
            }
        } catch (Exception e) {
            TimingUtils.showTimedBalloon(WarningBalloons.getTip(item_ID, "No Items !"), 1000);
        }
    }//GEN-LAST:event_item_IDKeyPressed

    private void item_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_IDActionPerformed

        if (item_ID.getSelectedIndex() == 1) {
            setEnable(false);
            new AddNewItem().setVisible(true);
        } else if (item_ID.getSelectedIndex() == 0) {
            setEnable(false);
        } else {
            spin_qty.setEnabled(true);
            txt_itemCost.setEnabled(true);
            txt_itemPrice.setEnabled(true);
            check_discount.setEnabled(true);
            check_warrantyPeriod.setEnabled(true);
            lbl_Description.setEnabled(true);
            lbl_ItemID.setEnabled(true);
            lbl_Qty.setEnabled(true);
            lbl_cost.setEnabled(true);
            lbl_price.setEnabled(true);
            lbl_updatedCost.setEnabled(true);

            String[] Des = item_ID.getSelectedItem().toString().split(" ");
            item_des.setText(Des[1]);
        }
    }//GEN-LAST:event_item_IDActionPerformed

    void setEnable(boolean tr) {
        spin_qty.setEnabled(tr);
        spin_warranty.setEnabled(tr);
        combo_period.setEnabled(tr);
        txt_itemCost.setEnabled(tr);
        txt_itemPrice.setEnabled(tr);
        item_des.setText(null);
        check_discount.setEnabled(tr);
        combo_discount.setEnabled(tr);
        discount.setEnabled(tr);
        check_warrantyPeriod.setEnabled(tr);

        lbl_Description.setEnabled(tr);
        lbl_ItemID.setEnabled(tr);
        lbl_Qty.setEnabled(tr);
        lbl_cost.setEnabled(tr);
        lbl_price.setEnabled(tr);
        lbl_updatedCost.setEnabled(tr);
    }
    private void table_newitemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_newitemsMouseClicked


    }//GEN-LAST:event_table_newitemsMouseClicked

    private void spin_warrantyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_spin_warrantyPropertyChange

    }//GEN-LAST:event_spin_warrantyPropertyChange

    private void combo_periodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_periodActionPerformed

    }//GEN-LAST:event_combo_periodActionPerformed

    private void check_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_discountActionPerformed

        if (check_discount.isSelected()) {
            combo_discount.setEnabled(true);
            discount.setEnabled(true);
        } else {
            combo_discount.setEnabled(false);
            discount.setEnabled(false);
            combo_discount.setSelectedItem("0");
        }
    }//GEN-LAST:event_check_discountActionPerformed

    private void combo_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_discountActionPerformed

        calDiscount();

    }//GEN-LAST:event_combo_discountActionPerformed

    private void combo_discountPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_combo_discountPropertyChange

        calDiscount();


    }//GEN-LAST:event_combo_discountPropertyChange

    private void combo_discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_discountKeyReleased

        if (evt.getKeyCode() == 10) {
            txt_itemPrice.grabFocus();
        }
        calDiscount();
    }//GEN-LAST:event_combo_discountKeyReleased

    private void combo_discountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_discountKeyPressed

        if (evt.getKeyCode() == 10) {

        }
    }//GEN-LAST:event_combo_discountKeyPressed

    private void txt_itemCostPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_itemCostPropertyChange

        calDiscount();
    }//GEN-LAST:event_txt_itemCostPropertyChange

    private void check_warrantyPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_warrantyPeriodActionPerformed

        if (check_warrantyPeriod.isSelected()) {
            spin_warranty.setEnabled(true);
            combo_period.setEnabled(true);
        } else {
            spin_warranty.setEnabled(false);
            combo_period.setEnabled(false);
        }
    }//GEN-LAST:event_check_warrantyPeriodActionPerformed

    private void item_IDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_IDKeyReleased

    }//GEN-LAST:event_item_IDKeyReleased

    private void spin_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spin_qtyKeyReleased

        if (evt.getKeyCode() == 10) {
            txt_itemCost.grabFocus();
        }
    }//GEN-LAST:event_spin_qtyKeyReleased

    private void txt_itemCostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_itemCostKeyReleased

        if (evt.getKeyCode() == 10) {
            check_discount.grabFocus();
        }
    }//GEN-LAST:event_txt_itemCostKeyReleased

    private void check_discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_check_discountKeyReleased

        if (evt.isShiftDown() && evt.getKeyCode() == 10) {
            txt_itemPrice.grabFocus();
        } else if (evt.getKeyCode() == 10 && !check_discount.isSelected()) {
            check_discount.setSelected(true);
            check_discountActionPerformed(null);
            combo_discount.grabFocus();
        }
    }//GEN-LAST:event_check_discountKeyReleased

    private void txt_itemPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_itemPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_itemPriceActionPerformed

    private void txt_itemPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_itemPriceKeyReleased

        if (evt.getKeyCode() == 10) {
            check_warrantyPeriod.grabFocus();
        }
    }//GEN-LAST:event_txt_itemPriceKeyReleased

    private void check_warrantyPeriodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_check_warrantyPeriodKeyReleased

        if (evt.isShiftDown() && evt.getKeyCode() == 10) {
            combo_suppID.grabFocus();
        } else if (!check_warrantyPeriod.isSelected() && evt.getKeyCode() == 10) {
            check_warrantyPeriod.setSelected(true);
            check_warrantyPeriodActionPerformed(null);
            spin_warranty.grabFocus();
        }
    }//GEN-LAST:event_check_warrantyPeriodKeyReleased

    private void spin_warrantyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spin_warrantyKeyReleased

        if (evt.getKeyCode() == 10) {
            combo_period.grabFocus();
        }
    }//GEN-LAST:event_spin_warrantyKeyReleased

    private void combo_periodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_periodKeyReleased

    }//GEN-LAST:event_combo_periodKeyReleased

    private void warranty_startsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_warranty_startsKeyReleased

        if (evt.getKeyCode() == 10) {
            combo_suppID.grabFocus();
        }
    }//GEN-LAST:event_warranty_startsKeyReleased

    private void combo_suppIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_suppIDKeyReleased

        if (combo_suppID.getSelectedIndex() == 0 && evt.getKeyCode() == 10) {
            Check_newSup.grabFocus();
        } else if (evt.getKeyCode() == 10) {
            btn_addItem.grabFocus();
        }
    }//GEN-LAST:event_combo_suppIDKeyReleased

    private void table_newitemsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_newitemsMouseReleased

        if (evt.getClickCount() == 2) {
            if (!spin_qty.getValue().equals(0) || item_ID.getSelectedIndex() != 0 || !txt_itemCost.getValue().equals(0) || !txt_itemPrice.getValue().equals(0)) {
                int decition = JOptionPane.showConfirmDialog(this, "Currently editing Data will be Lost !, continue ?", "Buid PC", 0, JOptionPane.WARNING_MESSAGE);
                if (decition == 0) {
                    setEditItem();
                    total_cost.setText(subTotal() + "");
                }
            } else {
                setEditItem();
            }

        }
    }//GEN-LAST:event_table_newitemsMouseReleased

    private void spin_qtyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spin_qtyStateChanged

        int qty = Integer.parseInt(spin_qty.getValue().toString());
        if (qty < 0) {
            spin_qty.setValue(0);
        }
    }//GEN-LAST:event_spin_qtyStateChanged

    private void combo_suppIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_suppIDActionPerformed

        try {
            ResultSet r = new JDBC().getData("SELECT sup_name,sup_web FROM suppliers WHERE sup_id='" + combo_suppID.getSelectedItem() + "' ");
            if (r.next()) {
                lbl_supName.setText(r.getString("sup_name"));
                lbl_supWebsite.setText(r.getString("sup_web"));
            } else {
                lbl_supName.setText(null);
                lbl_supWebsite.setText(null);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_combo_suppIDActionPerformed

    private void spin_warrantyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spin_warrantyStateChanged

        int wt = Integer.parseInt(spin_warranty.getValue().toString());
        if (wt < 0) {
            spin_warranty.setValue(0);
        }
    }//GEN-LAST:event_spin_warrantyStateChanged

    private void spin_qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spin_qtyKeyTyped

    }//GEN-LAST:event_spin_qtyKeyTyped

    private void txt_itemCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_itemCostKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) && Character.isLetter(evt.getKeyChar())) {
            BalloonTip tip = new WarningBalloons().getTip(txt_itemCost, "Incorrect Input");
            tip.setVisible(true);
            TimingUtils.showTimedBalloon(tip, 2000);
        }

    }//GEN-LAST:event_txt_itemCostKeyTyped

    private void combo_discountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_discountKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_discountKeyTyped

    private void Check_newSupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Check_newSupKeyPressed

        if (evt.getKeyCode() == 10 && Check_newSup.isSelected()) {
            Check_newSup.setSelected(false);
        } else if (evt.getKeyCode() == 10) {
            Check_newSup.setSelected(true);
        }
    }//GEN-LAST:event_Check_newSupKeyPressed

    void setEditItem() {
        int selectedRow = table_newitems.getSelectedRow();
        String id = table_newitems.getValueAt(selectedRow, 0).toString();
        Vector<String> v = getItemDetails(id);

        setEnable(true);
        item_ID.setSelectedItem(id + " " + table_newitems.getValueAt(selectedRow, 1));
        item_IDActionPerformed(null);
        spin_qty.setValue(table_newitems.getValueAt(selectedRow, 5));
        txt_itemPrice.setText(table_newitems.getValueAt(selectedRow, 3).toString());
        txt_itemCost.setValue(Integer.parseInt(v.get(0)));
        int disc = Integer.parseInt(v.get(1));
        if (disc > 0) {
            check_discount.setSelected(true);
            check_discountActionPerformed(null);
            combo_discount.setSelectedItem(disc);
        }
        String war = table_newitems.getValueAt(selectedRow, 4).toString();
        if (war.equalsIgnoreCase("No Warranty")) {
            check_warrantyPeriod.setSelected(false);
            check_warrantyPeriodActionPerformed(null);
        } else {
            String[] warr = table_newitems.getValueAt(selectedRow, 4).toString().split("-");
            spin_warranty.setValue(Integer.parseInt(warr[0]));
            combo_period.setSelectedItem(warr[1]);
        }
        removeSelectedItem(table_newitems);
        calDiscount();
    }

    void calDiscount() {
        try {
            if (!txt_itemCost.getText().isEmpty()) {
                double price = Double.parseDouble(txt_itemCost.getValue().toString());
                double discounts = price * Double.parseDouble(combo_discount.getSelectedItem().toString()) / 100;
                discount.setText("-" + String.valueOf(discounts));
                updated_cost.setText(String.valueOf(price - discounts));
                discount.setToolTipText("Save " + discount.getText().replace("-", ""));
                updated_cost.setToolTipText("Updated Cost with " + combo_discount.getSelectedItem() + "%" + " OFF");
            }
        } catch (NumberFormatException | NullPointerException e) {
        }

    }

    String getWarrantyEndsDate(Date starts, int period, String type) {

        if (starts != null && period > 0 && !type.equalsIgnoreCase("Select")) {
            SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat Year = new SimpleDateFormat("yyyy");
            SimpleDateFormat Month = new SimpleDateFormat("MM");
            SimpleDateFormat Day = new SimpleDateFormat("dd");

            int endYear = 0;
            int endMonth = 0;
            int endDay = 0;

            if (type.equalsIgnoreCase("Years")) {
                endYear = Integer.parseInt(Year.format(starts)) + period;
                endMonth = Integer.parseInt(Month.format(starts));
                endDay = Integer.parseInt(Day.format(starts));

            } else if (type.equalsIgnoreCase("Months")) {
                endMonth = Integer.parseInt(Month.format(starts)) + period;
                if (endMonth > 12) {
                    endYear = endMonth / 12;
                    endMonth = endMonth % 12;
                }
                endYear = Integer.parseInt(Year.format(starts)) + endYear;
                endDay = Integer.parseInt(Day.format(starts)) + endDay;

            } else if (type.equalsIgnoreCase("Days")) {
                endDay = Integer.parseInt(Day.format(starts)) + period;
                if (endDay > 30) {
                    endMonth = endDay / 30;
                    endDay = endDay % 30;
                }
                if (endMonth > 12) {
                    endYear = endMonth / 12;
                    endMonth = endMonth % 12;
                }
                endYear = Integer.parseInt(Year.format(starts)) + endYear;
                endMonth = Integer.parseInt(Month.format(starts)) + endMonth;
            }
            String endDate = endYear + "-" + String.format("%02d", endMonth) + "-" + String.format("%02d", endDay);
            return endDate;
        } else {
            return null;
        }
    }

    double subTotal() {
        int rowC = table_newitems.getRowCount();
        double Total = 0;
        if (rowC > 0) {
            for (int i = 0; i < rowC; i++) {
                Total += Double.parseDouble(table_newitems.getValueAt(i, 6).toString());
            }
        }
        return Total;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Check_newSup;
    private javax.swing.JPanel Panel_AddNewItems;
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_addItem;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_saveGRN;
    private javax.swing.JCheckBox check_discount;
    private javax.swing.JCheckBox check_warrantyPeriod;
    private javax.swing.JComboBox combo_discount;
    private javax.swing.JComboBox combo_period;
    public static javax.swing.JComboBox combo_suppID;
    private javax.swing.JLabel discount;
    public static javax.swing.JComboBox item_ID;
    private javax.swing.JLabel item_des;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Description;
    private javax.swing.JLabel lbl_ItemID;
    private javax.swing.JLabel lbl_Qty;
    private javax.swing.JLabel lbl_cost;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_supName;
    private javax.swing.JLabel lbl_supWebsite;
    private javax.swing.JLabel lbl_updatedCost;
    private javax.swing.JPanel panel_itemDetails;
    private javax.swing.JLabel progress_lable;
    public static javax.swing.JSpinner spin_qty;
    private javax.swing.JSpinner spin_warranty;
    private javax.swing.JTable table_newitems;
    private javax.swing.JLabel total_cost;
    private javax.swing.JFormattedTextField txt_itemCost;
    private javax.swing.JFormattedTextField txt_itemPrice;
    private javax.swing.JLabel updated_cost;
    // End of variables declaration//GEN-END:variables
}

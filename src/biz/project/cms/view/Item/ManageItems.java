/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.view.Item;

import biz.project.cms.controller.CategoryController;
import biz.project.cms.controller.ItemController;
import biz.project.cms.fileaccess.LoggerFileAcceess;
import biz.project.cms.model.BatchRest;
import biz.project.cms.model.Category;
import biz.project.cms.model.Item;
import biz.project.cms.other.SearchCombo;
import biz.project.cms.other.Validation;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vihanga
 */
public class ManageItems extends javax.swing.JDialog {

    private DefaultComboBoxModel boxModel = null;
    private DefaultComboBoxModel itBoxModel = null;
    private ArrayList<Category> allCategory = null;
    private String itemCode;
    private ArrayList<Item> allItem = null;
    private StringWriter sw;

    /**
     * Creates new form ManageItemss
     */
    public ManageItems(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        itemCode = "";
        sw = new StringWriter();
//
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        //
        boxModel = (DefaultComboBoxModel) cmbCategoryId.getModel();
        itBoxModel = (DefaultComboBoxModel) cmbType.getModel();
        loadItems();
        makeSearchable();
        loadCategorys();
        tblAllItem.setOpaque(true);
        tblAllItem.setFillsViewportHeight(true);
        tblAllItem.setBackground(Color.WHITE);
        tblBatch.setOpaque(true);
        tblBatch.setFillsViewportHeight(true);
        this.setIconImage(new ImageIcon(getClass().getResource("/image/Home/Logo Company.png")).getImage());
        tblBatch.setBackground(Color.WHITE);
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        lblType = new javax.swing.JLabel();
        cmbType = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllItem = new javax.swing.JTable();
        panelItemDetail = new javax.swing.JPanel();
        txtBarcode = new javax.swing.JTextField();
        lblBarcode = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtReOrderLevel = new javax.swing.JTextField();
        lblCategoryId = new javax.swing.JLabel();
        cmbCategoryId = new javax.swing.JComboBox<String>();
        btnUpdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBatch = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Item");

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        lblType.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblType.setText("Search :");

        cmbType.setEditable(true);
        cmbType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTypeItemStateChanged(evt);
            }
        });

        tblAllItem.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tblAllItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Barcode", "Description"
            }
        ));
        tblAllItem.setRowHeight(22);
        tblAllItem.setSelectionBackground(new java.awt.Color(0, 204, 153));
        tblAllItem.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAllItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAllItemMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblAllItemMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblAllItem);

        panelItemDetail.setBackground(new java.awt.Color(255, 255, 255));
        panelItemDetail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Waranty Info :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(102, 102, 255))); // NOI18N

        txtBarcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBarcode.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblBarcode.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBarcode.setText("Barcode :");

        txtDescription.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDescription.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblDescription.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescription.setText("Description :");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Reorder Level : ");

        txtReOrderLevel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtReOrderLevel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtReOrderLevel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReOrderLevelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReOrderLevelKeyTyped(evt);
            }
        });

        lblCategoryId.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCategoryId.setText("Category  :");

        cmbCategoryId.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        cmbCategoryId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoryIdItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelItemDetailLayout = new javax.swing.GroupLayout(panelItemDetail);
        panelItemDetail.setLayout(panelItemDetailLayout);
        panelItemDetailLayout.setHorizontalGroup(
            panelItemDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelItemDetailLayout.createSequentialGroup()
                .addGroup(panelItemDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelItemDetailLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelItemDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBarcode, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDescription, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelItemDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelItemDetailLayout.createSequentialGroup()
                                .addComponent(txtBarcode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtReOrderLevel))
                            .addComponent(txtDescription)))
                    .addGroup(panelItemDetailLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblCategoryId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelItemDetailLayout.setVerticalGroup(
            panelItemDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelItemDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelItemDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelItemDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelItemDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtReOrderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelItemDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBarcode)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelItemDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tblBatch.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tblBatch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Batch ID", "Batch QTY", "Cost Price", "Unit Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBatch.setRowHeight(22);
        tblBatch.setSelectionBackground(new java.awt.Color(0, 204, 153));
        tblBatch.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblBatch);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Current Batch Details");

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                                .addComponent(panelItemDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelMainLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2))
                                .addContainerGap())
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addGap(0, 54, Short.MAX_VALUE)
                                .addComponent(lblType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelItemDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAllItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAllItemMouseClicked

    }//GEN-LAST:event_tblAllItemMouseClicked

    private void cmbCategoryIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoryIdItemStateChanged
    }//GEN-LAST:event_cmbCategoryIdItemStateChanged

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (!txtBarcode.getText().isEmpty() && !txtDescription.getText().isEmpty() && !txtReOrderLevel.getText().isEmpty() && cmbCategoryId.getSelectedIndex() != -1) {
            try {
                Category c = CategoryController.searchCategoryByName(cmbCategoryId.getSelectedItem().toString());
                if (c != null) {
                    Item item = new Item(itemCode, txtBarcode.getText(), txtDescription.getText().toUpperCase(), c.getCatID(), Integer.parseInt(txtReOrderLevel.getText()));
                    boolean b = ItemController.updateItem(item);
                    if (b) {
                        JOptionPane.showMessageDialog(this, "Item successfully Updated !");
                        loadItems();
                        makeSearchable();
                        loadCategorys();
                    } else {
                        JOptionPane.showMessageDialog(this, "Update fail !");
                        txtBarcode.setText("");
                        txtDescription.setText("");
                        txtReOrderLevel.setText("");
                        cmbCategoryId.setSelectedIndex(-1);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Item category error !");
                }
            } catch (ClassNotFoundException | SQLException | NumberFormatException | HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                ex.printStackTrace(new PrintWriter(sw));
                String trace = sw.toString();
                LoggerFileAcceess.exceptionLogger(trace);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill all the fields!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cmbTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTypeItemStateChanged
        if (cmbType.getSelectedIndex() != -1) {
            String data[] = cmbType.getSelectedItem().toString().split(" | ");
            try {
                Item item = ItemController.searchItemBySerial(data[0]);
                DefaultTableModel model = (DefaultTableModel) tblBatch.getModel();
                if (item != null) {
                    itemCode = item.getCode();
                    txtBarcode.setText(item.getSerial());
                    txtDescription.setText(item.getDesciption());
                    txtReOrderLevel.setText(item.getRol() + "");
                    Category searchCategoryByID = CategoryController.searchCategoryByID(item.getCatId() + "");
                    boxModel.setSelectedItem(searchCategoryByID.getName());

                    ArrayList<BatchRest> batchRests = ItemController.getBatchRest(itemCode);
                    model.setRowCount(0);
                    for (BatchRest batchRest : batchRests) {
                        Object[] row = {batchRest.getBatchId(), batchRest.getCurrQTY(), batchRest.getCostPrice(), batchRest.getUnitPrice()};
                        model.addRow(row);
                    }

                } else {
                    model.setRowCount(0);
                    txtBarcode.setText("");
                    txtDescription.setText("");
                    txtReOrderLevel.setText("");
                    cmbCategoryId.setSelectedIndex(-1);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                ex.printStackTrace(new PrintWriter(sw));
                String trace = sw.toString();
                LoggerFileAcceess.exceptionLogger(trace);
            }
        }
    }//GEN-LAST:event_cmbTypeItemStateChanged

    private void tblAllItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAllItemMouseReleased
        if (tblAllItem.getSelectedRow() != -1) {
            DefaultTableModel dtm = (DefaultTableModel) tblAllItem.getModel();
            for (int i = 0; i < cmbType.getItemCount(); i++) {
                String data[] = cmbType.getItemAt(i).split(" | ");
                if (data[0].equals(dtm.getValueAt(tblAllItem.getSelectedRow(), 1).toString())) {
                    cmbType.setSelectedIndex(i);
                    break;
                }
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tblAllItemMouseReleased

    private void txtReOrderLevelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReOrderLevelKeyReleased
        Validation.limitesIntegers(txtReOrderLevel, 4);
    }//GEN-LAST:event_txtReOrderLevelKeyReleased

    private void txtReOrderLevelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReOrderLevelKeyTyped
        Validation.limitesIntegers(txtReOrderLevel, 4);
    }//GEN-LAST:event_txtReOrderLevelKeyTyped

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
            java.util.logging.Logger.getLogger(ManageItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManageItems dialog = new ManageItems(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbCategoryId;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JLabel lblCategoryId;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblType;
    private javax.swing.JPanel panelItemDetail;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTable tblAllItem;
    private javax.swing.JTable tblBatch;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtReOrderLevel;
    // End of variables declaration//GEN-END:variables

    private void loadItems() {
        DefaultTableModel dtm = (DefaultTableModel) tblAllItem.getModel();
        dtm.setRowCount(0);
        try {
            allItem = ItemController.getAllItem();
            itBoxModel.removeAllElements();
            for (Item item : allItem) {
                Object[] rowData = {item.getCode(), item.getSerial(), item.getDesciption()};
                dtm.addRow(rowData);
                itBoxModel.addElement(item.getSerial() + " | " + item.getDesciption() + " | " + item.getCode());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            ex.printStackTrace(new PrintWriter(sw));
            String trace = sw.toString();
            LoggerFileAcceess.exceptionLogger(trace);
        }
    }

    private void makeSearchable() {
        SearchCombo searchCombo = new SearchCombo();
        searchCombo.setSearchableCombo(cmbType, true, "No Item Found !", false);
    }

    private void loadCategorys() {

        try {
            allCategory = CategoryController.getAllCategory();
            boxModel.removeAllElements();
            for (Category category : allCategory) {
                boxModel.addElement(category.getName());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            ex.printStackTrace(new PrintWriter(sw));
            String trace = sw.toString();
            LoggerFileAcceess.exceptionLogger(trace);
        }
    }

}
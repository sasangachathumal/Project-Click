/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.view.Item;

import biz.project.cms.controller.AccountsController;
import biz.project.cms.controller.BatchController;
import biz.project.cms.controller.DamageController;
import biz.project.cms.controller.DealerSerialController;
import biz.project.cms.controller.ItemController;
import biz.project.cms.fileaccess.LoggerFileAcceess;
import biz.project.cms.model.Accounts;
import biz.project.cms.model.Batch;
import biz.project.cms.model.Damage;
import biz.project.cms.model.DealerSerial;
import biz.project.cms.model.Item;
import biz.project.cms.other.Validation;
import biz.project.cms.view.main.HomeFrame;
import java.awt.Color;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Kisal Suranjaya
 */
public class DamageItem extends javax.swing.JDialog {

    private StringWriter sw;
    private int qOH;

    /**
     * Creates new form DamageItem
     */
    public DamageItem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        //
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/image/Home/Logo Company.png")).getImage());
        sw = new StringWriter();
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
        lblItemCode = new javax.swing.JLabel();
        txtItemId = new javax.swing.JTextField();
        lblItemCode1 = new javax.swing.JLabel();
        lblItemCode2 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        lblItemCode4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReason = new javax.swing.JTextArea();
        comboBatch = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        comboSerails = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Damage Items");
        setResizable(false);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        lblItemCode.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblItemCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblItemCode.setText("Code / Barcode :");

        txtItemId.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtItemId.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtItemId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemIdActionPerformed(evt);
            }
        });

        lblItemCode1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblItemCode1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblItemCode1.setText("Batch Id :");

        lblItemCode2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblItemCode2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblItemCode2.setText("Qty :");

        txtQty.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtQty.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtyKeyTyped(evt);
            }
        });

        lblItemCode4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblItemCode4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblItemCode4.setText("Reason :");

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtReason.setColumns(20);
        txtReason.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        txtReason.setLineWrap(true);
        txtReason.setRows(5);
        txtReason.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtReason);

        comboBatch.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboBatch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Found Batch ID" }));
        comboBatch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBatchItemStateChanged(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("S/N :");

        comboSerails.setEditable(true);
        comboSerails.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboSerails.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSerails.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSerailsItemStateChanged(evt);
            }
        });
        comboSerails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSerailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblItemCode1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblItemCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblItemCode2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblItemCode4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtQty, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBatch, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtItemId, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboSerails, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemCode)
                    .addComponent(txtItemId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemCode1)
                    .addComponent(comboBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSerails, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemCode2)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblItemCode4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addDamageItem();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtItemIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemIdActionPerformed
        searchItem();
    }//GEN-LAST:event_txtItemIdActionPerformed

    private void comboSerailsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSerailsItemStateChanged
        if (comboSerails.getSelectedIndex() != -1) {
            if (comboSerails.getSelectedItem().toString().equals("SERIAL NOT FOUND !")) {
                txtQty.requestFocus();
                txtQty.setText("");
                txtQty.setEnabled(true);
            } else {
                txtReason.requestFocus();
                txtQty.setText("");
                txtQty.setEnabled(false);
            }
        }
    }//GEN-LAST:event_comboSerailsItemStateChanged

    private void comboSerailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSerailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSerailsActionPerformed

    private void comboBatchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBatchItemStateChanged
        if (comboBatch.getSelectedIndex() != -1) {
            String[] split = comboBatch.getSelectedItem().toString().split("BT00");
            try {
                Batch batch = BatchController.searchBatch(split[1]);
                if (batch != null) {
                    qOH = batch.getQty();
                    setSerialNumbers(split[1]);
                } else {
                    JOptionPane.showMessageDialog(this, "No batch found for this item !\nPlease add GRN properly.");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                ex.printStackTrace(new PrintWriter(sw));
                String trace = sw.toString();
                LoggerFileAcceess.exceptionLogger(trace);
            }
        }
    }//GEN-LAST:event_comboBatchItemStateChanged

    private void txtQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyReleased
        Validation.limitesIntegers(txtQty, 4);
    }//GEN-LAST:event_txtQtyKeyReleased

    private void txtQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyTyped
        Validation.limitesIntegers(txtQty, 4);
    }//GEN-LAST:event_txtQtyKeyTyped

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
            java.util.logging.Logger.getLogger(DamageItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DamageItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DamageItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DamageItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DamageItem dialog = new DamageItem(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox comboBatch;
    private javax.swing.JComboBox comboSerails;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblItemCode;
    private javax.swing.JLabel lblItemCode1;
    private javax.swing.JLabel lblItemCode2;
    private javax.swing.JLabel lblItemCode4;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTextField txtItemId;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextArea txtReason;
    // End of variables declaration//GEN-END:variables

    private void addDamageItem() {
        if (txtItemId.getText() != null && comboBatch.getSelectedIndex() != -1) {

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = dateFormat.format(date);
            String sn = null;
            String reason = "NO REASON !";
            String qty = "1";
            String[] split = comboBatch.getSelectedItem().toString().split("BT00");
            if (!comboSerails.getSelectedItem().toString().equals("SERIAL NOT FOUND !")) {
                sn = comboSerails.getSelectedItem().toString();
            } else {
                qty = txtQty.getText();
            }
            if (!txtReason.getText().isEmpty()) {
                reason = txtReason.getText();
            }
            if (Integer.parseInt(qty) <= qOH) {
                try {
                    Batch batch = BatchController.searchBatch(split[1]);
                    Damage damage = new Damage(0, Integer.parseInt(qty), reason, Integer.parseInt(split[1]), format);

                    if (batch != null) {
                        double tot = Integer.parseInt(qty) * batch.getCostPrice();
                        AccountsController.addAccount(new Accounts(0, HomeFrame.user.getUid(), "", "", 3, "Damage Item", -tot));
                    }
                    String added = DamageController.addDamageItem(damage, sn);
                    if (added.equals("1")) {
                        JOptionPane.showMessageDialog(this, "Item added as a damage item...!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Item cannot be added!");
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                    ex.printStackTrace(new PrintWriter(sw));
                    String trace = sw.toString();
                    LoggerFileAcceess.exceptionLogger(trace);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sorry! Inserted qty exceeds the batch qty on hand.\nQty On Hand - " + qOH);
                txtQty.removeFocusListener(null);
                txtQty.selectAll();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please Fill Text Fields...");
        }
    }

    private void searchItem() {
        if (!txtItemId.getText().isEmpty()) {
            Item item;
            try {
                item = ItemController.searchIstemByCode(txtItemId.getText());
                if (item == null) {
                    item = ItemController.searchItemBySerial(txtItemId.getText());
                }
                if (item != null) {
                    ArrayList<Batch> batches = BatchController.searchBatchByItemCode(item.getCode());
                    if (!batches.isEmpty()) {
                        comboBatch.removeAllItems();
                        for (Batch batch : batches) {
                            comboBatch.addItem("BT00" + batch.getBatchId());
                        }
                    }
                } else {
                    comboBatch.removeAllItems();
                    JOptionPane.showMessageDialog(this, "Item not found !");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                ex.printStackTrace(new PrintWriter(sw));
                String trace = sw.toString();
                LoggerFileAcceess.exceptionLogger(trace);
            }
        }
    }

    private void setSerialNumbers(String bid) {
        if (bid != null) {
            try {
                ArrayList<DealerSerial> serials = DealerSerialController.getAllDealerSerialByBatch(bid);
                if (!serials.isEmpty()) {
                    comboSerails.removeAllItems();
                    for (DealerSerial serial : serials) {
                        comboSerails.addItem(serial.getSerial());
                    }
                } else {
                    comboSerails.removeAllItems();
                    comboSerails.addItem("SERIAL NOT FOUND !");
                    txtQty.setText("");
                    txtReason.setText("");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
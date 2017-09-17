/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.view.grn;

import biz.project.cms.model.DealerSerial;
import biz.project.cms.model.TempSerial;
import biz.project.cms.other.SearchCombo;
import biz.project.cms.other.Validation;
import biz.project.cms.view.order.MakeCustomerOrder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vihanga
 */
public class AddWarranty extends javax.swing.JDialog {

    private String bID;
    private HashMap<String, ArrayList<TempSerial>> hashMap;
    private final DefaultTableModel dtm;
    private ArrayList<TempSerial> serialList;
    private int itemCount;
    private ArrayList<DealerSerial> serials;
    private final MakeCustomerOrder pOS;
    private String period1;
    private String bid;

    /**
     * Creates new form AddWarranty
     *
     * @param parent
     * @param modal
     * @param mco
     */
    public AddWarranty(javax.swing.JFrame parent, boolean modal, MakeCustomerOrder mco) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/image/Home/Logo Company.png")).getImage());
        //
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        //
        pOS = mco;
        setLocationRelativeTo(parent);
        setTitle("Set Warranty");
        dtm = (DefaultTableModel) tableSerial.getModel();
        serialList = new ArrayList<>();
        period1 = "0";
        tableSerial.setOpaque(true);
        tableSerial.setFillsViewportHeight(true);
        tableSerial.setBackground(Color.WHITE);
    }

    public void setTitle(String code, String qty, ArrayList<DealerSerial> serials, String bid) {
        setTitle(code + "  -  " + qty);
        this.serials = serials;
        setCombo(this.serials);
        this.bid = bid;
    }

    public void setItemCount(int count) {
        this.itemCount = count;
    }

    public void setDetail(String batchID) {
        bID = batchID;
    }

    public void setMap(HashMap<String, ArrayList<TempSerial>> hashMap) {
        this.hashMap = hashMap;
        if (hashMap.containsKey(bID)) {
            serialList = hashMap.get(bID);
            for (TempSerial serialList1 : hashMap.get(bID)) {
                Object row[] = {serialList1.getSerial(), serialList1.getPeriod(), serialList1.getTag1(), serialList1.getTag2()};
                dtm.addRow(row);
                period1 = serialList1.getPeriod() + "";
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtPeriod = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        rbtnDay = new javax.swing.JRadioButton();
        rbtnYears = new javax.swing.JRadioButton();
        rbtnMonths = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        txtTag2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtTag1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        comboSN = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableSerial = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Warrenty");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(252, 252, 252));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Warranty", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(102, 102, 255))); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(340, 103));

        txtPeriod.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPeriod.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPeriod.setCaretColor(new java.awt.Color(116, 7, 7));
        txtPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeriodActionPerformed(evt);
            }
        });
        txtPeriod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPeriodKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPeriodKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("Period :");

        rbtnDay.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnDay);
        rbtnDay.setSelected(true);
        rbtnDay.setText("Days");

        rbtnYears.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnYears);
        rbtnYears.setText("Years");

        rbtnMonths.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbtnMonths);
        rbtnMonths.setText("Months");
        rbtnMonths.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnMonthsItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(rbtnDay)
                        .addGap(59, 59, 59)
                        .addComponent(rbtnMonths)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbtnYears))
                    .addComponent(txtPeriod))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnDay)
                    .addComponent(rbtnMonths)
                    .addComponent(rbtnYears))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Serial IDs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(102, 102, 255))); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(340, 70));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTag2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTag2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTag2.setCaretColor(new java.awt.Color(116, 7, 7));
        txtTag2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTag2ActionPerformed(evt);
            }
        });
        txtTag2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTag2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTag2KeyTyped(evt);
            }
        });
        jPanel8.add(txtTag2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 101, 30));

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setText("Tag 2 :");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 66, -1, 40));

        txtTag1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTag1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTag1.setCaretColor(new java.awt.Color(116, 7, 7));
        txtTag1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTag1ActionPerformed(evt);
            }
        });
        txtTag1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTag1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTag1KeyTyped(evt);
            }
        });
        jPanel8.add(txtTag1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 106, 30));

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setText("Tag 1 :");
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 40));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("S/N :");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 60, 30));

        comboSN.setEditable(true);
        comboSN.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        comboSN.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboSN.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSNItemStateChanged(evt);
            }
        });
        comboSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSNActionPerformed(evt);
            }
        });
        jPanel8.add(comboSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 290, -1));

        tableSerial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "Period", "Tag 1", "Tag 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSerial.setSelectionBackground(new java.awt.Color(0, 102, 255));
        tableSerial.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableSerial.getTableHeader().setReorderingAllowed(false);
        tableSerial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableSerialKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tableSerial);
        if (tableSerial.getColumnModel().getColumnCount() > 0) {
            tableSerial.getColumnModel().getColumn(0).setResizable(false);
            tableSerial.getColumnModel().getColumn(1).setResizable(false);
            tableSerial.getColumnModel().getColumn(2).setResizable(false);
            tableSerial.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(41, 1));

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTag2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTag2ActionPerformed
        if (tableSerial.getRowCount() < itemCount) {
            if (!txtPeriod.getText().isEmpty() && comboSN.getSelectedIndex() != -1) {
                boolean has = false;
                if (tableSerial.getRowCount() > 0) {
                    for (int i = 0; i < tableSerial.getRowCount(); i++) {
                        if (dtm.getValueAt(i, 0).toString().equals(comboSN.getSelectedItem().toString())) {
                            has = true;
                            break;
                        }
                    }
                }
                if (!has) {
                    int period = Integer.parseInt(txtPeriod.getText());
                    String tag1 = txtTag1.getText();
                    String tag2 = txtTag2.getText();
                    if (rbtnMonths.isSelected()) {
                        period *= 30;
                    }
                    if (rbtnYears.isSelected()) {
                        period *= 365;
                    }
                    if (txtTag1.getText().isEmpty()) {
                        tag1 = "0";
                    }
                    if (txtTag2.getText().isEmpty()) {
                        tag2 = "0";
                    }
                    Object row[] = {comboSN.getSelectedItem().toString(), period, tag1, tag2};
                    boolean contains = false;
                    period1 = period + "";
                    for (DealerSerial serial : serials) {
                        if (serial.getSerial().equals(comboSN.getSelectedItem().toString())) {
                            contains = true;
                        }
                    }
                    if (contains) {
                        dtm.addRow(row);
                    } else {
                        Toolkit.getDefaultToolkit().beep();
                        try {
                            Thread.sleep(500);
                            Toolkit.getDefaultToolkit().beep();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AddWarranty.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    serialList.add(new TempSerial(comboSN.getSelectedItem().toString(),
                            period, tag1, tag2));
                    comboSN.requestFocus();
                    txtTag1.setText("");
                    txtTag2.setText("");
                } else {
                    JOptionPane.showMessageDialog(pOS, "Selected serial is already added !");
                }
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Maximum item count reached !");
        }
    }//GEN-LAST:event_txtTag2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (!serialList.isEmpty()) {
            pOS.setSerials(bID, serialList, period1);
        } else {
            pOS.setSerials(bID, serialList, "-");
        }
    }//GEN-LAST:event_formWindowClosing

    private void txtTag1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTag1ActionPerformed
        if (!txtTag1.getText().isEmpty()) {
            txtTag2.requestFocus();
        }
    }//GEN-LAST:event_txtTag1ActionPerformed

    private void txtPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeriodActionPerformed
        if (!txtPeriod.getText().isEmpty()) {
            comboSN.requestFocus();
        }
    }//GEN-LAST:event_txtPeriodActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (!serialList.isEmpty()) {
            pOS.setSerials(bID, serialList, period1);
        }
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void comboSNItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSNItemStateChanged

    }//GEN-LAST:event_comboSNItemStateChanged

    private void comboSNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSNActionPerformed

    private void rbtnMonthsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnMonthsItemStateChanged

    }//GEN-LAST:event_rbtnMonthsItemStateChanged

    private void tableSerialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableSerialKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            TempSerial ts = new TempSerial(dtm.getValueAt(tableSerial.getSelectedRow(), 0).toString(), Integer.parseInt(dtm.getValueAt(tableSerial.getSelectedRow(), 1).toString()), dtm.getValueAt(tableSerial.getSelectedRow(), 2).toString(), dtm.getValueAt(tableSerial.getSelectedRow(), 3).toString());
            TempSerial t = new TempSerial();
            for (TempSerial serialList1 : serialList) {
                if (serialList1.getSerial().equals(ts.getSerial())) {
                    t = serialList1;
                    break;
                }
            }
            if (serialList.remove(t)) {
                dtm.removeRow(tableSerial.getSelectedRow());
            }
        }
    }//GEN-LAST:event_tableSerialKeyReleased

    private void txtPeriodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPeriodKeyReleased
        Validation.limitesIntegers(txtPeriod, 5);              // TODO add your handling code here:
    }//GEN-LAST:event_txtPeriodKeyReleased

    private void txtPeriodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPeriodKeyTyped
        Validation.limitesIntegers(txtPeriod, 5);         // TODO add your handling code here:
    }//GEN-LAST:event_txtPeriodKeyTyped

    private void txtTag1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTag1KeyReleased
        Validation.limitesIntegers(txtTag1, 10);
    }//GEN-LAST:event_txtTag1KeyReleased

    private void txtTag1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTag1KeyTyped
        Validation.limitesIntegers(txtTag1, 10);   // TODO add your handling code here:
    }//GEN-LAST:event_txtTag1KeyTyped

    private void txtTag2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTag2KeyReleased
        Validation.limitesIntegers(txtTag2, 10);         // TODO add your handling code here:
    }//GEN-LAST:event_txtTag2KeyReleased

    private void txtTag2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTag2KeyTyped
        Validation.limitesIntegers(txtTag2, 10);         // TODO add your handling code here:
    }//GEN-LAST:event_txtTag2KeyTyped

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
            java.util.logging.Logger.getLogger(AddWarranty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddWarranty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddWarranty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddWarranty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddWarranty dialog = new AddWarranty(new javax.swing.JFrame(), true, null);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboSN;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbtnDay;
    private javax.swing.JRadioButton rbtnMonths;
    private javax.swing.JRadioButton rbtnYears;
    private javax.swing.JTable tableSerial;
    private javax.swing.JTextField txtPeriod;
    private javax.swing.JTextField txtTag1;
    private javax.swing.JTextField txtTag2;
    // End of variables declaration//GEN-END:variables

    private void setCombo(ArrayList<DealerSerial> serials) {
        comboSN.removeAllItems();
        for (DealerSerial serial : serials) {
            comboSN.addItem(serial.getSerial());
        }
        SearchCombo combo = new SearchCombo();
        combo.setSearchableCombo(comboSN, true, "Not found in batch " + bID, true);
    }
}
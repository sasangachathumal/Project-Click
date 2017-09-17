/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.view.customer;

import biz.project.cms.controller.CustomerChequeController;
import biz.project.cms.controller.JobChequeController;
import biz.project.cms.model.ChequPayentDefference;
import biz.project.cms.model.CustomerCheque;
import biz.project.cms.model.JobCheque;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Arty
 */
public class CustomerCheques extends javax.swing.JDialog {

    /**
     * Creates new form CustomerCheques
     */
    private ArrayList<ChequPayentDefference> List = new ArrayList<>();
    private ArrayList<ChequPayentDefference> List2 = new ArrayList<>();
    private ArrayList<ChequPayentDefference> loadAlldata = new ArrayList<>();
    private ArrayList<ChequPayentDefference> loadAlldata2 = new ArrayList<>();
    private ArrayList<Integer> j = new ArrayList<>();
    private DefaultTableModel model1;
    //private Date from;
    //private Date to;

    public CustomerCheques(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        //
        setLocationRelativeTo(null);
        model1 = (DefaultTableModel) tableCheue.getModel();
//        model2 = (DefaultTableModel) tableOrderDetail.getModel();
        this.setIconImage(new ImageIcon(getClass().getResource("/image/Home/Logo Company.png")).getImage());
        //LoadCheque();
        setLocationRelativeTo(parent);
        setTitle("Customer Cheques");
        Color white = new Color(255, 255, 255);
        tableCheue.setOpaque(true);
        tableCheue.setFillsViewportHeight(true);
        tableCheue.setBackground(white);
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
        datePicFrom = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        datePicTo = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCheue = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        All = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Cheque");
        setResizable(false);

        panelMain.setBackground(new java.awt.Color(255, 255, 255));

        datePicFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePicFromActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("From :");

        datePicTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePicToActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("To :");

        tableCheue.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tableCheue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cheque No", "Bank", "Amount", "Pay ID", "Plu "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCheue.setRowHeight(22);
        tableCheue.setSelectionBackground(new java.awt.Color(0, 204, 153));
        tableCheue.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableCheue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableCheueMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableCheue);
        if (tableCheue.getColumnModel().getColumnCount() > 0) {
            tableCheue.getColumnModel().getColumn(0).setResizable(false);
            tableCheue.getColumnModel().getColumn(1).setResizable(false);
            tableCheue.getColumnModel().getColumn(2).setResizable(false);
            tableCheue.getColumnModel().getColumn(3).setResizable(false);
        }

        jCheckBox1.setText(" Order Cheque");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText(" Job Cheque");
        jCheckBox2.setOpaque(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        All.setText("All");
        All.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(datePicFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(datePicTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(All, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 237, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(datePicFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jCheckBox1))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(datePicTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2)
                    .addComponent(All, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableCheueMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCheueMouseReleased
        //   loadSelectedChque();
    }//GEN-LAST:event_tableCheueMouseReleased

    private void datePicToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePicToActionPerformed
//        model1.setRowCount(0);
//        loadDateFromCheque();
//        load2DateFromCheque();
    }//GEN-LAST:event_datePicToActionPerformed

    private void datePicFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePicFromActionPerformed
//        model1.setRowCount(0);
//        loadDateFromCheque();
//        load2DateFromCheque();
    }//GEN-LAST:event_datePicFromActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jCheckBox1.isSelected()) {
            if (jCheckBox2.isSelected()) {
                model1.setRowCount(0);
                loadDateFromCheque();
                load2DateFromCheque();
            } else {
                model1.setRowCount(0);
                loadDateFromCheque();
            }
        } else if (jCheckBox2.isSelected()) {
            if (jCheckBox1.isSelected()) {
                model1.setRowCount(0);
                loadDateFromCheque();
                load2DateFromCheque();
            } else {
                model1.setRowCount(0);
                load2DateFromCheque();
            }
        } else {
            model1.setRowCount(0);
            loadDateFromCheque();
            load2DateFromCheque();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void AllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllActionPerformed
        if (jCheckBox1.isSelected()) {
            if (jCheckBox2.isSelected()) {
                model1.setRowCount(0);
                LoadAllData();
                LoadAllData2();
            } else {
                model1.setRowCount(0);
                LoadAllData();
            }
        } else if (jCheckBox2.isSelected()) {
            if (jCheckBox1.isSelected()) {
                model1.setRowCount(0);
                LoadAllData();
                LoadAllData2();
            } else {
                model1.setRowCount(0);
                LoadAllData2();
            }
        }
    }//GEN-LAST:event_AllActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerCheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerCheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerCheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerCheques.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomerCheques dialog = new CustomerCheques(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton All;
    private org.jdesktop.swingx.JXDatePicker datePicFrom;
    private org.jdesktop.swingx.JXDatePicker datePicTo;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTable tableCheue;
    // End of variables declaration//GEN-END:variables

    private void cleancomponents() {
//        txtOrderID.setText("");
//        txtDate.setText("");
//        txtTime.setText("");
//        txtTotal.setText("");
        model1.setRowCount(0);
    }

    private void loadDateFromCheque() {

        java.sql.Date from = new java.sql.Date(datePicFrom.getDate().getTime());
        java.sql.Date to = new java.sql.Date(datePicTo.getDate().getTime());

        int daysdiff = 0;
        long diff = to.getTime() - from.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
        daysdiff = (int) diffDays;

        try {
            if (daysdiff <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Please enter a valid date");
            } else {
                List.clear();
                List = CustomerChequeController.getDateDeffirence(from, to);
                String cheqArray = List + "";
                if (!"[]".equals(cheqArray)) {
                    for (int i = 0; i < List.size(); i++) {
                        model1.addRow(new Object[]{List.get(i).getChqNo(), List.get(i).getBank(), List.get(i).getAmount(), List.get(i).getCusPyID(), List.get(i).getOid()});
                    }
                } else {
                    //JOptionPane.showMessageDialog(rootPane, "No Oredrs in CustomerCheq this Period");
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerChequeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void load2DateFromCheque() {
        java.sql.Date from = new java.sql.Date(datePicFrom.getDate().getTime());
        java.sql.Date to = new java.sql.Date(datePicTo.getDate().getTime());

        int daysdiff = 0;
        long diff = to.getTime() - from.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
        daysdiff = (int) diffDays;

        try {
            if (daysdiff <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Please enter a valid date");
            } else {
                List2.clear();
                List2 = JobChequeController.getDateDeffirence(from, to);
                String cheqArray = List2 + "";
                if (!"[]".equals(cheqArray)) {
                    for (int i = 0; i < List2.size(); i++) {
                        model1.addRow(new Object[]{List2.get(i).getChqNo(), List2.get(i).getBank(), List2.get(i).getAmount(), List2.get(i).getCusPyID(), List2.get(i).getOid()});
                    }
                } else {
                    //JOptionPane.showMessageDialog(rootPane, "No Oredrs in JobCheq this Period");
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerChequeController.class.getName()).log(Level.SEVERE, null, ex);;
        }

    }

    private void LoadAllData() {
        loadAlldata.clear();
        loadAlldata = CustomerChequeController.getAllCusCheqData();
        String cheqArray = loadAlldata + "";
        if (!"[]".equals(cheqArray)) {
            for (int i = 0; i < loadAlldata.size(); i++) {
                model1.addRow(new Object[]{loadAlldata.get(i).getChqNo(), loadAlldata.get(i).getBank(), loadAlldata.get(i).getAmount(), loadAlldata.get(i).getCusPyID(), loadAlldata.get(i).getOid()});
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No Oredrs in JobCheq this Period");
        }
    }

    private void LoadAllData2() {
        loadAlldata2.clear();
        loadAlldata2 = JobChequeController.getAllJobData();
        String cheqArray = loadAlldata2 + "";
        if (!"[]".equals(cheqArray)) {
            for (int i = 0; i < loadAlldata2.size(); i++) {
                model1.addRow(new Object[]{loadAlldata2.get(i).getChqNo(), loadAlldata2.get(i).getBank(), loadAlldata2.get(i).getAmount(), loadAlldata2.get(i).getCusPyID(), loadAlldata2.get(i).getOid()});
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No Oredrs in JobCheq this Period");
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.view.Jobs;

import biz.project.cms.model.JobCheque;
import biz.project.cms.other.Validation;
import java.awt.Color;
import java.sql.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Dilhan Mendis
 */
public class AddedChequeDetails extends javax.swing.JDialog {

    private String jobpayId;

    /**
     * Creates new form AddedChequeDetails
     */
    public AddedChequeDetails(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        //
    }

    AddedChequeDetails(java.awt.Frame parent, boolean modal, String jobPayID, int i) {
        super(parent, modal);
        initComponents();
        //
        UIManager UI = new UIManager();
        this.setIconImage(new ImageIcon(getClass().getResource("/image/Home/Logo Company.png")).getImage());
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        //
        this.jobpayId = jobPayID;
        if (i == 1) {
            txtChequeNo.setText(CreateNewJob.cheque.getChqNo());
            datePickerChequeDate.setDate(Date.valueOf(CreateNewJob.cheque.getChqDate()));
            cmbBankName.setSelectedItem(CreateNewJob.cheque.getBank());
            jobpayId = CreateNewJob.cheque.getJobPayID();
        }
        setLocationRelativeTo(parent);
        setTitle("Cheques");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblChequeNumber = new javax.swing.JLabel();
        lblChequeDate = new javax.swing.JLabel();
        lblbankName = new javax.swing.JLabel();
        txtChequeNo = new javax.swing.JTextField();
        datePickerChequeDate = new org.jdesktop.swingx.JXDatePicker();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cmbBankName = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblChequeNumber.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblChequeNumber.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblChequeNumber.setText("Cheque No  :");

        lblChequeDate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblChequeDate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblChequeDate.setText("Cheque Date :");

        lblbankName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblbankName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblbankName.setText("Bank  :");

        txtChequeNo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtChequeNo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtChequeNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtChequeNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtChequeNoKeyTyped(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cmbBankName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sampath Bank", "Commercial Bank", "Nation's Trust Bank", "BOC", "People's Bank", "DFCC Bank", "Pan Asia Bank", "Seylan Bank", "Other" }));
        cmbBankName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBankNameActionPerformed(evt);
            }
        });
        cmbBankName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbBankNameKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblChequeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtChequeNo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblChequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(datePickerChequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblbankName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChequeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChequeNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(datePickerChequeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbankName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cmbBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 190));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        getChequeDetails();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtChequeNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChequeNoKeyReleased
        Validation.numberOnly(txtChequeNo);
    }//GEN-LAST:event_txtChequeNoKeyReleased

    private void txtChequeNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChequeNoKeyTyped
        Validation.numberOnly(txtChequeNo);
    }//GEN-LAST:event_txtChequeNoKeyTyped

    private void cmbBankNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBankNameActionPerformed

    }//GEN-LAST:event_cmbBankNameActionPerformed

    private void cmbBankNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbBankNameKeyPressed

    }//GEN-LAST:event_cmbBankNameKeyPressed

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
            java.util.logging.Logger.getLogger(AddedChequeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddedChequeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddedChequeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddedChequeDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddedChequeDetails dialog = new AddedChequeDetails(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox cmbBankName;
    private org.jdesktop.swingx.JXDatePicker datePickerChequeDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblChequeDate;
    private javax.swing.JLabel lblChequeNumber;
    private javax.swing.JLabel lblbankName;
    private javax.swing.JTextField txtChequeNo;
    // End of variables declaration//GEN-END:variables

    private void getChequeDetails() {
        String chqNo = txtChequeNo.getText();
        Date date = new Date(datePickerChequeDate.getDate().getTime());
        String bank = cmbBankName.getSelectedItem()+"";
        if (!chqNo.equals("")) {
            if (!bank.equals("")) {
                CreateNewJob.cheque = new JobCheque(chqNo, date + "", bank, jobpayId);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please Enter bank No...", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please Enter Cheque No...", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.view.accounts;

import biz.project.cms.controller.AccountsController;
import biz.project.cms.fileaccess.LoggerFileAcceess;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Amila(Polta)
 */
public class ViewProfit extends javax.swing.JDialog {

    private Date from = null;
    private Date to = null;

    /**
     * Creates new form ViewIncome
     */
    public ViewProfit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();//
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        //
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dateFrom.setFormats(sdf);
        dateFrom.requestFocus();
        dateTo.setFormats(sdf);
        setLocationRelativeTo(parent);
        setTitle("Accounts");
        loadIncomeToday();
        this.setIconImage(new ImageIcon(getClass().getResource("/image/Home/Logo Company.png")).getImage());
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
        jLabel1 = new javax.swing.JLabel();
        dateFrom = new org.jdesktop.swingx.JXDatePicker();
        dateTo = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblIncome = new javax.swing.JLabel();
        lblExpences = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDamage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblProfit = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Profit");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("From :");

        dateFrom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        dateFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFromActionPerformed(evt);
            }
        });
        dateFrom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dateFromKeyPressed(evt);
            }
        });

        dateTo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        dateTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateToActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("To :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Income :");

        lblIncome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblIncome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblExpences.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblExpences.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Expences :");

        lblDamage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDamage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Damage Item :");

        lblProfit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblProfit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Profit :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(dateTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(lblExpences, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDamage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProfit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblExpences, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDamage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(lblProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFromActionPerformed
        loadIncomeOne();
    }//GEN-LAST:event_dateFromActionPerformed

    private void dateToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateToActionPerformed
        loadIncomeFromTo();
    }//GEN-LAST:event_dateToActionPerformed

    private void dateFromKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateFromKeyPressed
        setNextfocus(evt);
    }//GEN-LAST:event_dateFromKeyPressed

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
            java.util.logging.Logger.getLogger(ViewProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewProfit dialog = new ViewProfit(new javax.swing.JFrame(), true);
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
    private org.jdesktop.swingx.JXDatePicker dateFrom;
    private org.jdesktop.swingx.JXDatePicker dateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDamage;
    private javax.swing.JLabel lblExpences;
    private javax.swing.JLabel lblIncome;
    private javax.swing.JLabel lblProfit;
    // End of variables declaration//GEN-END:variables

    private void loadIncomeOne() {
        from = dateFrom.getDate();
        to = dateTo.getDate();
        if (!from.equals(to)) {
            dateTo.setDate(from);
            String date = new SimpleDateFormat("yyyy-MM-dd").format(from);
            try {
                double income = AccountsController.getDayIncome(date);
                double dayExpences = AccountsController.getDayExpences(date);
                double damage = AccountsController.getDamageItemValue(date);
                lblExpences.setText(dayExpences + "");
                lblIncome.setText(income + "");
                lblDamage.setText(damage + "");
                lblProfit.setText(income + dayExpences + damage + "");
            } catch (ClassNotFoundException | SQLException ex) {
                StringWriter sw = new StringWriter();
                JOptionPane.showMessageDialog(this, ex.getMessage());
                ex.printStackTrace(new PrintWriter(sw));
                String trace = sw.toString();
                LoggerFileAcceess.exceptionLogger(trace);
            }
        }
    }

    private void loadIncomeFromTo() {
        from = dateFrom.getDate();
        to = dateTo.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if (Integer.parseInt(sdf.format(from)) <= Integer.parseInt(sdf.format(to))) {
            if (!from.equals(to)) {
                String date1 = new SimpleDateFormat("yyyy-MM-dd").format(from);
                String date2 = new SimpleDateFormat("yyyy-MM-dd").format(to);
                try {
                    double income = AccountsController.getFromToIncome(date1, date2);
                    double fromToExpences = AccountsController.getFromToExpences(date1, date2);
                    double damage = AccountsController.getDamegeFromTo(date1, date2);
                    lblExpences.setText(fromToExpences + "");
                    lblIncome.setText(income + "");
                    lblDamage.setText(damage + "");
                    lblProfit.setText(income + fromToExpences + damage + "");
                } catch (ClassNotFoundException | SQLException ex) {
                    StringWriter sw = new StringWriter();
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                    ex.printStackTrace(new PrintWriter(sw));
                    String trace = sw.toString();
                    LoggerFileAcceess.exceptionLogger(trace);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid date range");
        }
    }

    private void loadIncomeToday() {
        from = dateFrom.getDate();
        to = dateTo.getDate();

        dateTo.setDate(from);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(from);
        try {
            double income = AccountsController.getDayIncome(date);
            double dayExpences = AccountsController.getDayExpences(date);
            double damage = AccountsController.getDamageItemValue(date);
            lblExpences.setText(dayExpences + "");
            lblIncome.setText(income + "");
            lblDamage.setText(damage + "");
            lblProfit.setText(income + dayExpences + damage + "");
        } catch (ClassNotFoundException | SQLException ex) {
            StringWriter sw = new StringWriter();
            JOptionPane.showMessageDialog(this, ex.getMessage());
            ex.printStackTrace(new PrintWriter(sw));
            String trace = sw.toString();
            LoggerFileAcceess.exceptionLogger(trace);
        }

    }
    
    private void setNextfocus(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            dateTo.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.view.other;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author Dilhan
 */
public class About extends javax.swing.JDialog {

    /**
     * Creates new form about
     */
    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        //
        setLocationRelativeTo(parent);
        setTitle("About Us");
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

        animationClass1 = new AppPackage.AnimationClass();
        jLabel1 = new javax.swing.JLabel();
        closeLabel = new javax.swing.JLabel();
        aboutLabel = new javax.swing.JLabel();
        resevedLabel = new javax.swing.JLabel();
        cd = new javax.swing.JLabel();
        buildLabel = new javax.swing.JLabel();
        versionLabel = new javax.swing.JLabel();
        systemLabel = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        numberLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Home/LogoAboutHM.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 90, 270, 220));

        closeLabel.setBackground(new java.awt.Color(51, 51, 51));
        closeLabel.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        closeLabel.setForeground(new java.awt.Color(255, 255, 255));
        closeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        closeLabel.setText("Click to Close     ");
        closeLabel.setOpaque(true);
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeLabelMouseExited(evt);
            }
        });
        getContentPane().add(closeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 400, 700, 30));

        aboutLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        aboutLabel.setForeground(new java.awt.Color(51, 51, 51));
        aboutLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aboutLabel.setText("ABOUT");
        getContentPane().add(aboutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, -1));

        resevedLabel.setBackground(new java.awt.Color(255, 255, 255));
        resevedLabel.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        resevedLabel.setForeground(new java.awt.Color(0, 51, 51));
        resevedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resevedLabel.setText("© 2016 Black Mask  Products. All right reserved ");
        getContentPane().add(resevedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 690, 20));

        cd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cd.setForeground(new java.awt.Color(204, 0, 0));
        cd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cd.setText("Contact developer :");
        cd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cdMouseMoved(evt);
            }
        });
        cd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cdMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cdMouseExited(evt);
            }
        });
        getContentPane().add(cd, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, -1, -1));

        buildLabel.setBackground(new java.awt.Color(255, 255, 255));
        buildLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        buildLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buildLabel.setText("build 2016.02.01");
        getContentPane().add(buildLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 100, -1));

        versionLabel.setBackground(new java.awt.Color(51, 51, 51));
        versionLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        versionLabel.setForeground(new java.awt.Color(51, 51, 51));
        versionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        versionLabel.setText("Version 1.0.0");
        getContentPane().add(versionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 100, -1));

        systemLabel.setBackground(new java.awt.Color(255, 255, 255));
        systemLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        systemLabel.setForeground(new java.awt.Color(255, 255, 255));
        systemLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        systemLabel.setText("Click Management System ");
        getContentPane().add(systemLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 300, -1));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/LogoAbout.png"))); // NOI18N
        getContentPane().add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, -1));

        numberLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        numberLabel.setText(" Amila(+94) 76 794 0726  |  Vihanga(+94) 71 071 0917  |  Dilhan(+94) 77 834 5524");
        getContentPane().add(numberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 670, 40));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/about.png"))); // NOI18N
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cdMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cdMouseMoved

    }//GEN-LAST:event_cdMouseMoved

    private void cdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cdMouseClicked


    }//GEN-LAST:event_cdMouseClicked

    private void cdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cdMouseExited

    }//GEN-LAST:event_cdMouseExited

    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
        this.dispose();
    }//GEN-LAST:event_closeLabelMouseClicked

    private void closeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseEntered
        closeLabel.setForeground(Color.ORANGE);
    }//GEN-LAST:event_closeLabelMouseEntered

    private void closeLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseExited
        closeLabel.setForeground(Color.white);
    }//GEN-LAST:event_closeLabelMouseExited

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
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                About dialog = new About(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel aboutLabel;
    private AppPackage.AnimationClass animationClass1;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel buildLabel;
    private javax.swing.JLabel cd;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JLabel resevedLabel;
    private javax.swing.JLabel systemLabel;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables
}

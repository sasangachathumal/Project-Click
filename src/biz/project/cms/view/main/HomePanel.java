/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.project.cms.view.main;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import org.jdesktop.swingx.JXImagePanel;

/**
 *
 * @author Kisal Suranjaya
 */
public class HomePanel extends javax.swing.JPanel {

    /**
     * Creates new form HomePanel
     */
    public HomePanel() {
        initComponents();

        ImageIcon imageIcon = new ImageIcon("C:\\Windows\\BlackMask\\CMD\\AppData\\Image\\logo\\BackgroundPanel.png");
        panelImage.setImage(imageIcon.getImage());
        panelImage.setStyle(JXImagePanel.Style.SCALED);
        //
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        //

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage = new org.jdesktop.swingx.JXImagePanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(774, 720));
        setPreferredSize(new java.awt.Dimension(774, 720));

        panelImage.setMinimumSize(new java.awt.Dimension(774, 720));
        panelImage.setPreferredSize(new java.awt.Dimension(774, 720));
        panelImage.setStyle(org.jdesktop.swingx.JXImagePanel.Style.SCALED);

        javax.swing.GroupLayout panelImageLayout = new javax.swing.GroupLayout(panelImage);
        panelImage.setLayout(panelImageLayout);
        panelImageLayout.setHorizontalGroup(
            panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addContainerGap(774, Short.MAX_VALUE))
        );
        panelImageLayout.setVerticalGroup(
            panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImageLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addContainerGap(720, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private org.jdesktop.swingx.JXImagePanel panelImage;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package frames;

import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author PC Gamer
 */
public class Configfrm extends javax.swing.JDialog {

    /**
     * Creates new form Configfrm
     */
    public Configfrm(java.awt.Frame parent) {
            super(parent, "Configuracion", true);
        setUndecorated(true);
        initComponents();
        Shape forma = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50);
        setShape(forma);
        panelRound1.setRoundBottomLeft(35);
        panelRound1.setRoundBottomRight(35);
        panelRound1.setRoundTopLeft(35);
        panelRound1.setRoundTopRight(35);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new utilerias.PanelRound();
        panelRound2 = new utilerias.PanelRound();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        panelRound4 = new utilerias.PanelRound();
        panelRound3 = new utilerias.PanelRound();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(218, 218, 218));
        panelRound1.setRoundBottomLeft(35);
        panelRound1.setRoundBottomRight(35);
        panelRound1.setRoundTopLeft(35);
        panelRound1.setRoundTopRight(35);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(229, 229, 229));
        panelRound2.setRoundBottomRight(35);
        panelRound2.setRoundTopRight(35);

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Netbeans\\Juastapp\\JuatsappPresentacion\\src\\main\\java\\utilerias\\8666595_x_icon.png")); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("General");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addContainerGap(326, Short.MAX_VALUE))
        );

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 210, 360));

        panelRound4.setBackground(new java.awt.Color(209, 209, 209));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound3.setBackground(new java.awt.Color(18, 140, 126));
        panelRound3.setRoundBottomLeft(15);
        panelRound3.setRoundBottomRight(15);
        panelRound3.setRoundTopLeft(15);
        panelRound3.setRoundTopRight(15);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound4.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 10, 20));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Netbeans\\Juastapp\\JuatsappPresentacion\\src\\main\\java\\utilerias\\3592832_general_office_repair_repair tool_screwdriver_icon.png")); // NOI18N
        jLabel1.setText("General");
        panelRound4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelRound1.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, 40));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private utilerias.PanelRound panelRound1;
    private utilerias.PanelRound panelRound2;
    private utilerias.PanelRound panelRound3;
    private utilerias.PanelRound panelRound4;
    // End of variables declaration//GEN-END:variables
}

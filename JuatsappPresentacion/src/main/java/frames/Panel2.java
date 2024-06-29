/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames;

import javax.swing.JPanel;

/**
 *
 * @author PC Gamer
 */
public class Panel2 extends javax.swing.JPanel {

    /**
     * Creates new form Panel2
     */
    public Panel2() {
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        panelRound1 = new utilerias.PanelRound();
        buttonSend = new javax.swing.JButton();
        textMessage = new javax.swing.JTextField();
        buttonImage = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        textName = new javax.swing.JLabel();
        buttonConfigChat = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(236, 229, 221));

        panelRound1.setBackground(new java.awt.Color(234, 234, 234));
        panelRound1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));

        buttonSend.setIcon(new javax.swing.ImageIcon("D:\\Netbeans\\Juastapp\\JuatsappPresentacion\\src\\main\\java\\utilerias\\5340247_chat_media_network_social_telegram_icon.png")); // NOI18N
        buttonSend.setBorderPainted(false);
        buttonSend.setContentAreaFilled(false);
        buttonSend.setDefaultCapable(false);
        buttonSend.setFocusPainted(false);
        buttonSend.setFocusable(false);
        buttonSend.setRequestFocusEnabled(false);
        buttonSend.setVerifyInputWhenFocusTarget(false);
        buttonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendActionPerformed(evt);
            }
        });

        textMessage.setBackground(new java.awt.Color(234, 234, 234));
        textMessage.setForeground(new java.awt.Color(0, 0, 0));
        textMessage.setText("jTextField1");
        textMessage.setBorder(null);

        buttonImage.setIcon(new javax.swing.ImageIcon("D:\\Netbeans\\Juastapp\\JuatsappPresentacion\\src\\main\\java\\utilerias\\8664927_image_photo_icon.png")); // NOI18N
        buttonImage.setBorderPainted(false);
        buttonImage.setContentAreaFilled(false);
        buttonImage.setDefaultCapable(false);
        buttonImage.setFocusPainted(false);
        buttonImage.setFocusable(false);
        buttonImage.setRequestFocusEnabled(false);
        buttonImage.setVerifyInputWhenFocusTarget(false);
        buttonImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonImage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSend)
                .addGap(0, 0, 0))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonSend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textMessage))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(234, 234, 234));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText(".");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setDefaultCapable(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setRequestFocusEnabled(false);
        jButton1.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        textName.setBackground(new java.awt.Color(0, 0, 0));
        textName.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        textName.setForeground(new java.awt.Color(0, 0, 0));
        textName.setText("Name");
        jPanel3.add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        buttonConfigChat.setBorderPainted(false);
        buttonConfigChat.setContentAreaFilled(false);
        buttonConfigChat.setDefaultCapable(false);
        buttonConfigChat.setFocusPainted(false);
        buttonConfigChat.setFocusable(false);
        buttonConfigChat.setRequestFocusEnabled(false);
        buttonConfigChat.setVerifyInputWhenFocusTarget(false);
        buttonConfigChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfigChatActionPerformed(evt);
            }
        });
        jPanel3.add(buttonConfigChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 1, 420, 70));

        jPanel5.setBackground(new java.awt.Color(236, 229, 221));
        jPanel5.setForeground(new java.awt.Color(236, 229, 221));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConfigChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfigChatActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_buttonConfigChatActionPerformed

    private void buttonImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonImageActionPerformed

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonSendActionPerformed

    
    public JPanel getFondo() {
        return this;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConfigChat;
    private javax.swing.JButton buttonImage;
    private javax.swing.JButton buttonSend;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private utilerias.PanelRound panelRound1;
    private utilerias.PanelRound panelRound2;
    private javax.swing.JTextField textMessage;
    private javax.swing.JLabel textName;
    // End of variables declaration//GEN-END:variables
}

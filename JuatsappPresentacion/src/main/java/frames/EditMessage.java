/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package frames;

import dtos.ChatDTO;
import dtos.MessageDTO;
import exceptions.ExceptionService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import service.BusinessBO;

/**
 *
 * @author PC Gamer
 */
public class EditMessage extends javax.swing.JDialog {
     private BusinessBO busBO;
     private ChatDTO chat;
     private MessageDTO messages;
    /**
     * Creates new form EditMessage
     */
    public EditMessage(java.awt.Frame parent, MessageDTO message,BusinessBO busBO) {
        super(parent, "Editar mensaje",true);
        initComponents();
        this.busBO=busBO;
        this.messages=message;
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
        buttonUpdate = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(236, 229, 221));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(236, 229, 221));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonUpdate.setBackground(new java.awt.Color(37, 211, 102));
        buttonUpdate.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        buttonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        buttonUpdate.setText("EDITAR");
        buttonUpdate.setToolTipText("");
        buttonUpdate.setBorder(null);
        buttonUpdate.setBorderPainted(false);
        buttonUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(buttonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 70, 30));

        buttonCancel.setBackground(new java.awt.Color(37, 211, 102));
        buttonCancel.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        buttonCancel.setForeground(new java.awt.Color(255, 255, 255));
        buttonCancel.setText("CANCELAR");
        buttonCancel.setToolTipText("");
        buttonCancel.setBorder(null);
        buttonCancel.setBorderPainted(false);
        buttonCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 120, 20));

        txt.setBackground(new java.awt.Color(234, 234, 234));
        txt.setForeground(new java.awt.Color(0, 0, 0));
        txt.setBorder(null);
        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
            }
        });
        jPanel1.add(txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 340, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        try {
            int response = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres editar tu perfil?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                messages.setText(txt.getText());
                


                busBO.updateMessage(messages);

                JOptionPane.showMessageDialog(this, "Mensaje actualizado correctamente");
                this.dispose();
            }
        } catch (ExceptionService ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al actualizar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "El icono del botón no es un ImageIcon", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed

        this.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}

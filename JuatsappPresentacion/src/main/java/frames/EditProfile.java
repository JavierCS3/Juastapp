/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import dtos.UserDTO;
import exceptions.ExceptionService;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import service.BusinessBO;
import utilerias.ImageUtils;

/**
 *
 * @author PC Gamer
 */
public class EditProfile extends javax.swing.JFrame {
    private BusinessBO busBO;
    private int mouseX, mouseY;
    
    /**
     * Creates new form EditProfile
     */
    public EditProfile(BusinessBO busBO) {
        try {
            initComponents();
            this.busBO=busBO;
            this.setLocationRelativeTo(null);
            enableDrag();
            UserDTO user=busBO.getUserById(busBO.getId());
            txtName.setText(user.getUser());
            txtPassword.setText(user.getPassword());
            
            passwordBox.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           if (passwordBox.isSelected()) {
                               txtPassword.setEchoChar((char) 0);
                           } else {
                               txtPassword.setEchoChar('*');
                           }
                       }
                   });
            
            byte[] profileImageBytes = user.getProfileImage();
            
            ImageIcon icon = new ImageIcon(profileImageBytes);
            
            int width = 250;
            int height = 250;
            Image originalImage = icon.getImage();
            Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);

            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            jButton1.setIcon(scaledIcon);
        } catch (ExceptionService ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Método para habilitar el arrastrar
     */
    private void enableDrag() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
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
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonCancel = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        passwordBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(238, 238, 238));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Perfil");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 220, 50));

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Netbeans\\Juastapp\\JuatsappPresentacion\\src\\main\\java\\utilerias\\4213425_picture_image_file_gallery_photo_icon.png")); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setDefaultCapable(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 270, 270));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Contraseña");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.setToolTipText("");
        txtName.setActionCommand("<Not Set>");
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 140, 126)));
        txtName.setCaretColor(new java.awt.Color(18, 140, 126));
        txtName.setSelectionColor(new java.awt.Color(18, 140, 126));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 210, 30));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

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
        jPanel2.add(buttonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 90, 30));

        buttonUpdate.setBackground(new java.awt.Color(37, 211, 102));
        buttonUpdate.setFont(new java.awt.Font("Ebrima", 1, 14)); // NOI18N
        buttonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        buttonUpdate.setText("GUARDAR");
        buttonUpdate.setToolTipText("");
        buttonUpdate.setBorder(null);
        buttonUpdate.setBorderPainted(false);
        buttonUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(buttonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 90, 30));
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 210, 30));

        passwordBox.setContentAreaFilled(false);
        jPanel2.add(passwordBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 30, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif"));
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                // Cargar la imagen seleccionada como ImageIcon
                ImageIcon icon = new ImageIcon(ImageIO.read(file));

                // Mostrar la imagen en el botón jButton1
                jButton1.setIcon(icon);

            } catch (IOException ex) {
                Logger.getLogger(Chatsfrm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error al cargar la imagen: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
        Chatsfrm chat=new Chatsfrm(busBO);
        chat.show();
        this.dispose();
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
    try {
        int response = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres editar tu perfil?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
        UserDTO user = busBO.getUserById(busBO.getId());

        user.setUser(txtName.getText());
        user.setPassword((new String(txtPassword.getPassword())));

        Icon icon = jButton1.getIcon();
        byte[] profileImageBytes = null;

        if (icon instanceof ImageIcon) {
            BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g = bufferedImage.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            baos.flush();
            profileImageBytes = baos.toByteArray();
            baos.close();
        } else {
            throw new IllegalArgumentException("Icono del botón no es un ImageIcon");
        }

        user.setProfileImage(profileImageBytes);

        busBO.updateUser(user);

        JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente");
        Chatsfrm c=new Chatsfrm(busBO);
        c.show();
        this.dispose();
        }
    } catch (ExceptionService ex) {
        Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error al actualizar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IOException ex) {
        Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error al convertir imagen a bytes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException ex) {
        Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "El icono del botón no es un ImageIcon", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_buttonUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox passwordBox;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}

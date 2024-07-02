/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import dtos.ChatDTO;
import dtos.UserDTO;
import exceptions.ExceptionService;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;
import service.BusinessBO;

/**
 *
 * @author PC Gamer
 */
public class CreateContact extends javax.swing.JFrame {
    BusinessBO busBO;
    private List<JButton> buttons;
    private int index;
    private int mouseX, mouseY;
    
    /**
     * Creates new form CreateContact
     */
    public CreateContact(BusinessBO busBO) {
        initComponents();
        this.busBO=busBO;
        this.setLocationRelativeTo(null);
        buttons =new ArrayList<>();
        setButtonLayout();
        enableDrag();
        
    }
    
    /**
     * Método para habilitar el arrastras
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
     * Método para asignar el diseño a los botones
     * 
     */
    public void setButtonLayout() {
        try{
            
            List<ObjectId> ids = busBO.getUserById(busBO.getId()).getContactosDTO();
            List<UserDTO> contacts = new ArrayList<>();
            if(ids!=null){
               for (ObjectId id : ids) {
                    UserDTO user = busBO.getUserById(id);
                    contacts.add(user);
            } 
                buttons = new ArrayList<>();
            panel2.removeAll();

            for (UserDTO contact : contacts) {
                JButton button = new JButton();

                byte[] profileImageBytes = contact.getProfileImage();
                ImageIcon icon = new ImageIcon(profileImageBytes);
                Image scaledImage = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                button.setIcon(scaledIcon);
                button.setText("  " + contact.getUser());
                button.setHorizontalAlignment(JButton.LEFT);
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);

                button.setFocusCycleRoot(false);
                button.setFocusPainted(false);
                button.setFocusable(false);

                button.setPreferredSize(new Dimension(490, 60));

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CreateChatOrDeleteContact(contact);
                    }
                });

                panel2.add(button);
                buttons.add(button);
            }

            panel2.revalidate();
            panel2.repaint();
            }
            
        } catch (ExceptionService ex) {
            Logger.getLogger(CreateContact.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void CreateChatOrDeleteContact(UserDTO contact){
        try {
            List<ChatDTO> chat1 = busBO.getChatByUser(busBO.getId());
            List<ChatDTO> chat2 = busBO.getChatByUser(contact.getId());

            boolean hasChat = false;

            for (ChatDTO chatDTO1 : chat1) {
                for (ChatDTO chatDTO2 : chat2) {
                    if (chatDTO1 != null && chatDTO2 != null && chatDTO1.getId().equals(chatDTO2.getId())) {
                        hasChat = true;
                        break;
                    }
                }
                if (hasChat) {
                    break;
                }
            }

            if (!hasChat) {
                String[] options = { "Crear Chat", "Eliminar Contacto", "Cancelar" };
            int choice = JOptionPane.showOptionDialog(null, "¿Qué acción deseas realizar?", "Acción a Realizar",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
            
            switch (choice) {
                case JOptionPane.YES_OPTION:
                    CreateChat chat = new CreateChat(busBO, contact);
                    openCreateChat(chat);
                    System.out.println("Contacto seleccionado: " + contact.getUser());
                    break;
                case JOptionPane.NO_OPTION:
                    try {
                        UserDTO currentUser = busBO.getUserById(busBO.getId());
                        
                        if (currentUser != null && contact != null) {
                            List<ObjectId> contacts = currentUser.getContactosDTO();
                            if (contacts.remove(contact.getId())) {
                                currentUser.setContactosDTO(contacts);
                                busBO.updateUserContacts(currentUser);
                                JOptionPane.showMessageDialog(null, "Contacto eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                setButtonLayout();
                            } else {
                                JOptionPane.showMessageDialog(null, "El contacto no existe en tu lista.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al obtener los usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (ExceptionService ex) {
                        Logger.getLogger(AddContact.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case JOptionPane.CANCEL_OPTION:
                case JOptionPane.CLOSED_OPTION:
                    break;
            }
            }else{
                 String[] options = { "Eliminar Contacto", "Cancelar" };
                    int choice = JOptionPane.showOptionDialog(null, "Ya existe un chat con este contacto. ¿Qué acción deseas realizar?", "Acción a Realizar",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

                    switch (choice) {
                        case JOptionPane.YES_OPTION:
                            try {
                                UserDTO currentUser = busBO.getUserById(busBO.getId());

                                if (currentUser != null && contact != null) {
                                    List<ObjectId> contacts = currentUser.getContactosDTO();
                                    if (contacts.remove(contact.getId())) {
                                        currentUser.setContactosDTO(contacts);
                                        busBO.updateUserContacts(currentUser);
                                        JOptionPane.showMessageDialog(null, "Contacto eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                        setButtonLayout();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "El contacto no existe en tu lista.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error al obtener los usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (ExceptionService ex) {
                                Logger.getLogger(AddContact.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case JOptionPane.NO_OPTION:
                            break;
                        case JOptionPane.CANCEL_OPTION:
                            break;
                        case JOptionPane.CLOSED_OPTION:
                            break;
                    }
            }
            
        } catch (ExceptionService ex) {
            Logger.getLogger(CreateContact.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    /**
     * 
     * Método para abrir un chat creado
     * @param chat chat creadi para abrir
     */
    public void openCreateChat(CreateChat chat){
        chat.show();
        this.dispose();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panel = new javax.swing.JScrollPane();
        panel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Contactos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, -1));

        jButton2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("<");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setDefaultCapable(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setRequestFocusEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        panel.setBackground(new java.awt.Color(220, 220, 220));
        panel.setBorder(null);
        panel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel2.setBackground(new java.awt.Color(220, 220, 220));
        panel2.setLayout(new java.awt.GridLayout(0, 1));
        panel.setViewportView(panel2);

        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 580, 410));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Dubai", 0, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("+");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 80, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Chatsfrm chat=new Chatsfrm(busBO);
        chat.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        AddContact add=new AddContact(this,busBO);
        add.show();
    }//GEN-LAST:event_jButton3ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane panel;
    private javax.swing.JPanel panel2;
    // End of variables declaration//GEN-END:variables
}

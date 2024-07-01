/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import dtos.ChatDTO;
import dtos.UserDTO;
import exceptions.ExceptionService;
import java.awt.BorderLayout;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    
    public void setButtonLayout() {
        try {
            List<ObjectId> ids=busBO.getUserById(busBO.getId()).getContactosDTO();
            List<UserDTO> contacts =new ArrayList<>();
            UserDTO userNow=busBO.getUserById(busBO.getId());
            System.out.println("numero de chats " +busBO.getChatByUser(busBO.getId()).size());
            
            List<ChatDTO> chat1 = busBO.getChatByUser(busBO.getId());
            for (ObjectId id : ids) {
                int count = 0;
                List<ChatDTO> chat2 = busBO.getChatByUser(id);
                System.out.println("numero de chats contactos: " + chat2.size());

                for (int i = 0; i < chat1.size() && i < chat2.size(); i++) {
                    if (chat2.get(i) != null && chat1.get(i) != null) {
                        if (chat1.get(i).getId().equals(chat2.get(i).getId())) {
                            count = 1;
                            break;
                        }
                    }
                }
                System.out.println("Contador " + count);
                if (count == 0) {
                    UserDTO user = busBO.getUserById(id);
                    contacts.add(user);
                }
            }
            System.out.println(contacts.size());
            buttons = new ArrayList<>();
            panel.removeAll();
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
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CreateChat chat=new CreateChat(busBO,contact);
                        openCreateChat(chat);
                        System.out.println("Contacto seleccionado: " + contact.getUser());
                    }
                });

                panel.add(button);
                buttons.add(button);
                index++;
            }
            panel.revalidate();
            panel.repaint();
        } catch (ExceptionService ex) {
            Logger.getLogger(CreateContact.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
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
        panel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Contactos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        panel.setBackground(new java.awt.Color(220, 220, 220));
        panel.setLayout(new java.awt.GridLayout(0, 1));
        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 490, 290));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 380));

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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}

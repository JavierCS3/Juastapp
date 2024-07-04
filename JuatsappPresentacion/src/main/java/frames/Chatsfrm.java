/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import dtos.ChatDTO;
import dtos.UserDTO;
import exceptions.ExceptionService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.bson.types.ObjectId;
import service.BusinessBO;

/**
 *
 * @author PC Gamer
 */
public class Chatsfrm extends javax.swing.JFrame {
    private int mouseX, mouseY;
    private BusinessBO busBO;
     private List<JButton> buttons;
    private Panel1 b = new Panel1();
    
    /**
     * Creates new form Chats
     */
    public Chatsfrm(BusinessBO busBO) {
        try {
            initComponents();
            this.setSize(920,560);
            this.setLocationRelativeTo(null);
            
            showPanel(b.getFondo());
            enableDrag();
            this.busBO=busBO;
            byte[] profileImageBytes = busBO.getUserById(busBO.getId()).getProfileImage();
            
            ImageIcon icon = new ImageIcon(profileImageBytes);

            Image scaledImage = icon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            BontonPerfil.setText("");
            BontonPerfil.setIcon(scaledIcon);
            setButtonLayout();
        } catch (ExceptionService ex) {
            Logger.getLogger(Chatsfrm.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new utilerias.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        dashBoard = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        panelRound3 = new utilerias.PanelRound();
        BontonPerfil = new javax.swing.JButton();
        boardChats = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(635, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(234, 234, 234));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jLabel1.setText("Chats");

        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jButton3))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 220, 50));

        jPanel1.setBackground(new java.awt.Color(235, 235, 235));
        jPanel1.setPreferredSize(new java.awt.Dimension(628, 434));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(220, 220, 220));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel2.setText("    JuastApp");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 40, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 30));

        dashBoard.setBackground(new java.awt.Color(224, 224, 224));

        javax.swing.GroupLayout dashBoardLayout = new javax.swing.GroupLayout(dashBoard);
        dashBoard.setLayout(dashBoardLayout);
        dashBoardLayout.setHorizontalGroup(
            dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        dashBoardLayout.setVerticalGroup(
            dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jPanel1.add(dashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 620, 530));

        jPanel4.setBackground(new java.awt.Color(220, 220, 220));

        jButton1.setBackground(new java.awt.Color(220, 220, 220));
        jButton1.setForeground(new java.awt.Color(220, 220, 220));
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setDefaultCapable(false);
        jButton1.setFocusPainted(false);
        jButton1.setRequestFocusEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panelRound3.setBackground(new java.awt.Color(215, 215, 215));
        panelRound3.setRoundBottomLeft(100);
        panelRound3.setRoundBottomRight(100);
        panelRound3.setRoundTopLeft(100);
        panelRound3.setRoundTopRight(100);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        BontonPerfil.setText(".");
        BontonPerfil.setToolTipText("");
        BontonPerfil.setBorderPainted(false);
        BontonPerfil.setContentAreaFilled(false);
        BontonPerfil.setDefaultCapable(false);
        BontonPerfil.setFocusPainted(false);
        BontonPerfil.setFocusable(false);
        BontonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BontonPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                        .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BontonPerfil))
                .addGap(0, 17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(390, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(BontonPerfil)
                .addGap(49, 49, 49))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 560));

        boardChats.setBackground(new java.awt.Color(234, 234, 234));
        boardChats.setLayout(new java.awt.GridLayout(0, 1));
        jPanel1.add(boardChats, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 81, 220, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void setButtonLayout() {
        
        try {
        List<ChatDTO> chats = busBO.getChatByUser(busBO.getId());

        buttons = new ArrayList<>();
        boardChats.removeAll();

        boardChats.setLayout(new BoxLayout(boardChats, BoxLayout.Y_AXIS));

        for (ChatDTO chat : chats) {
            
            JPanel chatPanel = new JPanel();
            chatPanel.setLayout(new BorderLayout());
            chatPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            chatPanel.setBackground(new Color(236, 229, 221));

            byte[] chatImageBytes = chat.getChatImage();
            ImageIcon icon = new ImageIcon(chatImageBytes);
            Image scaledImage = icon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            chatPanel.add(imageLabel, BorderLayout.WEST);

            JTextArea chatInfo = new JTextArea();
            chatInfo.setOpaque(false);
            chatInfo.setEditable(false);
            chatInfo.setFocusable(false);
            chatInfo.setLineWrap(true);
            chatInfo.setWrapStyleWord(true);
            chatInfo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            chatInfo.setMaximumSize(new Dimension(400, 100));
            
            List<ObjectId> ids=chat.getParticipants();
            List<ObjectId> contacts = busBO.getUserById(busBO.getId()).getContactosDTO();
            UserDTO user=new UserDTO();
            boolean hasChat = false;
            if(contacts!=null){
                System.out.println("1");
               for(ObjectId idP : ids){
                    if(idP.equals(busBO.getId())){
                    } else {
                        user=busBO.getUserById(idP);
                        System.out.println("hola 1");
                }
               }
               
               for (ObjectId id : contacts) {
                        for(ObjectId idP : ids){
                            if (idP != null && id != null) {
                                if(id.equals(idP)){
                                  hasChat = true;  
                                  user=busBO.getUserById(idP);
                                }
                        }else{
                                if(idP!=(busBO.getId())){
                                    user=busBO.getUserById(idP);
                                }
                        }
                    }
            }   
            }
               
            if(!hasChat){
                System.out.println("hola "+ user.getPhone());
                chatInfo.setText( user.getPhone());
            }else{
                chatInfo.setText(chat.getChatName());
            }

            chatPanel.add(chatInfo, BorderLayout.CENTER);

            JButton button = new JButton("+");
            button.setForeground(chatInfo.getCaretColor());
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setFocusCycleRoot(false);
            button.setFocusPainted(false);
            button.setFocusable(false);
            
            button.addActionListener(e -> {
                Panel2 chatFrame = new Panel2(busBO, chat);
                showPanel(chatFrame);
            });
            
            chatPanel.add(button, BorderLayout.EAST);
            buttons.add(button);
            chatPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, chatPanel.getPreferredSize().height));
            chatPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            boardChats.add(chatPanel);
        
        }
        boardChats.revalidate();
        boardChats.repaint();
    } catch (ExceptionService ex) {
        Logger.getLogger(CreateContact.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            Configfrm config=new Configfrm(this,busBO);
            config.show();
        } catch (ExceptionService ex) {
            Logger.getLogger(Chatsfrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        CreateContact contact=new CreateContact(busBO);
        contact.show();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BontonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BontonPerfilActionPerformed
        // TODO add your handling code here:
        EditProfile editP=new EditProfile(busBO);
        editP.show();
        this.dispose();
    }//GEN-LAST:event_BontonPerfilActionPerformed


    private void showPanel(JPanel p){
        p.setSize(620, 530);
        p.setLocation(0, 0);
        dashBoard.removeAll();
        dashBoard.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,-1,-1));
        dashBoard.revalidate();
        dashBoard.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BontonPerfil;
    private javax.swing.JPanel boardChats;
    private javax.swing.JPanel dashBoard;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private utilerias.PanelRound panelRound1;
    private utilerias.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}

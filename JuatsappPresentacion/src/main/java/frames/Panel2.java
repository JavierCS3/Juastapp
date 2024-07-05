/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frames;

import dtos.ChatDTO;
import dtos.MessageDTO;
import dtos.ParticipantDTO;
import dtos.UserDTO;
import exceptions.ExceptionService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.bson.types.ObjectId;
import service.BusinessBO;


/**
 *
 * @author PC Gamer
 */
public class Panel2 extends javax.swing.JPanel {
    private BusinessBO busBO;
    private ChatDTO chat;
    private List<MessageDTO> messages;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("hh:mm a");
    public javax.swing.Timer timer;  
    private int PAGE_SIZE = 5; 
    private int currentPage = 0;

    /**
     * Creates new form Panel2
     */
    public Panel2(BusinessBO busBO, ChatDTO chat) {
        try {
            initComponents();
            this.busBO=busBO;
            this.chat=chat;
            JScrollBar verticalScrollBar = dashBoard.getVerticalScrollBar();
            verticalScrollBar.setValue(100);
            dashBoard.setVerticalScrollBar(verticalScrollBar);
            
            List<ParticipantDTO> participants=chat.getParticipants();
            List<ObjectId> ids=new ArrayList();
            
            for(ParticipantDTO participant:participants){
                ids.add(participant.getUserId());
            }
            
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
                textName.setText("   "+ user.getPhone());
            }else{
                textName.setText("   "+chat.getChatName());
            }
            jButton1.setText("");
            byte[] profileImageBytes = chat.getChatImage();
            
            ImageIcon icon = new ImageIcon(profileImageBytes);
            
            Image scaledImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            jButton1.setIcon(scaledIcon);
            
            
            setMessages();
            timer = new javax.swing.Timer(5000, e -> setMessages());
            timer.start();
            initialize();
        } catch (ExceptionService ex) {
            Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     @Override
    protected void finalize() throws Throwable {
        timer.stop();
        super.finalize();
    }
    
    /**
     * Método para asignar mensajes en el chat
     * 
     */
    private void setMessages() {
             try {
            List<MessageDTO> allMessages = busBO.getAllMessagesByChat(chat.getId());
            allMessages.sort((m1, m2) -> m2.getTimestamp().compareTo(m1.getTimestamp()));

            int fromIndex = currentPage * PAGE_SIZE;
            int toIndex = Math.min(fromIndex + PAGE_SIZE, allMessages.size());

            if (fromIndex >= allMessages.size()) {
                messages = Collections.emptyList();
            } else {
                messages = allMessages.subList(fromIndex, toIndex);
            }

            showMessages(currentPage == 0);
           } catch (ExceptionService ex) {
               Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
           }
       }

    /**
     * Método para mostrar los mensajes
     * @param scrollToBottom desplazar hasta el fondo
     */
    private void showMessages(boolean scrollToBottom) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            
            for (int i = messages.size() - 1; i >= 0; i--) {
                MessageDTO message = messages.get(i);
                JPanel messagePanel = new JPanel();
                messagePanel.setLayout(new BorderLayout());
                messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

                String formattedTime = message.getTimestamp().format(TIME_FORMATTER);


                if (message.getText() != null && !message.getText().isEmpty()) {
                    JTextArea messageArea = new JTextArea();
                    messageArea.setOpaque(true);
                    messageArea.setEditable(false);
                    messageArea.setLineWrap(true);
                    messageArea.setWrapStyleWord(true);
                    messageArea.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    messageArea.setMaximumSize(new Dimension(400, 100));
                    if (message.getSenderId().equals(busBO.getId())) {
                        messagePanel.setBackground(new Color(236, 229, 221));
                        messagePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                        messageArea.setForeground(Color.BLACK);
                        messageArea.setBackground(new Color(200, 255, 200));
                        messageArea.setText("Tú:\n" + message.getText() + "\n                               " + formattedTime);
                        
                        JPanel buttonPanel = new JPanel(new BorderLayout());
                        JButton button = new JButton("..");
                        button.setForeground(messageArea.getCaretColor());
                        button.setOpaque(false);
                        button.setContentAreaFilled(false);
                        button.setBorderPainted(false);
                        button.setFocusCycleRoot(false);
                        button.setFocusPainted(false);
                        button.setFocusable(false);
                        button.addActionListener(e -> {
                            editOrEliminated(message);
                        });
                        buttonPanel.add(button, BorderLayout.EAST);

                        messagePanel.add(buttonPanel, BorderLayout.NORTH);
                    } else {
                        try {
                            messagePanel.setBackground(new Color(236, 229, 221));
                            messagePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
                            messageArea.setBackground(new Color(230, 230, 230));
                            messageArea.setForeground(Color.BLACK);

                            UserDTO user = busBO.getUserById(message.getSenderId());
                            if (user != null) {
                                messageArea.setText(user.getUser() + ":\n" + message.getText() + "\n                            " + formattedTime);
                            } else {
                                messageArea.setText("Usuario Desconocido:\n" + message.getText() + "\n" + formattedTime);
                            }
                        } catch (ExceptionService ex) {
                            Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
                            messageArea.setText("Error al cargar el usuario:\n" + message.getText() + "\n" + formattedTime);
                        }
                    }

                    
                    messagePanel.add(messageArea, BorderLayout.CENTER);

                } else if (message.getImage()!=null) {
                    try {
                    byte[] imageData = message.getImage();
                    ImageIcon imageIcon = new ImageIcon(imageData);
                    Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    JLabel imageLabel = new JLabel(scaledIcon);

                    JPanel buttonPanel = new JPanel(new BorderLayout());
                    JButton button = new JButton("..");
                    button.setForeground(Color.BLACK);
                    button.setOpaque(false);
                    button.setContentAreaFilled(false);
                    button.setBorderPainted(false);
                    button.setFocusPainted(false);
                    
                    
                    button.addActionListener(e -> {
                        editOrEliminatedImageM(message);
                    });
                    

                    messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    messagePanel.setBackground(new Color(236, 229, 221));
                    messagePanel.setLayout(new BorderLayout());

                    if (message.getSenderId().equals(busBO.getId())) {
                        buttonPanel.add(button, BorderLayout.EAST);
                         messagePanel.add(buttonPanel, BorderLayout.NORTH);
                        messagePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    } else {
                        messagePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
                    }

                   
                    messagePanel.add(imageLabel, BorderLayout.CENTER);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                }
                panel.add(messagePanel);
            }

            panel.setBackground(new Color(236, 229, 221));
            SwingUtilities.invokeLater(() -> {
                dashBoard.setViewportView(panel);
                dashBoard.revalidate();
                dashBoard.repaint();

                if (scrollToBottom) {
                    JScrollBar verticalScrollBar = dashBoard.getVerticalScrollBar();
                    verticalScrollBar.setValue(verticalScrollBar.getMaximum());
                }
            });
        }
    
        
       public void initialize() {
       
        AdjustmentListener adjustmentListener = new AdjustmentListener() {
            int count=0;
             @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                JScrollBar scrollBar = (JScrollBar) e.getAdjustable();
                if(scrollBar.getValue()==0){
                    count++;
                    System.out.println(count);
                }else{
                    count=0;
                }
                if ( count==2) {
                    loadNextPage();
                }
            }
        };
        
        dashBoard.getVerticalScrollBar().addAdjustmentListener(adjustmentListener);
        currentPage = 0;
        setMessages();
    }
    
    public void loadNextPage() {
         System.out.println("mas mensajes cargados");
         PAGE_SIZE++;  
         setMessages();
    }

    public void loadPreviousPage() {
        if (currentPage > 0) {
            currentPage--;
            setMessages();
        }
    }
       
    /**
     * Método para eliminar o editar una imagen
     * @param message 
     */
       public void editOrEliminatedImageM(MessageDTO message){
         try {
            String[] options = {"Eliminar", "Cancelar"};
            int choice = JOptionPane.showOptionDialog(null,
                    "¿Qué acción deseas realizar con este mensaje?",
                    "Eliminar o Cancelar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);

            switch (choice) {
                case 0:
                    int confirmOption = JOptionPane.showConfirmDialog(null,
                            "¿Está seguro que desea eliminar este mensaje?",
                            "Confirmación de Eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    if (confirmOption == JOptionPane.YES_OPTION) {
                        busBO.deleteMessageById(message.getId());
                    }
                    break;
                case 1: // Cancelar
                    break;
                default:
                    break;
            }
        } catch (ExceptionService ex) {
            Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
       
       
    /**
     * Método para editar o eliminar un mensaje
     * @param message 
     */   
    public void editOrEliminated(MessageDTO message){
        try {
            String[] options = {"Editar", "Eliminar", "Cancelar"};
            int choice = JOptionPane.showOptionDialog(null,
                    "¿Qué acción desea realizar sobre el mensaje?",
                    "Editar o Eliminar Mensaje",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);

            switch (choice) {
                case 0: 
                    JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    EditMessage editMessage=new EditMessage(parentFrame,message,busBO);
                    editMessage.show();
                    break;
                case 1:
                    int option = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro que desea eliminar este mensaje?",
                        "Confirmación de Eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                
                if (option == JOptionPane.YES_OPTION) {
                    busBO.deleteMessageById(message.getId());
                }
                    break;
                case 2: 
                    break;
                default:
                    break;
            }
        } catch (ExceptionService ex) {
            Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        txt = new javax.swing.JTextField();
        buttonImage = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        textName = new javax.swing.JLabel();
        buttonConfigChat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dashBoard = new javax.swing.JScrollPane();

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

        txt.setBackground(new java.awt.Color(234, 234, 234));
        txt.setBorder(null);
        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addComponent(buttonImage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt)
                .addGap(18, 18, 18)
                .addComponent(buttonSend)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonSend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        textName.setBackground(new java.awt.Color(0, 0, 0));
        textName.setFont(new java.awt.Font("Dubai", 1, 14)); // NOI18N
        textName.setText("Name");
        jPanel3.add(textName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

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
        jPanel3.add(buttonConfigChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 1, 620, 70));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("...");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, -10, 40, 70));

        dashBoard.setBackground(new java.awt.Color(236, 229, 221));
        dashBoard.setBorder(null);
        dashBoard.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashBoard)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dashBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        String[] options = {"Editar", "Eliminar", "Cancelar"};
    
        int response = JOptionPane.showOptionDialog(
            null, 
            "¿Qué acción deseas realizar con este chat?", 
            "Editar o Eliminar Chat", 
            JOptionPane.YES_NO_CANCEL_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options,  
            options[0]  
        );

        if (response == JOptionPane.YES_OPTION) {
             JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            EditChat edit = new EditChat(parentFrame, busBO, chat);
            edit.setVisible(true); 
        } else if (response == JOptionPane.NO_OPTION) {
            int response1 = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres elimar este chat? ", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response1 == JOptionPane.YES_OPTION){
                try {
                    List<ParticipantDTO> participants=chat.getParticipants();
                    for(ParticipantDTO participant: participants){
                        if(busBO.getId().equals(participant.getUserId())){
                            participant.setDeleted(true);
                        }
                    }
                    chat.setParticipants(participants);
                    busBO.updateChat(chat);
                    Chatsfrm chatsFrame = new Chatsfrm(busBO);
                    chatsFrame.show();
                    JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    finalize();
                    parentFrame.dispose();
                } catch (ExceptionService ex) {
                    Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Throwable ex) {
                    Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (response == JOptionPane.CANCEL_OPTION) {
        }
    
    }//GEN-LAST:event_buttonConfigChatActionPerformed

    private void buttonImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImageActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif"));
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                byte[] imageData = Files.readAllBytes(file.toPath());

                int option = JOptionPane.showConfirmDialog(this, "¿Deseas enviar esta imagen?", "Confirmar Envío de Imagen", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    MessageDTO message = new MessageDTO();
                    message.setChatId(chat.getId());
                    message.setImage(imageData);
                    message.setSenderId(busBO.getId());
                    message.setTimestamp(LocalDateTime.now());
                    busBO.createMessage(message);

                    JOptionPane.showMessageDialog(this, "Imagen enviada correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "Envío cancelado");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al leer la imagen: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ExceptionService ex) {
                Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }//GEN-LAST:event_buttonImageActionPerformed

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendActionPerformed
        String messageText = txt.getText().trim(); 

        if (!messageText.isEmpty()) { 
            try {
                MessageDTO message = new MessageDTO();
                message.setChatId(chat.getId());
                message.setSenderId(busBO.getId());
                message.setTimestamp(LocalDateTime.now());
                message.setText(messageText);
                busBO.createMessage(message);

                txt.setText("");

            } catch (ExceptionService ex) {
                Logger.getLogger(Panel2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "El mensaje no puede estar vacío", "Mensaje Vacío", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_buttonSendActionPerformed

    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public JPanel getFondo() {
        return this;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConfigChat;
    private javax.swing.JButton buttonImage;
    private javax.swing.JButton buttonSend;
    private javax.swing.JScrollPane dashBoard;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private utilerias.PanelRound panelRound1;
    private javax.swing.JLabel textName;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}

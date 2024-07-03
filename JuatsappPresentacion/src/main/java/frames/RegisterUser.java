/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import dtos.AddresDTO;
import dtos.UserDTO;
import exceptions.ExceptionService;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import service.BusinessBO;

/**
 *
 * @author PC Gamer
 */
public class RegisterUser extends javax.swing.JFrame {
    BusinessBO busBO;
    private int mouseX, mouseY;
    
    /**
     * Creates new form RegisterUser
     */
    public RegisterUser(BusinessBO busBO) {
        initComponents();
        this.busBO=busBO;
        
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        date = new rojeru_san.componentes.RSDateChooser();
        txtPas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gener = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtStreet = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtHnumber = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtC = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCoords = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(18, 140, 126));

        jPanel3.setBackground(new java.awt.Color(37, 211, 102));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(241, 241, 241));
        jPanel2.setDoubleBuffered(false);

        jLabel3.setBackground(new java.awt.Color(18, 140, 126));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(18, 140, 126));
        jLabel3.setText("Nombre de Usuario");

        jLabel4.setBackground(new java.awt.Color(18, 140, 126));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(18, 140, 126));
        jLabel4.setText("CREAR CUENTA");

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setForeground(new java.awt.Color(0, 0, 0));
        txtUser.setToolTipText("");
        txtUser.setActionCommand("<Not Set>");
        txtUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 140, 126)));
        txtUser.setCaretColor(new java.awt.Color(18, 140, 126));
        txtUser.setSelectionColor(new java.awt.Color(18, 140, 126));
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(18, 140, 126));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(18, 140, 126));
        jLabel5.setText("Foto de perfil");

        jLabel6.setBackground(new java.awt.Color(18, 140, 126));
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(18, 140, 126));
        jLabel6.setText("Numero de telefono");

        txtNumber.setBackground(new java.awt.Color(255, 255, 255));
        txtNumber.setForeground(new java.awt.Color(0, 0, 0));
        txtNumber.setToolTipText("");
        txtNumber.setActionCommand("<Not Set>");
        txtNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 140, 126)));
        txtNumber.setCaretColor(new java.awt.Color(18, 140, 126));
        txtNumber.setSelectionColor(new java.awt.Color(18, 140, 126));
        txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(18, 140, 126));
        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(18, 140, 126));
        jLabel7.setText("Fecha de nacimiento");

        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setBgChooser(new java.awt.Color(37, 211, 102));
        date.setColorBackground(new java.awt.Color(37, 211, 102));
        date.setColorButtonHover(new java.awt.Color(37, 211, 102));
        date.setColorForeground(new java.awt.Color(18, 140, 126));
        date.setColorSelForeground(new java.awt.Color(0, 0, 0));
        date.setColorTextDiaActual(new java.awt.Color(0, 0, 0));

        txtPas.setBackground(new java.awt.Color(255, 255, 255));
        txtPas.setForeground(new java.awt.Color(0, 0, 0));
        txtPas.setToolTipText("");
        txtPas.setActionCommand("<Not Set>");
        txtPas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 140, 126)));
        txtPas.setCaretColor(new java.awt.Color(18, 140, 126));
        txtPas.setSelectionColor(new java.awt.Color(18, 140, 126));
        txtPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(18, 140, 126));
        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(18, 140, 126));
        jLabel8.setText("Genero:");

        gener.setBackground(new java.awt.Color(255, 255, 255));
        gener.setForeground(new java.awt.Color(18, 140, 126));
        gener.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Binario", "Caballo", "Otro" }));

        jLabel10.setBackground(new java.awt.Color(18, 140, 126));
        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(18, 140, 126));
        jLabel10.setText("Dirección");

        jLabel11.setBackground(new java.awt.Color(18, 140, 126));
        jLabel11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(18, 140, 126));
        jLabel11.setText("Contraseña:");

        txtStreet.setBackground(new java.awt.Color(255, 255, 255));
        txtStreet.setForeground(new java.awt.Color(0, 0, 0));
        txtStreet.setToolTipText("");
        txtStreet.setActionCommand("<Not Set>");
        txtStreet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 140, 126)));
        txtStreet.setCaretColor(new java.awt.Color(18, 140, 126));
        txtStreet.setSelectionColor(new java.awt.Color(18, 140, 126));
        txtStreet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStreetActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(18, 140, 126));
        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(18, 140, 126));
        jLabel12.setText("Calle");

        jLabel13.setBackground(new java.awt.Color(18, 140, 126));
        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(18, 140, 126));
        jLabel13.setText("Codigo postal");

        txtHnumber.setBackground(new java.awt.Color(255, 255, 255));
        txtHnumber.setForeground(new java.awt.Color(0, 0, 0));
        txtHnumber.setToolTipText("");
        txtHnumber.setActionCommand("<Not Set>");
        txtHnumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 140, 126)));
        txtHnumber.setCaretColor(new java.awt.Color(18, 140, 126));
        txtHnumber.setSelectionColor(new java.awt.Color(18, 140, 126));
        txtHnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHnumberActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(18, 140, 126));
        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(18, 140, 126));
        jLabel14.setText("Numero de casa");

        txtCode.setBackground(new java.awt.Color(255, 255, 255));
        txtCode.setForeground(new java.awt.Color(0, 0, 0));
        txtCode.setToolTipText("");
        txtCode.setActionCommand("<Not Set>");
        txtCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 140, 126)));
        txtCode.setCaretColor(new java.awt.Color(18, 140, 126));
        txtCode.setSelectionColor(new java.awt.Color(18, 140, 126));
        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(18, 140, 126));
        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(18, 140, 126));
        jLabel15.setText("Colonia");

        txtC.setBackground(new java.awt.Color(255, 255, 255));
        txtC.setForeground(new java.awt.Color(0, 0, 0));
        txtC.setToolTipText("");
        txtC.setActionCommand("<Not Set>");
        txtC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 140, 126)));
        txtC.setCaretColor(new java.awt.Color(18, 140, 126));
        txtC.setSelectionColor(new java.awt.Color(18, 140, 126));
        txtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(18, 140, 126));
        jLabel16.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(18, 140, 126));
        jLabel16.setText("Coordenadas");

        txtCoords.setBackground(new java.awt.Color(255, 255, 255));
        txtCoords.setForeground(new java.awt.Color(0, 0, 0));
        txtCoords.setToolTipText("");
        txtCoords.setActionCommand("<Not Set>");
        txtCoords.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 140, 126)));
        txtCoords.setCaretColor(new java.awt.Color(18, 140, 126));
        txtCoords.setSelectionColor(new java.awt.Color(18, 140, 126));
        txtCoords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCoordsActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(37, 211, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(37, 211, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ACEPTAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(37, 211, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("D:\\Netbeans\\Juastapp\\JuatsappPresentacion\\src\\main\\java\\utilerias\\290120_account_avatar_man_profile_user_icon.png")); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(164, 164, 164))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15)
                            .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(txtHnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCoords, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gener, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addComponent(txtPas, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gener, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPas, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCoords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Netbeans\\Juastapp\\JuatsappPresentacion\\src\\main\\java\\utilerias\\8197847_whatsapp_social network_communication_message_interaction_icon.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("JUATSAPP");

        jButton4.setIcon(new javax.swing.ImageIcon("D:\\Netbeans\\Juastapp\\JuatsappPresentacion\\src\\main\\java\\utilerias\\8666595_x_icon.png")); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(240, 240, 240))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(232, 232, 232)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(68, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(70, 70, 70)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(334, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberActionPerformed

    private void txtPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasActionPerformed

    private void txtStreetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStreetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStreetActionPerformed

    private void txtHnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHnumberActionPerformed

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    private void txtCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCActionPerformed

    private void txtCoordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCoordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoordsActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png", "gif"));
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                BufferedImage image = ImageIO.read(selectedFile);

                ImageIcon icon = new ImageIcon(image.getScaledInstance(120, 120, Image.SCALE_SMOOTH));
                jButton3.setIcon(icon);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:}
        Login login =new Login(busBO);
        login.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {                                         
            if (txtUser.getText().isEmpty() ||
                    txtNumber.getText().isEmpty() ||
                    txtPas.getText().isEmpty() ||
                    date.getDatoFecha() == null ||
                    gener.getSelectedItem() == null ||
                    txtC.getText().isEmpty() ||
                    txtStreet.getText().isEmpty() ||
                    txtCode.getText().isEmpty() ||
                    txtHnumber.getText().isEmpty() ||
                    txtCoords.getText().isEmpty()) {
                
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            
            String phoneNumberStr = txtNumber.getText().trim();
            if (phoneNumberStr.length() != 10 || (busBO.getUserByPhone(phoneNumberStr))!=null) {
                JOptionPane.showMessageDialog(null, "Numero de telefono no valido", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            long phoneNumber;
            try {
                phoneNumber = Long.parseLong(phoneNumberStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El número de teléfono debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            java.util.Date dateValue = date.getDatoFecha();
            LocalDate localDate = null;
            if (dateValue != null) {
                localDate = dateValue.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (localDate.isAfter(LocalDate.now())) {
                    JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede ser mayor que la fecha actual.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            int response = JOptionPane.showConfirmDialog(null, "¿Deseas registrarte?", "Confirmación de registro", JOptionPane.YES_NO_OPTION);
            
            if (response == JOptionPane.YES_OPTION) {
                try {
                    UserDTO user = new UserDTO();
                    AddresDTO address = new AddresDTO();
                    
                    user.setUser(txtUser.getText());
                    user.setPhone(txtNumber.getText());
                    user.setPassword(txtPas.getText());
                    user.setBirthDate(localDate);
                    user.setCreatedAt(LocalDateTime.now());
                    user.setGender((String) gener.getSelectedItem());
                    Icon icon = jButton3.getIcon();
                    if (icon instanceof ImageIcon) {
                        BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
                        Graphics g = bufferedImage.createGraphics();
                        icon.paintIcon(null, g, 0, 0);
                        g.dispose();
                        
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(bufferedImage, "png", baos);
                        baos.flush();
                        byte[] profileImageBytes = baos.toByteArray();
                        baos.close();
                        
                        user.setProfileImage(profileImageBytes);
                    } else {
                        throw new IllegalArgumentException("Icono del botón no es un ImageIcon");
                    }
                    
                    address.setStreet(txtStreet.getText());
                    address.setCity("Cd. Obregon");
                    address.sethNumber(txtHnumber.getText());
                    address.setCountry(txtC.getText());
                    address.setZipCode(txtCode.getText());
                    String coordsText = txtCoords.getText().trim();
                    String[] coordsArray = coordsText.split(",");
                    
                    if (coordsArray.length != 2) {
                        JOptionPane.showMessageDialog(null, "El formato de las coordenadas debe ser 'latitud, longitud'.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    try {
                        Double latitude = Double.valueOf(coordsArray[0].trim());
                        Double longitude = Double.valueOf(coordsArray[1].trim());
                        address.setLatitude(latitude);
                        address.setLongitude(longitude);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Las coordenadas deben ser valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    user.setAddres(address);
                    user.setContactosDTO(null);
                    System.out.println(""+user.getUser()+" "+user.getPhone()+" "+user.getBirthDate()+" "+user.getPassword()+" "+user.getGender()+" "+user.getAddres());
                    busBO.createUser(user);
                    
                    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                } catch (ExceptionService | IllegalArgumentException | IOException ex) {
                    Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        } catch (ExceptionService ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date;
    private javax.swing.JComboBox<String> gener;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCoords;
    private javax.swing.JTextField txtHnumber;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtPas;
    private javax.swing.JTextField txtStreet;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
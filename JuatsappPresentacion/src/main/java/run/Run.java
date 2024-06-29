/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package run;

import conexion.ConexionBD;
import daos.ChatDAO;
import daos.MessageDAO;
import daos.UserDAO;
import frames.Login;
import service.BusinessBO;
import service.JuastappService;

/**
 *
 * @author PC Gamer
 */
public class Run {
    public static void main(String[] args) {
        ConexionBD conexion=new ConexionBD();
        UserDAO userDAO=new UserDAO();
        MessageDAO messageDAO=new MessageDAO();
        ChatDAO chatDAO=new ChatDAO(conexion);
        JuastappService jS=new JuastappService(userDAO,messageDAO,chatDAO);
        BusinessBO bus=new BusinessBO(jS);
        Login login=new Login(bus);
        login.show();
    }
}

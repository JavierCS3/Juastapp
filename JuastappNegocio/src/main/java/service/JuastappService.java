/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import collection.Chat;
import collection.Message;
import collection.User;
import daos.ChatDAO;
import daos.MessageDAO;
import daos.UserDAO;
import dtos.ChatDTO;
import dtos.MessageDTO;
import dtos.UserDTO;
import exceptions.ExceptionPersistencia;
import exceptions.ExceptionService;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author PC Gamer
 */
public class JuastappService implements IJuastappService{

    private UserDAO userDAO;
    private MessageDAO messageDAO;
    private ChatDAO chatDAO;
    
    public JuastappService(UserDAO userDAO, MessageDAO messageDAO, ChatDAO chatDAO) {
        this.userDAO=userDAO;
        this.messageDAO=messageDAO;
        this.chatDAO=chatDAO;
    }
    
    

    @Override
    public void createMessage(MessageDTO messageDTO) throws ExceptionService{
        Message message=MessageDTO.conver(messageDTO);
        if(message!=null){
            try {
                messageDAO.createMessage(message);
            } catch (ExceptionPersistencia ex) {
                throw new ExceptionService("Error agregando Mensaje",ex);
            }
            throw new ExceptionService("El mensaje es null");
        }
    }

    @Override
    public List<MessageDTO> getAllMessagesByChat(ObjectId chatId) throws ExceptionService {
        try {
            if(chatId!=null){
            List<MessageDTO> allMessages=new ArrayList<>();
            List<Message> messages=new ArrayList<>();
            messages=messageDAO.getMessagesByChatId(chatId);
            if(messages!=null){
                for(Message messageDAO:messages){
                allMessages.add(MessageDTO.conver(messageDAO));
            }
            return allMessages;
            }
            }
        } catch (ExceptionPersistencia ex) {
            throw new ExceptionService("Error agregando Mensaje",ex);
        }
        return null;
    }

    @Override
    public void createUser(UserDTO userDTO) throws ExceptionService {
        if(userDTO!=null){
            try {
                User user=UserDTO.conver(userDTO);
                userDAO.createUser(user);
            } catch (ExceptionPersistencia ex) {
                throw new ExceptionService("Error al agregar Usuario",ex);
            }
        }else{
            System.out.println("UsuarioDTO nulo");
        }
    }

    @Override
    public UserDTO getUserById(ObjectId userDI) throws ExceptionService {
        if(userDI!=null){
            try {
                User user=userDAO.getUserById(userDI);
                UserDTO userDTO=new UserDTO();
                userDTO=UserDTO.conver(user);
                return userDTO;
            } catch (ExceptionPersistencia ex) {
                throw new ExceptionService("Error al buscar Usuario por id",ex);
            }
        }{
        System.out.println("userID es nulo");
        return null;
    }
    }

    @Override
    public UserDTO getUserByPhone(String phone) throws ExceptionService {
        if(phone!=null){
            try {
                User user=userDAO.getUserByPhoneNumber(phone);
                UserDTO userDTO=new UserDTO();
                userDTO=UserDTO.conver(user);
                return userDTO;
            } catch (ExceptionPersistencia ex) {
                throw new ExceptionService("Error al buscar Usuario por numero de telefono",ex);
            }
        }
        System.out.println("Numero de telefono es nulo");
        return null;
    }

    @Override
    public void createChat(ChatDTO chat) throws ExceptionService {
        if(chat!=null){
            try {
                Chat c=ChatDTO.conver(chat);
                chatDAO.createChat(c);
            } catch (ExceptionPersistencia ex) {
                throw new ExceptionService("Error al agregar chat",ex);
            }
        }
        System.out.println("El chat es nulo");
    }
    
    
    
    
}

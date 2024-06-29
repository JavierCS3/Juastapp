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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 * Clase que implementa los metodos de la interface Service
 * @author PC Gamer
 */
public class JuastappService implements IJuastappService{

    private UserDAO userDAO;
    private MessageDAO messageDAO;
    private ChatDAO chatDAO;
    private ObjectId id;
    
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
        System.out.println("El chat es nulo: "+chat);
    }

    @Override
    public void updateChat(ChatDTO chat) throws ExceptionService {
        if(chat!=null){
            try {
                Chat c=new Chat();
                c=ChatDTO.conver(chat);
                chatDAO.updateChat(c);
            } catch (ExceptionPersistencia ex) {
                throw new ExceptionService("Error al actualizar el chat",ex);
            }
        }System.out.println("El chatDTO es nulo: "+chat);
    }

    @Override
    public void deleteChatById(ObjectId chatId) throws ExceptionService {
        if(chatId!=null){
            try {
                messageDAO.deleteMessagesByChatId(chatId);
                
                chatDAO.deleteChat(chatId);
            } catch (ExceptionPersistencia ex) {
                throw new ExceptionService("Error al eliminar el chat",ex);
            }
        }
        System.out.println("El id del chat es nulo: "+chatId);
    }
    
    /**
     *  Metodo que elimana el Mensaje por id
     * @param messageId id del mensaje
     * @throws ExceptionService Excepcion de la capa negocio
     */
    @Override
    public void deleteMessageById(ObjectId messageId) throws ExceptionService {
        if(messageId!=null){
            try {
                messageDAO.deleteMessage(messageId);
            } catch (ExceptionPersistencia ex) {
                throw new ExceptionService("Error al eliminar el mensaje",ex);
            }
        }
        System.out.println("El id del mensaje es nulo");
    }

    @Override
    public void updateMessage(MessageDTO message) throws ExceptionService {
        if(message!=null){
            try {
                Message m=new Message();
                m=MessageDTO.conver(message);
                messageDAO.updateMessage(m);
            } catch (ExceptionPersistencia ex) {
                throw new ExceptionService("Error al eliminar el mensaje",ex);
            }
        }
    }

    @Override
    public UserDTO login(String phoneNumber, String password) throws ExceptionService {
        if(phoneNumber!=null && password!=null){
            try {
                System.out.println(phoneNumber+" "+password);
                User user=userDAO.login(phoneNumber, password);
                System.out.println(user.getId());
                UserDTO userDTO= UserDTO.conver(user);
                
                setId(userDTO.getId());
                return userDTO;
            } catch (ExceptionPersistencia ex) {
                throw new ExceptionService("Error al iniciar sesion",ex);
            }
        }else{
            throw new ExceptionService("No pueden ser nulo "+phoneNumber+" "+password);
        }
    }

    @Override
    public ObjectId getId() {
        return id;
    }

    @Override
    public void setId(ObjectId id) {
        this.id = id;
    }
    
    /**
     *
     * @param user
     */
    @Override
    public void updateUser(UserDTO user) throws ExceptionService{
        if(user!=null){
            try {
                User userD=UserDTO.conver(user);
                userDAO.updateUser(userD);
            } catch (ExceptionPersistencia ex) {
                throw new ExceptionService("Error al guardar sesion",ex);
            }
        }
    }
}

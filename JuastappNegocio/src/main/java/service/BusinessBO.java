/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dtos.ChatDTO;
import dtos.MessageDTO;
import dtos.UserDTO;
import exceptions.ExceptionService;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que implementa los metodos de la interface IControllerBusiness
 * @author PC Gamer
 */
public class BusinessBO implements IControllerBusiness{
    private JuastappService service;

    public BusinessBO(JuastappService service) {
        this.service = service;
    }
    
    @Override
    public void createUser(UserDTO userDTO) throws ExceptionService {
        if(userDTO!=null){
         service.createUser(userDTO);   
        }
        throw new ExceptionService("Usuario nulo");
    }

    @Override
    public UserDTO getUserById(ObjectId userDI) throws ExceptionService {
        if(userDI!=null){
        return service.getUserById(userDI);
        }
        throw new ExceptionService("El id es nulo");
    }

    @Override
    public UserDTO getUserByPhone(String phone) throws ExceptionService {
        if(phone!=null){
            return service.getUserByPhone(phone);
        }
        throw new ExceptionService("El numeor de telefono es nulo");
    }

    @Override
    public void createMessage(MessageDTO messageDTO) throws ExceptionService {
        if(messageDTO!=null){
            service.createMessage(messageDTO);
        }
        throw new ExceptionService("El mesaje es nulo");
    }

    @Override
    public List<MessageDTO> getAllMessagesByChat(ObjectId chatId) throws ExceptionService {
        if(chatId!=null){
            return service.getAllMessagesByChat(chatId);
        }
        throw new ExceptionService("El chatId es nulo");
    }

    @Override
    public void createChat(ChatDTO chat) throws ExceptionService {
        if(chat!=null){
            service.createChat(chat);
        }
        throw new ExceptionService("El chat es nulo");
    }

    @Override
    public void updateChat(ChatDTO chat) throws ExceptionService {
        if(chat!=null){
            service.updateChat(chat);
        }
        throw new ExceptionService("El chat es nulo");
    }

    @Override
    public void deleteChatById(ObjectId chatId) throws ExceptionService {
        if(chatId!=null){
            service.deleteChatById(chatId);
        }
        throw new ExceptionService("El chatId es nulo");
    }

    @Override
    public void updateMessage(MessageDTO message) throws ExceptionService {
        if(message!=null){
            service.updateMessage(message);
        }
        throw new ExceptionService("El mensaje es nulo");
    }

    @Override
    public void deleteMessageById(ObjectId messageId) throws ExceptionService {
        if(messageId!=null){
            service.deleteMessageById(messageId);
        }
        throw new ExceptionService("El mesajeId es nulo");
    }
}

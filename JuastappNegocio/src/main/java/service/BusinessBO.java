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

    
    /**
     *  Metodo para logger el usuario por numero telefonico y contraseña
     * @param phoneNumber Numero de telefono
     * @param password Contraseña
     * @return UsuarioDTO
     * @throws ExceptionService
     */
    @Override
    public UserDTO login(String phoneNumber, String password) throws ExceptionService{
        if(phoneNumber!=null && password!=null){
            return service.login(phoneNumber, password);
        }
        throw new ExceptionService("No pueden ser nulo");
    }
    
    
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

    @Override
    public ObjectId getId() {
        return service.getId();
    }

    @Override
    public void setId(ObjectId id) {
        service.setId(id);
    }
    
    @Override
    public void updateUser(UserDTO user) throws ExceptionService{
        service.updateUser(user);
    }
    
    /**
    * Obtiene todos los chats en los que participan todos los usuarios especificados.
    * @param participantIds Lista de identificadores de participantes.
    * @return Lista de chats en los que participan todos los usuarios especificados.
    * @throws ExceptionService Excepcion de la capa negocio
    */
    @Override
   public List<ChatDTO> getChatsByParticipants(List<ObjectId> participantIds) throws ExceptionService{
       return service.getChatsByParticipants(participantIds);
   }
   
    /**
     *
     * @param id
     * @return
     * @throws ExceptionService
     */
    @Override
    public List<ChatDTO> getChatByUser(ObjectId id)throws ExceptionService{
        return service.getChatByUser(id);
    }
    
}

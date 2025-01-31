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
    
    
    /**
     * Método para acceder a los métodos de  JuastappService
     * @param service recibe un objeto de la clase JuastappService
     * 
     */
    public BusinessBO(JuastappService service) {
        this.service = service;
    }
    
    /**
     * Método para crear un usuario
     * @param userDTO recibe un objeto de la clase userDTO
     * @throws ExceptionService 
     */
    @Override
    public void createUser(UserDTO userDTO) throws ExceptionService {
        if(userDTO!=null){
         service.createUser(userDTO);   
        }
    }
    
    /**
     * Método para obtener un usuario por id
     * @param userDI objeto de la clase ObjectID
     * @return regresa el usuario con id
     * @throws ExceptionService 
     * 
     */
    @Override
    public UserDTO getUserById(ObjectId userDI) throws ExceptionService {
        if(userDI!=null){
        return service.getUserById(userDI);
        }
        throw new ExceptionService("El id es nulo");
    }

    /**
     * Método que obtiene un usuario por teléfono
     * @param phone telefono para buscar
     * @return regresa el teléfono por usuario
     * @throws ExceptionService 
     * 
     */
    @Override
    public UserDTO getUserByPhone(String phone) throws ExceptionService {
        if(phone!=null){
            return service.getUserByPhone(phone);
        }
        return null;
    }

    /**
     * Método para crear un mensaje
     * @param messageDTO objeto de la clase MessageDTO
     * @throws ExceptionService 
     * 
     */
    @Override
    public void createMessage(MessageDTO messageDTO) throws ExceptionService {
        if(messageDTO!=null){
            service.createMessage(messageDTO);
        }
    }

    /**
     * Método para obtener todos los mensajes del chat
     * @param chatId id del chat
     * @return regresa los mensajes
     * @throws ExceptionService 
     */
    @Override
    public List<MessageDTO> getAllMessagesByChat(ObjectId chatId) throws ExceptionService {
        if(chatId!=null){
            return service.getAllMessagesByChat(chatId);
        }
        throw new ExceptionService("El chatId es nulo");
    }

    /**
     * Método para crear un chat
     * @param chat objeto de la clase ChatDTO
     * @throws ExceptionService 
     * 
     * 
     */
    @Override
    public void createChat(ChatDTO chat) throws ExceptionService {
        if(chat!=null){
            service.createChat(chat);
        }
    }

    /**
     * Actualiza un chat 
     * @param chat recbin un objeto tipo ChatDTO
     * @throws ExceptionService
     * 
     */
    @Override
    public void updateChat(ChatDTO chat) throws ExceptionService {
        if(chat!=null){
            service.updateChat(chat);
        }
    }

    /**
     * Método para eliminar un chat por id
     * @param chatId id de l chat
     * @throws ExceptionService
     * 
     */
    @Override
    public void deleteChatById(ObjectId chatId) throws ExceptionService {
        if(chatId!=null){
            service.deleteChatById(chatId);
        }
    }

    /**
     * Método para actualizar un mensaje
     * @param message Recibe un objeto de la clase MessageDTO
     * @throws ExceptionService 
     * 
     */
    @Override
    public void updateMessage(MessageDTO message) throws ExceptionService {
        if(message!=null){
            service.updateMessage(message);
        }
    }

    /**
     * Eliminar mensaje por medio de un id
     * @param messageId recibe un objeto de la clase ObjectId
     * @throws ExceptionService 
     * 
     */
    @Override
    public void deleteMessageById(ObjectId messageId) throws ExceptionService {
        if(messageId!=null){
            service.deleteMessageById(messageId);
        }
    }

    /**
     * Método para obtener un id
     * @return regresa el id
     */
    @Override
    public ObjectId getId() {
        return service.getId();
    }

    /**
     * Método para asginar un id
     * @param id id a asignar
     */
    @Override
    public void setId(ObjectId id) {
        service.setId(id);
    }
    
    /**
     * Método para actualizar un usuario
     * @param user recibe un objeto de la clase UserDTO
     * @throws ExceptionService lanza una excepción tipo ExceptionService
     */
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
     * @param id del chat
     * @return regrea el chat del usuario
     * @throws ExceptionService
     */
    @Override
    public List<ChatDTO> getChatByUser(ObjectId id)throws ExceptionService{
        return service.getChatByUser(id);
    }
    
    /**
     * Actualiza los contactos del usuario
     * @param user usuario para obtener sus contactos
     * @throws ExceptionService lanza una excepción tipo servicio
     */
    @Override
    public void updateUserContacts(UserDTO user) throws ExceptionService{
        service.updateUserContacts(user);
    }

    @Override
    public ChatDTO getChatById(ObjectId id) throws ExceptionService {
        return service.getChatById(id);
    }
}

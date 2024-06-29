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
 *  Interface que conecta las consultas de la capa persistence con la capa business
 * @author PC Gamer
 */
public interface IJuastappService {
    
    /**
     *  Metodo para logger el usuario por numero telefonico y contraseña
     * @param phoneNumber Numero de telefono
     * @param password Contraseña
     * @return UsuarioDTO
     * @throws ExceptionService
     */
    public UserDTO login(String phoneNumber, String password) throws ExceptionService;
    
    /**
     *  Metodo que crea un usuario
     * @param userDTO Usuario que se quiere crear
     * @throws exceptions.ExceptionService Excepcion de la capa negocio
     */
    public void createUser(UserDTO userDTO) throws ExceptionService;
    
    /**
     *  Metodo que obtiene el usuario por id
     * @param userDI Id del usuario
     * @return Usuario encontrado 
     * @throws ExceptionService Excepcion de la capa negocio
     */
    public UserDTO getUserById(ObjectId userDI) throws ExceptionService;
    
    /**
     *  Metodo que obtiene el usuario por numero de telefono
     * @param phone numero del telefono
     * @return Usuario que encontro por numero de telefono
     * @throws ExceptionService Excepcion de la capa negocio
     */
    public UserDTO getUserByPhone(String phone) throws ExceptionService;
    
    /**
     *  Metodo que crea un mensaje
     * @param messageDTO Mensaje que se quiere crear
     * @throws exceptions.ExceptionService Excepcion de la capa negocio
     */
    public void createMessage(MessageDTO messageDTO) throws ExceptionService;

    /**
     *  Metodo que Obtiene todos los mensajes del chat
     * @param chatId id del chat
     * @return Lista de todos los mensajes del chat
     * @throws ExceptionService Excepcion de la capa negocio
     */
    public List<MessageDTO> getAllMessagesByChat(ObjectId chatId) throws ExceptionService;
    
    /**
     *  Metodo que agrega un chat
     * @param chat Chat que se quiere agregar
     * @throws ExceptionService Excepcion de la capa negocio
     */
    public void createChat(ChatDTO chat) throws ExceptionService;
    
    /**
     *  Metodo que actualiza el chat
     * @param chat Que se quiere remplazar
     * @throws ExceptionService Excepcion de la capa negocio
     */
    public void updateChat(ChatDTO chat) throws ExceptionService;
    
    /**
     *  Metodo que elimina el chat por id
     * @param chatId id del chat a eliminar
     * @throws ExceptionService Excepcion de la capa negocio
     */
    public void deleteChatById(ObjectId chatId)throws ExceptionService;
    
    /**
     *  Metodo que elimana el Mensaje por id
     * @param messageId id del mensaje
     * @throws ExceptionService Excepcion de la capa negocio
     */
    public void deleteMessageById(ObjectId messageId)throws ExceptionService;
    
    /**
     *  Metodo que actualiza el mensagge
     * @param message mensaje actualizado
     * @throws ExceptionService Excepcion de la capa negocio
     */
    public void updateMessage(MessageDTO message) throws ExceptionService;
    
    /**
     *
     * @return
     */
    public ObjectId getId();

    /**
     *
     * @param id
     */
    public void setId(ObjectId id);
    
    /**
     *
     * @param user
     * @throws exceptions.ExceptionService
     */
    public void updateUser(UserDTO user) throws ExceptionService;
}

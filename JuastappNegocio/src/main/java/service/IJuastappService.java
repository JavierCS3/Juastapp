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
 *
 * @author PC Gamer
 */
public interface IJuastappService {
    
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
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import collection.Message;
import exceptions.ExceptionPersistencia;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz para definir operaciones CRUD con la colección de mensajes en MongoDB.
 * @author PC Gamer
 */
public interface IMessageDAO {

    /**
     * Lee todos los mensajes.
     * @return lista de mensajes
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    List<Message> readMessages() throws ExceptionPersistencia;

    /**
     * Crea un nuevo mensaje.
     * @param message mensaje a crear
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    void createMessage(Message message) throws ExceptionPersistencia;

    /**
     * Actualiza un mensaje existente.
     * @param message mensaje a actualizar
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    void updateMessage(Message message) throws ExceptionPersistencia;

    /**
     * Elimina un mensaje por su ID.
     * @param messageId ID del mensaje a eliminar
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    void deleteMessage(ObjectId messageId) throws ExceptionPersistencia;

    /**
     * Obtiene un mensaje por su ID.
     * @param messageId ID del mensaje
     * @return mensaje encontrado o null si no existe
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    Message getMessageById(ObjectId messageId) throws ExceptionPersistencia;

    /**
     * Obtiene todos los mensajes de un chat por su ID.
     * @param chatId ID del chat
     * @return lista de mensajes del chat
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    List<Message> getMessagesByChatId(ObjectId chatId) throws ExceptionPersistencia;

    /**
     * Obtiene todos los mensajes enviados por un usuario por su ID.
     * @param senderId ID del usuario
     * @return lista de mensajes enviados por el usuario
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    List<Message> getMessagesBySenderId(ObjectId senderId) throws ExceptionPersistencia;
    
    /**
     * Metodo que elimina todos los mensajes del chat
     * @param chatId el id del chat
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    public void deleteMessagesByChatId(ObjectId chatId) throws ExceptionPersistencia;
}

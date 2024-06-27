/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import collection.Chat;
import exceptions.ExceptionPersistencia;
import org.bson.types.ObjectId;
import java.util.List;

/**
 * Interfaz que define las operaciones básicas de acceso a datos para la entidad Chat.
 * @author PC Gamer
 */
public interface IChatDAO {

    /**
     * Lee todos los chats almacenados.
     * @return Lista de todos los chats
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    List<Chat> readChats() throws ExceptionPersistencia;

    /**
     * Crea un nuevo chat.
     * @param chat Objeto Chat a crear.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    void createChat(Chat chat) throws ExceptionPersistencia;

    /**
     * Actualiza un chat existente.
     * @param chat Objeto Chat con los datos actualizados.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    void updateChat(Chat chat) throws ExceptionPersistencia;

    /**
     * Elimina un chat por su identificador.
     * @param chatId Identificador del chat a eliminar.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    void deleteChat(ObjectId chatId) throws ExceptionPersistencia;

    /**
     * Obtiene un chat por su identificador.
     * @param chatId Identificador del chat.
     * @return Objeto Chat encontrado o null si no existe.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    Chat getChatById(ObjectId chatId) throws ExceptionPersistencia;

    /**
     * Obtiene todos los chats en los que participa un usuario.
     * @param userId Identificador del usuario.
     * @return Lista de chats en los que participa el usuario.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    List<Chat> getChatsByUserId(ObjectId userId) throws ExceptionPersistencia;

}

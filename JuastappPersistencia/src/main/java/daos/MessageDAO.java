/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import collection.Message;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import conexion.ConexionBD;
import exceptions.ExceptionPersistencia;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase concreta que implementa la interfaz IMessageDAO para manejar operaciones CRUD con la colección de mensajes en MongoDB.
 * @author PC Gamer
 */
public class MessageDAO implements IMessageDAO {

    private final MongoDatabase database;
    private final MongoCollection<Message> messageCollection;

    /**
     * Constructor que inicializa la conexión a la base de datos y obtiene la colección de mensajes.
     * Se utiliza la clase ConexionBD para obtener la base de datos.
     */
    public MessageDAO() {
        ConexionBD conexionBD = new ConexionBD();
        this.database = conexionBD.getDatabase();
        this.messageCollection = database.getCollection("messages", Message.class);
    }

    /**
     * Lee todos los mensajes.
     * @return lista de mensajes
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public List<Message> readMessages() throws ExceptionPersistencia {
        try {
            List<Message> messages = new ArrayList<>();
            messageCollection.find().into(messages);
            return messages;
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al leer los mensajes: " + e.getMessage());
        }
    }

    /**
     * Crea un nuevo mensaje.
     * @param message mensaje a crear
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public void createMessage(Message message) throws ExceptionPersistencia {
        try {
            messageCollection.insertOne(message);
            System.out.println("Mensaje creado: " + message.getId());
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al crear el mensaje: " + e.getMessage());
        }
    }

    /**
     * Actualiza un mensaje existente.
     * @param message mensaje a actualizar
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public void updateMessage(Message message) throws ExceptionPersistencia {
        try {
            ObjectId messageId = message.getId();
            messageCollection.replaceOne(Filters.eq("_id", messageId), message);
            System.out.println("Mensaje actualizado: " + messageId);
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al actualizar el mensaje: " + e.getMessage());
        }
    }

    /**
     * Elimina un mensaje por su ID.
     * @param messageId ID del mensaje a eliminar
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public void deleteMessage(ObjectId messageId) throws ExceptionPersistencia {
        try {
            messageCollection.deleteOne(Filters.eq("_id", messageId));
            System.out.println("Mensaje eliminado: " + messageId);
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al eliminar el mensaje: " + e.getMessage());
        }
    }

    /**
     * Obtiene un mensaje por su ID.
     * @param messageId ID del mensaje
     * @return mensaje encontrado o null si no existe
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public Message getMessageById(ObjectId messageId) throws ExceptionPersistencia {
        try {
            return messageCollection.find(Filters.eq("_id", messageId)).first();
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al obtener el mensaje por ID: " + e.getMessage());
        }
    }

    /**
     * Obtiene todos los mensajes de un chat por su ID.
     * @param chatId ID del chat
     * @return lista de mensajes del chat
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public List<Message> getMessagesByChatId(ObjectId chatId) throws ExceptionPersistencia {
        try {
            List<Message> chatMessages = new ArrayList<>();
            messageCollection.find(Filters.eq("chatId", chatId)).into(chatMessages);
            return chatMessages;
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al obtener los mensajes por ID de chat: " + e.getMessage());
        }
    }

    /**
     * Obtiene todos los mensajes enviados por un usuario por su ID.
     * @param senderId ID del usuario
     * @return lista de mensajes enviados por el usuario
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public List<Message> getMessagesBySenderId(ObjectId senderId) throws ExceptionPersistencia {
        try {
            List<Message> senderMessages = new ArrayList<>();
            messageCollection.find(Filters.eq("senderId", senderId)).into(senderMessages);
            return senderMessages;
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al obtener los mensajes por ID de remitente: " + e.getMessage());
        }
    }
}

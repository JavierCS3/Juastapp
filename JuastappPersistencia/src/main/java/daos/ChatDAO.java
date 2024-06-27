/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import collection.Chat;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import conexion.ConexionBD;
import exceptions.ExceptionPersistencia;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase concreta que implementa la interfaz IChatDAO para manejar operaciones CRUD con la colección de chats en MongoDB.
 * @author PC Gamer
 */
public class ChatDAO implements IChatDAO {

    private final MongoCollection<Chat> chatCollection;

    /**
     * Constructor que recibe una instancia de ConexionBD para inicializar el DAO.
     * @param conexion instancia de ConexionBD
     */
    public ChatDAO(ConexionBD conexion) {
        MongoDatabase database = conexion.getDatabase();
        this.chatCollection = database.getCollection("chats", Chat.class);
    }

    /**
     * Lee todos los chats almacenados.
     * @return Lista de todos los chats
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public List<Chat> readChats() throws ExceptionPersistencia {
        try {
            List<Chat> chats = new ArrayList<>();
            chatCollection.find().into(chats);
            return chats;
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al leer chats: " + e.getMessage(), e);
        }
    }

    /**
     * Crea un nuevo chat.
     * @param chat Objeto Chat a crear.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public void createChat(Chat chat) throws ExceptionPersistencia {
        try {
            chatCollection.insertOne(chat);
            System.out.println("Chat creado: " + chat.getId());
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al crear chat: " + e.getMessage(), e);
        }
    }

    /**
     * Actualiza un chat existente.
     * @param chat Objeto Chat con los datos actualizados.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public void updateChat(Chat chat) throws ExceptionPersistencia {
        try {
            ObjectId chatId = chat.getId();
            chatCollection.replaceOne(eq("_id", chatId), chat);
            System.out.println("Chat actualizado: " + chatId);
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al actualizar chat: " + e.getMessage(), e);
        }
    }

    /**
     * Elimina un chat por su identificador.
     * @param chatId Identificador del chat a eliminar.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public void deleteChat(ObjectId chatId) throws ExceptionPersistencia {
        try {
            chatCollection.deleteOne(eq("_id", chatId));
            System.out.println("Chat eliminado: " + chatId);
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al eliminar chat: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene un chat por su identificador.
     * @param chatId Identificador del chat.
     * @return Objeto Chat encontrado o null si no existe.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public Chat getChatById(ObjectId chatId) throws ExceptionPersistencia {
        try {
            return chatCollection.find(eq("_id", chatId)).first();
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al obtener chat por ID: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene todos los chats en los que participa un usuario.
     * @param userId Identificador del usuario.
     * @return Lista de chats en los que participa el usuario.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public List<Chat> getChatsByUserId(ObjectId userId) throws ExceptionPersistencia {
        try {
            List<Chat> userChats = new ArrayList<>();
            chatCollection.find(in("participants", userId)).into(userChats);
            return userChats;
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al obtener chats por usuario: " + e.getMessage(), e);
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase entidad que almacena la coleccion chats
 * @author PC Gamer
 */
public class Chat {
    private ObjectId id;
    private String chatName;
    private byte[] chatImage;
    private List<Participant> participants;
    private Date createdAt;

    /**
     * 
     * Constructor por omision
     */
    public Chat() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase Chat
     * @param chatName Nombre del chat
     * @param chatImage Imagen del chat en bytes
     * @param participants Lista de IDs de los participantes del chat
     */
    public Chat(String chatName, byte[] chatImage, List<Participant> participants) {
        this.chatName = chatName;
        this.chatImage = chatImage;
        this.participants = participants;
        this.createdAt = new Date();
    }

    /**
     * 
     * Método para obtener un id
     * 
     * @return regresa el id
     * 
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * 
     * Método para asignas un id
     * 
     * @param id id del chat
     * 
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * 
     * Método para obtener el nombre del chat
     * 
     * @return regresa el chat
     */
    public String getChatName() {
        return chatName;
    }

    
    /**
     * 
     * Método para asignar nombre a un chat
     * 
     * @param chatName nombre del chat
     * 
     */
    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    /**
     * Get imagen del chat
     * @return imagen del chat
     */
    public byte[] getChatImage() {
        return chatImage;
    }

    /**
     * Set imagen del chat
     * @param chatImage imagen del chat
     */
    public void setChatImage(byte[] chatImage) {
        this.chatImage = chatImage;
    }

    /**
     * 
     * Obtiene la lista de los participantes
     * 
     * @return regresa la lista con los participantes
     * 
     */
    public List<Participant> getParticipants() {
        return participants;
    }

    /**
     * Método para asignar los participantes
     * 
     * @param participants recibe una lista de los participantes
     * 
     */
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    /**
     * 
     * Tiempo cuando se crea el chat
     * 
     * @return regresa el chat creado
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * Método para asignar un hora al chat
     * 
     * @param createdAt hora para crear el chat
     * 
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

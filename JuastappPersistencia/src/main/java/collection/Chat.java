/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.time.LocalDateTime;
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
    private List<ObjectId> participants;
    private LocalDateTime createdAt;

    public Chat() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase Chat
     * @param chatName Nombre del chat
     * @param chatImage Imagen del chat en bytes
     * @param participants Lista de IDs de los participantes del chat
     */
    public Chat(String chatName, byte[] chatImage, List<ObjectId> participants) {
        this.chatName = chatName;
        this.chatImage = chatImage;
        this.participants = participants;
        this.createdAt = LocalDateTime.now();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getChatName() {
        return chatName;
    }

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

    public List<ObjectId> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ObjectId> participants) {
        this.participants = participants;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

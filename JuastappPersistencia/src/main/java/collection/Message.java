/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;

/**
 * Clase que representa un mensaje en un chat.
 * 
 */
public class Message {
    private ObjectId id;
    private ObjectId chatId;
    private ObjectId senderId;
    private String text;
    private byte[] image;
    private LocalDateTime timestamp;

    /**
     * Constructor por defecto.
     */
    public Message() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase Message.
     * @param chatId ID del chat al que pertenece el mensaje.
     * @param senderId ID del usuario que envía el mensaje.
     * @param text Texto del mensaje.
     * @param image Imagen del mensaje en formato de byte array.
     */
    public Message(ObjectId chatId, ObjectId senderId, String text, byte[] image) {
        this.chatId = chatId;
        this.senderId = senderId;
        this.text = text;
        this.image = image;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Obtiene el ID del mensaje.
     * @return ID del mensaje.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del mensaje.
     * @param id ID del mensaje.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el ID del chat al que pertenece el mensaje.
     * @return ID del chat.
     */
    public ObjectId getChatId() {
        return chatId;
    }

    /**
     * Establece el ID del chat al que pertenece el mensaje.
     * @param chatId ID del chat.
     */
    public void setChatId(ObjectId chatId) {
        this.chatId = chatId;
    }

    /**
     * Obtiene el ID del usuario que envía el mensaje.
     * @return ID del usuario.
     */
    public ObjectId getSenderId() {
        return senderId;
    }

    /**
     * Establece el ID del usuario que envía el mensaje.
     * @param senderId ID del usuario.
     */
    public void setSenderId(ObjectId senderId) {
        this.senderId = senderId;
    }

    /**
     * Obtiene el texto del mensaje.
     * @return Texto del mensaje.
     */
    public String getText() {
        return text;
    }

    /**
     * Establece el texto del mensaje.
     * @param text Texto del mensaje.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Obtiene la imagen del mensaje.
     * @return Imagen del mensaje en formato de byte array.
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Establece la imagen del mensaje.
     * @param image Imagen del mensaje en formato de byte array.
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * Obtiene la fecha y hora en la que se creó el mensaje.
     * @return Fecha y hora en la que se creó el mensaje.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Establece la fecha y hora en la que se creó el mensaje.
     * @param timestamp Fecha y hora en la que se creó el mensaje.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    
}

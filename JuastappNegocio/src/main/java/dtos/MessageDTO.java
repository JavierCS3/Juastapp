/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import collection.Message;
import java.time.LocalDateTime;
import org.bson.types.ObjectId;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para mensajes.
 * Puede contener los campos relevantes que se desean transferir entre capas o sistemas.
 * Esta clase facilita la conversión entre objetos Message y MessageDTO.
 * 
 * @author PC Gamer
 */
public class MessageDTO {
    private ObjectId id;
    private ObjectId chatId;
    private ObjectId senderId;
    private String text;
    private byte[] image;
    private LocalDateTime timestamp;

    /**
     * Constructor por omisión.
     */
    public MessageDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase MessageDTO.
     * @param chatId ID del chat al que pertenece el mensaje.
     * @param senderId ID del usuario que envía el mensaje.
     * @param text Texto del mensaje.
     * @param image Imagen del mensaje en formato de byte array.
     * @param timestamp Fecha y hora de creación del mensaje.
     */
    public MessageDTO(ObjectId chatId, ObjectId senderId, String text, byte[] image, LocalDateTime timestamp) {
        this.chatId = chatId;
        this.senderId = senderId;
        this.text = text;
        this.image = image;
        this.timestamp = timestamp;
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
    
    /**
     * Convierte un objeto Message a un objeto MessageDTO.
     * @param messageDAO Objeto Message a convertir.
     * @return Objeto MessageDTO resultante de la conversión.
     */
    public static MessageDTO conver(Message messageDAO){
        MessageDTO messageDTO=new MessageDTO();
        messageDTO.setId(messageDAO.getId());
        messageDTO.setChatId(messageDAO.getChatId());
        messageDTO.setImage(messageDAO.getImage());
        messageDTO.setSenderId(messageDAO.getSenderId());
        messageDTO.setText(messageDAO.getText());
        messageDTO.setTimestamp(messageDAO.getTimestamp());
        return messageDTO;
    }
    
    /**
     * Convierte un objeto MessageDTO a un objeto Message.
     * @param messageDTO Objeto MessageDTO a convertir.
     * @return Objeto Message resultante de la conversión.
     */
    public static Message conver(MessageDTO messageDTO){
        Message messageDAO=new Message();
        messageDAO.setId(messageDTO.getId());
        messageDAO.setChatId(messageDTO.getChatId());
        messageDAO.setImage(messageDTO.getImage());
        messageDAO.setSenderId(messageDTO.getSenderId());
        messageDAO.setText(messageDTO.getText());
        messageDAO.setTimestamp(messageDTO.getTimestamp());
        return messageDAO;
    }
}

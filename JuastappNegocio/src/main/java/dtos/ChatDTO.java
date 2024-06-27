/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import collection.Chat;
import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para chats.
 * Puede contener los campos relevantes que se desean transferir entre capas o sistemas.
 * Esta clase facilita la conversión entre objetos Chat y ChatDTO.
 * 
 * @author PC Gamer
 */
public class ChatDTO {
    private ObjectId id;
    private String chatName;
    private byte[] chatImage;
    private List<ObjectId> participants;
    private LocalDateTime createdAt;

    /**
     * Constructor por omisión.
     */
    public ChatDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase ChatDTO.
     * @param chatName Nombre del chat.
     * @param chatImage Imagen del chat en formato de byte array.
     * @param participants Lista de participantes del chat representados por sus ID.
     * @param createdAt Fecha y hora de creación del chat.
     */
    public ChatDTO(String chatName, byte[] chatImage, List<ObjectId> participants, LocalDateTime createdAt) {
        this.chatName = chatName;
        this.chatImage = chatImage;
        this.participants = participants;
        this.createdAt = createdAt;
    }

    /**
     * Obtiene el ID del chat.
     * @return ID del chat.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del chat.
     * @param id ID del chat.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del chat.
     * @return Nombre del chat.
     */
    public String getChatName() {
        return chatName;
    }

    /**
     * Establece el nombre del chat.
     * @param chatName Nombre del chat.
     */
    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    /**
     * Obtiene la imagen del chat.
     * @return Imagen del chat en formato de byte array.
     */
    public byte[] getChatImage() {
        return chatImage;
    }

    /**
     * Establece la imagen del chat.
     * @param chatImage Imagen del chat en formato de byte array.
     */
    public void setChatImage(byte[] chatImage) {
        this.chatImage = chatImage;
    }

    /**
     * Obtiene la lista de participantes del chat.
     * @return Lista de participantes del chat representados por sus ID.
     */
    public List<ObjectId> getParticipants() {
        return participants;
    }

    /**
     * Establece la lista de participantes del chat.
     * @param participants Lista de participantes del chat representados por sus ID.
     */
    public void setParticipants(List<ObjectId> participants) {
        this.participants = participants;
    }

    /**
     * Obtiene la fecha y hora en la que se creó el chat.
     * @return Fecha y hora de creación del chat.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Establece la fecha y hora de creación del chat.
     * @param createdAt Fecha y hora de creación del chat.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    /**
     * Convierte un objeto Chat a un objeto ChatDTO.
     * @param chatDAO Objeto Chat a convertir.
     * @return Objeto ChatDTO resultante de la conversión.
     */
    public static ChatDTO conver(Chat chatDAO){
        ChatDTO chatDTO=new ChatDTO();
        chatDTO.setId(chatDAO.getId());
        chatDTO.setChatImage(chatDAO.getChatImage());
        chatDTO.setChatName(chatDAO.getChatName());
        chatDTO.setCreatedAt(chatDAO.getCreatedAt());
        chatDTO.setParticipants(chatDAO.getParticipants());
        return chatDTO;
    }
    
    /**
     * Convierte un objeto ChatDTO a un objeto Chat.
     * @param chatDTO Objeto ChatDTO a convertir.
     * @return Objeto Chat resultante de la conversión.
     */
    public static Chat conver(ChatDTO chatDTO){
        Chat chatDAO=new Chat();
        chatDAO.setId(chatDTO.getId());
        chatDAO.setChatImage(chatDTO.getChatImage());
        chatDAO.setChatName(chatDTO.getChatName());
        chatDAO.setCreatedAt(chatDTO.getCreatedAt());
        chatDAO.setParticipants(chatDTO.getParticipants());
        return chatDAO;
    }
}

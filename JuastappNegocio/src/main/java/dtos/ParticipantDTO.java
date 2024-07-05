/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import collection.Participant;
import org.bson.types.ObjectId;

/**
 * Clase DTO que representa un participante en un chat
 * 
 * @autor PC Gamer
 */
public class ParticipantDTO {
    private ObjectId userId;
    private boolean isDeleted;

    /**
     * Constructor por omisión
     */
    public ParticipantDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase ParticipantDTO
     * @param userId Identificador del usuario participante
     * @param isDeleted Indica si el chat está eliminado para este usuario
     */
    public ParticipantDTO(ObjectId userId, boolean isDeleted) {
        this.userId = userId;
        this.isDeleted = isDeleted;
    }

    /**
     * Método para obtener el ID del usuario
     * @return regresa el ID del usuario
     */
    public ObjectId getUserId() {
        return userId;
    }

    /**
     * Método para asignar el ID del usuario
     * @param userId ID del usuario
     */
    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    /**
     * Método para obtener el estado de eliminación
     * @return regresa el estado de eliminación
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * Método para asignar el estado de eliminación
     * @param isDeleted estado de eliminación
     */
    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    public static ParticipantDTO conver(Participant participantDAO){
        ParticipantDTO participantDTO= new ParticipantDTO();
        participantDTO.setUserId(participantDAO.getUserId());
        participantDTO.setDeleted(participantDAO.isDeleted());
        return participantDTO;
    }
    
    public static Participant conver(ParticipantDTO participantDTO){
        Participant participantDAO=new Participant();
        participantDAO.setUserId(participantDTO.getUserId());
        participantDAO.setDeleted(participantDTO.isDeleted());
        return participantDAO;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import collection.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para usuarios.
 * Puede contener los campos relevantes que se desean transferir entre capas o sistemas.
 * 
 * @author PC Gamer
 */
public class UserDTO {
    private ObjectId id;
    private String user;
    private String phone;
    private String password;
    private LocalDate birthDate;
    private byte[] profileImage;
    private AddresDTO addres;
    private String gender;
    private LocalDateTime createdAt;
    private List<ObjectId> contactosDTO;

    /**
     * Constructor por omisión.
     */
    public UserDTO() {
        
    }

    /**
     * Constructor con parámetros para inicializar los campos principales.
     * @param user Nombre de usuario.
     * @param phone Número de teléfono.
     * @param password Contraseña.
     * @param birthDate Fecha de nacimiento del usuario.
     * @param profileImage Imagen de perfil (en bytes).
     * @param addres Dirección del usuario representada por un objeto AddresDTO.
     * @param gender Género del usuario.
     * @param contactosDTO Los contactos del usuario
     */
    public UserDTO(String user, String phone, String password, LocalDate birthDate, byte[] profileImage, AddresDTO addres, String gender,List<ObjectId> contactosDTO) {
        this.user = user;
        this.phone = phone;
        this.password = password;
        this.birthDate = birthDate;
        this.profileImage = profileImage;
        this.addres = addres;
        this.gender = gender;
        this.createdAt = LocalDateTime.now();
        this.contactosDTO = contactosDTO;
    }

    /**
     * Obtiene el ID del usuario.
     * @return ID del usuario.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * @param id ID del usuario a establecer.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return Nombre de usuario.
     */
    public String getUser() {
        return user;
    }

    /**
     * Establece el nombre de usuario.
     * @param user Nombre de usuario a establecer.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     * @return Número de teléfono del usuario.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Establece el número de teléfono del usuario.
     * @param phone Número de teléfono a establecer.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return Contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * @param password Contraseña a establecer.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     * @return Fecha de nacimiento del usuario.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     * @param birthDate Fecha de nacimiento a establecer.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Obtiene la imagen de perfil del usuario.
     * @return Imagen de perfil del usuario en formato de bytes.
     */
    public byte[] getProfileImage() {
        return profileImage;
    }

    /**
     * Establece la imagen de perfil del usuario.
     * @param profileImage Imagen de perfil a establecer en formato de bytes.
     */
    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * Obtiene la dirección del usuario representada por un objeto AddresDTO.
     * @return Objeto AddresDTO que representa la dirección del usuario.
     */
    public AddresDTO getAddres() {
        return addres;
    }

    /**
     * Establece la dirección del usuario representada por un objeto AddresDTO.
     * @param addres Objeto AddresDTO que representa la dirección a establecer.
     */
    public void setAddres(AddresDTO addres) {
        this.addres = addres;
    }

    /**
     * Obtiene el género del usuario.
     * @return Género del usuario.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Establece el género del usuario.
     * @param gender Género a establecer.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Obtiene la fecha y hora de creación del usuario.
     * @return Fecha y hora de creación del usuario.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Establece la fecha y hora de creación del usuario.
     * @param createdAt Fecha y hora de creación a establecer.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Obtiene todos los contactos
     * @return todos los ids de los contactos
     */
    public List<ObjectId> getContactosDTO() {
        return contactosDTO;
    }

    /**
     *  Establece los Ids de los contactos
     * @param contactosDTO los contactos que quiere settear
     */
    public void setContactosDTO(List<ObjectId> contactosDTO) {
        this.contactosDTO = contactosDTO;
    }
    
    /**
     *  Convierte un Usuario a UsuarioDTO
     * @param userDAO Usuario que se quiere convertir
     * @return UsuarioDTO convertido
     */
    public static UserDTO conver(User userDAO){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDAO.getId());
        
        userDTO.setBirthDate(userDAO.getBirthDate());
        userDTO.setCreatedAt(userDAO.getCreatedAt());
        userDTO.setUser(userDAO.getUser());
        userDTO.setPhone(userDAO.getPhone());
        userDTO.setAddres(AddresDTO.conver(userDAO.getAddress()));
        userDTO.setPassword(userDAO.getPassword());
        userDTO.setGender(userDAO.getGender());
        userDTO.setProfileImage(userDAO.getProfileImage());
        userDTO.setContactosDTO(userDAO.getContactos());
        return userDTO;
    }
    
    /**
     * Convierte un UsuarioDTO aun usuario
     * @param userDTO usuarioDTO que se quiere convertir
     * @return Usuario ya convertido
     */
    public static User conver(UserDTO userDTO){
        User userDAO = new User();
        userDAO.setId(userDTO.getId());
        userDAO.setBirthDate(userDTO.getBirthDate());
        userDAO.setCreatedAt(userDTO.getCreatedAt());
        userDAO.setUser(userDTO.getUser());
        userDAO.setPhone(userDTO.getPhone());
        userDAO.setAddress(AddresDTO.conver(userDTO.getAddres()));
        userDAO.setPassword(userDTO.getPassword());
        userDAO.setGender(userDTO.getGender());
        userDAO.setProfileImage(userDTO.getProfileImage());
        userDAO.setContactos(userDTO.getContactosDTO());
        return userDAO;
    }
    
    
}

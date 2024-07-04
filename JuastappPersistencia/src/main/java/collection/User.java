/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 * Clase para representar un usuario.
 */
public class User {
    private ObjectId id;
    private String user;
    private String phone;
    private String password;
    private LocalDate birthDate;
    private byte[] profileImage;
    private Address  address;
    private String gender;
    private LocalDateTime createdAt;
    private List<ObjectId> contactos;

    /**
     * Constructor por omisión.
     */
    public User() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase User.
     *
     * @param user        Nombre de usuario
     * @param phone       Número telefónico del usuario
     * @param profileImage Imagen de perfil en formato de arreglo de bytes
     * @param password    Contraseña del usuario
     * @param address     Dirección del usuario
     * @param gender      Género del usuario
     * @param birthDate   Fecha de nacimiento del usuario
     * @param contactos   Lista de contactos del usuario
     */
    public User(String user, String phone, byte[] profileImage, String password, Address  address, String gender, LocalDate birthDate, List<ObjectId> contactos) {
        this.user = user;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.createdAt = LocalDateTime.now();
        this.profileImage = profileImage;
        this.contactos = contactos;
    }

    // Getters and setters for all fields (omitted for brevity)

    /**
     * Método para obtener un id
     * @return regresa el id obtenido
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * método para asignar un id
     * @param id id a asignar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método para obtener un usuario
     * @return regresa el usuario obtenido
     * 
     */
    public String getUser() {
        return user;
    }

    /**
     * 
     * 
     * Método para asignar un usuario
     * @param user usuario a asignar
     * 
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Método para obtener un teléfono
     * @return regresa el teléfono
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Asigna un teléfono 
     * @param phone teléfono a asignar
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Método para obtener una contraseña
     * @return regresa la contraseña
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método para asignar una contraseña
     * @param password contraseña a asignar
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método para obtener una fecha de nacimiento
     * @return regresa la fecha de nacimiento
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Asigna una fecha de nacimiento
     * @param birthDate fecha de nacimiento a asignar
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Método para obtener una foto de perfil
     * @return regresa la foto de perfil
     */
    public byte[] getProfileImage() {
        return profileImage;
    }

    /**
     * Método para asignar una foto de perfil
     * @param profileImage foto de perfil a asignar
     */
    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * Método para obtener una dirección
     * @return regresa la dirección 
     */
    public Address  getAddress() {
        return address;
    }

    /**
     * Método para asignar una dirección
     * @param address dirección a asignar
     */
    public void setAddress(Address  address) {
        this.address = address;
    }

    /**
     * Método para obtener un género
     * @return regresa el género
     */
    public String getGender() {
        return gender;
    }

    /**
     * Método para obtener un género
     * @param gender género a asignar
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Método para obtener una fecha de creación
     * @return regrea la fecha de creación
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Método para asignar una fecha de creación
     * @param createdAt fecha de creado
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Método para obtener los contactos
     * @return regresa los contactos
     */
    public List<ObjectId> getContactos() {
        return contactos;
    }

    /**
     * Asigna los contactos ala lista
     * @param contactos lista de contactos
     * 
     */
    public void setContactos(List<ObjectId> contactos) {
        this.contactos = contactos;
    }
}


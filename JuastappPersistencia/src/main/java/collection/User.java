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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public Address  getAddress() {
        return address;
    }

    public void setAddress(Address  address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<ObjectId> getContactos() {
        return contactos;
    }

    public void setContactos(List<ObjectId> contactos) {
        this.contactos = contactos;
    }
}


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
 * Clase entidad que almacena la coleccion users
 * @author PC Gamer
 */
public class User {
    private ObjectId id;
    private String user;
    private String phone;
    private String password;
    private LocalDate birthDate;
    private byte[] profileImage;
    private Addres addres;
    private String gender;
    private LocalDateTime createdAt;
    private List<ObjectId> contactos;
    
    /**
     * Constructor por omision
     */
    public User(){
        
    }
    
    /**
     *  Constructor que inicializa todos los atributos de la clase User
     * @param user Usuario del user(nombre o alias)
     * @param phone Numero telefonico del usuario
     * @param profileImage Imagen de perfil del usuario en byte
     * @param password Contraseña del usuario
     * @param address Direccion de tipo address en donde almacenara la coleccion address
     * @param gender Genero del usuario
     * @param birthDate Fecha de nacimiento del usuario
     * @param contactos Contactos del usuario
     */
    public User(String user,String phone,byte[] profileImage, String password, Addres address, String gender, LocalDate birthDate,List<ObjectId> contactos){
        this.user=user;
        this.phone=phone;
        this.password=password;
        this.addres=address;
        this.gender=gender;
        this.birthDate=birthDate;
        this.createdAt=LocalDateTime.now();
        this.profileImage=profileImage;
        this.contactos = contactos;
    }

    /**
     * @return
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Set del id
     * @param id el id del usuario
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
      
    /**
     * get nombre del usuario
     * @return nombre del usuario
     */
    public String getUser() {
        return user;
    }

    /**
     * Set del nombre del usuario
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }
    
    /**
     * Get numero del usuario
     * @return numero del usuario
     */
    public String getPhone() {
        return phone;
    }

    /**
     *  Set numero del usuario
     * @param phone numero del usuario
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *  Get contraseña del usuario
     * @return contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     *  Set contraseña del usuario
     * @param password contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *  Get fecha de nacimiento del usuario
     * @return fecha de nacimiento del usuario
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     *  Set fecha de nacimiento del usuario
     * @param birthDate fecha de nacimiento del usuario
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    /**
     *  Get imagen del usuario
     * @return imagen del usuario
     */
    public byte[] getProfileImage() {
        return profileImage;
    }

    /**
     * Set imagen de perfil del usuario
     * @param profileImage imagen de perfil
     */
    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * Get Direccion de tipo Addres
     * @return Adres direccion del usuario
     */
    public Addres getAddress() {
        return addres;
    }

    /**
     * Set Direccion de tipo Addres
     * @param address Direccion del usuario de tipo addres
     */
    public void setAddress(Addres address) {
        this.addres = address;
    }

    /**
     * Set genero del usuario
     * @param gender genero del usuario
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Set genero del usuario
     * @return genero del usuario
     */
    public String getGender() {
        return gender;
    }
    
    /**
     * Get fecha en la que se creo el usuario
     * @return fecha en la que se creo el usuario
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Set fecha en la que se creo el usuario
     * @param createdAt fecha en la que se creo el usuario
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Método para obtener la direccion del usuario
     * @return regresa la dirección del usuario
     * 
     */
    public Addres getAddres() {
        return addres;
    }

    /**
     * 
     * Asigna el valor ala dirección
     * @param addres regresa la direccion del usuario
     * 
     */
    public void setAddres(Addres addres) {
        this.addres = addres;
    }

    /**
     * 
     * Método para obtener los contactos 
     * @return regresa la lista de los contactos
     */
    public List<ObjectId> getContactos() {
        return contactos;
    }

    /**
     * Asigna los contactos ala lista
     * @param contactos 
     * 
     */
    public void setContactos(List<ObjectId> contactos) {
        this.contactos = contactos;
    }
}

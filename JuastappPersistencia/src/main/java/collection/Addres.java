/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

/**
 *
 * @author PC Gamer
 */
public class Addres {
    
    
    /**
     * Creación de las variables de clase
     * 
     */
    private String street;
    private String city;
//    private String state;
    private String zipCode;
    private String country;
    private String hNumber;

    /**
     * Método constructor por omisión
     * 
     */
    public Addres() {
    }

    /**
     * 
     * Método constructor que inicializa las variables de clase
     * 
     * @param street calle del usuario
     * @param city ciudad del usuario
     * @param state estado del usuario
     * @param zipCode código postal del usuario
     * @param country pais del usuario
     * @param hNumber número de casa del usuario
     * 
     */
    public Addres(String street, String city, String state, String zipCode, String country,String hNumber) {
        this.street = street;
        this.city = city;
        this.hNumber=hNumber;
//        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    
    /**
     * 
     * Método que obtiene la 
     * calle del usuario
     * 
     * @return regresa la calle
     * 
     */
    public String getStreet() {
        return street;
    }

    /**
     * 
     * Asigna el valor ala calle del usuario
     * 
     * @param street 
     * 
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * 
     * Método que obtiene la ciudad del usuario
     * 
     * @return regresa la ciudad del usuario
     * 
     */
    public String getCity() {
        return city;
    }

    /**
     * Método para asginar una ciudad 
     * @param city ciudad a asignar
     * 
     */
    public void setCity(String city) {
        this.city = city;
    }

//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
    
    /**
     * Método para obtener el código postal
     * 
     * @return regresa el código postal
     * 
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 
     * Método para asignar el valor del código postal
     * 
     * @param zipCode 
     * 
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
//
//    public String getCountry() {
//        return country;
//    }

    /**
     * 
     * Método para obtener el número de la casa
     * del usuario
     * 
     * 
     * @return regresa el número
     * 
     * 
     */
    public String gethNumber() {
        return hNumber;
    }
    

    /**
     * 
     * Método para asignar un número de casa
     * 
     * @param hNumber número de casa a asignar
     * 
     * 
     */
    public void sethNumber(String hNumber) {
        this.hNumber = hNumber;
    }

    
    /**
     * 
     * Método para asignar un pais
     * 
     * @param country pais a asignar
     * 
     * 
     */
    public void setCountry(String country) {
        this.country = country;
    }

    
    /**
     * 
     * Método para obtener el pais del usuario
     * 
     * 
     * @return regresa el pais del usuario
     * 
     */
    public String getCountry() {
        return country;
    }
    
    
}


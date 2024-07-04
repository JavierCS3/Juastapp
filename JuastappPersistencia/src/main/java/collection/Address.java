/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

/**
 *
 * @author PC Gamer
 */
public class Address  {
    
    
    /**
     * Creación de las variables de clase
     * 
     */
     private String street;      
    private String city;        
    private String zipCode;      
    private String country;     
    private String hNumber;   
    private Coordinates coordinates;

    /**
     * Método constructor por omisión
     * 
     */
    public Address () {
    }

    /**
     * 
     * Método constructor que inicializa las variables de clase
     * 
     * @param street calle del usuario
     * @param city ciudad del usuario
     * @param zipCode código postal del usuario
     * @param country pais del usuario
     * @param hNumber número de casa del usuario
     * 
     */
    public Address (String street, String city, String zipCode, String country,String hNumber,Coordinates coordinates) {
        this.street = street;
        this.city = city;
        this.hNumber=hNumber;
        this.zipCode = zipCode;
        this.country = country;
        this.coordinates = coordinates;
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
     * @param street calle del usuario
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
     * @param zipCode código postal del usuario
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Addres{" + "street=" + street + ", city=" + city + ", zipCode=" + zipCode + ", country=" + country + ", hNumber=" + hNumber + ", coordinates=" + coordinates + '}';
    }
    
    
}


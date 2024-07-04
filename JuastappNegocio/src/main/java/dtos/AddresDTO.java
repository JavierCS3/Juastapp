/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import collection.Address;
import collection.Coordinates;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para direcciones.
 * Puede contener los campos relevantes que se desean transferir entre capas o sistemas.
 * 
 * @author PC Gamer
 */
public class AddresDTO {
    private String street;
    private String city;
    private String hNumber;
    private String country;
    private String zipCode;
    private double latitude; 
    private double longitude;

    /**
     * Constructor por omisión.
     */
    public AddresDTO() {
    }

    /**
     * Constructor con parámetros para inicializar los campos de la dirección.
     * @param street Calle de la dirección.
     * @param city Ciudad de la dirección.
     * @param country País pero lo manejamos como colonia de la dirección.
     * @param hNumber Número de casa
     * @param zipCode Código postal de la dirección.
     */
    public AddresDTO(String street, String city, String country, String hNumber,String zipCode) {
        this.street = street;
        this.city = city;
        this.hNumber=hNumber;   
        this.zipCode = zipCode;
        this.country = country;
    }

    /**
     * Obtiene la calle de la dirección.
     * @return Calle de la dirección.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Establece la calle de la dirección.
     * @param street Calle de la dirección a establecer.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Obtiene la ciudad de la dirección.
     * @return Ciudad de la dirección.
     */
    public String getCity() {
        return city;
    }

    /**
     * Establece la ciudad de la dirección.
     * @param city Ciudad de la dirección a establecer.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Método para obtener el número de casa
     * @return regresa el nñumero de casa
     */
    public String gethNumber() {
        return hNumber;
    }

    /**
     * Asignar el número de casa
     * @param hNumber número de casa a asignar
     */
    public void sethNumber(String hNumber) {
        this.hNumber = hNumber;
    }

//    /**
//     * Obtiene el estado o provincia de la dirección.
//     * @return Estado o provincia de la dirección.
//     */
//    public String getState() {
//        return state;
//    }
//
//    /**
//     * Establece el estado o provincia de la dirección.
//     * @param state Estado o provincia de la dirección a establecer.
//     */
//    public void setState(String state) {
//        this.state = state;
//    }
//
    /**
     * Obtiene el código postal de la dirección.
     * @return Código postal de la dirección.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Establece el código postal de la dirección.
     * @param zipCode Código postal de la dirección a establecer.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Obtiene el país de la dirección.
     * @return País de la dirección.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Establece el país de la dirección.
     * @param country País de la dirección a establecer.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Método para obtener la latitud
     * @return regresa la latitud
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Método para asignar la latitud
     * @param latitude latitud a asignar
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Método para obtener la longitud
     * @return regresa la longitud
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Método para asignar la longitud
     * @param longitude longitud a asignar
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    /**
    * Convierte un objeto de tipo AddresDAO a un objeto de tipo AddresDTO.
    * @param addresDAO Objeto AddresDAO a convertir.
    * @return Objeto AddresDTO resultante de la conversión.
    */
    public static AddresDTO conver(Address addresDAO){
        AddresDTO addresDTO =new AddresDTO();
        addresDTO.sethNumber(addresDAO.gethNumber());
        addresDTO.setStreet(addresDAO.getStreet());
        addresDTO.setCity(addresDAO.getCity());
        addresDTO.setCountry(addresDTO.getCountry());
        addresDTO.setZipCode(addresDAO.getZipCode());
        if(addresDAO.getCoordinates()!=null){
            addresDTO.setLatitude(addresDAO.getCoordinates().getLatitude());
        addresDTO.setLongitude(addresDAO.getCoordinates().getLongitude());
        }
        return addresDTO;
    }
    
    /**
    * Convierte un objeto de tipo AddresDTO a un objeto de tipo AddresDAO.
    * @param addresDTO Objeto AddresDTO a convertir.
    * @return Objeto AddresDAO resultante de la conversión.
    */
    public static Address  conver(AddresDTO addresDTO){
        Address  addresDAO =new Address();
        addresDAO.sethNumber(addresDTO.gethNumber());
        addresDAO.setStreet(addresDTO.getStreet());
        addresDAO.setCity(addresDTO.getCity());
        addresDAO.setCountry(addresDTO.getCountry());
        addresDAO.setZipCode(addresDTO.getZipCode());
        Coordinates coordinates=new Coordinates();
        coordinates.setLatitude(addresDTO.getLatitude());
        coordinates.setLongitude(addresDTO.getLongitude());
        addresDAO.setCoordinates(coordinates);
        return addresDAO;
    }
    
    
}

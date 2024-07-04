/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

/**
 * Clase para representar las coordenadas geográficas.
 */
public class Coordinates {
    
    /**
     * Declaración de variables
     */
    private double latitude;
    private double longitude;

    /**
     * Constructor por omision
     */
    public Coordinates() {
    }

    /**
     * Método constructor que inicializa las variables de clase
     * @param latitude latitud de las coordenadas
     * @param longitude longituda de las coordenadas
     */
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Método para obtener la latitud
     * @return regresa la latitud de la coordenada
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Asigna la latitud de la coordenada
     * @param latitude latitud para asignar
     * 
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Obtiene la longitud de la coordenada
     * @return regresa la longitud
     * 
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Asigna la longitud de la coordenada
     * @param longitude longitud a asignar
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Método para regresar las coordenadas
     * @return regresa las coordenadas
     */
    @Override
    public String toString() {
        return "Coordinates{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

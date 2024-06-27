/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 * Clase para manejar excepciones específicas de servicios o capas de aplicación.
 * Puedes extender esta clase para crear excepciones más específicas según tus necesidades.
 * 
 * Ejemplo de uso:
 * throw new ExceptionService("Mensaje de error");
 * 
 * @author PC Gamer
 */
public class ExceptionService extends Exception {

    /**
     * Constructor que recibe un mensaje de error.
     * @param message Mensaje descriptivo del error.
     */
    public ExceptionService(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje de error y una causa subyacente.
     * @param message Mensaje descriptivo del error.
     * @param cause Causa subyacente que originó la excepción.
     */
    public ExceptionService(String message, Throwable cause) {
        super(message, cause);
    }
}

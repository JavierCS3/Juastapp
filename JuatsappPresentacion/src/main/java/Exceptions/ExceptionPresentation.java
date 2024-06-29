/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 * Clase ExceptionPresentation que extiende Exception para manejar errores específicos en la capa de presentación.
 * @author PC Gamer
 */
public class ExceptionPresentation extends Exception {

    /**
     * Constructor por defecto.
     */
    public ExceptionPresentation() {
        super();
    }

    /**
     * Constructor que acepta un mensaje de error.
     * @param message Mensaje de error.
     */
    public ExceptionPresentation(String message) {
        super(message);
    }

    /**
     * Constructor que acepta una causa.
     * @param cause Causa del error.
     */
    public ExceptionPresentation(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que acepta un mensaje de error y una causa.
     * @param message Mensaje de error.
     * @param cause Causa del error.
     */
    public ExceptionPresentation(String message, Throwable cause) {
        super(message, cause);
    }
}

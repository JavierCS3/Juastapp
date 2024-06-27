/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 * Excepción personalizada para problemas de persistencia en la capa de datos.
 * Puede ser lanzada cuando ocurren errores relacionados con operaciones de base de datos.
 */
public class ExceptionPersistencia extends Exception {

    /**
     * Constructor que acepta un mensaje de error.
     * @param mensaje mensaje descriptivo del error
     */
    public ExceptionPersistencia(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor que acepta un mensaje de error y la causa subyacente.
     * @param mensaje mensaje descriptivo del error
     * @param causa causa subyacente de la excepción
     */
    public ExceptionPersistencia(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}


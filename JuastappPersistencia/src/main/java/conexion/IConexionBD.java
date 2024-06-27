/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

/**
 * Interfaz para definir métodos de conexión a la base de datos.
 */
public interface IConexionBD {

    /**
     * Establece la conexión con la base de datos.
     * @return true si la conexión se estableció correctamente, false en caso contrario.
     */
    public boolean connect();

    /**
     * Cierra la conexión con la base de datos.
     * @return true si la conexión se cerró correctamente, false en caso contrario.
     */
    public boolean close();

    /**
     * Verifica si la conexión está actualmente establecida.
     * @return true si hay una conexión activa, false si no hay conexión.
     */
    public boolean isConnected();
}

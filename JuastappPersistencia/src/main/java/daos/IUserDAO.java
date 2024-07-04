/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import collection.User;
import exceptions.ExceptionPersistencia;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz que define las operaciones CRUD para la gestión de usuarios en la base de datos.
 */
public interface IUserDAO {

    /**
    * Autentica un usuario por su número de teléfono y contraseña.
    * @param phoneNumber Número de teléfono del usuario.
    * @param password Contraseña del usuario.
    * @return Usuario autenticado o null si las credenciales no son válidas.
    * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
    */
    public User login(String phoneNumber, String password) throws ExceptionPersistencia;
    
    /**
     * Lee todos los usuarios almacenados en la base de datos.
     * @return la lista de todos los usuarios
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    public List<User> readUsers() throws ExceptionPersistencia;

    /**
     * Lee usuarios filtrados por género femenino.
     * @return la lista de los usuarios mujeres
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    public List<User> readUsersWithFilterWomens() throws ExceptionPersistencia;

    /**
     * Lee usuarios filtrados por género masculino.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    public void readUsersWithFilterMens() throws ExceptionPersistencia;

    /**
     * Crea un nuevo usuario en la base de datos.
     * @param user Usuario a crear.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    public void createUser(User user) throws ExceptionPersistencia;

    /**
     * Actualiza la información de un usuario existente en la base de datos.
     * @param user Usuario con la información actualizada.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    public void updateUser(User user) throws ExceptionPersistencia;

    /**
     * Elimina un usuario de la base de datos por su ID.
     * @param userId ID del usuario a eliminar.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    public void deleteUser(ObjectId userId) throws ExceptionPersistencia;

    /**
     * Obtiene un usuario de la base de datos por su ID.
     * @param userId ID del usuario a obtener.
     * @return Usuario encontrado o null si no existe.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    public User getUserById(ObjectId userId) throws ExceptionPersistencia;
    
    /**
    * Busca un usuario por su número de teléfono.
    * @param phoneNumber Número de teléfono del usuario a buscar.
    * @return Usuario encontrado o null si no existe.
    * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
    */
    public User getUserByPhoneNumber(String phoneNumber) throws ExceptionPersistencia;
    
    /**
     * Método para actualizar los contactos
     * @param user usuario para actualizar sus contactos
     * @throws ExceptionPersistencia lanza una excepción tipo ExceptionPersistencia
     */
    public void updateUserContacts(User user) throws ExceptionPersistencia;
}

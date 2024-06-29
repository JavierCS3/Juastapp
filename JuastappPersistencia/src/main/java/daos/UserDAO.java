/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import collection.User;
import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import conexion.ConexionBD;
import exceptions.ExceptionPersistencia;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase UserDAO que implementa los metodo de la interface IUserDAO
 * @author PC Gamer
 */
public class UserDAO implements IUserDAO{
    private final ConexionBD conexion;

    /**
     * Constructor que inicializa la conexión a la base de datos utilizando la clase ConexionBD.
     */
    public UserDAO() {
        this.conexion = new ConexionBD();
    }
    
    /**
    * Autentica un usuario por su número de teléfono y contraseña.
    * @param phoneNumber Número de teléfono del usuario.
    * @param password Contraseña del usuario.
    * @return Usuario autenticado o null si las credenciales no son válidas.
    * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
    */
   @Override
   public User login(String phoneNumber, String password) throws ExceptionPersistencia {
       try {
           System.out.println(phoneNumber+"  "+password);
           System.out.println(conexion.getDatabase().toString());
        MongoCollection<User> collection = conexion.getDatabase().getCollection("users", User.class);

        List<Bson> pipeline = Arrays.asList(
            Aggregates.match(Filters.and(
                Filters.eq("phone", phoneNumber),
                Filters.eq("password", password)
            ))
        );

        AggregateIterable<User> results = collection.aggregate(pipeline);

        User user = results.first();
        
        if (user == null) {
            System.out.println("No se encontro enconsulta");
            throw new ExceptionPersistencia("Usuario no encontrado para las credenciales proporcionadas");
        }
        
        return user;
    } catch (ExceptionPersistencia e) {
           System.out.println("Usuario");
        throw new ExceptionPersistencia("Error al autenticar usuario: " + e.getMessage(), e);
    }
   }

    /**
     * Lee todos los usuarios almacenados en la base de datos.
     * @return lista de usuarios
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public List<User> readUsers() throws ExceptionPersistencia {
        try {
            MongoCollection<User> collection = conexion.getDatabase().getCollection("users", User.class);
            List<User> userList = new ArrayList<>();
            collection.find().into(userList);
            return userList;
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al leer usuarios: " + e.getMessage(), e);
        }
    }

    /**
     * Lee usuarios filtrados por género femenino.
     * @return lista de usuarios filtrados
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public List<User> readUsersWithFilterWomens() throws ExceptionPersistencia {
        try {
            MongoCollection<User> collection = conexion.getDatabase().getCollection("users", User.class);
            Bson filter = Filters.eq("gender", "femenino");
            Bson sort = Sorts.orderBy(
                    Sorts.ascending("birthDate"),
                    Sorts.ascending("user")
            );

            List<User> userList = new ArrayList<>();
            collection.find(filter).sort(sort).into(userList);
            return userList;
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al leer usuarios filtrados por género femenino: " + e.getMessage(), e);
        }
    }

    /**
     * Lee usuarios filtrados por género masculino.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public void readUsersWithFilterMens() throws ExceptionPersistencia {
        try {
            MongoCollection<User> collection = conexion.getDatabase().getCollection("users", User.class);
            Bson filter = Filters.eq("gender", "masculino");
            Bson sort = Sorts.orderBy(
                    Sorts.ascending("birthDate"),
                    Sorts.ascending("user")
            );

            List<User> userList = new ArrayList<>();
            collection.find(filter).sort(sort).into(userList);
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al leer usuarios filtrados por género masculino: " + e.getMessage(), e);
        }
    }

    /**
     * Crea un nuevo usuario en la base de datos.
     * @param user Usuario a crear.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public void createUser(User user) throws ExceptionPersistencia {
        try {
            MongoCollection<User> collection = conexion.getDatabase().getCollection("users", User.class);
            collection.insertOne(user);
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al crear usuario: " + e.getMessage(), e);
        }
    }

    /**
     * Actualiza la información de un usuario existente en la base de datos.
     * @param user Usuario con la información actualizada.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public void updateUser(User user) throws ExceptionPersistencia {
        try {
            MongoCollection<User> collection = conexion.getDatabase().getCollection("users", User.class);
            ObjectId userId = user.getId();
            collection.replaceOne(Filters.eq("_id", userId), user);
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al actualizar usuario: " + e.getMessage(), e);
        }
    }

    /**
     * Elimina un usuario de la base de datos por su ID.
     * @param userId ID del usuario a eliminar.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public void deleteUser(ObjectId userId) throws ExceptionPersistencia {
        try {
            MongoCollection<User> collection = conexion.getDatabase().getCollection("users", User.class);
            Bson filter = Filters.eq("_id", userId);
            collection.deleteOne(filter);
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al eliminar usuario: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene un usuario de la base de datos por su ID.
     * @param userId ID del usuario a obtener.
     * @return Usuario encontrado o null si no existe.
     * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
     */
    @Override
    public User getUserById(ObjectId userId) throws ExceptionPersistencia {
        try {
            MongoCollection<User> collection = conexion.getDatabase().getCollection("users", User.class);
            Bson filter = Filters.eq("_id", userId);
            return collection.find(filter).first();
        } catch (Exception e) {
            throw new ExceptionPersistencia("Error al obtener usuario por ID: " + e.getMessage(), e);
        }
    }
    
    /**
    * Busca un usuario por su número de teléfono.
    * @param phoneNumber Número de teléfono del usuario a buscar.
    * @return Usuario encontrado o null si no existe.
    * @throws ExceptionPersistencia si ocurre un error al acceder a la base de datos
    */
   @Override
   public User getUserByPhoneNumber(String phoneNumber) throws ExceptionPersistencia {
       try {
           MongoCollection<User> collection = conexion.getDatabase().getCollection("users", User.class);
           Bson filter = Filters.eq("phone", phoneNumber);
           return collection.find(filter).first();
       } catch (Exception e) {
           throw new ExceptionPersistencia("Error al obtener usuario por número de teléfono: " + e.getMessage(), e);
       }
   }
}

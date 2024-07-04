/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * Clase de conexión a la base de datos MongoDB que implementa la interfaz IConexionBD.
 */
public class ConexionBD implements IConexionBD {

    /**
     * Creación de las variables de clase
     */
    private MongoClient mongoClient;
    private MongoDatabase database;
    private boolean connected;

    /**
     * Método constructor de la conexión
     */
    public ConexionBD() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(pojoCodecProvider)))
                .build();
        this.mongoClient = MongoClients.create(settings);
        this.database = mongoClient.getDatabase("equipo1"); 
        connected = true;
    }

    
    /**
     * Establece la conexión con la base de datos.
     * @return true si la conexión se estableció correctamente, false en caso contrario.
     */
    @Override
    public boolean connect() {
        try {
            mongoClient = MongoClients.create("mongodb://localhost:27017");
            database = mongoClient.getDatabase("equipo1"); 
            connected = true;
            return true;
        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            connected = false;
            return false;
        }
    }

    /**
     * Cierra la conexión con la base de datos.
     * @return true si la conexión se cerró correctamente, false en caso contrario.
     */
    @Override
    public boolean close() {
        try {
            if (mongoClient != null) {
                mongoClient.close();
                connected = false;
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para ver si está conectado
     * @return regresa si está contectado o no
     */
    @Override
    public boolean isConnected() {
        return connected;
    }
    
    /**
     * Obtiene el cliente MongoDB actualmente utilizado.
     * @return cliente MongoDB
     */
    public MongoClient getMongoClient() {
        return mongoClient;
    }

    /**
     * Obtiene la base de datos MongoDB actualmente conectada.
     * @return base de datos MongoDB
     */
    public MongoDatabase getDatabase() {
        return database;
    }

   
}

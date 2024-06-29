/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.JuastappPersistencia;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import conexion.ConexionBD;
import org.bson.Document;

/**
 *
 * @author PC Gamer
 */
public class Proyecto3 {

    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        MongoDatabase database = conexion.getDatabase();
        MongoCollection<Document> collection = database.getCollection("users");

        // Filtrar y obtener todos los usuarios
        FindIterable<Document> users = collection.find();

        // Iterar sobre los usuarios e imprimir cada documento
        for (Document user : users) {
            System.out.println(user.toJson());
        }
    }
}

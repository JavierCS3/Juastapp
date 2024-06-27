/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 *  Clase de utileria que maneja io para cargar las imagenes con bytes
 * @author PC Gamer
 */
public class ImageUtils {
    public static byte[] loadImage(String path) throws IOException {
        File file = new File(path);
        return Files.readAllBytes(file.toPath());
    }
}

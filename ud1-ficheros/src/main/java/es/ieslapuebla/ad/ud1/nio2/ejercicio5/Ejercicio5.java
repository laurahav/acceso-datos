package es.ieslapuebla.ad.ud1.nio2.ejercicio5;

/*
5. Crear un programa que cree un directorio llamado "UD1" en una ruta que indiques (por ejemplo,
dentro de tu carpeta de usuario) y, dentro de él, un subdirectorio llamado "EJEMPLO".
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio5 {
    static void main(String[] args) {
        try {
            Files.createDirectories(Path.of("C:/Users/laura/UD1/EJEMPLO"));
            System.out.println("Los directorios se han creado correctamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}

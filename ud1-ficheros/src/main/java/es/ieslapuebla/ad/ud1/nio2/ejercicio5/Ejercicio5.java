package es.ieslapuebla.ad.ud1.nio2.ejercicio5;

/*
5. Crear un programa que cree un directorio llamado "UD1" en una ruta que indiques (por ejemplo,
dentro de tu carpeta de usuario) y, dentro de él, un subdirectorio llamado "EJEMPLO".
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio5 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path directorio;

        do {
            System.out.println("Introduce el path de un directorio:");
            directorio = Path.of(sc.nextLine());
        } while (!Files.isDirectory(directorio));

        try {
            Files.createDirectories(directorio);
            System.out.println("Los directorios se han creado correctamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}

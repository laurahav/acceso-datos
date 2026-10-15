package es.ieslapuebla.ad.ud1.nio2.ejercicio1;

/*
1. Se pide crear un programa en Java que muestre el contenido (ficheros y subdirectorios) del
directorio actual del proyecto, usando Path y Files.
*/

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.Stream;

public class Ejercicio1 {
    static void main(String[] args) {
        Path directorioActual = Path.of(".");
        try (Stream<Path> rutas = Files.list(directorioActual)) {
            rutas.forEach(path -> System.out.println(path.getFileName()));
//            Iterator<Path> it = rutas.iterator();
//            while (it.hasNext()) {
//                Path p = it.next();
//                System.out.println(p.getFileName().toString());
//            }
        } catch (UncheckedIOException e) {
            System.out.println("Error al recorrer el árbol de carpetas: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al iniciar el recorrido: " + e.getMessage());
        }
    }
}

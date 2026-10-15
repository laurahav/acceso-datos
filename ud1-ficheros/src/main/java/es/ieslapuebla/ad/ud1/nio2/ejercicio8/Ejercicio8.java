package es.ieslapuebla.ad.ud1.nio2.ejercicio8;

/*
8. Crear un programa que muestre el listado de ficheros con extensión .xml del directorio actual del
proyecto.
*/


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ejercicio8 {
    static void main(String[] args) {
        try(Stream<Path> directorio = Files.list(Path.of("."))) {
            directorio.filter(Files::isRegularFile).filter(path -> path.toString().endsWith(".xml")).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}

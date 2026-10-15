package es.ieslapuebla.ad.ud1.nio2.ejercicio4;

/*
4. Crear un programa que pida un path y, si es un directorio, liste su contenido. Mientras no se
introduzca un path válido, el programa lo seguirá pidiendo. Es decir, debes asegurarte de que el
usuario ha introducido un path correspondiente a un directorio. Una vez validado el path, para cada
elemento dentro del directorio, el programa debe indicar si se trata de un fichero o de un directorio.
*/

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio4 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path directorio;

        do {
            System.out.println("Introduce el path de un directorio:");
            directorio = Path.of(sc.nextLine());
        } while (!Files.isDirectory(directorio));

        try(Stream<Path> rutas = Files.list(directorio)) {
            rutas.forEach(p -> System.out.printf("%s -> %s \n", p.getFileName(), Files.isDirectory(p) ? "directorio" : "fichero"));
        } catch (UncheckedIOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

    }
}

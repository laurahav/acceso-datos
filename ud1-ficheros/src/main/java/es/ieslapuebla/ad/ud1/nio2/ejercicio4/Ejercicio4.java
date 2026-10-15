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
        boolean esValido = false;
        Path directorio;

        System.out.println("Introduce el path de un directorio: ");
        do {
            String path = sc.nextLine();
            directorio = Path.of(path);
            if(!Files.exists(directorio)){
                System.out.println("El path no existe, introduce un directorio válido: ");
            }else if (Files.isRegularFile(directorio)) {
                System.out.println("El path introducido no es un directorio, inténtalo de nuevo: ");
            } else {
                esValido = true;
            }
        } while (!esValido);

        try(Stream<Path> rutas = Files.list(directorio)) {
            Iterator<Path> it = rutas.iterator();
            while(it.hasNext()) {
                Path p = it.next();
                System.out.printf("%s -> %s \n", p.getFileName(), Files.isDirectory(p) ? "directorio" : "fichero");
            }
        } catch (UncheckedIOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

    }
}

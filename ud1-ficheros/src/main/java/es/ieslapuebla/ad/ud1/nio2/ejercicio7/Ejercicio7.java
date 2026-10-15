package es.ieslapuebla.ad.ud1.nio2.ejercicio7;

/*
7. Crear un programa que borre una determinada carpeta cuyo path se introduce por teclado. Ten en
cuenta que el programa debe borrar todos los contenidos de la carpeta, es decir, debe borrarla de
manera recursiva. Pista: puedes combinar Files.walk(...) con streams, teniendo en cuenta que
un Stream<Path> se puede reordenar antes de recorrerlo con un iterador. Piensa qué orden
necesitas para no borrar una carpeta antes que su contenido.
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio7 {
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

        try(Stream<Path> carpeta = Files.walk(directorio)) {

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}

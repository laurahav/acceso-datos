package es.ieslapuebla.ejercicio1;

/*Crea un programa que reciba por teclado la ruta de un directorio.
El programa debe solicitar la ruta de manera iterativa hasta que sea válida y
corresponda a un directorio existente. Una vez validada:
1. Recorre de forma recursiva tod.o el árbol de directorios.
2. Filtra y procesa únicamente los ficheros regulares con extensión .xml o .txt,
mostrando por consola su ruta relativa y su tamaño en bytes.
3. Borra de manera recursiva todos los ficheros con extensión .tmp que se encuentren dentro del árbol.

Gestiona adecuadamente las excepciones de entrada/salida.*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio1 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path p;
        do{
            System.out.println("Introduce la ruta de un directorio: ");
            p = Path.of(sc.nextLine());
            if(!Files.isDirectory(p))
                System.out.println("ERROR. La ruta introducia no es un directorio.");
        } while (!Files.isDirectory(p));
        final Path directorioBase = p;
        try(Stream<Path> directorio = Files.walk(p)) {
            Iterator it = directorio.iterator();
            while (it.hasNext()) {
                Path elemento = (Path) it.next();
                String nombreFichero = elemento.toString().toLowerCase();
                if(nombreFichero.endsWith(".xml") || nombreFichero.endsWith(".txt")){
                    System.out.printf("%s -> %d bytes%n", p.relativize(elemento), Files.size(elemento));
                }
                if(nombreFichero.endsWith(".tmp")){
                    Files.delete(elemento);
                    System.out.println("Fichero borrado: " + p.relativize(elemento));
                }
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}
/* directorio.forEach(path -> {
                try {
                    if (Files.isRegularFile(path)){
                        String nombre = path.toString().toLowerCase();
                        if(nombre.endsWith(".xml") || nombre.endsWith(".txt")){
                            Path pathRelativo = directorioBase.relativize(path);
                            long sizeArchivo = Files.size(path);
                            System.out.printf("%s -> %d bytes%n", pathRelativo, sizeArchivo);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Ha ocurrido un error: " + e.getMessage());
                }
            });*/
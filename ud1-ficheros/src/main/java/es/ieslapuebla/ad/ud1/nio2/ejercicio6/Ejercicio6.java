package es.ieslapuebla.ad.ud1.nio2.ejercicio6;

/*
6. Crear un programa que borre un fichero ubicado en una ruta determinada. Para ello, el programa
debe pedir el path por teclado y comprobar que es válido.
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio6 {
    static void main(String[] args) {
        Path archivo = Path.of("C:/Users/laura/UD1/EJEMPLO/archivo.txt");
        try {
            if(Files.deleteIfExists(archivo)) {
                System.out.println("Se ha borrado el archivo correctamente.");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}

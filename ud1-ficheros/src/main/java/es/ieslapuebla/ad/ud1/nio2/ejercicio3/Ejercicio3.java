package es.ieslapuebla.ad.ud1.nio2.ejercicio3;

/*
3. Crear un programa que pida un path por teclado e indique si es un fichero o un directorio. Mientras
no se introduzca un path válido, el programa lo seguirá pidiendo.
*/

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio3 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esValido = false;
        Path directorio;

        System.out.println("Introduce un path: ");
        do {
            String path = sc.nextLine();
            directorio = Path.of(path);
            if(!Files.exists(directorio)){
                System.out.println("El path no existe, inténtalo otra vez: ");
            } else {
                esValido = true;
            }
        } while (!esValido);

        if(Files.isDirectory(directorio)) {
            System.out.println("El path es un directorio.");
        } else {
            System.out.println("El path es un fichero.");
        }
    }
}

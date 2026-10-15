package es.ieslapuebla.ad.ud1.nio2.ejercicio2;

/*
2. Crear un programa que pida un path por teclado y compruebe la validez. Es decir, debe mostrar la
siguiente información:
a. Si el path existe.
b. Y, en el caso de que exista, ha de indicar si se puede leer o no se puede leer.
*/

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Path directorio = Path.of(s);
        if(!Files.exists(directorio)) {
            System.out.println("El path no existe");
        } else {
            if(!Files.isReadable(directorio)) {
                System.out.println("El path NO se puede leer.");
            } else {
                System.out.println("El path se puede leer.");
            }
        }
        sc.close();
    }
}

package es.ieslapuebla.ad.ud1.file;

import java.io.File;
import java.util.Scanner;

/*
3. Se pide un programa que pida un path por teclado e indique si es un fichero o un directorio.
Mientras no se introduzca un path válido, el programa lo seguirá pidiendo.
*/
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esCorrecto = false;
        System.out.println("Introduce un path: ");

        do {
            File pathAComprobar = new File(sc.nextLine());
            if(pathAComprobar.exists()) {
                esCorrecto = true;
                if(pathAComprobar.isDirectory()) {
                    System.out.println("El path introducido es un DIRECTORIO.");
                } else {
                    System.out.println("El path introducido es un FICHERO.");
                }
            } else {
                System.out.println("El path introducido no es CORRECTO. Inténtalo de nuevo: ");
            }
        } while (!esCorrecto);

        sc.close();
    }

}

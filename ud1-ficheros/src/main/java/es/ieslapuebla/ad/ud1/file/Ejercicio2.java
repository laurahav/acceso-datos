package es.ieslapuebla.ad.ud1.file;

import java.io.File;
import java.util.Scanner;

/*
2.
Se pide crear un programa que pida un path por teclado y compruebe la validez. Es decir, debe mostrar la siguiente información:
a)Si el path existe.
b)Y, en el caso de que exista, ha de indicar si se puede leer o no se puede leer.
*/
public class Ejercicio2 {
    public static void main(String[] args) {
        File archivo = new File(pedirPath());

        if(archivo.exists()) {
            System.out.println("El path introducido EXISTE.");
            if(archivo.canRead()) {
                System.out.println("Además, SÍ se puede leer.");
            } else {
                System.out.println("Sin embargo, NO se puede leer.");
            }
        } else {
            System.out.println("El path introducido NO EXISTE.");
        }
    }


    public static String pedirPath() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un path:");
        String path = sc.nextLine();
        sc.close();
        return path;
    }
}

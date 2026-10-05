package es.ieslapuebla.ad.ud1.file;

/*
4. Se pide un programa que pida un path y, si es un directorio, liste su contenido. Mientras no
se introduzca un path válido, el programa lo seguirá pidiendo. Es decir, te debes asegurar
de que el usuario ha introducido un path correspondiente a un directorio. Una vez validado
el path, para cada elemento dentro del directorio, el programa debe indicar si se trata de un
fichero o de un directorio.
*/

import java.io.File;
import java.util.Scanner;

public class Ejercicio4 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esCorrecto = false;
        System.out.println("Introduce un path: ");

        do {
            File pathAComprobar = new File(sc.nextLine());
            if(pathAComprobar.exists()) {
                if(pathAComprobar.isDirectory()) {
                    System.out.println("El path indicado es un DIRECTORIO y contiene: ");
                    File[] contenido = pathAComprobar.listFiles();
                    for (File elemento: contenido){
                        if(elemento.isDirectory()) {
                            System.out.printf("%s -> directorio\n", elemento.getName());
                        } else {
                            System.out.printf("%s -> fichero\n", elemento.getName());
                        }
                    }
                } else {
                    System.out.println("El path introducido no es un DIRECTORIO. Inténtalo de nuevo: ");
                }
                esCorrecto = true;
            } else {
                System.out.println("El path introducido NO ES CORRECTO. Inténtalo de nuevo: ");
            }
        } while (!esCorrecto);

        sc.close();
    }
}


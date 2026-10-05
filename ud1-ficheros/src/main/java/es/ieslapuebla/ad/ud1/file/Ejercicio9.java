package es.ieslapuebla.ad.ud1.file;

/*
9. Se pide un programa que, dado el path de un directorio, muestre de forma recursiva todo
su contenido: todos los ficheros y subdirectorios que contenga, en cualquier nivel de
profundidad, indicando para cada uno si es un fichero o un directorio. El programa no debe
borrar ni modificar nada, solo mostrar la estructura completa.
*/

import java.io.File;
import java.util.Scanner;

public class Ejercicio9 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esCorrecto= false;
        System.out.println("Introduce el path del fichero: ");
        File directorio;
        //C:\Users\laura\Desktop\dinosaurio.fxml
        do{
            directorio = new File(sc.nextLine());
            if(directorio.exists()) {
                mostrarContenido(directorio);
                esCorrecto = true;
            } else {
                System.out.println("El directorio no existe. Inténtalo de nuevo: ");
            }
        } while (!esCorrecto);

        sc.close();
    }

    public static void mostrarContenido(File directorio) {
        File[] contenido = directorio.listFiles();

        if(contenido != null) {
            for(File elemento : contenido) {
                if(elemento.isDirectory()) {
                    System.out.println("Directorio: " + elemento.getAbsolutePath());
                    mostrarContenido(elemento);
                } else {
                    System.out.println("Fichero: " + elemento.getAbsolutePath());
                }
            }
        }
    }
}

package es.ieslapuebla.ad.ud1.file;

/*
8. Se pide crear un programa que borre un fichero ubicado en una ruta determinada. Para ello,
el programa debe pedir el path por teclado y comprobar que es válido.
*/

import java.io.File;
import java.util.Scanner;

public class Ejercicio8 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esCorrecto= false;
        System.out.println("Introduce el path del fichero: ");
        //C:\Users\laura\Desktop\dinosaurio.fxml
        do{
            File fichero = new File(sc.nextLine());
            if(fichero.exists()) {
                esCorrecto = true;
                if(fichero.delete()) {
                    System.out.println("El fichero " + fichero.getName() + " ha sido borrado con éxito.");
                } else {
                    System.out.println("Ha ocurrido un error y el fichero " + fichero.getName() + " no se ha podido borrar.");
                }
            } else {
                System.out.println("El fichero no existe. Inténtalo de nuevo: ");
            }
        } while (!esCorrecto);
        sc.close();
    }
}

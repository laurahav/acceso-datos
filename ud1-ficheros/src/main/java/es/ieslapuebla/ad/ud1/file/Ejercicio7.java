package es.ieslapuebla.ad.ud1.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
7. Se pide un programa que pida por teclado el path de un fichero existente y muestre su ruta
absoluta y su tamaño en bytes. A continuación, el programa debe renombrar el fichero
añadiendo el sufijo "_copia" a su nombre (por ejemplo, datos.txt pasaría a llamarse
datos_copia.txt), manteniendo la misma ubicación.
*/
public class Ejercicio7 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esCorrecto= false;
        System.out.println("Introduce el path del fichero: ");
        //C:\Users\laura\Desktop\dinosaurio.fxml
        do{
            File fichero = new File(sc.nextLine());
            if(fichero.exists()) {
                System.out.println("El nombre completo del fichero es: " + fichero.getAbsolutePath() + " y su tamaño es " + fichero.length() + " bytes.");
                String[] nombreConExtensiones = fichero.getName().split("\\.");
                String nuevoNombre = nombreConExtensiones[0] + "_copia";
                for(int i = 1; i < nombreConExtensiones.length; i++) {
                    nuevoNombre += "." + nombreConExtensiones[i];
                }
                File nuevoFichero = new File(fichero.getParent(),nuevoNombre);

                if(fichero.renameTo(nuevoFichero)){
                    System.out.println("El fichero se ha nombrado correctamente.");
                } else {
                    System.out.println("Ha habido un problema y no se ha renombrado el archivo.");
                }
                esCorrecto = true;
            } else {
                System.out.println("El fichero no existe. Inténtalo de nuevo: ");
            }
        } while (!esCorrecto);
        sc.close();
    }
}

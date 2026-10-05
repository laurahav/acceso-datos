package es.ieslapuebla.ad.ud1.file;

/*
10. Se pide crear un programa que borre una determinada carpeta cuyo path se introduce por
teclado. Ten en cuenta que el programa debe borrar todos los contenidos de la carpeta, es
decir, debe borrarla de manera recursiva. Pista: puedes reutilizar el mismo recorrido
recursivo del ejercicio anterior, pero esta vez borrando cada elemento en lugar de mostrarlo.
*/

import java.io.File;
import java.util.Scanner;

public class Ejercicio10 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esCorrecto= false;
        System.out.println("Introduce el path del fichero: ");
        File directorio;
        //C:\Users\laura\Desktop\2DAM
        do{
            directorio = new File(sc.nextLine());
            if(directorio.exists()) {
                borrarContenido(directorio);
                esCorrecto = true;
            } else {
                System.out.println("El directorio no existe. Inténtalo de nuevo: ");
            }
        } while (!esCorrecto);

        sc.close();
    }

    public static void borrarContenido(File directorio) {
        File[] contenido = directorio.listFiles();

        if(contenido != null) {
            for(File elemento : contenido) {
                if(elemento.isDirectory()) {
                    borrarContenido(elemento);
                    if(elemento.delete()){
                        System.out.println("El directorio " + elemento.getName() + " ha sido borrado con éxito");
                    } else {
                        System.out.println("Ha ocurrido un error y el directorio " + elemento.getName() + " no se ha podido borrar.");
                    }
                } else {
                    if(elemento.delete()){
                        System.out.println("El fichero " + elemento.getName() + " ha sido borrado con éxito");
                    } else {
                        System.out.println("Ha ocurrido un error y el fichero " + elemento.getName() + " no se ha podido borrar.");
                    }
                }
            }
        }
    }
}

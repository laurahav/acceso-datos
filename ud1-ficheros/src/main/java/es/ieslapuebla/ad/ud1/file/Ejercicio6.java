package es.ieslapuebla.ad.ud1.file;

/*
6. Se pide un programa que cree un fichero vacío en una ruta determinada que se pida por
teclado. Antes de crearlo, el programa debe comprobar si el fichero ya existe: si existe, debe
avisar de que no se va a sobrescribir y finalizar sin crear nada; si no existe, debe crearlo y
confirmarlo por pantalla.
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio6 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esCorrecto= false;
        System.out.println("Introduce la ruta donde quieres crear el fichero: ");

        do{
            String ruta = sc.nextLine();
            File f = new File(ruta);
            if(f.exists()) {
                File fichero = new File(ruta + "\\fichero.txt");
                if(fichero.exists()) {
                    System.out.println("El fichero ya existe y no se va a sobreescribir.");
                } else {
                    try{
                        if(fichero.createNewFile()){
                            System.out.println("El fichero se ha creado con éxito.");
                        } else {
                            System.out.println("Ha ocurrido un error y no se ha creado.");
                        }
                    } catch (IOException e) {
                        System.out.println("Ha ocurrido un error y no se ha creado.");
                    }
                }
                esCorrecto = true;
            } else {
                System.out.println("La ruta introducida es errónea. Vuelve a intentarlo: ");
            }
        } while (!esCorrecto);
        sc.close();
    }
}

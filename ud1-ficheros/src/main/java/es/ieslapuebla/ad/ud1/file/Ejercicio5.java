package es.ieslapuebla.ad.ud1.file;
//5. Se pide un programa que cree un directorio llamado "UD1" en una ruta que indiques (por
// ejemplo, dentro de tu carpeta de usuario) y, dentro de él, un subdirectorio llamado "EJEMPLO".

import java.io.File;
import java.util.Scanner;

public class Ejercicio5 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esCorrecto= false;
        System.out.println("Introduce la ruta donde quieres crear el directorio: ");

        do{
            String ruta = sc.nextLine();
            File f = new File(ruta);
            if(f.exists()) {
                File directorio = new File(ruta + "\\UD1\\EJEMPLO");
                if(directorio.mkdirs()) {
                    System.out.println("Directorio creado con éxito.");
                } else {
                    System.out.println("Ha ocurrido un error y el directorio no se ha creado.");
                }
                esCorrecto = true;
            } else {
                System.out.println("La ruta introducida es errónea. Vuelve a intentarlo: ");
            }
        } while (!esCorrecto);
        sc.close();
    }
}

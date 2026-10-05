package es.ieslapuebla.ad.ud1.file;

/*
1. Se pide crear un programa en Java que muestre el listado de ficheros del
directorio actual del proyecto.
*/

import java.io.File;

public class Ejercicio1 {
    public static void main(String[] args) {
        File directorio = new File(".");
        String[] archivos = directorio.list();
        for (int i = 0; i < archivos.length; i++){
            System.out.println(archivos[i]);
        }
        //System.out.println(directorio.getAbsolutePath());
    }
}

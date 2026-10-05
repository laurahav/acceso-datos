package es.ieslapuebla.ad.ud1.file;

import java.io.File;
import java.io.FilenameFilter;

/*
11. Se pide crear un programa que muestre el listado de ficheros con extensión xml del
directorio actual del proyecto.
Pasos a realizar:
a) Utilizamos la clase File para acceder a la ruta del directorio solicitado.
b) Utilizamos un objeto FilenameFilter para filtrar por extensión.
c) Guardar en un array el listado de archivos cuya extensión coincida con la extensión
dada.
d) Recorrer el array mostrando el nombre de cada elemento.
*/
public class Ejercicio11 {
    static void main(String[] args) {
        File directorio = new File(".");

        FilenameFilter filtroXML = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".xml");
            }
        };

        File[] archivosXML = directorio.listFiles(filtroXML);

        if(archivosXML != null){
            for(File elemento : archivosXML) {
                System.out.println(elemento.getName());
            }
        }

    }
}

package es.ieslapuebla.ad.ud1.streams.ejercicio3;

import es.ieslapuebla.ad.ud1.streams.ejercicio2.Producto;
import es.ieslapuebla.ad.ud1.streams.ejercicio2.TextoProductosToConsola;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class TextoProductosToBinario {
    static void main(String[] args) {
        File f = new File("src/main/java/es/ieslapuebla/ad/ud1/streams/ejercicio2/productos_entrada.txt");
        ArrayList<Producto> productos = new ArrayList<>();

        //Utilizamos el método del ejercicio anterior para sacar la lista de productos.

        productos = TextoProductosToConsola.textoToArrayList(f);

        //Convertimos la lista a binario

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productos.dat"))) {
            for(Producto p : productos) {
                oos.writeObject(p);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: "  + e.getMessage());
        }
    }
}

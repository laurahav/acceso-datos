package es.ieslapuebla.ad.ud1.streamsv2.ejercicio3;


import es.ieslapuebla.ad.ud1.streamsv2.ejercicio2.Producto;
import es.ieslapuebla.ad.ud1.streamsv2.ejercicio2.TextoProductosToConsola;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;


public class TextoProductosToBinario {
    static void main(String[] args) {
        Path p = Path.of("src/main/java/es/ieslapuebla/ad/ud1/streams/ejercicio2/productos_entrada.txt");
        ArrayList<Producto> productos = TextoProductosToConsola.textoToArrayList(p);

        //Convertimos la lista a binario

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productos.dat"))) {
            for(Producto producto : productos) {
                oos.writeObject(producto);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: "  + e.getMessage());
        }
    }
}

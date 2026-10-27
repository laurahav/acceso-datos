package es.ieslapuebla.ad.ud1.streamsv2.ejercicio4;

import es.ieslapuebla.ad.ud1.streamsv2.ejercicio2.Producto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class BinarioProductosToConsola {

    static void main(String[] args) {
        Path p = Path.of("productos.dat");
        ArrayList<Producto> productos = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(p))) {
            while (true) {
                Producto producto = (Producto) ois.readObject();
                productos.add(producto);
            }
        } catch (EOFException e) {
            e.getStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo productos.dat no encontrado.");
        } catch (IOException e) {
            System.out.println("Error: fallo en el acceso al archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: el contenido del archivo no se corresponde con lo que esperaba.");
        } catch (ClassCastException e) {
            System.out.println("Error: el archivo no contiene un Producto.");
        }

        System.out.println("CONTENIDO DEL ARCHIVO BINARIO");
        System.out.println("------------------------------");
        System.out.printf("Total de productos: %d\n", productos.size());
        int i = 1;
        for(Producto producto : productos) {
            System.out.printf("PRODUCTO %d: %s\n", i, producto.toString());
            i++;
        }
    }
}

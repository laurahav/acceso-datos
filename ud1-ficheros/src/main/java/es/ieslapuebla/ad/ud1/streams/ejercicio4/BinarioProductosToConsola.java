package es.ieslapuebla.ad.ud1.streams.ejercicio4;

import es.ieslapuebla.ad.ud1.streams.ejercicio2.Producto;

import java.io.*;
import java.util.ArrayList;

public class BinarioProductosToConsola {

    static void main(String[] args) {
        File f = new File("productos.dat");
        ArrayList<Producto> productos = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                Producto p = (Producto) ois.readObject();
                productos.add(p);
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
        for(Producto p : productos) {
            System.out.printf("PRODUCTO %d: %s\n", i, p.toString());
            i++;
        }
    }
}

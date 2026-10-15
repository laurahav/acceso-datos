package es.ieslapuebla.ad.ud1.streamsv2.ejercicio2;

import es.ieslapuebla.ad.ud1.streams.ejercicio2.Producto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextoProductosToConsola {
    static void main(String[] args) {
        File f = new File("src/main/java/es/ieslapuebla/ad/ud1/streams/ejercicio2/productos_entrada.txt");
        ArrayList<es.ieslapuebla.ad.ud1.streams.ejercicio2.Producto> productos = new ArrayList<es.ieslapuebla.ad.ud1.streams.ejercicio2.Producto>();

        productos = textoToArrayList(f);
        // Recorremos la lista
        System.out.println("CONTENIDO DEL ARCHIVO DE TEXTO");
        System.out.println("------------------------------");
        System.out.printf("Total de productos: %d\n", productos.size());
        int i = 1;
        for(es.ieslapuebla.ad.ud1.streams.ejercicio2.Producto p : productos) {
            System.out.printf("PRODUCTO %d: %s\n", i, p.toString());
            i++;
        }
    }

    public static ArrayList textoToArrayList(File f) {
        // Leemos lor productos y los almacenamos en el ArrayList.
        ArrayList<es.ieslapuebla.ad.ud1.streams.ejercicio2.Producto> productosArrayList = new ArrayList<es.ieslapuebla.ad.ud1.streams.ejercicio2.Producto>();
        try(BufferedReader br = new BufferedReader(new FileReader(f, StandardCharsets.UTF_8))){
            String linea;
            while ((linea = br.readLine()) != null) {
                if(comprobarProducto(linea)){
                    String[] producto = linea.split("::");
                    es.ieslapuebla.ad.ud1.streams.ejercicio2.Producto p = new Producto(producto[0],producto[1], producto[2], Double.parseDouble (producto[3]));
                    productosArrayList.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
        return productosArrayList;
    }

    public static boolean comprobarProducto(String linea) {
        Pattern p = Pattern.compile("^\\d{4}::[a-z\\s]+::[a-z0-9\\s]+::(\\d+\\.\\d{2})$");
        Matcher m = p.matcher(linea);

        return m.matches();
    }
}
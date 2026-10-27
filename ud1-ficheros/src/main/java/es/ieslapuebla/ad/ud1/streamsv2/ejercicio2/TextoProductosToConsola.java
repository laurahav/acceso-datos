package es.ieslapuebla.ad.ud1.streamsv2.ejercicio2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextoProductosToConsola {
    static void main(String[] args) {
        Path f = Path.of("src/main/java/es/ieslapuebla/ad/ud1/streamsv2/ejercicio2/productos_entrada.txt");
        ArrayList<Producto> productos = textoToArrayList(f);

        // Recorremos la lista
        System.out.println("CONTENIDO DEL ARCHIVO DE TEXTO");
        System.out.println("------------------------------");
        System.out.printf("Total de productos: %d\n", productos.size());
        int i = 1;
        for(Producto p : productos) {
            System.out.printf("PRODUCTO %d: %s\n", i, p.toString());
            i++;
        }
    }

    public static ArrayList<Producto> textoToArrayList(Path p) {
        // Leemos lor productos y los almacenamos en el ArrayList.
        ArrayList<Producto> productosArrayList = new ArrayList<Producto>();
        try{
            List<String> productosTexto = Files.readAllLines(p, StandardCharsets.UTF_8);
            for(String productoTexto: productosTexto) {
                if(comprobarProducto(productoTexto)) {
                    String[] producto = productoTexto.split("::");
                    productosArrayList.add(new Producto(producto[0],producto[1], producto[2], Double.parseDouble (producto[3])));
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

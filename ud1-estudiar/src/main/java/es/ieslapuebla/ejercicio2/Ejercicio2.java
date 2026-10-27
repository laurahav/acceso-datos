package es.ieslapuebla.ejercicio2;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
A partir de un fichero de texto llamado facturas_entrada.txt con el formato IDFactura::Cliente::Concepto::Importe por línea,
crea una clase ejecutable ProcesadorFacturas que:

1. Lea el fichero línea a línea y valide cada registro: si cumple el formato estricto y el importe es un valor numérico válido,
se instanciará un objeto Factura; en caso contrario, la línea se descartará silenciosamente.
2. Almacene las facturas válidas en una estructura de datos adecuada.
3. Muestre por consola el número total de líneas leídas frente al total de válidas, un listado ordenado delas facturas con importe
superior a 100,00 € de mayor a menor, y el importe total acumulado de todas las facturas válidas.
*/

public class Ejercicio2 {
    static void main(String[] args) {
        Path fichero = Path.of("facturas_entrada.txt");
        List<Factura> facturasObj = new ArrayList<Factura>();
        int lineasLeidas = 0, lineasValidas = 0;
        Pattern p = Pattern.compile("([^:]+)::([^:]+)::([^:]+)::([^:]+)");
        try (FileReader fr = new FileReader(fichero.toFile())) {
            List<String> facturas = fr.readAllLines();
            for(String factura : facturas){
                lineasLeidas++;
                Matcher m = p.matcher(factura);
                if(m.matches()) {
                    try {
                        facturasObj.add(new Factura(m.group(1), m.group(2), m.group(3), Double.parseDouble(m.group(4))));
                        lineasValidas++;
                    } catch (NumberFormatException e) {
                        e.getStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }

        System.out.println("Lineas leídas: " + lineasLeidas);
        System.out.println("Lineas válidas: " + lineasValidas);
        facturasObj.sort(Comparator.comparingDouble(Factura::getImporte).reversed());
        double importeAcumulado = 0;
        for(Factura f : facturasObj) {
            System.out.println(f.toString());
            importeAcumulado += f.getImporte();
        }
        System.out.println("Importe total acumulado: " + importeAcumulado + "€");
    }
}

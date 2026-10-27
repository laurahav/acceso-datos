package es.ieslapuebla.ejercicio3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
Desarrolla una aplicación que gestione un inventario en un fichero binario llamado catalogo.dat mediante un menú por consola con las siguientes opciones:
1. Añadir elemento: Pide por teclado los datos de un objeto Elemento (id int, nombre String, cuota double, activo boolean) y los almacena en el fichero binario,
controlando la persistencia acumulativa de objetos.
2. Listar contenido: Lee íntegramente el fichero binario, muestra los objetos formateados por consola y el total de registros leídos.
3. Modificar registro: Pide un ID de socio por teclado, actualiza su estado activo (invirtiendo su valor) y reescribe completamente el fichero binario con los datos modificados.
4. Salir.
*/
public class Ejercicio3 {
    static List<Elemento> elementos = new ArrayList<Elemento>();

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = leerEntero(mostrarMenu() + System.lineSeparator() + "Elige una opción: ", sc);
        do {
            switch (opcion) {
                case 1 -> addElemento(sc);
                case 2 -> listElementos();
                case 3 -> modifyElemento(sc);
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("ERROR. Introduce una opción válida.");
            }
        } while (opcion != 4);
        sc.close();
    }

    public static void addElemento(Scanner sc) {
        if
        System.out.println("Elemento añadido correctamente.");
    }

    public static void listElementos() {
        for (Elemento e : elementos) {
            System.out.println(e);
        }
    }

    public static void modifyElemento() {

    }

    public static Elemento leerElemento(Scanner sc) {
        int id = leerEntero("Introduce el id del elemento: ", sc);
        System.out.println("Introduce el nombre del elemento:");
        String nombre = sc.nextLine();
        double precio = leerDecimal("Introduce el precio: ", sc);
        System.out.println("¿Está activo el elemento? (true/FALSE): ");
        String activoString = sc.nextLine();
        boolean activo = false;
        if (activoString == "true") {
            activo = true;
        } else {
            activo = false;
        }
        return new Elemento(id, nombre, precio, activo);
    }

    public static String mostrarMenu() {
        String menu = "--------------------" + System.lineSeparator() +"-----INVENTARIO-----" + System.lineSeparator() +
                "--------------------" + System.lineSeparator() + "1. Añadir elemento." + System.lineSeparator() +
                "2. Listar contenido" + System.lineSeparator() + "3. Modificar registro" + System.lineSeparator() +
                "4. Salir";
        return menu;
    }

    public static int leerEntero(String mensaje, Scanner sc) {
        System.out.println(mensaje);
        int numero = 0;
        boolean esNum = false;
        do{
            try {
                numero = sc.nextInt();
                esNum = true;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("ERROR. Debes introducir un número entero.");
            }
        } while (!esNum);
        return numero;
    }

    public static double leerDecimal(String mensaje, Scanner sc) {
        System.out.println(mensaje);
        double numero = 0.00;
        boolean esNum = false;
        do{
            try {
                numero = sc.nextDouble();
                esNum = true;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("ERROR. Debes introducir un número decimal.");
            }
        } while (!esNum);
        return numero;
    }
}

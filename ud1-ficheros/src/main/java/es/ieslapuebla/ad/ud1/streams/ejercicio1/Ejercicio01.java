package es.ieslapuebla.ad.ud1.streams.ejercicio1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio01 {
    public static File f = new File("src/main/java/es/ieslapuebla/ad/ud1/streams/ejercicio1/datos.txt");
    public static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        int opcion = 0;
        do {
            mostrarMenu();

            System.out.println("Elige una opción:");
            try{
                opcion = sc.nextInt();
            } catch(InputMismatchException e) {
                sc.nextLine();
                System.out.println("Debes introducir un número válido. Vuelva a intentarlo: ");
            }

            if(opcion < 0 || opcion > 6) {
                System.out.println("Debes introducir una opción válida. Vuelva a intentarlo: ");
            }
            switch (opcion) {
                case 1:
                    registrarAlumno();
                    break;
                case 2:
                    mostrarDatos();
                    break;
                case 3:
                    System.out.println(buscarMayores(30));
                    break;
                case 4:
                    System.out.println(buscarNombre("Juan"));
                    break;
                case 5:
                    eliminarAlumno();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
            }
        } while (opcion != 6);
        sc.close();
    }


    public static void registrarAlumno() {
        sc.nextLine();
        System.out.print("Introduce el nombre del alumno: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce la edad del alumno: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce el correo electrónico: ");
        String email = sc.nextLine();
        System.out.print("Introduce número de teléfono: ");
        String telefono = sc.nextLine();

        try (PrintWriter pw = new PrintWriter(
                new FileWriter(f, StandardCharsets.UTF_8, true))) {
            pw.printf("%s#%d#%s#%s\n",nombre,edad, email, telefono);
            System.out.println("El alumno se ha registrado correctamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error y el registro no se ha guardado.");
        }
    }

    public static void mostrarDatos() {
        try(BufferedReader br = new BufferedReader(new FileReader(f, StandardCharsets.UTF_8))){

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error y el registro no se ha borrado.");
        }
    }

    public static String buscarMayores(int edad) {
        return "";
    }

    public static String buscarNombre(String nombre) {
        return "";
    }

    public static void eliminarAlumno() {

    }

    public static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.printf("\t1.Registrar el alumno.\n");
        System.out.printf("\t2.Mostrar datos del fichero.\n");
        System.out.printf("\t3.Ejecutar consulta mayores de 30.\n");
        System.out.printf("\t4.Ejecutar consulta alumnos Juan.\n");
        System.out.printf("\t5.Eliminar alumno.\n");
        System.out.printf("\t6.Salir.\n");
    }

}

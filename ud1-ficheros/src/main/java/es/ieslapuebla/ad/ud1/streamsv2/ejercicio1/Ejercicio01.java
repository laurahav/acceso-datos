package es.ieslapuebla.ad.ud1.streamsv2.ejercicio1;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Ejercicio01 {
    public static Path f = Path.of("src/main/java/es/ieslapuebla/ad/ud1/streamsv2/ejercicio1/datos.txt");
    public static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        int opcion = 0;
        do {
            mostrarMenu();

            System.out.print("Elige una opción:\n");
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
                    //mostrarDatos();
                    break;
                case 3:
                    //buscarMayores(30);
                    break;
                case 4:
                    //buscarNombre("Juan");
                    break;
                case 5:
                    //eliminarAlumno();
                    break;
                case 6:
                    System.out.print("Saliendo del programa...");
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
        int edad = pedirEntero();
        sc.nextLine();
        System.out.print("Introduce el correo electrónico: ");
        String email = sc.nextLine();
        System.out.print("Introduce número de teléfono: ");
        String telefono = sc.nextLine();

        String alumno = nombre + "#" + edad + "#" + email + "#" + telefono + "\n";

        try {
            Files.writeString(f,alumno  , StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

    public static void mostrarDatos() {
        try{
            List<String> alumnos = Files.readAllLines(f, StandardCharsets.UTF_8);
            int i = 1;
            for(String alumno : alumnos) {
                String[] camposAlumno = alumno.split("#");
                System.out.printf("Alumno %d: \nNombre: %s\nEdad: %s\nEmail: %s\nTeléfono: %s\n", i, camposAlumno[0], camposAlumno[1], camposAlumno[2],camposAlumno[3]);
                i++;
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error y el registro no .");
        }
    }

    public static void buscarMayores(int edad) {
        try{
            List<String> alumnos = Files.readAllLines(f, StandardCharsets.UTF_8);
            int i = 1;
            for(String alumno : alumnos) {
                String[] camposAlumno = alumno.split("#");
                if(camposAlumno[1].equals(String.valueOf(edad))){
                    System.out.printf("Alumno %d: \nNombre: %s\nEdad: %s\nEmail: %s\nTeléfono: %s\n", i, camposAlumno[0], camposAlumno[1], camposAlumno[2],camposAlumno[3]);
                    i++;
                }
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error y el registro no .");
        }
    }

    public static void buscarNombre(String nombre) {
        try{
            List<String> alumnos = Files.readAllLines(f, StandardCharsets.UTF_8);
            int i = 1;
            for(String alumno : alumnos) {
                String[] camposAlumno = alumno.split("#");
                if(camposAlumno[0].equals(nombre)){
                    System.out.printf("Alumno %d: \nNombre: %s\nEdad: %s\nEmail: %s\nTeléfono: %s\n", i, camposAlumno[0], camposAlumno[1], camposAlumno[2],camposAlumno[3]);
                    i++;
                }
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error y el registro no .");
        }
    }

    public static void eliminarAlumno() {
        System.out.print("Introduce el nombre del alumno que quieres borrar: ");
        sc.nextLine();
        String nombre = sc.nextLine();
        Path nuevoArchivo = Path.of("src/main/java/es/ieslapuebla/ad/ud1/streamsv2/ejercicio1/datos_nuevo.txt");
        try{
            List<String> alumnos = Files.readAllLines(f, StandardCharsets.UTF_8);
            int i = 1;
            for(String alumno : alumnos) {
                String[] camposAlumno = alumno.split("#");
                if(!camposAlumno[0].equals(nombre)){
                    Files.writeString(nuevoArchivo, alumno,StandardOpenOption.APPEND);
                }
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error y el registro no .");
        }
        try {
            Files.move(nuevoArchivo,f, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

    public static void mostrarMenu() {
        System.out.print("Menú:\n");
        System.out.print("\t1.Registrar el alumno.\n");
        System.out.print("\t2.Mostrar datos del fichero.\n");
        System.out.print("\t3.Ejecutar consulta mayores de 30.\n");
        System.out.print("\t4.Ejecutar consulta alumnos Juan.\n");
        System.out.print("\t5.Eliminar alumno.\n");
        System.out.print("\t6.Salir.\n");
    }

    public static int pedirEntero() {
        int num = 0;
        boolean esCorrecto = false;
        do {
            try {
                num = sc.nextInt();
                esCorrecto = true;
            } catch (InputMismatchException e) {
                System.out.println("No se ha introducido un entero. Inténtalo de nuevo: ");
            }
        } while (!esCorrecto);
        return num;
    }
}

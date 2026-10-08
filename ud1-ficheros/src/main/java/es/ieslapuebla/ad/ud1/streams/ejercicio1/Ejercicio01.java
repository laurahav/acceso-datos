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
                    mostrarDatos();
                    break;
                case 3:
                    buscarMayores(30);
                    break;
                case 4:
                    buscarNombre("Juan");
                    break;
                case 5:
                    eliminarAlumno();
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

        try (PrintWriter pw = new PrintWriter(
                new FileWriter(f, StandardCharsets.UTF_8, true))) {
            pw.printf("%s#%d#%s#%s\n",nombre,edad, email, telefono);
            System.out.println("El alumno se ha registrado correctamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error y el registro no se ha guardado.");
        }
    }

    public static void mostrarDatos() {
        String alumno;
        try(BufferedReader br = new BufferedReader(new FileReader(f, StandardCharsets.UTF_8))){
            while((alumno = br.readLine()) != null){
                String[] alumnoSplit = alumno.split("#");
                System.out.printf("Nombre: %s \nEdad: %d \nEmail: %s \nTeléfono: %s\n\n", alumnoSplit[0], Integer.parseInt(alumnoSplit[1]), alumnoSplit[2], alumnoSplit[3]);
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error y el registro no .");
        }
    }

    public static void buscarMayores(int edad) {
        String alumno;
        try(BufferedReader br = new BufferedReader(new FileReader(f, StandardCharsets.UTF_8))){
            while((alumno = br.readLine()) != null){
                String[] alumnoSplit = alumno.split("#");
                if(Integer.parseInt(alumnoSplit[1]) >= edad){
                    System.out.printf("Nombre: %s \nEdad: %d \nEmail: %s \nTeléfono: %s\n\n", alumnoSplit[0], Integer.parseInt(alumnoSplit[1]), alumnoSplit[2], alumnoSplit[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error y el registro no .");
        }
    }

    public static void buscarNombre(String nombre) {
        String alumno;
        try(BufferedReader br = new BufferedReader(new FileReader(f, StandardCharsets.UTF_8))){
            while((alumno = br.readLine()) != null){
                String[] alumnoSplit = alumno.split("#");
                if(alumnoSplit[0].equals(nombre)){
                    System.out.printf("Nombre: %s \nEdad: %d \nEmail: %s \nTeléfono: %s\n\n", alumnoSplit[0], Integer.parseInt(alumnoSplit[1]), alumnoSplit[2], alumnoSplit[3]);
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
        File nuevoArchivo = new File("src/main/java/es/ieslapuebla/ad/ud1/streams/ejercicio1/datos_nuevo.txt");
        String alumno;
        try(BufferedReader br = new BufferedReader(new FileReader(f, StandardCharsets.UTF_8))){
            while((alumno = br.readLine()) != null){
                String[] alumnoSplit = alumno.split("#");
                if(!alumnoSplit[0].equals(nombre)){
                    try (PrintWriter pw = new PrintWriter(
                            new FileWriter(nuevoArchivo, StandardCharsets.UTF_8, true))) {
                        pw.println(alumno);
                    } catch (IOException e) {
                        e.getStackTrace();
                    }
                }
            }
            System.out.println("El registro se ha borrado correctamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error y el registro no se ha borrado.");
        }
        f.delete();
        nuevoArchivo.renameTo(f);
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

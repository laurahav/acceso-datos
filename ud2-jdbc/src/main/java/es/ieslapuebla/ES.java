package es.ieslapuebla;

import java.util.Scanner;

// Clase de utilidad para leer datos por teclado
public final class ES {

    private static final Scanner sc = new Scanner(System.in);

    private ES() { }

    public static int leeEntero(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Número entero, por favor: ");
        }
        int v = sc.nextInt();
        sc.nextLine();
        return v;
    }

    public static int leeEntero(String prompt, int min, int max) {
        int v;
        do {
            v = leeEntero(prompt);
        } while (v < min || v > max);
        return v;
    }

    public static String leeCadena(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}

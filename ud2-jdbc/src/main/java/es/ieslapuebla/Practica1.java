package es.ieslapuebla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Practica1 {
    static void main(String[] args) {
        int opcion;
        do {
            opcion = ES.leeEntero(cadenaMenu(), 0, 5);
            switch (opcion) {
                case 1 -> mostrarPersonajes();
                case 2 -> mostrarNaves();
                case 3 -> insertarNave();
                case 4 -> editarNave();
                case 5 -> consultarPilotosEnUnAnio();
                case 0 -> System.out.println("Saliendo...");
            }
        } while (opcion != 0);
    }

    static void mostrarPersonajes() {
        try(Connection con = ConexionBD.getConnection()) {
            String sql = "SELECT * FROM personaje ORDER BY id_personaje";
            try(PreparedStatement ps = con.prepareStatement(sql)) {
                try(ResultSet rs = ps.executeQuery()) {
                    System.out.println("-------RESULTADO-------");
                    while(rs.next()) {
                        long id = rs.getLong("id_personaje");
                        String nombre = rs.getString("nombre");
                        String descripcion = rs.getString("descripcion");
                        String tipo = rs.getString("tipo");

                        System.out.printf("Personaje %d: %s - %s - %s%n", id, nombre, descripcion, tipo);
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error de conexión: " + e.getMessage());
        }
    }

    static void mostrarNaves() {
        try(Connection con = ConexionBD.getConnection()) {
            String sql = "SELECT * FROM nave ORDER BY id_nave";
            try(PreparedStatement ps = con.prepareStatement(sql)) {
                try(ResultSet rs = ps.executeQuery()) {
                    System.out.println("-------RESULTADO-------");
                    while(rs.next()) {
                        long id = rs.getLong("id_nave");
                        String descripcion = rs.getString("descripcion");
                        long motores = rs.getLong("motores");

                        System.out.printf("Nave %d: %s - %d motores%n", id, descripcion, motores);
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error de conexión: " + e.getMessage());
        }
    }

    static void insertarNave() {
        long id = ES.leeEntero("Introduce el ID de la nave que quieres insertar: ");
        String descripcion = ES.leeCadena("Introduce la descripción de la nave: ");
        long motores = ES.leeEntero("Introduce la cantidad de motores que tiene la nave: ");

        try(Connection con = ConexionBD.getConnection()) {
            String sql = "INSERT INTO nave (id_nave, descripcion, motores) VALUES (?,?,?)";
            try(PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                ps.setString(2, descripcion);
                ps.setLong(3, motores);

                int registrosAfectados = ps.executeUpdate();
                System.out.printf("Se ha(n) añadido %d naves a la base de datos.%n", registrosAfectados);
            } catch (SQLException e) {
                System.out.println("Ya exsite una nave con el ID " + id + ".");
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error de conexión: " + e.getMessage());
        }

    }

    static void editarNave() {
        long id = ES.leeEntero("Introduce el ID de la nave que quieres editar: ");
        long motores = ES.leeEntero("Introduce el nuevo número de motores de la nave: ");
        try (Connection con = ConexionBD.getConnection()){
            String sql = "UPDATE nave SET motores = ? WHERE id_nave = ?";
            try (PreparedStatement ps  = con.prepareStatement(sql)){
                ps.setLong(1, motores);
                ps.setLong(2, id);

                int registrosAfectados = ps.executeUpdate();
                if (registrosAfectados > 0) {
                    System.out.printf("La nave con el ID %d ha actualizado su número de motores a %d.", id, motores);
                } else {
                    System.out.println("No existe ninguna nave con el ID " + id + ", por tanto, no se ha actualizado el número de motores.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error de conexión: " +  e.getMessage());
        }
    }

    static void consultarPilotosEnUnAnio() {
        int anio = ES.leeEntero("Introduzca el año que quieras consultar: ");
        LocalDate fecha = LocalDate.of(anio,1,1);
        try(Connection con = ConexionBD.getConnection()) {
            String sql = "SELECT DISTINCT nombre FROM personaje a JOIN pilota b ON a.id_personaje = b.id_personaje WHERE fecha < ? ORDER BY a.nombre";
            try(PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setObject(1, fecha);
                try(ResultSet rs = ps.executeQuery()) {
                    System.out.println("-------RESULTADO-------");
                    while(rs.next()) {
                        String nombre = rs.getString("nombre");
                        System.out.println(nombre);
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error de conexión: " + e.getMessage());
        }
    }

    static String cadenaMenu() {
        return """
                -----------OPCIONES----------- 
                    1. Mostrar todos los personajes.
                    2. Mostrar todas las naves.
                    3. Insertar nave nueva.
                    4. Editar una nave existente.
                    5. Mostrar personajes que han pilotado al menos una nave antes de un año específico.
                    0. Salir
                Elige una opción: 
                """;
    }
}

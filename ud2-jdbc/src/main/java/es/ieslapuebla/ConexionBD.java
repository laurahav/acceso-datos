package es.ieslapuebla;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Clase de utilidad: obtiene conexiones a partir de db.properties

// Nadie puede heredar de ella: es una clase de utilidad (solo tiene miembros static)
public final class ConexionBD {

    // Guarda las líneas clave=valor de db.properties.
    // static --> un único almacén para todo el programa.
    // final --> no se puede sustituir por otro.
    private static final Properties PROPS = new Properties();

    // Lee db.properties una sola vez, la primera vez que se usa la clase.
    // Para no leer el fichero en cada conexión.
    static {
        // En src/main/resources va todo lo que la aplicación necesita
        // leer mientras se ejecuta y que no es código Java.
        // getResourceAsStream("/db.properties") busca el fichero en la
        // raíz de los recursos (src/main/resources)
        // getResourceAsStream() no lanza excepción, si no lo encuentra:
        // devuelve null
        try (InputStream in = ConexionBD.class.getResourceAsStream("/db.properties")) {
            if (in == null) {
                throw new IllegalStateException("No se encuentra db.properties");
            }
            PROPS.load(in);
        } catch (IOException e) {
            // Envuelve la IOException -> un bloque static no puede lanzar
            // excepciones comprobadas.
            throw new ExceptionInInitializerError(e);
        }
    }

    // Nadie puede hacer new ConexionBD(). No tiene sentido crear objetos de ella
    private ConexionBD() { }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                PROPS.getProperty("db.url"),
                PROPS.getProperty("db.user"),
                PROPS.getProperty("db.password"));
    }
}

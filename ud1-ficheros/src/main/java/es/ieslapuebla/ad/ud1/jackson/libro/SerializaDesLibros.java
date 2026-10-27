package es.ieslapuebla.ad.ud1.jackson.libro;

import com.fasterxml.jackson.annotation.JsonInclude;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.io.File;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SerializaDesLibros {
    public static void main(String[] args) throws Exception {
        // 1) Configurar ObjectMapper (JSON legible)
        ObjectMapper om = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .build();
        // 2) Construir datos (el 1º libro no tiene Titulo para que se omita en JSON)
        Libros raiz = new Libros()
                .add(new Libro(null, "Nikolai Gogol", 1840))
                .add(new Libro("El Sanador de Caballos", "Gonzalo Giner", 2008))
                .add(new Libro("El Nombre de la Rosa", "Umberto Eco", 1981));
        // 3) Serializar a fichero
        File ficheroJSON = new File("libros.json");
        om.writeValue(ficheroJSON, raiz);
        System.out.println("JSON escrito en: " + ficheroJSON.getAbsolutePath());
        // 4) Deserializar desde el mismo fichero
        Libros leido = om.readValue(ficheroJSON, Libros.class);
        // 5) Mostrar lo leído
        System.out.println("\nContenido deserializado:");
        for (Libro l : leido.getLibros()) {
            System.out.printf("publicado_en=%s, Titulo=%s, Autor=%s%n",
                    l.getPublicadoEn(), l.getTitulo(), l.getAutor());
        }
    }
}

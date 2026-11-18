package es.ieslapuebla.ad.ud1.jackson.apiOpenLibrary;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ConsultarLibro {

    static void consultarLibro(String nombre) {
        // He codificado el nombre, por si hay varias palabras que no haya problemas al crear la url
        String nombreCodificado = URLEncoder.encode(nombre, StandardCharsets.UTF_8);
        String url = "https://openlibrary.org/search.json?title=" + nombreCodificado;
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest peticion = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "PracticaJackson (laurahavadtai@gmail.com)")
                .GET()
                .build();
        try {
            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
            if(respuesta.statusCode() != 200) {
                System.out.println("Error al llamar a la API. Código HTTP: " + respuesta.statusCode());
            } else {
                ObjectMapper mapper = new ObjectMapper();
                // La API de OpenLibrary, al buscar por nombre del libro, devuelve una lista, en este caso voy a quedarme con el primero de esa lista y lo voy a mostrar
                JsonNode raiz = mapper.readTree(respuesta.body());
                // Me quedo con la primera respuesta que hay dentro de docs, que es la parte donde realmente está la respuesta, lo demás es información relacionada con la búsqueda.
                JsonNode primerLibro = raiz.get("docs").get(0);

                Libro l = mapper.readValue(primerLibro.toString(), Libro.class);
                libroToConsola(l);
            }
        } catch (IOException e) {
            System.out.println("No se ha podido completar la consulta a la API: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("La petición se ha interrumpido.");
        }
    }

    public static void libroToConsola(Libro libro) {
        System.out.printf("Título: %s%n", libro.getTitulo());
        System.out.printf("Autores:%n");
        for(String a : libro.getAutores()){
            System.out.printf("  - %s%n", a);
        }
        System.out.printf("Año de publicación: %d%n", libro.getAnioPublicacion());
        System.out.printf("Key para búsqueda del ejemplar: %s%n", libro.getKeyBusquedaEjemplar());
    }

    static void main(String[] args) {
        List<String> librosParaBuscar = new ArrayList<String>();
        librosParaBuscar.add("El Quijote");
        librosParaBuscar.add("Harry Potter y la piedra filosofal");
        librosParaBuscar.add("La Celestina");
        librosParaBuscar.add("Crónica de una muerte anunciada");

        for(String libro : librosParaBuscar){
            System.out.printf("Texto búsqueda: %s%n-----------------------------------------------%n" , libro);
            consultarLibro(libro);
            System.out.println();
        }
    }

}

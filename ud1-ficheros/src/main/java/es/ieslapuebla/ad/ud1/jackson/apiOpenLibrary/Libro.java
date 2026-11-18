package es.ieslapuebla.ad.ud1.jackson.apiOpenLibrary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("author_name")
    private List<String> autores;
    @JsonProperty("first_publish_year")
    private int anioPublicacion;
    @JsonProperty("key")
    private String keyBusquedaEjemplar;


    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public String getKeyBusquedaEjemplar() { return keyBusquedaEjemplar; }
    public void setKeyBusquedaEjemplar(String keyBusquedaEjemplar) { this.keyBusquedaEjemplar = keyBusquedaEjemplar; }

    public List<String> getAutores() { return autores; }
    public void setAutores(List<String> autores) { this.autores = autores; }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", anioPublicacion=" + anioPublicacion +
                ", keyBusquedaEjemplar='" + keyBusquedaEjemplar + '\'' +
                '}';
    }
}

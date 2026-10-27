package es.ieslapuebla.ad.ud1.jackson.libro;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Libros {
    @JsonProperty("Libros")
    private List<Libro> libros = new ArrayList<>();
    public Libros() {}
    public Libros(List<Libro> libros) { this.libros = libros; }
    public List<Libro> getLibros() { return libros; }
    public void setLibros(List<Libro> libros) { this.libros = libros; }
    public Libros add(Libro libro) { this.libros.add(libro); return this; }
}
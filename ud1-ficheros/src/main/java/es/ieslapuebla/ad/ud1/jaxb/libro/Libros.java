package es.ieslapuebla.ad.ud1.jaxb.libro;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Libros")
@XmlAccessorType(XmlAccessType.FIELD)
public class Libros {
    @XmlElement(name = "Libro")
    private List<Libro> libros = new ArrayList<>();
    public Libros() {}
    public List<Libro> getLibros() { return libros; }
    public void setLibros(List<Libro> libros) { this.libros = libros; }
    public void add(Libro libro) { this.libros.add(libro); }
}

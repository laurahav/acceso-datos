package es.ieslapuebla.ad.ud1.jaxb.libro;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"titulo", "autor"})

public class Libro {
    @XmlElement(name = "Titulo")
    private String titulo;
    @XmlElement(name = "Autor")
    private String autor;
    @XmlAttribute(name = "publicado_en")
    private int publicadoEn;
    // Constructor vacío obligatorio
    public Libro() {
    }
    // Constructor con parámetros (opcional)
    public Libro(String titulo, String autor, int publicadoEn) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicadoEn = publicadoEn;
    }
    // Getters y setters (útiles, aunque no requeridos si usamos XmlAccessType.FIELD)
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getPublicadoEn() { return publicadoEn; }
    public void setPublicadoEn(int publicadoEn) { this.publicadoEn = publicadoEn; }
}

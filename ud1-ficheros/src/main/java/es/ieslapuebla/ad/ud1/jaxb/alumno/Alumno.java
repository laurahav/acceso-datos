package es.ieslapuebla.ad.ud1.jaxb.alumno;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"nombre", "edad"})
public class Alumno {
    @XmlElement(name = "Nombre")
    private String nombre;
    @XmlElement(name = "Edad")
    private int edad;
    @XmlAttribute(name = "curso")
    private String curso;
    public Alumno() {}

    public Alumno(String nombre, int edad, String curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCurso() {
        return curso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}

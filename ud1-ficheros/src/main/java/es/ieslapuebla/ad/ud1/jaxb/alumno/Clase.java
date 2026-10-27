package es.ieslapuebla.ad.ud1.jaxb.alumno;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Clase")
@XmlAccessorType(XmlAccessType.FIELD)
public class Clase {
    @XmlElement(name = "Alumno")
    private List<Alumno> clase = new ArrayList<>();
    public Clase() {}

    public List<Alumno> getClase() {
        return clase;
    }

    public void setClase(List<Alumno> clase) {
        this.clase = clase;
    }

    public void add(Alumno alumno) {
        clase.add(alumno);
    }
}
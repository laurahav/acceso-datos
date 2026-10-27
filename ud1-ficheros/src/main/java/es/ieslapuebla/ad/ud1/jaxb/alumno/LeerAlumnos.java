package es.ieslapuebla.ad.ud1.jaxb.alumno;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class LeerAlumnos {
    static void main(String[] args) {
        File xml = new File("clase.xml");
        JAXBContext ctx;
        try {
            ctx = JAXBContext.newInstance(Clase.class);
            Unmarshaller um = ctx.createUnmarshaller();
            Clase clase = (Clase) um.unmarshal(xml);
            System.out.println("Listado de alumnos: ");
            for(Alumno a : clase.getClase()) {
                System.out.printf("- %s (%d años) - %s%n", a.getNombre(), a.getEdad(), a.getCurso());
            }
        } catch (JAXBException e) {
            System.out.println("Error leyendo el XML de la clase: " + e.getMessage());
        }
    }
}

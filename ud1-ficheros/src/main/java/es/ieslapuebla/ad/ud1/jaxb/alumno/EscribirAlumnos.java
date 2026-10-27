package es.ieslapuebla.ad.ud1.jaxb.alumno;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class EscribirAlumnos {
    static void main(String[] args) {
        Clase clase = new Clase();
        clase.add(new Alumno("Atenea", 18, "2DAM"));
        clase.add(new Alumno("Laura", 30, "2DAM"));
        clase.add(new Alumno("Ouail", 20,"2DAM"));

        JAXBContext ctx;
        try {
            ctx = JAXBContext.newInstance(Clase.class);
            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(clase, System.out);
            m.marshal(clase, new File("clase.xml"));
        } catch (JAXBException e) {
            System.out.println("Problema de configuración/serialización: " + e.getMessage());
        }

    }
}

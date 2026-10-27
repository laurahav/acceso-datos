package es.ieslapuebla.ad.ud1.jaxb.libro;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class EscribirLibros {
    public static void main(String[] args) {
        Libros libreria = new Libros();
        libreria.add(new Libro("El Capote", "Nikolai Gogol", 1840));
        libreria.add(new Libro("El Sanador de Caballos", "Gonzalo Giner", 2008));
        libreria.add(new Libro("El Nombre de la Rosa", "Umberto Eco", 1981));
        JAXBContext ctx;
        try {
            ctx = JAXBContext.newInstance(Libros.class);
            Marshaller m = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // 1) A consola
            m.marshal(libreria, System.out);
            // 2) A fichero
            m.marshal(libreria, new File("libros.xml"));
        } catch (JAXBException ex) {
            System.out.println("Problema de configuración/serialización: " +
                    ex.getMessage());
        }
    }
}

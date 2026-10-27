package es.ieslapuebla.ad.ud1.jaxb.libro;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class LeerLibros {
    public static void main(String[] args) {
        File xml = new File("librosJAXB.xml");
        JAXBContext ctx;
        try {
            ctx = JAXBContext.newInstance(Libros.class);
            Unmarshaller um = ctx.createUnmarshaller();
            Libros libreria = (Libros) um.unmarshal(xml);
            System.out.println("Listado de libros:");
            for (Libro l : libreria.getLibros()) {
                System.out.printf("- %s (%d) - %s%n",
                        l.getTitulo(), l.getPublicadoEn(), l.getAutor());
            }
        } catch (JAXBException ex) {
            System.out.println("Error leyendo el XML de libros: " + ex.getMessage());
        }
    }
}

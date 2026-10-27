package es.ieslapuebla.ejercicio3;

public class Elemento {
    private int id;
    private String nombre;
    private double precio;
    private boolean activo;

    public Elemento(int id, String nombre, double precio, boolean activo){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ID: " + id + System.lineSeparator() + "Nombre: " + nombre + System.lineSeparator();
    }
}

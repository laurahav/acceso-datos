package es.ieslapuebla.ejercicio2;

public class Factura {
    private String idFactura;
    private String cliente;
    private String concepto;
    private double importe;

    public Factura(String idFactura, String cliente, String concepto, double importe) {
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.concepto = concepto;
        this.importe = importe;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura='" + idFactura + '\'' +
                ", cliente='" + cliente + '\'' +
                ", concepto='" + concepto + '\'' +
                ", importe=" + importe +
                '}';
    }
}
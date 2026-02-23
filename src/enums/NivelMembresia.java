package enums;

public enum NivelMembresia {

    BASICO(4.99),
    EXCLUSIVO(9.99),
    VIP(19.99);

    private double precioMensual;

    NivelMembresia(double precioMensual) {
        this.precioMensual = precioMensual;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }
}
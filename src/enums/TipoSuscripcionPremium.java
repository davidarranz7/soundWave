package enums;

public enum TipoSuscripcionPremium {

    BASICA(4.99, "Acceso limitado al contenido exclusivo"),
    PRO(9.99, "Acceso completo con beneficios adicionales"),
    ELITE(19.99, "Acceso total con ventajas anticipadas y contenido VIP");

    private double precioMensual;
    private String descripcion;

    TipoSuscripcionPremium(double precioMensual, String descripcion) {
        this.precioMensual = precioMensual;
        this.descripcion = descripcion;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }
}

package enums;

public enum TipoSuscripcion {
    GRATUITO(0.0, false, 50, false),
    PREMIUM(9.99, true, -1, true),
    FAMILIAR(14.99, true, -1, true),
    ESTUDIANTE(4.99, true, -1, true);

    private double precioMensual;
    private boolean sinAnuncios;
    private int limiteResoluciones;
    private boolean descargasOffline;


    TipoSuscripcion(double precioMensual, boolean sinAnuncios, int limiteResoluciones, boolean descargasOffline) {
        this.precioMensual = precioMensual;
        this.sinAnuncios = sinAnuncios;
        this.limiteResoluciones = limiteResoluciones;
        this.descargasOffline = descargasOffline;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }

    public boolean isSinAnuncios() {
        return sinAnuncios;
    }

    public int getLimiteResoluciones() {
        return limiteResoluciones;
    }

    public boolean isDescargasOffline() {
        return descargasOffline;
    }

    public boolean tieneReproduccionesIlimitadas() {
        return this.limiteResoluciones == -1;
    }


    @Override
    public String toString() {
        return name() + ":" + precioMensual + "€/mes)";
    }
}
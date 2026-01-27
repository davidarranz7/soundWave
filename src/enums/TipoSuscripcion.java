package enums;

public enum TipoSuscripcion {
    GRATUITO,
    PREMIUM,
    FAMILIAR,
    ESTUDIANTE;

    private double precioMensual;
    private boolean sinAnuncios;
    private int limiteResoluciones;
    private boolean descargasOffline;


    TipoSuscripcion() {

    }

    public double getPrecioMensual() {
        return precioMensual;
    }

    public void setPrecioMensual(double precioMensual) {
        this.precioMensual = precioMensual;
    }

    public boolean isDescargasOffline() {
        return descargasOffline;
    }

    public void setDescargasOffline(boolean descargasOffline) {
        this.descargasOffline = descargasOffline;
    }

    public int getLimiteResoluciones() {
        return limiteResoluciones;
    }

    public void setLimiteResoluciones(int limiteResoluciones) {
        this.limiteResoluciones = limiteResoluciones;
    }

    public boolean isSinAnuncios() {
        return sinAnuncios;
    }

    public void setSinAnuncios(boolean sinAnuncios) {
        this.sinAnuncios = sinAnuncios;
    }

    public double getPrecioMensual;
    public boolean isSinAnuncios;
}

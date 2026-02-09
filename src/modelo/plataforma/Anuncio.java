package modelo.plataforma;

import enums.TipoAnuncio;

public class Anuncio {

    private String id;
    private String empresa;
    private int duracionSegundos;
    private String audioURL;
    private TipoAnuncio tipo;
    private int impresiones;
    private double presupuesto;
    private boolean activo;

    public Anuncio(String empresa, TipoAnuncio tipo, double presupuesto) {
        this.empresa = empresa;
        this.tipo = tipo;
        this.presupuesto = presupuesto;
        this.activo=true;
        this.impresiones = 0;
    }

    public Anuncio(String empresa, TipoAnuncio tipo, double presupuesto, String audioURL) {
        this.empresa = empresa;
        this.tipo = tipo;
        this.presupuesto = presupuesto;
        this.audioURL = audioURL;
        this.activo=true;
        this.impresiones = 0;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    public TipoAnuncio getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnuncio tipo) {
        this.tipo = tipo;
    }

    public int getImpresiones() {
        return impresiones;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    //metodos propios
    public void reproducir() {

        if (!activo) return;

        registrarImpresion();
    }


    public void registrarImpresion() {
///  revisar si esta bien o no
        if (!activo) return;

        impresiones++;

        presupuesto -= tipo.getCostoPorImpresion();

        if (presupuesto <= 0) {
            activo = false;
        }
    }

    public double calcularCostoPorImpresion() {
        return tipo.getCostoPorImpresion();
    }

    public double calcularCostoTotal(){
        return impresiones * tipo.getCostoPorImpresion();
    }

    public int calcularImpresionesRestantes(){
        if (tipo.getCostoPorImpresion() == 0) return Integer.MAX_VALUE;
        return (int)(presupuesto / tipo.getCostoPorImpresion());
    }

    public void desactivar() {
        activo = false;
    }

    public void activar() {
        if (presupuesto > 0) {
            activo = true;
        }
    }

    public boolean puedeMostrarse(){
        return activo && presupuesto > 0;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

package modelo.contenido;

import enums.DificultadMasterclass;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.contenido.DuracionInvalidaException;
import interfaces.Reproducible;

public class Masterclass extends Contenido implements Reproducible {

    private String instructor;
    private DificultadMasterclass dificultadMasterclass;
    private int numeroLecciones;
    private double precio;
    private boolean reproduciendo;
    private boolean pausado;

    public Masterclass(String titulo, int duracionSegundos, String instructor, DificultadMasterclass dificultadMasterclass, int numeroLecciones, double precio) throws DuracionInvalidaException {
        super(titulo, duracionSegundos);
        if(numeroLecciones <= 0){
            throw new IllegalArgumentException("El número de lecciones debe ser mayor que 0");
        }
        this.instructor = instructor;
        this.dificultadMasterclass = dificultadMasterclass;
        this.numeroLecciones = numeroLecciones;
        this.precio = precio;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public DificultadMasterclass getDificultadMasterclass() {
        return dificultadMasterclass;
    }

    public void setDificultadMasterclass(DificultadMasterclass dificultadMasterclass) {
        this.dificultadMasterclass = dificultadMasterclass;
    }

    public int getNumeroLecciones() {
        return numeroLecciones;
    }

    public void setNumeroLecciones(int numeroLecciones) {
        this.numeroLecciones = numeroLecciones;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isReproduciendo() {
        return reproduciendo;
    }

    public void setReproduciendo(boolean reproduciendo) {
        this.reproduciendo = reproduciendo;
    }

    public boolean isPausado() {
        return pausado;
    }

    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }

    public String esIntensivo(){
        if(duracionSegundos>=7200){
            return "SI";
        }
        return "NO";
    }

    public DificultadMasterclass getDificultad(){
        return dificultadMasterclass;
    }

    public double calcularDuracionMediaPorLeccion(){
        return (double) duracionSegundos / numeroLecciones;
    }


    @Override
    public void play() {
        this.reproduciendo = true;
        this.pausado = false;

        System.out.println("Reproduciendo: " + getTitulo() +
                " (" + getDuracionFormateada() + ")");

    }

    @Override
    public void pause() {

        if (reproduciendo) {
            reproduciendo = false;
            pausado = true;

            System.out.println("Pausado: " + getTitulo());
        }
    }


    @Override
    public void stop() {

        reproduciendo = false;
        pausado = false;

        System.out.println("Detenido: " + getTitulo());
    }

    @Override
    public int getDuracion() {
        return duracionSegundos;
    }

    @Override
    public void reproducir() throws ContenidoNoDisponibleException {
        if (!disponible) {
            throw new ContenidoNoDisponibleException("La canción no está disponible ");
        }
        play();
        aumentarReproducciones();
    }
}

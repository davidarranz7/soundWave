package modelo.contenido;

import enums.CategoriaLiteraria;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.contenido.DuracionInvalidaException;
import excepciones.descarga.ContenidoYaDescargadoException;
import excepciones.descarga.LimiteDescargasException;
import interfaces.Descargable;
import interfaces.Reproducible;

public class Audiolibro extends Contenido implements Descargable, Reproducible {

    private String narrador;
    private int numeroCapitulos;
    private CategoriaLiteraria categoriaLiteraria;
    private boolean reproduciendo;
    private boolean pausado;
    private boolean descargado;

    public Audiolibro(String titulo, int duracionSegundos, String narrador, int numeroCapitulos, CategoriaLiteraria categoriaLiteraria) throws DuracionInvalidaException {
        super(titulo, duracionSegundos);
        this.narrador = narrador;
        this.numeroCapitulos = numeroCapitulos;
        this.categoriaLiteraria = categoriaLiteraria;
    }

    public String getNarrador() {
        return narrador;
    }

    public void setNarrador(String narrador) {
        this.narrador = narrador;
    }

    public int getNumeroCapitulos() {
        return numeroCapitulos;
    }

    public void setNumeroCapitulos(int numeroCapitulos) {
        this.numeroCapitulos = numeroCapitulos;
    }

    public CategoriaLiteraria getCategoria() {
        return categoriaLiteraria;
    }

    public void setCategoriaLiteraria(CategoriaLiteraria categoriaLiteraria) {
        this.categoriaLiteraria = categoriaLiteraria;
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

    public boolean isDescargado() {
        return descargado;
    }

    public void setDescargado(boolean descargado) {
        this.descargado = descargado;
    }

    //metodos propios

    public boolean esExtenso() {
        return this.numeroCapitulos > 50;
    }


    @Override
    public boolean descargar() throws LimiteDescargasException, ContenidoYaDescargadoException {
        return false;
    }

    @Override
    public boolean eliminarDescarga() {
        return false;
    }

    @Override
    public int espacioRequerido() {
        return 0;
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

        if (!isDisponible()) {
            throw new ContenidoNoDisponibleException("El podcast no está disponible");
        }

        play();
        aumentarReproducciones();
    }

    @Override
    public String toString() {
        if(esExtenso()){
            return "Extenso";
        }
        return"";
    }
}

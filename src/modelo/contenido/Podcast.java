package modelo.contenido;

import enums.CategoriaPodcast;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.contenido.DuracionInvalidaException;
import excepciones.contenido.EpisodioNoEncontradoException;
import excepciones.contenido.TranscripcionNoDisponibleException;
import excepciones.descarga.ContenidoYaDescargadoException;
import excepciones.descarga.LimiteDescargasException;
import interfaces.IDescargable;
import interfaces.IReproducible;
import modelo.artistas.Creador;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.DuplicateFormatFlagsException;

public class Podcast extends Contenido implements IDescargable,IReproducible {

    private Creador creador;
    private int numeroEpisodio;
    private int temporada;
    private String descripcion;
    private CategoriaPodcast categoria;
    private ArrayList<String> invitados;
    private String transcripcion;
    private boolean reproduciendo;
    private boolean pausado;
    private boolean descargado;



    public Podcast(String titulo, int duracionSegundos, Creador creador, int numeroEpisodio, int temporada, CategoriaPodcast categoria) throws DuracionInvalidaException {
        super(titulo, duracionSegundos);
        this.creador = creador;
        this.numeroEpisodio = numeroEpisodio;
        this.temporada = temporada;
        this.descripcion = null;
        this.categoria = categoria;
        this.invitados = new ArrayList<>();
        this.transcripcion = null;
        this.reproduciendo = false;
        this.pausado = true;
        this.descargado = false;
    }


    public Podcast(String titulo, int duracionSegundos, Creador creador, int numeroEpisodio, int temporada, String descripcion, CategoriaPodcast categoria) throws DuracionInvalidaException {
        super(titulo, duracionSegundos);
        this.creador = creador;
        this.numeroEpisodio = numeroEpisodio;
        this.temporada = temporada;
        this.descripcion = null;
        this.categoria = categoria;
        this.invitados = new ArrayList<>();
        this.transcripcion = null;
        this.reproduciendo = false;
        this.pausado = true;
        this.descargado = false;
    }

//getters y setters
    public Creador getCreador() {
        return creador;
    }

    public void setCreador(Creador creador) {
        this.creador = creador;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaPodcast getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPodcast categoria) {
        this.categoria = categoria;
    }

    public ArrayList<String> getInvitados() {
        return new ArrayList<>(invitados);
    }


    public String getTranscripcion() {
        return transcripcion;
    }

    public void setTranscripcion(String transcripcion) {
        this.transcripcion = transcripcion;
    }

    public boolean isReproduciendo() {
        return reproduciendo;
    }


    public boolean isPausado() {
        return pausado;
    }

    public boolean isDescargado() {
        return descargado;
    }

    public void setDescargado(boolean descargado) {
        this.descargado = descargado;
    }


    //metodos Propios
    //preguntar
    public String obtenerDescripcion() {

        return descripcion != null && !descripcion.isEmpty() ? descripcion : "No hay descripción disponible";
    }

    //preguntar
    public void agregarInvitado(String nombre) {
        if (nombre != null && !nombre.isEmpty()
                && !invitados.contains(nombre)) {
                invitados.add(nombre);
        }
    }

    public boolean esTemporadaNueva(){
        return numeroEpisodio == 1;
    }

    public String obtenerTranscripcion() throws TranscripcionNoDisponibleException {

        if (transcripcion == null || transcripcion.trim().isEmpty()) {
            throw new TranscripcionNoDisponibleException("No hay transcripción disponible");
        }

        return transcripcion;
    }


    //falta la logica de esto!!!
    public void validarEpisodio() throws EpisodioNoEncontradoException {

        if (temporada <= 0 || numeroEpisodio <= 0) {
            throw new EpisodioNoEncontradoException("Temporada o episodio inválido");
        }
    }


    //metodo del padre
    @Override
    public void reproducir() throws ContenidoNoDisponibleException {

        if (!isDisponible()) {
            throw new ContenidoNoDisponibleException("El podcast no está disponible");
        }

        play();
        aumentarReproducciones();
    }

    //metodos IReproducible

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

    //metodos IDescargable
    //preguntar!!!
    @Override
    public boolean descargar() throws LimiteDescargasException, ContenidoYaDescargadoException {
        if (descargado) {
            throw new ContenidoYaDescargadoException("El contenido ya está descargado");
        }

        descargado = true;
        return true;
    }


    @Override
    public boolean eliminarDescarga() {

        if (descargado) {
            descargado = false;
            return true;
        }

        return false;
    }

    @Override
    public int espacioRequerido() {

        return (duracionSegundos/60)+1;
    }



    @Override
    public String toString() {
        return "Podcast: " + getTitulo() +
                " | Creador: " + creador +
                " | Temporada " + temporada +
                " Episodio " + numeroEpisodio +
                " | Categoría: " + categoria +
                " | Duración: " + getDuracionFormateada();
    }

}

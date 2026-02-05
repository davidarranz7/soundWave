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

    public String obtenerDescripcion(){
        return descripcion;
    }


    public void agregarInvitado(String nombre){
        invitados.add(nombre);
    }

    public boolean esTemporadaNueva(){
        return numeroEpisodio == 1;
    }

    public String obtenerTranscripcion() throws TranscripcionNoDisponibleException {
        return transcripcion;
    }

    //falta la logica de esto!!!
    public void validarEpisodio() throws EpisodioNoEncontradoException {

    }


    //metodo del padre
    @Override
    public void reproducir() throws ContenidoNoDisponibleException {

    }


    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public int getDuracion() {
        return 0;
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
    public String toString() {
        return super.toString();
    }
}

package modelo.contenido;

import enums.CategoriaPodcast;
import interfaces.IDescargable;
import interfaces.IRecomendador;
import interfaces.IReproducible;
import modelo.artistas.Creador;

import java.time.LocalDate;
import java.util.ArrayList;

public class Podcast extends Contenido implements IDescargable, IReproducible {

    private Creador creador;
    private int numeroEpisodio;
    private int temporada;
    private String descripcion;
    private CategoriaPodcast categoriaPodcast;
    private ArrayList<String>invitado;
    private String transcripcion;


    public Podcast(String id, LocalDate fechaPublicacion, boolean disponible, ArrayList<String> tags, int duracionSegundos, int likes, int reproducciones, String titulo, String transcripcion, CategoriaPodcast categoriaPodcast, int numeroEpisodio, Creador creador, int temporada, String descripcion, ArrayList<String> invitados) {
        super(id, fechaPublicacion, disponible, tags, duracionSegundos, likes, reproducciones, titulo);
        this.transcripcion = transcripcion;
        this.categoriaPodcast = categoriaPodcast;
        this.numeroEpisodio = numeroEpisodio;
        this.creador = creador;
        this.temporada = temporada;
        this.descripcion = descripcion;
        this.invitado = new ArrayList<>();
    }

    public Creador getCreador() {
        return creador;
    }

    public void setCreador(Creador creador) {
        this.creador = creador;
    }

    public ArrayList<String> getInvitado() {
        return invitado;
    }

    public void addInvitado(String invitado) {
        this.invitado.add(invitado);
    }

    public CategoriaPodcast getCategoriaPodcast() {
        return categoriaPodcast;
    }

    public void setCategoriaPodcast(CategoriaPodcast categoriaPodcast) {
        this.categoriaPodcast = categoriaPodcast;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getTranscripcion() {
        return transcripcion;
    }

    public void setTranscripcion(String transcripcion) {
        this.transcripcion = transcripcion;
    }

    @Override
    void reproducir() {

    }

    String obtenerDescripcion(){
        return descripcion;
    }

    void agregarInvitado(String nombreInvitado) {

    }

    boolean esTemporadaNueva(){
        return false;
    }


    @Override
    public boolean descargar(Contenido contenido) {
        return false;
    }

    @Override
    public boolean eliminarDescarga(Contenido contenido) {
        return false;
    }

    @Override
    public int espacioRequerido() {
        return 0;
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
}

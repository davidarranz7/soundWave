package modelo.contenido;

import enums.GeneroMusical;
import interfaces.IDescargable;
import interfaces.IReproducible;
import modelo.artistas.Album;
import modelo.artistas.Artista;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cancion extends Contenido implements IDescargable, IReproducible {

    private String letra;
    private Artista artista;
    private Album album;
    private GeneroMusical genero;
    private String audioURL;
    private boolean explicit;
    private String ISRC;


    public Cancion(String id, LocalDate fechaPublicacion, boolean disponible, ArrayList<String> tags, int duracionSegundos, int likes, int reproducciones, String titulo, String letra, String ISRC, boolean explicit, String audioURL, GeneroMusical genero, Album album, Artista artista) {
        super(id, fechaPublicacion, disponible, tags, duracionSegundos, likes, reproducciones, titulo);
        this.letra = letra;
        this.ISRC = ISRC;
        this.explicit = explicit;
        this.audioURL = audioURL;
        this.genero = genero;
        this.album = album;
        this.artista = artista;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getISRC() {
        return ISRC;
    }

    public void setISRC(String ISRC) {
        this.ISRC = ISRC;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    public GeneroMusical getGenero() {
        return genero;
    }

    public void setGenero(GeneroMusical genero) {
        this.genero = genero;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    void reproducir() {

    }


    String obtenerLetra(){
        return letra;
    }

    boolean esExplicita(){
        return false;
    }


    void cambiarGenero(GeneroMusical genero){}


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

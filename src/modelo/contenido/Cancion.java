package modelo.contenido;

import enums.GeneroMusical;
import excepciones.contenido.ArchivoAudioNoEncontradoException;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.contenido.DuracionInvalidaException;
import excepciones.contenido.LetraNoDisponibleException;
import excepciones.descarga.ContenidoYaDescargadoException;
import excepciones.descarga.LimiteDescargasException;
import interfaces.IDescargable;
import interfaces.IReproducible;
import modelo.artistas.Album;
import modelo.artistas.Artista;
import java.util.ConcurrentModificationException;
import java.util.UUID;

public class Cancion extends Contenido implements IDescargable, IReproducible {

    private String letra;
    private Artista artista;
    private Album album;
    private GeneroMusical genero;
    private String audioURL;
    private boolean explicit;
    private String ISRC;
    private boolean reproduciendo;
    private boolean pausado;
    private boolean descargado;


    public Cancion(String titulo, int duracionSegundos, GeneroMusical genero, Artista artista)
            throws DuracionInvalidaException {
        super(titulo, duracionSegundos);
        this.artista = artista;
        this.genero = genero;
        this.letra = null;
        this.album = null;
        this.audioURL = "https://soundwave.com/audio/" + id + ".mp3";
        this.explicit = false;
        this.ISRC = generarISRC();
        this.reproduciendo = false;
        this.pausado = false;
        this.descargado = false;
    }


    public Cancion(String titulo, int duracionSegundos, GeneroMusical genero, Artista artista, String letra, boolean explicit)
            throws DuracionInvalidaException {
        super(titulo, duracionSegundos);
        this.artista = artista;
        this.genero = genero;
        this.letra = null;
        this.album = null;
        this.audioURL = "https://soundwave.com/audio/" + id + ".mp3";
        this.explicit = false;
        this.ISRC = generarISRC();
        this.reproduciendo = false;
        this.pausado = false;
        this.descargado = false;
    }


    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public GeneroMusical getGenero() {
        return genero;
    }

    public void setGenero(GeneroMusical genero) {
        this.genero = genero;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public String getISRC() {
        return ISRC;
    }

    public void setISRC(String ISRC) {
        this.ISRC = ISRC;
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

    //metodo privado
    //preguntar
    public String generarISRC() {
        return "ES-" + UUID.randomUUID().toString().substring(0, 8);
    }

    //metodos propios

    public String obtenerLetra() throws LetraNoDisponibleException {

        if (letra == null || letra.trim().isEmpty()) {
            throw new LetraNoDisponibleException("La canción no tiene letra disponible");
        }
        return letra;
    }


    public boolean esExplicit() {
        return this.explicit;
    }

    public void cambiarGenero(GeneroMusical nuevoGenero) {
        this.genero = nuevoGenero;
    }

    public void validarAudioURL() throws ArchivoAudioNoEncontradoException {

        if (audioURL == null || audioURL.trim().isEmpty()) {
            throw new ArchivoAudioNoEncontradoException("No existe URL de audio");
        }
    }


    //overide del padre
    @Override
    public void reproducir() throws ContenidoNoDisponibleException {
        if (!disponible) {
            throw new ContenidoNoDisponibleException("La canción no está disponible ");
        }
        play();
        aumentarReproducciones();
    }

    //overide de Reproducible
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

    //overide de IDescargable
    @Override
    public boolean descargar() throws ContenidoYaDescargadoException,LimiteDescargasException {

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

    //preguntar
    @Override
    public int espacioRequerido() {

        return (duracionSegundos/60)+1;
    }


    //preguntar
    @Override
    public String toString() {
        return "Canción: " + getTitulo() +
                " | Artista: " + artista +
                " | Duración: " + getDuracionFormateada();
    }

}


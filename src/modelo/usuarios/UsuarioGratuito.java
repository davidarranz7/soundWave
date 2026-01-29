package modelo.usuarios;

import enums.TipoSuscripcion;
import modelo.contenido.Contenido;
import modelo.plataforma.Playlist;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioGratuito extends Usuario{
    private int anunciosEscuchados;
    private LocalDate ultimoAnuncio;
    private int reproduccionesHoy;
    private int limiteReproducciones;
    private int cancionesSinAnuncios;

    public UsuarioGratuito(String id, String nombre, String email, String password, TipoSuscripcion suscripcion, ArrayList<Playlist> misPlaylists, ArrayList<Contenido> contenidos, LocalDate fechaRegistro, int anunciosEscuchados, int cancionesSinAnuncios, int limiteReproducciones, int reproduccionesHoy, LocalDate ultimoAnuncio) {
        super(id, nombre, email, password, suscripcion, misPlaylists, contenidos, fechaRegistro);
        this.anunciosEscuchados = anunciosEscuchados;
        this.cancionesSinAnuncios = cancionesSinAnuncios;
        this.limiteReproducciones = limiteReproducciones;
        this.reproduccionesHoy = reproduccionesHoy;
        this.ultimoAnuncio = ultimoAnuncio;
    }

    public int getAnunciosEscuchados() {
        return anunciosEscuchados;
    }


    public void setAnunciosEscuchados(int anunciosEscuchados) {
        this.anunciosEscuchados = anunciosEscuchados;
    }


    public int getLimiteReproducciones() {
        return limiteReproducciones;
    }


    public void setLimiteReproducciones(int limiteReproducciones) {
        this.limiteReproducciones = limiteReproducciones;
    }


    public int getReproduccionesHoy() {
        return reproduccionesHoy;
    }


    public void setReproduccionesHoy(int reproduccionesHoy) {
        this.reproduccionesHoy = reproduccionesHoy;
    }


    public LocalDate getUltimoAnuncio() {
        return ultimoAnuncio;
    }


    public void setUltimoAnuncio(LocalDate ultimoAnuncio) {
        this.ultimoAnuncio = ultimoAnuncio;
    }


    public int getCancionesSinAnuncios() {
        return cancionesSinAnuncios;
    }


    public void setCancionesSinAnuncios(int cancionesSinAnuncios) {
        this.cancionesSinAnuncios = cancionesSinAnuncios;
    }


    void verAnuncio(){

    }


    boolean puedeReproducir(){
        return true;
    }


    void reiniciarContadorDiario(){

    }


    @Override
    public void reproducir(Contenido contenido) {

    }
}

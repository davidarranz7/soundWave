package modelo.usuarios;

import enums.TipoSuscripcion;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.PasswordDebilException;
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

    public UsuarioGratuito(String nombre, String email, String password, TipoSuscripcion suscripcion, int anunciosEscuchados, LocalDate ultimoAnuncio, int reproduccionesHoy, int limiteReproducciones, int cancionesSinAnuncios) throws EmailInvalidoException, PasswordDebilException {
        super(nombre, email, password, suscripcion);
        this.anunciosEscuchados = anunciosEscuchados;
        this.ultimoAnuncio = ultimoAnuncio;
        this.reproduccionesHoy = reproduccionesHoy;
        this.limiteReproducciones = limiteReproducciones;
        this.cancionesSinAnuncios = cancionesSinAnuncios;
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

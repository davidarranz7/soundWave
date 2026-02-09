package modelo.usuarios;

import enums.TipoAnuncio;
import enums.TipoSuscripcion;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.usuario.AnuncioRequeridoException;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.LimiteDiarioAlcanzadoException;
import excepciones.usuario.PasswordDebilException;
import modelo.contenido.Contenido;
import modelo.plataforma.Playlist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class UsuarioGratuito extends Usuario{
    private int anunciosEscuchados;
    private Date ultimoAnuncio;
    private int reproduccionesHoy;
    private int limiteReproducciones;
    private int cancionesSinAnuncios;
    private Date fechaUltimaReproduccion;
    private static final int LIMITE_DIARIO = 50;
    private static final int CANCIONES_ENTRE_ANUNCIOS = 3;

    public UsuarioGratuito(String nombre, String email, String password) throws EmailInvalidoException, PasswordDebilException {
        super(nombre, email, password, TipoSuscripcion.GRATUITO);
         this.anunciosEscuchados = 0;
         this.ultimoAnuncio = null;
         this.reproduccionesHoy = 0;
         this.limiteReproducciones = LIMITE_DIARIO;
         this.cancionesSinAnuncios = 0;
         this.fechaUltimaReproduccion = null;
    }

    // Getters y Setters


    public int getAnunciosEscuchados() {
        return anunciosEscuchados;
    }

    public Date getUltimoAnuncio() {
        return ultimoAnuncio;
    }

    public int getReproduccionesHoy() {
        return reproduccionesHoy;
    }

    public void setReproduccionesHoy(int reproduccionesHoy) {
        this.reproduccionesHoy = reproduccionesHoy;
    }

    public int getLimiteReproducciones() {
        return limiteReproducciones;
    }


    public int getCancionesSinAnuncios() {
        return cancionesSinAnuncios;
    }

    public void setCancionesSinAnuncios(int cancionesSinAnuncios) {
        this.cancionesSinAnuncios = cancionesSinAnuncios;
    }

    //por que no hay fecha de ultima reproducion?


    //metodos propios

    //ver logica
    public void verAnuncio() {

    }

    //anuncio preguntas
    public void verAnuncio(TipoAnuncio anuncio){

    }


    public boolean puedeReproducir(){
            return reproduccionesHoy < limiteReproducciones;
    }

    public boolean debeVerAnuncio() {
        return cancionesSinAnuncios >= CANCIONES_ENTRE_ANUNCIOS;
    }

    public void reiniciarContadorDiario(){
        if(fechaUltimaReproduccion == null || !fechaUltimaReproduccion.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate().equals(LocalDate.now())){
            reproduccionesHoy = 0;
            fechaUltimaReproduccion = new Date();
        }
    }


    public int getReproduccionesRestantes() {
        return Math.max(0, limiteReproducciones - reproduccionesHoy);
    }

    public int getCancionesEntreAnuncios() {
        return Math.max(0, CANCIONES_ENTRE_ANUNCIOS - cancionesSinAnuncios);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void reproducir(Contenido contenido) throws ContenidoNoDisponibleException, LimiteDiarioAlcanzadoException, AnuncioRequeridoException {

    }





}

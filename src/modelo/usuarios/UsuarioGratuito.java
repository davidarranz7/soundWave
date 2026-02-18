package modelo.usuarios;

import enums.TipoAnuncio;
import enums.TipoSuscripcion;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.usuario.AnuncioRequeridoException;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.LimiteDiarioAlcanzadoException;
import excepciones.usuario.PasswordDebilException;
import modelo.contenido.Contenido;
import modelo.plataforma.Anuncio;
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


    public int getCancionesSinAnuncio() {
        return cancionesSinAnuncios;
    }

    public void setCancionesSinAnuncio(int cancionesSinAnuncios) {
        this.cancionesSinAnuncios = cancionesSinAnuncios;
    }

    //por que no hay fecha de ultima reproducion?


    //metodos propios

    //ver logica
    public void verAnuncio() {
        anunciosEscuchados++;
        cancionesSinAnuncios = 0;
    }

    //anuncio preguntas
    public void verAnuncio(TipoAnuncio anuncio){
        anunciosEscuchados++;
        cancionesSinAnuncios = 0;
    }

    public void verAnuncio(Anuncio anuncio){
        if (anuncio != null) {
            anuncio.reproducir();
            anunciosEscuchados++;
            cancionesSinAnuncios = 0;
        }
    }


    public boolean puedeReproducir(){
            return reproduccionesHoy < limiteReproducciones;
    }

    public boolean debeVerAnuncio() {
        return cancionesSinAnuncios >= CANCIONES_ENTRE_ANUNCIOS;
    }

    public void reiniciarContadorDiario(){
        this.reproduccionesHoy = 0;
    }



    public int getReproduccionesRestantes() {
        return Math.max(0, limiteReproducciones - reproduccionesHoy);
    }

    public int getCancionesHastaAnuncio() {
        return Math.max(0, CANCIONES_ENTRE_ANUNCIOS - cancionesSinAnuncios);
    }

    //override de reproducir


    @Override
    public void reproducir(Contenido contenido) throws ContenidoNoDisponibleException, LimiteDiarioAlcanzadoException, AnuncioRequeridoException {
        if (!contenido.isDisponible()) {
            throw new ContenidoNoDisponibleException("El contenido no está disponible");
        }

        if (!puedeReproducir()) {
            throw new LimiteDiarioAlcanzadoException("Has alcanzado el límite diario de reproducciones");
        }

        if (debeVerAnuncio()) {
            throw new AnuncioRequeridoException("Debes ver un anuncio para continuar reproduciendo");
        }

        contenido.aumentarReproducciones();
        reproduccionesHoy++;
        cancionesSinAnuncios++;
        agregarAlHistorial(contenido);
    }

    //overide

    @Override
    public String toString() {
        return "UsuarioGratuito{nombre='" + nombre + "', email='" + email + "', reproduccionesHoy=" + reproduccionesHoy + "}";
    }



}

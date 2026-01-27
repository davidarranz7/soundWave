package modelo.usuarios;

import modelo.contenido.Contenido;

import java.time.LocalDate;

public class UsuarioGratuito extends Usuario{
    private int anunciosEscuchados;
    private LocalDate ultimoAnuncio;
    private int reproduccionesHoy;
    private int limiteReproducciones;
    private int cancionesSinAnuncios;


    public UsuarioGratuito(String id, String nombre, String email, String password, int anunciosEscuchados, int reproduccionesHoy, LocalDate ultimoAnuncio, int cancionesSinAnuncios, int limiteReproducciones) {
        super(id, nombre, email, password);
        this.anunciosEscuchados = anunciosEscuchados;
        this.reproduccionesHoy = reproduccionesHoy;
        this.ultimoAnuncio = ultimoAnuncio;
        this.cancionesSinAnuncios = cancionesSinAnuncios;
        this.limiteReproducciones = limiteReproducciones;
    }

    public int getAnunciosEscuchados() {
        return anunciosEscuchados;
    }

    public void setAnunciosEscuchados(int anunciosEscuchados) {
        this.anunciosEscuchados = anunciosEscuchados;
    }

    public LocalDate getUltimoAnuncio() {
        return ultimoAnuncio;
    }

    public void setUltimoAnuncio(LocalDate ultimoAnuncio) {
        this.ultimoAnuncio = ultimoAnuncio;
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

    public void setLimiteReproducciones(int limiteReproducciones) {
        this.limiteReproducciones = limiteReproducciones;
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

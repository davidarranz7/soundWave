package modelo.contenido;

import enums.CategoriaPodcast;
import excepciones.contenido.DuracionInvalidaException;
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


    public Podcast(String titulo, int duracionSegundos,Creador creador,int numeroEpisodio,int temporada, CategoriaPodcast categoria) throws DuracionInvalidaException {
        super(titulo, duracionSegundos);
        this.creador = creador;
        this.numeroEpisodio = numeroEpisodio;
        this.temporada = temporada;
        this.categoria = categoria;
        this.invitados = new ArrayList<>();



    }


    public Podcast(String titulo, int duracionSegundos, Creador creador, int numeroEpisodio, int temporada, CategoriaPodcast categoria, String descripcion) throws DuplicateFormatFlagsException {
        super(titulo, duracionSegundos);
        this.creador = creador;
        this.numeroEpisodio = numeroEpisodio;
        this.temporada = temporada;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    //preguntar por que no se puede hacer los demas atributos!!!!

















}

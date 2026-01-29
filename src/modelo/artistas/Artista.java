package modelo.artistas;

import modelo.contenido.Cancion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Artista {

    private String id;
    private String nombreArtistico;
    private String nombreReal;
    private String paisOrigen;
    private ArrayList<Cancion> discografia;
    private ArrayList<Album> albumes;
    private int oyentesMensuales;
    private boolean verificado;
    private String biografia;

    public Artista(String id, String biografia, boolean verificado, int oyentesMensuales, ArrayList<Cancion> discografia, String paisOrigen, String nombreReal, String nombreArtistico, ArrayList<Album> albumes) {
        this.id = id;
        this.biografia = biografia;
        this.verificado = verificado;
        this.oyentesMensuales = oyentesMensuales;
        this.discografia = discografia;
        this.paisOrigen = paisOrigen;
        this.nombreReal = nombreReal;
        this.nombreArtistico = nombreArtistico;
        this.albumes = albumes;
    }

    void publicarCancion(Cancion cancion) {
    }

    Album crearAlbum(String titulo, Date fecha){
        return null;
    }


    ArrayList<Cancion> obtenerTopCanciones(int Cantidad){
        return null;
    }

    double calcularPromedioReproducciones(){
        return 0;
    }

    boolean esVerificado(){
        return false;
    }



}
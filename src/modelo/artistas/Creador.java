package modelo.artistas;

import enums.CategoriaPodcast;
import modelo.contenido.Podcast;
import utilidades.EstadisticasCreador;

import java.util.ArrayList;
import java.util.HashMap;

public class Creador {

    private String id;
    private String nombreCanal;
    private String nombre;
    private ArrayList<Podcast>episodios;
    private int suscriptores;
    private String descripcion;
    private HashMap<String,String>redesSociales;
    private ArrayList<CategoriaPodcast>categoriaPodcasts;


    public Creador(String descripcion, int suscriptores, String nombre, String nombreCanal, String id) {
        this.categoriaPodcasts = new ArrayList<>();
        this.redesSociales = new HashMap<>();
        this.descripcion = descripcion;
        this.suscriptores = suscriptores;
        this.episodios = new ArrayList<>();
        this.nombre = nombre;
        this.nombreCanal = nombreCanal;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCanal() {
        return nombreCanal;
    }

    public void setNombreCanal(String nombreCanal) {
        this.nombreCanal = nombreCanal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Podcast> getEpisodios() {
        return episodios;
    }

    public void addEpisodios(Podcast episodios) {
        this.episodios.add(episodios);
    }

    public int getSuscriptores() {
        return suscriptores;
    }

    public void setSuscriptores(int suscriptores) {
        this.suscriptores = suscriptores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public HashMap<String, String> getRedesSociales() {
        return redesSociales;
    }

    public void addRedesSociales(String key,String redesSocial) {
        this.redesSociales.put(key, redesSocial);
    }

    public ArrayList<CategoriaPodcast> getCategoriaPodcasts() {
        return categoriaPodcasts;
    }

    public void setCategoriaPodcasts(ArrayList<CategoriaPodcast> categoriaPodcasts) {
        this.categoriaPodcasts = categoriaPodcasts;
    }

    void publicarPodcast(Podcast episodio){}


    EstadisticasCreador obtenerEstadisticas;

    void agregarRedSocial(String red, String usuario){}


    double calcularPromedioReproducciones(){
        return 0;
    }

    void eliminarEpisodio(String idEpisodio){

    }


}

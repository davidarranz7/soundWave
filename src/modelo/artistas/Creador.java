package modelo.artistas;

import enums.CategoriaPodcast;
import excepciones.artista.LimiteEpisodiosException;
import excepciones.contenido.EpisodioNoEncontradoException;
import modelo.contenido.Podcast;
import utilidades.EstadisticasCreador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Creador {

    private String id;
    private String nombreCanal;
    private String nombre;
    private ArrayList<Podcast>episodios;
    private int suscriptores;
    private String descripcion;
    private HashMap<String,String>redesSociales;
    private ArrayList<CategoriaPodcast>categoriaPodcasts;
    private static final int MAX_EPISODIOS = 500;


    public Creador(String nombreCanal, String nombre) {
        this.id = UUID.randomUUID().toString();
        this.nombreCanal = nombreCanal;
        this.nombre = nombre;
        this.episodios = new ArrayList<>();
        this.suscriptores = 0;
        this.descripcion = "";
        this.redesSociales = new HashMap<>();
        this.categoriaPodcasts = new ArrayList<>();
    }

    public Creador(String nombreCanal, String nombre, String descripcion) {
        this.id = UUID.randomUUID().toString();
        this.nombreCanal = nombreCanal;
        this.nombre = nombre;
        this.episodios = new ArrayList<>();
        this.suscriptores = 0;
        this.descripcion = descripcion;
        this.redesSociales = new HashMap<>();
        this.categoriaPodcasts = new ArrayList<>();
    }

    public String getId() {
        return id;
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
        return new ArrayList<>(episodios);
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
        return new HashMap<>(redesSociales);
    }

    public ArrayList<CategoriaPodcast> getCategoriaPodcasts() {
        return new ArrayList<>(categoriaPodcasts);
    }

    public int getNumEpisodios(){
        return episodios.size();
    }


    //metodos

    public void publicarPodcast(Podcast episodio) throws LimiteEpisodiosException {
        if (episodios.size() >= MAX_EPISODIOS) {
            throw new LimiteEpisodiosException("No se pueden publicar más episodios.");
        }
        episodio.setCreador(this);
        episodios.add(episodio);
    }


    public EstadisticasCreador obtenerEstadisticas(){
        return new EstadisticasCreador(this);
    }


    public void agregarRedSocial(String red, String usuario) {
        redesSociales.put(red, usuario);
    }

    public double calcularPromedioReproducciones(){
        if (episodios.isEmpty()) {
            return 0.0;
        }
        int totalReproducciones = episodios.stream().mapToInt(Podcast::getReproducciones).sum();
        return (double) totalReproducciones / episodios.size();
    }

    public void eliminarEpisodio(String idEpisodio) throws EpisodioNoEncontradoException{
        boolean eliminado = episodios.removeIf(episodio -> episodio.getId().equals(idEpisodio));
        if (!eliminado) {
            throw new EpisodioNoEncontradoException("Episodio con ID " + idEpisodio + " no encontrado.");
        }
    }


    public int getTotalReproducciones() {
        return episodios.stream().mapToInt(Podcast::getReproducciones).sum();
    }

    public void incrementarSuscriptores() {
        this.suscriptores++;
    }

    //ver logica
    public ArrayList<Podcast> obtenerTopEpisodios(int cantidad) {
        ArrayList<Podcast> copia = new ArrayList<>(episodios);
        copia.sort((p1, p2) ->
                Integer.compare(
                        p2.getReproducciones(),
                        p1.getReproducciones()
                )
        );
        if (cantidad >= copia.size()) {
            return copia;
        }
        return new ArrayList<>(copia.subList(0, cantidad));
    }


    public int getUltimaTemporada(){
        if (episodios.isEmpty()) {
            return 0;
        }
        return episodios.stream().mapToInt(Podcast::getTemporada).max().orElse(0);
    }


    @Override
    public String toString() {
        return "Creador{" +
                "id='" + id + '\'' +
                ", canal='" + nombreCanal + '\'' +
                ", nombre='" + nombre + '\'' +
                ", suscriptores=" + suscriptores +
                ", episodios=" + episodios.size() +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Creador creador = (Creador) obj;
        return id.equals(creador.id);
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }

}

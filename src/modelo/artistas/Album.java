package modelo.artistas;

import enums.GeneroMusical;
import modelo.contenido.Cancion;

import java.time.LocalDate;
import java.util.ArrayList;

public class Album {

    private String id;
    private String titulo;
    private LocalDate fechaLanzamiento;
    private ArrayList<Cancion> canciones;
    private String portadaURL;
    private String discografica;
    private String tipoAlbum;

    public Album(String id, String tipoAlbum, String discografica, String portadaURL, ArrayList<Cancion> canciones, LocalDate fechaLanzamiento, String titulo) {
        this.id = id;
        this.tipoAlbum = tipoAlbum;
        this.discografica = discografica;
        this.portadaURL = portadaURL;
        this.canciones = new ArrayList<>();
        this.fechaLanzamiento = fechaLanzamiento;
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoAlbum() {
        return tipoAlbum;
    }

    public void setTipoAlbum(String tipoAlbum) {
        this.tipoAlbum = tipoAlbum;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    public String getPortadaURL() {
        return portadaURL;
    }

    public void setPortadaURL(String portadaURL) {
        this.portadaURL = portadaURL;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void addCanciones(Cancion canciones) {
        this.canciones.add(canciones);
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }




    Cancion crearCancion(String titulo, int duracion, GeneroMusical genero){
        return null;
    }



    void agregarCancion(Cancion cancion){
    }



    void eliminarCancion(int posicion){

    }


    int getDuracionTotal(){
        return 0;
    }



    int getNumCanciones(){
        return 0;
    }



    void ordenarPorPopularidad() {
    }


}




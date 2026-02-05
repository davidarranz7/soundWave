package modelo.artistas;

import enums.GeneroMusical;
import excepciones.artista.AlbumCompletoException;
import excepciones.contenido.DuracionInvalidaException;
import excepciones.playlist.CancionNoEncontradaException;
import modelo.contenido.Cancion;

import java.util.ArrayList;
import java.util.Date;

public class Album {

    private String id;
    private String titulo;
    private Artista artista;
    private Date fechaLanzamiento;
    private ArrayList<Cancion> canciones;
    private String portadaURL;
    private String discografica;
    private String tipoAlbum;
    private static final int MAX_CANCIONES = 20;

    //constructor


    public Album(String titulo, Artista artista, Date fechaLanzamiento) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.fechaLanzamiento = fechaLanzamiento;
        this.canciones = new ArrayList<>();
        this.portadaURL = portadaURL;
        this.discografica = discografica;
        this.tipoAlbum = tipoAlbum;
    }

    public Album(String titulo, Artista artista, Date fechaLanzamiento, String discografica, String tipoAlbum) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.fechaLanzamiento = fechaLanzamiento;
        this.canciones = new ArrayList<>();
        this.portadaURL = portadaURL;
        this.discografica = discografica;
        this.tipoAlbum = tipoAlbum;
    }



    //getters y setters


    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }


    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }


    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }


    public String getPortadaURL() {
        return portadaURL;
    }

    public void setPortadaURL(String portadaURL) {
        this.portadaURL = portadaURL;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    public String getTipoAlbum() {
        return tipoAlbum;
    }

    public void setTipoAlbum(String tipoAlbum) {
        this.tipoAlbum = tipoAlbum;
    }

    public int getMaxCanciones(){
        return MAX_CANCIONES;
    }

    //metodos composicion

    public Cancion crearCancion(String titulo, int duracionSegundos,GeneroMusical genero)throws AlbumCompletoException, DuracionInvalidaException {

       return null;
    }


    public Cancion crearCancion(String titulo, int duracionSegundos, GeneroMusical genero, String letra, boolean esxplicit) throws AlbumCompletoException, DuracionInvalidaException {

        return null;
    }


    //metodos de la la clase

    public void eliminarCancion(int posicion) throws CancionNoEncontradaException {
        if (posicion < 1 || posicion > canciones.size()) {
            throw new CancionNoEncontradaException("No exite cancion en la posicion especificada");
        }
        Cancion cancion = canciones.remove(posicion -1);
        cancion.setAlbum(null);


    }

    public void eliminarCancion(Cancion cancion) throws CancionNoEncontradaException {

    }

    public int getDuracionTotal() {
        int duracionTotal = 0;
        for (Cancion cancion : canciones) {
            duracionTotal += cancion.getDuracionSegundos();
        }
        return duracionTotal;
    }

    public String getDuracionTotalFormateada(){
        int duracionTotalSegundos = getDuracionTotal();
        int minutos = duracionTotalSegundos / 60;
        int segundos = duracionTotalSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    public int getNumCanciones(){
        return canciones.size();
    }

    public void ordenarPorPopularidad(){
    /*    canciones.sort((c1, c2) ->
                Integer.compare(
                        c2.getNumReproducciones(),
                        c1.getNumReproducciones()
                )
        );*/
    }

    public Cancion getCancion(int posicion) throws CancionNoEncontradaException {
        return null;
    }

    public int getTotalReproducciones(){
    /*    int totalReproducciones = 0;
        for (Cancion cancion : canciones) {
            totalReproducciones += cancion.getNumReproducciones();
        }*/
        return 0;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}




package modelo.artistas;

import enums.GeneroMusical;
import excepciones.artista.AlbumCompletoException;
import excepciones.contenido.DuracionInvalidaException;
import excepciones.playlist.CancionNoEncontradaException;
import modelo.contenido.Cancion;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

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
        this.id = UUID.randomUUID().toString();;
        this.titulo = titulo;
        this.artista = artista;
        this.fechaLanzamiento = fechaLanzamiento;
        this.canciones = new ArrayList<>();
    }

    public Album(String titulo, Artista artista, Date fechaLanzamiento, String discografica, String tipoAlbum) {
        this.id = UUID.randomUUID().toString();;
        this.titulo = titulo;
        this.artista = artista;
        this.fechaLanzamiento = fechaLanzamiento;
        this.canciones = new ArrayList<>();
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
        return new ArrayList<>(canciones);
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

    public Cancion crearCancion(String titulo, int duracionSegundos, GeneroMusical genero)
            throws AlbumCompletoException, DuracionInvalidaException {
        if (canciones.size() >= MAX_CANCIONES) {
            throw new AlbumCompletoException("El álbum está completo");
        }
        Cancion cancion = new Cancion(titulo, duracionSegundos, genero, this.artista);
        canciones.add(cancion);
        return cancion;
    }

    public Cancion crearCancion(String titulo, int duracionSegundos,GeneroMusical genero, String letra, boolean explicit)
            throws AlbumCompletoException, DuracionInvalidaException {
        if (canciones.size() >= MAX_CANCIONES) {
            throw new AlbumCompletoException("El álbum está completo");
        }
        Cancion nueva = new Cancion(titulo, duracionSegundos, genero, artista, letra, explicit);
        canciones.add(nueva);
        return nueva;
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

        if (!canciones.contains(cancion)) {
            throw new CancionNoEncontradaException("La canción no existe en el álbum");
        }

        canciones.remove(cancion);
        cancion.setAlbum(null);
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
        int horas = duracionTotalSegundos / 3600;
        int minutos = (duracionTotalSegundos / 60) % 60;
        int segundos = duracionTotalSegundos % 60;

        if (horas > 0) {
            return String.format("%d:%02d:%02d", horas, minutos, segundos);
        }
        return String.format("%02d:%02d", minutos, segundos);
    }

    public int getNumCanciones(){
        return canciones.size();
    }

    public void ordenarPorPopularidad() {

        canciones.sort((c1, c2) ->
                Integer.compare(
                        c2.getReproducciones(),
                        c1.getReproducciones()
                )
        );
    }

    public Cancion getCancion(int posicion) throws CancionNoEncontradaException {
        if (posicion < 1 || posicion > canciones.size()) {;
            throw new CancionNoEncontradaException("No exite cancion en la posicion especificada");
        }
        return canciones.get(posicion -1);
    }

    public int getTotalReproducciones(){
        int total = 0;
        for (Cancion cancion : canciones) {
            total += cancion.getReproducciones();
        }
        return total;
    }


    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", artista=" + artista.getNombreArtistico() +
                ", fecha=" + fechaLanzamiento +
                ", canciones=" + canciones.size() +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Album album = (Album) obj;
        return id.equals(album.id);
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }
}




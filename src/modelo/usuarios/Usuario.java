package modelo.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import modelo.contenido.Contenido;
import modelo.plataforma.Playlist;

public abstract class  Usuario {
    private String id;
    private String nombre;
    private String email;
    private String password;
    private ArrayList<Playlist> misPlaylists;
    private ArrayList<Contenido> contenidos;
    private LocalDate fechaRegistro;


    public Usuario(String id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.misPlaylists = new ArrayList<>();
        this.contenidos = new ArrayList<>();
        this.fechaRegistro = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public ArrayList<Contenido> getContenidos() {
        return contenidos;
    }

    public void addContenidos(Contenido contenidos) {
        this.contenidos.add(contenidos);
    }

    public ArrayList<Playlist> getPlaylists() {
        return misPlaylists;
    }

    public void addPlaylists(Playlist playlists) {
        this.misPlaylists.add(playlists);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public abstract void reproducir(Contenido contenido);

    Playlist crearPlaylist(String nombre){
        Playlist playlist = new Playlist(nombre);
        misPlaylists.add(playlist);
        return playlist;
    }
    void seguirPLaylist(Playlist playlist){
        misPlaylists.add(playlist);
    }

    void darLike(Contenido contenido) {

    }

    boolean validarEmail(){return true;}
    boolean validarPassword(){return true;}

    void agregarAlHistorial(Contenido contenido){}

}

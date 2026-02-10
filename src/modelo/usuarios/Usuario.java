package modelo.usuarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import enums.TipoSuscripcion;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.usuario.AnuncioRequeridoException;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.LimiteDiarioAlcanzadoException;
import excepciones.usuario.PasswordDebilException;
import modelo.contenido.Contenido;
import modelo.plataforma.Playlist;

public abstract class  Usuario {
    protected String id;
    protected String nombre;
    protected String email;
    protected String password;
    protected TipoSuscripcion suscripcion;
    protected ArrayList<Playlist> misPlaylists;
    protected ArrayList<Contenido> historial;
    protected Date fechaRegistro;
    protected ArrayList<Playlist> playlistsSeguidas;
    protected ArrayList<Contenido> contenidosLiked;
    private static final int LIMITE_HISTORIAL = 1000;



    public Usuario(String nombre, String email, String password, TipoSuscripcion suscripcion) throws EmailInvalidoException, PasswordDebilException {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.suscripcion = suscripcion;
        this.misPlaylists = new ArrayList<>();
        this.historial = new ArrayList<>();
        this.fechaRegistro = fechaRegistro;
        this.playlistsSeguidas = new ArrayList<>();
        this.contenidosLiked = new ArrayList<>();
    }


    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailInvalidoException {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PasswordDebilException {
        this.password = password;
    }

    public TipoSuscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(TipoSuscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public ArrayList<Playlist> getMisPlaylists() {
        return new ArrayList<>(misPlaylists);
    }


    public ArrayList<Contenido> getHistorial() {
        return new ArrayList<>(historial);
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public ArrayList<Playlist> getPlaylistsSeguidas() {
        return new ArrayList<>(playlistsSeguidas);
    }

    public ArrayList<Contenido> getContenidosLiked() {
        return new ArrayList<>(contenidosLiked);
    }


    //metodo abstracto
    public abstract void reproducir(Contenido contenido) throws ContenidoNoDisponibleException, LimiteDiarioAlcanzadoException, AnuncioRequeridoException;




    //metodos propios

    //revisar logicas
    public Playlist crearPlaylist(String nombrePlaylist){
        Playlist nuevaPlaylist = new Playlist(nombrePlaylist,this);
        misPlaylists.add(nuevaPlaylist);
        return nuevaPlaylist;
    }

    public void seguirPlaylist(Playlist playlist){
        if (!playlistsSeguidas.contains(playlist)){
            playlistsSeguidas.add(playlist);
        }
    }

    //logica
    public void darLike(Contenido contenido){


    }

    public void quitarLike(Contenido contenido){


    }


    public boolean validaEmail() throws EmailInvalidoException{
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new EmailInvalidoException("El email no es válido: " + email);
        }
        return true;
    }

    public boolean validarPassword()throws PasswordDebilException{
        if (password == null || password.length() < 8) {
            throw new PasswordDebilException("La contraseña es demasiado débil. Debe tener al menos 8 caracteres.");
        }
        return true;
    }

    public void agregarHistorial(Contenido contenido) {

        if (historial.contains(contenido)) {
            return;
        }

        if (historial.size() >= LIMITE_HISTORIAL) {
            historial.remove(0);
        }

        historial.add(contenido);
    }

    public void limpiarHistorial(){
        historial.clear();
    }

    public boolean esPremium(){
        return suscripcion == TipoSuscripcion.PREMIUM;
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

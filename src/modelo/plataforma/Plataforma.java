package modelo.plataforma;

import enums.CategoriaPodcast;
import enums.GeneroMusical;
import enums.TipoSuscripcion;
import excepciones.artista.AlbumCompletoException;
import excepciones.artista.AlbumYaExisteException;
import excepciones.artista.ArtistaNoVerificadoException;
import excepciones.artista.LimiteEpisodiosException;
import excepciones.contenido.DuracionInvalidaException;
import excepciones.plataforma.ArtistaNoEncontradoException;
import excepciones.plataforma.ContenidoNoEncontradoException;
import excepciones.plataforma.UsuarioYaExisteException;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.PasswordDebilException;
import modelo.artistas.Album;
import modelo.artistas.Artista;
import modelo.artistas.Creador;
import modelo.contenido.Cancion;
import modelo.contenido.Contenido;
import modelo.contenido.Podcast;
import modelo.usuarios.Usuario;
import modelo.usuarios.UsuarioGratuito;
import modelo.usuarios.UsuarioPremium;
import utilidades.RecomendadoIA;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Plataforma {

    private static Plataforma instancia;
    private String nombre;
    private HashMap<String, Usuario> usuarios;
    private HashMap<String, Usuario> usuarioPorEmail;
    private ArrayList<Contenido> catalogo;
    private ArrayList<Playlist> playlistsPublicas;
    private HashMap<String, Artista> artistas;
    private HashMap<String, Creador> creadores;
    private ArrayList<Album> albumes;
    private ArrayList<Anuncio> anuncios;
    private RecomendadoIA recomendador;
    private int totalAnuncioReproducidos;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.usuarios = new HashMap<>(usuarios);
        this.usuarioPorEmail = new HashMap<>(usuarioPorEmail);
        this.catalogo = new ArrayList<>(catalogo);
        this.playlistsPublicas = new ArrayList<>(playlistsPublicas);
        this.artistas = new HashMap<>(artistas);
        this.creadores = new HashMap<>(creadores);
        this.albumes = new ArrayList<>(albumes);
        this.anuncios = new ArrayList<>(anuncios);
        this.recomendador = recomendador;
        this.totalAnuncioReproducidos = totalAnuncioReproducidos;
    }

//getters y setters basicos

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Contenido> getCatalogo() {
        return catalogo;
    }

    public HashMap<String, Artista> getArtistas() {
        return artistas;
    }

    public HashMap<String, Creador> getCreadores() {
        return creadores;
    }

    public ArrayList<Anuncio> getAnuncios() {
        return anuncios;
    }

    public RecomendadoIA getRecomendador() {
        return recomendador;
    }

    public int getTotalUsuario() {
        return usuarios.size();
    }

    public int getTotalContenido() {
        return catalogo.size();
    }

    public int getTotalAnuncioReproducidos() {
        return totalAnuncioReproducidos;
    }

    //metodos Singleton

    public static synchronized Plataforma getInstancia(String nombre) {
        if (instancia == null) {
            instancia = new Plataforma(nombre);
        }
        return instancia;
    }

    public static synchronized Plataforma getInstancia() {
        if (instancia == null) {
            throw new IllegalStateException("La plataforma no ha sido inicializada. Llama a getInstancia(String nombre) primero.");
        }
        return instancia;
    }

    public synchronized void reiniciarInstancia() {
        instancia = null;
    }

    //metodos usuarios

    public UsuarioPremium registrarUsuarioPremium(String nombre, String email, String password, TipoSuscripcion tipo) throws UsuarioYaExisteException, EmailInvalidoException, PasswordDebilException {
        return null;
    }

    public UsuarioPremium registrarUsuarioPremium(String nombre, String email, String password) throws UsuarioYaExisteException, EmailInvalidoException, PasswordDebilException {
        return null;
    }

    public UsuarioGratuito registrarUsuarioGratuito(String nombre, String email, String password) throws UsuarioYaExisteException, EmailInvalidoException, PasswordDebilException{
        return null;
    }

    public ArrayList<UsuarioPremium> getUsuariopremium(){
        return null;
    }

    public ArrayList<UsuarioGratuito> getUsuarioGratuito(){
        return null;
    }

    public ArrayList<Usuario> getTodosLosUsuarios(){
        return null;
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return null;
    }

    //gestionArtista

    public Artista registrarArtista(String nombreArtisto,String nombreReal, String paisorigen, boolean verificado){
        return null;
    }

    public void registrarArtista(Artista artista){

    }

    public ArrayList<Artista> getArtistasVerificados(){
        return null;
    }

    public ArrayList<Artista> getArtistasNoVerificados(){
        return null;
    }

    public Artista buscarArtistaPorNombre(String nombre) throws ArtistaNoEncontradoException {
        return null;
    }

    //gestion Albumes

    public Album crearAlbum(String nombre, String titulo, Date fecha) throws ArtistaNoVerificadoException, AlbumYaExisteException{
        return null;
    }

    public ArrayList<Album> getAlbumes(){
        return null;
    }

    //gestion de canciones

    public Cancion crearCancion(String titulo, int duracion, Artista artista, GeneroMusical genero) throws DuracionInvalidaException {
        return null;
    }

    public Cancion crearCancionEnAlbum(String titulo, int duracion, Artista artista, GeneroMusical genero, Album album) throws DuracionInvalidaException, AlbumCompletoException{
        return null;
    }

    public void agregarContenidoCatalogo(Contenido contenido){

    }

    public ArrayList<Cancion> getCanciones(){
        return null;
    }

    //Gestion de creadores/podcast

    public Creador registrarCreador(String nombreCanal, String nombre, String descripcion){
        return null;
    }

    public void registrarCreador(Creador creador){

    }

    public Podcast crearPodcast(String titulo, int duracion, Creador creador, int numEpisodio, int temporada, CategoriaPodcast categoria) throws DuracionInvalidaException, LimiteEpisodiosException{
        return null;
    }

    public ArrayList<Podcast> getPodcasts(){
        return null;
    }

    public ArrayList<Creador> getTodosLosCreadores(){
        return null;
    }


    //gestion playlists publicas

    public Playlist crearPlaylistPublica(String nombre, Usuario creador){
        return null;
    }

    public ArrayList<Playlist> getPlaylistsPublicas(){
        return null;
    }


    //Busquedas

    public ArrayList<Contenido> buscarContenido(String termino) throws ContenidoNoEncontradoException{
        return null;
    }

    public ArrayList<Cancion> buscarPorGenero(GeneroMusical genero) throws ContenidoNoEncontradoException{
        return null;
    }

    public ArrayList<Podcast> buscarPorCategoria(CategoriaPodcast categoria) throws ContenidoNoEncontradoException{
        return null;
    }

    public ArrayList<Contenido> obtenerTopContenidos(int cantidad){
        return null;
    }

    //anuncios
    public Anuncio obtenerAnuncioAleatorio(){
        return null;
    }

    public void incrementarAnunciosReproducidos(){

    }

    //Estadisticas

    public String obtenerEstadisticasGenerales(){
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}



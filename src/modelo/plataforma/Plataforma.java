package modelo.plataforma;

import enums.TipoSuscripcion;
import excepciones.plataforma.UsuarioYaExisteException;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.PasswordDebilException;
import modelo.artistas.Album;
import modelo.artistas.Artista;
import modelo.artistas.Creador;
import modelo.contenido.Contenido;
import modelo.usuarios.Usuario;
import modelo.usuarios.UsuarioPremium;
import utilidades.RecomendadoIA;

import java.util.ArrayList;
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







}



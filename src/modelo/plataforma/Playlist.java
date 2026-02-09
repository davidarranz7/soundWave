package modelo.plataforma;

import enums.CriterioOrden;
import excepciones.playlist.ContenidoDuplicadoException;
import excepciones.playlist.PlaylistLlenaException;
import excepciones.playlist.PlaylistVaciaException;
import modelo.contenido.Contenido;
import modelo.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Date;

public class Playlist {

    private String id;
    private String nombre;
    private Usuario creador;
    private ArrayList<Contenido> contenidos;
    private boolean esPublica;
    private  int seguidores;
    private String descripcion;
    private String portadaURL;
    private Date fechaCreacion;
    private int maxContenidos;
    private static final int MAX_CONTNIDOS_DEFAULT = 500;

    public Playlist(String nombre, Usuario creador) {
        this.id = id;
        this.nombre = nombre;
        this.creador = creador;
        this.contenidos = new ArrayList<>(contenidos);
        this.esPublica = esPublica;
        this.seguidores = seguidores;
        this.descripcion = descripcion;
        this.portadaURL = portadaURL;
        this.fechaCreacion = fechaCreacion;
        this.maxContenidos = maxContenidos;
    }

    public Playlist(String nombre, Usuario creador, boolean esPublica,String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.creador = creador;
        this.contenidos = new ArrayList<>(contenidos);
        this.esPublica = esPublica;
        this.seguidores = seguidores;
        this.descripcion = descripcion;
        this.portadaURL = portadaURL;
        this.fechaCreacion = fechaCreacion;
        this.maxContenidos = maxContenidos;
    }

    //getters y setters

        public String getId() {
            return id;
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getCreador() {
        return creador;
    }

    public ArrayList<Contenido> getContenidos() {
        return new ArrayList<>(contenidos);
    }

    public boolean isEsPublica() {
        return esPublica;
    }

    public void setEsPublica(boolean esPublica) {
        this.esPublica = esPublica;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPortadaURL() {
        return portadaURL;
    }

    public void setPortadaURL(String portadaURL) {
        this.portadaURL = portadaURL;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public int getMaxContenidos() {
        return maxContenidos;
    }


    //metodos propios

    public void agregarContenido(Contenido contenido) throws PlaylistLlenaException, ContenidoDuplicadoException {

    }

    public boolean eliminarContenido(String idContenido) {
        return false;
    }

    public boolean eliminarContenido(Contenido contenido) {
        return false;
    }

    public void ordenarpor(CriterioOrden criterio) throws PlaylistVaciaException{

    }

    public int getDuracionTotal(){
        return 0;
    }

    public String getDuracionTotalFormateada(){
        return "";
    }

    public void shuffle(){

    }

     public ArrayList<Contenido> buscarContenido(String titulo) {
         return new ArrayList<>();
     }

     public void hacerPublica(){
         this.esPublica = true;
     }

     public void hacerPrivada(){
         this.esPublica = false;
     }

     public void incrementarSeguidores(){
         this.seguidores++;
     }

     public void decrementarSeguidores(){
         if(this.seguidores > 0){
             this.seguidores--;
         }
     }

     public int getNumContenidos(){
         return contenidos.size();
     }

     public boolean estaVacia(){
         return contenidos.isEmpty();
     }

     public Contenido getContenido(int posicion){
            if(posicion >= 0 && posicion < contenidos.size()){
                return contenidos.get(posicion);
            }
            return null;
     }


     //overider


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

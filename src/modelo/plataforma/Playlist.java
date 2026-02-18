package modelo.plataforma;

import enums.CriterioOrden;
import excepciones.playlist.ContenidoDuplicadoException;
import excepciones.playlist.PlaylistLlenaException;
import excepciones.playlist.PlaylistVaciaException;
import modelo.contenido.Contenido;
import modelo.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

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

    //constructores


    public Playlist(String nombre, Usuario creador) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.creador = creador;
        this.contenidos = new ArrayList<>();
        this.esPublica = false;
        this.seguidores = 0;
        this.descripcion = "";
        this.portadaURL = "";
        this.fechaCreacion = new Date();
        this.maxContenidos = MAX_CONTNIDOS_DEFAULT;
    }

    public Playlist(String nombre, Usuario creador, boolean esPublica, String descripcion) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.creador = creador;
        this.contenidos = new ArrayList<>();
        this.esPublica = esPublica;
        this.seguidores = 0;
        this.descripcion = descripcion;
        this.portadaURL = "";
        this.fechaCreacion = new Date();
        this.maxContenidos = MAX_CONTNIDOS_DEFAULT;
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
        if (contenidos.size() >= maxContenidos) {
            throw new PlaylistLlenaException("La playlist está llena");
        }
        if (contenidos.contains(contenido)) {
            throw new ContenidoDuplicadoException("El contenido ya existe en la playlist");
        }
        contenidos.add(contenido);
    }

    public boolean eliminarContenido(String idContenido) {
        for (Contenido contenido : contenidos) {
            if (contenido.getId().equals(idContenido)) {
                return contenidos.remove(contenido);
            }
        }
        return false;
    }

    public boolean eliminarContenido(Contenido contenido) {
        return contenidos.remove(contenido);
    }

    public void ordenarPor(CriterioOrden criterio) throws PlaylistVaciaException{
        if (contenidos.isEmpty()) {
            throw new PlaylistVaciaException("La playlist está vacía");
        }

        if (criterio == CriterioOrden.POPULARIDAD) {
            contenidos.sort((c1, c2) -> Integer.compare(c2.getReproducciones(), c1.getReproducciones()));
        } else if (criterio == CriterioOrden.DURACION) {
            contenidos.sort((c1, c2) -> Integer.compare(c1.getDuracionSegundos(), c2.getDuracionSegundos()));
        } else if (criterio == CriterioOrden.FECHA_AGREGADO) {
            contenidos.sort((c1, c2) -> c1.getFechaPublicacion().compareTo(c2.getFechaPublicacion()));
        } else if (criterio == CriterioOrden.ALFABETICO) {
            contenidos.sort((c1, c2) -> c1.getTitulo().compareTo(c2.getTitulo()));
        } else if (criterio == CriterioOrden.ALEATORIO) {
            shuffle();
        }
    }

    public int getDuracionTotal(){
        return contenidos.stream().mapToInt(Contenido::getDuracionSegundos).sum();
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

    public void shuffle(){
        for (int i = contenidos.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Contenido temp = contenidos.get(i);
            contenidos.set(i, contenidos.get(j));
            contenidos.set(j, temp);
        }
    }

     public ArrayList<Contenido> buscarContenido(String titulo) {
         ArrayList<Contenido> resultados = new ArrayList<>();
         for (Contenido contenido : contenidos) {
             if (contenido.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                 resultados.add(contenido);
             }
         }
         return resultados;
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

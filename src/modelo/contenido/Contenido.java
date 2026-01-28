package modelo.contenido;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Contenido {

    private String id;
    private String titulo;
    private int reproducciones;
    private int likes;
    private int duracionSegundos;
    private ArrayList<String>tags;
    private boolean disponible;
    private LocalDate fechaPublicacion;

    public Contenido(String id, LocalDate fechaPublicacion, boolean disponible, ArrayList<String> tags, int duracionSegundos, int likes, int reproducciones, String titulo) {
        this.id = id;
        this.fechaPublicacion = fechaPublicacion;
        this.disponible = disponible;
        this.tags = new ArrayList<>();
        this.duracionSegundos = duracionSegundos;
        this.likes = likes;
        this.reproducciones = reproducciones;
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void addTags(String tags) {
        this.tags.add(tags);
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    abstract void reproducir();

    void aumentarReproducciones(){}

    void agregarLike(){}

    boolean esPopular(){
        return false;
    }

    void validarDuracion(){}



}

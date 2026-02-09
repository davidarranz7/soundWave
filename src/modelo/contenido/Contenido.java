package modelo.contenido;
import excepciones.contenido.ContenidoNoDisponibleException;

import java.util.*;

public abstract class Contenido {

    protected String id;
    protected String titulo;
    protected int reproducciones;
    protected int likes;
    protected int duracionSegundos;
    protected ArrayList<String>tags;
    protected boolean disponible;
    protected Date fechaPublicacion;

public Contenido(String titulo,int duracionSegundos) throws DuplicateFormatFlagsException {
    if (duracionSegundos <=0){
        throw new DuplicateFormatFlagsException("La duracion debe ser mayor a 0");
    }
    this.id = UUID.randomUUID().toString();
    this.titulo = titulo;
    this.duracionSegundos = duracionSegundos;
    this.reproducciones = 0;
    this.likes = 0;
    this.tags = new ArrayList<>();
    this.disponible = true;
    this.fechaPublicacion = new Date();

}
    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public int getLikes() {
        return likes;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public ArrayList<String> getTags() {
        return new ArrayList<>(tags);
    }

    public boolean isDisponible() {
        return disponible;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }


    public abstract void reproducir() throws ContenidoNoDisponibleException;



    public void  aumentarReproducciones(){
        this.reproducciones ++;
    }

    public void agregarLike(String tag){
        this.likes ++;
    }

    public boolean esPopular(){
        return this.reproducciones > 100000;
    }

    public void validarDisponibilidad() throws DuplicateFormatFlagsException{

    }

    public void agregarTag(String tag) {
        if ( tag!= null && !tag.trim().isEmpty() && !tags.contains(tag)) {
            tags.add(tag.toLowerCase());
        }

    }

    public boolean tieneTag(String tag) {
        return tags.contains(tag.toLowerCase()) ;
    }

    public void marcarNoDisponible() {
    }


    public void marcarDisponible() {
    }

    public String getDuracionFormateada() {
        int minutos = duracionSegundos / 60;
        int segundos = duracionSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    @Override
    public String toString() {
        return "contenido" + titulo + "duracion" + getDuracionFormateada();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contenido contenido = (Contenido) obj;
        return Objects.equals(id, contenido.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

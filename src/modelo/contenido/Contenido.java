package modelo.contenido;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.contenido.DuracionInvalidaException;

import java.util.*;

//FINALIZADO SOLO REVISAR LOS OVERRIDER!!!
public abstract class Contenido {

    protected String id;
    protected String titulo;
    protected int reproducciones;
    protected int likes;
    protected int duracionSegundos;
    protected ArrayList<String>tags;
    protected boolean disponible;
    protected Date fechaPublicacion;

public Contenido(String titulo,int duracionSegundos) throws DuracionInvalidaException {
    if (duracionSegundos <=0){
        throw new DuracionInvalidaException("La duracion debe ser mayor a 0");
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


    //metodo abstracto
    public abstract void reproducir() throws ContenidoNoDisponibleException;



    //metodos propios

    public void  aumentarReproducciones(){
        this.reproducciones ++;
    }

    public void agregarLike(){
        this.likes ++;
    }

    public boolean esPopular(){
        return this.reproducciones > 100000;
    }

    public void validarDuracion() throws DuracionInvalidaException {
        if (duracionSegundos <= 0) {
            throw new DuracionInvalidaException("La duración debe ser mayor que 0");
        }
    }


    public void agregarTag(String tag) {
        if(tag == null) {
            return;//lo hacemos para que si una persona manda un tag vacio no se pueda agregar!!
        }
        String limpio = tag.trim().toLowerCase();//esto se hace para que si una persona manda un tag con espacios o mayusculas se pueda agregar igual!! y no se duplique por eso mismo!!

        if (!limpio.isEmpty() && !tags.contains(limpio)) {
            tags.add(limpio);
        }
    }

    public boolean tieneTag(String tag) {
        if(tag == null){
            return false;
        }
        String limpio = tag.trim().toLowerCase();

        if(limpio.isEmpty()) {
            return false;
        }
        return tags.contains(limpio);
    }

    public void marcarNoDisponible() {
        this.disponible = false;
    }



    public void marcarDisponible() {
        this.disponible = true;
    }

    public String getDuracionFormateada() {
        int minutos = duracionSegundos / 60;
        int segundos = duracionSegundos % 60;
        return String.format("%d:%02d", minutos, segundos);
    }


    //override

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

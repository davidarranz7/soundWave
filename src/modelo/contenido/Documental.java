package modelo.contenido;

import enums.TematicaDocumental;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.contenido.DuracionInvalidaException;
import interfaces.Reproducible;

import java.util.Date;

public class Documental extends Contenido implements Reproducible {

    private String director;
    private TematicaDocumental tematica;
    private Date fechaEstreno;
    private boolean narracion;

    public Documental(String titulo, int duracionSegundos, String director, TematicaDocumental tematica, Date fechaEstreno, boolean narracion) throws DuracionInvalidaException {
        super(titulo, duracionSegundos);

        if(fechaEstreno.after(new Date())){
            throw new IllegalArgumentException("La fecha de estreno no puede ser futura.");
        }

        this.director = director;
        this.tematica = tematica;
        this.fechaEstreno = fechaEstreno;
        this.narracion = narracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public TematicaDocumental getTematica() {
        return tematica;
    }

    public void setTematica(TematicaDocumental tematica) {
        this.tematica = tematica;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public boolean isNarracion() {
        return narracion;
    }

    public void setNarracion(boolean narracion) {
        this.narracion = narracion;
    }


    public String esLargo(){
        if(duracionSegundos > 5400){
            return "Largo";
        } else {
            return "Corto";
        }
    }

    public int calcularAntiguedad(){
        return new Date().getYear() - fechaEstreno.getYear();
    }

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public int getDuracion() {
        return 0;
    }

    @Override
    public void reproducir() throws ContenidoNoDisponibleException {

    }
}

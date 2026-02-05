package modelo.usuarios;
import enums.TipoSuscripcion;
import excepciones.contenido.ContenidoNoDisponibleException;
import excepciones.descarga.ContenidoYaDescargadoException;
import excepciones.descarga.LimiteDescargasException;
import excepciones.usuario.AnuncioRequeridoException;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.LimiteDiarioAlcanzadoException;
import excepciones.usuario.PasswordDebilException;
import interfaces.IDescargable;
import modelo.contenido.Contenido;
import modelo.plataforma.Playlist;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioPremium extends Usuario {
    private boolean descargasOffline;
    private int maxDescargas;
    private ArrayList<Contenido>descargados;
    private String calidadAudio;
    private static final int MAX_DESCARGAS_DEFAULT = 100;

    public UsuarioPremium(String nombre, String email, String password) throws EmailInvalidoException, PasswordDebilException {
        super(nombre, email, password, TipoSuscripcion.PREMIUM);
        this.descargasOffline = descargasOffline;
        this.maxDescargas = maxDescargas;
        this.descargados = new ArrayList<>();
        this.calidadAudio = calidadAudio;
    }

    public UsuarioPremium(String nombre, String email, String password, TipoSuscripcion suscripcion) throws EmailInvalidoException, PasswordDebilException {
        super(nombre, email, password, suscripcion);
        this.descargasOffline = descargasOffline;
        this.maxDescargas = maxDescargas;
        this.descargados = new ArrayList<>();
        this.calidadAudio = calidadAudio;
    }


    //getters y setters
    public boolean isDescargasOffline() {
        return descargasOffline;
    }

    public void setDescargasOffline(boolean descargasOffline) {
        this.descargasOffline = descargasOffline;
    }

    public int getMaxDescargas() {
        return maxDescargas;
    }

    public ArrayList<Contenido> getDescargados() {
        return new ArrayList<>(descargados);
    }

    public int getNumDescargados(){
        return descargados.size();
    }

    public String getCalidadAudio() {
        return calidadAudio;
    }

    public void setCalidadAudio(String calidadAudio) {
        this.calidadAudio = calidadAudio;
    }

    //mertodos propios
    public void descragar(Contenido contenido) throws LimiteDescargasException, ContenidoYaDescargadoException{
        if(descargados.size() >= maxDescargas){
            throw new LimiteDescargasException("Has alcanzado el límite de descargas permitidas.");
        }
        if(descargados.contains(contenido)){
            throw new ContenidoYaDescargadoException("Este contenido ya ha sido descargado.");
        }
        descargados.add(contenido);
    }

    public boolean eliminarDescarga(Contenido contenido){
        return descargados.remove(contenido);

    }

    //revisar esto
    public boolean verificarEspacioDescarga(){
        return descargados.size() < maxDescargas;
    }

    public int getDescargasRestantes(){
        return maxDescargas - descargados.size();
    }

    public void cambiarCalidadAudio(String calidad){
        setCalidadAudio(calidad);
    }

    public void limpiarDescargas(){
        descargados.clear();
    }

    //Override del padre ver logica


    @Override
    public void reproducir(Contenido contenido) throws ContenidoNoDisponibleException, LimiteDiarioAlcanzadoException, AnuncioRequeridoException {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package modelo.usuarios;
import enums.TipoSuscripcion;
import interfaces.IDescargable;
import modelo.contenido.Contenido;
import modelo.plataforma.Playlist;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioPremium extends Usuario implements IDescargable{
    private boolean descargasOffline;
    private int maxDescargas;
    private ArrayList<Contenido>descargados;
    private String calidadAudio;

    public UsuarioPremium(String id, String nombre, String email, String password, TipoSuscripcion suscripcion, ArrayList<Playlist> misPlaylists, ArrayList<Contenido> contenidos, LocalDate fechaRegistro, boolean descargasOffline, String calidadAudio, ArrayList<Contenido> descargados, int maxDescargas) {
        super(id, nombre, email, password, suscripcion, misPlaylists, contenidos, fechaRegistro);
        this.descargasOffline = descargasOffline;
        this.calidadAudio = calidadAudio;
        this.descargados = new ArrayList<>();
        this.maxDescargas = maxDescargas;
    }

    public boolean isDescargasOffline() {
        return descargasOffline;
    }

    public void setDescargasOffline(boolean descargasOffline) {
        this.descargasOffline = descargasOffline;
    }

    public String getCalidadAudio() {
        return calidadAudio;
    }

    public void setCalidadAudio(String calidadAudio) {
        this.calidadAudio = calidadAudio;
    }

    public ArrayList<Contenido> getDescargados() {
        return descargados;
    }

    public void addDescargados(Contenido descargados) {
        this.descargados.add(descargados);
    }

    public int getMaxDescargas() {
        return maxDescargas;
    }

    public void setMaxDescargas(int maxDescargas) {
        this.maxDescargas = maxDescargas;
    }



    @Override
    public void reproducir(Contenido contenido) {

    }

    boolean vereficarEspacio(){
    return true;
    }


    @Override
    public boolean descargar(Contenido contenido) {
        return false;
    }

    @Override
    public boolean eliminarDescarga(Contenido contenido) {
        return false;
    }

    @Override
    public int espacioRequerido() {
        return 0;
    }
}

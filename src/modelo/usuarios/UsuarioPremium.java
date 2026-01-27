package modelo.usuarios;
import modelo.contenido.Contenido;
import java.util.ArrayList;

public class UsuarioPremium extends Usuario {
    private boolean descargasOffline;
    private int maxDescargas;
    private ArrayList<Contenido>descargados;
    private String calidadAudio;

    public UsuarioPremium(String id, String nombre, String email, String password, boolean descargasOffline, String calidadAudio, ArrayList<Contenido> descargados, int maxDescargas) {
        super(id, nombre, email, password);
        this.descargasOffline = descargasOffline;
        this.calidadAudio = calidadAudio;
        this.descargados = descargados;
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

    void descargar(Contenido contenido){

    }
    void eliminarDescarga(Contenido contenido){

    }
    boolean vereficarEspacio(){
        return true;
    }



    @Override
    public void reproducir(Contenido contenido) {

    }
}

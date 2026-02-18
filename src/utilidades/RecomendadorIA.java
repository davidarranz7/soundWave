package utilidades;

import enums.AlgoritmoRecomendacion;
import enums.GeneroMusical;
import enums.CategoriaPodcast;
import excepciones.recomendacion.HistorialVacioException;
import excepciones.recomendacion.ModeloNoEntrenadoException;
import excepciones.recomendacion.RecomendacionException;
import interfaces.Recomendador;
import modelo.contenido.Cancion;
import modelo.contenido.Contenido;
import modelo.contenido.Podcast;
import modelo.usuarios.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public class RecomendadorIA implements Recomendador {

    private HashMap<String, ArrayList<String>> matrizPreferencias;
    private HashMap<String, ArrayList<Contenido>> historialCompleto;
    private AlgoritmoRecomendacion algoritmo;
    private double umbralSimilitud;
    private boolean modeloEntrenado;
    private ArrayList<Contenido> catalogoReferencia;
    private static final double UMBRAL_DEFAULT = 0.6;

    //constructores

    public RecomendadorIA() {
        this.matrizPreferencias = new HashMap<>();
        this.historialCompleto = new HashMap<>();
        this.catalogoReferencia = new ArrayList<>();
        this.umbralSimilitud = UMBRAL_DEFAULT;
        this.modeloEntrenado = false;
    }

    public RecomendadorIA(AlgoritmoRecomendacion algoritmo) {
        this.matrizPreferencias = new HashMap<>();
        this.historialCompleto = new HashMap<>();
        this.algoritmo = algoritmo;
        this.catalogoReferencia = new ArrayList<>();
        this.umbralSimilitud = UMBRAL_DEFAULT;
        this.modeloEntrenado = false;
    }

    // Getters y Setters
    public AlgoritmoRecomendacion getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(AlgoritmoRecomendacion algoritmo) {
        this.algoritmo = algoritmo;
    }

    public double getUmbralSimilitud() {
        return umbralSimilitud;
    }

    public void setUmbralSimilitud(double umbralSimilitud) {
        this.umbralSimilitud = umbralSimilitud;
    }

    public boolean isModeloEntrenado() {
        return modeloEntrenado;
    }

    public HashMap<String, ArrayList<String>> getMatrizPreferencias() {
        return new HashMap<>(matrizPreferencias);
    }

    public void setCatalogoReferencia(ArrayList<Contenido> catalogoReferencia) {
        this.catalogoReferencia = new ArrayList<>(catalogoReferencia);
    }

    //metodos propios
    public void entrenarModelo(){
        this.modeloEntrenado = true;
    }

    public void entrenarModelo(ArrayList<Usuario> usuarios, ArrayList<Contenido> catalogo){
        if (usuarios == null || usuarios.isEmpty()) {
            return;
        }

        this.catalogoReferencia = new ArrayList<>(catalogo);

        for (Usuario usuario : usuarios) {
            historialCompleto.put(usuario.getId(), new ArrayList<>(usuario.getHistorial()));
            actualizarPreferencias(usuario);
        }

        this.modeloEntrenado = true;
    }

    public double calcularSimilitud(Usuario usuario1, Usuario usuario2){
        if (usuario1 == null || usuario2 == null) {
            return 0.0;
        }

        ArrayList<String> pref1 = matrizPreferencias.getOrDefault(usuario1.getId(), new ArrayList<>());
        ArrayList<String> pref2 = matrizPreferencias.getOrDefault(usuario2.getId(), new ArrayList<>());

        if (pref1.isEmpty() || pref2.isEmpty()) {
            return 0.0;
        }

        int coincidencias = 0;
        for (String p1 : pref1) {
            if (pref2.contains(p1)) {
                coincidencias++;
            }
        }

        int total = Math.max(pref1.size(), pref2.size());
        return (double) coincidencias / total;
    }

    public void actualizarPreferencias(Usuario usuario){
        if (usuario == null) {
            return;
        }

        ArrayList<String> preferencias = new ArrayList<>();
        ArrayList<Contenido> historial = usuario.getHistorial();

        for (Contenido contenido : historial) {
            if (contenido instanceof Cancion) {
                Cancion cancion = (Cancion) contenido;
                String genero = cancion.getGenero().name();
                if (!preferencias.contains(genero)) {
                    preferencias.add(genero);
                }
            } else if (contenido instanceof Podcast) {
                Podcast podcast = (Podcast) contenido;
                String categoria = podcast.getCategoria().name();
                if (!preferencias.contains(categoria)) {
                    preferencias.add(categoria);
                }
            }
        }

        matrizPreferencias.put(usuario.getId(), preferencias);
    }

    public HashMap<String, Integer> obtenerGenerosPopulares(){
        HashMap<String, Integer> generosPopulares = new HashMap<>();

        for (ArrayList<String> preferencias : matrizPreferencias.values()) {
            for (String pref : preferencias) {
                generosPopulares.put(pref, generosPopulares.getOrDefault(pref, 0) + 1);
            }
        }

        return generosPopulares;
    }


    //metodo privado
    private double calcularSimilitudContenido(Contenido contenido, ArrayList<String> preferencias){
        if (contenido instanceof Cancion) {
            Cancion cancion = (Cancion) contenido;
            String genero = cancion.getGenero().name();
            if (preferencias.contains(genero)) {
                return 0.8;
            }
        } else if (contenido instanceof Podcast) {
            Podcast podcast = (Podcast) contenido;
            String categoria = podcast.getCategoria().name();
            if (preferencias.contains(categoria)) {
                return 0.8;
            }
        }

        return 0.0;
    }

    //implementacion Recomendador
    @Override
    public ArrayList<Contenido> recomendar(Usuario usuario)
            throws RecomendacionException {

        if (!modeloEntrenado) {
            throw new ModeloNoEntrenadoException("El modelo no ha sido entrenado");
        }

        if (usuario == null) {
            throw new RecomendacionException("Usuario inválido");
        }

        ArrayList<Contenido> historial = usuario.getHistorial();

        if (historial.isEmpty()) {
            throw new HistorialVacioException("El usuario no tiene historial");
        }

        ArrayList<Contenido> recomendaciones = new ArrayList<>();

        for (Contenido contenido : catalogoReferencia) {
            if (!historial.contains(contenido)) {
                recomendaciones.add(contenido);
            }
        }

        return recomendaciones;
    }

    @Override
    public ArrayList<Contenido> obtenerSimilares(Contenido contenido) throws RecomendacionException {
        ArrayList<Contenido> similares = new ArrayList<>();

        if (contenido instanceof Cancion) {
            Cancion cancion = (Cancion) contenido;
            GeneroMusical genero = cancion.getGenero();

            for (Contenido c : catalogoReferencia) {
                if (c instanceof Cancion && !c.equals(contenido)) {
                    if (((Cancion) c).getGenero() == genero) {
                        similares.add(c);
                    }
                }
            }
        } else if (contenido instanceof Podcast) {
            Podcast podcast = (Podcast) contenido;
            CategoriaPodcast categoria = podcast.getCategoria();

            for (Contenido c : catalogoReferencia) {
                if (c instanceof Podcast && !c.equals(contenido)) {
                    if (((Podcast) c).getCategoria() == categoria) {
                        similares.add(c);
                    }
                }
            }
        }

        return similares;
    }

}

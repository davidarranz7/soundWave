package utilidades;

import enums.CategoriaPodcast;
import modelo.contenido.Podcast;

import java.util.HashMap;

public class EstadisticasCreador {

    private int totalEpisodios;
    private long totalReproducciones;
    private double promedioReproducciones;
    private Podcast episodioMasPopular;
    private HashMap<CategoriaPodcast, Integer> categoriaFrecuentes;


    public EstadisticasCreador(int totalEpisodios, HashMap<CategoriaPodcast, Integer> categoriaFrecuentes, double promedioReproducciones, long totalReproducciones, Podcast episodioMasPopular) {
        this.totalEpisodios = totalEpisodios;
        this.categoriaFrecuentes = new HashMap<>();
        this.promedioReproducciones = promedioReproducciones;
        this.totalReproducciones = totalReproducciones;
        this.episodioMasPopular = episodioMasPopular;
    }

    public int getTotalEpisodios() {
        return totalEpisodios;
    }

    public void setTotalEpisodios(int totalEpisodios) {
        this.totalEpisodios = totalEpisodios;
    }

    public HashMap<CategoriaPodcast, Integer> getCategoriaFrecuentes() {
        return categoriaFrecuentes;
    }

    public void setCategoriaFrecuentes(CategoriaPodcast, Integer categoriaFrecuentes) {
        this.categoriaFrecuentes.put(CategoriaPodcast, categoriaFrecuentes);
    }

    public Podcast getEpisodioMasPopular() {
        return episodioMasPopular;
    }

    public void setEpisodioMasPopular(Podcast episodioMasPopular) {
        this.episodioMasPopular = episodioMasPopular;
    }

    public double getPromedioReproducciones() {
        return promedioReproducciones;
    }

    public void setPromedioReproducciones(double promedioReproducciones) {
        this.promedioReproducciones = promedioReproducciones;
    }

    public long getTotalReproducciones() {
        return totalReproducciones;
    }

    public void setTotalReproducciones(long totalReproducciones) {
        this.totalReproducciones = totalReproducciones;
    }
}

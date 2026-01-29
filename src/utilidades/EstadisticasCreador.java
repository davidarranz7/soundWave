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
}

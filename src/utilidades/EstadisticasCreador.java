package utilidades;

import modelo.artistas.Creador;
import modelo.contenido.Podcast;

import java.util.HashMap;

public class EstadisticasCreador {

    private Creador creador;
    private int totalEpisodios;
    private int totalReproducciones;
    private double promedioReproducciones;
    private int totalSuscriptores;
    private int totalLikes;
    private int duracionTotalSegundos;
    private Podcast episodioMasPopular;
    private HashMap<Integer, Integer> episodiosPorTemporada;

    //constructor

    public EstadisticasCreador(Creador creador) {
        this.creador = creador;
        this.episodiosPorTemporada = new HashMap<>();
        calcularEstadisticas();
    }

    //getters y setters

    public Creador getCreador() {
        return creador;
    }

    public int getTotalEpisodios() {
        return totalEpisodios;
    }

    public int getTotalReproducciones() {
        return totalReproducciones;
    }

    public double getPromedioReproducciones() {
        return promedioReproducciones;
    }

    public int getTotalSuscriptores() {
        return totalSuscriptores;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public int getDuracionTotalSegundos() {
        return duracionTotalSegundos;
    }

    public Podcast getEpisodioMasPopular() {
        return episodioMasPopular;
    }

    public HashMap<Integer, Integer> getEpisodiosPorTemporada() {
        return new HashMap<>(episodiosPorTemporada);
    }

    //metodos privados

    private void calcularEstadisticas() {
        this.totalEpisodios = creador.getNumEpisodios();
        this.totalSuscriptores = creador.getSuscriptores();
        this.totalReproducciones = 0;
        this.totalLikes = 0;
        this.duracionTotalSegundos = 0;
        this.episodioMasPopular = null;
        int maxReproducciones = 0;

        for (Podcast podcast : creador.getEpisodios()) {
            this.totalReproducciones += podcast.getReproducciones();
            this.totalLikes += podcast.getLikes();
            this.duracionTotalSegundos += podcast.getDuracionSegundos();

            if (podcast.getReproducciones() > maxReproducciones) {
                maxReproducciones = podcast.getReproducciones();
                this.episodioMasPopular = podcast;
            }

            // Contar episodios por temporada
            int temporada = podcast.getTemporada();
            episodiosPorTemporada.put(temporada, episodiosPorTemporada.getOrDefault(temporada, 0) + 1);
        }

        if (totalEpisodios > 0) {
            this.promedioReproducciones = (double) totalReproducciones / totalEpisodios;
        }
    }
    //revisar logica
    private String formatearDuracion(int segundos){
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segs = segundos % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segs);
    }

    //metodos publicos
    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== REPORTE DE ESTADÍSTICAS ===\n");
        sb.append("Canal: ").append(creador.getNombreCanal()).append("\n");
        sb.append("Total Episodios: ").append(totalEpisodios).append("\n");
        sb.append("Total Suscriptores: ").append(totalSuscriptores).append("\n");
        sb.append("Total Reproducciones: ").append(totalReproducciones).append("\n");
        sb.append("Promedio Reproducciones: ").append(String.format("%.2f", promedioReproducciones)).append("\n");
        sb.append("Duración Total: ").append(formatearDuracion(duracionTotalSegundos)).append("\n");
        if (episodioMasPopular != null) {
            sb.append("Episodio Más Popular: ").append(episodioMasPopular.getTitulo()).append("\n");
        }
        return sb.toString();
    }

    public double calcularEngagement(){
        if (totalSuscriptores == 0) return 0.0;
        return (double) totalLikes / totalSuscriptores * 100;
    }

    public int estimacionCrecimientoMensual(){
        //revisar logica
        return (int) (promedioReproducciones * 0.1);
    }

    //overrides

    @Override
    public String toString() {
        return super.toString();
    }
}

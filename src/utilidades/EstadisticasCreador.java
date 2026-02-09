package utilidades;

import modelo.artistas.Creador;
import modelo.contenido.Podcast;

import java.util.HashMap;

public class EstadisticasCreador {

    private Creador creador;
    private int totalEpisodios;
    private int totatReproducciones;
    private double promedioReproducciones;
    private int totalSuscriptores;
    private int totalLikes;
    private int duracionTotalSegundos;
    private Podcast episodioMasPopular;
    private HashMap<Integer, Integer> episodiosPorTemporada; // Clave: Mes (1-12), Valor: Total de reproducciones


    public EstadisticasCreador(Creador creador) {
        this.creador = creador;
        this.episodiosPorTemporada = new HashMap<>();
    }

    //getters y setters

    public Creador getCreador() {
        return creador;
    }

    public int getTotalEpisodios() {
        return totalEpisodios;
    }

    public int getTotatReproducciones() {
        return totatReproducciones;
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

    //revisar logica
    private void calcularEstadisticas() {

    }
    //revisar logica
    private String formatearDuracion(int segundos){
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segs = segundos % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segs);
    }
    public String generarReporte(){
        StringBuilder reporte = new StringBuilder();
        reporte.append("Estadísticas del Creador: ").append(creador.getNombre()).append("\n");
        reporte.append("Total de Episodios: ").append(totalEpisodios).append("\n");
        reporte.append("Total de Reproducciones: ").append(totatReproducciones).append("\n");
        reporte.append("Promedio de Reproducciones por Episodio: ").append(String.format("%.2f", promedioReproducciones)).append("\n");
        reporte.append("Total de Suscriptores: ").append(totalSuscriptores).append("\n");
        reporte.append("Total de Likes: ").append(totalLikes).append("\n");
        reporte.append("Duración Total: ").append(formatearDuracion(duracionTotalSegundos)).append("\n");
        if (episodioMasPopular != null) {
            reporte.append("Episodio Más Popular: ").append(episodioMasPopular.getTitulo()).append(" con ").append(episodioMasPopular.getReproducciones()).append(" reproducciones\n");
        }
        return reporte.toString();
    }

    public double calcularEngagement(){
        if (totalSuscriptores == 0) return 0.0;
        return (double) totalLikes / totalSuscriptores * 100;
    }

    public int estimacionCrecimientoMensual(){
        //revisar logica
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

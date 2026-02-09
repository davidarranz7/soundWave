package utilidades;

import enums.AlgoritmoRecomendacion;
import excepciones.recomendacion.RecomendacionException;
import interfaces.IRecomendador;
import modelo.contenido.Contenido;
import modelo.usuarios.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public class RecomendadoIA implements IRecomendador {

    private HashMap<String, ArrayList<String>> matrizPreferencias;
    private HashMap<String, ArrayList<Contenido>> historialCompleto;
    private AlgoritmoRecomendacion algoritmo;
    private double umbralSimilitud;
    private boolean modeloEntrenado;
    private ArrayList<Contenido> catalogoReferencia;
    private static final double UMBRAL_DEFAULT = 0.6;


    public RecomendadoIA() {
        this.matrizPreferencias = new HashMap<>();
        this.historialCompleto = new HashMap<>();
        this.catalogoReferencia = new ArrayList<>();
    }

    public RecomendadoIA(AlgoritmoRecomendacion algoritmo) {
        this.matrizPreferencias = new HashMap<>();
        this.historialCompleto = new HashMap<>();
        this.algoritmo = algoritmo;
        this.catalogoReferencia = new ArrayList<>();
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
        return matrizPreferencias;
    }

    public void setCatalogoReferencia(ArrayList<Contenido> catalogoReferencia) {
        this.catalogoReferencia = catalogoReferencia;
    }


    //metodos propios y revisar logicas

    public void entrenarModelo(){

    }

    public void entrenarModelo(ArrayList<Usuario> usuarios, ArrayList<Contenido> catalogo){

    }

    public double calcularSimilitud(Usuario usuario1, Usuario usuario2){
        return 0.0;
    }

    public void actualizarMatrizPreferencias(Usuario usuario){

    }

    public HashMap<String, Integer> obtenerGenerosPopulares(){
        return new HashMap<>();
    }

    //metodo privado
    private double CalcularSimilitudContenido(Contenido contenido, ArrayList<String> preferencias){
        return 0.0;
    }

    //implementacion Recomendador


    @Override
    public ArrayList<Contenido> recomendar(Usuario usuario) throws RecomendacionException {
        return null;
    }

    @Override
    public ArrayList<Contenido> obtenerSimilares(Contenido contenido) throws RecomendacionException {
        return null;
    }




}

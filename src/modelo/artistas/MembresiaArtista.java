package modelo.artistas;

import enums.NivelMembresia;
import modelo.usuarios.Usuario;

import java.util.ArrayList;

public class MembresiaArtista  {

    private String nombre;
    private NivelMembresia nivelMembresia;
    private ArrayList<Usuario> suscriptores;
    private Artista artista;


    public MembresiaArtista(String nombre, Artista artista, NivelMembresia nivelMembresia) {
        this.nombre = nombre;
        this.artista = artista;
        this.nivelMembresia = nivelMembresia;
        this.suscriptores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelMembresia getNivel() {
        return nivelMembresia;
    }

    public void setNivel(NivelMembresia nivelMembresia) {
        this.nivelMembresia = nivelMembresia;
    }

    public ArrayList<Usuario> getSuscriptores() {
        return new ArrayList<>(suscriptores);
    }


    public  void suscribirUsuario(Usuario usuario){
        if (suscriptores.contains(usuario)) {
            throw new IllegalArgumentException("El usuario ya está suscrito a esta membresía.");
        }
        suscriptores.add(usuario);
    }

    public void cancelarSuscripcion(Usuario usuario) {
        if (!suscriptores.contains(usuario)) {
            throw new IllegalArgumentException("El usuario no está suscrito a esta membresía.");
        }
        suscriptores.remove(usuario);
    }

    public int getNumeroSuscriptores() {
        return suscriptores.size();
    }

    public boolean estaSuscrito(Usuario usuario) {
        return suscriptores.contains(usuario);
    }

    public double calcularIngresosMensuales() {
        return suscriptores.size() * nivelMembresia.getPrecioMensual();
    }
}



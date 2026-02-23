package modelo.plataforma;

import excepciones.playlist.ContenidoDuplicadoException;
import excepciones.playlist.PlaylistLlenaException;
import modelo.contenido.Contenido;
import modelo.usuarios.Usuario;

import java.util.ArrayList;

public class PlaylistColaborativa extends Playlist {

    public ArrayList<Usuario> colaboradores;

    private static final int MAX_COLABORADORES = 30;

    public PlaylistColaborativa(String nombre, Usuario creador) {
        super(nombre, creador);
        this.colaboradores = new ArrayList<>();

    }

    public ArrayList<Usuario> getColaboradores() {
        return new ArrayList<>(colaboradores);
    }

    public void agregarColaborador(Usuario usuario) {
        if (usuario != null && !colaboradores.contains(usuario) && (colaboradores.size() >= 0 && colaboradores.size() < MAX_COLABORADORES)) {
            colaboradores.add(usuario);
        }
    }

    public void eliminarColaborador(Usuario usuario) {
        if (usuario != null && colaboradores.contains(usuario)) {
            colaboradores.remove(usuario);
        }
    }

    public void agregarContenido(Contenido contenido, Usuario usuario)
            throws ContenidoDuplicadoException, PlaylistLlenaException {

        if (usuario == null) {
            throw new SecurityException("Usuario no válido");
        }

        if (!usuario.equals(getPropietario()) && !colaboradores.contains(usuario)) {
            throw new SecurityException("No tiene permisos para modificar la playlist");
        }

        // Llamamos al método original de Playlist
        super.agregarContenido(contenido);
    }

    public int getNumeroColaboradores() {
        return colaboradores.size();
    }

    public Usuario getPropietario() {
        return super.getCreador();
    }

    public boolean esColaborador(Usuario usuario) {
        return colaboradores.contains(usuario);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

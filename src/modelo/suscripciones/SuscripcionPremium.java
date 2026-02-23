package modelo.suscripciones;

import enums.TipoSuscripcion;
import enums.TipoSuscripcionPremium;
import modelo.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Date;

public abstract class SuscripcionPremium {

    protected String nombre;
    protected TipoSuscripcionPremium tipoSuscripcionPremium;
    protected Date fechaCreacion;
    protected ArrayList<Usuario> suscriptores;


    public SuscripcionPremium(String nombre, TipoSuscripcionPremium tipoSuscripcionPremium, Date fechaCreacion, ArrayList<Usuario> suscriptores) {
        this.nombre = nombre;
        this.tipoSuscripcionPremium = tipoSuscripcionPremium;
        this.fechaCreacion = fechaCreacion;
        this.suscriptores = new ArrayList<>();
    }

    public SuscripcionPremium(String nombre, TipoSuscripcionPremium tipoSuscripcionPremium) {
        this.nombre = nombre;
        this.tipoSuscripcionPremium = tipoSuscripcionPremium;
        this.suscriptores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoSuscripcionPremium getTipoSuscripcionPremium() {
        return tipoSuscripcionPremium;
    }

    public void setTipoSuscripcionPremium(TipoSuscripcionPremium tipoSuscripcionPremium) {
        this.tipoSuscripcionPremium = tipoSuscripcionPremium;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ArrayList<Usuario> getSuscriptores() {
        return new ArrayList<>(suscriptores);
    }

    public void suscribirUsuario(Usuario usuario) {
        if (suscriptores.contains(usuario)) {
            throw new IllegalArgumentException("Usuario ya suscrito");
        }
        suscriptores.add(usuario);
    }

    public void cancelarSuscripcion(Usuario usuario) {
        if (!suscriptores.contains(usuario)) {
            throw new IllegalArgumentException("Usuario no suscrito");
        }
        suscriptores.remove(usuario);
    }

    public int getNumeroSuscriptores() {
        return suscriptores.size();
    }

    public double calcularIngresosMensuales() {
        return tipoSuscripcionPremium.getPrecioMensual() * getNumeroSuscriptores();
    }

    public double getPrecioMensual() {
        return tipoSuscripcionPremium.getPrecioMensual();
    }

    public boolean estaSuscrito(Usuario usuario) {
        return suscriptores.contains(usuario);
    }

}

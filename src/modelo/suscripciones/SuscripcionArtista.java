package modelo.suscripciones;

import enums.TipoSuscripcion;
import enums.TipoSuscripcionPremium;
import modelo.artistas.Artista;
import modelo.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Date;

public class SuscripcionArtista extends SuscripcionPremium{

    private Artista artista;

    public SuscripcionArtista(String nombre, TipoSuscripcionPremium tipoSuscripcionPremium, Artista artista) {
        super(nombre, tipoSuscripcionPremium);
        this.artista = artista;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }



}

package modelo.suscripciones;

import enums.TipoSuscripcion;
import enums.TipoSuscripcionPremium;
import modelo.contenido.Masterclass;
import modelo.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Date;

public class SuscripcionMasterclass extends SuscripcionPremium{

    private String instructor;

    public SuscripcionMasterclass(String nombre, TipoSuscripcionPremium tipoSuscripcionPremium, String instructor) {
        super(nombre, tipoSuscripcionPremium);
        this.instructor = instructor;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}

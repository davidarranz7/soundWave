package modelo.usuarios;

import enums.TipoSuscripcion;
import excepciones.usuario.EmailInvalidoException;
import excepciones.usuario.PasswordDebilException;

import java.util.ArrayList;

public class UsuarioEmpresarial extends UsuarioPremium{

    private ArrayList<String> perfilesSecundarios;
    private final static int MAX_PERFILES_SECUNDARIOS = 5;

    public UsuarioEmpresarial(String nombre, String email, String password) throws EmailInvalidoException, PasswordDebilException {
        super(nombre, email, password, TipoSuscripcion.EMPRESARIAL);
        this.perfilesSecundarios = new ArrayList<>();
    }

    public ArrayList<String> getUsuarioSecundarios() {
        return new ArrayList<>(perfilesSecundarios);
    }



    public int getNumeroPerfilesSecundarios() {
        return perfilesSecundarios.size();
    }


    public void agregarPerfilSecundario(String nombreUsuario) {
        if (perfilesSecundarios.size() >= MAX_PERFILES_SECUNDARIOS) {
            throw new IllegalStateException("No se pueden agregar más de " + MAX_PERFILES_SECUNDARIOS + " usuarios secundarios");
        }
        perfilesSecundarios.add(nombreUsuario);
    }

}

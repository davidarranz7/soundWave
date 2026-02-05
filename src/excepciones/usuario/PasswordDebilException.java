package excepciones.usuario;

public class PasswordDebilException extends Exception {
    public PasswordDebilException(String mensaje) {
        super(mensaje);
    }
}

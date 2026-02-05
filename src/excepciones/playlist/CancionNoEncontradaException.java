package excepciones.playlist;

public class CancionNoEncontradaException extends Exception {
    public CancionNoEncontradaException(String message) {
        super(message);
    }

    public CancionNoEncontradaException() {
    }
}

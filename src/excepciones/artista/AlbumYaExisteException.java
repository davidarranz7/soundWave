package excepciones.artista;

public class AlbumYaExisteException extends Exception{
    public AlbumYaExisteException(String mensaje) {
        super(mensaje);
    }
}

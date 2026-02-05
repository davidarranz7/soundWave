package excepciones.artista;

public class LimiteEpisodiosException extends Exception{
    public LimiteEpisodiosException(String message) {
        super(message);
    }

    public LimiteEpisodiosException() {
    }
}

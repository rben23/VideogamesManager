package excepciones;

public class JuegoNoCompatible extends Exception {
    public JuegoNoCompatible(String message) {
        super(String.format("(!) ERROR: Este juego no es compatible con %s", message));
    }
}

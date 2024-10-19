package exceptions;

public class GameNotCompatible extends Exception {
    public GameNotCompatible(String message) {
        super(String.format("(!) ERROR: Este juego no es compatible con %s", message));
    }
}

package exceptions;

public class GameAlreadyInstalled extends Exception {
    public GameAlreadyInstalled() {
        super("(!) ERROR: Juego ya instalado");
    }
}

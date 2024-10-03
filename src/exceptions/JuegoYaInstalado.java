package exceptions;

public class JuegoYaInstalado extends Exception {
    public JuegoYaInstalado() {
        super("(!) ERROR: Juego ya instalado");
    }
}

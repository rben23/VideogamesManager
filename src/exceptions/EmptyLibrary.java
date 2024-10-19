package exceptions;

public class EmptyLibrary extends NullPointerException {
    public EmptyLibrary() {
        super("❗ La Biblioteca vacia");
    }
}

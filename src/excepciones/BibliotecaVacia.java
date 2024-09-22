package excepciones;

import java.io.IOException;

public class BibliotecaVacia extends NullPointerException {
    public BibliotecaVacia() {
        super("❗ La Biblioteca vacia");
    }
}

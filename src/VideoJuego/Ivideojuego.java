package videojuego;

import videojuego.enums.GeneroJuego;
import videojuego.enums.TituloJuego;

import java.util.List;

public interface Ivideojuego {
    void videojuego(TituloJuego tituloJuego, double precio, List<GeneroJuego> generoJuego, String plataformaJuego);
}
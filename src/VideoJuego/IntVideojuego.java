package videojuego;

import enums.PlataformaJuego;
import enums.GeneroJuego;
import enums.TituloJuego;

import java.util.List;

public interface IntVideojuego {
    void videojuego(TituloJuego tituloJuego, double precio, List<GeneroJuego> generoJuego, String plataformaJuego);
}
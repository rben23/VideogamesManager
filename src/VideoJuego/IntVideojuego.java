package VideoJuego;

import java.util.List;

public interface IntVideojuego {
    void videojuego(EnumsJuego.Titulo titulo, double precio, List<EnumsJuego.Genero> genero, List<EnumsJuego.Consola> consola);
}
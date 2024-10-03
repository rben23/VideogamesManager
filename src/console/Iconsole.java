package console;

import exceptions.JuegoNoCompatible;
import exceptions.JuegoYaInstalado;
import videogames.Videogame;

import java.io.IOException;

public interface Iconsole {
    // Encender Consola
    void switchOn() throws IOException;

    // Apagar Consola
    void switchOff() throws IOException;

    // Instalar Juegos
    void installVideogame(Videogame videogame) throws JuegoNoCompatible, JuegoYaInstalado, IOException;

    // Jugar juegos
    void playVideogame();

    // Coger plataforma
    String getPlataform();

    // Coger Juegos
    String getGames();
}

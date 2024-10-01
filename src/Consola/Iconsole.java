package consola;

import excepciones.JuegoNoCompatible;
import excepciones.JuegoYaInstalado;
import videojuego.Videogame;

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
}

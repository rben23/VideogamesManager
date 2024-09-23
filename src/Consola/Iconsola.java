package consola;

import excepciones.JuegoNoCompatible;
import excepciones.JuegoYaInstalado;
import videojuego.Videojuego;
import videojuego.VideojuegoDigital;
import videojuego.VideojuegoFisico;

import java.io.IOException;

public interface Iconsola {
    // Encender Consola
    void switchOn() throws IOException;

    // Apagar Consola
    void switchOff() throws IOException;

    // Instalar Juegos
    void installVideogame(Videojuego videojuego) throws JuegoNoCompatible, JuegoYaInstalado, IOException;

    // Jugar juegos
    void playVideogame();

    // Coger plataforma
    String getPlataform();
}

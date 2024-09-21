package consola;

import excepciones.JuegoNoCompatible;
import excepciones.JuegoYaInstalado;
import videojuego.Videojuego;

import java.io.IOException;

public interface Consola {
    void switchOn() throws IOException;
    void switchOff() throws IOException;
    void installVideogame(Videojuego videojuego) throws JuegoNoCompatible, JuegoYaInstalado, IOException;
    void playVideogame();
    String getPlataforma();
}

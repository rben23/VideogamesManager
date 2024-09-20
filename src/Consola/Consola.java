package consola;

import excepciones.JuegoNoCompatible;
import excepciones.JuegoYaInstalado;
import videojuego.Videojuego;

public interface Consola {
    void switchOn();
    void switchOff();
    void installVideogame(Videojuego videojuego) throws JuegoNoCompatible, JuegoYaInstalado;
    void playVideogame();
    String getPlataforma();
}

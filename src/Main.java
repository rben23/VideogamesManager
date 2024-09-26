import consola.Xbox;
import excepciones.JuegoNoCompatible;
import excepciones.JuegoYaInstalado;
import videojuego.VideojuegoDigital;
import videojuego.VideojuegoFisico;
import videojuego.enums.GeneroJuego;
import videojuego.enums.PlataformaJuego;
import videojuego.enums.TipoJuego;
import videojuego.enums.TituloJuego;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws JuegoYaInstalado, JuegoNoCompatible, IOException {
        // Inicializar Juego Digital
        List<GeneroJuego> generoJuego = Arrays.asList(GeneroJuego.Aventura, GeneroJuego.Acción);
        VideojuegoDigital vd = new VideojuegoDigital(TituloJuego.MINECRAFT, 25.95, PlataformaJuego.Xbox, generoJuego, TipoJuego.DIGITAL);
        // Inicializar Juego Físico
        List<GeneroJuego> generoJuego2 = Arrays.asList(GeneroJuego.Misterio, GeneroJuego.Estrategia);
        VideojuegoFisico vf = new VideojuegoFisico(TituloJuego.AMONGUS, 27.98, PlataformaJuego.Xbox, generoJuego, TipoJuego.FISICO);

        // Inicializar Consola Nintendo
        Xbox play = new Xbox();
        play.switchOn();
        play.installVideogame(vd);
        play.installVideogame(vf);
        play.playVideogame();
        play.switchOff();
    }
}
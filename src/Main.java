import consola.NintendoSwitch;
import consola.PlayStation;
import consola.Xbox;
import excepciones.JuegoNoCompatible;
import excepciones.JuegoYaInstalado;
import videojuego.Videojuego;
import videojuego.VideojuegoDigital;
import videojuego.VideojuegoFisico;
import videojuego.enums.GeneroJuego;
import videojuego.enums.TituloJuego;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws JuegoYaInstalado, JuegoNoCompatible, IOException {
        // Inicializar Juego Digital
        VideojuegoDigital vd = new VideojuegoDigital();
        List<GeneroJuego> generoJuego = Arrays.asList(GeneroJuego.Aventura, GeneroJuego.Acción);
        vd.setTitulo(TituloJuego.MINECRAFT);
        vd.setGenero(generoJuego);
        vd.setConsola("NintendoSwitch");
        vd.setPrecio(25.99);

        // Inicializar Juego Físico
        VideojuegoFisico vf = new VideojuegoFisico();
        List<GeneroJuego> generoJuego2 = Arrays.asList(GeneroJuego.Misterio, GeneroJuego.Estrategia);
        vf.setTitulo(TituloJuego.AMONGUS);
        vf.setGenero(generoJuego2);
        vf.setConsola("NintendoSwitch");
        vf.setPrecio(25.99);

        // Inicializar Consola Nintendo
        NintendoSwitch play = new NintendoSwitch();
        play.switchOn();
//        play.installVideogame(vd);
//        play.installVideogame(vf);
        System.out.println("---");
        play.playVideogame();
        System.out.println("---");
        play.switchOff();
    }
}
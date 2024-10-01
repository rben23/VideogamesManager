import consola.Console;
import excepciones.JuegoNoCompatible;
import excepciones.JuegoYaInstalado;
import videojuego.VideogameDigital;
import videojuego.VideogamePhisic;
import videojuego.enums.GameGenre;
import videojuego.enums.GamePlatform;
import videojuego.enums.GameType;
import videojuego.enums.GameTitle;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws JuegoYaInstalado, JuegoNoCompatible, IOException {
        // Inicializar Juego Digital
        List<GameGenre> gameGenres = Arrays.asList(GameGenre.AVENTURA, GameGenre.ACCIÓN);
        VideogameDigital vdMinecraft = new VideogameDigital(GameTitle.MINECRAFT, 25.95, GamePlatform.Xbox,
                gameGenres, GameType.DIGITAL);

        // Inicializar Juego Físico
        List<GameGenre> gameGenre2 = Arrays.asList(GameGenre.MISTERIO, GameGenre.ESTRATEGIA);
        VideogamePhisic vfAmongUs = new VideogamePhisic(GameTitle.AMONGUS, 27.98, GamePlatform.Xbox,
                gameGenres, GameType.FISICO);

        // Inicializar Consola Nintendo
        Console play = new Console(GamePlatform.Xbox);
        play.switchOn();
        play.installVideogame(vdMinecraft);
        play.installVideogame(vfAmongUs);
        System.out.println("---");
        play.playVideogame();
        play.switchOff();
    }
}
import console.Console;
import exceptions.GameNotCompatible;
import exceptions.GameAlreadyInstalled;
import videogames.VideogameDigital;
import videogames.VideogamePhisic;
import enums.GameGenre;
import enums.GamePlatform;
import enums.GameType;
import enums.GameTitle;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws GameAlreadyInstalled, GameNotCompatible, IOException {
        // Inicializar Juego Digital
        List<GameGenre> gameGenres = Arrays.asList(GameGenre.AVENTURA, GameGenre.ACCIÓN);
        VideogameDigital vdMinecraft = new VideogameDigital(GameTitle.MINECRAFT, 25.95, GamePlatform.NINTENDOSWITCH,
                gameGenres, GameType.DIGITAL);

        // Inicializar Juego Físico
        List<GameGenre> gameGenre2 = Arrays.asList(GameGenre.MISTERIO, GameGenre.ESTRATEGIA);
        VideogamePhisic vfAmongUs = new VideogamePhisic(GameTitle.AMONGUS, 27.98, GamePlatform.NINTENDOSWITCH,
                gameGenres, GameType.FISICO);

        // Inicializar Consola Nintendo
        Console play = new Console(GamePlatform.NINTENDOSWITCH);
        play.switchOn();
        play.installVideogame(vdMinecraft);
        play.installVideogame(vfAmongUs);
        System.out.println("---");
        play.playVideogame();
        System.out.println("---");
        play.switchOff();
    }
}
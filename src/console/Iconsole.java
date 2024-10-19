package console;

import exceptions.GameNotCompatible;
import exceptions.GameAlreadyInstalled;
import videogames.Videogame;

import java.io.IOException;

public interface Iconsole {

    void switchOn() throws IOException;

    void switchOff() throws IOException;

    void installVideogame(Videogame videogame) throws GameNotCompatible, GameAlreadyInstalled, IOException;

    void playVideogame();

    String getPlataform();

    String getGames();
}

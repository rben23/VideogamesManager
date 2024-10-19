package console;

import console.fileManager.FileManager;
import exceptions.GameNotCompatible;
import exceptions.GameAlreadyInstalled;
import resources.Messages;
import videogames.Videogame;
import enums.GamePlatform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Console implements Iconsole {

    private GamePlatform platform;
    private List<Videogame> games = new ArrayList<>();

    public Console(GamePlatform plataforma) {
        this.platform = plataforma;
    }

    @Override
    public void switchOn() {
        System.out.printf(Messages.MNU_CON_POWERON, getPlataform(), getPlataform());

        try {
            uploadData();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        showData();
    }

    private void uploadData() throws IOException {
        FileManager guardarInfo = new FileManager();
        guardarInfo.uploadVideogame(selectFile(), games);
    }

    @Override
    public void switchOff() {
        System.out.printf(Messages.MSG_CON_END, getPlataform());
    }

    @Override
    public void installVideogame(Videogame videogame) throws GameNotCompatible, GameAlreadyInstalled, IOException {
        if (getGames().contains(videogameTitle(videogame))) {
            throw new GameAlreadyInstalled();
        } else {
            if (getPlataform().equals(videogame.getPlataformaJuego())) {
                games.add(videogame);
                saveData();
                System.out.printf(Messages.MNU_CON_INSTALLED, videogameTitle(videogame));

                showData();
            } else {
                throw new GameNotCompatible(getPlataform());
            }
        }
    }

    private void saveData() throws IOException {
        FileManager guardarInfo = new FileManager();
        guardarInfo.saveVideogame(selectFile(), games);
    }

    private void showData() {
        System.out.println(Messages.MNU_VDG_LIBRARY);

        for (Videogame videogame : games) {
            System.out.println(videogame);
        }
    }

    private static String videogameTitle(Videogame videogame) {
        return videogame.getTitulo();
    }

    @Override
    public void playVideogame() {
        if (!games.isEmpty()) {
            System.out.printf(Messages.MSG_CON_PLAYING, videogameTitle(games.get(0)));
        } else {
            System.out.println(Messages.MSG_CON_NOGAME);
        }
    }

    @Override
    public String getPlataform() {
        return this.platform.toString();
    }

    @Override
    public String getGames() {
        return this.games.toString();
    }

    private String selectFile() {
        return getPlataform() + ".txt";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(games);
    }
}

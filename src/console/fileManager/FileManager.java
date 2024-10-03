package console.fileManager;

import resources.Messages;
import videogames.Videogame;
import videogames.VideogameDigital;
import videogames.VideogamePhisic;
import videogames.enums.GameGenre;
import videogames.enums.GamePlatform;
import videogames.enums.GameType;
import videogames.enums.GameTitle;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    // CONSTANTES - Spearadores
    private final String SEP_FILAS = ":";
    private final String SEP_NORMAL = "-";
    private final String SEP_COMAS = ",";

    // Guardamos los datos en el CSV
    public void saveData(String dir, List<Videogame> juego) throws IOException {
        FileWriter fl = new FileWriter(dir);

        for (Videogame j : juego) {
            fl.write(j.getTitulo() + SEP_NORMAL + j.getGenero() + SEP_NORMAL +
                    j.getPlataformaJuego() + SEP_NORMAL + j.getPrice() + SEP_NORMAL + j.getTipo() + SEP_FILAS + "\n");
        }
        fl.close();
    }

    // Cargamos los datos desde el CSV en la lista Videogame
    public void cargarInfo(String dir, List<Videogame> juego) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(dir));
            String linea;
            do {
                linea = bf.readLine();

                if (linea != null) {
                    // Array con toda la información
                    String[] pase = linea.split(SEP_NORMAL);

                    // Inicializar Array con los generos quitandole los corchetes []
                    List<String> generos = Arrays.asList(
                            pase[1].replace("[", "")
                                    .replace("]", "")
                                    .split(SEP_COMAS));

                    // Asignar el titulo del juego a la variable gameTitle
                    GameTitle gameTitle = GameTitle.valueOf(pase[0]);

                    // Asignar los generos del juego al array genere
                    List<GameGenre> genere = new ArrayList<>();
                    for (int i = 0; i < generos.size(); i++) {
                        genere.add(GameGenre.valueOf(generos.get(i).trim()));
                    }

                    // Asignar la plataforma del juego a la variable gamePlatform
                    GamePlatform gamePlatform = GamePlatform.valueOf(pase[2]);

                    // Asignar el precio del juego a la variable price
                    double price = Double.parseDouble(pase[3]);
                    // Asignar el tipo del juego a la variable gameType
                    GameType gameType = GameType.valueOf(pase[4].replace(":", ""));

                    // Inicializar videojuego y asignar al videojuego digital o físico
                    Videogame vd;
                    if (gameType.equals(GameType.DIGITAL)) {
                        vd = new VideogameDigital(gameTitle, price, gamePlatform, genere, gameType);
                    } else {
                        vd = new VideogamePhisic(gameTitle, price, gamePlatform, genere, gameType);
                    }
                    juego.add(vd);

                }
            } while (linea != null);

        } catch (FileNotFoundException e) {
            System.out.println(Messages.MSG_CON_ERRORFILE);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
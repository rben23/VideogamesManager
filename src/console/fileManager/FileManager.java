package console.fileManager;

import resources.Messages;
import videogames.Videogame;
import videogames.VideogameDigital;
import videogames.VideogamePhisic;
import enums.GameGenre;
import enums.GamePlatform;
import enums.GameType;
import enums.GameTitle;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    private final String SEP_NORMAL = "-";
    private final String SEP_GENRE = ",";

    public void saveVideogame(String dir, List<Videogame> juego) throws IOException {
        FileWriter fl = new FileWriter(dir);
        writeVideogameOnFile(juego, fl);
        fl.close();
    }

    private void writeVideogameOnFile(List<Videogame> juego, FileWriter fl) throws IOException {
        for (Videogame j : juego) {
            fl.write(j.getTitulo() + SEP_NORMAL + j.getPrice() + SEP_NORMAL + j.getGenero() +
                    SEP_NORMAL + j.getPlataformaJuego() + SEP_NORMAL + j.getTipo() + SEP_NORMAL + "\n");
        }
    }

    public void uploadVideogame(String dir, List<Videogame> juego) {

        try {
            BufferedReader bf = new BufferedReader(new FileReader(dir));
            String linea;
            do {
                linea = bf.readLine();

                if (linea != null) {
                    uploadDataOnVideogame(juego, linea);
                }

            } while (linea != null);

        } catch (FileNotFoundException e) {
            System.out.println(Messages.MSG_CON_ERRORFILE);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private void uploadDataOnVideogame(List<Videogame> juego, String linea) {
        String[] pase = linea.split(SEP_NORMAL);

        GameTitle gameTitle = GameTitle.valueOf(pase[0]);
        Double price = Double.valueOf(pase[1]);
        List<GameGenre> genere = addGenreInArrayPase(pase);
        GamePlatform gamePlatform = GamePlatform.valueOf(pase[3]);
        GameType gameType = GameType.valueOf(pase[4]);

        Videogame vd = getDigitalOrPhisicalVideogame(gameType, gameTitle, price, gamePlatform, genere);
        juego.add(vd);
    }

    private static Videogame getDigitalOrPhisicalVideogame(GameType gameType, GameTitle gameTitle, Double price, GamePlatform gamePlatform, List<GameGenre> genere) {
        Videogame vd;
        if (gameType.equals(GameType.DIGITAL)) {
            vd = new VideogameDigital(gameTitle, price, gamePlatform, genere, gameType);
        } else {
            vd = new VideogamePhisic(gameTitle, price, gamePlatform, genere, gameType);
        }
        return vd;
    }

    private List<GameGenre> addGenreInArrayPase(String[] pase) {
        List<String> generos = detectGenres(pase);
        List<GameGenre> genre = addGenresInArrayGenre(generos);
        return genre;
    }

    private static List<GameGenre> addGenresInArrayGenre(List<String> genres) {
        List<GameGenre> genere = new ArrayList<>();
        for (int i = 0; i < genres.size(); i++) {
            genere.add(GameGenre.valueOf(genres.get(i).trim()));
        }
        return genere;
    }

    private List<String> detectGenres(String[] pase) {
        List<String> genres = Arrays.asList(
                pase[2].replace("[", "")
                        .replace("]", "")
                        .split(SEP_GENRE));
        return genres;
    }
}
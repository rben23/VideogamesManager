package videogames;

import enums.GameGenre;
import enums.GamePlatform;
import enums.GameType;
import enums.GameTitle;

import java.util.List;
import java.util.Locale;
import java.util.Objects;


public abstract class Videogame implements Ivideogame {

    private GameTitle gameTitle;
    protected double price;
    private List<GameGenre> gameGenres;
    private GamePlatform gamePlatform;
    private GameType gameType;

    public Videogame(GameTitle gameTitle, double price, GamePlatform gamePlatform, List<GameGenre> gameGenres, GameType gameType) {
        this.gameTitle = gameTitle;
        this.price = price;
        this.gameGenres = gameGenres;
        this.gamePlatform = gamePlatform;
        this.gameType = gameType;
    }

    public String getTitulo() {
        return gameTitle.toString();
    }

    public double getPrice() {
        return price;
    }

    public List<GameGenre> getGenero() {
        return gameGenres;
    }

    public String getPlataformaJuego() {
        return gamePlatform.toString();
    }

    public String getTipo() {
        return gameType.toString();
    }

    public abstract double aplyPrice();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Videogame that = (Videogame) o;
        return Double.compare(price, that.price) == 0 &&
                Objects.equals(gameTitle, that.gameTitle) &&
                Objects.equals(gameGenres, that.gameGenres) &&
                Objects.equals(gamePlatform, that.gamePlatform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameTitle, price, gameGenres, gamePlatform);
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%-23s %-25s %-22s %19s", this.gameTitle, this.gameGenres,
                this.gamePlatform, this.gameType);
    }
}

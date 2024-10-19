package videogames;

import enums.GameGenre;
import enums.GamePlatform;
import enums.GameType;
import enums.GameTitle;

import java.util.List;
import java.util.Objects;

public class VideogameDigital extends Videogame {

    private double discount;

    public VideogameDigital(GameTitle title, double price, GamePlatform platform, List<GameGenre> genre, GameType type) {
        super(title, price, platform, genre, type);
        this.discount = 15;
    }

    @Override
    public double aplyPrice() {return this.price - discount;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VideogameDigital that = (VideogameDigital) o;
        return discount == that.discount;
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), discount);}

    @Override
    public String toString() {return String.format("%s %12.2f€", super.toString(), aplyPrice());}
}

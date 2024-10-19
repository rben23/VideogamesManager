package videogames;

import enums.GameGenre;
import enums.GamePlatform;
import enums.GameType;
import enums.GameTitle;

import java.util.List;
import java.util.Objects;

public class VideogamePhisic extends Videogame {

    private double shipment;

    public VideogamePhisic(GameTitle title, double price, GamePlatform platform, List<GameGenre> genre, GameType type) {
        super(title, price, platform, genre, type);
        this.shipment = 10;
    }

    @Override
    public double aplyPrice() {
        return this.price + shipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VideogamePhisic videojuegoFisico = (VideogamePhisic) o;
        return Double.compare(shipment, videojuegoFisico.shipment) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shipment);
    }

    @Override
    public String toString() {
        return String.format("%s %12.2f€", super.toString(), aplyPrice());
    }
}

package videojuego;

import videojuego.enums.GameGenre;
import videojuego.enums.GamePlatform;
import videojuego.enums.GameType;
import videojuego.enums.GameTitle;

import java.util.List;
import java.util.Objects;

public class VideogamePhisic extends Videogame {
    // Atributos
    private double shipment;

    // Constructor Predeterminado
    public VideogamePhisic(GameTitle title, double price, GamePlatform platform, List<GameGenre> genre, GameType type) {
        super(title, price, platform, genre, type);
        this.shipment = 10;
    }

    // Constructor Paraetrizado
    public VideogamePhisic(GameTitle title, double price, GamePlatform platform, List<GameGenre> genre, GameType type, double shipment) {
        super(title, price, platform, genre, type);
        this.shipment = shipment;
    }

    // Setters y Getters
    public double getShipment() {
        return shipment;
    }

    public void setShipment(double shipment) {
        this.shipment = shipment;
    }

    // Overrides
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

    // Overrides -> Aplicar Envio
    @Override
    public double aplyPrice() {
        return this.price + shipment;
    }
}

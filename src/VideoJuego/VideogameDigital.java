package videojuego;

import videojuego.enums.GameGenre;
import videojuego.enums.GamePlatform;
import videojuego.enums.GameType;
import videojuego.enums.GameTitle;

import java.util.List;
import java.util.Objects;

public class VideogameDigital extends Videogame {
    // Atributos
    private int discount;

    // Constructor Predeterminado
    public VideogameDigital(GameTitle title, double price, GamePlatform platform, List<GameGenre> genre, GameType type) {
        super(title, price, platform, genre, type);
        this.discount = 10;
    }

    // Constructor Parametrizado
    public VideogameDigital(GameTitle title, double price, GamePlatform platform, List<GameGenre> genre, GameType type, int amountDiscount) {
        super(title, price, platform, genre, type);
        this.discount = amountDiscount;
    }

    // Setters y Getters > cantDesc
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    // Overrides -> Aplicar Descuento
    @Override
    public double aplyPrice() {
        return this.price - discount;
    }

    // Overrides -> Equals, HashCode, ToString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VideogameDigital that = (VideogameDigital) o;
        return discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }

    @Override
    public String toString() {
        return String.format("%s", super.toString());
    }
}

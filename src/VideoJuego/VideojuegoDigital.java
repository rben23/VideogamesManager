package videojuego;

import enums.PlataformaJuego;
import enums.GeneroJuego;
import enums.TituloJuego;

import java.util.List;
import java.util.Objects;

public class VideojuegoDigital extends Videojuego {
    // Atributos
    private int descueto;

    // Constructor Predeterminado
    public VideojuegoDigital() {
        descueto = 10;
    }

    // Constructor Parametrizado
    public VideojuegoDigital(int cantDesc) {
        this.descueto = cantDesc;
    }

    // Setters y Getters > cantDesc
    public int getDescueto() {
        return descueto;
    }

    public void setDescueto(int descueto) {
        this.descueto = descueto;
    }

    // Overrides -> Padre
    @Override
    public void videojuego(TituloJuego tituloJuego, double precio, List<GeneroJuego> generoJuego, String plataformaJuego) {

    }


    // Overrides -> Aplicar Descuento
    @Override
    public double aplicarPrecio() {
        return getPrecio() - descueto;
    }

    // Overrides -> Equals, HashCode, ToString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VideojuegoDigital that = (VideojuegoDigital) o;
        return descueto == that.descueto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), descueto);
    }

    @Override
    public String toString() {
        return String.format("%s", super.toString());
    }
}

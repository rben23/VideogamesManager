package VideoJuego;

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
    public void videojuego(EnumsJuego.Titulo titulo, double precio, List<EnumsJuego.Genero> genero, List<EnumsJuego.Consola> consola) {

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

}

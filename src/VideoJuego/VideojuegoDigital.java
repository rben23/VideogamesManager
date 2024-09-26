package videojuego;

import videojuego.enums.GeneroJuego;
import videojuego.enums.PlataformaJuego;
import videojuego.enums.TipoJuego;
import videojuego.enums.TituloJuego;

import java.util.List;
import java.util.Objects;

public class VideojuegoDigital extends Videojuego {
    // Atributos
    private int descueto;

    // Constructor Predeterminado
    public VideojuegoDigital(TituloJuego titulo, double precio, PlataformaJuego plataforma, List<GeneroJuego> genero, TipoJuego tipo) {
        super(titulo, precio, plataforma, genero, tipo);
        this.descueto = 10;
    }

    // Constructor Parametrizado
    public VideojuegoDigital(TituloJuego titulo, double precio, PlataformaJuego plataforma, List<GeneroJuego> genero, TipoJuego tipo, int cantDesc) {
        super(titulo, precio, plataforma, genero, tipo);
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
    public void videojuego(TituloJuego tituloJuego, double precio, List<GeneroJuego> generoJuego, PlataformaJuego plataformaJuego, TipoJuego tipoJuego) {

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

    @Override
    public void videojuego(TituloJuego tituloJuego, double precio, List<GeneroJuego> generoJuego, String plataformaJuego, TipoJuego tipoJuego) {

    }
}

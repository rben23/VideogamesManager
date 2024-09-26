package videojuego;

import videojuego.enums.GeneroJuego;
import videojuego.enums.PlataformaJuego;
import videojuego.enums.TipoJuego;
import videojuego.enums.TituloJuego;
import recursos.Mensajes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;


public abstract class Videojuego implements Ivideojuego {

    // Atributos
    private TituloJuego tituloJuego;
    private double precio;
    private List<GeneroJuego> generoJuego;
    private PlataformaJuego plataformaJuego;
    private TipoJuego tipoJuego;

    // Constructor Parametrizado
    public Videojuego(TituloJuego tituloJuego, double precio, PlataformaJuego plataformaJuego, List<GeneroJuego> generoJuego, TipoJuego tipoJuego) {
        this.tituloJuego = tituloJuego;
        this.precio = precio;
        this.generoJuego = generoJuego;
        this.plataformaJuego = plataformaJuego;
        this.tipoJuego = tipoJuego;
    }

    // Setter y Getter Titulo
    public void setTitulo(TituloJuego tituloJuego) {
        this.tituloJuego = tituloJuego;
    }

    public String getTitulo() {
        return tituloJuego.toString();
    }

    // Setter y Getter Precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    // Setter y Getter Genero
    public void setGenero(List<GeneroJuego> generoJuego) {
        if (generoJuego != null) {
            this.generoJuego = new ArrayList<>(generoJuego);
        } else {
            System.out.println("ERROR");
        }
    }

    public List<GeneroJuego> getGenero() {
        return generoJuego;
    }

    // Setter y Getter Plataforma
    public void setPlataforma(PlataformaJuego plataformaJuego) {
        this.plataformaJuego = plataformaJuego;
    }

    public String getPlataformaJuego() {
        return plataformaJuego.toString();
    }

    // Setter y Getter Tipo
    public void setTipo(TipoJuego tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public String getTipo() {
        return tipoJuego.toString();
    }

    // Overrides -> Padre
    public abstract void videojuego(TituloJuego tituloJuego, double precio, List<GeneroJuego> generoJuego, PlataformaJuego plataformaJuego, TipoJuego tipoJuego);

    // Aplicar Precio Abstracto
    public abstract double aplicarPrecio();

    // Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Videojuego that = (Videojuego) o;
        return Double.compare(precio, that.precio) == 0 &&
                Objects.equals(tituloJuego, that.tituloJuego) &&
                Objects.equals(generoJuego, that.generoJuego) &&
                Objects.equals(plataformaJuego, that.plataformaJuego);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tituloJuego, precio, generoJuego, plataformaJuego);
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%s%n %-23s %-25s %-29s %.2f€ %s",
                Mensajes.MNU_VDJ_VIDEOJUEGOS, this.tituloJuego, this.generoJuego,
                this.plataformaJuego, this.precio, this.tipoJuego);
    }
}

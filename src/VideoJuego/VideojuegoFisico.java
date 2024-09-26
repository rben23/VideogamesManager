package videojuego;

import videojuego.enums.GeneroJuego;
import videojuego.enums.PlataformaJuego;
import videojuego.enums.TipoJuego;
import videojuego.enums.TituloJuego;

import java.util.List;
import java.util.Objects;

public class VideojuegoFisico extends Videojuego {
    // Atributos
    private double envio;

    // Constructor Predeterminado
    public VideojuegoFisico(TituloJuego titulo, double precio, PlataformaJuego plataforma, List<GeneroJuego> genero, TipoJuego tipo) {
        super(titulo, precio, plataforma, genero, tipo);
        this.envio = 10;
    }

    // Constructor Paraetrizado
    public VideojuegoFisico(TituloJuego titulo, double precio, PlataformaJuego plataforma, List<GeneroJuego> genero, TipoJuego tipo, double envio) {
        super(titulo, precio, plataforma, genero, tipo);
        this.envio = envio;
    }

    // Setters y Getters
    public double getEnvio() {
        return envio;
    }

    public void setEnvio(double envio) {
        this.envio = envio;
    }

    // Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VideojuegoFisico videojuegoFisico = (VideojuegoFisico) o;
        return Double.compare(envio, videojuegoFisico.envio) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), envio);
    }

    // Overrides -> Padre
    @Override
    public void videojuego(TituloJuego tituloJuego, double precio, List<GeneroJuego> generoJuego, PlataformaJuego plataformaJuego, TipoJuego tipoJuego) {
    }

    // Overrides -> Aplicar Envio
    @Override
    public double aplicarPrecio() {
        return this.getPrecio() + envio;
    }

    @Override
    public void videojuego(TituloJuego tituloJuego, double precio, List<GeneroJuego> generoJuego, String plataformaJuego, TipoJuego tipoJuego) {

    }
}

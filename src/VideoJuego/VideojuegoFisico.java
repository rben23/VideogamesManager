package videojuego;

import enums.PlataformaJuego;
import enums.GeneroJuego;
import enums.TituloJuego;

import java.util.List;
import java.util.Objects;

public class VideojuegoFisico extends Videojuego {
    // Atributos
    private double envio;

    // Constructor Predeterminado
    public VideojuegoFisico() {
        setEnvio(10);
    }

    // Constructor Paraetrizado
    public VideojuegoFisico(double envio) {
        this.setEnvio(envio);
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
    public void videojuego(TituloJuego tituloJuego, double precio, List<GeneroJuego> generoJuego, String plataformaJuego) {
    }

    // Overrides -> Aplicar Envio
    @Override
    public double aplicarPrecio() {
        return this.getPrecio() + envio;
    }
}

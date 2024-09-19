package VideoJuego;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public abstract class Videojuego implements IntVideojuego {

    // Atributos
    private EnumsJuego.Titulo titulo;
    private double precio;
    private List<EnumsJuego.Genero> genero;
    private List<EnumsJuego.Consola> consola;

    // Constructor Predeterminado
    public Videojuego() {
        this.titulo = titulo.AmongUs;
        this.precio = 0.0;
        this.genero = new ArrayList<>();
        this.consola = new ArrayList<>();
    }

    // Constructor Parametrizado
    public Videojuego(EnumsJuego.Titulo titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
        this.genero = new ArrayList<>();
        this.consola = new ArrayList<>();
    }

    // Setter y Getter Titulo
    public void setTitulo(EnumsJuego.Titulo titulo) {
        this.titulo = titulo;
    }

    public EnumsJuego.Titulo getTitulo() {
        return titulo;
    }

    // Setter y Getter Precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    // Setter y Getter Genero
    public void setGenero(List<EnumsJuego.Genero> genero) {
        if (genero != null) {
            this.genero = new ArrayList<>(genero);
        } else {
            System.out.println("ERROR");
        }
    }

    public List<EnumsJuego.Genero> getGenero() {
        return genero;
    }

    // Setter y Getter Tipo
    public void setConsola(List<EnumsJuego.Consola> consola) {
        if (consola != null) {
            this.consola = new ArrayList<>(consola);
        } else {
            System.out.println("ERROR");
        }
    }

    public List<EnumsJuego.Consola> getConsola() {
        return consola;
    }

    // Overrides -> Padre
    public abstract void videojuego(EnumsJuego.Titulo titulo, double precio, List<EnumsJuego.Genero> genero, List<EnumsJuego.Consola> consola);

    // Aplicar Precio Abstracto
    public abstract double aplicarPrecio();

    // Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Videojuego that = (Videojuego) o;
        return Double.compare(precio, that.precio) == 0 && Objects.equals(titulo, that.titulo) && Objects.equals(genero, that.genero) && Objects.equals(consola, that.consola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, precio, genero, consola);
    }

    @Override
    public String toString() {
        return String.format("%-23s %-25s %-29s %.2f€", this.titulo, this.genero, this.consola, aplicarPrecio());
    }
}

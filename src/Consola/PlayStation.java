package consola;

import excepciones.JuegoNoCompatible;
import excepciones.JuegoYaInstalado;
import menus.Menus;
import videojuego.Videojuego;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PlayStation implements Consola {
    // Atributos
    private List<String> juegos;

    // Constructor
    public PlayStation() {
        juegos = new ArrayList<>();
    }

    // Getters y Setters
    public List<String> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<String> juegos) {
        this.juegos = juegos;
    }

    // Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayStation that = (PlayStation) o;
        return Objects.equals(juegos, that.juegos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(juegos);
    }

    @Override
    public String toString() {
        switchOn();
        StringBuilder stringBuilder = new StringBuilder(String.format("%s", Menus.MNU_JUEGOS_INSTALADOS));

        int contador = 1;
        for (String j : juegos) {
            stringBuilder.append(j);
            if (contador % 2 == 0) {
                stringBuilder.append("\n");
            } else {
                stringBuilder.append("\s");
            }
            contador++;
        }
        return stringBuilder.toString();
    }

    // Overrides - Funcion
    @Override
    public void switchOn() {
        System.out.printf("(i) Iniciando %s ...%n", getClass().getSimpleName());
    }

    @Override
    public void switchOff() throws IOException {
        guardar();
        System.out.printf("(i) Apagando %s ...%n", getClass().getSimpleName());
    }

    @Override
    public void installVideogame(Videojuego videojuego) throws JuegoNoCompatible, JuegoYaInstalado {
        if (!juegos.contains(videojuego.getTitulo())) {
            if (videojuego.getPlataformaJuego().equals(getClass().getSimpleName())) {
                juegos.addAll(Arrays.asList(videojuego.getTitulo(), videojuego.getGenero().toString()));
            } else {
                throw new JuegoNoCompatible(getClass().getSimpleName());
            }
        } else {
            throw new JuegoYaInstalado();
        }
    }

    @Override
    public void playVideogame() {
        System.out.printf("(i) Jugando a %s%n", juegos.getFirst());
    }

    @Override
    public String getPlataforma() {
        return getClass().getSimpleName();
    }

    public void guardar() throws IOException {
        ManejarInfo manejarInfo = new ManejarInfo();
        manejarInfo.guardarInfo("instaladosPlayStation.csv", juegos);
    }
}

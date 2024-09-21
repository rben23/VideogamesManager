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

public class Xbox implements Consola {
    // Atributos
    private List<String> juegos;

    // Constructor
    public Xbox() {
        setJuegos(new ArrayList<>());
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
        Xbox xbox = (Xbox) o;
        return Objects.equals(juegos, xbox.juegos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(juegos);
    }

    @Override
    public String toString() {
        // Encender Sistema
        switchOn();

        // Inicializar retorno
        String retorno;

        // Inicializar StringBuilder
        StringBuilder stringBuilder = new StringBuilder(String.format("%s", Menus.MNU_JUEGOS_INSTALADOS));

        // Decisión Vacio
        if (juegos.isEmpty()) {
            retorno = stringBuilder + "(!) Biblioteca vacia";
        } else {
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
            retorno = stringBuilder.toString();
        }
        return retorno;
    }

    // Overrides - Función
    @Override
    public void switchOn() {
        System.out.printf("(i) Iniciando %s ...%n", getClass().getSimpleName());

        try {
            cargar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void switchOff() throws IOException {
        System.out.printf("(i) Apagando %s ...%n", getClass().getSimpleName());
    }

    @Override
    public void installVideogame(Videojuego videojuego) throws JuegoNoCompatible, JuegoYaInstalado, IOException {
        if (!juegos.contains(videojuego.getTitulo())) {
            if (videojuego.getPlataformaJuego().equals(getClass().getSimpleName())) {
                juegos.addAll(Arrays.asList(videojuego.getTitulo(), videojuego.getGenero().toString()));
                guardar();
            } else {
                throw new JuegoNoCompatible(getClass().getSimpleName());
            }
        } else {
            throw new JuegoYaInstalado();
        }
    }

    @Override
    public void playVideogame() {
        if (!juegos.isEmpty()) {
            System.out.printf("(i) Jugando a %s%n", juegos.getFirst());
        } else {
            System.out.println("(!) No tienes juegos instalados");
        }
    }

    @Override
    public String getPlataforma() {
        return getClass().getSimpleName();
    }

    // Cargar info
    public void cargar() throws IOException {
        ManejarInfo manejarInfo = new ManejarInfo();
        juegos.addAll(manejarInfo.cargarInfo("src/instaladosXbox.csv"));
    }

    // Guardar info
    public void guardar() throws IOException {
        ManejarInfo manejarInfo = new ManejarInfo();
        manejarInfo.guardarInfo("instaladosXbox.csv", juegos);
    }
}

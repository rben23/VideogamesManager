package consola;

import consola.GuardarInfo.GuardarInfo;
import excepciones.JuegoNoCompatible;
import excepciones.JuegoYaInstalado;
import recursos.Mensajes;
import videojuego.Videojuego;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PlayStation implements Iconsola {
    // Atributos
    private List<String> juegos;

    // Constructor
    public PlayStation() {
        juegos = new ArrayList<>();
    }

    // Setter
    public void setJuegos(List<String> juegos) {
        this.juegos = juegos;
    }

    // Cargar info
    private void uploadData() throws IOException {
        juegos.clear();
        GuardarInfo guardarInfo = new GuardarInfo();
        guardarInfo.cargarInfo("instaladosPlayStation.csv", juegos);
    }

    // Guardar info
    private void saveData() throws IOException {
        GuardarInfo guardarInfo = new GuardarInfo();
        guardarInfo.guardarInfo("instaladosPlayStation.csv", juegos);
    }

    // Ordenar Información
    private String orderData() {
        // Inicializar retorno
        String retorno;

        // Inicializar StringBuilder
        StringBuilder stringBuilder = new StringBuilder(String.format("%s", Mensajes.MNU_CON_INSTALADOS));

        // Decisión Vacio
        if (juegos.isEmpty()) {
            retorno = stringBuilder + Mensajes.MSG_CON_BIBLIOVACIA;
        } else {
            int contador = 0;
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

    // Overrides -> toString
    @Override
    public String toString() {
        switchOn();
        return orderData();
    }

    // Overrides -> SwitchOn
    @Override
    public void switchOn() {
        System.out.printf(Mensajes.MNU_CON_INICIO, getPlataform(), getPlataform());

        try {
            uploadData();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Overrides -> SwitchOff
    @Override
    public void switchOff() {
        System.out.printf(Mensajes.MSG_CON_FIN, getPlataform());
    }

    // Overrides -> Instalar Juegos
    @Override
    public void installVideogame(Videojuego videojuego) throws JuegoNoCompatible, JuegoYaInstalado, IOException {
        if (!juegos.contains(videojuego.getTitulo())) {
            if (videojuego.getPlataformaJuego().equals(getPlataform())) {
                juegos.addAll(Arrays.asList(videojuego.getTitulo(), videojuego.getGenero().toString()));
                saveData();
            } else {
                throw new JuegoNoCompatible(getPlataform());
            }
        } else {
            throw new JuegoYaInstalado();
        }
    }

    // Overrides -> Jugar Juegos
    @Override
    public void playVideogame() {
        if (!juegos.isEmpty()) {
            System.out.printf(Mensajes.MSG_CON_JUGANDO, juegos.getFirst());
        } else {
            System.out.println(Mensajes.MSG_CON_BIBLIOVACIA);
        }
    }

    // Overrides -> Devolver plataforma
    @Override
    public String getPlataform() {
        return getClass().getSimpleName();
    }
}

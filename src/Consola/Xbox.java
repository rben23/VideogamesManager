package consola;

import consola.guardarInfo.GuardarInfo;
import excepciones.JuegoNoCompatible;
import excepciones.JuegoYaInstalado;
import recursos.Mensajes;
import videojuego.Videojuego;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Xbox implements Iconsola {
    // Atributos
    private List<String> juegos;

    // Constructor
    public Xbox() {
        juegos = new ArrayList<>();
    }

    // Setter
    public void setJuegos(List<String> juegos) {
        this.juegos = juegos;
    }

    // Cargar info
    private void uploadData() throws IOException {
        GuardarInfo guardarInfo = new GuardarInfo();
        guardarInfo.cargarInfo("instaladosXbox.csv", juegos);
    }

    // Guardar info
    private void saveData() throws IOException {
        GuardarInfo guardarInfo = new GuardarInfo();
        guardarInfo.guardarInfo("instaladosXbox.csv", juegos);
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

    // Overrides -> SwitchOn
    @Override
    public void switchOn() {
        // Lanzar menú consola
        System.out.printf(Mensajes.MNU_CON_INICIO, getPlataform(), getPlataform());

        // Fichero -> List juegos
        try {
            uploadData();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Llamada -> OrderData "Estructurar la información para la salida"
        orderData();
    }

    // Overrides -> SwitchOff
    @Override
    public void switchOff() {
        System.out.printf(Mensajes.MSG_CON_FIN, getPlataform());
    }

    // Ordenar Información
    private void orderData() {
// Inicializar retorno
        String retorno;

        // Inicializar StringBuilder
        StringBuilder stringBuilder = new StringBuilder(String.format("%s", Mensajes.MNU_CON_INSTALADOS));

        // Decisión List juegos Vacio
        if (juegos.isEmpty()) {
            // Mensaje "Biblioteca vacia"
            retorno = stringBuilder + Mensajes.MSG_CON_BIBLIOVACIA;
        } else {
            // Estructurar salida
            int contador = 0;
            for (String j : juegos) {
                stringBuilder.append(j);
                if (contador == 2) {
                    stringBuilder.append("\n");
                } else {
                    stringBuilder.append("\s");
                }
                contador++;
            }
            // String Builder -> Retorno
            retorno = stringBuilder.toString();
        }
        // Salida Retorno
        System.out.println(retorno);
    }

    // Overrides -> Instalar Juegos
    @Override
    public void installVideogame(Videojuego videojuego) throws JuegoNoCompatible, JuegoYaInstalado, IOException {
        // Decisión juego instalado
        if (juegos.contains(videojuego.getTitulo())) {
            throw new JuegoYaInstalado();
        } else {
            // Decisión Plataforma compatible
            if (videojuego.getPlataformaJuego().equals(getClass().getSimpleName())) {
                // Videojuego -> Fichero
                juegos.addAll(Arrays.asList(videojuego.getTitulo(), videojuego.getGenero().toString()));
                saveData();

                // Mensaje juego instalado
                System.out.printf(Mensajes.MNU_CON_INSTALADO, videojuego.getTitulo());

                // Mostrar biblioteca
                orderData();
            } else {
                throw new JuegoNoCompatible(getClass().getSimpleName());
            }
        }
    }

    // Overrides -> Jugar Juegos
    @Override
    public void playVideogame() {
        // Decisión List juegos vacio
        if (!juegos.isEmpty()) {
            // Mensaje "Jugando a..."
            System.out.printf(Mensajes.MSG_CON_JUGANDO, juegos.getFirst());
        } else {
            // Mensaje "No hay juegos"
            System.out.println(Mensajes.MSG_CON_NOJUEGO);
        }
    }

    // Overrides -> Devolver plataforma
    @Override
    public String getPlataform() {
        return getClass().getSimpleName();
    }
}

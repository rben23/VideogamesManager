package console;

import console.fileManager.FileManager;
import exceptions.JuegoNoCompatible;
import exceptions.JuegoYaInstalado;
import resources.Messages;
import videogames.Videogame;
import videogames.enums.GamePlatform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Console implements Iconsole {
    // Atributos
    private GamePlatform platform;
    private List<Videogame> games = new ArrayList<>();

    public Console(GamePlatform plataforma) {
        this.platform = plataforma;
    }

    // Pasamos los datos a FileManager para que los cargue en el Array
    private void uploadData() throws IOException {
        FileManager guardarInfo = new FileManager();
        guardarInfo.cargarInfo(selectFile(), games);
    }

    // Pasamos los datos a FileManager para que los guarde en el CSV
    private void saveData() throws IOException {
        FileManager guardarInfo = new FileManager();
        guardarInfo.saveData(selectFile(), games);
    }

    // Encendemos la consola, mostramos menú y juegos instalados
    @Override
    public void switchOn() {
        // Lanzar menú consola
        System.out.printf(Messages.MNU_CON_POWERON, getPlataform(), getPlataform());

        // Fichero -> List juegos
        try {
            uploadData();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Llamada -> OrderData "Estructurar la información para la salida"
        orderData();
    }

    // Apagamos la consola y mostramos despedida
    @Override
    public void switchOff() {
        System.out.printf(Messages.MSG_CON_END, getPlataform());
    }

    // Ordenamos la información de la biblioteca de juegos
    private void orderData() {
        // Mostramos cabecera
        System.out.println(Messages.MNU_VDG_LIBRARY);

        // Mostrar Lista
        for (Videogame videogame : games) {
            System.out.println(videogame);
        }
    }

    // Verificamos que el juego no esta instalado y es compatible, después lo instalamos
    @Override
    public void installVideogame(Videogame videogame) throws JuegoNoCompatible, JuegoYaInstalado, IOException {
        // Decisión juego instalado
        if (getGames().contains(videogame.getTitulo())) {
            throw new JuegoYaInstalado();
        } else {
            // Decisión Plataforma compatible
            if (getPlataform().equals(videogame.getPlataformaJuego())) {
                // Videojuego -> List Juego
                games.add(videogame);

                // List juego -> Fichero
                saveData();

                // Mensaje juego instalado
                System.out.printf(Messages.MNU_CON_INSTALLED, videogame.getTitulo());

                // Mostrar biblioteca
                orderData();
            } else {
                throw new JuegoNoCompatible(getPlataform());
            }
        }
    }

    // Mostramos mensaje de jugando
    @Override
    public void playVideogame() {
        // Decisión List juegos vacio
        if (!games.isEmpty()) {
            // Mensaje "Jugando a..."
            System.out.printf(Messages.MSG_CON_PLAYING, games.get(0).getTitulo());
        } else {
            // Mensaje "No hay juegos"
            System.out.println(Messages.MSG_CON_NOGAME);
        }
    }

    // Devolvemos la plataforma actual
    @Override
    public String getPlataform() {
        return this.platform.toString();
    }

    @Override
    public String getGames() {
        return this.games.toString();
    }

    // Decisión Dirección de Fichero
    private String selectFile() {
        if (getPlataform().equals(GamePlatform.XBOX.toString())) {
            return "instaladosXbox.csv";
        }

        if (getPlataform().equals(GamePlatform.NINTENDOSWITCH.toString())) {
            return "instaladosNintendo.csv";
        }

        return "instaladosPlaystation.csv";

    }

    // Overrides - Equals && HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return Objects.equals(games, console.games);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(games);
    }
}

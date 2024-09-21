package consola;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

public class ManejarInfo {
    // Guardar en CSV
    public void guardarInfo(String dir, List<String> juego) throws IOException {
        FileWriter fl = new FileWriter(dir);
        int contador = 1;
        for (String j : juego) {
            if (contador % 2 == 0) {
                fl.write(j + "\n");
            } else {
                fl.write(j + "\s");
            }
            contador++;
        }

        fl.close();
    }

    // Cargar desde CSV
    public List<String> cargarInfo(String dir) {
        String[] info = null;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(dir));
            String linea;
            do {
                linea = bf.readLine();
                if (linea != null) {
                    info = linea.split("\n");

                }

            } while (linea != null);

        } catch (FileNotFoundException e) {
            System.out.println("(!) ERROR al cargar el fichero");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Arrays.asList(info);
    }
}
package consola.guardarInfo;

import excepciones.BibliotecaVacia;
import recursos.Mensajes;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuardarInfo {
    // Guardar en CSV
    public void guardarInfo(String dir, List<String> juego) throws IOException {
        FileWriter fl = new FileWriter(dir);
        int contador = 0;
        for (String j : juego) {
            if (contador == 2) {
                fl.write(j + "," + "\n");
            } else {
                fl.write(j + ",");
            }
            contador++;
        }
        fl.close();
    }

    // Cargar desde CSV
    public void cargarInfo(String dir, List<String> juego) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(dir));
            String linea;
            do {
                linea = bf.readLine();

                if (linea != null) {
                    juego.addAll(Arrays.asList(linea.split(",")));
                }
            } while (linea != null);

        } catch (FileNotFoundException e) {
            System.out.println("(!) ERROR al cargar el fichero");
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
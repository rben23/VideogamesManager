package consola.GuardarInfo;

import recursos.Mensajes;
import videojuego.Videojuego;
import videojuego.VideojuegoDigital;
import videojuego.VideojuegoFisico;
import videojuego.enums.GeneroJuego;
import videojuego.enums.PlataformaJuego;
import videojuego.enums.TipoJuego;
import videojuego.enums.TituloJuego;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class GuardarInfo {

    // CONSTANTES - Spearadores
    private final String SEP_FILAS = ".";
    private final String SEP_NORMAL = "-";

    // Guardar en CSV
    public void guardarInfo(String dir, List<Videojuego> juego) throws IOException {
        FileWriter fl = new FileWriter(dir);

        for (Videojuego j : juego) {
            fl.write(j.getTitulo() + SEP_NORMAL + j.getGenero() + SEP_NORMAL +
                    j.getPlataformaJuego() + SEP_NORMAL + j.getPrecio() + j.getTipo() + SEP_FILAS);
        }
        fl.close();
    }

    // Cargar desde CSV
    public void cargarInfo(String dir, List<Videojuego> juego) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(dir));
            String linea;
            do {
                linea = bf.readLine();

                if (linea != null) {
                    String[] pase = linea.split(SEP_FILAS);
                    pase = pase.toString().split(SEP_NORMAL);

                    TituloJuego tituloJuego = TituloJuego.valueOf(pase[0]);
                    GeneroJuego generoJuego = GeneroJuego.valueOf(pase[1]);
                    PlataformaJuego plataforma = PlataformaJuego.valueOf(pase[2]);
                    double precio = Integer.parseInt(pase[3]);
                    TipoJuego tipoJuego = TipoJuego.valueOf(pase[4]);

                    List<GeneroJuego> generos = Arrays.asList(generoJuego);

                    if (tipoJuego.equals(TipoJuego.DIGITAL)) {
                        Videojuego vd = new VideojuegoDigital(tituloJuego, precio, plataforma, generos, tipoJuego);
                        juego.add(vd);
                    } else if (tipoJuego.equals(TipoJuego.FISICO)) {
                        Videojuego vd = new VideojuegoFisico(tituloJuego, precio, plataforma, generos, tipoJuego);
                        juego.add(vd);
                    } else {
                        System.out.printf("ERROR al identificar el juego");
                    }

                }
            } while (linea != null);

        } catch (FileNotFoundException e) {
            System.out.println(Mensajes.MSG_CON_ERRFICHERO);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
import VideoJuego.EnumsJuego;
import VideoJuego.Videojuego;
import VideoJuego.VideojuegoDigital;
import VideoJuego.VideojuegoFisico;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        System.out.println("Titulo                 | Genero                  | Consola                     | Precio");
        System.out.println("-----------------------|-------------------------|-----------------------------|------------");

        // Videojuego Digital
        VideojuegoDigital juegoDigital = new VideojuegoDigital();
        List<EnumsJuego.Genero> generoDigital = Arrays.asList(EnumsJuego.Genero.Shooter, EnumsJuego.Genero.Estrategia);
        List<EnumsJuego.Consola> consolaDigital = Arrays.asList(EnumsJuego.Consola.PlayStation, EnumsJuego.Consola.Xbox);

        juegoDigital.setTitulo(EnumsJuego.Titulo.CallOfDuty);
        juegoDigital.setGenero(generoDigital);
        juegoDigital.setConsola(consolaDigital);
        juegoDigital.setPrecio(68.99);
        System.out.println(juegoDigital.toString());

        // Videojuego Físico
        VideojuegoFisico juegoFisico = new VideojuegoFisico();
        List<EnumsJuego.Genero> generoFisico = Arrays.asList(EnumsJuego.Genero.Acción, EnumsJuego.Genero.Aventura);
        List<EnumsJuego.Consola> consolaFisico = Arrays.asList(EnumsJuego.Consola.NintendoSwitch);

        juegoFisico.setTitulo(EnumsJuego.Titulo.TheLegendOfZelda);
        juegoFisico.setGenero(generoFisico);
        juegoFisico.setConsola(consolaFisico);
        juegoFisico.setPrecio(45.85);
        System.out.println(juegoFisico.toString());
    }
}
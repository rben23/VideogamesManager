import consola.PlayStation;
import consola.Xbox;
import enums.GeneroJuego;
import enums.PlataformaJuego;
import enums.TituloJuego;
import excepciones.JuegoNoCompatible;
import excepciones.JuegoYaInstalado;
import videojuego.VideojuegoDigital;
import videojuego.VideojuegoFisico;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws JuegoYaInstalado, JuegoNoCompatible, IOException {
        // Videojuego Digital
        VideojuegoDigital juegoDigital = new VideojuegoDigital();
        List<GeneroJuego> generoJuegoDigital = Arrays.asList(GeneroJuego.Shooter, GeneroJuego.Estrategia);

        juegoDigital.setTitulo(TituloJuego.CALLOFDUTY);
        juegoDigital.setGenero(generoJuegoDigital);
        juegoDigital.setConsola("Xbox");
        juegoDigital.setPrecio(68.99);


        // Videojuego Físico
        VideojuegoFisico juegoFisico = new VideojuegoFisico();
        List<GeneroJuego> generoJuegoFisico = Arrays.asList(GeneroJuego.Acción, GeneroJuego.Aventura);
        List<PlataformaJuego> plataformaJuegoFisico = Arrays.asList(PlataformaJuego.NintendoSwitch);

        juegoFisico.setTitulo(TituloJuego.THELEGENDOFZELDA);
        juegoFisico.setGenero(generoJuegoFisico);
        juegoFisico.setConsola("Xbox");
        juegoFisico.setPrecio(45.85);

        // Videojuego Físico
        VideojuegoFisico juegoFisico2 = new VideojuegoFisico();
        List<GeneroJuego> generoJuegoFisico2 = Arrays.asList(GeneroJuego.Acción, GeneroJuego.Aventura);
        List<PlataformaJuego> plataformaJuegoFisico2 = Arrays.asList(PlataformaJuego.NintendoSwitch);

        juegoFisico2.setTitulo(TituloJuego.MINECRAFT);
        juegoFisico2.setGenero(generoJuegoFisico);
        juegoFisico2.setConsola("Xbox");
        juegoFisico2.setPrecio(45.85);

        // PlayStation
        Xbox xbox = new Xbox();
//        xbox.installVideogame(juegoDigital);
//        xbox.installVideogame(juegoFisico);
//        xbox.installVideogame(juegoFisico2);
        System.out.print(xbox.toString());
        System.out.println();
        xbox.switchOff();
    }
}
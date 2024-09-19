package Consola;

import java.util.ArrayList;
import java.util.List;

public class PlayStation {
    // Atributos
    private List<EnumsPlataforma.PlayStation> juego;

    public PlayStation() {
        setJuego(new ArrayList<>());
    }

    // Getters y Setters
    public List<EnumsPlataforma.PlayStation> getJuego() {
        return juego;
    }

    public void setJuego(List<EnumsPlataforma.PlayStation> juego) {
        this.juego = juego;
    }

}

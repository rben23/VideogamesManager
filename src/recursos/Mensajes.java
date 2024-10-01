package recursos;

public class Mensajes {
    // Menú Videojuegos
    public static final String MNU_VDJ_VIDEOJUEGOS
            = """
            🎮 VIDEOJUEGOS
            ==========================================================================================================
            Titulo                 | Genero                  | Consola                     | Precio     | Tipo        |
            -----------------------|-------------------------|-----------------------------|------------|-------------|""";

    // Menú Consolas -> Inicio Sistema
    public static final String MNU_CON_INICIO
            = """
            🟢 Iniciando consola %s ...\n
            🕹️ CONSOLA %S
            =====================================================================\n""";

    // Mensaje Consolas -> Fin Sistema
    public static final String MSG_CON_FIN = "🔘 Apagando consola %s ...\n";

    // Mensaje Consolas -> Biblioteca vacia
    public static final String MSG_CON_BIBLIOVACIA = "❗ La Biblioteca vacia";

    // Mensaje Consolas -> Jugando juego
    public static final String MSG_CON_JUGANDO = "🎮 Jugando a %s%n";
    public static final String MSG_CON_NOJUEGO = "❗ Instala un juego para poder jugar";
    public static final String MSG_CON_ERRFICHERO = "❌ ERROR al cargar el fichero";

    // Mensaje Consolas -> Juego instalado
    public static final String MNU_CON_INSTALADO
            = """
            ---
            📥 Descargado %s
            ---\n""";

    // Menú Consolas -> Juegos instalados
    public static final String MNU_CON_INSTALADOS
            = """
            📂 Biblioteca de Juegos
            -----------------------------------------\n""";
}

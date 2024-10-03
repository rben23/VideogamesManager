package resources;

public class Messages {
    // Menú Videojuegos
    public static final String MNU_VDG_LIBRARY
            = """
            🎮 VIDEOJUEGOS
            ==========================================================================================================
            Titulo                 | Genero                  | Consola                     | Precio     | Tipo        |
            -----------------------|-------------------------|-----------------------------|------------|-------------|""";

    // Menú Consolas -> Inicio Sistema
    public static final String MNU_CON_POWERON
            = """
            🟢 Iniciando consola %s ...\n
            🕹️ CONSOLA %S
            =====================================================================\n""";

    // Mensaje Consolas -> Fin Sistema
    public static final String MSG_CON_END = "🔘 Apagando consola %s ...\n";

    // Mensaje Consolas -> Biblioteca vacia
    public static final String MSG_CON_VOIDLIBRARY = "❗ La Biblioteca vacia";

    // Mensaje Consolas -> Jugando juego
    public static final String MSG_CON_PLAYING = "🎮 Jugando a %s%n";
    public static final String MSG_CON_NOGAME = "❗ Instala un juego para poder jugar";
    public static final String MSG_CON_ERRORFILE = "❌ ERROR al cargar el fichero";

    // Mensaje Consolas -> Juego instalado
    public static final String MNU_CON_INSTALLED
            = """
            ---
            📥 Descargado %s
            ---\n""";
}

import java.util.HashMap;
import java.util.Map;

class EditorMemento {
    private final String nombre;
    private final String clase;
    private final int nivel;
    private final int vida;
    private final int mana;
    private final Map<String, Integer> stats;
    private final String buildName;
    private final int puntosDisponibles;

    public EditorMemento(String nombre, String clase, int nivel,
                         int vida, int mana, Map<String, Integer> stats,
                         String buildName, int puntosDisponibles) {
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
        this.vida = vida;
        this.mana = mana;
        this.stats = new HashMap<>(stats);
        this.buildName = buildName;
        this.puntosDisponibles = puntosDisponibles;
    }

    public String getNombre() { return nombre; }
    public String getClase() { return clase; }
    public int getNivel() { return nivel; }
    public int getVida() { return vida; }
    public int getMana() { return mana; }
    public Map<String, Integer> getStats() { return new HashMap<>(stats); }
    public String getBuildName() { return buildName; }
    public int getPuntosDisponibles() { return puntosDisponibles; }
}

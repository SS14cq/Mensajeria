import java.util.HashMap;
import java.util.Map;

// ORIGINADOR
class Editor {
    private String nombre;
    private String clase;
    private int nivel;
    private int vida;
    private int mana;
    private Map<String, Integer> stats;
    private int puntosDisponibles = 10;

    // Nuevo: para manejar la vista previa
    private EditorMemento estadoTemporal;
    private Historial historial; // referencia opcional para manejar deshacer/aplicar

    public Editor(String nombre, String clase) {
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = 1;
        this.vida = 100;
        this.mana = 50;
        this.stats = new HashMap<>();
        stats.put("fuerza", 5);
        stats.put("inteligencia", 5);
        stats.put("agilidad", 5);
    }

    // Vincula el historial para aplicar/descartar cambios
    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public void cambiarClase(String nuevaClase) { this.clase = nuevaClase; }

    public void subirNivel() {
        this.nivel++;
        this.puntosDisponibles += 5;
    }

    public void distribuirPuntos(String estadistica, int cantidad) {
        if (!stats.containsKey(estadistica)) {
            System.out.println("Estadística no válida.");
            return;
        }
        if (cantidad > puntosDisponibles || stats.get(estadistica) + cantidad < 0) {
            System.out.println("Operación inválida. Puntos insuficientes o valor negativo.");
            return;
        }

        stats.put(estadistica, stats.get(estadistica) + cantidad);
        puntosDisponibles -= cantidad;
    }

    public void equiparItem(String item) {
        switch (item) {
            case "Espada" -> stats.put("fuerza", stats.get("fuerza") + 2);
            case "Báculo" -> stats.put("inteligencia", stats.get("inteligencia") + 2);
            case "Botas" -> stats.put("agilidad", stats.get("agilidad") + 2);
            default -> System.out.println("Item desconocido.");
        }
    }

    // MEMENTOS
    public EditorMemento guardar() {
        return new EditorMemento(nombre, clase, nivel, vida, mana, stats, null, puntosDisponibles);
    }

    public EditorMemento guardarBuild(String buildName) {
        return new EditorMemento(nombre, clase, nivel, vida, mana, stats, buildName, puntosDisponibles);
    }

    public void restaurar(EditorMemento m) {
        if (m == null) return;
        this.nombre = m.getNombre();
        this.clase = m.getClase();
        this.nivel = m.getNivel();
        this.vida = m.getVida();
        this.mana = m.getMana();
        this.stats = m.getStats();
        this.puntosDisponibles = m.getPuntosDisponibles();
    }

    // NUEVO: SISTEMA DE PREVIEW
    public void previsualizarCambio(Runnable cambios) {
        System.out.println("\n🔍 --- Entrando en modo preview ---");
        estadoTemporal = guardar(); // guardamos el estado actual por si se cancela
        cambios.run(); // se ejecutan los cambios temporales
        mostrarEstado();
        System.out.println("Vista previa aplicada temporalmente.");
    }

    public void cancelarPreview() {
        if (estadoTemporal != null) {
            restaurar(estadoTemporal);
            estadoTemporal = null;
            System.out.println("❌ Cambios cancelados. Estado restaurado.");
        } else {
            System.out.println("No hay cambios en preview para cancelar.");
        }
    }

    public void aplicarCambios() {
        if (estadoTemporal != null) {
            historial.guardarEstado(guardar());
            estadoTemporal = null;
            System.out.println("✅ Cambios aplicados y guardados en historial.");
        } else {
            System.out.println("No hay cambios en preview para aplicar.");
        }
    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre + " | Clase: " + clase + " | Nivel: " + nivel +
                " | Vida: " + vida + " | Maná: " + mana +
                " | Stats: " + stats + " | PuntosDisponibles: " + puntosDisponibles);
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Historial {
    private final Stack<EditorMemento> historial = new Stack<>();
    private final Map<String, EditorMemento> builds = new HashMap<>();

    public void guardarEstado(EditorMemento memento) {
        historial.push(memento);
    }

    public EditorMemento deshacer() {
        if (!historial.isEmpty())
            return historial.pop();
        return null;
    }

    public void guardarBuild(EditorMemento memento) {
        if (memento.getBuildName() != null)
            builds.put(memento.getBuildName(), memento);
    }

    public EditorMemento getBuild(String buildName) {
        return builds.get(buildName);
    }

    public void mostrarBuilds() {
        System.out.println("Builds guardadas: " + builds.keySet());
    }
}

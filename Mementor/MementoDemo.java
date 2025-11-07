public class MementoDemo {
    public static void main(String[] args) {
        Editor personaje = new Editor("Arin", "Mago");
        Historial historial = new Historial();
        personaje.setHistorial(historial);

        personaje.mostrarEstado();

        // Guardamos el estado inicial
        historial.guardarEstado(personaje.guardar());

        // --- Vista previa de cambios ---
        personaje.previsualizarCambio(() -> {
            personaje.cambiarClase("Guerrero");
            personaje.equiparItem("Espada");
            personaje.distribuirPuntos("fuerza", 3);
        });

        // Si no gustó el cambio
        personaje.cancelarPreview();
        personaje.mostrarEstado();

        // Si se quieren aplicar los cambios
        personaje.previsualizarCambio(() -> {
            personaje.cambiarClase("Arquero");
            personaje.equiparItem("Botas");
            personaje.distribuirPuntos("agilidad", 4);
        });
        personaje.aplicarCambios();

        // Guardamos build
        historial.guardarBuild(personaje.guardarBuild("Build PvP"));
        historial.mostrarBuilds();

        // Probamos restaurar build
        personaje.restaurar(historial.getBuild("Build PvP"));
        personaje.mostrarEstado();
    }
}

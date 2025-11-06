abstract class Editor {
    protected String nombre;
    protected Historial mediator;

    public Editor(String nombre, Historial mediator) {
        this.nombre = nombre;
        this.mediator = mediator;
    }
    public void enviar(String mensaje) {
        mediator.guardarEstado(new EditorMemento(mensaje, nombre), this);
    }
    public abstract void recibir(EditorMemento memento);
}


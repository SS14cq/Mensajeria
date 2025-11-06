class Desarrollador extends Editor {
    public Desarrollador(String nombre, Historial mediator) { super(nombre, mediator); }
    public void recibir(EditorMemento memento) {
        System.out.println("[Dev " + nombre + "] recibió de [" + memento.getRemitente() + "]: " + memento.getMensaje());
    }
}
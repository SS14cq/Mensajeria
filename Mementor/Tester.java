class Tester extends Editor {
    public Tester(String nombre, Historial mediator) { super(nombre, mediator); }
    public void recibir(EditorMemento memento) {
        System.out.println("[Tester " + nombre + "] recibió de [" + memento.getRemitente() + "]: " + memento.getMensaje());
    }
}

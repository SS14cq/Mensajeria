class Gerente extends Editor {
    public Gerente(String nombre, Historial mediator) { super(nombre, mediator); }
    public void recibir(EditorMemento memento) {
        System.out.println("[Gerente " + nombre + "] recibió de [" + memento.getRemitente() + "]: " + memento.getMensaje());
    }
}

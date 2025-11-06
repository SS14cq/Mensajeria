class Historial {
    private Desarrollador dev;
    private Tester tester;
    private Gerente gerente;

    public void registrar(Desarrollador d, Tester t, Gerente g) {
        dev = d; tester = t; gerente = g;
    }

    public void guardarEstado(EditorMemento memento, Editor remitente) {
        if (remitente instanceof Desarrollador) {
            System.out.println("[PM] — Mensaje para Tester");
            tester.recibir(memento);
        } else if (remitente instanceof Tester) {
            System.out.println("[PM] — Mensaje para Dev");
            dev.recibir(memento);
        } else if (remitente instanceof Gerente) {
            System.out.println("[PM] — Mensaje a todos");
            dev.recibir(memento);
            tester.recibir(memento);
            gerente.recibir(memento);
        }
    }
}
